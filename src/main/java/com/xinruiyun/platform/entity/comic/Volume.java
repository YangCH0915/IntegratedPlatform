package com.xinruiyun.platform.entity.comic;

import java.util.Date;

/**
 * CREATE TABLE `volume` (
 *   `id` int(12) unsigned NOT NULL AUTO_INCREMENT COMMENT '话ID',
 *   `master_volume_id` int(12) unsigned DEFAULT '0' COMMENT '主服务器章节id',
 *   `comic_id` int(12) unsigned NOT NULL COMMENT '漫画ID',
 *   `title` varchar(128) DEFAULT NULL COMMENT '标题',
 *   `cover` varchar(256) DEFAULT NULL COMMENT '封面',
 *   `page_count` int(12) unsigned NOT NULL DEFAULT '0' COMMENT '页数',
 *   `origin_title` varchar(128) DEFAULT NULL COMMENT '原始标题',
 *   `origin_id` varchar(21) DEFAULT NULL COMMENT '原始ID',
 *   `origin_cover` varchar(256) DEFAULT NULL COMMENT '原始封面',
 *   `origin_url` varchar(256) DEFAULT NULL COMMENT '原始地址',
 *   `order_index` int(12) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
 *   `order_no` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序权值 越小越靠前',
 *   `free` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '1-免费,0-付费',
 *   `gold` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '金币售价',
 *   `open` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否开放',
 *   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
 *   `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
 *   PRIMARY KEY (`id`),
 *   KEY `origin_id` (`origin_id`,`origin_url`(255)),
 *   KEY `free` (`free`,`open`),
 *   KEY `order_index` (`order_index`),
 *   KEY `comic_id` (`comic_id`),
 *   KEY `orderno` (`order_no`),
 *   KEY `master_id` (`master_volume_id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=113285 DEFAULT CHARSET=utf8 COMMENT='分卷表';
 */
public class Volume {

    private int id;// 话ID',
    private int masterVolumeId;//主服务器章节id',
    private int comicId;//漫画ID',
    private String title;//标题',
    private String cover;//封面',
    private int pageCount;//页数',
    private String originTitle;//原始标题',
    private String originId;//原始ID',
    private String originCover;//原始封面',
    private String originUrl;//原始地址',
    private int orderIndex;//排序',
    private int orderNo;//排序权值 越小越靠前',
    private boolean free;//1-免费,0-付费',
    private int gold;//金币售价',
    private boolean open;//是否开放',
    private Date createTime;//添加时间',
    private Date updateTime;//更新时间',

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasterVolumeId() {
        return masterVolumeId;
    }

    public void setMasterVolumeId(int masterVolumeId) {
        this.masterVolumeId = masterVolumeId;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getOriginTitle() {
        return originTitle;
    }

    public void setOriginTitle(String originTitle) {
        this.originTitle = originTitle;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getOriginCover() {
        return originCover;
    }

    public void setOriginCover(String originCover) {
        this.originCover = originCover;
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

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Volume{" +
                "id=" + id +
                ", masterVolumeId=" + masterVolumeId +
                ", comicId=" + comicId +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", pageCount=" + pageCount +
                ", originTitle='" + originTitle + '\'' +
                ", originId='" + originId + '\'' +
                ", originCover='" + originCover + '\'' +
                ", originUrl='" + originUrl + '\'' +
                ", orderIndex=" + orderIndex +
                ", orderNo=" + orderNo +
                ", free=" + free +
                ", gold=" + gold +
                ", open=" + open +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
