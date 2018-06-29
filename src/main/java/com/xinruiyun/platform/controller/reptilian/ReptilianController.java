package com.xinruiyun.platform.controller.reptilian;

import com.xinruiyun.platform.http.OkHttpManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/spider")
public class ReptilianController {

    @RequestMapping("/index")
    public String index(){

        return "spider";
    }

    @RequestMapping("/grab")
    public String GrabPictures(HttpServletRequest request, HttpServletResponse response){

        String savePath = request.getParameter("savePath");
        String html = request.getParameter("html");
        try {
            paserHtml(html,savePath);
        } catch (Exception e) {
            request.setAttribute("msg","下载失败");
            System.out.println("异常："+e.toString());
            e.printStackTrace();
        }
        request.setAttribute("msg","下载成功");
        return "spider";
    }

    public void paserHtml(String html,String savePaht) throws Exception {
        Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
        Matcher m = p.matcher(html);
        int i = 1;
        while(m.find()){
            String imgPath = m.group(1);
            if(imgPath.endsWith(".jpg")){
                OkHttpManager.getInstance().downFile("http:"+imgPath,savePaht,i+".jpg");
                i++;
                Thread.sleep(10);
            }
        }
    }
}
