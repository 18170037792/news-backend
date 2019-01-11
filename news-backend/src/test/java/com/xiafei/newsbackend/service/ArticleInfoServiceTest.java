package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.article.ArticleAndTypeEntity;
import com.xiafei.newsbackend.entity.article.ArticleInfoEntity;
import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.entity.article.ArticlePublishEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by qujie on 2018/12/20
 * 文章信息模块测试
 * */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleInfoServiceTest {

    @Autowired
    private ArticleInfoService service;

    @Test
    public void getList() throws Exception{
        List<ArticleInfoEntity> acticleList = service.getActicleList(1L);
        System.out.println(acticleList);
    }

    @Test
    public void getArticleAll() throws Exception{
        List<ArticleInfoEntity> entities = service.getArticleAll();
        System.out.println(entities);
    }

    /**
     * 根据登录人id获取文章列表
     * */
    @Test
    public void getArticleAllBySearch() throws Exception{
        ArticleInfoSearchEntity searchEntity = new ArticleInfoSearchEntity();
        searchEntity.setUserId(1L);
        PageLimitEntity pageLimitEntity = new PageLimitEntity();
        pageLimitEntity.setCurrent(1);
        pageLimitEntity.setRow(5);
        searchEntity.setLimitEntity(pageLimitEntity);
        List<ArticleAndTypeEntity> entities = service.getArticleAllBySearch(searchEntity);
        System.out.println(entities);
    }

    /**
     * 根据登录人id获取文章分页信息
     * */
    @Test
    public void getArticleWithPage() throws Exception{
        ArticleInfoSearchEntity searchEntity = new ArticleInfoSearchEntity();
        searchEntity.setUserId(1L);
        PageLimitEntity pageLimitEntity = new PageLimitEntity();
        pageLimitEntity.setCurrent(1);
        pageLimitEntity.setRow(5);
        searchEntity.setLimitEntity(pageLimitEntity);
        PageShowEntity<ArticleAndTypeEntity> showEntity = service.getArticleWithPage(searchEntity);
        System.out.println(showEntity);
    }

    /**
     * 获取前台首页所有文章分页信息
     * */
    @Test
    public void getHomeArticleWithPage() throws Exception{
        PageLimitEntity pageLimitEntity = new PageLimitEntity();
        pageLimitEntity.setCurrent(1);
        pageLimitEntity.setRow(5);

        PageShowEntity<ArticleAndTypeEntity> homeArticleWithPage = service.getHomeArticleWithPage(pageLimitEntity);
        System.out.println(homeArticleWithPage);
    }

    /**
     * 单个文章信息详情
     * */
    @Test
    public void getArticle() throws Exception{
        ArticleAndTypeEntity articleInfo = service.getArticleInfo(1L);
        System.out.println(articleInfo);
    }

    /**
     * 前台作者介绍页根据作者id获取文章列表信息
     * */
    @Test
    public void getArticleListByAuthorId()throws Exception{
        List<ArticleAndTypeEntity> entities = service.getArticleListByAuthorId(6L);
        System.out.println(entities);
    }

    /**
     * 发布文章
     * */
    @Test
    public void publishArticle() throws Exception{
        ArticlePublishEntity publishEntity = new ArticlePublishEntity();
        publishEntity.setTitle("红楼梦");
        publishEntity.setSubtitle("111");
        publishEntity.setContent("222");
        publishEntity.setAddTime(new Date());

        service.publishArticle(publishEntity);
    }

    /**
     * 编辑文章
     * */

    /**
     * 删除文章
     * */
    @Test
    public void deleteArticle() throws Exception{
        service.deleteArticle(20L);
    }
}
