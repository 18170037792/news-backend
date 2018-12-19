package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.pojo.table.ArticleInfoTable;

import java.util.List;

/**
 * Created by qujie on 2018/12/19
 * */
public interface ArticleInfoDao {

    int getCount(ArticleInfoSearchEntity searchEntity);

    /**
     * 根据登录人id获取列表
     * */
    List<ArticleInfoTable> getActicleList(ArticleInfoSearchEntity searchEntity);
}
