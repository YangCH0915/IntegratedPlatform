package com.xinruiyun.platform.dto.pay;

/**
 * 客户端请求订购信息
 */
public class PayInfo {
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 购买产品ID（通过产品ID查询得到购买的套餐）
     */
    private String subProductId;
    /**
     * 渠道Id(通过渠道Id和支付类型查询得到支付通道)
     */
    private String channelId;
    /**
     * 支付类型
     */
    private String payType;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubProductId() {
        return subProductId;
    }

    public void setSubProductId(String subProductId) {
        this.subProductId = subProductId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "PayInfo{" +
                "phone='" + phone + '\'' +
                ", subProductId='" + subProductId + '\'' +
                ", channelId='" + channelId + '\'' +
                ", payType='" + payType + '\'' +
                '}';
    }
}
