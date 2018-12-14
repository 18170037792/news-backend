package com.xiafei.newsbackend.pojo.table;

/**
 * Created by qujie on 2018/12/14
 * 系统日志实体
 * */
public class LogInfoTable extends BaseTable{

    private String action;
    private String data;
    private Long authorId;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
