package com.taobao.caipiao.agentmock.core.commu.xgjx;

import com.taobao.caipiao.agentmock.core.commu.xgjx.impl.XgjxCommandAdaptorBookeTicketsImpl;
import com.taobao.caipiao.agentmock.core.commu.xgjx.impl.XgjxCommandAdaptorGetIssueImpl;
import com.taobao.caipiao.agentmock.core.commu.xgjx.impl.XgjxCommandAdaptorGetLuckyNumImpl;


/**
 * @author youshan
 */
public class XgjxCommandAdaptorFactory {

	public static final int GET_ISSUE=1003;
	public static final int BOOK_TICKETS = 1000;
	public static final int GET_LUCKY_NUM = 1004;
	
	public static XgjxCommandAdaptor getAdaptor(int _target){
		switch(_target){
			case (GET_ISSUE):
				return new XgjxCommandAdaptorGetIssueImpl();
			case (BOOK_TICKETS):
				return new XgjxCommandAdaptorBookeTicketsImpl();
			case (GET_LUCKY_NUM):
				return new XgjxCommandAdaptorGetLuckyNumImpl();
			
			default:
				return null;
		}
	}
}

