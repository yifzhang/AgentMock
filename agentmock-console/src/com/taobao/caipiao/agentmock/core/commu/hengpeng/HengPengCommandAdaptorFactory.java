package com.taobao.caipiao.agentmock.core.commu.hengpeng;

import com.taobao.caipiao.agentmock.core.commu.hengpeng.impl.HengPengCommandAdaptorBookTicketsImpl;
import com.taobao.caipiao.agentmock.core.commu.hengpeng.impl.HengPengCommandAdaptorGetAwardTicketsImpl;
import com.taobao.caipiao.agentmock.core.commu.hengpeng.impl.HengPengCommandAdaptorGetIssueImpl;
import com.taobao.caipiao.agentmock.core.commu.hengpeng.impl.HengPengCommandAdaptorQueryTicketsImpl;

/**
 * @author youshan
 */
public class HengPengCommandAdaptorFactory {
	public static final int  GET_ISSUE = 102;
	public static final int  BOOK_TICKETS = 103;
	public static final int  QUERY_TICKETS = 137;
	//public static final int  GET_LUCKY_NUMBER = 102102;//Lucky number is an extension of get issue!
	public static final int  GET_AWARD_TICKETS = 106;
	
	public static HengPengCommandAdaptor getAdaptor(int _target){
		switch(_target){
			case (GET_ISSUE):
				return new HengPengCommandAdaptorGetIssueImpl();
			case (BOOK_TICKETS):
				return new HengPengCommandAdaptorBookTicketsImpl();
			case (QUERY_TICKETS):
				return new HengPengCommandAdaptorQueryTicketsImpl();
			case (GET_AWARD_TICKETS):
				return new HengPengCommandAdaptorGetAwardTicketsImpl();
			default:
				return null;
		}
	}

}

