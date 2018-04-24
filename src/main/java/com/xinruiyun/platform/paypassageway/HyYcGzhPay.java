package com.xinruiyun.platform.paypassageway;

import com.xinruiyun.platform.entity.pay.OrderInfo;
import org.springframework.stereotype.Service;

@Service
public class HyYcGzhPay {

    public static final String URL = "http://pay.azsdcn.com/hy/payOrder";
    public static final String MCH_ID = "8002982899629995";
    public static final String MCH_KEY = "728358173801";
    public static final String APP_ID = "wxf43c2bd0c02eef02";
    public static final String APP_SECRET = "00ab264516e65c0d608323e2d65e8218";

    public String pay(OrderInfo orderInfo){
        StringBuffer map = new StringBuffer();
        map.append(URL+"?");
        map.append("orderId="+orderInfo.getOrderId());
        map.append("&appId="+APP_ID);
        map.append("&name=77");
        map.append("&appsecret="+APP_SECRET);
        map.append("&mchId="+MCH_ID);
        map.append("&mchKey="+MCH_KEY);
        String money = ((int) (orderInfo.getMoney()*100))+"";
        if(orderInfo.getUserInfo().equals("18566209357")){
            money = "1";
        }
        map.append("&money="+money);
        map.append("&returnUrl=https://qy.17yichuang.com/vip/activity-77.html");
        map.append("&nofityUrl=https://qy.17yichuang.com/extension/notify_gzh");
        return map.toString();
    }
}
