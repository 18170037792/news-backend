package com.xiafei.newsbackend.entity.article;

import com.xiafei.newsbackend.entity.page.PageLimitEntity;

import javax.validation.constraints.NotNull;

public class ArticleInfoSearchEntity {

    @NotNull
    private Long userId;

    private PageLimitEntity limitEntity;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PageLimitEntity getLimitEntity() {
        return limitEntity;
    }

    public void setLimitEntity(PageLimitEntity limitEntity) {
        this.limitEntity = limitEntity;
    }
}
