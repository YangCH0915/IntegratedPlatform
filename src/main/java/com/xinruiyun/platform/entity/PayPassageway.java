package com.xinruiyun.platform.entity;

/**
 * 支付通道，保存不同类型，不同渠道的支付账户
 */
public class PayPassageway {

    /**
     * 主键ID
     */
    private int id;
    /**
     * 通道名称
     */
    private String passageName;
    /**
     * 通道ID
     */
    private String passageId;
    /**
     * 加密类型
     */
    private String encryptionType;
    /**
     * 支付类型
     */
    private String payType;
    /**
     * 商户号
     */
    private String mchId;
    /**
     *  商户密钥
     */
    private String mchKey;
    /**
     * appId(公众号类型需要此参赛)
     */
    private String appId;
    /**
     * appSecret(公众号类型需要此参赛)
     */
    private String appSecret;
    /**
     * 使用状态
     */
    private int isUse;
}
