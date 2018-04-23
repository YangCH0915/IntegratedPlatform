package com.xinruiyun.platform.paypassageway;

import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.http.OkHttpManager;
import com.xinruiyun.platform.utils.Encrypt;
import com.xinruiyun.platform.utils.Log;
import com.xinruiyun.platform.utils.Tools;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Service
public class YinShiTongH5Pay {

    private static final String URL = "https://pay2.100bsh.com:180/dps/waptest/order";
    public static final String MCH_ID = "939290048990099";
    private static final String MCH_KEY = "8065BDC8C977D47280EADEBBFEA8F398";

    public String orderRequest(OrderInfo orderInfo) throws UnsupportedEncodingException {
        JSONObject json = new JSONObject();
        json.put("service","wechatH5.apiorder");
        json.put("formid","000000000008644");
        json.put("sdkInfo","01.01.01M");
        json.put("signtype","SHA512");
        json.put("sign","");
        json.put("charest","utf-8");

        JSONObject requestData = new JSONObject();
        requestData.put("orderid",orderInfo.getOrderId());
        requestData.put("orgcode","60088888");
        requestData.put("merno",MCH_ID);
        requestData.put("transdate", Tools.getDateTime());
        int money = (int) (orderInfo.getMoney()*100);
        requestData.put("txnAmt","000000000"+money);
        requestData.put("orderInfo", URLEncoder.encode("7天通用流量+7天芒果会员","utf-8"));
        requestData.put("return_url","https://qy.17yichuang.com/vip/index.html");
        requestData.put("notify_url","https://qy.17yichuang.com/extension/notify");

        JSONObject appInfo = new JSONObject();
        appInfo.put("requestFrom","WAP");
        appInfo.put("app_name","");
        appInfo.put("bundle_id","");
        appInfo.put("package_name","");
        appInfo.put("wap_url","https://qy.17yichuang.com/vip/index.html");
        appInfo.put("wap_name", "易创迅驰");
        appInfo.put("note",orderInfo.getOrderId());
        appInfo.put("attach",Tools.getTimestamp());
        requestData.put("app_Info",appInfo);
        json.put("requestData",requestData);
        json.put("sign", Encrypt.HmacSHA512(json.toJSONString(),MCH_KEY));
        Log.i(YinShiTongH5Pay.class,"支付请求参数："+json.toJSONString());

        String body = OkHttpManager.getInstance().doPostJson(URL, json.toJSONString());
        Log.i(YinShiTongH5Pay.class,"返回结果："+body);
        JSONObject result = JSONObject.parseObject(body);
        String resultCode = result.getString("resultcode");
        if(resultCode.equals("0000")){
            JSONObject responsedata = result.getJSONObject("responsedata");
            String errorcode = responsedata.getString("errorcode");
            String orderid = responsedata.getString("orderid");
            if(errorcode.equals("0000")){
                String postStr = responsedata.getString("postStr");
                String postURL = responsedata.getString("postURL");
                postStr = URLDecoder.decode(postStr,"utf-8");
                postURL = URLDecoder.decode(postURL,"utf-8");
                String postUrl = postURL+"?"+postStr;
                System.out.println("H5地址："+postUrl);
                return postUrl;
            }else{
                String errorinfo = responsedata.getString("errorinfo");
                Log.i(YinShiTongH5Pay.class,"返回结果异常："+errorinfo+"--订单号："+orderid);
            }
        }else{
            Log.i(YinShiTongH5Pay.class,"请求失败");
        }
        return "";
    }
}
