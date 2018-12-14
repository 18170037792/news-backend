package com.xiafei.newsbackend.entity.log;

import com.xiafei.newsbackend.entity.base.BaseAddEntity;

/**
 * Created by qujie on 2018/12/14
 * */
public class LogInfoAddEntity extends BaseAddEntity {

    /**
     * 用户操作
     * */
    private String action;
    /**
     * 操作数据
     * */
    private String data;
    /**
     * 操作人Id
     * */
    private Long authorId;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
