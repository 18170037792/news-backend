package com.xiafei.newsbackend.entity.type;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ArticleTypeAddEntity {

    /**
     * 类别名称
     * */
    @NotNull(message = "分类名称不能为空")
    @NotBlank(message = "分类名称不能为空")
    private String name;

    /**
     * 排序
     * */
    @NotNull(message = "分类名称不能为空")
    @Min(value = 0,message = "排序值不能过小")
    @Max(value = 500,message = "排序值不能过大")
    private Integer sort;

    private Long addUser;

    private Date addTime;
    private String addIp;

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public Integer getSort() {
        return sort;
    }

    public void setSort(@NotNull Integer sort) {
        this.sort = sort;
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
