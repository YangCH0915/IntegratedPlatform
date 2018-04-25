package com.xinruiyun.platform.controller.business;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.business.VideoMember;
import com.xinruiyun.platform.dao.QCellCoreDao;
import com.xinruiyun.platform.dao.pay.OrderInfoDao;
import com.xinruiyun.platform.entity.QCellCore;
import com.xinruiyun.platform.entity.pay.OrderInfo;
import com.xinruiyun.platform.paypassageway.HyYcGzhPay;
import com.xinruiyun.platform.paypassageway.YinShiTongH5Pay;
import com.xinruiyun.platform.utils.Constants;
import com.xinruiyun.platform.utils.Log;
import com.xinruiyun.platform.encrypt.SignUtils;
import com.xinruiyun.platform.utils.Tools;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

@Controller
@RequestMapping("/extension")
public class ExtensionController {

    @Autowired
    public OrderInfoDao orderInfoDao;

    @Autowired
    public YinShiTongH5Pay yinShiTongH5Pay;

    @Autowired
    public QCellCoreDao qCellCoreDao;

    @Autowired
    public HyYcGzhPay hyYcGzhPay;

    @RequestMapping(value = "mg77")
    @CrossOrigin(origins = Constants.COUL_URL)
    public void mangGuo7and7(HttpServletRequest request, HttpServletResponse response){
        try {
            String phone = request.getParameter("phone");
            JSONObject json = new JSONObject();
            if(phone != null){
               String sectionNo = phone.substring(0,7);
                QCellCore qCellCore = qCellCoreDao.getQCellCoreBysectionNo(sectionNo);
                if(qCellCore != null){
                    json.put("status",-1);//非浙江移动用户
                }else{
                    OrderInfo orderInfo = new OrderInfo();
                    orderInfo.setChannelId("00001");
                    orderInfo.setChannelName("未知");
                    orderInfo.setCreateIp(Tools.getIpAddress(request));
                    orderInfo.setMoney(9.9);
                    orderInfo.setProduct("mangguo002");
                    orderInfo.setRequestTime(new Date());
                    orderInfo.setUserInfo(phone);

                    boolean isWeiXin = Tools.isMicromessengerBrowser(request);
                    String url = "";
                    if(isWeiXin){//公众号支付
                        orderInfo.setMchId(HyYcGzhPay.MCH_ID);
                        orderInfo.setPayType("weixin_gzh");
                        orderInfo.setPayPassagewayName("华移-易创公众号");
                        orderInfo.setOrderId(Tools.getOrder());
                        orderInfoDao.addOrderInfo(orderInfo);
                        url = hyYcGzhPay.pay(orderInfo);
                    }else{//H5支付
                        orderInfo.setMchId("939290048990099");
                        orderInfo.setPayType("weixin_h5");
                        orderInfo.setPayPassagewayName("银视通");
                        orderInfo.setOrderId("YCXC"+Tools.getOrder());
                        orderInfoDao.addOrderInfo(orderInfo);
                        url = yinShiTongH5Pay.orderRequest(orderInfo);
                    }
                    json.put("url",url);
                    json.put("status",0);
                }
            }else{
                json.put("status",-2);//未上传电话号码
            }
            response.getWriter().write(json.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "notify")
    public void ystNotify(HttpServletRequest request, HttpServletResponse response){
        try {
            Reader reader = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
            String body = IOUtils.read(reader);
            Log.i(getClass(),"异步通知结果："+body);
            JSONObject json = JSONObject.parseObject(body);
            String respCode = json.getString("respCode");
            String orderId = json.getString("merchorder_no");
            OrderInfo orderInfo = orderInfoDao.queryOrderInfoByOrderId(orderId);
            JSONObject responseJson = new JSONObject();
            if(orderInfo != null){
                if(respCode.equals("00")){
                    if(checkSign(json)){
                         responseJson.put("respCode","00");
                         Log.i(getClass(),"签名验证通过："+orderId);
                         response.getWriter().write(responseJson.toJSONString());
                         String platformId = json.getString("order_id");
                         orderInfo.setPlatformId(platformId);
                         orderInfo.setState(0);
                         orderInfo.setFinishTime(new Date());
                         orderInfoDao.updateOrderInfoState(orderInfo);

                        String liuliangUrl = "",vipUrl = "";
                        if(orderInfo.getUserInfo().equals("18566209357")){
                            liuliangUrl = VideoMember.TEST;
                            vipUrl = VideoMember.TEST;
                        }else{
                            liuliangUrl = VideoMember.LIULIANG_URL;
                            vipUrl = VideoMember.MANGGUO_URL;
                        }
                        //支付成功，发送流量充值请求
                        VideoMember.openMember(liuliangUrl,orderInfo.getOrderId(),
                                orderInfo.getUserInfo(),VideoMember.LIANTONG_PRODUCT_ID);
                        //支付成功，发送会员开通请求
                        VideoMember.openMember(vipUrl,orderInfo.getOrderId(),
                                orderInfo.getUserInfo(),VideoMember.MANGGUO_PRODUCT_ID);
                    }else{
                        responseJson.put("respCode","00");
                        response.getWriter().write(responseJson.toJSONString());
                        Log.i(getClass(),"签名验证失败："+orderId);
                    }
                }
            }else{
                responseJson.put("respCode","00");
                response.getWriter().write(responseJson.toJSONString());
                Log.i(getClass(),"订单号不存在:"+orderInfo.getOrderId());
            }
        } catch (IOException e) {
            Log.i(getClass(),"异常捕获:"+e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean checkSign(JSONObject json){
       String sign = json.getString("sign");
       json.remove("signature");
       json.remove("accNo");
       json.remove("reserved");
       json.remove("payCardType");
        Map<String,String> parse = (Map)JSON.parse(json.toJSONString());
        boolean b = SignUtils.checkParam(parse, YinShiTongH5Pay.NOTIFY_KEY);
        return b;
    }

    @RequestMapping(value = "/notify_gzh")
    public void notifyGzh(HttpServletRequest request,HttpServletResponse response) throws IOException {

        Map<String, String> map = new HashMap<>();
        String orderNo  = request.getParameter("orderNo");
        String sign  = request.getParameter("sign");
        map.put("orderNo", orderNo);
        map.put("total", request.getParameter("total"));
        map.put("merchantNo", request.getParameter("merchantNo"));
        map.put("code", request.getParameter("code"));
        map.put("timestamp", request.getParameter("timestamp"));
        Log.i(this.getClass(), "公众号异步数据:"+map.toString());

        OrderInfo orderInfo = orderInfoDao.queryOrderInfoByOrderId(orderNo);
        if(orderInfo != null){
            if(creatAliSign(map, HyYcGzhPay.MCH_KEY).equals(sign)){
                response.getWriter().write("success");
                Log.i(this.getClass(), "验证签名通过,正常统计:"+orderNo);
                orderInfo.setPlatformId("");
                orderInfo.setState(0);
                orderInfo.setFinishTime(new Date());
                orderInfoDao.updateOrderInfoState(orderInfo);

                String liuliangUrl = "",vipUrl = "";
                if(orderInfo.getUserInfo().equals("18566209357")){
                    liuliangUrl = VideoMember.TEST;
                    vipUrl = VideoMember.TEST;
                }else{
                    liuliangUrl = VideoMember.LIULIANG_URL;
                    vipUrl = VideoMember.MANGGUO_URL;
                }
                //支付成功，发送流量充值请求
                VideoMember.openMember(liuliangUrl,orderInfo.getOrderId(),
                        orderInfo.getUserInfo(),VideoMember.LIANTONG_PRODUCT_ID);
                //支付成功，发送会员开通请求
                VideoMember.openMember(vipUrl,orderInfo.getOrderId(),
                        orderInfo.getUserInfo(),VideoMember.MANGGUO_PRODUCT_ID);
            }else{
                Log.i(this.getClass(), "验证签名失败:"+orderNo);
                response.getWriter().write("fail");
            }
        }else{
            Log.i(this.getClass(), "订单号不存在:"+orderNo);
            response.getWriter().write("success");
        }
    }

    public static String creatAliSign(Map<String,String> map,String sigkey){
        StringBuffer sb = new StringBuffer();
        List<String> keys = new ArrayList<String>(map.keySet());
        Collections.sort(keys);
        for(String key : keys){
            sb.append(key).append("=");
            sb.append(map.get(key));
        }
        sb.append(sigkey);
        return DigestUtils.md5Hex(sb.toString()).toLowerCase();
    }

}
