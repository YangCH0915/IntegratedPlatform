package com.xinruiyun.platform.http;

import com.xinruiyun.platform.utils.Log;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by YCH on 16/10/13.
 */
public class OkHttpManager {

    private static OkHttpManager mInstance;
    private static OkHttpClient mClient;

    private OkHttpManager() {
        OkHttpRetryInterceptor interceptor = new OkHttpRetryInterceptor.Builder().build();

        mClient = new OkHttpClient().newBuilder()
                .retryOnConnectionFailure(true)
                .addInterceptor(interceptor)
                .connectionPool(new ConnectionPool())
                .connectTimeout(3000, TimeUnit.MILLISECONDS)
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .build();
    }

    public static OkHttpManager getInstance() {
        if (mInstance == null) {
            synchronized (OkHttpManager.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * Get异步请求
     *
     * @param url
     * @param callback
     */
    public void doGet(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = mClient.newCall(request);
        call.enqueue(callback);
    }

    /**
     * Get同步请求
     *
     * @param url
     */
    public String doGet(String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = mClient.newCall(request);
        try {
            Response response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            Log.i(getClass(), "请求异常：" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Post请求发送键值对数据
     *
     * @param url
     * @param mapParams
     * @param callback
     */
    public void doPost(String url, Map<String, String> mapParams, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : mapParams.keySet()) {
            builder.add(key, mapParams.get(key));
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        Call call = mClient.newCall(request);
        call.enqueue(callback);
    }


    /**
     * Post请求发送JSON数据
     *
     * @param url
     * @param jsonParams
     * @param callback
     */
    public void doPost(String url, String jsonParams, Callback callback) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8")
                , jsonParams);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = mClient.newCall(request);
        call.enqueue(callback);
    }

    /**
     * Post请求发送JSON数据
     *
     * @param url
     * @param xmlParams
     */
    public String doPost(String url, String xmlParams) {
        try {
            RequestBody body = RequestBody.create(MediaType.parse("application/xml; charset=utf-8")
                    , xmlParams);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Call call = mClient.newCall(request);
            Response response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            Log.i(getClass(),"xml请求异常："+e.getMessage());
            e.printStackTrace();
        }
        return "";
    }
}
