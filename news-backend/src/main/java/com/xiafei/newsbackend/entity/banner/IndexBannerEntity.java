package com.xiafei.newsbackend.entity.banner;

import java.util.Date;

public class IndexBannerEntity {

    private Long id;

    /**
     * 文章id
     * */
    private Long articleId;
    /**
     * 文章标题
     * */
    private String title;
    /**
     * 文章内容
     * */
    private String content;

    /**
     * 文章作者id
     * */
    private Long addUser;

    /**
     * 文章作者
     * */
    private String authorName;

    /**
     * 文章发布时间
     * */
    private Date addTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAddUser() {
        return addUser;
    }

    public void setAddUser(Long addUser) {
        this.addUser = addUser;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "IndexBannerEntity{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", addUser=" + addUser +
                ", authorName='" + authorName + '\'' +
                ", addTime=" + addTime +
                '}';
    }
}
