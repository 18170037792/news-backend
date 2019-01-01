package com.xiafei.newsbackend.pojo.view;

import java.util.Date;

/**
 * Created by qujie on 2019/1/1
 * 文章和类别关联实体
 * */
public class ArticleTypeView {

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
     * 发布时间
     * */
    private Date addTime;
    /**
     * 文章分类
     * */
    private String typeName;

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

    @Override
    public String toString() {
        return "ArticleTypeView{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", content='" + content + '\'' +
                ", addTime=" + addTime +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
