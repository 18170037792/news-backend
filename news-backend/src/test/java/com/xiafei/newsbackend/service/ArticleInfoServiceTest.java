package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.article.ArticleInfoEntity;
import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
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
}
