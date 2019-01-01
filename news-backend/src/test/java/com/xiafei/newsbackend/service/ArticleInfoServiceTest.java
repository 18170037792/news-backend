package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.article.ArticleAndTypeEntity;
import com.xiafei.newsbackend.entity.article.ArticleInfoEntity;
import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by qujie on 2018/12/20
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
}
