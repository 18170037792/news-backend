package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.dao.ArticleInfoDao;
import com.xiafei.newsbackend.entity.article.*;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.exception.ServiceException;
import com.xiafei.newsbackend.pojo.table.ArticleInfoTable;
import com.xiafei.newsbackend.pojo.view.ArticleTypeView;
import com.xiafei.newsbackend.service.ArticleInfoService;
import com.xiafei.newsbackend.util.Constant;
import com.xiafei.newsbackend.util.FormatPage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {

    @Autowired
    private ArticleInfoDao dao;

    /**
     * 登录用户最近发表的文章
     * @param userId
     * */
    @Override
    public List<ArticleInfoEntity> getActicleList(Long userId) throws Exception{
        if(userId == null){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
        ArticleInfoSearchEntity searchEntity = new ArticleInfoSearchEntity();
        searchEntity.setUserId(userId);

        List<ArticleInfoTable> tables = dao.getActicleList(searchEntity);
        if(tables == null || tables.size() == 0){
            return null;
        }
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

    /**
     * 获取所有用户最近发表的文章
     * */
    @Override
    public List<ArticleInfoEntity> getArticleAll() throws Exception {
        List<ArticleInfoTable> tables = dao.getArticleAll();
        if(tables == null || tables.size() == 0){
            return null;
        }
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

    /**
     * 根据登录人id获取文章列表
     * @param searchEntity
     * @throws Exception
     * @return ArticleInfoEntity
     * */
    @Override
    public List<ArticleAndTypeEntity> getArticleAllBySearch(ArticleInfoSearchEntity searchEntity) throws Exception {
        List<ArticleTypeView> views = dao.getArticleAllBySearch(searchEntity);
        if(views == null || views.size() == 0){
            return null;
        }
        List<ArticleAndTypeEntity> entities = new ArrayList<>();
        for (ArticleTypeView view: views
        ) {
            ArticleAndTypeEntity entity = new ArticleAndTypeEntity();
            BeanUtils.copyProperties(view,entity);
            entities.add(entity);
        }
        return entities;
    }

    /**
     * 根据登录人id获取文章分页信息
     * @param searchEntity
     * @throws Exception
     * @return ArticleAndTypeEntity
     * */
    @Override
    public PageShowEntity<ArticleAndTypeEntity> getArticleWithPage(ArticleInfoSearchEntity searchEntity) throws Exception {
        /**
         * 统计数据
         * */
        int count = dao.getCount(searchEntity.getUserId());
        PageShowEntity showEntity = FormatPage.format(searchEntity.getLimitEntity(), count);
        if(count <= 0){
            return null;
        }
        List<ArticleAndTypeEntity> andTypeEntityList = this.getArticleAllBySearch(searchEntity);
        showEntity.setData(andTypeEntityList);
        return showEntity;
    }

    /**
     * 获取前台首页所有文章分页信息
     * @param pageLimitEntity
     * @throws Exception
     * @return ArticleAndTypeEntity
     * */
    @Override
    public PageShowEntity<ArticleAndTypeEntity> getHomeArticleWithPage(PageLimitEntity pageLimitEntity) throws Exception {
        /**
         * 统计数据
         * */
        int count = dao.getArticleCount();
        PageShowEntity showEntity = FormatPage.format(pageLimitEntity, count);
        if(count<=0){
            return null;
        }

        /**
         * 分页数据
         * */
        List<ArticleTypeView> views = dao.getHomeArticleAll(pageLimitEntity);
        List<ArticleAndTypeEntity> entities = new ArrayList<>();
        for (ArticleTypeView view:views
             ) {
            ArticleAndTypeEntity entity = new ArticleAndTypeEntity();
            BeanUtils.copyProperties(view,entity);
            entity.setMessageCount(dao.getMessageCount(entity.getAddUser(),entity.getId()));
            entities.add(entity);
        }

        showEntity.setData(entities);
        return showEntity;
    }

    /**
     * 单个文章信息详情
     * @param articleId
     * @throws Exception
     * */
    @Override
    public ArticleAndTypeEntity getArticleInfo(Long articleId) throws Exception {
        ArticleTypeView view = dao.getArticleInfo(articleId);
        if(view == null){
            throw new ServiceException(Constant.ARTICLE_IS_NULL);
        }

        if(view != null && view.getStatus() == 2){
            throw new ServiceException(Constant.PUBLISH_NOT);
        }

        ArticleAndTypeEntity entity = new ArticleAndTypeEntity();
        BeanUtils.copyProperties(view,entity);
        return entity;
    }

    /**
     * 前台作者介绍页根据作者id获取文章列表信息
     * @param authorId
     * @throws Exception
     * */
    @Override
    public List<ArticleAndTypeEntity> getArticleListByAuthorId(Long authorId) throws Exception {
        List<ArticleTypeView> views = dao.getArticleListByAuthorId(authorId);
        if(views == null || views.size() == 0){
            return null;
        }
        List<ArticleAndTypeEntity> entities = new ArrayList<>();
        for (ArticleTypeView view: views
        ) {
            ArticleAndTypeEntity entity = new ArticleAndTypeEntity();
            BeanUtils.copyProperties(view,entity);
            entity.setMessageCount(dao.getMessageCount(authorId,entity.getId()));
            entities.add(entity);
        }
        return entities;
    }

    /**
     * 发布文章
     * @param publishEntity
     * @throws Exception
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void publishArticle(ArticlePublishEntity publishEntity) throws Exception {
        /**
         * 文章发布实体赋值给数据库实体
         * publish -> table
         * */
        ArticleInfoTable table = new ArticleInfoTable();
        BeanUtils.copyProperties(publishEntity,table);
        /**
         * 新增文章
         * */
        int result = dao.addArticle(table);
        if(result <1){
            throw new ServiceException(Constant.PUBLISH_FAILED);
        }
    }

    /**
     * 编辑文章
     * @param modifyEntity
     * @throws Exception
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyArticle(ArticleModifyEntity modifyEntity) throws Exception {
        /**
         * 拷贝赋值
         * */
        ArticleInfoTable table = new ArticleInfoTable();
        BeanUtils.copyProperties(modifyEntity,table);

        /**
         * 修改文章
         * */
        int count = dao.updateArticle(table);
        if(count <1){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
    }

    /**
     * 删除文章
     * @param id
     * @throws Exception
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteArticle(Long id) throws Exception {
        /**
         * 判断文章是否存在
         * */
        int result = dao.isExist(id);
        if(result <1){
            throw new ServiceException(Constant.WAIT_AGAIN);
        }

        /**
         * 删除文章并判断数量级
         * */
        int count = dao.deleteArticle(id);
        if(count <1){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
    }

    /**
     * 文章预览
     * @param articleId
     * @throws Exception
     * */
    @Override
    public ArticleAndTypeEntity previewArticle(Long articleId) throws Exception {
        ArticleTypeView view = dao.getArticleInfo(articleId);
        if(view == null){
            throw  new ServiceException(Constant.ARTICLE_IS_NULL);
        }

        ArticleAndTypeEntity entity = new ArticleAndTypeEntity();
        BeanUtils.copyProperties(view,entity);
        return entity;
    }

}
