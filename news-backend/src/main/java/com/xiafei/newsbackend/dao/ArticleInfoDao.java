package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.pojo.table.ArticleInfoTable;
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
     * 根据登录人id获取列表
     * @param searchEntity
     * */
    List<ArticleInfoTable> getActicleList(ArticleInfoSearchEntity searchEntity);

    /**
     * 无参获取所有文章
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

}
