package com.xinruiyun.platform.service.product;

import com.xinruiyun.platform.entity.SubProduct;

import java.util.List;

public interface SubProductService {

    int addSubProduct(SubProduct subProduct);

    int deleteSubProduct(int id);

    int updateSubProduct(SubProduct subProduct);

    SubProduct querySubProduct(int id);

    List<SubProduct> querySubProductList();

    List<SubProduct> querySubProductListByProductId(String productId);

    long querySubProductCount();
}
