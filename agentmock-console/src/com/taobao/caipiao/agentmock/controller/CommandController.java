package com.taobao.caipiao.agentmock.controller;

import java.io.IOException;

import static com.taobao.caipiao.agentmock.util.Constants._CHARSET_UTF;
import static com.taobao.caipiao.agentmock.util.Constants._COMMAND_URL_PREFIX;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobao.caipiao.agentmock.core.AgentMockCommand;
import com.taobao.caipiao.agentmock.core.AgentMockCommandFactory;

/**
 * 
 * @author youshan
 * The CommandController is the interface for admin to control the variables in the memory.
 * The URL should like this:
 * http://xxxx/AgentMockService/command/bjfc?issue=xxx&luckynum=xxx
 * 
 */
public class CommandController extends GenericController {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, ControllerChain chain)
			throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		String path = uri.substring(index + 1);
		
		if(uri.indexOf(_COMMAND_URL_PREFIX) >= 0){
			doCommand(request, response, path);
		}
		
//		response.setContentType("text/xml;charset=UTF-8");
//		request.setCharacterEncoding(_CHARSET_UTF);
		
		chain.execute(request,response);
	}
	
	private void doCommand(HttpServletRequest request, HttpServletResponse response, String uri)
	throws ServletException, IOException {
		AgentMockCommand agCommand = 
			AgentMockCommandFactory.getInstance().getCommand(uri);
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		response.setHeader("Cache-Control", "no-store");
		
		if(agCommand != null){
			try {
				agCommand.execute(request,response);
			} catch (Exception e) {
				throw new IOException(e);
			}
		}
	}

}
