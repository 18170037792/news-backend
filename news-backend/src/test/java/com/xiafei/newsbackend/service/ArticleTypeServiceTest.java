package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.dao.ArticleTypeDao;
import com.xiafei.newsbackend.entity.type.ArticleTypeEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by qujie on 2019/1/7
 * 文章分类模块测试
 * */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleTypeServiceTest {

    @Autowired
    private ArticleTypeService typeService;

    @Test
    public void getTypeList() throws Exception{
        List<ArticleTypeEntity> list = typeService.getTypeList();
        System.out.println(list);
    }
}
