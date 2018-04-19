package com.xinruiyun.platform.service.pay.impl;

import com.xinruiyun.platform.dao.SubProductDao;
import com.xinruiyun.platform.dao.pay.OrderInfoDao;
import com.xinruiyun.platform.dao.pay.PayPassagewayDao;
import com.xinruiyun.platform.dto.pay.PayInfo;
import com.xinruiyun.platform.entity.SubProduct;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.service.pay.PayRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayRequestServiceImpl implements PayRequestService{

    @Autowired
    public SubProductDao subProductDao;

    @Autowired
    public PayPassagewayDao passagewayDao;

    @Autowired
    public OrderInfoDao orderInfoDao;

    @Override
    public void orderPay(PayInfo payInfo) {
        SubProduct subProduct = subProductDao.querySubProductBySubProductId(payInfo.getSubProductId());
        
    }

    @Override
    public void orderNotify(OrderInfo orderInfo) {

    }
}
