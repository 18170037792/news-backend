package com.xiafei.newsbackend.controller.user;

import com.xiafei.newsbackend.controller.BaseController;
import com.xiafei.newsbackend.entity.article.ArticleAndTypeEntity;
import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.entity.type.ArticleTypeEntity;
import com.xiafei.newsbackend.service.ArticleInfoService;
import com.xiafei.newsbackend.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user/article")
public class ArticleInfoController extends BaseController {

    @Autowired
    private ArticleInfoService service;
    @Autowired
    private ArticleTypeService typeService;

    /**
     * 文章管理分页列表
     * @param current 当前页
     * @param row 分页条数
     * @throws Exception
     * */
    @GetMapping("/list")
    public String articleList(@RequestParam(value = "current", defaultValue = "1") int current,
                              @RequestParam(value = "row", defaultValue = "7") int row,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
        Long userId = this.getUserId(request, response);
        PageLimitEntity limitEntity = new PageLimitEntity();
        limitEntity.setCurrent(current);
        limitEntity.setRow(row);
        ArticleInfoSearchEntity searchEntity = new ArticleInfoSearchEntity();
        searchEntity.setUserId(userId);
        searchEntity.setLimitEntity(limitEntity);

        PageShowEntity<ArticleAndTypeEntity> showEntity = service.getArticleWithPage(searchEntity);
        request.setAttribute("articles",showEntity);

        return "user/article_list";
    }

    /**
     * 文章发表页
     * */
    @GetMapping("/publish")
    public String newArticle(HttpServletRequest request) throws Exception {
        List<ArticleTypeEntity> typeList = typeService.getTypeList();
        request.setAttribute("types",typeList);
        return "user/article_edit";
    }

    /**
     * 文章编辑页
     * @param id
     * */
    @GetMapping(value = "/{id}")
    public String editArticle(@PathVariable Long id,HttpServletRequest request) throws Exception {
        ArticleAndTypeEntity articleInfo = service.getArticleInfo(id);
        request.setAttribute("contents", articleInfo);
        List<ArticleTypeEntity> typeList = typeService.getTypeList();
        request.setAttribute("types",typeList);
        return "user/article_edit";
    }
}
