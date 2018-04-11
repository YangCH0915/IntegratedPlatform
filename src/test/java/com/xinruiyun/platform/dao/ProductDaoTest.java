package com.xinruiyun.platform.dao;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.entity.Product;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

public class ProductDaoTest extends BaseTest{

    @Resource
    ProductDao productDao;

    @Test
    public void addProduct() {
        Product product = new Product();
        product.setProductId("2000");
        product.setIsEnable(1);
        product.setProductExplain("akjdflkajsdlfj");
        product.setProductBg("adfsdfasdf");
        product.setProductLogo("sd");
        product.setProductName("asd");
        int i = productDao.addProduct(product);
        System.out.println(i);
    }

    @Test
    public void deleteProduct() {
        int i = productDao.deleteProduct("2000");
        System.out.println(i);
    }

    @Test
    public void updateProduct() {
        Product product = new Product();
        product.setId(1);
        product.setProductId("2000");
        product.setIsEnable(0);
        product.setProductExplain("akjdflkajsdlfj");
        product.setProductBg("adfsdfasdf");
        product.setProductLogo("sd");
        product.setProductName("asd");
        int i = productDao.updateProduct(product);
        System.out.println(i);
    }

    @Test
    public void queryProductAndSubProduct() {
        Product product = productDao.queryProductAndSubProduct("1000");
        System.out.println(product.toString());
    }

    @Test
    public void queryProductList() {
        List<Product> products = productDao.queryProductList();
        System.out.println(products.toString());
    }
}