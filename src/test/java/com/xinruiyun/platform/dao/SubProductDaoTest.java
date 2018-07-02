package com.xinruiyun.platform.dao;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.dao.product.SubProductDao;
import com.xinruiyun.platform.entity.product.SubProduct;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SubProductDaoTest extends BaseTest{

    @Autowired
    SubProductDao subProductDao;

    @Test
    public void addSubProduct() {
        SubProduct sp = new SubProduct();
        sp.setProductId("1000");
        sp.setSubProductId("1003");
        sp.setTitle("优酷VIP月卡");
        sp.setPrice(15);
        sp.setOriginalPrice(20);
        sp.setBillingCode("103948");
        sp.setRanking(0);
        sp.setIsShow(0);
        sp.setRemark("jikan");
        int i = subProductDao.addSubProduct(sp);
        System.out.println("插入结果："+i);
    }

    @Test
    public void deleteSubProduct() {
        int i = subProductDao.deleteSubProduct(1001);
        System.out.println("删除结果："+i);
    }

    @Test
    public void updateSubProduct() {
        SubProduct sp = new SubProduct();
        sp.setId(2);
        sp.setProductId("1000");
        sp.setSubProductId("1001");
        sp.setTitle("优酷VIP年卡");
        sp.setPrice(15);
        sp.setOriginalPrice(20);
        sp.setBillingCode("103948");
        sp.setRanking(0);
        sp.setIsShow(0);
        sp.setRemark("jikan");
        int i = subProductDao.updateSubProduct(sp);
        System.out.println("更新结果："+i);
    }

    @Test
    public void querySubProduct() {
        SubProduct subProduct = subProductDao.querySubProduct(1003);
        System.out.println(subProduct.toString());
    }

    @Test
    public void querySubProductList() {
        List<SubProduct> subProducts = subProductDao.querySubProductList();
        System.out.println(subProducts.toString());
    }

    @Test
    public void quereSubProductListByProductId() {
        List<SubProduct> subProducts = subProductDao.querySubProductListByProductId("1000");
        System.out.println(subProducts.toString());
    }
}