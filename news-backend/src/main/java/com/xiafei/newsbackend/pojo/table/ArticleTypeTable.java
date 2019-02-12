package com.xiafei.newsbackend.pojo.table;

/**
 * Created by qujie on 2018/1/7
 * 文章类别实体类
 * */
public class ArticleTypeTable extends BaseTable{

    /**
     * 类别名称
     * */
    private String name;
    /**
     * 是否显示
     * */
    private Integer show;
    /**
     * 排序
     * */
    private Integer sort;

    /**
     * 文章分类下对应的文章数量
     * */
    private Integer count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ArticleTypeTable{" +
                "name='" + name + '\'' +
                ", show=" + show +
                ", sort=" + sort +
                ", count=" + count +
                '}';
    }
}
