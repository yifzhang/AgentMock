package com.taobao.caipiao.agentmock.core.commu;

import com.taobao.caipiao.agentmock.core.AgentCommConfig;

/**
 * @author youshan
 */
public interface AgentCommandAdaptor {
	public void   setXmlMsg(String _xml);
	public void   setAgentCommConfig(AgentCommConfig _config);
	public String getResponseMsg();
	public boolean doCommCommand();
}

