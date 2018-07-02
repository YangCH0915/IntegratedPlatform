package com.xinruiyun.platform.entity.user;

import java.io.Serializable;

/**
 * 角色{@link Role}和 权限{@link Permission}中间表
 */
public class URolePermission  implements Serializable{

	private static final long serialVersionUID = 10004L;
	/**
     * {@link Role.id}
     */
    private Long rid;
    /**
     * {@link Permission.id}
     */
    private Long pid;

    public URolePermission() {
	}
    public URolePermission(Long rid,Long pid) {
    	this.rid = rid;
    	this.pid = pid;
    }
    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}