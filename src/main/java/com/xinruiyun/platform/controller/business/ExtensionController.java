package com.xinruiyun.platform.controller.business;

import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.dao.QCellCoreDao;
import com.xinruiyun.platform.dao.pay.OrderInfoDao;
import com.xinruiyun.platform.entity.QCellCore;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.paypassageway.SwifiGzhPay;
import com.xinruiyun.platform.paypassageway.SwifiH5Pay;
import com.xinruiyun.platform.utils.Constants;
import com.xinruiyun.platform.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/extension")
public class ExtensionController {

    @Autowired
    public OrderInfoDao orderInfoDao;

    @Autowired
    public SwifiH5Pay swifiH5Pay;

    @Autowired
    public QCellCoreDao qCellCoreDao;

    @Autowired
    public SwifiGzhPay swifiGzhPay;

    @RequestMapping(value = "mg77")
    @CrossOrigin(origins = Constants.COUL_URL)
    public void mangGuo7and7(HttpServletRequest request, HttpServletResponse response){
        try {
            String phone = request.getParameter("phone");
            JSONObject json = new JSONObject();
            if(phone != null){
               String sectionNo = phone.substring(0,7);
                QCellCore qCellCore = qCellCoreDao.getQCellCoreBysectionNo(sectionNo);
                if(qCellCore == null){
                    json.put("status",-1);//非浙江移动用户
                }else{
                    OrderInfo orderInfo = new OrderInfo();
                    orderInfo.setChannelId("00001");
                    orderInfo.setChannelName("未知");
                    orderInfo.setCreateIp(Tools.getIpAddress(request));
                    orderInfo.setMoney(9.9);
                    orderInfo.setProduct("mangguo002");
                    orderInfo.setRequestTime(new Date());
                    orderInfo.setUserInfo(phone);

                    boolean isWeiXin = Tools.isMicromessengerBrowser(request);
                    String url = "";
                    if(isWeiXin){//公众号支付
                        orderInfo.setMchId(SwifiH5Pay.MCH_ID);
                        orderInfo.setPayType("weixin_gzh");
                        orderInfo.setPayPassagewayName("威富通");
                        orderInfo.setOrderId(Tools.getOrder());
                        orderInfoDao.addOrderInfo(orderInfo);
                        url = swifiGzhPay.getCode(orderInfo.getOrderId());
                    }else{//H5支付
                        orderInfo.setMchId(SwifiH5Pay.MCH_ID);
                        orderInfo.setPayType("weixin_h5");
                        orderInfo.setPayPassagewayName("威富通");
                        orderInfo.setOrderId("YCXC"+Tools.getOrder());
                        orderInfoDao.addOrderInfo(orderInfo);
                        JSONObject jsonObject = swifiH5Pay.pay(orderInfo);
                        if(jsonObject.getString("status").equals("0")){
                            url = jsonObject.getString("pay_info");
                        }
                    }
                    json.put("url",url);
                    json.put("status",0);
                }
            }else{
                json.put("status",-2);//未上传电话号码
            }
            response.getWriter().write(json.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
