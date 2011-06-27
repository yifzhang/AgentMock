package com.taobao.caipiao.agentmock.core.commu.xgjx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.xpath.XPathFactory;

import com.taobao.caipiao.agentmock.core.AgentCommConfig;
import com.taobao.caipiao.agentmock.core.commu.AgentComm;
import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;
import com.taobao.caipiao.agentmock.util.Fserver;

/**
 * @author youshan
 */
public class XgjxAgentComm implements AgentComm{

	private AgentCommConfig agentCommConfig;
	private static final Logger log = LoggerFactory.getLogger(XgjxAgentComm.class);
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
	public void processAgentMockAction(HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderAgentMockResult(HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLuckyNum(String issue, String luckyNum) {
		
	}

}

