package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.pojo.view.IndexBannerView;

import java.util.List;

/**
 * Created by qujie on 2019/1/21
 * 首页轮播持久层接口
 * */
public interface IndexBannerDao {

    /**
     * 查询首页轮播文章信息
     * */
    List<IndexBannerView> getHomeArticleBanner();
}
