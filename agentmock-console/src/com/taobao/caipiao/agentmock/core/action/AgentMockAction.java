package com.taobao.caipiao.agentmock.core.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AgentMockAction {
	public Object setLuckyNum(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
