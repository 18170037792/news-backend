package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.dao.ArticleTypeDao;
import com.xiafei.newsbackend.entity.type.ArticleTypeAddEntity;
import com.xiafei.newsbackend.entity.type.ArticleTypeEntity;
import com.xiafei.newsbackend.entity.type.ArticleTypeModifyEntity;
import com.xiafei.newsbackend.exception.ServiceException;
import com.xiafei.newsbackend.pojo.table.ArticleTypeTable;
import com.xiafei.newsbackend.service.ArticleTypeService;
import com.xiafei.newsbackend.util.Constant;
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

    /**
     * 删除文章分类
     * @param id
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCategory(Long id) throws Exception {
        /**
         * 删除前统计数量级
         * */
        int count = typeDao.getCategoryCount(id);
        if(count ==0){
            throw new ServiceException(Constant.COUNT_ZERO);
        }

        /**
         * 删除
         * */
        int result = typeDao.deleteCategory(id);
        if(result !=1){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
    }

    /**
     * 新增文章分类
     * @param addEntity
     * @throws Exception
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addCategory(ArticleTypeAddEntity addEntity) throws Exception {
        ArticleTypeTable table = new ArticleTypeTable();
        BeanUtils.copyProperties(addEntity,table);
        /**
         * 新增文章
         * */
        int result = typeDao.addCategory(table);
        if(result <1){
            throw new ServiceException(Constant.ADD_FAILED);
        }
    }

    /**
     * 修改文章分类
     * @param modifyEntity
     * @throws Exception
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyCategory(ArticleTypeModifyEntity modifyEntity) throws Exception {
        /**
         * 拷贝赋值
         * */
        ArticleTypeTable table = new ArticleTypeTable();
        BeanUtils.copyProperties(modifyEntity,table);

        /**
         * 修改文章
         * */
        int count = typeDao.updateCategory(table);
        if(count <1){
            throw new ServiceException(Constant.UPDATE_FAILED);
        }
    }
}
