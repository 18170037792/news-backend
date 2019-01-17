package com.xiafei.newsbackend.entity.message;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by qujie on 2019/1/14
 * */
public class MessageInfoUpdateEntity {

    @NotNull
    private Long id;
    /**
     * 留言状态
     * */
    @NotNull(message = "留言状态不能为空")
    @Min(value = 0,message = "留言操作错误")
    @Max(value = 2,message = "留言操作错误")
    private Integer status;
    /**
     * 修改人
     * */
    private Long modifyUser;

    @NotNull
    public Long getId() {
        return id;
    }

    public void setId(@NotNull Long id) {
        this.id = id;
    }

    @NotNull
    public Integer getStatus() {
        return status;
    }

    public void setStatus(@NotNull Integer status) {
        this.status = status;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }
}
