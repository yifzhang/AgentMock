package com.taobao.caipiao.agentmock.util;

import static com.taobao.caipiao.agentmock.util.Constants._AGENTMOCK_CONTROLLER_CHAIN;

import com.germinus.easyconf.EasyConf;

public class PropUtil {
	public static final String _BASE="agentmock";
	
	public static String getString(String name){		
		return getString(name, null);
	}
	
	public static String getString(String name,String orgWebId){
		String value = null;
		try{
			if(orgWebId != null)
				value = EasyConf.getConfiguration(orgWebId,_BASE).getProperties().getString(name);
			else
				value = EasyConf.getConfiguration(_BASE).getProperties().getString(name);
		}catch(Exception e){}
		return value;
	}
	
	public static String[] getStringArray(String name){
		return getStringArray(name, null);
	}
	
	public static String[] getStringArray(String name,String orgWebId){
		String[] value = null;
		if(orgWebId != null)
			value = EasyConf.getConfiguration(orgWebId,_BASE).getProperties().getStringArray(name);
		else
			value = EasyConf.getConfiguration(_BASE).getProperties().getStringArray(name);
		return value;
	}
	
	public static boolean getBoolean(String name){
		return getBoolean(name, null);
	}
	
	public static boolean getBoolean(String name,String orgWebId){
		boolean value = false;
		try{
			if(orgWebId != null)
				value = EasyConf.getConfiguration(orgWebId,_BASE).getProperties().getBoolean(name);
			else
				value = EasyConf.getConfiguration(_BASE).getProperties().getBoolean(name);
		}catch(Exception e){}
		return value;
	}
	
	public static Class getClass(String name){
		return getClass(name,null);
	}
	
	public static Class getClass(String name, String orgId) {
		Class value = null;
		try {
			if (orgId != null)
				value = EasyConf.getConfiguration(orgId, _BASE).getProperties()
						.getClass(name);
			else
				value = EasyConf.getConfiguration(_BASE).getProperties()
						.getClass(name);

		} catch (Exception e) {
		}

		return value;
	}
	
	public static Class[] getClassArray(String name){
		return getClassArray(name,null);
	}
	
	public static Class[] getClassArray(String name, String orgId){
		Class[] value = null;
		try{
			if(orgId != null)
				value = EasyConf.getConfiguration(orgId,_BASE)
				.getProperties().getClassArray(name);
			else
				value = EasyConf.getConfiguration(_BASE)
				.getProperties().getClassArray(name);
		}catch(Exception e){}
		return value;
	}
	
	public static void main(String[] args){
		Class chainClass = PropUtil.getClass(_AGENTMOCK_CONTROLLER_CHAIN);
		
	}
}
