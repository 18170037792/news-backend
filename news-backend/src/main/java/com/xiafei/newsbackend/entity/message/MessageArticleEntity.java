package com.xiafei.newsbackend.entity.message;

import java.util.Date;

/**
 * Created by qujie on 2019/1/14
 * 留言表和文章关联视图实体
 * */
public class MessageArticleEntity {

    private Long id;
    /**
     * 留言文章
     * */
    private String title;
    /**
     * 文章id
     * */
    private Long articleId;
    /**
     * 留言人姓名
     * */
    private String name;
    /**
     * 留言内容
     * */
    private String content;
    /**
     * 留言时间
     * */
    private Date commentTime;
    /**
     * 留言人邮箱
     * */
    private String email;
    /**
     * 留言人网址
     * */
    private String webSiteUrl;
    /**
     * ip
     * */
    private String addIp;

    /**
     * 留言状态
     * */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    public void setWebSiteUrl(String webSiteUrl) {
        this.webSiteUrl = webSiteUrl;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MessageArticleEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", articleId=" + articleId +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", commentTime=" + commentTime +
                ", email='" + email + '\'' +
                ", webSiteUrl='" + webSiteUrl + '\'' +
                ", addIp='" + addIp + '\'' +
                ", status=" + status +
                '}';
    }
}
