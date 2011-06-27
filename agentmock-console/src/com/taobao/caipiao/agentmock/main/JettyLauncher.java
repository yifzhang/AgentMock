package com.taobao.caipiao.agentmock.main;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ContextHandlerCollection;
import org.mortbay.jetty.handler.DefaultHandler;
import org.mortbay.jetty.handler.HandlerList;
import org.mortbay.jetty.handler.StatisticsHandler;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.xml.XmlConfiguration;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHandler;
import org.mortbay.jetty.servlet.ServletHolder;

import static com.taobao.caipiao.agentmock.util.Constants._AGENT_MOCK_SERVICE_PORT;

public class JettyLauncher {
	
	/* WebApp∂‘”¶µƒ≈‰÷√
	private Server start() throws Exception{
		Server jetty = new Server();
		String[] configFiles = {"etc/jetty.xml"};
		for(String configFile : configFiles){
			XmlConfiguration configuration = 
				new XmlConfiguration(new File(configFile).toURI().toURL());
			configuration.configure(jetty);
		}
		
		//Configure our web appliction
		WebAppContext appContext = new WebAppContext();
		appContext.setContextPath("/agentmock");
		File rd = new File("./");
		File warPath = new File(rd,"../agentmock-app/web");
		appContext.setWar(warPath.getAbsolutePath());
		
		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[]{appContext,new DefaultHandler()});
		
		jetty.setHandler(handlers);
        
		jetty.start();
		return jetty;
	}
	*/
	
	private Server start() throws Exception{
		int port = Integer.parseInt(_AGENT_MOCK_SERVICE_PORT);
		Server jetty = new Server(port);
		String serverConfig = "<Configure id=\"Server\" class=\"org.mortbay.jetty.Server\"> \n" +
		"<Set name=\"stopAtShutdown\">true</Set> \n" +
		"<Set name=\"sendServerVersion\">true</Set>" + "</Configure>\n";
		
		XmlConfiguration configuration = new XmlConfiguration(serverConfig); 
        configuration.configure(jetty);
        
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		jetty.setHandler(contexts);
		
		Context root = new Context(contexts,"/",Context.SESSIONS);
		root.addServlet(new ServletHolder(new WelcomeServlet("Oh!")),"/*" );
		
		Context other = new Context(contexts,"/AgentMockService",Context.SESSIONS);
		other.addServlet("com.taobao.caipiao.agentmock.core.Service", "/*");

		jetty.start();
		return jetty;
	}

	public static class WelcomeServlet extends HttpServlet {
		String greeting = "Hello";

		public WelcomeServlet() {
		}

		public WelcomeServlet(String hi) {
			greeting = hi;
		}

		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException,
				IOException {
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println("Please visit /AgentMockService");
			//response.getWriter().println("session=" + request.getSession(true).getId());
		}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException,IOException{
			doGet(req,resp);
		}
	}
	
	public static void main(String args[]){
		try{
			Server jetty = new JettyLauncher().start();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
