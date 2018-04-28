DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `ua_name` varchar(32) NOT NULL,
  `user_jurisdiction` INT,
  `html` varchar(32),
  `founder` varchar(32),
  `create_time` datetime,
  `renewing` varchar(32),
  `update_time` datetime,
  `remarks` varchar(32),
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `product_id` varchar(32) NOT NULL COMMENT '产品ID',
  `product_name` varchar(32) NOT NULL COMMENT '产品名称',
  `product_logo` varchar(200) DEFAULT NULL COMMENT '产品LOGO地址',
  `product_bg` varchar(200) DEFAULT NULL COMMENT '产品背景',
  `product_explain` varchar(800) DEFAULT NULL COMMENT '产品说明，多条说明用竖线隔开',
  `founder` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` DATETIME COMMENT '创建时间',
  `renewing` varchar(32) COMMENT '更新人',
  `update_time` DATETIME COMMENT '更新时间',
  `is_enable` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sub_product`;
CREATE TABLE `sub_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(32) NOT NULL COMMENT '产品标题',
  `product_name` varchar(32) NOT NULL COMMENT '父产品名称',
  `product_id` varchar(32) NOT NULL COMMENT '产品ID',
  `sub_product_id` varchar(32) NOT NULL COMMENT '子产品ID',
  `price` float DEFAULT NULL COMMENT '出售价格',
  `original_price` float DEFAULT NULL COMMENT '原价',
  `billing_code` varchar(32) DEFAULT NULL COMMENT '推荐等级，数字0.1.2.3.。。等级显示，值越小排序靠前',
  `is_show` int(11) DEFAULT NULL COMMENT '是否启用',
  `ranking` int(11) DEFAULT NULL COMMENT '排序等级',
  `product_explain` varchar(50) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `pay_passageway`;
CREATE TABLE `pay_passageway` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `passageway_name` varchar(32) NOT NULL COMMENT '通道名称',
  `passageway_id` varchar(32) NOT NULL COMMENT '通道ID,唯一标识',
  `encryption_type` varchar(12) DEFAULT NULL COMMENT '加密类型',
  `pay_type` varchar(32) NOT NULL COMMENT '支付类型',
  `mch_id` varchar(32) DEFAULT NULL COMMENT '商户号',
  `mch_key` varchar(32) DEFAULT NULL COMMENT '商户秘钥',
  `app_id` varchar(32) DEFAULT NULL COMMENT 'appId,公众号支付需要',
  `app_secret` varchar(32) DEFAULT NULL COMMENT 'appSecret,公众号支付需要',
  `is_use` int(11) DEFAULT NULL COMMENT '是否正常使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `channel_id` varchar(32) NOT NULL COMMENT '渠道ID',
  `channel_name` varchar(32) NOT NULL COMMENT '渠道名称',
  `pay_passageway_name` varchar(32) DEFAULT NULL COMMENT '支付通道名称',
  `mch_id` varchar(32) NOT NULL COMMENT '商户号',
  `pay_type` varchar(32) DEFAULT NULL COMMENT '支付类型',
  `request_time` DATETIME DEFAULT NULL COMMENT '请求时间',
  `finish_time` DATETIME DEFAULT NULL COMMENT '完成时间',
  `user_info` varchar(32) DEFAULT NULL COMMENT '用户信息',
  `product` varchar(32) DEFAULT NULL COMMENT '商品信息',
  `money` DOUBLE DEFAULT NULL COMMENT '金额',
  `order_id` varchar(50) DEFAULT NULL COMMENT '商户订单号',
  `platform_id` varchar(50) DEFAULT NULL COMMENT '平台订单号',
  `create_ip` varchar(32) DEFAULT NULL COMMENT '用户IP',
  `state` int(11) DEFAULT NULL COMMENT '是否正常使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

alter table order_info add product_name varchar(32) DEFAULT NULL ;
alter table order_info add sub_product_name varchar(32) DEFAULT NULL ;


DROP TABLE IF EXISTS `phone_ascription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone_ascription` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sectionNo` varchar(16) DEFAULT NULL,
  `province` varchar(16) DEFAULT NULL,
  `city` varchar(16) DEFAULT NULL,
  `operator` varchar(16) DEFAULT NULL,
  `areaCode` varchar(16) DEFAULT NULL,
  `zipCode` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=360570 DEFAULT CHARSET=utf8;
