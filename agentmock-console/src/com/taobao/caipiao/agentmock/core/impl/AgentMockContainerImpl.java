package com.taobao.caipiao.agentmock.core.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exolab.castor.xml.Unmarshaller;

import com.taobao.caipiao.agentmock.core.AgentCommConfig;
import com.taobao.caipiao.agentmock.core.AgentMockContainer;
import com.taobao.caipiao.agentmock.core.commu.AgentComm;
import com.taobao.caipiao.agentmock.generate.agent.config.Agent;
import com.taobao.caipiao.agentmock.generate.agent.config.Agents;
import com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent;
import com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgentApp;
import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;

public class AgentMockContainerImpl implements AgentMockContainer {

	private ServletConfig servletConfig;
	private Logger logger = LoggerFactory.getLogger(AgentMockContainerImpl.class); 
	
	private LotteryAgentApp agentApp;
	//Save AgentComm object's configuration for communication user
	private Map<String, AgentCommConfig> agentsCommConfigs = new HashMap<String, AgentCommConfig>();
	private HashMap<String, LotteryAgent> agentDefinitions = new HashMap<String, LotteryAgent>();
	private HashMap<String, AgentComm> agentComms = new HashMap<String, AgentComm>();
	//Save agent configurations in agent-config.xml
	private HashMap<String, com.taobao.caipiao.agentmock.generate.agent.config.Agent> agentConfigs 
		= new HashMap<String, com.taobao.caipiao.agentmock.generate.agent.config.Agent>();

	@Override
	public void init(ServletConfig servletConfig) throws Exception {
		try {
//			InputStream stream = servletConfig.getServletContext()
//					.getResourceAsStream("etc/lotteryagent.xml");
			InputStream stream = null;
			try{
				stream = new FileInputStream("lotteryagent.xml");
			}catch(FileNotFoundException e){
				stream = new FileInputStream("etc/lotteryagent.xml");
			}
			
			InputStreamReader rdr = new InputStreamReader(stream);
			LotteryAgentApp lotteryAgentApp = (LotteryAgentApp) Unmarshaller
					.unmarshal(LotteryAgentApp.class, rdr);
			if (lotteryAgentApp == null)
				throw new RuntimeException(
						"lotteryagent.xml configure error: null object!");
			
//			InputStream stream1 = servletConfig.getServletContext()
//					.getResourceAsStream("etc/agent-config.xml");
			InputStream stream1 = null;
			try{
				stream1 = new FileInputStream("agent-config.xml");
			}catch(FileNotFoundException e){
				stream1 = new FileInputStream("etc/agent-config.xml");
			}
			
			InputStreamReader rdr1 = new InputStreamReader(stream1);
			Agents agents = (Agents)Unmarshaller.unmarshal(Agents.class, rdr1);
			if(agents == null)
				throw new RuntimeException("agent-config.xml error: null object!");
			
			this.init(servletConfig, lotteryAgentApp,agents);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void init(ServletConfig servletConfig, LotteryAgentApp agentApp,Agents agents) throws Exception {
		this.servletConfig = servletConfig;
		this.agentApp = agentApp;

		for(int i = 0 ; i < agents.getAgentCount(); i++){
			agentConfigs.put(agents.getAgent(i).getName(), agents.getAgent(i));
		}
		
		LotteryAgent agentDefinitionArray[] = agentApp.getLotteryAgent();
		if (agentDefinitions != null) {
			if (agentDefinitionArray.length > 0) {
				for (int i = 0; i < agentDefinitionArray.length; i++) {
					try {
						AgentComm agentComm = (AgentComm)Class.forName(
								agentDefinitionArray[i].getAgentClass()).newInstance();
						Agent agent = agentConfigs.get(agentDefinitionArray[i].getAgentName());
						if(agent == null){
							throw new RuntimeException("Configuration not fit in agent-config.xml and lotteryagent.xml!" +
									"For: "+agentDefinitionArray[i].getAgentName());
						}
						AgentCommConfig agentConfig = new AgentCommConfigImpl(servletConfig,
								agentDefinitionArray[i],agent);
						agentsCommConfigs.put(agentDefinitionArray[i].getAgentName(), agentConfig);
						agentComm.init(agentConfig);
						agentComms.put(agentDefinitionArray[i].getAgentName(), agentComm);
						agentDefinitions.put(agentDefinitionArray[i].getAgentName(), 
								agentDefinitionArray[i]);
						// 需要将agentDefinitions和agentConfigs进行设置！
					} catch (Exception e) {
						throw new Exception(e);
					}
				}
			}
		}
	}

	@Override
	public boolean isInitialized() {
		return (servletConfig == null) ? false : true;
	}

	@Override
	public void processAgentMockAction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String agentName = null;
		if(request.getAttribute("agentName") != null)
			agentName= (String)request.getAttribute("agentName");
		else{
			String uri = request.getRequestURI();
			int index = uri.lastIndexOf("/");
			String path = uri.substring(index+1);
			index = path.indexOf(".");
			if(index > 0) path = path.substring(0,index);
			agentName = path;
			request.setAttribute("agentName", agentName);
		}
		AgentComm agentComm = this.getAgentComm(agentName);
		if(agentComm != null){
			agentComm.processAgentMockAction(request, response);
		}
	}

	@Override
	public void renderAgentMockResult(HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws Exception {
		
	}

	@Override
	public void shutdown() {
	}
	
	@Override
	public AgentComm getAgentComm(String name) {
		AgentComm agentComm = agentComms.get(name);
		Agent agent = agentConfigs.get(name);
		if(agent == null)
			throw new RuntimeException("Configuration not fit in agent-config.xml and lotteryagent.xml!"+
					"For: "+name);
		if(agentComm == null){
			synchronized (this){
				if (agentComm == null){
					try{
						LotteryAgent agentDefinition = agentDefinitions.get(name);
						if(agentDefinition != null){
							agentComm = (AgentComm)Class.forName(agentDefinition.getAgentClass()).newInstance();
							AgentCommConfig agentConfig = agentsCommConfigs.get(name);
							if(agentConfig == null){
								agentConfig = new AgentCommConfigImpl(servletConfig,agentDefinition,agent);
								agentsCommConfigs.put(name, agentConfig);
							}
							agentComm.init(agentConfig);
							agentComms.put(name, agentComm);
						}
					}catch(Exception e){}
				}
			}				
					
		}
		return agentComm;
	}

}
