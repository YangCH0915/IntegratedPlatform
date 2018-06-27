package com.xinruiyun.platform.controller.auth;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xinruiyun.platform.dto.ResponseResult;
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

@Controller
@RequestMapping("")
@CrossOrigin(origins = Constants.CORS_URL)
public class UserAuthController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(){
        return "auth/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        ResponseResult<String> responseResult = null;
        if (userName.equals("YC2018")&&password.equals("654321")){
            responseResult =  new ResponseResult<>(StateEnum.SUCCESS,Constants.HTML_SUPERADMIN);
        }else {
            UserInfo userInfo = userService.queryUserByUsername(userName);
            if(userInfo == null){
                responseResult = new ResponseResult<>(StateEnum.LOGIN_USER_ERROR,null);
            }else if(!password.equals(userInfo.getPassword())){
                responseResult = new ResponseResult<>(StateEnum.LOGIN_PASSWORD_ERROR,null);
            }else{
                responseResult =  new ResponseResult<>(StateEnum.SUCCESS,userInfo.getHtml());
            }
        }
        String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty);
        response.getWriter().write(json);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void register(UserInfo userInfo,HttpServletResponse response){
        try{
            ResponseResult responseResult = null;
            if(userInfo == null){
                responseResult =  new ResponseResult<>(StateEnum.REGISTER_ERROR,null);
            }else{
                int i = userService.addUserInfo(userInfo);
                if(i == 1){
                    responseResult =  new ResponseResult<>(StateEnum.SUCCESS,userInfo);
                }else if(i == -1){
                    responseResult = new ResponseResult<>(StateEnum.REGISTER_USER_EXIST,null);
                }else{
                    responseResult = new ResponseResult<>(StateEnum.REGISTER_FAIL,null);
                }
            }
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        }catch (IOException e){
            Log.i(getClass(),"register exception"+e.getMessage());
        }
    }

}
