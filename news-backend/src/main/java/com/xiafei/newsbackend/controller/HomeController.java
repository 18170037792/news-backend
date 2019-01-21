package com.xiafei.newsbackend.controller;

import com.xiafei.newsbackend.entity.article.ArticleAndTypeEntity;
import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.entity.banner.IndexBannerEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import com.xiafei.newsbackend.service.ArticleInfoService;
import com.xiafei.newsbackend.service.IndexBannerService;
import com.xiafei.newsbackend.service.UserInfoService;
import com.xiafei.newsbackend.util.Constant;
import com.xiafei.newsbackend.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ArticleInfoService articleInfoService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private IndexBannerService bannerService;

//    @GetMapping("/ueditor")
//    public String showPage(){
//        return "index";
//    }

    /**
     * 首页信息和文章列表分页
     * @param current
     * @param row
     * @param request
     * @throws Exception
     * */
    @GetMapping("/index")
    public String index(@RequestParam(value = "current", defaultValue = "1") int current,
                        @RequestParam(value = "row", defaultValue = "6") int row, HttpServletRequest request) throws Exception{
        PageLimitEntity pageLimitEntity = new PageLimitEntity();
        pageLimitEntity.setCurrent(current);
        pageLimitEntity.setRow(row);

        PageShowEntity<ArticleAndTypeEntity> homeArticleWithPage = articleInfoService.getHomeArticleWithPage(pageLimitEntity);
        /**
         * 首页轮播信息列表
         * */
        List<IndexBannerEntity> bannerEntities = bannerService.getHomeArticleBanner();

        request.setAttribute("articles",homeArticleWithPage);
        request.setAttribute("banners",bannerEntities);

        return "home/index";
    }

    @GetMapping("/contact")
    public String contact(){
        return "home/contact";
    }

    /**
     * 根据作者id查询作者信息和文章分页信息
     * @param authorId 作者id
     * @throws Exception
     * */
    @GetMapping("/about")
    public String about(@RequestParam ("authorId") Long authorId,HttpServletRequest request) throws Exception {
        UserInfoEntity entity = userInfoService.getUserByAuthorId(authorId);
        List<ArticleAndTypeEntity> entities = articleInfoService.getArticleListByAuthorId(authorId);

        request.setAttribute("author",entity);
        request.setAttribute("articles",entities);
        return "home/about";
    }

    /**
     * 根据文章id查询单个文章信息
     * */
    @GetMapping("/single")
    public String single(@RequestParam ("articleId") Long articleId, HttpServletRequest request) throws Exception {
        ArticleAndTypeEntity articleInfo = articleInfoService.getArticleInfo(articleId);
        request.setAttribute("article",articleInfo);
        return "home/single";
    }

}
