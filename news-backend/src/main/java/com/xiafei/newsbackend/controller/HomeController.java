package com.xiafei.newsbackend.controller;

import com.xiafei.newsbackend.entity.article.ArticleAndTypeEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.service.ArticleInfoService;
import com.xiafei.newsbackend.util.Constant;
import com.xiafei.newsbackend.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private ArticleInfoService articleInfoService;

    /**
     * 首页信息和文章列表分页
     * @param current
     * @param row
     * @param request
     * @throws Exception
     * */
    @GetMapping("/index")
    public String index(@RequestParam(value = "current", defaultValue = "1") int current,
                        @RequestParam(value = "row", defaultValue = "5") int row, HttpServletRequest request) throws Exception{
        PageLimitEntity pageLimitEntity = new PageLimitEntity();
        pageLimitEntity.setCurrent(current);
        pageLimitEntity.setRow(row);

        PageShowEntity<ArticleAndTypeEntity> homeArticleWithPage = articleInfoService.getHomeArticleWithPage(pageLimitEntity);

        request.setAttribute("articles",homeArticleWithPage);

        return "home/index";
    }

    @GetMapping("/contact")
    public String contact(){
        return "home/contact";
    }

    @GetMapping("/about")
    public String about(){
        return "home/about";
    }

    @GetMapping("/single")
    public String single(@RequestParam ("articleId") Long articleId, HttpServletRequest request) throws Exception {
        ArticleAndTypeEntity articleInfo = articleInfoService.getArticleInfo(articleId);
        request.setAttribute("article",articleInfo);
        return "home/single";
    }

    @PostMapping("/single/article")
    @ResponseBody
    public JsonResult singleArticle(Long articleId,HttpServletRequest request) throws Exception {
        ArticleAndTypeEntity articleInfo = articleInfoService.getArticleInfo(articleId);
        request.setAttribute("article",articleInfo);
        return new JsonResult(Constant.SUCCESS_CODE,Constant.QUERY_SUCCESS);
    }
}
