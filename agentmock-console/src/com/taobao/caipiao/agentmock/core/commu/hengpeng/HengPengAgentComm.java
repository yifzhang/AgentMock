package com.taobao.caipiao.agentmock.core.commu.hengpeng;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.common.lang.StringUtil;
import com.taobao.caipiao.agentmock.core.AgentCommConfig;
import com.taobao.caipiao.agentmock.core.commu.AgentComm;
import com.taobao.caipiao.agentmock.generate.agent.config.Issue;
import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;
import com.taobao.caipiao.agentmock.util.Fserver;

/**
 * @author youshan
 */
public class HengPengAgentComm implements AgentComm{

	private AgentCommConfig agentCommConfig; 
	private static final Logger log = LoggerFactory.getLogger(HengPengAgentComm.class);
	private static final String CONTENT_TYPE = "text/html; charset=GBK";
	/**
	 * request & response mapping code!
	 */
	private static Map<String, String> ResponsMap = new HashMap<String, String>();
	
	static {
		ResponsMap.put("102", "502");	//GetIssue,GetLuckyNumber
		ResponsMap.put("103", "503");	//BookTickets
		ResponsMap.put("105", "505");	//QueryTickets
		ResponsMap.put("106", "506");	//GetAwardTickets
		
	}
	
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
		InputStream in =  null;
		ByteArrayOutputStream out = null;
		String transType= null;
		String xmlMsg = null;
		
		String contentType = req.getContentType();
		if(contentType != null && contentType.contains("zip")){
			try{
				in = req.getInputStream();
				out = new ByteArrayOutputStream();
				byte[] bytes = new byte[1024];
				int count = -1;
				while((count = in.read(bytes)) != -1){
					out.write(bytes,0,count);
				}
				byte[] b = out.toByteArray();
				String paramString = new String(b,"GBK");
				log.warn("Receive request from Keno: "+paramString);
				if(StringUtil.isBlank(paramString)){
					log.error("Request from keno is illegal: "+paramString);
					resp.getWriter().println("请求内容为空！");
					return;
				}
				transType = getParameter(paramString, "transType");
				xmlMsg = getParameter(paramString, "transMessage");
			}catch (Exception e){}
			finally{
				in.close();
				if(out != null){
					out.close();
				}
			}
			
		}else{
			transType = req.getParameter("transType");
			xmlMsg = req.getParameter("transMessage");
		}
		
		boolean success = false;
		
		if(StringUtil.isEmpty(xmlMsg) || transType == null){
			success = false;
		}else{
			//process action!
			int transTypeCode = Integer.parseInt(transType);
			HengPengCommandAdaptor executeCommand = null; 
			if (transTypeCode == HengPengCommandAdaptorFactory.BOOK_TICKETS){
				executeCommand = HengPengCommandAdaptorFactory
				.getAdaptor(HengPengCommandAdaptorFactory.BOOK_TICKETS);
			}else if(transTypeCode == HengPengCommandAdaptorFactory.GET_ISSUE){
				//Should identify the get issue or get lucky number!
				executeCommand = HengPengCommandAdaptorFactory
				.getAdaptor(HengPengCommandAdaptorFactory.GET_ISSUE);
			}else if(transTypeCode == HengPengCommandAdaptorFactory.QUERY_TICKETS){
				executeCommand = HengPengCommandAdaptorFactory
				.getAdaptor(HengPengCommandAdaptorFactory.QUERY_TICKETS);
			}else if(transTypeCode == HengPengCommandAdaptorFactory.GET_AWARD_TICKETS){
				executeCommand = HengPengCommandAdaptorFactory
				.getAdaptor(HengPengCommandAdaptorFactory.GET_AWARD_TICKETS);
			}
			
			if(executeCommand != null){
				executeCommand.setXmlMsg(xmlMsg);
				executeCommand.setAgentCommConfig(agentCommConfig);
				if(executeCommand.doCommCommand()){
					resp.setContentType(CONTENT_TYPE);
					PrintWriter pw = resp.getWriter();
					String res = "transType=" + ResponsMap.get(transType) + "&transMessage="
						+ executeCommand.getResponseMsg();
					pw.println(res);
					pw.close();
					success = true;
					return;
				}
			}
		}
		
		if(!success){
			resp.setContentType(CONTENT_TYPE);
			resp.getWriter().println("请求参数错误,或配置错误。 transType{" + transType + "}, transMessage{" + xmlMsg + "}...");
			return ;
		}
		 
	}

	@Override
	public void renderAgentMockResult(HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws Exception {
		
	}
	
	

	/**
	 * Get required parameter value from the url
	 * @param source Request or Response String
	 * @param parameter name
	 * @return parameter value
	 */
	public static String getParameter(String source, String parameter)
	{
		String paramValue = null;
		String[] keyvalus = source.split("&");
		for (int i = 0; i < keyvalus.length; i++)
		{
			String string = keyvalus[i];
			int index = string.indexOf("=");
			if (index > 0)
			{
				String key = string.substring(0, index);
				if (key.equalsIgnoreCase(parameter))
				{
					paramValue = string.substring(index + 1, string.length());
					break;
				}
			}
		}
		return paramValue;
	}
	
	@Override
	public void setLuckyNum(String issue, String luckyNum) {
		if(agentCommConfig != null){
			int i = 0;
			int len = agentCommConfig.getAgent().getIssues().getIssue().length;
			for(;i < len; i++){
				//Verify if it's the desired issue!
				Issue iss = agentCommConfig.getAgent().getIssues().getIssue(i);
				if(issue.trim().equalsIgnoreCase(iss.getIssueNumber())){
					iss.setBonusCode(luckyNum);  
					iss.setStatus("5");
					break;
				}
			}
			if (i >= len ){
				log.error("In setLuckyNum: maybe set the wrong issue number,pls check the configure file!\n " +
						"The issue set is:"+issue);
			}
		}
	}
	
}

