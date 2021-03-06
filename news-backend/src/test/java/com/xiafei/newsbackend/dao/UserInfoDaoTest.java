package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.user.UserLoginEntity;
import com.xiafei.newsbackend.pojo.table.UserInfoTable;
import com.xiafei.newsbackend.pojo.view.UserInfoView;
import com.xiafei.newsbackend.pojo.view.UserLogView;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

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

    @Test
    public void getCountUser(){
        int count = dao.countUserList();
        System.out.println(count);
    }

    /**
     * 测试用户分页列表
     * */
    @Test
    public void getUserList(){
        PageLimitEntity limitEntity = new PageLimitEntity();
        limitEntity.setCurrent(1);
        limitEntity.setRow(10);
        List<UserLogView> logViews = dao.getUserList(limitEntity);
        System.out.println(logViews);
    }

    /**
     * 根据作者id查询作者信息
     * */
    @Test
    public void getUserByAuthorId(){
        UserInfoTable table = dao.getUserByAuthorId(1L);
        System.out.println(table);
    }

    /**
     * 根据用户id获取原密码
     * */
    @Test
    public void getOldPwd(){
        String oldPwd = dao.getOldPwd(1L);
        System.out.println(oldPwd);
    }

    /**
     * 用户修改密码
     * */
    @Test
    public void updatePwdById(){
        UserInfoTable table = new UserInfoTable();
        table.setId(5L);
        table.setPwd("123456");
        dao.updatePwdById(table);
    }

    /**
     * 修改用户信息
     * */
    @Test
    public void updateUser(){
        UserInfoTable table = new UserInfoTable();
        table.setId(1L);
        table.setNickname("瞿杰");
        table.setGender(1);
        table.setPersonalizedSignature("白茶清欢无别事");
        table.setMobile("11244522221");
        table.setModifyTime(new Date());
        int result = dao.updateUser(table);
        Assert.assertTrue(result>0);
    }
}
