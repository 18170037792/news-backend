package com.xiafei.newsbackend.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qujie on 2018/12/10
 * 转换日期格式类
 * */
public class DateFormatUtil {

    /**
     * 转换中文日期格式
     * @param date
     * @return
     * @throws Exception
     */
    public static String formatFullDate(Date date) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        return sdf.format(date);
    }
    /**
     * 转换日期全格式
     * @param date
     * @return
     * @throws Exception
     */
    public static Date formatFullString(String date) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(date);
    }

    /**
     * 生日日期格式转换 String --->Date
     */
    public static Date parseBirthdayDate(String birthday) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(birthday);
    }

    /**
     * 生日日期格式转换  Date--->String
     */
    public static String formatBirthdayDate(Date birthday) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(birthday);
    }

    public static void main(String[] args) throws Exception {
        String date = formatFullDate(new Date());
        System.out.println(date);
    }
}
