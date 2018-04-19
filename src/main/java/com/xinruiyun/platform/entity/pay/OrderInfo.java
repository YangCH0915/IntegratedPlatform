package com.xinruiyun.platform.entity.pay;

import javax.xml.crypto.Data;

public class OrderInfo {

    private long id;
    private String channelId;
    private String channelName;
    private String payPassagewayName;
    private String mchId;
    private String payType;
    private Data requestTime;
    private Data finishTime;
    private String userInfo;   //用户ID
    private String product;  //商品信息
    private float money;
    private String orderId;
    private String platformId;
    private String createIp;
    private Integer state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getPayPassagewayName() {
        return payPassagewayName;
    }

    public void setPayPassagewayName(String payPassagewayName) {
        this.payPassagewayName = payPassagewayName;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Data getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Data requestTime) {
        this.requestTime = requestTime;
    }

    public Data getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Data finishTime) {
        this.finishTime = finishTime;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                ", payPassagewayName='" + payPassagewayName + '\'' +
                ", mchId='" + mchId + '\'' +
                ", payType='" + payType + '\'' +
                ", requestTime=" + requestTime +
                ", finishTime=" + finishTime +
                ", userInfo='" + userInfo + '\'' +
                ", product='" + product + '\'' +
                ", state=" + state +
                ", money=" + money +
                ", orderId='" + orderId + '\'' +
                ", platformId='" + platformId + '\'' +
                '}';
    }
}
