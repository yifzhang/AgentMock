package com.taobao.caipiao.agentmock.core.commu.bjfc.impl;
/**
 * @author youshan
 */
public class BjfcCommandAdaptorGetLuckyNumImpl extends BjfcCommandAdaptorAbstractImpl {

	//Bjfc don't need to have GetLuckyNum implementation!
	@Override
	public boolean doCommCommand() {
		return false;
	}

	@Override
	public String getResponseMsg() {
		return null;
	}

}

