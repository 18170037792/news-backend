package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.article.ArticleInfoEntity;
import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;

import java.util.List;

/**
 * Created by qujie on 2018/12/20
 * 文章信息业务层
 * */
public interface ArticleInfoService {

    /**
     * 登录用户最近发表的文章
     * */
    List<ArticleInfoEntity> getActicleList(Long userId) throws Exception;

    /**
     * 获取所有用户最近发表的文章
     * */
    List<ArticleInfoEntity> getArticleAll() throws Exception;
}
