package com.xiafei.newsbackend.entity.article;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by qujie on 2019/1/15
 * 文章编辑实体类
 * */
public class ArticleModifyEntity {

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

    private Integer status;

    private Date modifyTime;
    private Long modifyUser;
    private String modifyIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    @NotNull
    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(@NotNull String subtitle) {
        this.subtitle = subtitle;
    }

    @NotNull
    public String getContent() {
        return content;
    }

    public void setContent(@NotNull String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @NotNull
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(@NotNull Long typeId) {
        this.typeId = typeId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getModifyIp() {
        return modifyIp;
    }

    public void setModifyIp(String modifyIp) {
        this.modifyIp = modifyIp;
    }
}
