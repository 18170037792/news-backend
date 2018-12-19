package com.xiafei.newsbackend.entity.article;

import javax.validation.constraints.NotNull;

public class ArticleInfoSearchEntity {

    @NotNull
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
