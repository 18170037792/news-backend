package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.banner.IndexBannerEntity;

import java.util.List;

/**
 * Created by qujie on 2019/1/21
 * 首页轮播业务层
 * */
public interface IndexBannerService {

    /**
     * 查询首页轮播文章信息
     * @throws Exception
     * */
    List<IndexBannerEntity> getHomeArticleBanner() throws Exception;
}
