package com.xiafei.newsbackend.entity.log;

import java.util.Date;

/**
 * Created by qujie on 2018/12/22
 * */
public class LogInfoEntity {

    private Long id;
    private String action;
    private String data;
    private Long authorId;
    private Date addTime;
    private String addIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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

    @Override
    public String toString() {
        return "LogInfoEntity{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", data='" + data + '\'' +
                ", authorId=" + authorId +
                ", addTime=" + addTime +
                ", addIp='" + addIp + '\'' +
                '}';
    }
}
