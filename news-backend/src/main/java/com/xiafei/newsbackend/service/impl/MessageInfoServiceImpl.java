package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.dao.MessageInfoDao;
import com.xiafei.newsbackend.entity.message.MessageArticleEntity;
import com.xiafei.newsbackend.entity.message.MessageInfoSearchEntity;
import com.xiafei.newsbackend.entity.message.MessageInfoUpdateEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.exception.ServiceException;
import com.xiafei.newsbackend.pojo.table.MessageInfoTable;
import com.xiafei.newsbackend.pojo.view.MessageArticleView;
import com.xiafei.newsbackend.service.MessageInfoService;
import com.xiafei.newsbackend.util.Constant;
import com.xiafei.newsbackend.util.FormatPage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qujie on 2019/1/14
 * 留言管理业务层
 * */
@Service
public class MessageInfoServiceImpl implements MessageInfoService {

    @Autowired
    private MessageInfoDao messageInfoDao;

    @Override
    public PageShowEntity<MessageArticleEntity> getMessageWithPage(MessageInfoSearchEntity searchEntity) throws Exception {

        /**
         * 统计数据
         * */
        int count = messageInfoDao.getCount(searchEntity.getUserId());
        PageShowEntity showEntity = FormatPage.format(searchEntity.getLimitEntity(), count);
        if(count <= 0){
            showEntity.setData(null);
            return showEntity;
        }

        /**
         * 分页数据
         * */
        List<MessageArticleView> views = messageInfoDao.getMessagePageList(searchEntity);
        List<MessageArticleEntity> entities = new ArrayList<>();
        for (MessageArticleView view:views
             ) {
            MessageArticleEntity entity = new MessageArticleEntity();
            BeanUtils.copyProperties(view,entity);
            entities.add(entity);
        }

        /**
         * 赋值
         * */
        showEntity.setData(entities);
        return showEntity;
    }

    /**
     * 修改留言信息
     * @param updateEntity
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMessage(MessageInfoUpdateEntity updateEntity) throws Exception {
        /**
         * 赋值
         * */
        MessageInfoTable table = new MessageInfoTable();
        BeanUtils.copyProperties(updateEntity,table);

        int result = messageInfoDao.update(table);
        if(result <1){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
    }

    /**
     * 删除单个留言信息
     * @param id
     * @throws Exception
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delComment(Long id) throws Exception {
        /**
         * 判断是否存在
         * */
        int count = messageInfoDao.isExist(id);
        if(count <1){
            throw new ServiceException(Constant.WAIT_AGAIN);
        }

        /**
         * 执行删除
         * */
        int result = messageInfoDao.delete(id);
        if(result <1){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
    }
}
