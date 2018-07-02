package com.xinruiyun.platform.entity.product;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 产品分类
 */
public class Product implements Serializable{

    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 产品ID
     */
    private String productId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品LOGO
     */
    private String productLogo;
    /**
     * 产品背景
     */
    private String productBg;
    /**
     * 产品说明，多个说明用竖线隔开
     */
    private String productExplain;
    /**
     * 是否启用
     */
    private Integer isEnable;

    /**
     * 创建人
     */
    private String founder;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private String renewing;
    /**
     * 更新时间,指渠道信息更新
     */
    private Date updateTime;

    /**
     * 请求地址
     */
    private String requestUrl;
    /**
     * 子商品列表
     */
    private List<SubProduct> subProducts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLogo() {
        return productLogo;
    }

    public void setProductLogo(String productLogo) {
        this.productLogo = productLogo;
    }

    public String getProductBg() {
        return productBg;
    }

    public void setProductBg(String productBg) {
        this.productBg = productBg;
    }

    public String getProductExplain() {
        return productExplain;
    }

    public void setProductExplain(String productExplain) {
        this.productExplain = productExplain;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public List<SubProduct> getSubProducts() {
        return subProducts;
    }

    public void setSubProducts(List<SubProduct> subProducts) {
        this.subProducts = subProducts;
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

    public String getRenewing() {
        return renewing;
    }

    public void setRenewing(String renewing) {
        this.renewing = renewing;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productLogo='" + productLogo + '\'' +
                ", productBg='" + productBg + '\'' +
                ", productExplain='" + productExplain + '\'' +
                ", isEnable=" + isEnable +
                ", founder='" + founder + '\'' +
                ", createTime=" + createTime +
                ", renewing='" + renewing + '\'' +
                ", updateTime=" + updateTime +
                ", subProducts=" + subProducts +
                '}';
    }
}
