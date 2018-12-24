package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.datas.StatisticsEntity;

/**
 * Created by qujie on 2018/12/19
 * */
public interface WebSiteService {

    /**
     * 获取用户的统计数据
     * */
    StatisticsEntity getStatistics(Long userId) throws Exception;

    /**
     * 获取管理员的统计数据
     * */
    StatisticsEntity getAdminStatistics() throws Exception;
}
