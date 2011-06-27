package com.taobao.caipiao.agentmock.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerChain {
	public void execute(HttpServletRequest req,HttpServletResponse resp)
	throws ServletException,IOException;
	public void setController(Controller controller);
	public void setNextControllerChain(ControllerChain next);
}
