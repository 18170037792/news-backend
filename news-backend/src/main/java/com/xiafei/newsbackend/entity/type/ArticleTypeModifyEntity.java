package com.xiafei.newsbackend.entity.type;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class ArticleTypeModifyEntity {

    private Long id;

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
