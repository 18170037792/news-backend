package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.dao.UserInfoDao;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.entity.user.*;
import com.xiafei.newsbackend.exception.ServiceException;
import com.xiafei.newsbackend.pojo.table.UserInfoTable;
import com.xiafei.newsbackend.pojo.view.UserInfoView;
import com.xiafei.newsbackend.pojo.view.UserLogView;
import com.xiafei.newsbackend.service.UserInfoService;
import com.xiafei.newsbackend.util.Constant;
import com.xiafei.newsbackend.util.FormatPage;
import com.xiafei.newsbackend.util.GetMD5;
import com.xiafei.newsbackend.util.ValidateUtil;
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
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao dao;

    /**
     * 用户登录
     * @param loginEntity
     * @return UserInfoEntity
     * @throws Exception
     * */
    @Override
    public UserInfoEntity login(UserLoginEntity loginEntity) throws Exception {
        if(ValidateUtil.isNull(loginEntity.getName())||ValidateUtil.isNull(loginEntity.getPwd())){
            throw new ServiceException(Constant.LOGIN_NULL);
        }
        /**
         * md5加密密码
         * */
        loginEntity.setPwd(GetMD5.getMD5(loginEntity.getPwd()));
        UserInfoView view = dao.login(loginEntity);
        if(view == null){
            throw new ServiceException(Constant.LOGIN_ERROR);
        }

        UserInfoEntity entity = new UserInfoEntity();
        BeanUtils.copyProperties(view,entity);
        return entity;
    }

    /**
     * 拉取用户信息列表
     * @throws Exception
     * */
    @Override
    public List<UserLogEntity> getUserList(PageLimitEntity limitEntity) throws Exception {
        List<UserLogView> views = dao.getUserList(limitEntity);
        if(views == null || views.size()==0){
            return null;
        }

        List<UserLogEntity> entities = new ArrayList<>();
        for (UserLogView view:views
             ) {
            UserLogEntity entity = new UserLogEntity();
            BeanUtils.copyProperties(view,entity);
            entities.add(entity);
        }
        return entities;
    }

    /**
     * 冻结用户
     * @param updateEntity
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void frozenUser(UserInfoUpdateEntity updateEntity) throws Exception {
        UserInfoTable table = new UserInfoTable();
        BeanUtils.copyProperties(updateEntity,table);
        int count = dao.updateFrozen(table);
        if(count <1){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
    }

    /**
     * 拉取用户分页数据列表
     * @param current
     * @param row
     * @throws Exception
     * */
    @Override
    public PageShowEntity<UserInfoEntity> getUserWithPage(int current, int row) throws Exception {
        /**
         * 分页条件
         * */
        PageLimitEntity limitEntity = new PageLimitEntity();
        limitEntity.setCurrent(current);
        limitEntity.setRow(row);

        /**
         * 统计数据
         * */
        int count = dao.countUserList();
        PageShowEntity showEntity = FormatPage.format(limitEntity, count);
        if(count <= 0){
            return null;
        }
        List<UserLogEntity> userList = this.getUserList(limitEntity);
        showEntity.setData(userList);

        return showEntity;
    }

    /**
     * 根据作者id查询作者信息
     * @param authorId
     * @throws Exception
     * */
    @Override
    public UserInfoEntity getUserByAuthorId(Long authorId) throws Exception {
        UserInfoTable table = dao.getUserByAuthorId(authorId);
        if(table == null){
            return null;
        }
        UserInfoEntity entity = new UserInfoEntity();
        BeanUtils.copyProperties(table,entity);
        switch (entity.getGender()){
            case 1:
                entity.setGenderStr("男");
                break;
            case 2:
                entity.setGenderStr("女");
                break;
            default :
                entity.setGenderStr("");
                break;
        }
        return entity;
    }

    /**
     * 根据用户id获取原密码
     * @param id
     * @throws Exception
     * */
    @Override
    public String getOldPwd(Long id) throws Exception {
        String oldPwd = dao.getOldPwd(id);
        if(ValidateUtil.isNull(oldPwd)){
            throw  new ServiceException(Constant.SYSTEM_ERROR);
        }
        return oldPwd;
    }

    /**
     * 修改密码
     * @param id 用户id
     * @param newPwd 新密码
     * @throws Exception
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePwd(Long id,String newPwd) throws Exception {
        UserInfoTable table = new UserInfoTable();
        table.setId(id);
        table.setPwd(GetMD5.getMD5(newPwd));
        dao.updatePwdById(table);
    }

    /**
     * 修改用户信息
     * @param entity
     * @throws Exception
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(UserInfoEntity entity) throws Exception {
        UserInfoTable table = new UserInfoTable();
        BeanUtils.copyProperties(entity,table);
        int count = dao.updateUser(table);
        if(count <1){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
    }

}
