package com.taobao.caipiao.agentmock.core.commu.hengpeng.impl;

import java.io.StringReader;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.taobao.caipiao.agentmock.core.commu.hengpeng.CQFCStatusEnum;
import com.taobao.caipiao.agentmock.generate.agent.config.Issue;
import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;


/**
 * @author youshan
 */
public class HengPengCommandAdaptorBookTicketsImpl extends HengPengCommandAdaptorAbstractImpl{

	private static final Logger log = LoggerFactory.getLogger(HengPengCommandAdaptorBookTicketsImpl.class);
	private static final String transActionResponseType = "503";
	private StringBuffer _bodyXmlBuff = new StringBuffer();
	private com.taobao.caipiao.agentmock.generate.agent.config.Agent agent = null;
	
	@Override
	public boolean doCommCommand() {
		try {
			agent = config.getAgent();
			
			//Don't mind of the input items,just give the book success or failure feedback 
			//based on the configuration!
			_bodyXmlBuff.append("<body><response code=");
			
			String resultCode = agent.getGetTicketResult().getResultCode();
			String resultMsg = null;
			
			if(resultCode != null )
				resultCode = resultCode.trim();
			else
				resultCode = CQFCStatusEnum.CALL_SUCCESS_CODE.getCode();//Default is success!
			
			for(CQFCStatusEnum se:CQFCStatusEnum.values()){
				if(se.getCode().equals(resultCode)){
					resultMsg = se.getDesc();
					break;
				}
			}
			if(resultMsg == null)
				resultMsg = "成功,系统处理正常";//Default is success msg!
			
			_bodyXmlBuff.append("\"").append(resultCode)
				.append("\" message=\"").append(resultMsg).append("\" /></body>");
			
			//Save and cache the ticket nubmer!
			StringBuilder ticketSb = new StringBuilder();
			String keyTicketStr = null;
			NodeList ticketNodelist = (NodeList) factory.newXPath().evaluate("/message/body/lotteryRequest/ticket",
					new InputSource(new StringReader(inputFile)),XPathConstants.NODESET);
			int nodeListLen = ticketNodelist.getLength();
			boolean flag = false;
			for(int i = 0; i < nodeListLen; i++){
				NamedNodeMap ticketAttr = ticketNodelist.item(i).getAttributes();
				//Get ticket id!
				String ticketId = ticketAttr.getNamedItem("id").getNodeValue();
				//Save the ticket id to key!
				if(!flag){
					keyTicketStr = ticketId;
					flag = true;
				}
				ticketSb.append(ticketId);
				if(i < nodeListLen -1)
					ticketSb.append(",");
			}
			String ticketStr = ticketSb.toString();
			ticketSb = null;
			ticketNumberMap.put(keyTicketStr, ticketStr);
			
			return true;
		} catch (XPathExpressionException e) {
			log.error("parse xml failed: "+ inputFile);
			log.error("error info:"+e.getStackTrace().toString());
		}
		
		return false;
	}

	@Override
	public String getResponseMsg() {
		String bodyStr = _bodyXmlBuff.toString();
		String digestKey = agent.getDigestKey();
		StringBuilder sb = createRequestXmlHead(
				transActionResponseType,
				bodyStr,
				TaobaoAgentIdSSQ,
				digestKey
				);
		sb.append(_bodyXmlBuff);
		sb.append("</message>");
		_bodyXmlBuff = null;
		return sb.toString();
	}
}

