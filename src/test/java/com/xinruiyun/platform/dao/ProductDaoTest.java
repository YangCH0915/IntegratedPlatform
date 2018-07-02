package com.xinruiyun.platform.dao;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.dao.product.ProductDao;
import com.xinruiyun.platform.entity.product.Product;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

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
        int i = productDao.deleteProduct(1);
        System.out.println(i);
    }

    @Test
    public void updateProduct() {
        Product product = new Product();
        product.setId(14);
        product.setProductId("1004561");
        product.setIsEnable(1);
        product.setProductExplain("院线大片任性看,赠送观影券大片免费看,视频播放免广告");
        product.setProductBg("");
        product.setProductLogo("");
        product.setProductName("搜狐会员");
        product.setUpdateTime(new Date());
        int i = productDao.updateProduct(product);
        System.out.println(i);
    }

    @Test
    public void queryProductAndSubProduct() {
        Product product = productDao.queryProductAndSubProduct("1004561");
        System.out.println(product.toString());
    }

    @Test
    public void queryProductList() {
        List<Product> products = productDao.queryProductList();
        System.out.println(products.toString());
    }

    @Test
    public void getProductCount(){
        System.out.println("输出查询结果："+productDao.queryProductCount());
    }

    @Test
    public void queryProductById(){
        System.out.println("输出查询结果："+productDao.queryProductById(8));
    }
}