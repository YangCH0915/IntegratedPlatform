package com.xinruiyun.platform.service.product.impl;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.entity.Product;
import com.xinruiyun.platform.service.product.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ProductServiceImplTest extends BaseTest{

    @Autowired
    private ProductService productService;

    @Test
    public void addProduct() {
    }

    @Test
    public void deleteProduct() {
    }

    @Test
    public void updateProduct() {
    }

    @Test
    public void queryProductAndSubProduct() {
        Product product = productService.queryProductAndSubProduct("1002547");
        System.out.println("查询结果："+product);
    }

    @Test
    public void queryProductList() {
    }
}