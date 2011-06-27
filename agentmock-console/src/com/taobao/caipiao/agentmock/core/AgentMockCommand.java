package com.taobao.caipiao.agentmock.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AgentMockCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public Object executeWithResult(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
