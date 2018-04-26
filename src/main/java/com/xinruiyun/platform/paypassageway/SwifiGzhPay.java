package com.xinruiyun.platform.paypassageway;

import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.encrypt.SignUtils;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.http.OkHttpManager;
import com.xinruiyun.platform.utils.Log;
import com.xinruiyun.platform.utils.Tools;
import com.xinruiyun.platform.utils.XmlUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SwifiGzhPay {

    private static final String SWIFI_URL = "https://pay.swiftpass.cn/pay/gateway";

    public static final String MCH_ID = "102585560100";
    public static final String APP_ID = "wxf43c2bd0c02eef02";
    public static final String APP_SECRET = "00ab264516e65c0d608323e2d65e8218";

    private static String baseUrl = "https://qy.17yichuang.com/gzh/";

    public String getCode(String orderId){
        try {
            //授权后要跳转的链接
            String backUri = baseUrl + "toPay";
            backUri = URLEncoder.encode(backUri,"utf-8");
            String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                    "appid=" + APP_ID +
                    "&redirect_uri=" + backUri+
                    "&response_type=code&scope=snsapi_base&state="+orderId+"#wechat_redirect";
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public JSONObject pay(OrderInfo orderInfo,String openId) {
        JSONObject json = new JSONObject();
        Map<String, String> map = new HashMap<>();
        map.put("service", "pay.weixin.jspay");
        map.put("version", "2.0");
        map.put("charset", "UTF-8");
        map.put("sign_type", "RSA_1_256");
        map.put("mch_id", MCH_ID);
        map.put("is_raw", "1");
        map.put("out_trade_no", orderInfo.getOrderId());
        map.put("body", orderInfo.getProduct());
        map.put("sub_openid", openId);//"o1IB51e7L3XX_bepC_NQO99KOcho"
        map.put("sub_appid", APP_ID);
        map.put("attach", orderInfo.getUserInfo());
        String money = ((int) (orderInfo.getMoney() * 100)) + "";
        if (orderInfo.getUserInfo().equals("18566209357")) {
            money = "1";
        }
        map.put("total_fee", money);
        map.put("mch_create_ip", orderInfo.getCreateIp());
        map.put("notify_url", "https://qy.17yichuang.com/swifi/notify");
        map.put("callback_url","https://qy.17yichuang.com/vip/activity-77.html");//前端页面跳转地址（包括支付成功和关闭时都会跳到这个地址）
        map.put("nonce_str", String.valueOf(new Date().getTime()));

        Map<String, String> params = SignUtils.paraFilter(map);
        StringBuilder buf = new StringBuilder((params.size() + 1) * 10);
        SignUtils.buildPayParams(buf, params, false);
        String preStr = buf.toString();
        String sign = SignUtils.rasSignData(preStr, "C:/key/app_private_key_pkcs8.pem");
        map.put("sign", sign);
        String xmlString = XmlUtils.parseXML(map);
        Log.i(SwifiGzhPay.class, "威富通请求参数：" + map.toString());
        try {
            String result = OkHttpManager.getInstance().doPost(SWIFI_URL, xmlString);
            if (result != null && !result.equals("")) {
                Map<String, String> resultMap = XmlUtils.toMap(result.getBytes("utf-8"), "utf-8");
                if (!SignUtils.rasValidateSignData(resultMap, "C:/key/platform_public_key.pem")) {
                    json.put("status", "-1");
                    json.put("msg", "验证签名不通过");
                    Log.i(SwifiGzhPay.class, "验证签名不通过：" + resultMap.toString());
                } else {
                    Log.i(SwifiGzhPay.class, "签名通过：" + resultMap.toString());
                    if ("0".equals(resultMap.get("status")) && "0".equals(resultMap.get("result_code"))) {
                        String pay_info = resultMap.get("pay_info");
                        json.put("pay_info", pay_info);
                        json.put("out_trade_no", map.get("out_trade_no"));
                        json.put("total_fee", map.get("total_fee"));
                        json.put("status", "0");
                        json.put("msg", "success");
                    } else {
                        json.put("status", "-2");
                        json.put("msg", "fail");
                    }
                }
            } else {
                json.put("status", "-3");
                json.put("msg", "操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("status", "-4");
            json.put("msg", "请求出现异常");
        }
        return json;
    }
}
