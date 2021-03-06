package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.entity.article.ArticlePublishEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.pojo.table.ArticleInfoTable;
import com.xiafei.newsbackend.pojo.view.ArticleTypeView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qujie on 2018/12/19
 * */
public interface ArticleInfoDao {

    /**
     * 根据登录用户统计文章数
     * @param userId
     * */
    int getCount(@Param("userId") Long userId);

    /**
     * 根据登录人id获取最新五篇文章
     * @param searchEntity
     * */
    List<ArticleInfoTable> getActicleList(ArticleInfoSearchEntity searchEntity);

    /**
     * 无参获取管理员日志的最新五篇文章
     * */
    List<ArticleInfoTable> getArticleAll();

    /**
     * 获取留言记录数
     * @param userId
     * @param articleId
     * */
    int getMessageCount(@Param("userId") Long userId,@Param("articleId") Long articleId);

    /**
     * 统计文章总数
     * */
    int getArticleCount();

    /**
     * 根据登录人id获取文章分页信息
     * @param searchEntity
     * @return ArticleTypeView
     * */
    List<ArticleTypeView> getArticleAllBySearch(ArticleInfoSearchEntity searchEntity);

    /**
     * 获取前台首页所有文章分页信息
     * @param pageLimitEntity
     * @return ArticleTypeView
     * */
    List<ArticleTypeView> getHomeArticleAll(PageLimitEntity pageLimitEntity);

    /**
     * 单个文章信息详情
     * @param articleId
     * @return ArticleTypeView
     * */
    ArticleTypeView getArticleInfo(@Param("articleId") Long articleId);

    /**
     * 前台作者介绍页根据作者id获取文章列表信息
     * @param authorId
     * @return ArticleTypeView
     * */
    List<ArticleTypeView> getArticleListByAuthorId(@Param("authorId") Long authorId);

    /**
     * 新增文章
     * @param table
     * @return int
     * */
    int addArticle(ArticleInfoTable table);

    /**
     * 修改文章
     * @param table
     * @return int
     * */
    int updateArticle(ArticleInfoTable table);

    /**
     * 根据id查询文章是否存在
     * */
    int isExist(@Param("id") Long id);

    /**
     * 删除文章
     * */
    int deleteArticle(@Param("id") Long id);
}
