package com.xinruiyun.platform.entity;

/**
 * 储存组合的产品ID
 */
public class CompositeProduct {

    private int id;
    /**
     * 产品ID
     */
    private String productId;
    /**
     * 子产品ID
     */
    private String subProductId;

    /**
     * 通道ID
     */
    private String passagewayId;
    /**
     * 渠道ID
     */
    private String channelId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSubProductId() {
        return subProductId;
    }

    public void setSubProductId(String subProductId) {
        this.subProductId = subProductId;
    }

    public String getPassagewayId() {
        return passagewayId;
    }

    public void setPassagewayId(String passagewayId) {
        this.passagewayId = passagewayId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
