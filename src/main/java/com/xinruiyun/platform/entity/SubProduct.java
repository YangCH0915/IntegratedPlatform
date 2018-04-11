package com.xinruiyun.platform.entity;

/**
 * 子产品分类
 */
public class SubProduct {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 子产品标题
     */
    private String title;
    /**
     * 父产品ID
     */
    private String productId;
    /**
     * 子父产品ID
     */
    private String subProductId;
    /**
     * 出售价格
     */
    private float price;
    /**
     * 原价
     */
    private float originalPrice;
    /**
     * 会员计费协议代码（用于开通会员的一个标识号）
     */
    private String billingCode;
    /**
     * 是否显示
     */
    private Integer isShow;
    /**
     * 推荐等级，数字0.1.2.3.。。等级显示，值越小排序靠前
     */
    private Integer ranking;
    /**
     * 推荐描述
     */
    private String productExplain;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getBillingCode() {
        return billingCode;
    }

    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getProductExplain() {
        return productExplain;
    }

    public void setProductExplain(String productExplain) {
        this.productExplain = productExplain;
    }

    @Override
    public String toString() {
        return "SubProduct{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", productId='" + productId + '\'' +
                ", subProductId='" + subProductId + '\'' +
                ", price=" + price +
                ", originalPrice=" + originalPrice +
                ", billingCode='" + billingCode + '\'' +
                ", isShow=" + isShow +
                ", ranking=" + ranking +
                ", productExplain='" + productExplain + '\'' +
                '}';
    }
}
