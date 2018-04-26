package com.xinruiyun.platform.controller.pay.notify;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.business.VideoMember;
import com.xinruiyun.platform.dao.pay.OrderInfoDao;
import com.xinruiyun.platform.encrypt.SignUtils;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.paypassageway.YinShiTongH5Pay;
import com.xinruiyun.platform.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/yst")
public class YinShiTongH5PayResult {

    @Autowired
    public OrderInfoDao orderInfoDao;

    @RequestMapping(value = "notify")
    public void ystNotify(HttpServletRequest request, HttpServletResponse response){
        try {
            Reader reader = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
            String body = IOUtils.read(reader);
            Log.i(getClass(),"异步通知结果："+body);
            JSONObject json = JSONObject.parseObject(body);
            String respCode = json.getString("respCode");
            String orderId = json.getString("merchorder_no");
            OrderInfo orderInfo = orderInfoDao.queryOrderInfoByOrderId(orderId);
            JSONObject responseJson = new JSONObject();
            if(orderInfo != null){
                if(respCode.equals("00")){
                    if(checkSign(json)){
                        responseJson.put("respCode","00");
                        Log.i(getClass(),"签名验证通过："+orderId);
                        response.getWriter().write(responseJson.toJSONString());
                        String platformId = json.getString("order_id");
                        orderInfo.setPlatformId(platformId);
                        orderInfo.setState(0);
                        orderInfo.setFinishTime(new Date());
                        orderInfoDao.updateOrderInfoState(orderInfo);

                        String liuliangUrl = "",vipUrl = "";
                        if(orderInfo.getUserInfo().equals("18566209357")){
                            liuliangUrl = VideoMember.TEST;
                            vipUrl = VideoMember.TEST;
                        }else{
                            liuliangUrl = VideoMember.LIULIANG_URL;
                            vipUrl = VideoMember.MANGGUO_URL;
                        }
                        //支付成功，发送流量充值请求
                        VideoMember.openMember(liuliangUrl,orderInfo.getOrderId(),
                                orderInfo.getUserInfo(),VideoMember.LIANTONG_PRODUCT_ID);
                        //支付成功，发送会员开通请求
                        VideoMember.openMember(vipUrl,orderInfo.getOrderId(),
                                orderInfo.getUserInfo(),VideoMember.MANGGUO_PRODUCT_ID);
                    }else{
                        responseJson.put("respCode","00");
                        response.getWriter().write(responseJson.toJSONString());
                        Log.i(getClass(),"签名验证失败："+orderId);
                    }
                }
            }else{
                responseJson.put("respCode","00");
                response.getWriter().write(responseJson.toJSONString());
                Log.i(getClass(),"订单号不存在:"+orderInfo.getOrderId());
            }
        } catch (IOException e) {
            Log.i(getClass(),"异常捕获:"+e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean checkSign(JSONObject json){
        String sign = json.getString("sign");
        json.remove("signature");
        json.remove("accNo");
        json.remove("reserved");
        json.remove("payCardType");
        Map<String,String> parse = (Map) JSON.parse(json.toJSONString());
        boolean b = SignUtils.checkParam(parse, YinShiTongH5Pay.NOTIFY_KEY);
        return b;
    }
}
