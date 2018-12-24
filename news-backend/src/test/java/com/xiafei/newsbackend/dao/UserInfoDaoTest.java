package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.user.UserLoginEntity;
import com.xiafei.newsbackend.pojo.table.UserInfoTable;
import com.xiafei.newsbackend.pojo.view.UserInfoView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserInfoDaoTest {

    @Autowired
    private UserInfoDao dao;

    @Test
    public void login(){
        UserLoginEntity loginEntity = new UserLoginEntity();
        loginEntity.setName("qujie");
        loginEntity.setPwd("e10adc3949ba59abbe56e057f20f883e");
        UserInfoView infoView = dao.login(loginEntity);
        System.out.println(infoView);
    }
}
