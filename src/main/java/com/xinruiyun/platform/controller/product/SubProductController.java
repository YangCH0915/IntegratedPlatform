package com.xinruiyun.platform.controller.product;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xinruiyun.platform.dto.AuthResult;
import com.xinruiyun.platform.entity.Product;
import com.xinruiyun.platform.entity.SubProduct;
import com.xinruiyun.platform.enums.StateEnum;
import com.xinruiyun.platform.service.product.SubProductService;
import com.xinruiyun.platform.utils.Constants;
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
@RequestMapping("/subProduct")
public class SubProductController {

    @Autowired
    private SubProductService subProductService;

    @CrossOrigin(origins = Constants.CORS_URL)
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addProduct(SubProduct subProduct, HttpServletResponse response){
        AuthResult<Product> authResult = null;
        try{
            subProductService.addSubProduct(subProduct);
            authResult = new AuthResult(StateEnum.SUCCESS,null);
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        }catch(Exception e){
            authResult = new AuthResult(StateEnum.ADD_PRODUCT_ERROR,null);
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            try {
                response.getWriter().write(json);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @CrossOrigin(origins = Constants.CORS_URL)
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void uploadPic( SubProduct subProduct,HttpServletResponse response){
        AuthResult<SubProduct> authResult = null;
        try{
            int i = subProductService.updateSubProduct(subProduct);
            authResult = new AuthResult(StateEnum.SUCCESS,subProduct);
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        }catch(Exception e){
            authResult = new AuthResult(StateEnum.ADD_PRODUCT_ERROR,null);
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            try {
                response.getWriter().write(json);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @CrossOrigin(origins = Constants.CORS_URL)
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public void getList(HttpServletResponse response){
        AuthResult<List<SubProduct>> authResult = null;
        try{
            List<SubProduct> subProducts = subProductService.querySubProductList();
            if(subProducts != null){
                authResult = new AuthResult<>(StateEnum.SUCCESS,subProducts);
                String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                        SerializerFeature.WriteNullStringAsEmpty);
                response.getWriter().write(json);
            }else{
                authResult = new AuthResult(StateEnum.PRODUCT_LIST_NULL,null);
                String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                        SerializerFeature.WriteNullStringAsEmpty);
                response.getWriter().write(json);
            }
        }catch(Exception e){
            authResult = new AuthResult(StateEnum.PRODUCT_LIST_ERROR,null);
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            try {
                response.getWriter().write(json);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @CrossOrigin(origins = Constants.CORS_URL)
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    public void getCount(HttpServletResponse response){
        AuthResult<Long> authResult = null;
        try{
            long count = subProductService.querySubProductCount();
                authResult = new AuthResult(StateEnum.SUCCESS,count);
                String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                        SerializerFeature.WriteNullStringAsEmpty);
                response.getWriter().write(json);
        }catch(Exception e){
            authResult = new AuthResult(StateEnum.PRODUCT_LIST_ERROR,null);
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            try {
                response.getWriter().write(json);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @CrossOrigin(origins = Constants.CORS_URL)
    @RequestMapping(value = "/getSubProductById",method = RequestMethod.GET)
    public void getSubProductById(HttpServletRequest request,HttpServletResponse response){
        AuthResult<SubProduct> authResult = null;
        String id = request.getParameter("id");

        try{
            SubProduct subProduct = subProductService.querySubProduct(Integer.valueOf(id));
            authResult = new AuthResult(StateEnum.SUCCESS,subProduct);
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        }catch(Exception e){
            authResult = new AuthResult(StateEnum.PRODUCT_LIST_ERROR,null);
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            try {
                response.getWriter().write(json);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @CrossOrigin(origins = Constants.CORS_URL)
    @RequestMapping(value = "/deleteSubProductById",method = RequestMethod.GET)
    public void deleteSubProductById(HttpServletRequest request,HttpServletResponse response){
        AuthResult<Integer> authResult = null;
        String id = request.getParameter("id");
        try{
            int count = subProductService.deleteSubProduct(Integer.valueOf(id));
            authResult = new AuthResult(StateEnum.SUCCESS,count);
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        }catch(Exception e){
            authResult = new AuthResult(StateEnum.PRODUCT_LIST_ERROR,null);
            String json = JSONObject.toJSONString(authResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            try {
                response.getWriter().write(json);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
