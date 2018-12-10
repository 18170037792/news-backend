package com.xiafei.newsbackend.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by qujie on 2018/12/10
 * */
public class GetIpAndMac {
    public GetIpAndMac() {
    }

    public static String getIp(HttpServletRequest req) {
        String ip = req.getHeader("X-Real-IP");
        if (!ValidateUtil.isNull(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        } else {
            ip = req.getHeader("X-Forwarded-For");
            if (!ValidateUtil.isNull(ip) && !"unknown".equalsIgnoreCase(ip)) {
                int index = ip.indexOf(44);
                return index != -1 ? ip.substring(0, index) : ip;
            } else {
                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = req.getHeader("Proxy-Client-IP");
                }

                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = req.getHeader("WL-Proxy-Client-IP");
                }

                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = req.getHeader("HTTP_CLIENT_IP");
                }

                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = req.getHeader("HTTP_X_FORWARDED_FOR");
                }

                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = req.getRemoteAddr();
                }

                return ip;
            }
        }
    }

    public static String getMac() {
        return null;
    }
}
