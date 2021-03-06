package com.xiafei.newsbackend.entity.enu;

/**
 * Created by qujie on 2018/12/14
 * 日志字段枚举
 * */
public enum LogActions {

    LOGIN("登录系统"), LOGOUT("退出系统"), UP_PWD("修改密码"), UP_INFO("修改个人信息"),
    DEL_ARTICLE("删除文章"), DEL_COMMENT("删除留言"), SYS_BACKUP("系统备份"),
    SYS_SETTING("保存系统设置"), INIT_SITE("初始化站点");

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    LogActions(String action) {
        this.action = action;
    }
}
