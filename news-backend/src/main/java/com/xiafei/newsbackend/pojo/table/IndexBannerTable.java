package com.xiafei.newsbackend.pojo.table;

/**
 * Created by qujie on 2019/1/21
 * 首页轮播实体类
 * */
public class IndexBannerTable extends BaseTable{

    /**
     * 排序
     * */
    private Integer sort;
    /**
     * 文章id
     * */
    private Long articleId;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "IndexBannerTable{" +
                "sort=" + sort +
                ", articleId=" + articleId +
                '}';
    }
}
