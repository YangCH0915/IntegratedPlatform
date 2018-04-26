package com.xinruiyun.platform.controller.pay.notify;

import com.xinruiyun.platform.business.VideoMember;
import com.xinruiyun.platform.dao.pay.OrderInfoDao;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.paypassageway.HuaYiGzhPay;
import com.xinruiyun.platform.utils.Log;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 华移支付结果通知管理类
 */
@Controller
@RequestMapping("/huayi")
public class HuaYiGzhPayResult {

    @Autowired
    public OrderInfoDao orderInfoDao;

    @RequestMapping(value = "/notify_gzh")
    public void notifyGzh(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String> map = new HashMap<>();
        String orderNo  = request.getParameter("orderNo");
        String sign  = request.getParameter("sign");
        map.put("orderNo", orderNo);
        map.put("total", request.getParameter("total"));
        map.put("merchantNo", request.getParameter("merchantNo"));
        map.put("code", request.getParameter("code"));
        map.put("timestamp", request.getParameter("timestamp"));
        Log.i(this.getClass(), "公众号异步数据:"+map.toString());

        OrderInfo orderInfo = orderInfoDao.queryOrderInfoByOrderId(orderNo);
        if(orderInfo != null){
            if(creatAliSign(map, HuaYiGzhPay.MCH_KEY).equals(sign)){
                response.getWriter().write("success");
                Log.i(this.getClass(), "验证签名通过,正常统计:"+orderNo);
                orderInfo.setPlatformId("");
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
                Log.i(this.getClass(), "验证签名失败:"+orderNo);
                response.getWriter().write("fail");
            }
        }else{
            Log.i(this.getClass(), "订单号不存在:"+orderNo);
            response.getWriter().write("success");
        }
    }

    public static String creatAliSign(Map<String,String> map,String sigkey){
        StringBuffer sb = new StringBuffer();
        List<String> keys = new ArrayList<String>(map.keySet());
        Collections.sort(keys);
        for(String key : keys){
            sb.append(key).append("=");
            sb.append(map.get(key));
        }
        sb.append(sigkey);
        return DigestUtils.md5Hex(sb.toString()).toLowerCase();
    }
}
