package com.xinruiyun.platform.service.product;

import com.xinruiyun.platform.entity.Product;

import java.util.List;

public interface ProductService {

    int addProduct(Product product);

    int deleteProduct(String productId);

    int updateProduct(Product product);

    Product queryProductAndSubProduct(String productId);

    List<Product> queryProductList();

    long getProductCount();
}
