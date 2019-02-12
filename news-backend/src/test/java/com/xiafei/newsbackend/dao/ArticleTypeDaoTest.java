package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.NewsBackendApplicationTests;
import com.xiafei.newsbackend.pojo.table.ArticleTypeTable;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;

@Component
public class ArticleTypeDaoTest extends NewsBackendApplicationTests {

    @Autowired
    private ArticleTypeDao dao;

    @Test
    public void getTypeList() {
        List<ArticleTypeTable> typeList = dao.getTypeList();
        Assert.assertTrue( typeList!=null && typeList.size()!=0);
    }
}