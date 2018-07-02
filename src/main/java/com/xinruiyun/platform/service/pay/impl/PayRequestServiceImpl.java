package com.xinruiyun.platform.service.pay.impl;

import com.xinruiyun.platform.dao.pay.OrderInfoDao;
import com.xinruiyun.platform.dao.pay.PayPassagewayDao;
import com.xinruiyun.platform.entity.product.SubProduct;
import com.xinruiyun.platform.entity.user.UserInfo;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.entity.pay.PayPassageway;
import com.xinruiyun.platform.paypassageway.PayPassagewayFactory;
import com.xinruiyun.platform.service.pay.PayRequestService;
import com.xinruiyun.platform.service.product.SubProductService;
import com.xinruiyun.platform.service.user.UserService;
import com.xinruiyun.platform.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        orderInfo.setPayPassagewayName(passageway.getPassagewayName());
        orderInfo.setOrderId("YCXC"+Tools.getOrder());
        orderInfoDao.addOrderInfo(orderInfo);

        String payUrl = PayPassagewayFactory.passageway(passageway.getPassagewayName(), payType).pay(orderInfo);
        return payUrl;
    }

    @Override
    public void notifyData(String tradeId, int status) {

    }
}
