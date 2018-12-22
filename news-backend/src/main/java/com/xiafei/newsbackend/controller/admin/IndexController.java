package com.xiafei.newsbackend.controller.admin;

import com.xiafei.newsbackend.controller.BaseController;
import com.xiafei.newsbackend.entity.article.ArticleInfoEntity;
import com.xiafei.newsbackend.entity.datas.StatisticsEntity;
import com.xiafei.newsbackend.entity.log.LogInfoEntity;
import com.xiafei.newsbackend.service.ArticleInfoService;
import com.xiafei.newsbackend.service.LogInfoService;
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
public class IndexController extends BaseController{

    @Autowired
    private WebSiteService webSiteService;
    @Autowired
    private ArticleInfoService articleInfoService;
    @Autowired
    private LogInfoService logInfoService;

    @GetMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Long userId = this.getUserId(request, response);
        List<ArticleInfoEntity> acticleList = articleInfoService.getActicleList(userId);
        List<LogInfoEntity> logInfoList = logInfoService.getLogInfoList(userId);

        StatisticsEntity statistics = webSiteService.getStatistics(userId);
        request.setAttribute("statistics",statistics);
        request.setAttribute("acticleList",acticleList);
        request.setAttribute("logInfoList",logInfoList);
        return "admin/index";
    }
}
