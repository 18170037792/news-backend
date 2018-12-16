package com.xiafei.newsbackend.util;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by qujie on 2018/12/16
 * 一些公共的方法集合,final
 * 修饰,不允许被继承
 * */
@Component
public final class Common {

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
}
