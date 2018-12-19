package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by qujie on 2018/12/19
 * */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleInfoDaoTest {

    @Autowired
    private ArticleInfoDao dao;

    @Test
    public void getCount(){
        int count = dao.getCount(2L);
        if(count == 0){
            System.out.println("未找到数据");
        }else {
            System.out.println(count);
        }
    }
}
