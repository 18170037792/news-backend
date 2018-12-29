package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.pojo.table.ArticleInfoTable;
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
        List<ArticleInfoTable> tables = dao.getArticleAllBySearch(searchEntity);
        System.out.println(tables);
    }
}
