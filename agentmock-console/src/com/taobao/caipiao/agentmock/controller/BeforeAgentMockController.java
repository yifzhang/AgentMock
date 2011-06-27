package com.taobao.caipiao.agentmock.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeforeAgentMockController extends GenericController {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, ControllerChain chain)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		String path = uri.substring(index+1);
		index = path.indexOf("?");
		if(index > 0 ) path = path.substring(0,index);
		index = path.indexOf(".");
		if(index > 0) path = path.substring(0,index);
		if(path.trim().equals("")){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("Invalid url request!");
			//Return error directly!
			return ;
		}
		request.setAttribute("agentName", path);//Set agent name!
		doBeforeHandler(request,response,path);
		chain.execute(request,response);
	}

	private void doBeforeHandler(HttpServletRequest request,
			HttpServletResponse response, String path) throws ServletException{
		response.setContentType("text/html;charset=GBK");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		response.setHeader("Cache-Control", "no-store");
	}
	
}
