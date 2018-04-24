package com.xinruiyun.platform.dao.pay;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class OrderInfoDaoTest extends BaseTest{

    @Autowired
    public OrderInfoDao orderInfoDao;

    @Test
    public void addOrderInfo() {
    }

    @Test
    public void deleteOrderInfo() {
    }

    @Test
    public void updateOrderInfoState() {
    }

    @Test
    public void queryOrderInfoById() {
    }

    @Test
    public void queryOrderInfoByOrderId() {
        OrderInfo orderInfo = orderInfoDao.queryOrderInfoByOrderId("YCXC1000001911329661");
        System.out.println(orderInfo.toString());
    }

    @Test
    public void queryOrderInfoListByPage() {
    }

    @Test
    public void queryPassagewayCount() {
    }
}