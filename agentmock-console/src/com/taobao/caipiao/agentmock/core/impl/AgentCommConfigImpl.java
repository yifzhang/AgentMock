package com.taobao.caipiao.agentmock.core.impl;

import com.taobao.caipiao.agentmock.core.AgentCommConfig;
import com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent;

public class AgentCommConfigImpl implements AgentCommConfig {
	private javax.servlet.ServletConfig servletConfig;
	private LotteryAgent agentDefinition;
	private com.taobao.caipiao.agentmock.generate.agent.config.Agent agent;

	public AgentCommConfigImpl(javax.servlet.ServletConfig servletConfig,
			LotteryAgent agentDefinition,
			com.taobao.caipiao.agentmock.generate.agent.config.Agent agent){
		this.servletConfig = servletConfig;
		this.agentDefinition = agentDefinition;
		this.agent = agent;
	}
	
	@Override
	public String getLotteryAgentName() {
		return agentDefinition.getAgentName();
	}

	public javax.servlet.ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public String[] getFtpUrlPort() {
		String ftpUrlPort[] = null;
		String strUrl = this.agentDefinition.getFtpUrl();
		if(strUrl != null && !strUrl.equals("")){
			ftpUrlPort = strUrl.split(":");
		}
		return ftpUrlPort;
	}

	public LotteryAgent getAgentDefinition() {
		return agentDefinition;
	}

	public com.taobao.caipiao.agentmock.generate.agent.config.Agent getAgent() {
		return agent;
	}
	
}
