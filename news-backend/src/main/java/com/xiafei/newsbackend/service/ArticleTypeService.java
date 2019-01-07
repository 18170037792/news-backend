package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.type.ArticleTypeEntity;

import java.util.List;

/**
 * Created by qujie on 2019/1/7
 * */
public interface ArticleTypeService {

    List<ArticleTypeEntity> getTypeList() throws Exception;
}
