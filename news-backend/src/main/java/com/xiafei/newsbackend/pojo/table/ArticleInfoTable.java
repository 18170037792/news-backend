package com.xiafei.newsbackend.pojo.table;

/**
 * Created by qujie on 2018/12/19
 * 文章信息实体类
 * */
public class ArticleInfoTable extends BaseTable{

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
    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ArticleInfoTable{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", content='" + content + '\'' +
                ", typeId=" + typeId +
                ", status=" + status +
                '}';
    }
}
