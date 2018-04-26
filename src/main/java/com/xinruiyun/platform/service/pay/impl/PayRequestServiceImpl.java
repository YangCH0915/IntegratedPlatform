package com.xinruiyun.platform.service.pay.impl;

import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.dao.SubProductDao;
import com.xinruiyun.platform.dao.pay.OrderInfoDao;
import com.xinruiyun.platform.dao.pay.PayPassagewayDao;
import com.xinruiyun.platform.dto.pay.PayInfo;
import com.xinruiyun.platform.entity.SubProduct;
import com.xinruiyun.platform.entity.UserInfo;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.entity.pay.PayPassageway;
import com.xinruiyun.platform.paypassageway.SwifiH5Pay;
import com.xinruiyun.platform.service.pay.PayRequestService;
import com.xinruiyun.platform.service.product.SubProductService;
import com.xinruiyun.platform.service.user.UserService;
import com.xinruiyun.platform.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PayRequestServiceImpl implements PayRequestService{

    @Autowired
    public SubProductService subProductService;
    @Autowired
    public PayPassagewayDao passagewayDao;
    @Autowired
    public OrderInfoDao orderInfoDao;
    @Autowired
    public UserService userService;

    @Override
    public String pay(String phone, String userIp,String subProductId,String channelId, String payType) {

        UserInfo userInfo = userService.queryUserByUsername(channelId);
        SubProduct subProduct = subProductService.querySubProductBySubProductId(subProductId);
        PayPassageway passageway = null;

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setChannelId(userInfo.getUserName());
        orderInfo.setChannelName(userInfo.getUaName());
        orderInfo.setCreateIp(userIp);
        orderInfo.setMoney(subProduct.getPrice());
        orderInfo.setProduct(subProduct.getProductName());
        orderInfo.setRequestTime(new Date());
        orderInfo.setUserInfo(phone);
        orderInfo.setPayType(payType);
        orderInfo.setMchId(passageway.getMchId());
        orderInfo.setPayPassagewayName(passageway.getPassageName());
        orderInfo.setOrderId("YCXC"+Tools.getOrder());
        orderInfoDao.addOrderInfo(orderInfo);

        boolean isWeiXin = true;
        String url = "";
        if(isWeiXin){//公众号支付

//            url = swifiGzhPay.getCode(orderInfo.getOrderId());
        }else{//H5支付
//            JSONObject jsonObject = swifiH5Pay.pay(orderInfo);
//            if(jsonObject.getString("status").equals("0")){
//                url = jsonObject.getString("pay_info");
//            }
        }
        return null;
    }

    @Override
    public void notifyData(String tradeId, int status) {

    }
}
