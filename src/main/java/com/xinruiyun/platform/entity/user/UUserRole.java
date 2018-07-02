package com.xinruiyun.platform.entity.user;

import java.io.Serializable;

/**
 * 用户{@link UserInfo} 和角色 {@link Role} 中间表
 */
public class UUserRole  implements Serializable{

	private static final long serialVersionUID = 10003L;
	 /**
      * 关联用户ID
      */
    private Long uid;
    /**
     * 关联角色ID
     */
    private Long rid;

    public UUserRole(Long uid,Long rid) {
    	this.uid = uid;
    	this.rid = rid;
	}
    public UUserRole() {
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}