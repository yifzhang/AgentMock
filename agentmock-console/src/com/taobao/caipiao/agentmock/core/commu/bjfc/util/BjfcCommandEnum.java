package com.taobao.caipiao.agentmock.core.commu.bjfc.util;

import com.alibaba.common.lang.enumeration.IntegerEnum;

/**
 * @author youshan
 */
public class BjfcCommandEnum extends IntegerEnum{
	private static final long serialVersionUID = 1L;

	/**
	 * 1000 提交投注接口
	 */
	public static final BjfcCommandEnum ORDER_COMMOND = (BjfcCommandEnum) create(1000);
	
	/**
	 * 1003查询彩期状态接口
	 */
	public static final BjfcCommandEnum CHECK_ISSUE = (BjfcCommandEnum) create(1003);

	/**
	 * 1004 查询开奖号码
	 */
	public static final BjfcCommandEnum GET_LUCKNUMBER = (BjfcCommandEnum) create(1004);

    /**
	 * 2000 通知出票结果
	 */
	public static final BjfcCommandEnum ORDERBOOK_RESULT_NOTIFY = (BjfcCommandEnum) create(2000);
	
	/**
	 * 2001 期号信息通知
	 */
	public static final BjfcCommandEnum ISSUE_NOTIFY = (BjfcCommandEnum) create(2001);
	
	/**
	 *  2004 开奖完毕通知
	 */
	public static final BjfcCommandEnum AWARD_ORDER_NOTIFY = (BjfcCommandEnum) create(2004);
	
	/**
	 *  3001 查询中奖文件 
	 */
	public static final BjfcCommandEnum GET_AWARD_ORDER = (BjfcCommandEnum) create(2004);
	
}
