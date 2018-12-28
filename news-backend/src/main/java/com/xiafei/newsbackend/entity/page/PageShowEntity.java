package com.xiafei.newsbackend.entity.page;

import java.util.Arrays;
import java.util.List;

/**
 * Created by qujie on 2018/12/27
 * 分类数据展示类
 * */
public class PageShowEntity<T> {

    /**
     * 首页
     * */
    private int indexPage=1;

    /**
     * 当前页
     * */
    private int current;
    /**
     * 分页数
     * */
    private int row;
    /**
     * 总页数
     * */
    private int pageTotal;
    /**
     * 总记录数
     * */
    private int rowTotal;
    /**
     * 是否为第一页
     * */
    private boolean firstPage;
    /**
     * 是否为最后一页
     * */
    private boolean lastPage;
    /**
     * 是否有前一页
     * */
    private boolean hasPreviousPage;
    /**
     * 是否有下一页
     * */
    private boolean hasNextPage;
    /**
     * 导航页码数
     * */
    private int navigatePages;
    /**
     * 所有导航页号
     * */
    private int[] navigatePageNumbers;
    /**
     * 前一页
     * */
    private int prePage;
    /**
     * 下一页
     * */
    private int nextPage;


    private List<T> data;

    public PageShowEntity() {
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getRowTotal() {
        return rowTotal;
    }

    public void setRowTotal(int rowTotal) {
        this.rowTotal = rowTotal;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int[] getNavigatePageNumbers() {
        return navigatePageNumbers;
    }

    public void setNavigatePageNumbers(int[] navigatePageNumbers) {
        this.navigatePageNumbers = navigatePageNumbers;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }


    public int getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(int indexPage) {
        this.indexPage = indexPage;
    }

    @Override
    public String toString() {
        return "PageShowEntity{" +
                "indexPage=" + indexPage +
                ", current=" + current +
                ", row=" + row +
                ", pageTotal=" + pageTotal +
                ", rowTotal=" + rowTotal +
                ", firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                ", hasPreviousPage=" + hasPreviousPage +
                ", hasNextPage=" + hasNextPage +
                ", navigatePages=" + navigatePages +
                ", navigatePageNumbers=" + Arrays.toString(navigatePageNumbers) +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", data=" + data +
                '}';
    }
}
