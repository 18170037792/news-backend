package com.xiafei.newsbackend.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qujie on 2018/1/4
 * 用户个人信息控制器
 * */
@Controller
@RequestMapping("/user")
public class UserProfileController {


    @GetMapping("/profile")
    public String profile(){
        return "user/profile";
    }
}
