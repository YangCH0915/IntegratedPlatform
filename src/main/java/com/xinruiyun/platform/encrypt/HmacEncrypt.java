package com.xinruiyun.platform.encrypt;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HmacEncrypt {

    /**
     * 26      * @param encryptText 被签名的字符串
     * 27      * @param key  密钥
     * 28      * @return
     */
    public static String HmacSHA512(String encryptText, String key){
        Mac sha512_HMAC = null;
        String result = null;
        try{
            byte [] byteKey = key.getBytes("UTF-8");
            final String HMAC_SHA512 = "HmacSHA512";
            sha512_HMAC = Mac.getInstance(HMAC_SHA512);
            SecretKeySpec keySpec = new SecretKeySpec(byteKey, HMAC_SHA512);
            sha512_HMAC.init(keySpec);
            byte [] mac_data = sha512_HMAC.doFinal(encryptText.getBytes("UTF-8"));
            //result = Base64.encode(mac_data);
            result = bytesToHex(mac_data);
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }finally{
            System.out.println("Done");
        }
        return result;
    }

    public static String bytesToHex(byte[] bytes) {
        final  char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
