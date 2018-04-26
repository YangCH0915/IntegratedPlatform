package com.xinruiyun.platform.controller.pay.notify;

import com.xinruiyun.platform.business.VideoMember;
import com.xinruiyun.platform.dao.pay.OrderInfoDao;
import com.xinruiyun.platform.encrypt.SignUtils;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.utils.Log;
import com.xinruiyun.platform.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/swifi")
public class SwifiPayResult {

    @Autowired
    public OrderInfoDao orderInfoDao;

    @RequestMapping(value = "notify")
    public void ystNotify(HttpServletRequest request, HttpServletResponse response) {
        try {
            String resString = XmlUtils.parseRequst(request);
            if (resString != null && !"".equals(resString)) {
                Map<String, String> map = XmlUtils.toMap(resString.getBytes(), "utf-8");
                Log.i(getClass(), "异步通知结果：" + map.toString());
                if (map.containsKey("sign")) {
                    if (!SignUtils.rasValidateSignData(map, "C:/key/platform_public_key.pem")) {
                        response.getWriter().write("fail");
                        Log.i(getClass(), "签名验证不通过：" + map.get("out_trade_no"));
                    } else {
                        response.getWriter().write("success");
                        String status = map.get("status");
                        if (status != null && "0".equals(status)) {
                            String result_code = map.get("result_code");
                            if (result_code != null && "0".equals(result_code)) {
                                String orderId = map.get("out_trade_no");
                                OrderInfo orderInfo = orderInfoDao.queryOrderInfoByOrderId(orderId);
                                Log.i(getClass(), "签名验证通过：" + orderId);
                                if (orderInfo != null && orderInfo.getState() != 0) {
                                    String platformId = map.get("transaction_id");
                                    orderInfo.setPlatformId(platformId);
                                    orderInfo.setState(0);
                                    orderInfo.setFinishTime(new Date());
                                    orderInfoDao.updateOrderInfoState(orderInfo);

                                    String liuliangUrl = "", vipUrl = "";
                                    if (orderInfo.getUserInfo().equals("18566209357")) {
                                        liuliangUrl = VideoMember.TEST;
                                        vipUrl = VideoMember.TEST;
                                    } else {
                                        liuliangUrl = VideoMember.LIULIANG_URL;
                                        vipUrl = VideoMember.MANGGUO_URL;
                                    }
                                    //支付成功，发送流量充值请求
                                    VideoMember.openMember(liuliangUrl, orderInfo.getOrderId(),
                                            orderInfo.getUserInfo(), VideoMember.LIANTONG_PRODUCT_ID);
                                    //支付成功，发送会员开通请求
                                    VideoMember.openMember(vipUrl, orderInfo.getOrderId(),
                                            orderInfo.getUserInfo(), VideoMember.MANGGUO_PRODUCT_ID);
                                }else{
                                    Log.i(getClass(), "订单不存在：" + orderId);
                                }
                            }
                        } else {
                            Log.i(getClass(), "订单异常："+map.get("err_msg"));
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.i(getClass(), "异常捕获:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
