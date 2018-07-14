package com.xinruiyun.platform.http;

import com.xinruiyun.platform.utils.Log;
import okhttp3.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
                .connectTimeout(30000, TimeUnit.MILLISECONDS)
                .readTimeout(30000, TimeUnit.MILLISECONDS)
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
     * Post map 异步请求
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
     * Post map 同步请求
     *
     * @param url
     * @param mapParams
     */
    public String doPost(String url, Map<String, String> mapParams) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : mapParams.keySet()) {
            builder.add(key, mapParams.get(key));
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        Call call = mClient.newCall(request);
        try {
            Response execute = call.execute();
            return execute.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
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
     * @param jsonParams
     */
    public String doPostJson(String url, String jsonParams) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8")
                , jsonParams);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = mClient.newCall(request);
        try {
            Response execute = call.execute();
            return execute.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
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

    /**
     * 下载文件
     * @param url
     * @param fileDir
     * @param fileName
     */
    public void downFile(String url, final String fileDir, final String fileName) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Call call = mClient.newCall(request);
        Response response = call.execute();

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("下载异常："+e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                try {
                    is = response.body().byteStream();
                    File file = new File(fileDir);
                    if(!file.exists()){
                        file.mkdirs();
                    }
                    file = new File(file.getAbsolutePath(), fileName);
                    fos = new FileOutputStream(file);
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    fos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (is != null) is.close();
                    if (fos != null) fos.close();
                }
            }
        });
    }

    public void syncDownFile(String url, final String fileDir, final String fileName) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Call call = mClient.newCall(request);
        Response response = call.execute();
        InputStream is = null;
        byte[] buf = new byte[2048];
        int len = 0;
        FileOutputStream fos = null;
        try {
//            len = response.body().charStream().read();
            File file = new File(fileDir);
            if(!file.exists()){
                file.mkdirs();
            }
            file = new File(file.getAbsolutePath(), fileName);
            fos = new FileOutputStream(file);
            while ((len = response.body().charStream().read()) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) is.close();
            if (fos != null) fos.close();
        }
    }
}
