package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.dao.LogInfoDao;
import com.xiafei.newsbackend.entity.log.LogInfoAddEntity;
import com.xiafei.newsbackend.entity.log.LogInfoEntity;
import com.xiafei.newsbackend.exception.ServiceException;
import com.xiafei.newsbackend.pojo.table.LogInfoTable;
import com.xiafei.newsbackend.service.LogInfoService;
import com.xiafei.newsbackend.util.Constant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qujie on 2018/12/14
 * */
@Service
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    private LogInfoDao dao;


    /**
     * 系统日志添加
     * @param addEntity
     * @throws Exception
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertLog(LogInfoAddEntity addEntity) throws Exception {
        LogInfoTable table = new LogInfoTable();
        BeanUtils.copyProperties(addEntity,table);
        int count = dao.insertLog(table);
        if(count <1){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
    }

    /**
     * 查询系统日志列表
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<LogInfoEntity> getLogInfoList(Long userId) throws Exception{
        if(userId == null){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
        List<LogInfoTable> tables = dao.getLogList(userId);
        List<LogInfoEntity> entities = new ArrayList<>();
        for (LogInfoTable table:tables
             ) {
            LogInfoEntity entity = new LogInfoEntity();
            BeanUtils.copyProperties(table,entity);
            entities.add(entity);
        }
        return entities;
    }
}
