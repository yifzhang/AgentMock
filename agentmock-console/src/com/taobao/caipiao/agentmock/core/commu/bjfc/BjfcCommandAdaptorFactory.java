package com.taobao.caipiao.agentmock.core.commu.bjfc;

import com.taobao.caipiao.agentmock.core.commu.bjfc.impl.BjfcCommandAdaptorBookeTicketsImpl;
import com.taobao.caipiao.agentmock.core.commu.bjfc.impl.BjfcCommandAdaptorGetIssueImpl;
import com.taobao.caipiao.agentmock.core.commu.bjfc.impl.BjfcCommandAdaptorGetLuckyNumImpl;

/**
 * @author youshan
 */
public class BjfcCommandAdaptorFactory {
	// H8 don't have query tickets interface!
	public static final int GET_ISSUE=1003;
	public static final int BOOK_TICKETS = 1000;
	public static final int GET_LUCKY_NUM = 1004;
	
	public static BjfcCommandAdaptor getAdaptor(int _target){
		switch(_target){
			case (GET_ISSUE):
				return new BjfcCommandAdaptorGetIssueImpl();
			case (BOOK_TICKETS):
				return new BjfcCommandAdaptorBookeTicketsImpl();
			case (GET_LUCKY_NUM):
				return new BjfcCommandAdaptorGetLuckyNumImpl();
			
			default:
				return null;
		}
	}
}

