package com.xiafei.newsbackend.entity.message;

import com.xiafei.newsbackend.entity.page.PageLimitEntity;

import javax.validation.constraints.NotNull;

/**
 * Created by qujie on 2019/1/14
 * 留言信息查询条件
 * */
public class MessageInfoSearchEntity {

    /**
     * 登录用户id
     * */
    @NotNull
    private Long userId;

    /**
     * 分页条件
     * */
    private PageLimitEntity limitEntity;

    @NotNull
    public Long getUserId() {
        return userId;
    }

    public void setUserId(@NotNull Long userId) {
        this.userId = userId;
    }

    public PageLimitEntity getLimitEntity() {
        return limitEntity;
    }

    public void setLimitEntity(PageLimitEntity limitEntity) {
        this.limitEntity = limitEntity;
    }
}
