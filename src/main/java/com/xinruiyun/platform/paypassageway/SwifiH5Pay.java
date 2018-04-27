package com.xinruiyun.platform.paypassageway;

import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.entity.UserInfo;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.entity.pay.PayPassageway;
import com.xinruiyun.platform.http.OkHttpManager;
import com.xinruiyun.platform.utils.Log;
import com.xinruiyun.platform.encrypt.SignUtils;
import com.xinruiyun.platform.utils.Tools;
import com.xinruiyun.platform.utils.XmlUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SwifiH5Pay implements BasePayPassageway{

    private static final String SWIFI_URL = "https://pay.swiftpass.cn/pay/gateway";

    public static final String MCH_ID = "102585560100";

    public String pay(OrderInfo orderInfo) {

        JSONObject json = new JSONObject();
        Map<String,String> map = new HashMap<>();
        map.put("service","pay.weixin.wappay");
        map.put("version","2.0");
        map.put("charset","UTF-8");
        map.put("sign_type","RSA_1_256");
        map.put("mch_id", MCH_ID);
        map.put("out_trade_no", orderInfo.getOrderId());
        map.put("body", orderInfo.getProduct());
        map.put("attach",orderInfo.getUserInfo());
        String money = ((int) (orderInfo.getMoney()*100))+"";
        if(orderInfo.getUserInfo().equals(PayPassagewayFactory.TEST_PHONE)){
            money = "1";
        }
        map.put("total_fee",money);
        map.put("mch_create_ip",orderInfo.getCreateIp());
        map.put("notify_url", "https://qy.17yichuang.com/swifi/notify");
        map.put("callback_url","https://qy.17yichuang.com/vip/activity-77.html");//前端页面跳转地址（包括支付成功和关闭时都会跳到这个地址）
        map.put("nonce_str", String.valueOf(new Date().getTime()));

        //注意：device_info、mch_app_name、mch_app_id这三个具体传值必须以文档说明为准，传真实有效的，否则有可能无法正常支付！！！
        map.put("device_info", "AND_WAP");
        map.put("mch_app_name", "易创迅驰");
        map.put("mch_app_id", "http://17yichuang.com/");
        Map<String,String> params = SignUtils.paraFilter(map);
        StringBuilder buf = new StringBuilder((params.size() +1) * 10);
        SignUtils.buildPayParams(buf,params,false);
        String preStr = buf.toString();
        String sign = SignUtils.rasSignData(preStr, "C:/key/app_private_key_pkcs8.pem");
        map.put("sign", sign);
        String xmlString = XmlUtils.parseXML(map);
        Log.i(SwifiH5Pay.class,"威富通请求参数："+map.toString());

        String resultStr = "";
        try {
            String result = OkHttpManager.getInstance().doPost(SWIFI_URL, xmlString);
            if(result != null && !result.equals("")){
                Map<String,String> resultMap = XmlUtils.toMap(result.getBytes("utf-8"), "utf-8");
                Log.i(SwifiH5Pay.class,"请求结果：" + resultMap.toString());
                if(resultMap.containsKey("sign")){
                    if(!SignUtils.rasValidateSignData(resultMap, "C:/key/platform_public_key.pem")){
                        json.put("status","-1");
                        json.put("msg","验证签名不通过");
                        resultStr = json.toJSONString();
                    }else{
                        if("0".equals(resultMap.get("status")) && "0".equals(resultMap.get("result_code"))){
                            resultStr = resultMap.get("pay_info");
                        }else{
                            json.put("status","-2");
                            json.put("msg","fail");
                            resultStr = json.toJSONString();
                        }
                    }
                }
            }else{
                json.put("status","-3");
                json.put("msg","操作失败");
                resultStr = json.toJSONString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("status","-4");
            json.put("msg","请求出现异常");
            resultStr = json.toJSONString();
        }
        return resultStr;
    }
}
