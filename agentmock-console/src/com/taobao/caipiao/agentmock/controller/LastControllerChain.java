package com.taobao.caipiao.agentmock.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastControllerChain implements ControllerChain {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	@Override
	public void setController(Controller controller) {
	}

	@Override
	public void setNextControllerChain(ControllerChain next) {
	}

}
