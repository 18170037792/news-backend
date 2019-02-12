package com.xiafei.newsbackend.entity.article;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by qujie on 2019/1/11
 * 文章发表实体类
 * */
public class ArticlePublishEntity {

    private Long id;

    /**
     * 文章标题
     * */
    @NotNull(message = "文章标题不能为空")
    @NotBlank(message = "文章标题不能为空")
    private String title;
    /**
     * 副标题
     * */
    @NotNull(message = "副标题不能为空")
    @NotBlank(message = "副标题不能为空")
    private String subtitle;
    /**
     * 内容
     * */
    @NotNull(message = "内容不能为空")
    @NotBlank(message = "内容不能为空")
    private String content;
    /**
     * 文章分类
     * */
    @NotNull(message = "文章分类不能为空")
    private Long typeId;

    /**
     * 文章标签
     * */
    private String tag;

    /**
     * 文章状态
     * */
    private Integer status;

    private Long addUser;

    private Date addTime;
    private String addIp;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getAddUser() {
        return addUser;
    }

    public void setAddUser(Long addUser) {
        this.addUser = addUser;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }
}
