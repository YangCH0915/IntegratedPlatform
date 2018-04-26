package com.xinruiyun.platform.encrypt;

import org.apache.commons.codec.digest.DigestUtils;

import java.net.URLEncoder;
import java.util.*;

/**
 * ClassName:SignUtils
 * Function: 签名用的工具箱
 * @author
 */
public class SignUtils {

    public static boolean checkParam(Map<String,String> params,String key){
        boolean result = false;
        if(params.containsKey("sign")){
            String sign = params.get("sign");
            params.remove("sign");
            StringBuilder buf = new StringBuilder((params.size() +1) * 10);
            SignUtils.buildPayParams(buf,params,false);
            String preStr = buf.toString();
            String signStr = preStr+key;
            String signRecieve = DigestUtils.md5Hex(signStr);
            result = sign.equalsIgnoreCase(signRecieve.toUpperCase());
        }
        return result;
    }
    /**
     * 过滤为空和sign参数
     * @author  
     * @param sArray
     * @return
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {
        Map<String, String> result = new HashMap<String, String>(sArray.size());
        if (sArray == null || sArray.size() <= 0) {
            return result;
        }
        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }

    public static String payParamsToString(Map<String, String> payParams){
        return payParamsToString(payParams,false);
    }

    public static String payParamsToString(Map<String, String> payParams,boolean encoding){
        return payParamsToString(new StringBuilder(),payParams,encoding);
    }

    public static String payParamsToString(StringBuilder sb,Map<String, String> payParams,boolean encoding){
        buildPayParams(sb,payParams,encoding);
        return sb.toString();
    }

    public static void buildPayParams(StringBuilder sb,Map<String, String> payParams,boolean encoding){
        List<String> keys = new ArrayList<String>(payParams.keySet());
        Collections.sort(keys);
        for(String key : keys){
            sb.append(key).append("=");
            if(encoding){
                sb.append(urlEncode(payParams.get(key)));
            }else{
                sb.append(payParams.get(key));
            }
            sb.append("&");
        }
        sb.setLength(sb.length() - 1);
    }
    
    public static String urlEncode(String str){
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable e) {
            return str;
        } 
    }

    public static String rasSignData(String content,String keyPath){
        String signData = null;
        try {
            signData = RSAUtil.signByPrivate(content,
                    RSAUtil.readFile(keyPath, "UTF-8"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return signData;
    }

    public static boolean rasValidateSignData(Map<String,String> resultMap,String keyPath) {
        String sign = resultMap.get("sign");
        Map<String,String> Reparams = SignUtils.paraFilter(resultMap);
        StringBuilder Rebuf = new StringBuilder((Reparams.size() +1) * 10);
        SignUtils.buildPayParams(Rebuf,Reparams,false);
        String RepreStr = Rebuf.toString();
        if(RSAUtil.verifyByKeyPath(RepreStr,sign, keyPath,"UTF-8")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        String cotent = "我就测试一下";
        String s = rasSignData(cotent, "E:/key/app_private_key_pkcs8.pem");
        System.out.println("加密："+s);

//        boolean b = rasValidateSignData(cotent, s, "E:/key/app_public_key.pem");
//        System.out.println("验证结果："+b);
    }
}

