package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.dao.UserInfoDao;
import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import com.xiafei.newsbackend.entity.user.UserLogEntity;
import com.xiafei.newsbackend.entity.user.UserLoginEntity;
import com.xiafei.newsbackend.exception.ServiceException;
import com.xiafei.newsbackend.pojo.table.UserInfoTable;
import com.xiafei.newsbackend.pojo.view.UserInfoView;
import com.xiafei.newsbackend.pojo.view.UserLogView;
import com.xiafei.newsbackend.service.UserInfoService;
import com.xiafei.newsbackend.util.Constant;
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
    @Transactional(rollbackFor = Exception.class)
    public UserInfoEntity login(UserLoginEntity loginEntity) throws Exception {
        if(ValidateUtil.isNull(loginEntity.getName())||ValidateUtil.isNull(loginEntity.getPwd())){
            throw new ServiceException(Constant.LOGIN_NULL);
        }
        //md5加密密码
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
    @Transactional(rollbackFor = Exception.class)
    public List<UserLogEntity> getUserList() throws Exception {
        List<UserLogView> views = dao.getUserList();
        if(views == null || views.size()==0){
            throw new ServiceException(Constant.SYSTEM_ERROR);
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


}
