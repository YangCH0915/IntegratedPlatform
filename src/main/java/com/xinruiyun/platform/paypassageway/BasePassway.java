package com.xinruiyun.platform.paypassageway;

import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.entity.UserInfo;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.entity.pay.PayPassageway;

public interface BasePassway {

    JSONObject pay(PayPassageway passageway, UserInfo userInfo, OrderInfo orderInfo);
}
