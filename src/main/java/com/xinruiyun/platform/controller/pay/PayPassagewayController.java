package com.xinruiyun.platform.controller.pay;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xinruiyun.platform.dto.ResponseResult;
import com.xinruiyun.platform.dto.PagingQuery;
import com.xinruiyun.platform.entity.pay.PayPassageway;
import com.xinruiyun.platform.enums.StateEnum;
import com.xinruiyun.platform.service.pay.PayPassagewayService;
import com.xinruiyun.platform.utils.Constants;
import com.xinruiyun.platform.utils.Log;
import com.xinruiyun.platform.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/payPassageway")
@CrossOrigin(origins = Constants.CORS_URL)
public class PayPassagewayController {

    @Autowired
    public PayPassagewayService payPassagewayService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void addPassageway(PayPassageway payPassageway, HttpServletResponse response) {

        try {
            ResponseResult responseResult = null;
            if (payPassageway == null) {
                responseResult = new ResponseResult<>(StateEnum.REGISTER_ERROR, null);
            } else {
                int i = payPassagewayService.addPassageway(payPassageway);
                if (i == 1) {
                    responseResult = new ResponseResult<>(StateEnum.SUCCESS, i);
                } else {
                    responseResult = new ResponseResult<>(StateEnum.ADD_PASSAGEWAY_ERROR, null);
                }
            }
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        } catch (IOException e) {
            Log.i(getClass(), "register exception" + e.getMessage());
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void updatePassageway(PayPassageway payPassageway, HttpServletResponse response) {
        try {
            ResponseResult responseResult = null;
            if (payPassageway == null) {
                responseResult = new ResponseResult<>(StateEnum.REGISTER_ERROR, null);
            } else {
                int i = payPassagewayService.updatePassageway(payPassageway);
                if (i == 1) {
                    responseResult = new ResponseResult<>(StateEnum.SUCCESS, i);
                } else {
                    responseResult = new ResponseResult<>(StateEnum.UPDATE_PASSAGEWAY_ERROR, null);
                }
            }
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        } catch (IOException e) {
            Log.i(getClass(), "register exception" + e.getMessage());
        }
    }

    @RequestMapping(value = "deleteById", method = RequestMethod.GET)
    public void deletePassageway(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("id");
            ResponseResult responseResult = null;
            int i = payPassagewayService.deletePassageway(Tools.checkValue(id));
            if (i == 1) {
                responseResult = new ResponseResult<>(StateEnum.SUCCESS, i);
            } else {
                responseResult = new ResponseResult<>(StateEnum.DELETE_PASSAGEWAY_ERROR, null);
            }
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        } catch (IOException e) {
            Log.i(getClass(), "register exception" + e.getMessage());
        }
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public void queryPassagewayById(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("id");
            ResponseResult responseResult = null;
            PayPassageway payPassageway = payPassagewayService.queryPassagewayById(Tools.checkValue(id));
            if (payPassageway != null) {
                responseResult = new ResponseResult<>(StateEnum.SUCCESS, payPassageway);
            } else {
                responseResult = new ResponseResult<>(StateEnum.QUERY_PASSAGEWAY_ERROR, null);
            }
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        } catch (IOException e) {
            Log.i(getClass(), "register exception" + e.getMessage());
        }
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public void queryPassagewayListByPage(HttpServletRequest request, HttpServletResponse response) {
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        String operator = request.getParameter("operator");
        String allRecords = request.getParameter("allRecords");

        PagingQuery pq = new PagingQuery();
        pq.setPageIndex(Tools.checkValue(pageNo));
        pq.setPageSize(Tools.checkValue(pageSize));
        pq.setOperator(operator);
        pq.setTotalRecords(Long.valueOf(allRecords));
        List<PayPassageway> userInfos = payPassagewayService.queryPassagewayListByPage(pq);
        String json = JSONObject.toJSONString(userInfos, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty);
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "count", method = RequestMethod.GET)
    public void queryPassagewayCount(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult<Long> responseResult = null;
        long userCount = payPassagewayService.queryPassagewayCount();
        try {
            if(userCount>0){
                responseResult = new ResponseResult<>(StateEnum.SUCCESS,userCount);
            }else{
                responseResult = new ResponseResult<>(StateEnum.PASSAGEWAY_LIST_EMPTY,null);
            }
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
