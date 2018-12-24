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
public class AdminIndexController extends BaseController{

    @Autowired
    private WebSiteService webSiteService;
    @Autowired
    private ArticleInfoService articleInfoService;
    @Autowired
    private LogInfoService logInfoService;

    /**
     * 首页跳转
     * @param request
     * @throws Exception
     * */
    @GetMapping("/index")
    public String index(HttpServletRequest request) throws Exception{

        /**
         * 通过request作用域向前端传参
         * */
        StatisticsEntity statistics = webSiteService.getAdminStatistics();
        request.setAttribute("statistics",statistics);
        return "admin/index";
    }
}
