package com.xinruiyun.platform.controller.business;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.dao.pay.OrderInfoDao;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.paypassageway.YinShiTongH5Pay;
import com.xinruiyun.platform.utils.Constants;
import com.xinruiyun.platform.utils.Log;
import com.xinruiyun.platform.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;

@Controller
@CrossOrigin(origins = Constants.COUL_URL)
@RequestMapping("/extension")
public class ExtensionController {

    @Autowired
    public OrderInfoDao orderInfoDao;

    @Autowired
    public YinShiTongH5Pay yinShiTongH5Pay;

    @RequestMapping(value = "mg77")
    public void mangGuo7and7(HttpServletRequest request, HttpServletResponse response){
        try {
            String phone = request.getParameter("phone");
            System.out.println("电话号码："+phone);
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setChannelId("00001");
            orderInfo.setChannelName("未知");
            orderInfo.setCreateIp(Tools.getIpAddress(request));
            orderInfo.setMchId("939290048990099");
            orderInfo.setMoney(9.9);
            orderInfo.setOrderId("YCXC"+Tools.getOrder());
            orderInfo.setPayPassagewayName("银视通");
            orderInfo.setPayType("weixin_h5");
            orderInfo.setProduct("mangguo002");
            orderInfo.setRequestTime(new Date());
            orderInfo.setUserInfo(phone);
            orderInfoDao.addOrderInfo(orderInfo);
            String s = yinShiTongH5Pay.orderRequest(orderInfo);
            response.getWriter().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "notify")
    public void ystNotify(HttpServletRequest request, HttpServletResponse response){
        try {
            Reader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String body = IOUtils.read(reader);
            Log.i(getClass(),"异步通知结果："+body);
            JSONObject json = JSONObject.parseObject(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkSign(JSONObject json){
       String sign = json.getString("sign");
       return true;
    }
}
