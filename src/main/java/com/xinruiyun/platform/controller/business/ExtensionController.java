package com.xinruiyun.platform.controller.business;

import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.dao.QCellCoreDao;
import com.xinruiyun.platform.entity.QCellCore;
import com.xinruiyun.platform.service.pay.PayRequestService;
import com.xinruiyun.platform.utils.Constants;
import com.xinruiyun.platform.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/extension")
public class ExtensionController {

    @Autowired
    public PayRequestService payRequestService;

    @Autowired
    public QCellCoreDao qCellCoreDao;

    @RequestMapping(value = "mg77")
    @CrossOrigin(origins = Constants.COUL_URL)
    public void mangGuo7and7(HttpServletRequest request, HttpServletResponse response){
        try {
            String phone = request.getParameter("phone");
            String payType = request.getParameter("payType");
            String subProductId = "";
            String channelId = "";
            JSONObject json = new JSONObject();
            if(phone != null){
               String sectionNo = phone.substring(0,7);
                QCellCore qCellCore = qCellCoreDao.getQCellCoreBysectionNo(sectionNo);
                if(qCellCore == null){
                    json.put("status",-1);//非浙江移动用户
                }else{
                    String url = payRequestService.pay(phone,Tools.getIpAddress(request),subProductId,channelId,payType);
                    json.put("url",url);
                    json.put("status",0);
                }
            }else{
                json.put("status",-2);//未上传电话号码
            }
            response.getWriter().write(json.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
