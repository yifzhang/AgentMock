package com.taobao.caipiao.agentmock.core.commu.hengpeng;

public enum CQFCStatusEnum {

	/**
	 * "0000", "成功"
	 */
	CALL_SUCCESS_CODE("0000", "成功"),
	
	/**
	 * "1008","玩法不存在"
	 */
	CALL_PLAY_CODE("1008","玩法不存在"),
	/**
	 * "1009","奖期不存在"
	 */
	CALL_ISSUE_CODE("1009","奖期不存在"),
	/**
	 * "2011","单个号码值超出允许范围"
	 */
	CALL_SIMPLE_CODE("2011","单个号码值超出允许范围"),
	/**
	 * "2032", "单个号码购买注数超出允许范围"
	 */
	CALL_RESTRICT_CODE("2032", "单个号码购买注数超出允许范围"),
	/**
	 * "2040","票金额不相符"
	 */
	CALL_TICK_CODE("2040","票金额不相符"),
	/**
	 * "2043","不支持的投注方式"
	 */
	CALL_SUPPORT_CODE("2043","不支持的投注方式"),
	/**
	 * "2044","投注号码格式错误"
	 */
	CALL_FORMAT_CODE("2044","投注号码格式错误"),
	
	/**
	 * "2048","重复投票"
	 */
	DUPLICATE_SALE_SUCCESS("2048","重复投票"),
	
	/**
	 * "2052","投注中"
	 * */
	IN_PROGRESS("2052","投注中"),
	
	/**
	 * "9999","未知失败原因"
	 */
	CALL_FAILE_CODE("9999","未知失败原因");

	private CQFCStatusEnum(String code, String desc) {
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
