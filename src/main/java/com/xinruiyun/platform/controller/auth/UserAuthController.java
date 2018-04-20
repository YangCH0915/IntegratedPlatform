package com.xinruiyun.platform.controller.auth;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xinruiyun.platform.dto.AuthResult;
import com.xinruiyun.platform.entity.UserInfo;
import com.xinruiyun.platform.enums.StateEnum;
import com.xinruiyun.platform.service.user.UserService;
import com.xinruiyun.platform.utils.Constants;
import com.xinruiyun.platform.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/auth")
@CrossOrigin(origins = Constants.COUL_URL)
public class UserAuthController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        Log.i(getClass(),"userName:"+userName);
        UserInfo userInfo = userService.queryUserByUsername(userName);
        AuthResult authResult = null;
        if(userInfo == null){
            authResult = new AuthResult<>(StateEnum.LOGIN_USER_ERROR,null);
        }else if(!password.equals(userInfo.getPassword())){
            authResult = new AuthResult<>(StateEnum.LOGIN_PASSWORD_ERROR,null);
        }else{
            authResult =  new AuthResult<>(StateEnum.SUCCESS,userInfo);
        }
        String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty);
        response.getWriter().write(json);
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public void register(UserInfo userInfo,HttpServletResponse response){
        try{
            AuthResult authResult = null;
            if(userInfo == null){
                authResult =  new AuthResult<>(StateEnum.REGISTER_ERROR,null);
            }else{
                userInfo.setCreateTime(new Date());
                int i = userService.addUserInfo(userInfo);
                if(i == 1){
                    authResult =  new AuthResult<>(StateEnum.SUCCESS,userInfo);
                }else{
                    authResult = new AuthResult<>(StateEnum.REGISTER_FAIL,null);
                }
            }
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        }catch (IOException e){
            Log.i(getClass(),"register exception"+e.getMessage());
        }
    }

}
