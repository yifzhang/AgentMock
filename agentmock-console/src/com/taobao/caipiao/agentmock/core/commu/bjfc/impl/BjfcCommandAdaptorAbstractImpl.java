package com.taobao.caipiao.agentmock.core.commu.bjfc.impl;


import javax.xml.xpath.XPathFactory;

import com.taobao.caipiao.agentmock.core.AgentCommConfig;
import com.taobao.caipiao.agentmock.core.commu.bjfc.BjfcCommandAdaptor;

/**
 * @author youshan
 */
public abstract class BjfcCommandAdaptorAbstractImpl implements BjfcCommandAdaptor{

	protected String inputFile;
	protected XPathFactory factory = XPathFactory.newInstance();
	protected AgentCommConfig config;
	
	public void setXmlMsg(String xml) {
		this.inputFile = xml;
	}
	
	public void setAgentCommConfig(AgentCommConfig config){
		this.config = config;
	}

}

