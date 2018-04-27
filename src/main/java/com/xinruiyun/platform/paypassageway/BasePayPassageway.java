package com.xinruiyun.platform.paypassageway;

import com.xinruiyun.platform.entity.pay.OrderInfo;

public interface BasePayPassageway {

    String pay(OrderInfo orderInfo);
}
