package com.xinruiyun.platform.controller.business;

import com.xinruiyun.platform.service.pay.PayRequestService;
import com.xinruiyun.platform.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/extension")
public class ExtensionController {

    @Autowired
    public PayRequestService payRequestService;

    @RequestMapping(value = "mg77")
    @CrossOrigin(origins = Constants.CORS_URL)
    public void mangGuo7and7(HttpServletRequest request, HttpServletResponse response){

    }
}
