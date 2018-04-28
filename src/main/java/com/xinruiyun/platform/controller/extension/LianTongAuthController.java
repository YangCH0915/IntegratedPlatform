package com.xinruiyun.platform.controller.extension;

import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.service.auth.LianTongAuthService;
import com.xinruiyun.platform.utils.Constants;
import com.xinruiyun.platform.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/ltAuth")
public class LianTongAuthController {

    @Autowired
    public LianTongAuthService lianTongAuthService;

    @CrossOrigin(origins = Constants.CORS_URL)
    @RequestMapping(value = "activity")
    public void login(HttpServletRequest request, HttpServletResponse response) {
        try {
            String phone = request.getParameter("phone");
            String s = lianTongAuthService.loginAuth(phone);
            JSONObject json = JSONObject.parseObject(s);
            Log.i(getClass(),"请求返回："+json.toJSONString());
            int resultCode = Integer.valueOf(json.getString("resultCode"));
            if (resultCode == 0) {
                response.getWriter().write(json.toJSONString());
            } else {
                JSONObject j = new JSONObject();
                j.put("resultCode", -1);
                response.getWriter().write(json.toJSONString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
