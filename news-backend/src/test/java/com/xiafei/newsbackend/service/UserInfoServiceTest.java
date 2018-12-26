package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import com.xiafei.newsbackend.entity.user.UserLogEntity;
import com.xiafei.newsbackend.entity.user.UserLoginEntity;
import com.xiafei.newsbackend.util.GetMD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService service;

    @Test
    public void login() throws Exception{
        UserLoginEntity loginEntity = new UserLoginEntity();
        loginEntity.setPwd("123456");
        loginEntity.setName("qujie");

        UserInfoEntity entity = service.login(loginEntity);
        System.out.println(entity);
    }

    @Test
    public void getUserList() throws Exception{
        List<UserLogEntity> list = service.getUserList();
        System.out.println(list);
    }
}
