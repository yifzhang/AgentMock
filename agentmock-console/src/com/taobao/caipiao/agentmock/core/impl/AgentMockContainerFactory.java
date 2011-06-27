package com.taobao.caipiao.agentmock.core.impl;

import com.taobao.caipiao.agentmock.core.AgentMockContainer;

public class AgentMockContainerFactory {
	
	private static AgentMockContainer agentMockContainer = 
		new AgentMockContainerImpl();
	
	public static AgentMockContainer getAgentMockContainer(){
		return agentMockContainer;
	}
}
