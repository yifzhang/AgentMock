package com.taobao.caipiao.agentmock.core.commu.bjfc.impl;

import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;

/**
 * @author youshan
 */
public class BjfcCommandAdaptorBookeTicketsImpl extends BjfcCommandAdaptorAbstractImpl{

	private static final Logger log = LoggerFactory.getLogger(BjfcCommandAdaptorBookeTicketsImpl.class);
	private StringBuffer _bodyXmlBuff = new StringBuffer();
	
	@Override
	public boolean doCommCommand() {
		try {
			
			_bodyXmlBuff.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			_bodyXmlBuff.append("<body><ltype>1</ltype><periodnum>");
			String issueNum = factory.newXPath().evaluate("/body/periodnum", 
					new InputSource(new StringReader(inputFile)));
			_bodyXmlBuff.append(issueNum).append("</periodnum>")
			.append("<records>");
			NodeList nodeList = (NodeList) factory.newXPath().evaluate("/body/records/record", 
	          		  new InputSource(new StringReader(inputFile)), XPathConstants.NODESET);
            String orderNo = null;
            String timeStr=null;
			
            for (int i =0 ; i < nodeList.getLength(); i++){
            	Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");
				timeStr = dateFormat.format(date);
				
            	Node node = nodeList.item(i);
            	orderNo = node.getChildNodes().item(4).getTextContent();
            	_bodyXmlBuff.append("<record><orderno>").append(orderNo).append("</orderno>");
            	_bodyXmlBuff.append("<chipincontent></chipincontent>")
            	.append("<chipinresult>0</chipinresult>")
            	.append("<printresult>2</printresult>")
            	.append("<printtime>").append(timeStr).append("</printtime>")
            	.append("<failreason></failreason>")
            	.append("<orderamount></orderamount>")
            	.append("<cpserial>AgentMock_TicketSerialNumber_").append(timeStr).append("</cpserial>")
            	.append("</record>");
          	  
            }
            _bodyXmlBuff.append("</records></body>");
            
			return true;
		} catch (XPathExpressionException e) {
			log.error("parse xml failed: "+ inputFile);
			log.error("error info:"+e.getStackTrace().toString());
			return false;
		}
		
		
	}

	@Override
	public String getResponseMsg() {
		return _bodyXmlBuff.toString();
	}

}

