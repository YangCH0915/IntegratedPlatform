package com.xinruiyun.platform.paypassageway;

public class PayPassagewayFactory {

    public static final String HUAYI_YICHUANG = "huayi_yichuang";
    public static final String YINSHITONG_MOBAO = "yinshitong_mobao";
    public static final String SWIFI_YICHUANG = "swifi_yichuang";

    public static final String WEIXIN_H5 = "weixin_h5";
    public static final String WEIXIN_GZH = "weixin_gzh";
    public static final String ALIPAY_H5 = "alipay_h5";

    public static final String TEST_PHONE = "13429001234";

    public static BasePayPassageway passageway(String passagewayName,String payType){
        if(passagewayName.equals(HUAYI_YICHUANG)&&payType.equals(WEIXIN_GZH)){
            return new HuaYiGzhPay();
        }
        if(passagewayName.equals(YINSHITONG_MOBAO)&&payType.equals(WEIXIN_H5)){
            return new YinShiTongH5Pay();
        }
        if(passagewayName.equals(YINSHITONG_MOBAO)&&payType.equals(ALIPAY_H5)){
            return new YinShiTongAliH5Pay();
        }
        if(passagewayName.equals(SWIFI_YICHUANG)&&payType.equals(WEIXIN_H5)){
            return new SwifiH5Pay();
        }
        if(passagewayName.equals(SWIFI_YICHUANG)&&payType.equals(WEIXIN_GZH)){
            return new SwifiGzhPay();
        }
        if(passagewayName.equals(SWIFI_YICHUANG)&&payType.equals(ALIPAY_H5)){

        }
        return null;
    }
}
