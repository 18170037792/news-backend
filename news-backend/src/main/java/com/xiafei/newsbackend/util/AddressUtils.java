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



    public static String getIpDescr(String ipAddress){
        try
        {
            String strIP = ipAddress;

            if(strIP.equals("0:0:0:0:0:0:0:1") || strIP.equals("127.0.0.1")){
                return "localhost";
            }

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

            String descr = region + " " + city + " " + isp;
            return descr;

        } catch( Exception e) {
            return null;
        }

    }
}
