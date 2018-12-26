package com.xiafei.newsbackend.entity.user;

import java.util.Date;

public class UserInfoUpdateEntity {

    private Long id;

    /**
     * 是否冻结
     * */
    private Integer frozen;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFrozen() {
        return frozen;
    }

    public void setFrozen(Integer frozen) {
        this.frozen = frozen;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
