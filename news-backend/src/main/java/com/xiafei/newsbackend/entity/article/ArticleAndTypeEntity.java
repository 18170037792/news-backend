package com.xiafei.newsbackend.entity.article;

import java.util.Date;

public class ArticleAndTypeEntity {

    private Long id;
    /**
     * 文章标题
     * */
    private String title;
    /**
     * 副标题
     * */
    private String subtitle;
    /**
     * 内容
     * */
    private String content;

    /**
     * 文章状态
     * */
    private Integer status;

    /**
     * 发布时间
     * */
    private Date addTime;
    /**
     * 文章分类
     * */
    private String typeName;

    private String tag;

    /**
     * 作者名称
     * */
    private String authorName;
    /**
     * 作者id
     * */
    private Long addUser;
    /**
     * 作者头像
     * */
    private String avatar;

    /**
     * 评论数
     * */
    private Integer messageCount;

    /**
     * 浏览量
     * */
    private Integer views;

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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getAddUser() {
        return addUser;
    }

    public void setAddUser(Long addUser) {
        this.addUser = addUser;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "ArticleAndTypeEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", addTime=" + addTime +
                ", typeName='" + typeName + '\'' +
                ", tag='" + tag + '\'' +
                ", authorName='" + authorName + '\'' +
                ", addUser=" + addUser +
                ", avatar='" + avatar + '\'' +
                ", messageCount=" + messageCount +
                ", views=" + views +
                '}';
    }
}
