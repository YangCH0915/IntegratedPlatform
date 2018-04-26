package com.xinruiyun.platform.controller.pay;

import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.dao.pay.OrderInfoDao;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.http.OkHttpManager;
import com.xinruiyun.platform.paypassageway.SwifiGzhPay;
import com.xinruiyun.platform.utils.Constants;
import com.xinruiyun.platform.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/gzh")
public class SwifiGzhController {

    @Autowired
    public SwifiGzhPay swifiGzhPay;

    @Autowired
    public OrderInfoDao orderInfoDao;

    @RequestMapping("/toPay")
    public String toPay(HttpServletRequest request, Model model) {
        try {
            String info = request.getParameter("state");
            String code = request.getParameter("code");

            OrderInfo orderInfo = orderInfoDao.queryOrderInfoByOrderId(info);
            //获取统一下单需要的openid
            String openId = "";
            String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                    "appid=" + SwifiGzhPay.APP_ID +
                    "&secret=" + SwifiGzhPay.APP_SECRET +
                    "&code=" + code + "&grant_type=authorization_code";

            String jsonResult = OkHttpManager.getInstance().doGet(URL);
            JSONObject jsonObject = JSONObject.parseObject(jsonResult);
            Log.i(this.getClass(), "获取OPENID：" + jsonObject.toJSONString());
            if (null != jsonObject) {
                openId = jsonObject.getString("openid");
            }

            JSONObject result = swifiGzhPay.pay(orderInfo, openId);
            Log.i(this.getClass(), "下单返回结果：" + result.toJSONString() + "-订单号：" + info);
            JSONObject json = result.getJSONObject("pay_info");
            if (json.getInteger("status") == 0) {
                model.addAttribute("appid", json.getString("appId"));
                model.addAttribute("timeStamp", json.getString("timeStamp"));
                model.addAttribute("nonceStr", json.getString("nonceStr"));
                model.addAttribute("packageValue", json.getString("package"));
                model.addAttribute("sign", json.getString("paySign"));
                model.addAttribute("callbackUrl", json.getString("callback_url"));
            }
            return "/jsapi";
        } catch (Exception e) {
            Log.i(this.getClass(), "异常：" + e.toString());
        }
        return null;
    }
}
