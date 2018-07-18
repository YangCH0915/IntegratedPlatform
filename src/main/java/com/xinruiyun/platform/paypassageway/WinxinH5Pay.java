package com.xinruiyun.platform.paypassageway;

import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.encrypt.SignUtils;
import com.xinruiyun.platform.http.OkHttpManager;
import com.xinruiyun.platform.utils.Log;
import com.xinruiyun.platform.utils.Tools;
import com.xinruiyun.platform.utils.XmlUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class WinxinH5Pay{

    private static final String REQUEST_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    public static final String APP_ID = "wx875d2a3c9570ab17";
    public static final String MCH_ID = "1510045931";
    public static final String MCH_KEY = "hubeigaoweiwangluokeji1736412248";

    public static String pay(String money,HttpServletRequest request) {

        JSONObject json = new JSONObject();
        Map<String,String> map = new HashMap<>();
        map.put("appid",APP_ID);
        map.put("mch_id", MCH_ID);
        map.put("body", "test");
        map.put("out_trade_no", Tools.getOrder());
        map.put("total_fee",money);
        map.put("spbill_create_ip",Tools.getIpAddress(request));
        map.put("trade_type","MWEB");
        map.put("sign_type","MD5");
        map.put("attach",Tools.getTimestamp()+"");
        map.put("nonce_str", String.valueOf(new Date().getTime()));
        map.put("notify_url", "https://qy.17yichuang.com/swifi/notify");
//        map.put("callback_url","https://qy.17yichuang.com/vip/activity-77.html");//前端页面跳转地址（包括支付成功和关闭时都会跳到这个地址）

        JSONObject j1 = new JSONObject();
        JSONObject j2 = new JSONObject();
        j2.put("type","Wap");
        j2.put("wap_url","https://qy.17yichuang.com/swifi/notify");
        j2.put("wap_name","易创迅驰");
        j1.put("h5_info",j2.toJSONString());
        map.put("scene_info",j1.toJSONString());

        map.put("sign", SignUtils.md5(map,MCH_KEY));
        String xmlString = XmlUtils.parseXML(map);
        Log.i(WinxinH5Pay.class,"威富通请求参数："+map.toString());

        String resultStr = "";
        try {
            String result = OkHttpManager.getInstance().doPost(REQUEST_URL, xmlString);
            if(result != null && !result.equals("")){
                Map<String,String> resultMap = XmlUtils.toMap(result.getBytes("utf-8"), "utf-8");
                Log.i(WinxinH5Pay.class,"请求结果：" + resultMap.toString());
                if(resultMap.containsKey("sign")){
                    if(!SignUtils.checkMd5(resultMap, MCH_KEY)){
                        json.put("status","-1");
                        json.put("msg","验证签名不通过");
                        resultStr = json.toJSONString();
                    }else{
                        if("SUCCESS".equals(resultMap.get("result_code")) && "SUCCESS".equals(resultMap.get("return_code"))){
                            resultStr = resultMap.get("mweb_url");
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
