package com.xinruiyun.platform.paypassageway;

import com.xinruiyun.platform.entity.pay.OrderInfo;

public interface BasePaypassway {

    String pay(OrderInfo orderInfo);

    void notifyData();
}
