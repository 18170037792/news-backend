package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.dao.ArticleInfoDao;
import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.entity.datas.StatisticsEntity;
import com.xiafei.newsbackend.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by qujie on 2018/12/19
 * 网站设置业务层
 * */
@Service
public class WebSiteServiceImpl implements WebSiteService{

    @Autowired
    private ArticleInfoDao articleInfoDao;

    /**
     * 加载统计数据
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public StatisticsEntity getStatistics(Long userId) throws Exception {

        StatisticsEntity statisticsEntity = new StatisticsEntity();

        int articles = articleInfoDao.getCount(userId);
        statisticsEntity.setArticles(articles);
        return statisticsEntity;
    }
}
