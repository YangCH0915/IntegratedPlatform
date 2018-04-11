package com.xinruiyun.platform.service.product;

import com.xinruiyun.platform.entity.SubProduct;

import java.util.List;

public interface SubProductService {

    int addSubProduct(SubProduct subProduct);

    int deleteSubProduct(String subProductId);

    int updateSubProduct(SubProduct subProduct);

    SubProduct querySubProduct(String subProductId);

    List<SubProduct> querySubProductList();

    List<SubProduct> querySubProductListByProductId(String productId);
}
