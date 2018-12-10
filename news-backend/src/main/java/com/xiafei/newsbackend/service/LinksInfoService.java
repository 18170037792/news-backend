package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.links.LinksInfoAddEntity;
import com.xiafei.newsbackend.entity.links.LinksInfoEntity;

import java.util.List;

/**
 * Created by qujie on 2018/12/10
 * */
public interface LinksInfoService {
    void insert(LinksInfoAddEntity entity) throws Exception;

    List<LinksInfoEntity> getList() throws Exception;
}
