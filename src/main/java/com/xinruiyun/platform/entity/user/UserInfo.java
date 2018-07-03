package com.xinruiyun.platform.entity.user;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class UserInfo {

    private long id;
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
     * 创建人
     */
    private String founder;
    /**
     * 创建时间
     * @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;  //创建时间,指渠道账户创建时间
    /**
     * 更新人
     */
    private String renewing;
    /**
     * 更新时间,指渠道信息更新
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 异步回调地址
     */
    private String notifyUrl;
    /**
     * 前端回调地址
     */
    private String callbackUrl;
    /**
     * 使用状态
     */
    private int state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", uaName='" + uaName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", founder='" + founder + '\'' +
                ", createTime=" + createTime +
                ", renewing='" + renewing + '\'' +
                ", updateTime=" + updateTime +
                ", remarks='" + remarks + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", state=" + state +
                '}';
    }
}
