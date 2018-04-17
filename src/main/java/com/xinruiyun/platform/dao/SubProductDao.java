package com.xinruiyun.platform.dao;

import com.xinruiyun.platform.entity.SubProduct;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SubProductDao {

    int addSubProduct(@Param("sp")SubProduct subProduct);

    int deleteSubProduct(int id);

    int updateSubProduct(@Param("sp") SubProduct subProduct);

    SubProduct querySubProduct(int id);

    List<SubProduct> querySubProductList();

    List<SubProduct> querySubProductListByProductId(@Param("productId")String productId);

    long querySubProductCount();
}
