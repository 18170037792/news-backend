package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.dao.ArticleInfoDao;
import com.xiafei.newsbackend.dao.LinksInfoDao;
import com.xiafei.newsbackend.dao.MessageInfoDao;
import com.xiafei.newsbackend.dao.UserInfoDao;
import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.entity.datas.StatisticsEntity;
import com.xiafei.newsbackend.exception.ServiceException;
import com.xiafei.newsbackend.service.WebSiteService;
import com.xiafei.newsbackend.util.Constant;
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
    @Autowired
    private MessageInfoDao messageInfoDao;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private LinksInfoDao linksInfoDao;

    /**
     * 加载用户的统计数据
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public StatisticsEntity getStatistics(Long userId) throws Exception {
        if(userId == null){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
        StatisticsEntity statisticsEntity = new StatisticsEntity();

        int articles = articleInfoDao.getCount(userId);
        int messages = messageInfoDao.getCount(userId);

        statisticsEntity.setArticles(articles);
        statisticsEntity.setMessages(messages);
        return statisticsEntity;
    }

    /**
     * 加载管理员的统计数据
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public StatisticsEntity getAdminStatistics() throws Exception {
        StatisticsEntity statisticsEntity = new StatisticsEntity();
        int articleCount = articleInfoDao.getArticleCount();
        int countUser = userInfoDao.CountUser();
        int linksCount = linksInfoDao.getLinksCount();

        statisticsEntity.setArticles(articleCount);
        statisticsEntity.setLinks(linksCount);
        statisticsEntity.setUsers(countUser);
        return statisticsEntity;
    }
}
