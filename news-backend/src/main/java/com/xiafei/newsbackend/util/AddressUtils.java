package com.xiafei.newsbackend.util;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by qujie on 2018/12/22
 * 根据IP地址获取详细的地域信息
 * */
public class AddressUtils {



    public static StringBuffer getIpDescr(String ipAddress){
        try
        {
            String strIP = ipAddress;
            URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + strIP);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line = null;
            StringBuffer result = new StringBuffer();
            while((line = reader.readLine()) != null)
            {
                result.append(line);
            }
            reader.close();
            String jsonResult=result.toString();
            JSONObject jsonObject=JSONObject.fromObject(jsonResult);
            JSONObject jsonObject1=(JSONObject)jsonObject.get("data");
            String country = jsonObject1.get("country").toString();
            String area =jsonObject1.get("area").toString();
            String region =jsonObject1.get("region").toString();
            String city =jsonObject1.get("city").toString();
            String isp =jsonObject1.get("isp").toString();
            StringBuffer descr = new StringBuffer();
            descr.append(region).append(" ").append(city).append(" ").append(isp);
            return descr;
        }
        catch( IOException e)
        {
            return null;
        }

    }

    public static void main(String[] args){
        StringBuffer ipDescr = AddressUtils.getIpDescr("47.99.120.167");
        String ss = ipDescr.toString();
        System.out.println(ss);
    }

}
