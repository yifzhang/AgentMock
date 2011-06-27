package com.taobao.caipiao.agentmock.logger;

public interface Logger {
	public enum Level{TRACE,DEBUG,INFO,WARN,ERROR,FATAL};
	
	public void trace(Object msg);
	public void debug(Object msg);
	public void info(Object msg);
	public void warn(Object msg);
	public void error(Object msg);
	public void fatal(Object msg);
	public void warn(Object message, Throwable t);
	public void error(Object message, Throwable t);
	
	// generic printing method :
	public void log(Level l,Object msg);
	public boolean isDebugEnabled();
}
