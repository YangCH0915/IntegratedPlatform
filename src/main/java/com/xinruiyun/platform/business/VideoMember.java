package com.xinruiyun.platform.business;

import com.alibaba.fastjson.JSONObject;
import com.xinruiyun.platform.http.OkHttpManager;
import com.xinruiyun.platform.utils.Log;
import com.xinruiyun.platform.utils.MD5;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;

public class VideoMember {

    public static final String YOUKU_UTL = "http://123.207.184.203:50/YK/RcvMo.sy";
    public static final String MANGGUO_URL = "http://123.207.184.203:50/MG/RcvMo.sy";
    public static final String LIULIANG_URL = "http://123.207.184.203:50/ZJYDZY/RcvMo.sy";

    private static final String YOUKU_TEST = "http://123.207.184.203:50/test/RcvMo.sy";
    private static final String MANGGUO_TEST = "http://123.207.184.203:50/mgtest/RcvMo.sy";

    private static final String KEY = "YCXC7dki39kd93ksl39ls93a";

    public static void openMember(String url,String orderId,String phone,String productId){
        JSONObject json = new JSONObject();
        json.put("transferId",orderId);
        json.put("phoneNumber",phone);
        json.put("productId",productId);
        json.put("sign", createSing(json));
        Log.i(VideoMember.class,"开通会员参数："+json.toJSONString());
        OkHttpManager.getInstance().doPost(url, json.toJSONString(), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(VideoMember.class,"开通出现异常："+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(VideoMember.class,"返回信息："+response.body().string());
            }
        });
    }

    private static String createSing(JSONObject json){
        String sing = "";
        StringBuffer sb = new StringBuffer();
        sb.append("transferId"+json.getString("transferId"));
        sb.append("phoneNumber"+json.getString("phoneNumber"));
        sb.append("productId"+json.getString("productId"));
        sb.append("ykfm_sign_key"+KEY);
        try {
            sing = MD5.getMD5Str(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sing;
    }
}
