package com.taobao.caipiao.agentmock.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GenericControllerChain implements ControllerChain {

	private Controller controller;
	private ControllerChain next;
	
	public GenericControllerChain(){
		this(null,null);
	}
	
	public GenericControllerChain(Controller controller){
		this(controller,null);
	}
	
	public GenericControllerChain(Controller controller,ControllerChain next){
		this.controller = controller;
		this.next = next;
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(this.controller != null){
			controller.execute(req, resp, this.next);
		}
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void setNextControllerChain(ControllerChain next) {
		this.next = next;

	}

}
