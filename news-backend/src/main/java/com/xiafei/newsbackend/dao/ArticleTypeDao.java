package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.pojo.table.ArticleTypeTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qujie on 2019/1/7
 * */
public interface ArticleTypeDao {

    /**
     * 拉取文章分类列表
     * */
    List<ArticleTypeTable> getTypeList();

    /**
     * 删除文章分类
     * */
    int deleteCategory(@Param("id") Long id);

    /**
     * 查询存在数量
     * */
    int getCategoryCount(@Param("id") Long id);

    /**
     * 新增文章分类
     * @param table
     * @return int
     * */
    int addCategory(ArticleTypeTable table);

    /**
     * 修改文章分类
     * @param table
     * @return int
     * */
    int updateCategory(ArticleTypeTable table);
}
