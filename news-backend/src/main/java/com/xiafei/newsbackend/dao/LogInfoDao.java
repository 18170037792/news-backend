package com.xiafei.newsbackend.dao;
import com.xiafei.newsbackend.pojo.table.LogInfoTable;
import com.xiafei.newsbackend.pojo.view.UserLogView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qujie on 2018/12/14
 * */
public interface LogInfoDao {

    int insertLog(LogInfoTable table);

    /**
     * 查询系统日志列表
     * @param authorId
     * */
    List<LogInfoTable> getLogList(@Param("authorId") Long authorId);

    /**
     * 获取管理员日志的最新用户动态
     * @return UserLogView
     * */
    List<UserLogView> getUserDynamic();
}
