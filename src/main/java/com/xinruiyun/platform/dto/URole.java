package com.xinruiyun.platform.dto;

import com.xinruiyun.platform.entity.user.Role;

import java.io.Serializable;

public class URole extends Role implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户ID (用String， 考虑多个ID，现在只有一个ID)
     */
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "URole{" +
                "userId='" + userId + '\'' +
                "Role{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", permissions=" + getPermissions() +
                '}'+
                '}';
    }
}
