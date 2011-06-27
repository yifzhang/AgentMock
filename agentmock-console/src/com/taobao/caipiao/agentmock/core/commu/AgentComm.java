package com.taobao.caipiao.agentmock.core.commu;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobao.caipiao.agentmock.core.AgentCommConfig;

public interface AgentComm {
	public void init(AgentCommConfig agentConfig);
	public void processAgentMockAction(HttpServletRequest servletRequest, HttpServletResponse servletResponse ) throws Exception;
	public void renderAgentMockResult(HttpServletRequest servletRequest, HttpServletResponse servletResponse ) throws  Exception;
	public void setLuckyNum(String issue,String luckyNum);
}
