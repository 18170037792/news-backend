package com.xiafei.newsbackend.entity.links;

import java.util.Date;

public class LinksInfoEntity {

    private Long id;
    private String name;
    private String logo;
    private String linkAddress;
    private Integer sort;
    private Date addTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "LinksInfoEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", linkAddress='" + linkAddress + '\'' +
                ", sort=" + sort +
                ", addTime=" + addTime +
                '}';
    }
}
