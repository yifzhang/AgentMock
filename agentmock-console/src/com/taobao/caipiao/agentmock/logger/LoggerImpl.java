package com.taobao.caipiao.agentmock.logger;

public class LoggerImpl implements Logger {

	private org.apache.log4j.Logger logger;
	
	public static LoggerImpl getLogger(Class klass){
		return new LoggerImpl(klass);
	}
	
	public LoggerImpl(Class klass){
		this.logger = org.apache.log4j.Logger.getLogger(klass);
	}
	
	@Override
	public void debug(Object msg) {
		this.logger.debug(msg);
	}

	@Override
	public void error(Object msg) {
		this.logger.error(msg);
	}

	@Override
	public void fatal(Object msg) {
		this.logger.fatal(msg);
	}

	@Override
	public void info(Object msg) {
		this.logger.info(msg);
	}

	@Override
	public boolean isDebugEnabled() {
		return this.logger.isDebugEnabled();
	}

	@Override
	public void log(Level l, Object msg) {
		if(l == Logger.Level.TRACE){
    		trace(msg);
    	}else if(l == Logger.Level.DEBUG){
    		debug(msg);
    	}else if(l == Logger.Level.INFO){
    		info(msg);
    	}else if(l == Logger.Level.WARN){
    		warn(msg);
    	}else if(l == Logger.Level.ERROR){
    		error(msg);
    	}else if(l == Logger.Level.FATAL){
    		fatal(msg);
    	}
	}

	@Override
	public void trace(Object msg) {
		this.logger.trace(msg);
	}

	@Override
	public void warn(Object msg) {
		this.logger.warn(msg);
	}

	@Override
	public void error(Object message, Throwable t) {
		this.logger.error(message, t);
	}

	@Override
	public void warn(Object message, Throwable t) {
		this.logger.warn(message,t);
	}

}
