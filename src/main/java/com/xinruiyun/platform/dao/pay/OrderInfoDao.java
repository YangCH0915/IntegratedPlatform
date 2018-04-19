package com.xinruiyun.platform.dao.pay;

import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.entity.pay.PayPassageway;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoDao {

    int addOrderInfo(@Param("oi")OrderInfo orderInfo);

    int deleteOrderInfo(int id);

    int updateOrderInfoState(@Param("oi")OrderInfo orderInfo);

    OrderInfo queryOrderInfoById(int id);

    OrderInfo queryOrderInfoByOrderId(String orderId);

    List<OrderInfo> queryOrderInfoListByPage(@Param("offset") int offset, @Param("limit") int limit);

    long queryPassagewayCount();
}
