package com.taobao.caipiao.agentmock.core.commu.hengpeng.util;

import java.security.MessageDigest;

public class MD5 {
    public static String encode(String _msg) {
        try {
            StringBuffer  digMsg = new StringBuffer();
            MessageDigest md  = MessageDigest.getInstance("MD5");
            byte[]        bmd = md.digest(_msg.getBytes("GBK"));

            for (int i = 0; i < bmd.length; i++) {
                int tmp = (int) bmd[i];

                tmp = tmp & 0xFF;

                if (tmp <= 0xF) {
                    digMsg.append("0");
                }

                digMsg.append(Integer.toHexString(tmp));
            }

            return digMsg.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
