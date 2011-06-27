package com.taobao.caipiao.agentmock.core.commu.hengpeng.impl;

import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.InputSource;

import com.taobao.caipiao.agentmock.core.commu.hengpeng.CQFCStatusEnum;
import com.taobao.caipiao.agentmock.generate.agent.config.Issue;
import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;


/**
 * @author youshan
 */
public class HengPengCommandAdaptorGetIssueImpl extends HengPengCommandAdaptorAbstractImpl{
	private static final Logger log = LoggerFactory.getLogger(HengPengCommandAdaptorGetIssueImpl.class);
	private static final String transActionResponseType = "502";
	private StringBuffer _bodyXmlBuff = new StringBuffer();
	@Override
	public boolean doCommCommand() {
		try {
			String issueName = factory.newXPath().evaluate("/message/body/issueQuery/issue/@number",
					new InputSource(new StringReader(inputFile)));
			if(issueName == null || issueName.equals("")){
				//It's get issue command!
				_bodyXmlBuff.append("<body><response code=\"").append(CQFCStatusEnum.CALL_SUCCESS_CODE.getCode())
				.append("\" message=\"成功,系统处理正常\">");
				for(int i =0 ; i < config.getAgent().getIssues().getIssue().length; i++){
					Issue issue = config.getAgent().getIssues().getIssue(i);
					_bodyXmlBuff.append("<issue gameName=\"" + issue.getIssueType()+ "\"")
								.append(" number=\"" +issue.getIssueNumber() + "\"")
								.append(" startTime=\"" + issue.getStartTime()+"\"")
								.append(" stopTime=\"" + issue.getEndTime() +"\"")
								.append(" status = \"").append(issue.getStatus()).append("\"")
								.append(" bonusCode=\"\" />");
				}
				_bodyXmlBuff.append("</response></body>");
			}else{
				//It's get lucky number command!
				boolean flag = false;
				StringBuffer tmpSb = new StringBuffer();
				for(int i = 0;i < config.getAgent().getIssues().getIssue().length; i++){
					//Verify if it's the desired issue!
					Issue issue = config.getAgent().getIssues().getIssue(i);
					if(issueName.trim().equalsIgnoreCase(issue.getIssueNumber())){
						if(issue.getStartTime() != null && issue.getStartTime().trim().equals("")){
							Date date = new Date();
							DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

							issue.setStartTime(dateFormater.format(date));
						}
						if(issue.getEndTime() != null && issue.getEndTime().trim().equals("")){
							Date date = new Date();
							DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

							issue.setEndTime(dateFormater.format(date));
						}
						tmpSb.append("<issue gameName=\"" + issue.getIssueType()+ "\"")
								.append(" number=\"" +issueName + "\"")
								.append(" startTime=\"" + issue.getStartTime()+"\"")
								.append(" stopTime=\"" + issue.getEndTime() +"\"")
								.append(" status = \"5\"")
								.append(" bonusCode=\""+issue.getBonusCode()+"\"")
								.append(" />");
						flag = true;
						break;
					}
				}
				if(flag){
					_bodyXmlBuff.append("<body><response code=\"").append(CQFCStatusEnum.CALL_SUCCESS_CODE.getCode())
					.append("\" message=\"成功,系统处理正常\">");
					_bodyXmlBuff.append(tmpSb);
				}else{
					_bodyXmlBuff.append("<body><response code=\"").append(CQFCStatusEnum.CALL_FAILE_CODE.getCode())
					.append("\" message=\"没有对应的彩期\">");
					
				}
				_bodyXmlBuff.append("</response></body>");
			}
			return true;
		} catch (XPathExpressionException e) {
			log.error("parse xml failed: "+ inputFile);
			log.error("error info:"+e.getStackTrace().toString());
			return false;
		}
		
	}

	@Override
	public String getResponseMsg() {
		String bodyStr = _bodyXmlBuff.toString();
		com.taobao.caipiao.agentmock.generate.agent.config.Agent agent = 
			config.getAgent();
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

