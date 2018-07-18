package com.xinruiyun.platform.paypassageway;

import com.alibaba.fastjson.JSON;
import com.xinruiyun.platform.encrypt.SignUtils;
import com.xinruiyun.platform.http.OkHttpManager;
import com.xinruiyun.platform.utils.Log;
import com.xinruiyun.platform.utils.Tools;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KaihuiAliPay {

    private static final String REQUEST_URL = "http://39.106.164.71:3020/api/pay/create_order";

    public static final String APP_ID = "918ea8a3abc545868d43d193bbbf051d";
    public static final String MCH_ID = "20000000";
    public static final String REQUEST_KEY = "F5Owd7m2ILuQF4TwvSXLvYFmYaHvJwcwc0zeZY8EFfvHqUti";
    public static final String RESPONSE_KEY = "JZ9LVj35CPckkpouLqL6BxOL09MtOaD8pwSf6Kpt3FouRMJh";

    public static void pay(String money) {

        Map<String, String> map = new HashMap<>();
        map.put("appId", APP_ID);
        map.put("mchId", MCH_ID);
        map.put("passageId", "3");
        map.put("channelId", "alipay_wap");
        map.put("mchOrderNo", Tools.getOrder());
        map.put("currency", "cny");
        map.put("amount", money);
        map.put("subject", "test");
        map.put("body", "MWEB");
        map.put("notifyUrl", "https://qy.17yichuang.com/swifi/notify");
        map.put("sign", SignUtils.md5(map, REQUEST_KEY));

        String jsonStr = JSON.toJSONString(map);
        Log.i(KaihuiAliPay.class, "快汇请求参数：" + map.toString());

        String requestUrl = REQUEST_URL + "?params=" + jsonStr;
        System.out.println(requestUrl);
        String result = OkHttpManager.getInstance().doGet(requestUrl);
        if (result != null && !result.equals("")) {
            Log.i(KaihuiAliPay.class, "请求结果：" + result);
        }
    }

    public static void main(String[] args) {
        pay("1");
    }
}
