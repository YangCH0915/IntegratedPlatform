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