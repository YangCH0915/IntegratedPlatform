package com.xinruiyun.platform.controller.auth;

import com.xinruiyun.platform.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void update(){

    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public void getList(){

    }
}
