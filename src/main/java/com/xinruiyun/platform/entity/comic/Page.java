package com.xinruiyun.platform.entity.comic;

import java.util.Date;

/**
 * CREATE TABLE `page` (
 * `id` int(12) unsigned NOT NULL AUTO_INCREMENT COMMENT '页面ID',
 * `master_page_id` int(12) unsigned zerofill DEFAULT '000000000000' COMMENT '主服务器页面id',
 * `comic_id` int(12) unsigned NOT NULL COMMENT '漫画ID',
 * `volume_id` int(12) unsigned NOT NULL COMMENT '话ID',
 * `page_url` varchar(256) NOT NULL COMMENT '页面地址',
 * `origin_url` varchar(256) DEFAULT NULL COMMENT '原始URL',
 * `order_index` int(12) unsigned NOT NULL DEFAULT '0' COMMENT '页面排序',
 * `aisles` text COMMENT '分流地址',
 * `open` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否可用',
 * `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
 * PRIMARY KEY (`id`),
 * KEY `comic_id` (`comic_id`,`volume_id`,`order_index`,`open`),
 * KEY `volume_id` (`volume_id`),
 * KEY `order_index` (`order_index`),
 * KEY `volume_id_2` (`volume_id`,`order_index`),
 * KEY `master_id` (`master_page_id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=1125412 DEFAULT CHARSET=utf8 COMMENT='页';
 */
public class Page {

    private int id;//页面ID',
    private int masterPageId;//主服务器页面id',
    private int comicId;//漫画ID',
    private int volumeId;//话ID',
    private String pageUrl;//页面地址',
    private String originUrl;//原始URL',
    private int orderIndex;//页面排序',
    private String aisles;//分流地址',
    private boolean open;//是否可用',
    private Date createTime;//添加时间',

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasterPageId() {
        return masterPageId;
    }

    public void setMasterPageId(int masterPageId) {
        this.masterPageId = masterPageId;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public int getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(int volumeId) {
        this.volumeId = volumeId;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getAisles() {
        return aisles;
    }

    public void setAisles(String aisles) {
        this.aisles = aisles;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", masterPageId=" + masterPageId +
                ", comicId=" + comicId +
                ", volumeId=" + volumeId +
                ", pageUrl='" + pageUrl + '\'' +
                ", originUrl='" + originUrl + '\'' +
                ", orderIndex=" + orderIndex +
                ", aisles='" + aisles + '\'' +
                ", open=" + open +
                ", createTime=" + createTime +
                '}';
    }
}
