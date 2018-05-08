package com.xinruiyun.platform.controller.product;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xinruiyun.platform.dto.ResponseResult;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = Constants.CORS_URL)
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addProduct(Product product,HttpServletResponse response){
        ResponseResult<Product> responseResult = null;
        try{
            product.setCreateTime(new Date());
            productService.addProduct(product);
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
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public void uploadPic(@RequestParam(value="file", required=false)MultipartFile file,
                          HttpServletRequest request,HttpServletResponse response){
        ResponseResult<String> responseResult = null;
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
            responseResult = new ResponseResult(StateEnum.SUCCESS,dataSaveName);
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
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public void getList(HttpServletResponse response){
        ResponseResult<List<Product>> responseResult = null;
        try{
            List<Product> products = productService.queryProductList();
            System.out.println(products.toString());
            if(products != null){
                responseResult = new ResponseResult(StateEnum.SUCCESS,products);
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
        ResponseResult<Product> responseResult = null;
        try{
            long count = productService.getProductCount();
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
    @RequestMapping(value = "/getProductAndSubProduct",method = RequestMethod.GET)
    public void queryProductAndSubProduct(HttpServletRequest request,HttpServletResponse response){
        String productId = request.getParameter("productId");
        ResponseResult<Product> responseResult = null;
        try{
            Product product = productService.queryProductAndSubProduct(productId);
            responseResult = new ResponseResult(StateEnum.SUCCESS,product);
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
    @RequestMapping(value = "/getProductById",method = RequestMethod.GET)
    public void getProductById(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        ResponseResult<Product> responseResult = null;
        try{
            Product product = productService.queryProductById(Integer.valueOf(id));
            responseResult = new ResponseResult(StateEnum.SUCCESS,product);
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
    @RequestMapping(value = "/updateProduct",method = RequestMethod.POST)
    public void updateProduct(Product product,HttpServletResponse response){
        ResponseResult<Product> responseResult = null;
        try{
            product.setUpdateTime(new Date());
            productService.updateProduct(product);
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
    @RequestMapping(value = "/deleteProductById",method = RequestMethod.GET)
    public void deleteProductById(HttpServletRequest request,HttpServletResponse response){
        ResponseResult<String> responseResult = null;
        String id = request.getParameter("id");
        try{
            productService.deleteProduct(Integer.valueOf(id));
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
}
