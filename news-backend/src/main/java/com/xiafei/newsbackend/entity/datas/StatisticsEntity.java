package com.xiafei.newsbackend.entity.datas;
/**
 * Created by qujie on 2018/12/19
 * 后台统计对象
 * */
public class StatisticsEntity {

    private Integer articles;
    private Integer links;
    private Integer messages;


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

    @Override
    public String toString() {
        return "StatisticsEntity{" +
                "articles=" + articles +
                ", links=" + links +
                ", messages=" + messages +
                '}';
    }
}
