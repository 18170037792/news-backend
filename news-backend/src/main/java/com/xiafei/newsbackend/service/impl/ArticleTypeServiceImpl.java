package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.dao.ArticleTypeDao;
import com.xiafei.newsbackend.entity.type.ArticleTypeEntity;
import com.xiafei.newsbackend.pojo.table.ArticleInfoTable;
import com.xiafei.newsbackend.pojo.table.ArticleTypeTable;
import com.xiafei.newsbackend.service.ArticleTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qujie on 2018/1/7
 * 文章分类业务层
 * */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypeDao typeDao;

    /**
     * 拉取文章分类列表
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ArticleTypeEntity> getTypeList() throws Exception {
        List<ArticleTypeTable> tables = typeDao.getTypeList();
        if(tables == null || tables.size() == 0){
            return null;
        }

        List<ArticleTypeEntity> entities = new ArrayList<>();
        for (ArticleTypeTable table:tables
             ) {
            ArticleTypeEntity entity = new ArticleTypeEntity();
            BeanUtils.copyProperties(table,entity);
            entities.add(entity);
        }
        return entities;
    }
}
