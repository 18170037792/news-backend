package com.xiafei.newsbackend.entity.links;

import com.xiafei.newsbackend.entity.base.BaseAddEntity;
import com.xiafei.newsbackend.util.Constant;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by qujie on 2018/12/10
 * */
public class LinksInfoAddEntity extends BaseAddEntity {

    @NotBlank(message = "链接名不能为空")
    @NotNull(message = "链接名不能为空")
    @Size(min = 1, max = 20, message = Constant.LENGTH_ERROR)
    private String name;
    private String logo;
    @NotBlank(message = "链接地址不能为空")
    @NotNull(message = "链接地址不能为空")
    @Size(min = 1, max = 100, message = Constant.LENGTH_ERROR)
    private String linkAddress;
    private Integer sort;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
