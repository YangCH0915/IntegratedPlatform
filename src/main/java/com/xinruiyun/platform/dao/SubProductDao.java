package com.xinruiyun.platform.dao;

import com.xinruiyun.platform.entity.SubProduct;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SubProductDao {

    int addSubProduct(@Param("sp")SubProduct subProduct);

    int deleteSubProduct(@Param("subProductId") String subProductId);

    int updateSubProduct(@Param("sp") SubProduct subProduct);

    SubProduct querySubProduct(@Param("subProductId")String subProductId);

    List<SubProduct> querySubProductList();

    List<SubProduct> querySubProductListByProductId(@Param("productId")String productId);
}
