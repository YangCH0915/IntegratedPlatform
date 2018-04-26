package com.xinruiyun.platform.entity.statistics;

import java.util.Date;

/**
 * 访问统计
 */
public class VisitStatistics {

    /**
     * 主键ID
     */
    private long id;
    /**
     * 渠道
     */
    private String channel;
    /**
     * 统计节点
     */
    private String node;
    /**
     * 统计时间
     */
    private Date visitTime;
    /**
     * 统计访问数
     */
    private long visitNumber;
    /**
     * 活动页面
     */
    private String activityPage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public long getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(long visitNumber) {
        this.visitNumber = visitNumber;
    }

    public String getActivityPage() {
        return activityPage;
    }

    public void setActivityPage(String activityPage) {
        this.activityPage = activityPage;
    }

    @Override
    public String toString() {
        return "VisitStatistics{" +
                "id=" + id +
                ", channel='" + channel + '\'' +
                ", node='" + node + '\'' +
                ", visitTime=" + visitTime +
                ", visitNumber=" + visitNumber +
                ", activityPage='" + activityPage + '\'' +
                '}';
    }
}
