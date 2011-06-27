package com.taobao.caipiao.agentmock.core.commu.bjfc.impl;

import java.io.StringReader;

import org.xml.sax.InputSource;

import com.taobao.caipiao.agentmock.generate.agent.config.Issue;
import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;

/**
 * @author youshan
 */
public class BjfcCommandAdaptorGetIssueImpl extends BjfcCommandAdaptorAbstractImpl{

	private static final Logger log = LoggerFactory.getLogger(BjfcCommandAdaptorGetIssueImpl.class);
	private StringBuffer _bodyXmlBuff = new StringBuffer();
	private com.taobao.caipiao.agentmock.generate.agent.config.Agent agent = null;
	
	@Override
	public boolean doCommCommand() {
		try{
			_bodyXmlBuff.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			_bodyXmlBuff.append("<body><ltype>1</ltype>");
			String issueNum = factory.newXPath().evaluate("/body/periodnum", 
					new InputSource(new StringReader(inputFile)));
			boolean flag = false;
			for(int i = 0;i < config.getAgent().getIssues().getIssue().length; i++){
				//Verify if it's the desired issue!
				Issue issue = config.getAgent().getIssues().getIssue(i);
				if(issueNum.trim().equalsIgnoreCase(issue.getIssueNumber())){
					_bodyXmlBuff.append("<periodnum>" + issue.getIssueType())
							.append("</periodnum>")
							.append("<begintime>").append(issue.getStartTime()).append("</begintime>")
							.append("<endtime>").append(issue.getEndTime()).append("</endtime>")
							.append("<startsaletime>").append(issue.getStartTime()).append("</startsaletime>")
							.append("<endsaletime>").append(issue.getEndTime()).append("</endsaletime>")
							.append("<status>").append(issue.getStatus()).append("</status>");
					flag = true;
					break;
				}
			}
			if(!flag){
				log.error("The required issue is not configured!");
				_bodyXmlBuff.append("<periodnum>").append(issueNum).append("</periodnum>")
				.append("<begintime></begintime>")
				.append("<endtime></endtime>")
				.append("<startsaletime></startsaletime>")
				.append("<endsaletime></endsaletime>")
				.append("<status></status>");
			}
			_bodyXmlBuff.append("</body>");
			return true;
		}catch(Exception e){
			log.error("parse xml failed: "+ inputFile);
			log.error("error info:"+e.getStackTrace().toString());
			return false;
		}
		
	}

	@Override
	public String getResponseMsg() {
		return _bodyXmlBuff.toString();
	}

}

