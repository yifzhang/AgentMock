package com.taobao.caipiao.agentmock.core;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleAgentMockCommand implements AgentMockCommand {

	private String className;
	private String method;
	
	public SimpleAgentMockCommand(String className){
		this.className = className;
	}
	
	public SimpleAgentMockCommand(String className,String method){
		this.className = className;
		this.method = method;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Object result;
		Class types[] = new Class[2];
		types[0] = HttpServletRequest.class;
		types[1] = HttpServletResponse.class;
		
		Object arglist[] = new Object[2];
		arglist[0] = request;
		arglist[1] = response;
		
		Method method = Class.forName(this.getClassName()).getMethod(this.getMethod(),
				types);
		result = method.invoke(Class.forName(this.getClassName()).newInstance(),
				arglist);
		response.getWriter().print(result);
	}

	@Override
	public Object executeWithResult(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Object result;
		Class types[] = new Class[2];
		types[0] = HttpServletRequest.class;
		types[1] = HttpServletResponse.class;
		
		Object arglist[] = new Object[2];
		arglist[0] = request;
		arglist[1] = response;
		
		Method method = Class.forName(this.getClassName()).getMethod(this.getMethod(),
				types);
		result = method.invoke(Class.forName(this.getClassName()).newInstance(),
				arglist);
		
		return result;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	

}
