package com.xinruiyun.platform.entity.comic;

/**
 * CREATE TABLE `comic` (
 *   `id` int(12) unsigned NOT NULL AUTO_INCREMENT COMMENT '漫画ID',
 *   `master_comic_id` int(12) unsigned DEFAULT '0' COMMENT '主服务器漫画id',
 *   `title` varchar(128) NOT NULL COMMENT '漫画标题',
 *   `intro` text CHARACTER SET utf8mb4 COMMENT '描述',
 *   `cover` varchar(256) DEFAULT NULL COMMENT '漫画封面',
 *   `page_count` int(12) unsigned NOT NULL DEFAULT '0' COMMENT '漫画页数',
 *   `volume_count` int(12) unsigned NOT NULL DEFAULT '0' COMMENT '卷数',
 *   `origin_url` varchar(256) DEFAULT NULL COMMENT '原始资源URL',
 *   `origin_aisles` text COMMENT '其它分流url',
 *   `origin_domain` varchar(64) DEFAULT NULL COMMENT '原始资源域名',
 *   `origin_id` varchar(32) DEFAULT NULL COMMENT '原始资源ID',
 *   `origin_cover` varchar(256) DEFAULT NULL COMMENT '原始资源封面',
 *   `origin_title` varchar(128) DEFAULT NULL COMMENT '原始资源名称',
 *   `origin_intro` text COMMENT '来源网站简介',
 *   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
 *   `open` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否可用',
 *   `isend` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '漫画是否已完结',
 *   `in_search` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否显示在热搜中',
 *   `read_add_rate_min` int(11) unsigned NOT NULL DEFAULT '5' COMMENT '阅读放大倍数最小',
 *   `read_add_rate_max` int(11) unsigned NOT NULL DEFAULT '10' COMMENT '阅读数放大倍率最大',
 *   `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
 *   `last_volpub_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后vol发布时间',
 *   `level` tinyint(1) unsigned DEFAULT '0',
 *   PRIMARY KEY (`id`),
 *   KEY `origin_url` (`origin_url`(255),`origin_id`),
 *   KEY `open` (`open`),
 *   KEY `origin_domain` (`origin_domain`),
 *   KEY `end` (`isend`,`update_time`),
 *   KEY `lastpubtime` (`last_volpub_time`),
 *   KEY `create_time` (`create_time`,`open`),
 *   KEY `open_2` (`open`,`last_volpub_time`),
 *   KEY `create_time_2` (`create_time`,`open`,`isend`),
 *   KEY `open_3` (`open`,`isend`,`last_volpub_time`),
 *   KEY `insearch` (`in_search`),
 *   KEY `open_4` (`open`,`in_search`),
 *   KEY `master_id` (`master_comic_id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=6367 DEFAULT CHARSET=utf8 COMMENT='漫画表';
 * /*!40101 SET character_set_client = @saved_cs_client */

import java.util.Date;

public class Comic {

    private int id;
    private int masterComicId;//主服务器漫画id
    private String title;//漫画标题
    private String intero;//描述
    private String cover;//漫画封面
    private int pageCount;//漫画页数
    private int volumeCount;//卷数
    private String originUrl;//原始资源URL
    private String originAisles;//其它分流url',
    private String originDomain;//原始资源域名',
    private String originId;//原始资源ID',
    private String originCover;//原始资源封面',
    private String originTitle;//原始资源名称',
    private String originIntro;//来源网站简介',
    private Date createTime;//添加时间',
    private boolean open;//是否可用',
    private boolean isend;//漫画是否已完结',
    private boolean inSearch;//是否显示在热搜中',
    private int readAddRateMin;//阅读放大倍数最小',
    private int readAddRateMax;//阅读数放大倍率最大',
    private Date updateTime;//最后更新时间',
    private Date lastVolpubTime;//最后vol发布时间',
    private boolean level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasterComicId() {
        return masterComicId;
    }

    public void setMasterComicId(int masterComicId) {
        this.masterComicId = masterComicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntero() {
        return intero;
    }

    public void setIntero(String intero) {
        this.intero = intero;
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

    public int getVolumeCount() {
        return volumeCount;
    }

    public void setVolumeCount(int volumeCount) {
        this.volumeCount = volumeCount;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public String getOriginAisles() {
        return originAisles;
    }

    public void setOriginAisles(String originAisles) {
        this.originAisles = originAisles;
    }

    public String getOriginDomain() {
        return originDomain;
    }

    public void setOriginDomain(String originDomain) {
        this.originDomain = originDomain;
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

    public String getOriginTitle() {
        return originTitle;
    }

    public void setOriginTitle(String originTitle) {
        this.originTitle = originTitle;
    }

    public String getOriginIntro() {
        return originIntro;
    }

    public void setOriginIntro(String originIntro) {
        this.originIntro = originIntro;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isIsend() {
        return isend;
    }

    public void setIsend(boolean isend) {
        this.isend = isend;
    }

    public boolean isInSearch() {
        return inSearch;
    }

    public void setInSearch(boolean inSearch) {
        this.inSearch = inSearch;
    }

    public int getReadAddRateMin() {
        return readAddRateMin;
    }

    public void setReadAddRateMin(int readAddRateMin) {
        this.readAddRateMin = readAddRateMin;
    }

    public int getReadAddRateMax() {
        return readAddRateMax;
    }

    public void setReadAddRateMax(int readAddRateMax) {
        this.readAddRateMax = readAddRateMax;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastVolpubTime() {
        return lastVolpubTime;
    }

    public void setLastVolpubTime(Date lastVolpubTime) {
        this.lastVolpubTime = lastVolpubTime;
    }

    public boolean isLevel() {
        return level;
    }

    public void setLevel(boolean level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "id=" + id +
                ", masterComicId=" + masterComicId +
                ", title='" + title + '\'' +
                ", intero='" + intero + '\'' +
                ", cover='" + cover + '\'' +
                ", pageCount=" + pageCount +
                ", volumeCount=" + volumeCount +
                ", originUrl='" + originUrl + '\'' +
                ", originAisles='" + originAisles + '\'' +
                ", originDomain='" + originDomain + '\'' +
                ", originId='" + originId + '\'' +
                ", originCover='" + originCover + '\'' +
                ", originTitle='" + originTitle + '\'' +
                ", originIntro='" + originIntro + '\'' +
                ", createTime=" + createTime +
                ", open=" + open +
                ", isend=" + isend +
                ", inSearch=" + inSearch +
                ", readAddRateMin=" + readAddRateMin +
                ", readAddRateMax=" + readAddRateMax +
                ", updateTime=" + updateTime +
                ", lastVolpubTime=" + lastVolpubTime +
                ", level=" + level +
                '}';
    }
}
