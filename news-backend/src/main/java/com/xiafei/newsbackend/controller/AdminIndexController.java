package com.xiafei.newsbackend.controller;

import com.xiafei.newsbackend.entity.article.ArticleInfoEntity;
import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.entity.datas.StatisticsEntity;
import com.xiafei.newsbackend.service.ArticleInfoService;
import com.xiafei.newsbackend.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminIndexController extends BaseController{

    @Autowired
    private WebSiteService webSiteService;
    @Autowired
    private ArticleInfoService articleInfoService;

    @GetMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Long userId = this.getUserId(request, response);
        List<ArticleInfoEntity> acticleList = articleInfoService.getActicleList(userId);

        StatisticsEntity statistics = webSiteService.getStatistics(userId);
        request.setAttribute("statistics",statistics);
        request.setAttribute("acticleList",acticleList);
        return "admin/index";
    }
}
