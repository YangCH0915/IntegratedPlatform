package com.xinruiyun.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class StopShow {

    @RequestMapping(value = "/{channelId}")
    public String detail(@PathVariable("channelId") String channelId) {
        System.out.println("停机页面："+channelId);
        return "showstop";
    }
}


