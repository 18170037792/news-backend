package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.datas.StatisticsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by qujie on 2018/12/20
 * */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class WebSiteServiceTest {

    @Autowired
    private WebSiteService siteService;

    @Test
    public void getStatistics() throws Exception{
        StatisticsEntity statistics = siteService.getStatistics(1L);
        System.out.println(statistics);
    }
}
