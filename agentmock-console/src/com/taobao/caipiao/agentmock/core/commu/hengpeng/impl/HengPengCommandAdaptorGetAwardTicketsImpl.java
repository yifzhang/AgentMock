package com.taobao.caipiao.agentmock.core.commu.hengpeng.impl;

import java.io.StringReader;

import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.InputSource;

import com.taobao.caipiao.agentmock.core.commu.hengpeng.CQFCStatusEnum;
import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;


/**
 * @author youshan
 */
public class HengPengCommandAdaptorGetAwardTicketsImpl extends HengPengCommandAdaptorAbstractImpl{

	private static final Logger log = LoggerFactory.getLogger(HengPengCommandAdaptorGetAwardTicketsImpl.class);
	private static final String transActionResponseType = "506";
	private StringBuffer _bodyXmlBuff = new StringBuffer();
	private com.taobao.caipiao.agentmock.generate.agent.config.Agent agent = null;
	
	@Override
	public boolean doCommCommand() {
		agent = config.getAgent();
		String requestIssue = null;
		String requestGameName = null;
		try {
			requestIssue = (String)factory.newXPath().evaluate("/message/body/bonusQuery/issue/@number",
					new InputSource(new StringReader(inputFile)));
			requestGameName = (String)factory.newXPath().evaluate("/message/body/bonusQuery/issue/@gameName",
					new InputSource(new StringReader(inputFile)));
			
		} catch (XPathExpressionException e) {
			log.error("parse xml failed: "+ inputFile);
			log.error("error info:"+e.getStackTrace().toString());
			return false;
		}
		
		com.taobao.caipiao.agentmock.generate.agent.config.IssueAward[] issueAwards = 
			agent.getGetAwardTickets().getIssueAward();
		String issueNumStr=null;
		String issueType = null;
		boolean flag = false;
		int issueCount = -1;
		for(int i = 0 ;i < issueAwards.length;i++){
			issueNumStr = issueAwards[i].getIssueNumber();
			issueType = issueAwards[i].getIssueType();
			if(issueNumStr != null && issueNumStr.trim().equals(requestIssue) &&
					issueType != null && issueType.trim().equals(requestGameName)){
				//find the corresponding issue!
				flag = true;
				issueCount = i;
				break;
			}
		}
		if(!flag)
			return false;
		com.taobao.caipiao.agentmock.generate.agent.config.Tickets awardTickets = 
			issueAwards[issueCount].getTickets();
		
		_bodyXmlBuff.append("<body><response code=\"").append(CQFCStatusEnum.CALL_SUCCESS_CODE.getCode()).append("\"")
		.append(" message=\"成功，系统正常处理\" >")
		.append("<bonusQueryResult bonusNumber=\"\" totalMoney=\"\" totalItems=\"")
		.append(awardTickets.getTicketCount()).append("\"> ")
		.append("<issue number=\"").append(requestIssue).append("\" gameName=\"")
		.append(requestGameName).append("\" />");
		
		String isBigBonus = null;
		for(int i = 0 ; i < awardTickets.getTicketCount();i++){
			com.taobao.caipiao.agentmock.generate.agent.config.Ticket award = 
				awardTickets.getTicket(i);
			isBigBonus = "false";
			String awardMoneyAndStake[] = null;
			if(award.getAwardMoney().contains("*")){
				awardMoneyAndStake = award.getAwardMoney().split("*");
			}else{
				awardMoneyAndStake = new String[2];
				awardMoneyAndStake[0] = award.getAwardMoney();
				awardMoneyAndStake[1] = "1";
			}
			
			if(award.getAwardType() != null && !award.getAwardType().equals("") 
					&& !award.getAwardType().equals("0"))
				isBigBonus = "true";
			_bodyXmlBuff.append("<bonusItem playType=\"\" money=\"")
			.append(awardMoneyAndStake[0]).append("\" isBombBonus=\"").append(isBigBonus).append("\"")
			.append(" levelBonusMoney=\"").append(awardMoneyAndStake[0]).append("\" bonusLevel=\"\" ")
			.append(" ticketID=\"")
			.append(TaobaoAgentIdSSQ)//Taobao agent id defined by Hengpeng
			.append("00009527")//placeholder
			.append(award.getTicketNo()).append("\"")
			.append(" size=\"").append(awardMoneyAndStake[1]).append("\" />");
		}
		
		_bodyXmlBuff.append("</bonusQueryResult></response></body>");
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
		sb.append(_bodyXmlBuff);//Add body
		sb.append("</message>");
		_bodyXmlBuff = null;
		return sb.toString();
	}

}

