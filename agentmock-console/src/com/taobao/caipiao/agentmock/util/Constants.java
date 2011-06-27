package com.taobao.caipiao.agentmock.util;

public final class Constants {
	public static final String _AGENT_MOCK_SERVICE_PORT = PropUtil.getString("agentmock.service.port");
	public static final String _AGENTMOCK_CONTROLLER_CHAIN	= "agentmock.controller.chain";
	public static final String _AGENTMOCK_CONTROLLER_LIST	= "agentmock.controller.list";
	
	public static final String _CHARSET_UTF		   = "UTF-8";
	public static final String _CHARSET_CHINESE	   = "gb2312";
	public static final String _CHARSET_CHINESE_GBK= "gbk";
	public static final String _CHARSET_8859	   = "8859_1";
	public static final String _COMMAND_URL_PREFIX	   = PropUtil.getString("agentmock.command.url.prefix");
	public static final String _COMMUNICATE_URL_PREFIX	   = PropUtil.getString("agentmock.commu.url.prefix");
	public final static String _FILE_PATH		 	 = (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") == -1) ? PropUtil.getString("file.root") : PropUtil.getString("file.root.windows");
	public static final String _SEND_MSG_PATH  		 = PropUtil.getString("agentmock.sendmsg.path");
	public static final String _SEND_MSG_FILE  		 = PropUtil.getString("agentmock.sendmsg.file");
	public static final String _SEND_MSG_AGENT_URL   = PropUtil.getString("agentmock.sendmsg.agent.url");
}
