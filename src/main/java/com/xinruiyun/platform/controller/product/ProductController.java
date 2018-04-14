package com.xinruiyun.platform.controller.product;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xinruiyun.platform.dto.AuthResult;
import com.xinruiyun.platform.entity.Product;
import com.xinruiyun.platform.enums.StateEnum;
import com.xinruiyun.platform.service.product.ProductService;
import com.xinruiyun.platform.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = Constants.COUL_URL)
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addProduct(Product product,HttpServletResponse response){
        AuthResult<Product> authResult = null;
        try{
            productService.addProduct(product);
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

    @CrossOrigin(origins = Constants.COUL_URL)
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public void uploadPic(@RequestParam(value="file", required=false)MultipartFile file,
                          HttpServletRequest request,HttpServletResponse response){
        AuthResult<String> authResult = null;
        try{
            String randomName = UUID.randomUUID().toString().replaceAll("-","");
            //写入磁盘，和上面的单个文件上传一模一样
            String fileName = file.getOriginalFilename();
            String filePath = request.getServletContext().getRealPath("/") + Constants.IMAGE_SAVE_PATH;
            String dataSaveName = randomName+"/"+fileName;
            String originalFileName = filePath+	dataSaveName;

            File newFile = new File(originalFileName);
            if(!newFile.exists()){
                newFile.mkdirs();
            }
            file.transferTo(newFile);
            authResult = new AuthResult(StateEnum.SUCCESS,dataSaveName);
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

    @CrossOrigin(origins = Constants.COUL_URL)
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public void getList(HttpServletResponse response){
        AuthResult<Product> authResult = null;
        try{
            List<Product> products = productService.queryProductList();
            if(products != null){
                authResult = new AuthResult(StateEnum.SUCCESS,products);
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

    @CrossOrigin(origins = Constants.COUL_URL)
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    public void getCount(HttpServletResponse response){
        AuthResult<Product> authResult = null;
        try{
            long count = productService.getProductCount();
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
