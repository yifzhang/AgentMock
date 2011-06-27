package com.taobao.caipiao.agentmock.core.commu.hengpeng.impl;

import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.taobao.caipiao.agentmock.core.commu.hengpeng.CQFCStatusEnum;
import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;

/**
 * @author youshan
 */
public class HengPengCommandAdaptorQueryTicketsImpl extends HengPengCommandAdaptorAbstractImpl{

	private static final Logger log = LoggerFactory.getLogger(HengPengCommandAdaptorQueryTicketsImpl.class);
	private static final String transActionResponseType = "505";
	private StringBuffer _bodyXmlBuff = new StringBuffer();
	private com.taobao.caipiao.agentmock.generate.agent.config.Agent agent = null;
	private final String successTicketMsgPrefix="dealTime=\"\" money=\"\" playType=\"\" amount=\"\" " +
			"status=\"0000\" message=\"成功，系统处理正常。\"";
	private final String successTicketMsgPostfix="<issue gameName=\"gameName\" number=\"number\"/> " +
			"<userProfile cardType=\"\" cardNumber=\"\" userName=\"AgentMock\" mail=\"\" />"+
			"<anteCode>1,2,3,4,5</anteCode>";
	
	@Override
	public boolean doCommCommand() {
		agent = config.getAgent();
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
		
		if(resultCode.equals(CQFCStatusEnum.CALL_SUCCESS_CODE.getCode())){
			_bodyXmlBuff.append("\"").append(resultCode)
			.append("\" message=\"").append(resultMsg).append("\" >");
			
			//append the ticketQueryResult content!
			_bodyXmlBuff.append("<ticketQueryResult>");
			NodeList ticketNodelist = null;
			
			try {
				ticketNodelist = (NodeList) factory.newXPath().evaluate("/message/body/ticketQuery/ticket",
						new InputSource(new StringReader(inputFile)),XPathConstants.NODESET);
				//Get the first ticket number for key!
				String keyTicketStr = ticketNodelist.item(0).getAttributes().getNamedItem("id").getNodeValue();
				String ticketsStr = ticketNumberMap.get(keyTicketStr);
				if(ticketsStr != null){
					String tickets[] = ticketsStr.split(",");
					int len = tickets.length;
					String timeStr=null;
					for(int i = 0; i < len ; i++){
						Date date = new Date();
						DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");
						timeStr = dateFormat.format(date);

						_bodyXmlBuff.append("<ticket id=\"").append(tickets[i]).append("\" ")
						.append(successTicketMsgPrefix)
						.append(" ticketSerialNo=\"")
						.append("AgentMock_TicketSerialNumber_").append(timeStr).append("\"> ")
						.append(successTicketMsgPostfix)
						.append("</ticket>");
					}
					//Remove this entry for save memory!
					ticketNumberMap.remove(keyTicketStr);
				}else{
					log.error("The bookTickets and queryTickets is not match!");
				}
				
			} catch (XPathExpressionException e) {
				log.error("parse xml failed: "+ inputFile);
				log.error("error info:"+e.getStackTrace().toString());
			}
			
			_bodyXmlBuff.append("</ticketQueryResult>");
		}else{
			resultCode = "9999";
			resultMsg = "Not AgentMock Support Tickets!";
			_bodyXmlBuff.append("\"").append(resultCode)
			.append("\" message=\"").append(resultMsg).append("\" >");
			
		}
	
		_bodyXmlBuff.append("</response></body>");
		return true;
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

