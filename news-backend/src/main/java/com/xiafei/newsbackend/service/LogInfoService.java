package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.log.LogInfoAddEntity;
import com.xiafei.newsbackend.entity.log.LogInfoEntity;
import com.xiafei.newsbackend.entity.user.UserLogEntity;
import java.util.List;

/**
 * Created by qujie on 2018/12/14
 * */
public interface LogInfoService {

    void insertLog(LogInfoAddEntity addEntity) throws Exception;

    List<LogInfoEntity> getLogInfoList(Long userId) throws Exception;

    /**
     * 获取管理员日志的最新用户动态
     * @return UserLoginEntity
     * */
    List<UserLogEntity> getUserDynamic() throws Exception;

}
