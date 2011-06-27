package com.taobao.caipiao.agentmock.core.commu.hengpeng.impl;

import java.io.StringReader;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

import com.taobao.caipiao.agentmock.core.AgentCommConfig;
import com.taobao.caipiao.agentmock.core.commu.hengpeng.HengPengCommandAdaptor;
import com.taobao.caipiao.agentmock.core.commu.hengpeng.util.CalendarUtil;
import com.taobao.caipiao.agentmock.core.commu.hengpeng.util.MD5;

/**
 * @author youshan
 */
public abstract class HengPengCommandAdaptorAbstractImpl implements HengPengCommandAdaptor{
	protected static final String TaobaoAgentIdSSQ = "023005";
	protected String inputFile;
	protected XPathFactory factory = XPathFactory.newInstance();
	protected AgentCommConfig config;
	protected final static String XML_HEAD = "<?xml version=\"1.0\" encoding=\"GBK\"?>";
	protected static ConcurrentHashMap<String,String> ticketNumberMap = 
		new ConcurrentHashMap<String, String>();
	
	
	public void setXmlMsg(String xml) {
		this.inputFile = xml;
	}
	
	public void setAgentCommConfig(AgentCommConfig config){
		this.config = config;
	}
	
	public final static StringBuilder createRequestXmlHead(
			final String tranType, final String requestXmlBody,
			String taobaoAgentId, String digestKey) {
		StringBuilder sb = new StringBuilder(XML_HEAD);
		// 获得 当前 格式 为 yyyyMMddHHmmss 的 日期
		String date = CalendarUtil.toString(CalendarUtil.getCurrentDate(),
				CalendarUtil.TIME_PATTERN_SESSION);
		String id = taobaoAgentId + date + System.nanoTime()
				+ Thread.currentThread().getId();// agentID + 8位时间戳(yyyyMMdd) +
		// 系统时间的纳秒数+当前线程的id
		// XXX: 注意重庆福彩的接口版本号是1.1，而非江西福彩的1.0！
		sb.append("<message version=\"1.1\" id=\"").append(id).append("\">");
		sb.append("<header>");
		sb.append("<messengerID>");
		sb.append(taobaoAgentId);
		sb.append("</messengerID>");
		sb.append("<timestamp>");
		sb.append(date);
		sb.append("</timestamp>");
		sb.append("<transactionType>");
		sb.append(tranType);
		sb.append("</transactionType>");
		sb.append("<digest>");
		sb.append(MD5.encode(id + date + digestKey + requestXmlBody));
		sb.append("</digest>");
		sb.append("</header>");
		return sb;
	}
	
	/**
	 * 按照重庆福彩恒朋接口的签名规范验证请求合法性
	 * 
	 * @param xml
	 * @return
	 */
	public boolean checkXml(String xml, String digestKey) {
		try {
			String id = factory.newXPath().evaluate(
					"/message/@id",
					new InputSource(new StringReader(xml))
					);
			String timestamp = factory.newXPath().evaluate(
					"/message/header/timestamp",
					new InputSource(new StringReader(xml))
					);
			// 从请求内容中提取<body>部分
			int beginIndex = xml.indexOf("<body>");
			int endIndex = xml.indexOf("</body>");
			String body = xml.substring(beginIndex, endIndex) + "</body>";
			// 从请求内容中提取请求体摘要
			String digest = factory.newXPath().evaluate(
					"/message/header/digest",
					new InputSource(new StringReader(xml))
					);
			// 自行计算请求体摘要并进行比对
			String md5 = MD5.encode(id + timestamp + digestKey + body);
			if (digest.equalsIgnoreCase(md5)) {
				// 比对一致，验证通过
				return true;
			}
		} catch (XPathExpressionException e) {
		}
		
		// 验证未通过
		return false;
	}
	
}

