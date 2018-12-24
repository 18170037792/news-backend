package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.dao.ArticleInfoDao;
import com.xiafei.newsbackend.entity.article.ArticleInfoEntity;
import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.exception.ServiceException;
import com.xiafei.newsbackend.pojo.table.ArticleInfoTable;
import com.xiafei.newsbackend.service.ArticleInfoService;
import com.xiafei.newsbackend.util.Constant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {

    @Autowired
    private ArticleInfoDao dao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ArticleInfoEntity> getActicleList(Long userId) throws Exception{
        if(userId == null){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
        ArticleInfoSearchEntity searchEntity = new ArticleInfoSearchEntity();
        searchEntity.setUserId(userId);

        List<ArticleInfoTable> tables = dao.getActicleList(searchEntity);
        List<ArticleInfoEntity> entities = new ArrayList<>();
        for (ArticleInfoTable table: tables
             ) {
            ArticleInfoEntity entity = new ArticleInfoEntity();
            BeanUtils.copyProperties(table,entity);
            int messageCount = dao.getMessageCount(entity.getAddUser(),entity.getId());
            entity.setMessageCount(messageCount);
            entities.add(entity);
        }
        return entities;

    }
}
