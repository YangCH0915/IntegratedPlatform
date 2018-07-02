package com.xinruiyun.platform.controller.reptilian;

import com.xinruiyun.platform.http.OkHttpManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 获取网站图片的URL，实现下载图片
 */
@Controller
@RequestMapping("/spider")
public class ReptilianController {

    @RequestMapping("/index")
    public String index(){

        return "reptile/spider";
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
        return "reptile/spider";
    }

    public void paserHtml(String html,String savePaht) throws Exception {
        Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
        Matcher m = p.matcher(html);
        int i = 1;
        while(m.find()){
            String imgPath = m.group(1);
            if(imgPath.endsWith(".jpg")){
                OkHttpManager.getInstance().downFile("http:"+imgPath,savePaht,i+".jpg");
//               download("http:"+imgPath,i+".jpg",savePaht);
                i++;
                Thread.sleep(10);
            }
        }
    }

    public static void download(String urlString, String filename,String savePath) throws Exception {
        URL url = new URL(urlString);
        URLConnection con = url.openConnection();
        con.setConnectTimeout(5*1000);
        InputStream is = con.getInputStream();
        byte[] bs = new byte[1024];
        int len;
        File sf=new File(savePath);
        if(!sf.exists()){
            sf.mkdirs();
        }
        OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        os.close();
        is.close();
    }
}
