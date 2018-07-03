package com.xinruiyun.platform.dto;

import com.xinruiyun.platform.entity.user.Permission;
import com.xinruiyun.platform.utils.StringUtils;

import java.io.Serializable;

public class UPermission extends Permission implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 是否勾选
     */
    private String marker;
    /**
     * role Id
     */
    private String roleId;

    public boolean isCheck(){
        return StringUtils.equals(roleId,marker);
    }
    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }
    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
