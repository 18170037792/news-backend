package com.xiafei.newsbackend.dao;

import com.xiafei.newsbackend.pojo.table.LinksInfoTable;

import java.util.List;

/**
 * Created by qujie on 2018/12/10
 * */
public interface LinksInfoDao {

    int insert(LinksInfoTable table);

    List<LinksInfoTable> getList();
}
