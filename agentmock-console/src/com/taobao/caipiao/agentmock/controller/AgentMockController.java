package com.taobao.caipiao.agentmock.controller;

import static com.taobao.caipiao.agentmock.util.Constants._COMMUNICATE_URL_PREFIX;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobao.caipiao.agentmock.core.impl.AgentMockContainerFactory;

public class AgentMockController extends GenericController {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, ControllerChain chain)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if(uri.indexOf(_COMMUNICATE_URL_PREFIX) >= 0){
			try {
				AgentMockContainerFactory.getAgentMockContainer().processAgentMockAction(request, response);
				// If some fragment code needed, can use this method to do the work!
				AgentMockContainerFactory.getAgentMockContainer().renderAgentMockResult(request, response);
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		
		//Not agent communication request, just forward it!
		chain.execute(request,response);
	}

}
