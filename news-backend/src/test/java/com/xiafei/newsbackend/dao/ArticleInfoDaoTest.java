package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.entity.article.ArticlePublishEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.pojo.table.ArticleInfoTable;
import com.xiafei.newsbackend.pojo.view.ArticleTypeView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by qujie on 2018/12/19
 * */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleInfoDaoTest {

    @Autowired
    private ArticleInfoDao dao;

    /**
     * 统计文章数
     * */
    @Test
    public void getCount(){
        int count = dao.getCount(2L);
        if(count == 0){
            System.out.println("未找到数据");
        }else {
            System.out.println(count);
        }
    }

    /**
     * 统计此文章评论数
     * */
    @Test
    public void getMessageCount(){
        int messageCount = dao.getMessageCount(1L,1L);
        if(messageCount == 0){
            System.out.println("未找到数据");
        }else {
            System.out.println(messageCount);
        }
    }

    /**
     * 获取所有文章
     * */
    @Test
    public void getArticleAll(){
        List<ArticleInfoTable> tables = dao.getArticleAll();
        System.out.println(tables);
    }

    /**
     * 根据登录人id获取文章分页信息
     * */
    @Test
    public void getArticleAllByUserId(){
        ArticleInfoSearchEntity searchEntity = new ArticleInfoSearchEntity();
        searchEntity.setUserId(1L);
        PageLimitEntity pageLimitEntity = new PageLimitEntity();
        pageLimitEntity.setCurrent(1);
        pageLimitEntity.setRow(5);
        searchEntity.setLimitEntity(pageLimitEntity);
        List<ArticleTypeView> articleTypeViews = dao.getArticleAllBySearch(searchEntity);
        System.out.println(articleTypeViews);
    }

    /**
     * 获取前台首页所有文章分页信息
     * */
    @Test
    public void getHomeArticleAll(){
        PageLimitEntity pageLimitEntity = new PageLimitEntity();
        pageLimitEntity.setCurrent(1);
        pageLimitEntity.setRow(5);
        List<ArticleTypeView> views = dao.getHomeArticleAll(pageLimitEntity);
        System.out.println(views);
    }

    /**
     * 单个文章信息详情
     * */
    @Test
    public void getArticleInfo(){
        ArticleTypeView view = dao.getArticleInfo(1L);
        System.out.println(view);
    }

    /**
     * 前台作者介绍页根据作者id获取文章分页信息
     * */
    @Test
    public void getArticleListByAuthorId(){
        List<ArticleTypeView> views = dao.getArticleListByAuthorId(6L);
        System.out.println(views);
    }

    /**
     * 新增文章
     * */
    @Test
    public void addArticle(){
        ArticleInfoTable table = new ArticleInfoTable();
        table.setTitle("三国演义");
        table.setSubtitle("传奇巨作");
        table.setContent("讲的刘关张和梁山泊一百零八将的故事");
        table.setTypeId(1L);

        int count = dao.addArticle(table);
        if(count <1){
            System.out.println("新增失败");
        }
    }
}
