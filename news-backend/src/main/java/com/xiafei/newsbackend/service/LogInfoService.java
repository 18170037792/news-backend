package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.log.LogInfoAddEntity;
import com.xiafei.newsbackend.entity.log.LogInfoEntity;

import java.util.List;

/**
 * Created by qujie on 2018/12/14
 * */
public interface LogInfoService {

    void insertLog(LogInfoAddEntity addEntity) throws Exception;

    List<LogInfoEntity> getLogInfoList(Long userId) throws Exception;
}
