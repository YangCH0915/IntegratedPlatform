package com.xinruiyun.platform.entity;

import java.util.Date;

public class UserInfo {

    private Integer id;
    /**
     * 中文名
     */
    private String uaName;
    /**
     * 用户账号
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户权限
     * 0  超级管理员
     * 1  运营人员
     * 2  普通用户
     * 3  下游渠道
     */
    private Integer userJurisdiction;
    /**
     * 账号对应的网页
     */
    private String html;
    /**
     * 创建人
     */
    private String founder;
    /**
     * 创建时间
     */
    private Date createTime;  //创建时间,指渠道账户创建时间
    /**
     * 更新人
     */
    private String renewing;
    /**
     * 更新时间,指渠道信息更新
     */
    private Date updateTime;
    /**
     * 备注
     */
    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUaName() {
        return uaName;
    }

    public void setUaName(String uaName) {
        this.uaName = uaName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserJurisdiction() {
        return userJurisdiction;
    }

    public void setUserJurisdiction(Integer userJurisdiction) {
        this.userJurisdiction = userJurisdiction;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRenewing() {
        return renewing;
    }

    public void setRenewing(String renewing) {
        this.renewing = renewing;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", uaName='" + uaName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userJurisdiction=" + userJurisdiction +
                ", html='" + html + '\'' +
                ", founder='" + founder + '\'' +
                ", createTime='" + createTime + '\'' +
                ", renewing='" + renewing + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
