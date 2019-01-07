package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.pojo.table.ArticleTypeTable;

import java.util.List;

/**
 * Created by qujie on 2019/1/7
 * */
public interface ArticleTypeDao {

    /**
     * 拉取文章分类列表
     * */
    List<ArticleTypeTable> getTypeList();
}
