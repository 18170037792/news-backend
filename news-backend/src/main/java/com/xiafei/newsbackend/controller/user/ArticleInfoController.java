package com.xiafei.newsbackend.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/article")
public class ArticleInfoController {

    @RequestMapping("/publish")
    public String article(){
        return "user/article_edit";
    }

    @RequestMapping("/list")
    public String list(){
        return "user/article_list";
    }
}
