package com.xinruiyun.platform.entity.user;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Role implements Serializable {

    private static final long serialVersionUID = 1001L;

    private int id;
    /**
     * 角色名称
     * */
    private String name;
    /**
     * 角色类型
     */
    private String type;
    /**
     * role --> permission 一对多处理
     */
    private List<Permission> permissions = new LinkedList<Permission>();

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
