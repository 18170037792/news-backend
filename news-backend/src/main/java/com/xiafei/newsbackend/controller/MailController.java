package com.xiafei.newsbackend.controller;

import com.xiafei.newsbackend.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created by qijie on 2018/2/12
 * 邮件发送服务控制器
 * */
@Controller
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/getCheckCode")
    @ResponseBody
    public String getCheckCode(String email){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为："+checkCode;
        try {
            mailService.sendSimpleMail(email, "注册验证码", message);
        }catch (Exception e){
            return "";
        }
        return checkCode;
    }
    
}
