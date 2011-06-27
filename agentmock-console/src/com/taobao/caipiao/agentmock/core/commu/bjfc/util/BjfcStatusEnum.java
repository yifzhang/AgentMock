package com.taobao.caipiao.agentmock.core.commu.bjfc.util;

public enum BjfcStatusEnum {
	/**
	 * "00", "操作成功"
	 */
	OPERATION_SUCCESS_CODE("00", "操作成功"),
	/**
	 * "100001","程序错误"
	 */
	PROCEDURE_ERROR_CODE("100001","程序错误"),
	/**
	 * "100002","解码错误"
	 */
	DECODE_ERROR_CODE("100002","解码错误"),
	/**
	 * "100003","无效参数"
	 */
	INVALID_PARAMETER_CODE("100003","无效参数"),
	/**
	 * "100004","商户信息不存在/状态不正确"
	 */
	SYSTEM_EXCEPTION_CODE("100004","商户信息不存在/状态不正确"),
	/**
	 * "100005","未开通该游戏"
	 */
	VALID_GAME("100005","未开通该游戏"),
	/**
	 * "100006","未开通该游戏"
	 */
	VALID_PAUSE_GAME("100006","该游戏已暂停"),
	
	/**
	 * "200001","投注金余额不足"
	 */
	INVEST_MONEY_LACK_CODE("200001","投注金余额不足"),
	/**
	 * "200002","注码格式错误"
	 */
	STAKECODE_FORMAT_ERROR_CODE("200002","注码格式错误"),
	/**
	 * "200003","投注序列号重复"
	 */
	INVEST_SEQ_DUPLICATE_CODE("200003","投注序列号重复"),
	
	/**
	 * "200004","无效玩法代码"
	 */
	INVALID_PLAYTYPE_CODE("200004","无效玩法代码"),
	
	/**
	 * "200005","玩法期不正确"
	 */
	INVALID_PLAYTYPE_ISSUE("200005","玩法期不正确"),
	
	/**
	 * "200009", "限号"
	 */
	LIMIT_NUMBER("200009", "限号"),
	
	/**
	 * "200010", "无此投注订单号"
	 */
	INVALID_BOOK_ORDER("200010", "无此投注订单号"),
	
	/**
	 * "200020","出票失败"
	 */
	 OUT_TICKET_FAIL("200020","出票失败"),
	
	/**
	 * "200022","还未出票"
	 */
	 NO_OUT_TICKET("200022","还未出票"),
	
	/**
	 * "200023","投注成功"
	 */
	INVEST_SUCCESS("200023","已提交成功"),
	
	/**
	 * "200023","投注成功"
	 */
	INVEST_FAIL("200024","已提交失败"),
	
	/**
	 * "200025","投注成功"
	 */
	NOT_DRAWED("200025","未开奖"),
	
	/**
	 * "200027","超过一单允许票数"
	 */
	EXCEED_ONE_ORDER_TICKETS("200027","超过一单允许票数"),
	
	/**
	 * "200090","出票结果未知"
	 */
	UNKNOWN_BOOK_RESULT("200090","出票结果未知"),
	
	/**
	 * "北京福彩chipinresult"
	 */
	BJFC_CHIPIN_RET_SUCCESS("00","接单成功"),
	
	
	/**
	 * "北京福彩printresult"，只有chipinresult失败的情况下，才有意义
	 */
	BJFC_PRINT_RET_NOT_BOOK("0","未出票"),
	BJFC_PRINT_RET_IN_PROCESS("1","出票中"),
	BJFC_PRINT_RET_SUCCESS("2","出票成功"),
	BJFC_PRINT_RET_LIMIT_CODE("4","限号"),
	BJFC_PRINT_RET_BOOK_FAIL("7","出票失败"),
	
	/**
	 * 调用反馈结果代码，0-成功，
	 */
	FEEDBACK_SUCCESS("00","成功"),
	
	/**
	 * 1-失败
	 */
    FEEDBACKFAIL("99","失败"),
	/**
	 * 2-彩期已停止
	 */
   ISSUESTOP("2","彩期已停止"),
	
   /**
    * 未开奖
    */
	NOT_OPEN_AWARD("200025","未开奖");	
		
	private BjfcStatusEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	private String code;

	private String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
