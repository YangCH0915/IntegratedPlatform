package com.xinruiyun.platform.controller.product;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xinruiyun.platform.dto.ResponseResult;
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
        ResponseResult<Product> responseResult = null;
        try{
            subProductService.addSubProduct(subProduct);
            responseResult = new ResponseResult(StateEnum.SUCCESS,null);
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        }catch(Exception e){
            responseResult = new ResponseResult(StateEnum.ADD_PRODUCT_ERROR,null);
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
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
        ResponseResult<SubProduct> responseResult = null;
        try{
            int i = subProductService.updateSubProduct(subProduct);
            responseResult = new ResponseResult(StateEnum.SUCCESS,subProduct);
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        }catch(Exception e){
            responseResult = new ResponseResult(StateEnum.ADD_PRODUCT_ERROR,null);
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
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
        ResponseResult<List<SubProduct>> responseResult = null;
        try{
            List<SubProduct> subProducts = subProductService.querySubProductList();
            if(subProducts != null){
                responseResult = new ResponseResult<>(StateEnum.SUCCESS,subProducts);
                String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                        SerializerFeature.WriteNullStringAsEmpty);
                response.getWriter().write(json);
            }else{
                responseResult = new ResponseResult(StateEnum.PRODUCT_LIST_NULL,null);
                String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                        SerializerFeature.WriteNullStringAsEmpty);
                response.getWriter().write(json);
            }
        }catch(Exception e){
            responseResult = new ResponseResult(StateEnum.PRODUCT_LIST_ERROR,null);
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
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
        ResponseResult<Long> responseResult = null;
        try{
            long count = subProductService.querySubProductCount();
                responseResult = new ResponseResult(StateEnum.SUCCESS,count);
                String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                        SerializerFeature.WriteNullStringAsEmpty);
                response.getWriter().write(json);
        }catch(Exception e){
            responseResult = new ResponseResult(StateEnum.PRODUCT_LIST_ERROR,null);
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
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
        ResponseResult<SubProduct> responseResult = null;
        String id = request.getParameter("id");
        try{
            SubProduct subProduct = subProductService.querySubProduct(Integer.valueOf(id));
            responseResult = new ResponseResult(StateEnum.SUCCESS,subProduct);
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        }catch(Exception e){
            responseResult = new ResponseResult(StateEnum.PRODUCT_LIST_ERROR,null);
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
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
        ResponseResult<Integer> responseResult = null;
        String id = request.getParameter("id");
        try{
            int count = subProductService.deleteSubProduct(Integer.valueOf(id));
            responseResult = new ResponseResult(StateEnum.SUCCESS,count);
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            response.getWriter().write(json);
        }catch(Exception e){
            responseResult = new ResponseResult(StateEnum.PRODUCT_LIST_ERROR,null);
            String json = JSONObject.toJSONString(responseResult, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
            try {
                response.getWriter().write(json);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
