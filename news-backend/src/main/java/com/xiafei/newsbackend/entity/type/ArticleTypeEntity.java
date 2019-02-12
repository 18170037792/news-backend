package com.xiafei.newsbackend.entity.type;

/**
 * Created by qujie on 2019/1/7
 * */
public class ArticleTypeEntity {

    private Long id;
    /**
     * 类别名称
     * */
    private String name;

    private Integer count;
    /**
     * 是否显示
     * */
    private Integer show;
    /**
     * 排序
     * */
    private Integer sort;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getShow() {
        return show;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "ArticleTypeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", show=" + show +
                ", sort=" + sort +
                '}';
    }
}
