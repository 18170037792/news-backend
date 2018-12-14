package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.log.LogInfoAddEntity;

/**
 * Created by qujie on 2018/12/14
 * */
public interface LogInfoService {

    void insertLog(LogInfoAddEntity addEntity) throws Exception;
}
