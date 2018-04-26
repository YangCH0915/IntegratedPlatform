package com.xinruiyun.platform.service.pay;

public interface PayRequestService {
    /**
     * 支付
     * @param phone 手机号码
     * @param userIp 用户IP
     * @param channelId 渠道ID
     * @param payType   支付类型
     * @return
     */
    String pay(String phone,String userIp,String subProductId,String channelId,String payType);

    /**
     * 处理通知数据，如果成功，则下发会员或流量
     * @param tradeId  平台订单号
     * @param status   支付状态
     */
    void notifyData(String tradeId,int status);
}
