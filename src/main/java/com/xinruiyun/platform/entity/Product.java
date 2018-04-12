package com.xinruiyun.platform.entity;

import java.io.Serializable;
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
                ", subProducts=" + subProducts +
                '}';
    }
}
