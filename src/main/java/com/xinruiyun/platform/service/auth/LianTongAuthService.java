package com.xinruiyun.platform.service.auth;

import com.xinruiyun.platform.http.OkHttpManager;
import com.xinruiyun.platform.utils.Log;
import com.xinruiyun.platform.utils.Tools;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class LianTongAuthService {

    private String getTokenUrl = "http://qy.chinaunicom.cn/mobile/api/getTokenWithPhone?";
    private static final String CHANNEL_ID = "285911";
    private static final String CHANNEL_KEY = "c1abab223f94322929dc54854bc55606";
    /**
     * 联通鉴权中心，免登陆协议
     */
    public String loginAuth(String phone){
        try {
            StringBuffer sb = new StringBuffer();
            sb.append(getTokenUrl);
            sb.append("channelId=" + CHANNEL_ID);
            long timestamp = Tools.getTimestamp();
            sb.append("&timestamp=" + timestamp);
            String orderNo = Tools.getOrder();
            sb.append("&requestNo=" + orderNo);
            sb.append("&phone=" + phone);
            String sign = DigestUtils.md5Hex(CHANNEL_ID + CHANNEL_KEY + timestamp + phone);
            sb.append("&sign=" + sign);
            Log.i(getClass(),"联通免登陆请求："+sb.toString());
            return OkHttpManager.getInstance().doGet(sb.toString());
        }catch (Exception e){
            Log.i(getClass(),"联通免登陆请求异常："+e.toString());
        }
      return "";
    }
}