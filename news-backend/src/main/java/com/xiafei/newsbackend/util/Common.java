package com.xiafei.newsbackend.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qujie on 2018/12/16
 * 一些公共的方法集合,final
 * 修饰,不允许被继承
 * */
@Component
public final class Common {

    private static final String[] COLORS = {"default", "primary", "success", "info", "warning", "danger", "inverse", "purple", "pink"};

    /**
     * 获取图片名随机数
     * @param max
     * @param str
     * @return 随机图片名
     */
    public static String random(int max, String str) {
        Random random = new Random();
        int bounds = random.nextInt(max) + 1;
        return bounds + str;
    }

    /**
     * 系统日期格式转换中文时间
     * @param date
     * @throws Exception
     * @return String
     * */
    public static String formatDate(Date date) throws Exception {
        return DateFormatUtil.formatFullDate(date);
    }

    /**
     * 正则截取图片路径集合
     * @param htmlStr
     * */
    public static List<String> getImgSrc(String htmlStr) {
        String img = "";
        Pattern p_image;
        Matcher m_image;
        List<String> pics = new ArrayList<String>();
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            img = img + "," + m_image.group();
            //匹配src
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        return pics;
    }

    /**
     * 获取第一张图片路径
     * @param htmlStr
     * */
    public static String getFirstImg(String htmlStr){
        List<String> imgSrc = getImgSrc(htmlStr);
        if(imgSrc ==null || imgSrc.size()<1){
            return null;
        }
        String firstImg = imgSrc.get(0);
        return firstImg;
    }

    /**
     * 颜色随机数
     * */
    public static String rand_color() {
        int r = rand(0, COLORS.length - 1);
        return COLORS[r];
    }

    public static int rand(int min, int max) {
        final Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }
}
