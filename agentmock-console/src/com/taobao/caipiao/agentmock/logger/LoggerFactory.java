package com.taobao.caipiao.agentmock.logger;

public class LoggerFactory {
	public static Logger getLogger(Class klass){
		return new LoggerImpl(klass);
	}
}
