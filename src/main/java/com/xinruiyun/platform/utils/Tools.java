package com.xinruiyun.platform.utils;

import java.util.UUID;

public class Tools {

    public static boolean isEmpty(String string){
        if(string != null && "".equals(string)){
           return true;
        }else{
            return false;
        }
    }

    public static String getOrder(){
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodev = UUID.randomUUID().toString().hashCode();
        if(hashCodev < 0){
            //有可能是负数
            hashCodev = -hashCodev;
        }
        //"%015d"的意思：0代表不足位数的补0，这样可以确保相同的位数，15是位数也就是要得到到的字符串长度是15，d代表数字。
        return machineId + String.format("%015d", hashCodev);
    }

    public static long getTimestamp(){
        return System.currentTimeMillis();
    }
}
