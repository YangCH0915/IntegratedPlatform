package com.xinruiyun.platform.dto;

/**
 * 分页条件查询
 */
public class PagingQuery {

    /**
     * 查询类型，用于区分按什么级别查询，如果用户具有管理员权限，并且没有指定要查询那个渠道的数据，则查询所有渠道的数据,
     * 此时将type设置为1；若指定了查询那个渠道的数据，则设置为2
     * 如果用户是管理员以下的级别，只能查询自己的数据，此时type设置为2
     */
    private Integer type;
    /**
     *渠道名
     */
    private String uaName;
    /**
     * 开始时间
     */
    private String startDate;
    /**
     * 结束时间
     */
    private String endDate;
    /**
     * 支付状态
     */
    private Integer payState;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 子产品名称
     */
    private String subProductName;
    /**
     * 支付类型
     */
    private Integer payType;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 平台订单号
     */
    private String platformId;
    /**
     * 查询的页码
     */
    private Integer pageIndex;
    /**
     * 当前页显示的条数
     */
    private Integer pageSize;
    /**
     * 操作者，每次查询或更改都需要此参数
     */
    private String operator;
    /**
     * 总记录数
     */
    private long totalRecords;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUaName() {
        return uaName;
    }

    public void setUaName(String uaName) {
        this.uaName = uaName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSubProductName() {
        return subProductName;
    }

    public void setSubProductName(String subProductName) {
        this.subProductName = subProductName;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    @Override
    public String toString() {
        return "PagingQuery{" +
                "type=" + type +
                ", uaName='" + uaName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", payState=" + payState +
                ", productName='" + productName + '\'' +
                ", subProductName='" + subProductName + '\'' +
                ", payType=" + payType +
                ", orderId='" + orderId + '\'' +
                ", platformId='" + platformId + '\'' +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", operator='" + operator + '\'' +
                ", totalRecords=" + totalRecords +
                '}';
    }
}
