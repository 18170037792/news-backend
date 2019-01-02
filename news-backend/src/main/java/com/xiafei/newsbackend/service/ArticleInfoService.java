package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.article.ArticleAndTypeEntity;
import com.xiafei.newsbackend.entity.article.ArticleInfoEntity;
import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.pojo.view.ArticleTypeView;

import java.util.List;

/**
 * Created by qujie on 2018/12/20
 * 文章信息业务层
 * */
public interface ArticleInfoService {

    /**
     * 登录用户最近发表的文章
     * @throws Exception
     * @return ArticleInfoEntity
     * */
    List<ArticleInfoEntity> getActicleList(Long userId) throws Exception;

    /**
     * 获取所有用户最近发表的文章
     * @throws Exception
     * @return ArticleInfoEntity
     * */
    List<ArticleInfoEntity> getArticleAll() throws Exception;

    /**
     * 根据登录人id获取文章列表
     * @param searchEntity
     * @throws Exception
     * @return ArticleInfoEntity
     * */
    List<ArticleAndTypeEntity> getArticleAllBySearch(ArticleInfoSearchEntity searchEntity) throws Exception;

    /**
     * 根据登录人id获取文章分页信息
     * @param searchEntity
     * @throws Exception
     * @return ArticleAndTypeEntity
     * */
    PageShowEntity<ArticleAndTypeEntity> getArticleWithPage(ArticleInfoSearchEntity searchEntity) throws Exception;

    /**
     * 获取前台首页所有文章分页信息
     * @param pageLimitEntity
     * @throws Exception
     * @return ArticleAndTypeEntity
     * */
    PageShowEntity<ArticleAndTypeEntity> getHomeArticleWithPage(PageLimitEntity pageLimitEntity) throws Exception;

    /**
     * 单个文章信息详情
     * @param articleId
     * @throws Exception
     * */
    ArticleAndTypeEntity getArticleInfo(Long articleId) throws Exception;
}
