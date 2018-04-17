package com.xinruiyun.platform.utils;

public class Tools {

    public static boolean isEmpty(String string){
        if(string != null && "".equals(string)){
           return true;
        }else{
            return false;
        }
    }
}
