package com.xinruiyun.platform.service.product;

import com.xinruiyun.platform.entity.Product;

import java.util.List;

public interface ProductService {

    int addProduct(Product product);

    int deleteProduct(int id);

    int updateProduct(Product product);

    Product queryProductById(int id);

    Product queryProductAndSubProduct(String productId);

    List<Product> queryProductList();

    long getProductCount();
}
