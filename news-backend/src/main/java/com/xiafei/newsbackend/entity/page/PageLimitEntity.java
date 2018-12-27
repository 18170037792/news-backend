package com.xiafei.newsbackend.entity.page;

/**
 * Created by qujie on 2018/12/27
 * 自定义分页类
 * */
public class PageLimitEntity {

    /**
     * 当前页
     * */
    private int current;
    /**
     * 分页条数
     * */
    private int row;
    /**
     * mysql分页语句起始量
     * */
    private int offset;

    public PageLimitEntity(int current, int row) {
        this.current = current;
        this.row = row;
    }

    public PageLimitEntity() {
    }

    public int getCurrent() {
        return this.current;
    }

    public void setCurrent(int current) {
        if (current <= 0) {
            current = 1;
        }

        this.current = current;
    }

    public int getRow() {
        if (this.row <= 0) {
            this.row = 20;
        } else if (this.row >= 100) {
            this.row = 100;
        }

        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getOffset() {
        this.offset = offsetCurrent(this.current, this.row);
        return this.offset;
    }

    private static int offsetCurrent(int current, int row) {
        return current > 0 ? (current - 1) * row : 0;
    }
}
