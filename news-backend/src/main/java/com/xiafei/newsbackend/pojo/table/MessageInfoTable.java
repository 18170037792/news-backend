package com.xiafei.newsbackend.pojo.table;

/**
 * Created by qujie on 2018/12/15
 * */
public class MessageInfoTable extends BaseTable{

    /**
     * 留言人姓名
     * */
    private String name;
    /**
     * 留言人邮箱
     * */
    private String email;
    /**
     * 留言人个人网站地址
     * */
    private String webSiteUrl;
    /**
     * 标题
     * */
    private String title;
    /**
     * 内容
     * */
    private String content;

    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
