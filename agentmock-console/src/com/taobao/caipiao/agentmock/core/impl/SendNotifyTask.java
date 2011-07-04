package com.taobao.caipiao.agentmock.core.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import com.taobao.caipiao.agentmock.core.AgentMockTask;
import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;

import static com.taobao.caipiao.agentmock.util.Constants._FILE_PATH;
import static com.taobao.caipiao.agentmock.util.Constants._SEND_MSG_PATH;
import static com.taobao.caipiao.agentmock.util.Constants._SEND_MSG_FILE;
import static com.taobao.caipiao.agentmock.util.Constants._SEND_MSG_AGENT_URL;

/**
 * @author youshan
 */
public class SendNotifyTask implements AgentMockTask{

	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Override
	public void execute(Object... arguments) throws Exception {
		sendNotifyMsg();
	}
	
	protected void sendNotifyMsg(){	
		logger.info("start sendNotifyMsg ");
		BufferedReader bufReader = null;
		try{			
			FileReader fileReader = new FileReader(new File(getFileName(0)));
			bufReader = new BufferedReader(fileReader);
			sendMsg(bufReader);
			bufReader.close();			
		}catch(Exception e){
			logger.error(e.getStackTrace());
		}finally{
			try{
				if(bufReader != null) bufReader.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		logger.info("end sendNotifyMsg");
	}
	
	protected void sendMsg(BufferedReader is) throws IOException,Exception {
		StringBuffer sb = new StringBuffer();
		String inputLine = null;
		while((inputLine = is.readLine()) != null){
			sb.append(inputLine);
		}
		//now send the message to the url!
		String url = _SEND_MSG_AGENT_URL;
		httpPost(null,sb.toString(),url);
	}
	
	protected String getFileName(long orgId){
		String separator = System.getProperty("file.separator");
		return _FILE_PATH+orgId+separator+_SEND_MSG_PATH+separator+_SEND_MSG_FILE;
	}
	
	protected void httpPost(Object paramObj, String requestXml,
			String serviceUrl) throws Exception {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(serviceUrl);
		client.setConnectionTimeout(30000);
		client.setTimeout(50000);
		client.setHttpConnectionFactoryTimeout(30000);
		post.addRequestHeader("Content-Type", "GBK");
		post.setRequestBody(requestXml);
		try {
			logger.warn("Taobao send xml:" + requestXml);
			long currTime = System.currentTimeMillis();
			int statusCode = client.executeMethod(post);
			logger.warn("Taobao receive response from bjfc for: "
					+ (System.currentTimeMillis() - currTime) + " ms");
			if (statusCode == HttpStatus.SC_OK) {
				// http调用成功
				String responseXml = null;
				responseXml = post.getResponseBodyAsString();
				logger.debug("Receive msg from "+serviceUrl+",message is:"+responseXml);
			} else {
				logger.error("In httpPost,url: "
						+ serviceUrl + "; httpPost error for:"+statusCode);
				throw new Exception("地址调用不成功---> 状态：" + statusCode);
			}
		} catch (Exception ex) {
			logger.error("communication with agent has error:\n Error Message->"
					+ ex.getMessage() + "\nURL->" + serviceUrl
					+ "; lotteryAgent =>agent; request is: " + requestXml);
			throw ex;
		} finally {
			// 释放连接
			post.releaseConnection();
			client.getHttpConnectionManager().closeIdleConnections(0);
		}
	}
}

