package com.xinruiyun.platform.paypassageway;

import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.entity.UserInfo;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.entity.pay.PayPassageway;
import com.xinruiyun.platform.http.OkHttpManager;
import com.xinruiyun.platform.utils.Log;
import com.xinruiyun.platform.encrypt.SignUtils;
import com.xinruiyun.platform.utils.XmlUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SwifiH5Pay implements BasePassway{

    private static final String SWIFI_URL = "https://pay.swiftpass.cn/pay/gateway";

    @Override
    public JSONObject pay(PayPassageway passageway, UserInfo userInfo, OrderInfo orderInfo) {

        JSONObject json = new JSONObject();
        Map<String,String> map = new HashMap<>();
        map.put("service","pay.weixin.wappay");
        map.put("version","2.0");
        map.put("charset","UTF-8");
        map.put("sign_type","MD5");
        map.put("mch_id", passageway.getMchId());
        map.put("out_trade_no", orderInfo.getOrderId());
        map.put("body", orderInfo.getProduct());
        map.put("attach",userInfo.getUserName());
        map.put("total_fee",((int)orderInfo.getMoney()*100)+"");
        map.put("mch_create_ip",orderInfo.getCreateIp());
        map.put("notify_url", userInfo.getNotifyUrl());
        map.put("callback_url",userInfo.getCallbackUrl());//前端页面跳转地址（包括支付成功和关闭时都会跳到这个地址）
        map.put("nonce_str", String.valueOf(new Date().getTime()));

        //注意：device_info、mch_app_name、mch_app_id这三个具体传值必须以文档说明为准，传真实有效的，否则有可能无法正常支付！！！
        map.put("device_info", "AND_WAP");
        map.put("mch_app_name", "易创迅驰");
        map.put("mch_app_id", "http://17yichuang.com/");
        Map<String,String> params = SignUtils.paraFilter(map);
        StringBuilder buf = new StringBuilder((params.size() +1) * 10);
        SignUtils.buildPayParams(buf,params,false);
        String preStr = buf.toString();
        String sign = DigestUtils.md5Hex(preStr+"&key=" +passageway.getMchKey());
        map.put("sign", sign);

        String xmlString = XmlUtils.parseXML(map);
        Log.i(getClass(),"威富通请求参数："+xmlString);
        String res = "";
        try {
            String result = OkHttpManager.getInstance().doPost(SWIFI_URL, xmlString);
            if(result != null && !result.equals("")){
                Map<String,String> resultMap = XmlUtils.toMap(result.getBytes("utf-8"), "utf-8");
                System.out.println("请求结果：" + resultMap.toString());
                if(resultMap.containsKey("sign")){
                    if(!SignUtils.checkParam(resultMap, passageway.getMchKey())){
                        res = "验证签名不通过";
                    }else{
                        if("0".equals(resultMap.get("status")) && "0".equals(resultMap.get("result_code"))){
                            String pay_info = resultMap.get("pay_info");
                            json.put("pay_info", pay_info);
                            json.put("out_trade_no", map.get("out_trade_no"));
                            json.put("total_fee", map.get("total_fee"));
                        }else{
                            json.put("result", res);
                        }
                    }
                }
            }else{
                res = "操作失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = "系统异常";
        }
        return json;
    }
}
