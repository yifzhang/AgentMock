package com.taobao.caipiao.agentmock.core.commu.bjfc.util;

import java.io.IOException;
import java.io.StringReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;

/**
 * @author youshan
 */
public class BjfcUtil {

	private static final Logger logger = LoggerFactory.getLogger(BjfcUtil.class);
	
	public static String MD5(String base64Xml){
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return Tool.bytesToHexString(md5.digest(base64Xml.trim()
					.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			logger.error("md5加密错误--->",e);
		}
		return "";
	}
	
	public static String packBody(String requestBodyXml,String digestKey){
		Des des = new Des(digestKey);
		//des.setKey(digestKey);
		return des.getEncString(requestBodyXml);
	}
	
	/**加密byte[]明文输入,String密文输出
	 * 对于有压缩的密文,压缩时不使用bytes转string返回,直接使用bytes
	 * @author fuguo
	 * @return String 
	 */
	public static String packBodyByte(byte[] requestBodyXml,String digestKey){
		Des des = new Des();
		des.setKey(digestKey);
		return des.getEncStringByte(requestBodyXml);
	}
	
	public static boolean validBody(String md, String body)
			throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		
		String newMD5 = Tool.bytesToHexString(md5
				.digest(body.trim().getBytes()));
		Tool.getLogger().debug("newMD5::" + newMD5);
		Tool.getLogger().debug("oldMD5::" + md);
		if (!newMD5.equals(md.toUpperCase())){
			logger.error("北京福彩接口xml参数的md5校验异常 newMD5::" + newMD5+"  oldMD5::" + md );
			return false;
		}
		return true;
			
		
	}
	
	public  static String unpackBodyToXML(String packInfo,String digestKey)
	throws IOException, Exception {
		Des des = new Des();
		des.setKey(digestKey);
		String xml = des.getDesString(packInfo);
		return xml;
	}
	
	/**
	 * 解密 以String密文输入,byte[]明文输出
	 * 对于有压缩的密文解压缩时不使用bytes转string返回,直接返回bytes
	 * @param strMi
	 * @author fuguo
	 * @return
	 */
	public  static byte[] unpackBodyToXMLByte(String packInfo,String digestKey)
	throws IOException, Exception {
		Des des = new Des();
		des.setKey(digestKey);
		byte[] xml = des.getDesStringByte(packInfo);
		return xml;
	}
	
	/**
	 * 中奖明细文件MD5校验 true:校验通过  ，flase:校验不通过
	 * @param fileContents
	 * @param sign
	 * @return
	 */
	public static boolean checkMd5(String fileContents, String sign, String md5Key){
		try {

			String BeginWord = "<head>";
			String EndWord = "<sign>";
			String md5_text = (String) fileContents.subSequence(
					fileContents.indexOf(BeginWord), fileContents.indexOf(EndWord));		
			String MyMd5 = null;
			MyMd5 = getMD5(md5_text.trim() + md5Key);
			if (MyMd5.equals(sign))
				return true;
			else
				logger.warn("md5校验中奖明细文件异常 MyMD5::" + MyMd5+"  sign::" + sign );
				return false;
		}
		 catch (Exception e) {
			logger.error("北京福彩中奖明细文件MD5校验有误，可能明细文件中的格式不对！", e);
			e.printStackTrace();
			return false;
		}
	}
	
	public final static String getMD5(String s) {
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int val = ((int) md[i]) & 0xff;
				if (val < 16)
					sb.append("0");
				sb.append(Integer.toHexString(val));

			}
			return sb.toString();
		} catch (Exception e) {
			logger.error("北京福彩中奖明细文件MD5校验时有误，根据<head><body>内容生成的MD5有误！", e);
			return null;
		}
	}
 
	public static void main(String[] args) {
		
	}

}
