package com.xiafei.newsbackend.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qujie on 2019/1/30
 * 管理员分类管理控制器
 * */
@Controller
@RequestMapping("/admin/category")
public class ArticleTypeController {

    @GetMapping("")
    public String categoryList(){
        return "admin/category";
    }


}
