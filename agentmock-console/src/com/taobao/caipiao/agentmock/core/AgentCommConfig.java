package com.taobao.caipiao.agentmock.core;

public interface AgentCommConfig {

	public String getLotteryAgentName();
	/**
	 * 
	 * @return
	 * String[0]: ftp url
	 * String[1]: ftp port
	 */
	public String[] getFtpUrlPort();
	public com.taobao.caipiao.agentmock.generate.agent.config.Agent getAgent();
}
