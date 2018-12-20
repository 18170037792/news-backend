package com.xiafei.newsbackend.entity.article;

public class ArticleInfoEntity {

    private Long id;

    /**
     * 文章标题
     * */
    private String title;
    /**
     * 副标题
     * */
    private String subtitle;
    /**
     * 内容
     * */
    private String content;
    /**
     * 文章分类
     * */
    private Long typeId;
    /**
     * 排序
     * */
    private Integer sort;

    private Long addUser;

    private Integer messageCount;

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }

    public Long getAddUser() {
        return addUser;
    }

    public void setAddUser(Long addUser) {
        this.addUser = addUser;
    }

    @Override
    public String toString() {
        return "ArticleInfoEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", content='" + content + '\'' +
                ", typeId=" + typeId +
                ", sort=" + sort +
                ", addUser=" + addUser +
                ", messageCount=" + messageCount +
                '}';
    }
}
