package com.xinruiyun.platform.controller.product;

import com.xinruiyun.platform.entity.Product;
import com.xinruiyun.platform.service.product.ProductService;
import com.xinruiyun.platform.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addProduct(Product product,
                           @RequestParam(value="logo_pic",required=false)MultipartFile[] items_pic,
                           HttpServletRequest request){
        ModelAndView mode = new ModelAndView();
        mode.setViewName("main-activity");
        try{
            String randomName = UUID.randomUUID().toString().replaceAll("-","");
            Set<Product> gds = new HashSet<>();
            for(int i=0;i<items_pic.length;i++){
                if(items_pic[i].isEmpty()){
                    System.out.println("文件未上传");
                }else{
                    System.out.println("文件原名: " + items_pic[i].getOriginalFilename());
                    System.out.println("========================================");
                    //写入磁盘，和上面的单个文件上传一模一样
                    String fileName = items_pic[i].getOriginalFilename();
                    String filePath = request.getServletContext().getRealPath("/") + Constants.IMAGE_SAVE_PATH;
                    String dataSaveName = randomName+"/"+fileName;
                    String originalFileName = filePath+	dataSaveName;

                    File newFile = new File(originalFileName);
                    if(!newFile.exists()){
                        newFile.mkdirs();
                    }
                    items_pic[i].transferTo(newFile);
                    if(i == 0){
                        product.setProductLogo(dataSaveName);
                    }else if(i == 1){
                        product.setProductBg(dataSaveName);
                    }
                }
            }
            productService.addProduct(product);
            mode.addObject("saveResult", "success");
            return mode;
        }catch(Exception e){
            mode.addObject("saveResult", "fail"+e.toString());
            return mode;
        }
    }
}
