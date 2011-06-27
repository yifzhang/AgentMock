package com.taobao.caipiao.agentmock.core.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobao.caipiao.agentmock.core.commu.AgentComm;
import com.taobao.caipiao.agentmock.core.impl.AgentMockContainerFactory;

public class AgentMockCommandAction extends BaseAction {

	@Override
	public Object setLuckyNum(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String luckyNum = request.getParameter("luckynum");
		String issue=request.getParameter("issue");
		String agentName = (String)request.getAttribute("agentName");
		AgentComm agentComm = AgentMockContainerFactory.getAgentMockContainer().getAgentComm(agentName);
		agentComm.setLuckyNum(issue,luckyNum);
		return true;
	}

}
