package com.xiafei.newsbackend.controller.admin;

import com.xiafei.newsbackend.entity.type.ArticleTypeEntity;
import com.xiafei.newsbackend.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by qujie on 2019/1/30
 * 管理员分类管理控制器
 * */
@Controller
@RequestMapping("/admin/category")
public class ArticleTypeController {

    @Autowired
    ArticleTypeService typeService;

    @GetMapping("")
    public String categoryList(HttpServletRequest request) throws Exception{
        List<ArticleTypeEntity> typeList = typeService.getTypeList();
        request.setAttribute("categorys",typeList);
        return "admin/category";
    }

}
