package com.xinruiyun.platform.controller.pay;

import com.xinruiyun.platform.paypassageway.WinxinH5Pay;
import com.xinruiyun.platform.utils.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/wx")
public class WinxinH5Controller {

    @RequestMapping("/h5")
    public String toPay(HttpServletRequest request, Model model) {
        try {
            String money = request.getParameter("m");
            String pay = WinxinH5Pay.pay(money, request);
            if(pay.contains("https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb")){
                model.addAttribute("payUrl",pay);
                return "/pay/wx_h5";
            }
        } catch (Exception e) {
            Log.i(this.getClass(), "异常：" + e.toString());
        }
        return "";
    }
}
