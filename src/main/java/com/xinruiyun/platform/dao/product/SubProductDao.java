package com.xinruiyun.platform.dao.product;

import com.xinruiyun.platform.entity.product.SubProduct;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SubProductDao {

    int addSubProduct(@Param("sp")SubProduct subProduct);

    int deleteSubProduct(int id);

    int updateSubProduct(@Param("sp") SubProduct subProduct);

    SubProduct querySubProduct(int id);

    SubProduct querySubProductBySubProductId(String subProductId);

    List<SubProduct> querySubProductList();

    List<SubProduct> querySubProductListByProductId(String productId);

    long querySubProductCount();
}
