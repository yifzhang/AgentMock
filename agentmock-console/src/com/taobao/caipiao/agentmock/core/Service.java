package com.taobao.caipiao.agentmock.core;

import static com.taobao.caipiao.agentmock.util.Constants._AGENTMOCK_CONTROLLER_CHAIN;
import static com.taobao.caipiao.agentmock.util.Constants._AGENTMOCK_CONTROLLER_LIST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobao.caipiao.agentmock.controller.Controller;
import com.taobao.caipiao.agentmock.controller.ControllerChain;
import com.taobao.caipiao.agentmock.controller.LastControllerChain;
import com.taobao.caipiao.agentmock.core.impl.AgentMockContainerFactory;
import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;
import com.taobao.caipiao.agentmock.util.PropUtil;

public class Service extends HttpServlet implements Servlet{
	private Logger logger = LoggerFactory.getLogger(Service.class); 
	private ControllerChain chain;
	
	public void init(ServletConfig config) throws ServletException{
		super.init();
		try{
			this.registerControllers();
			AgentMockContainerFactory.getAgentMockContainer().init(config);
		}catch (Exception e){
			Throwable ex = e;
			while(ex != null){
				logger.error(String.format("%s: %s", ex.getClass().toString(),
						ex.getMessage()));
				ex = ex.getCause();
			}
		}
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp)
	throws ServletException,IOException{
		process(req,resp);
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
	throws ServletException,IOException{
		process(req,resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException,IOException{
//		BufferedReader in = req.getReader();
//		StringBuffer sb = new StringBuffer();
//		String line;
//		while((line = in.readLine()) != null){
//			sb.append(line);
//		}
//		
//		String path = req.getRequestURI();
//		PrintWriter out = resp.getWriter();
//        out.println("This is post and path:"+path);
//        out.close();
		chain.execute(req, resp);
	}
	
	/**
     * registerControllers.
     * 
     * @throws Exception
     * 
     * using chain of responsibility design pattern to process all incoming requests. 
     * All controllers are configured at portal.properties, default configurations are:
     * 
     * agentmock.controller.chain=com.taobao.caipiao.agentmock.controller.GenericControllerChain
     * agentmock.controller.list=\
	 *		   com.taobao.caipiao.agentmock.controller.CommandController,\
	 *		   com.taobao.caipiao.agentmock.controller.PageController
	 *
     * and the configuration can be overriden in portal-ext.properties and portal-ext-[organization webId].properties which is community separated configration file
     * 
     */
	private void registerControllers() throws Exception{
		Class chainClass = PropUtil.getClass(_AGENTMOCK_CONTROLLER_CHAIN);
		Class[] controllerClasses = PropUtil.getClassArray(_AGENTMOCK_CONTROLLER_LIST);
		List<Controller> controllers = new LinkedList<Controller>();
		LinkedList<ControllerChain> chains = new LinkedList<ControllerChain>();
		
		for(int i = controllerClasses.length - 1; i >= 0; i--){
			controllers.add((Controller)controllerClasses[i].newInstance());
			chains.add((ControllerChain)chainClass.newInstance());
		}
		
		for(int i=0; i < controllers.size();i++){
			chains.get(i).setController(controllers.get(i));
			if(i == 0){
				chains.get(i).setNextControllerChain(new LastControllerChain());
			}else{
				chains.get(i).setNextControllerChain(chains.get(i-1));
			}
		}
		
		this.chain = chains.getLast();
	}
}