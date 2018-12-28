package com.xiafei.newsbackend.util;

import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;

/**
 * Created by qujie on 2018/12/27
 * 格式化分页数据
 * */
public class FormatPage {

    public FormatPage() {
    }

    public static <T extends PageLimitEntity> PageShowEntity format(T page,int rowTatal){

        int current = page.getCurrent();
        int pageTotal;
        if (rowTatal == 0) {
            pageTotal = 1;
        } else {
            pageTotal = rowTatal % page.getRow() == 0 ? rowTatal / page.getRow() : rowTatal / page.getRow() + 1;
        }
        if (current > pageTotal) {
            current = pageTotal;
        }

        /**
         * 判断是否是第一页
         * */
        Boolean isFirstPage = false;
        if(current == 1){
            isFirstPage = true;
        }

        /**
         * 判断是否是最后一页
         * */
        Boolean isLastPage = false;
        if(current == pageTotal && current !=1){
            isLastPage = true;
        }

        /**
         * 判断是否有前一页
         * */
        Boolean hasPreviousPage = false;
        if(current >1){
            hasPreviousPage = true;
        }

        /**
         * 判断是否有后一页
         * */
        Boolean hasNextPage = false;
        if(current < pageTotal){
            hasNextPage = true;
        }

        /**
         * 前一页
         * */
        int prePage = 0;
        if(current >1){
            prePage = current -1;
        }

        /**
         * 后一页
         * */
        int nextPage = 0;
        if(current < pageTotal){
            nextPage = current + 1;
        }

        /**
         * 初始化导航页码数
         * */
        int navigatePages = 5;
        /**
         * 初始化页码数组
         * */
        int[] navigatePageNumber = {};

        int[] navigatePageNumbers = calcNavigatePageNumbers(pageTotal, navigatePages, navigatePageNumber, current);

        return format(current, page.getRow(), pageTotal, rowTatal,isFirstPage,isLastPage,hasPreviousPage,hasNextPage,prePage,nextPage,navigatePages,navigatePageNumbers);
    }

    /**
     * 计算导航页
     */
    private static int[] calcNavigatePageNumbers(int pageTotal,int navigatePages, int[] navigatePageNumbers, int current){
        /**
         * 当总页数小于或等于导航页码数时
         * */
        if(pageTotal<=navigatePages){
            navigatePageNumbers=new int[pageTotal];
            for(int i=0;i<pageTotal;i++){
                navigatePageNumbers[i]=i+1;
            }
            return navigatePageNumbers;
        }else{
            /**
             * 当总页数大于导航页码数时
             * */
            navigatePageNumbers=new int[navigatePages];
            int startNum=current-navigatePages/2;
            int endNum=current+navigatePages/2;

            if(startNum<1){
                startNum=1;
                /**
                 * 最前navigatePages页
                 * */
                for(int i=0;i<navigatePages;i++){
                    navigatePageNumbers[i]=startNum++;
                }
            }else if(endNum>pageTotal){
                endNum=pageTotal;
                /**
                 * 最后navigatePages页
                 * */
                for(int i=navigatePages-1;i>=0;i--){
                    navigatePageNumbers[i]=endNum--;
                }
            }else{
                /**
                 * 所有中间页
                 * */
                for(int i=0;i<navigatePages;i++){
                    navigatePageNumbers[i]=startNum++;
                }
            }
            return navigatePageNumbers;
        }
    }

    /**
     * 设置值
     * */
    private static PageShowEntity format(int current, int row, int pageTotal, int rowTotal,
                                         Boolean isFirstPage, Boolean isLastPage, Boolean hasPreviousPage, Boolean hasNextPage,
                                         int prePage, int nextPage, int navigatePages, int[] navigatePageNumbers) {
        PageShowEntity page = new PageShowEntity();
        page.setCurrent(current);
        page.setRow(row);
        page.setPageTotal(pageTotal);
        page.setRowTotal(rowTotal);
        page.setFirstPage(isFirstPage);
        page.setLastPage(isLastPage);
        page.setHasPreviousPage(hasPreviousPage);
        page.setHasNextPage(hasNextPage);
        page.setPrePage(prePage);
        page.setNextPage(nextPage);
        page.setNavigatePages(navigatePages);
        page.setNavigatePageNumbers(navigatePageNumbers);
        return page;
    }


}
