package com.xinruiyun.platform.controller.business;

import com.xinruiyun.platform.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@CrossOrigin(origins = Constants.COUL_URL)
@RequestMapping("/extension")
public class ExtensionController {


    @RequestMapping(value = "mg77")
    public void mangGuo7and7(HttpServletRequest request, HttpServletResponse response){

        try {
            String phone = request.getParameter("phone");
            System.out.println("电话号码："+phone);
            response.getWriter().write("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
