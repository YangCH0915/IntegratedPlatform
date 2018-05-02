package com.xinruiyun.platform.entity.pay;

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
    private String passagewayName;
    /**
     * 通道ID
     */
    private String passagewayId;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassagewayName() {
        return passagewayName;
    }

    public void setPassagewayName(String passagewayName) {
        this.passagewayName = passagewayName;
    }

    public String getPassagewayId() {
        return passagewayId;
    }

    public void setPassagewayId(String passagewayId) {
        this.passagewayId = passagewayId;
    }

    public String getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(String encryptionType) {
        this.encryptionType = encryptionType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    @Override
    public String toString() {
        return "PayPassageway{" +
                "id=" + id +
                ", passageName='" + passagewayName + '\'' +
                ", passageId='" + passagewayId + '\'' +
                ", encryptionType='" + encryptionType + '\'' +
                ", payType='" + payType + '\'' +
                ", mchId='" + mchId + '\'' +
                ", mchKey='" + mchKey + '\'' +
                ", appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", isUse=" + isUse +
                '}';
    }
}
