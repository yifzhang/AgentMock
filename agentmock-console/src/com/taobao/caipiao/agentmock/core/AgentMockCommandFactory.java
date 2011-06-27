package com.taobao.caipiao.agentmock.core;

import java.util.HashMap;
import java.util.Map;

public class AgentMockCommandFactory {
	private static AgentMockCommandFactory instance = 
		new AgentMockCommandFactory();
	
	private Map<String,AgentMockCommand> defaultCommandMaps;
	
	public static AgentMockCommandFactory getInstance(){
		return instance;
	}
	
	/**
	 * 
	 * @param path: bjfc?issue=xxx&luckynum=xxx
	 * @return
	 * 
	 * Note: 
	 * The limitation of this method is: cann't be configured for Application Service 
	 * Provider!
	 * In ASP, a single running application may need to have different configurations 
	 * depending on the customer that is accessing the application.
	 * 
	 */
	public AgentMockCommand getCommand(String path){
		int index = path.indexOf("?");
		if(index != -1){
			path = path.substring(0,index);
		}
		return defaultCommandMaps.get(path);
	}
	
	private AgentMockCommandFactory(){
		defaultCommandMaps = new HashMap<String,AgentMockCommand>();
		
		defaultCommandMaps.put("bjfc", new SimpleAgentMockCommand(
				"com.taobao.caipiao.agentmock.core.action.impl.AgentMockCommandAction"
				,"setLuckyNum"));

		defaultCommandMaps.put("cqfc", new SimpleAgentMockCommand(
				"com.taobao.caipiao.agentmock.core.action.impl.AgentMockCommandAction"
				,"setLuckyNum"));
		
		defaultCommandMaps.put("xgjx", new SimpleAgentMockCommand(
				"com.taobao.caipiao.agentmock.core.action.impl.AgentMockCommandAction"
				,"setLuckyNum"));
	}
	
	public static void main(String[] args){
	}
}
