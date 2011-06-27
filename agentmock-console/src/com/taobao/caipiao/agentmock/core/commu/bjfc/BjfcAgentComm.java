package com.taobao.caipiao.agentmock.core.commu.bjfc;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.alibaba.common.lang.StringUtil;
import com.taobao.caipiao.agentmock.core.AgentCommConfig;
import com.taobao.caipiao.agentmock.core.commu.AgentComm;
import com.taobao.caipiao.agentmock.core.commu.bjfc.util.BjfcCommandEnum;
import com.taobao.caipiao.agentmock.core.commu.bjfc.util.BjfcStatusEnum;
import com.taobao.caipiao.agentmock.core.commu.bjfc.util.BjfcUtil;
import com.taobao.caipiao.agentmock.core.commu.bjfc.util.Bjfczlip;
import com.taobao.caipiao.agentmock.core.commu.hengpeng.HengPengCommandAdaptor;
import com.taobao.caipiao.agentmock.core.commu.hengpeng.HengPengCommandAdaptorFactory;
import com.taobao.caipiao.agentmock.core.commu.hengpeng.util.CalendarUtil;
import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;
import com.taobao.caipiao.agentmock.util.Fserver;

/**
 * @author youshan
 */
public class BjfcAgentComm implements AgentComm {

	private AgentCommConfig agentCommConfig;
	private static final Logger log = LoggerFactory.getLogger(BjfcAgentComm.class);
	private static final String CONTENT_TYPE= "text/html; charset=utf-8";
	private XPathFactory factory = XPathFactory.newInstance();
	private static final String XML_HEAD="<?xml version=\"1.0\" encoding=\"utf-8\"?>";
	
	@Override
	public void init(AgentCommConfig agentConfig) {
		agentCommConfig = agentConfig;
		String ftpUrlport[] = agentCommConfig.getFtpUrlPort();
		if (ftpUrlport != null){
			//Start the ftp server!
			int port = 21;
			try{
				port = Integer.parseInt(ftpUrlport[1]);
			}catch(Exception e){
				port = 21;
			}
			Fserver ftpServer = new Fserver(port);
			ftpServer.start();
		}
	}

	@Override
	public void processAgentMockAction(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		InputStream in = req.getInputStream();
		ByteArrayOutputStream out = null;
		String paramStr = null;
		try{
			out = new ByteArrayOutputStream();
			byte[] bytes= new byte[1024];
			int count = -1;
			while((count = in.read(bytes)) != -1){
				out.write(bytes,0,count);
			}
			byte[] b = out.toByteArray();
			paramStr = new String(b,"utf-8");
			log.warn("Receive request from Keno: "+paramStr);
			if(StringUtil.isBlank(paramStr)){
				log.error("Request from keno is illegal: "+paramStr);
				resp.getWriter().println("请求内容为空！");
				return;
			}
		}catch(Exception e){}
		finally{
			in.close();
			if(out != null)
				out.close();
		}
		
		//Get the required message!
		Map<String,String> paramResult = getProcessMsg(paramStr);
		String status = paramResult.get("status");
		String bodyMsg= paramResult.get("messageBody");
		String tranType = paramResult.get("tranType");
		String messageId = paramResult.get("messageId");
		int tranNum = -1;
		
		if(status.equals(BjfcStatusEnum.OPERATION_SUCCESS_CODE.getCode())){
			//first check the configuration success or not
			String resultCode = agentCommConfig.getAgent().getGetTicketResult().getResultCode();
			//configuration should be "00"
			if(resultCode.equals(BjfcStatusEnum.OPERATION_SUCCESS_CODE.getCode())){
				//should handle the command here
				BjfcCommandAdaptor executeCommand = null;
				tranNum = -1;
				try{
					tranNum = Integer.parseInt(tranType);
				}catch(Exception e){
					tranNum = -1;
					log.error("tranType error for:"+e.getMessage());
				}
				if (tranNum == BjfcCommandAdaptorFactory.BOOK_TICKETS){
					executeCommand = BjfcCommandAdaptorFactory
					.getAdaptor(BjfcCommandAdaptorFactory.BOOK_TICKETS);
				}else if(tranNum == BjfcCommandAdaptorFactory.GET_ISSUE){
					executeCommand = BjfcCommandAdaptorFactory
					.getAdaptor(BjfcCommandAdaptorFactory.GET_ISSUE);
				}else if(tranNum == BjfcCommandAdaptorFactory.GET_LUCKY_NUM){
					executeCommand = BjfcCommandAdaptorFactory
					.getAdaptor(BjfcCommandAdaptorFactory.GET_LUCKY_NUM);
				}
				
				if(executeCommand != null){
					executeCommand.setXmlMsg(bodyMsg);
					executeCommand.setAgentCommConfig(agentCommConfig);
					if(executeCommand.doCommCommand()){
						bodyMsg = executeCommand.getResponseMsg();
					}
				}
			}
		}
		
		if(tranNum == -1){
			StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			sb.append("<body><result>");
			sb.append(status);
			sb.append("</result></body>");	
			bodyMsg = sb.toString();
		}
		
		String responseXml = createResponseXml(tranType,bodyMsg, messageId, 
				status, agentCommConfig.getAgent().getDigestKey());
		
		PrintWriter pw = resp.getWriter();
		pw.println(responseXml);
		pw.close();
	}

	@Override
	public void renderAgentMockResult(HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws Exception {

	}

	private String createResponseXml(
			String tranType, String requestXmlBody,
			String messageIdStr, String bjfcStatus, String digestKey) {
		StringBuilder sb = new StringBuilder(XML_HEAD);
		String body= BjfcUtil.packBody(requestXmlBody, digestKey);
		String md=BjfcUtil.MD5(body);
		String messageId = messageIdStr;
		
		String timeStr = null;
		sb.append("<message>");
		sb.append("<head>");
		sb.append("<messageId>").append(messageId).append("</messageId>");
		sb.append("<command>").append(tranType).append("</command>");				
		sb.append("<encrypt>").append("1").append("</encrypt>");//会加密
		sb.append("<compress>").append("0").append("</compress>");//未压缩
		timeStr = CalendarUtil.toString(new Date(), "yyyyMMddHHmmss");
		sb.append("<timestamp>").append(timeStr).append("</timestamp>");
		sb.append("<result>").append(bjfcStatus).append("</result>");
		sb.append("<md>");
		sb.append(md.toLowerCase());
		sb.append("</md>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append(body);
		sb.append("</body>");		
		StringBuilder headSb = new StringBuilder(tranType);		
		//headSb.append(timeStr).append(agentManager.getMd5Key());
		headSb.append(timeStr).append(digestKey);
		String headMd = BjfcUtil.MD5(headSb.toString());		
		sb.append("<md>").append(headMd.toLowerCase()).append("</md>");
		sb.append("</message>");	
		return sb.toString();
	}
	
	private Map<String,String> getProcessMsg(String param){
		Map<String,String> result = new HashMap<String,String>();
		
		try{
			String messageIdStr = null;
			String commandName = null;
			String compressStr = null;
			String mdStr = null;
			String bodyStr = null;
			
			Node body = (Node)factory.newXPath().evaluate("/message/body" , 
					new InputSource(new StringReader(param)) , XPathConstants.NODE);
			Node md = (Node)factory.newXPath().evaluate("/message/head/md" ,
					new InputSource(new StringReader(param)) , XPathConstants.NODE);
			Node messageId=(Node)factory.newXPath().evaluate("/message/head/messageId" , 
					new InputSource(new StringReader(param)) , XPathConstants.NODE);
			Node compressNode=(Node)factory.newXPath().evaluate("/message/head/compress" , 
					new InputSource(new StringReader(param)) , XPathConstants.NODE);
			Node command=(Node)factory.newXPath().evaluate("/message/head/command" , 
					new InputSource(new StringReader(param)) , XPathConstants.NODE);
			
			messageIdStr = messageId.getTextContent();
			result.put("messageId", messageIdStr);
			commandName = command.getTextContent();
			result.put("tranType", commandName);
			
			if(body == null || body.getChildNodes() == null || body.getChildNodes().getLength() == 0){
				result.put("status", BjfcStatusEnum.FEEDBACKFAIL.getCode());
				return result;
			}
			bodyStr=body.getTextContent();
			mdStr=md.getTextContent();
			compressStr = compressNode.getTextContent();

			if(!BjfcUtil.validBody(mdStr, bodyStr)){
				log.error("the digest is illegal! -->"+param);
				result.put("status", BjfcStatusEnum.FEEDBACKFAIL.getCode());
				return result;
			}
			
			String unecodeRequestBodyXml = "";
			
			if(compressStr.equals("1")){
				byte[] unPackBytes = BjfcUtil.unpackBodyToXMLByte(bodyStr, agentCommConfig.getAgent().getDigestKey());
				unecodeRequestBodyXml= Bjfczlip.decode(unPackBytes);
			}else{
				unecodeRequestBodyXml = BjfcUtil.unpackBodyToXML(bodyStr, agentCommConfig.getAgent().getDigestKey());
			}
			
			log.debug("notify from Bjfc is  legal!" + unecodeRequestBodyXml);			
			result.put("status", BjfcStatusEnum.FEEDBACK_SUCCESS.getCode());
			result.put("messageBody",unecodeRequestBodyXml);
			
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return result;
	}

	@Override
	public void setLuckyNum(String issue, String luckyNum) {
		
	}
	
}

