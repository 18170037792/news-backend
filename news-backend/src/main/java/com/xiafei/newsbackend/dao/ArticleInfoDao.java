package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.pojo.table.ArticleInfoTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qujie on 2018/12/19
 * */
public interface ArticleInfoDao {

    Integer getCount(@Param("userId") Long userId);

    /**
     * 根据登录人id获取列表
     * */
    List<ArticleInfoTable> getActicleList(ArticleInfoSearchEntity searchEntity);
}
