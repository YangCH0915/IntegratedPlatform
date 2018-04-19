package com.xinruiyun.platform.service.pay;

import com.xinruiyun.platform.dto.pay.PayInfo;
import com.xinruiyun.platform.entity.pay.OrderInfo;

public interface PayRequestService {

    /**
     * 订单支付接口
     */
    void orderPay(PayInfo payInfo);

    /**
     * 订单异步回调接口
     */
    void orderNotify(OrderInfo orderInfo);
}
