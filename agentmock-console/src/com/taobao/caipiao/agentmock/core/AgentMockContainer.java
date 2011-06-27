package com.taobao.caipiao.agentmock.core;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobao.caipiao.agentmock.core.commu.AgentComm;


public interface AgentMockContainer {
	public void init(ServletConfig servletConfig) throws Exception;
	public boolean isInitialized();
	public AgentComm getAgentComm(String name);
	public void processAgentMockAction(HttpServletRequest servletRequest, HttpServletResponse servletResponse ) throws Exception;
	public void renderAgentMockResult(HttpServletRequest servletRequest, HttpServletResponse servletResponse ) throws  Exception;
	public void shutdown();

}
