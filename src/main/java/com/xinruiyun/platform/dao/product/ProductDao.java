package com.xinruiyun.platform.dao.product;

import com.xinruiyun.platform.entity.product.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductDao {

    int addProduct(@Param("p") Product product);

    int deleteProduct(int id);

    int updateProduct(@Param("p")Product product);

    Product queryProductById(int id);

    Product queryProductAndSubProduct(@Param("productId")String productId);

    List<Product> queryProductList();

    long queryProductCount();
}
