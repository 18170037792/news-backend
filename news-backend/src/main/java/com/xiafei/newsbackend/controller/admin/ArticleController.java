package com.xiafei.newsbackend.controller.admin;

import com.xiafei.newsbackend.controller.BaseController;
import com.xiafei.newsbackend.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qujie on 2019/1/21
 * 管理员模块文章管理控制器
 * */
@Controller
@RequestMapping("/admin/article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleInfoService articleService;

    @GetMapping("/list")
    public String article(){
        return "admin/article_list";
    }

}
