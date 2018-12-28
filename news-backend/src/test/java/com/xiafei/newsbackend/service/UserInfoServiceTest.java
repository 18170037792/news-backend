package com.xiafei.newsbackend.service;

import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.entity.user.UserInfoEntity;
import com.xiafei.newsbackend.entity.user.UserLogEntity;
import com.xiafei.newsbackend.entity.user.UserLoginEntity;
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
        PageLimitEntity limitEntity = new PageLimitEntity();
        limitEntity.setCurrent(1);
        limitEntity.setRow(10);
        List<UserLogEntity> userList = service.getUserList(limitEntity);
        System.out.println(userList.size());
    }

    /**
     * 用户信息分页
     * */
    @Test
    public void getUserWithPage() throws Exception{
        PageShowEntity<UserInfoEntity> page = service.getUserWithPage(11, 3);
        System.out.println(page);
    }
}
