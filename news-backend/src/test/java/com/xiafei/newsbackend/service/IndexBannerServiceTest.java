package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.banner.IndexBannerEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by qujie on 2019/1/21
 * 首页轮播业务测试
 * */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class IndexBannerServiceTest {

    @Autowired
    private IndexBannerService bannerService;

    @Test
    public void getHomeArticleBanner() throws Exception{
        List<IndexBannerEntity> entities = bannerService.getHomeArticleBanner();
        System.out.println(entities);
    }
}
