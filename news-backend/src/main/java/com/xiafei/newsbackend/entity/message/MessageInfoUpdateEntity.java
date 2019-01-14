package com.xiafei.newsbackend.entity.message;

/**
 * Created by qujie on 2019/1/14
 * */
public class MessageInfoUpdateEntity {

    private Long id;
    /**
     * 留言状态
     * */
    private Integer status;
    /**
     * 修改人
     * */
    private Long modifyUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }
}
