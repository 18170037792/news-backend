package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.type.ArticleTypeAddEntity;
import com.xiafei.newsbackend.entity.type.ArticleTypeEntity;
import com.xiafei.newsbackend.entity.type.ArticleTypeModifyEntity;

import java.util.List;

/**
 * Created by qujie on 2019/1/7
 * */
public interface ArticleTypeService {

    /**
     * 获取分类列表
     * @throws Exception
     * @return
     * */
    List<ArticleTypeEntity> getTypeList() throws Exception;

    /**
     * 删除文章分类
     * @param id
     * @throws Exception
     * */
    void deleteCategory(Long id) throws Exception;

    /**
     * 新增文章分类
     * */
    void addCategory(ArticleTypeAddEntity addEntity) throws Exception;

    /**
     * 修改文章分类
     * @param modifyEntity
     * @throws Exception
     * */
    void modifyCategory(ArticleTypeModifyEntity modifyEntity) throws Exception;
}
