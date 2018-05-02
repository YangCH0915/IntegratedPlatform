package com.xinruiyun.platform.controller.auth;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xinruiyun.platform.dto.AuthResult;
import com.xinruiyun.platform.dto.PagingQuery;
import com.xinruiyun.platform.entity.UserInfo;
import com.xinruiyun.platform.enums.StateEnum;
import com.xinruiyun.platform.service.user.UserService;
import com.xinruiyun.platform.utils.Constants;
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
@RequestMapping("/user")
@CrossOrigin(origins = Constants.CORS_URL)
public class UserInfoController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public void getUserById(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        try{
            UserInfo userInfo = userService.queryUserById(Tools.checkValue(id));
            AuthResult<UserInfo> authResult = null;
            if(userInfo != null){
                authResult = new AuthResult<>(StateEnum.SUCCESS,userInfo);
            }else{
                authResult = new AuthResult<>(StateEnum.QUERY_USER_EMPTY,null);
            }
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    public void deleteById(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        try{
            int i = userService.deleteUserById(Tools.checkValue(id));
            AuthResult<UserInfo> authResult = null;
            if(i == 1){
                authResult = new AuthResult<>(StateEnum.SUCCESS,null);
            }else{
                authResult = new AuthResult<>(StateEnum.QUERY_USER_EMPTY,null);
            }
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void update(UserInfo userInfo,HttpServletResponse response){
        try {
            int i = userService.updateUserInfo(userInfo);
            AuthResult<Integer> authResult = null;
            if(i == 1){
                authResult = new AuthResult<>(StateEnum.SUCCESS,null);
            }else{
                authResult = new AuthResult<>(StateEnum.QUERY_USER_EMPTY,null);
            }
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/count",method = RequestMethod.GET)
    public void getUserCount(HttpServletRequest request,HttpServletResponse response){
        String userName = request.getParameter("operator");
        AuthResult<Long> authResult = null;
        long userCount = userService.queryAllCount(userName);
        try {
            if(userCount>0){
                authResult = new AuthResult<>(StateEnum.SUCCESS,userCount);
            }else{
                authResult = new AuthResult<>(StateEnum.QUERY_USER_EMPTY,null);
            }
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public void getList(HttpServletRequest request, HttpServletResponse response){

        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        String operator = request.getParameter("operator");
        String allRecords = request.getParameter("allRecords");

        PagingQuery pq = new PagingQuery();
        pq.setPageIndex(Tools.checkValue(pageNo));
        pq.setPageSize(Tools.checkValue(pageSize));
        pq.setOperator(operator);
        pq.setTotalRecords(Long.valueOf(allRecords));
        List<UserInfo> userInfos = userService.queryUserByPage(pq);
        String json = JSONObject.toJSONString(userInfos, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty);
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
