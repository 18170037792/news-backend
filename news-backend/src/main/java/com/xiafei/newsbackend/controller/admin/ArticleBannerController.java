package com.xiafei.newsbackend.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qujie on 2019/2/2
 * 管理员轮播管理控制器
 * */
@Controller
@RequestMapping("/admin/banner")
public class ArticleBannerController {


    @GetMapping("/list")
    public String banner(){
        return "admin/banner_list";
    }
}
