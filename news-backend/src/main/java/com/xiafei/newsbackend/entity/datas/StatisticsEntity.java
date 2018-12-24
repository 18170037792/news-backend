package com.xiafei.newsbackend.entity.datas;
/**
 * Created by qujie on 2018/12/19
 * 后台统计对象
 * */
public class StatisticsEntity {

    /**
     * 文章数
     * */
    private Integer articles;
    /**
     * 友链数
     * */
    private Integer links;
    /**
     * 评论数
     * */
    private Integer messages;
    /**
     * 用户数
     * */
    private Integer users;
    /**
     * 文件数
     * */
    private Integer documents;


    public Integer getArticles() {
        return articles;
    }

    public void setArticles(Integer articles) {
        this.articles = articles;
    }

    public Integer getLinks() {
        return links;
    }

    public void setLinks(Integer links) {
        this.links = links;
    }

    public Integer getMessages() {
        return messages;
    }

    public void setMessages(Integer messages) {
        this.messages = messages;
    }

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    public Integer getDocuments() {
        return documents;
    }

    public void setDocuments(Integer documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "StatisticsEntity{" +
                "articles=" + articles +
                ", links=" + links +
                ", messages=" + messages +
                ", users=" + users +
                ", documents=" + documents +
                '}';
    }
}
