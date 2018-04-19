package com.xinruiyun.platform.utils;

import org.springframework.util.DigestUtils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
* 功能：MD5签名
* 版本：3.3
* 修改日期：2012-08-17
* */
public class MD5 {

    public static String getMD5Str(String str){
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            Log.i(MD5.class,"MD5加密出现错误，"+e.toString());
        }
        return "";
    }
}