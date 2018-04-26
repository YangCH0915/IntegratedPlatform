package com.xinruiyun.platform.dao;

import com.xinruiyun.platform.entity.CompositeProduct;

import java.util.List;

public interface CompositeProductDao {

    int addCompositeProduct(CompositeProduct compositeProduct);

    int deleteCompositeProduct(int id);

    int deleteCompositeProduct(String subProductId,String channelId);

    int updateCompositeProduct(CompositeProduct compositeProduct);

    /**
     *  返回支付通道id
     * @param subProductId
     * @param channelId
     * @return
     */
    String queryCompositeProduct(String subProductId,String channelId);

    List<CompositeProduct> queryCompositeProduct();
}
