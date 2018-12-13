/*
Navicat MySQL Data Transfer

Source Server         : qujie
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-13 17:58:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article_image_info`
-- ----------------------------
DROP TABLE IF EXISTS `article_image_info`;
CREATE TABLE `article_image_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(20) DEFAULT NULL,
  `image_addr` varchar(255) DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of article_image_info
-- ----------------------------

-- ----------------------------
-- Table structure for `article_info`
-- ----------------------------
DROP TABLE IF EXISTS `article_info`;
CREATE TABLE `article_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `content` text,
  `type_id` bigint(20) DEFAULT NULL COMMENT '文章所属分类',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_user` bigint(20) DEFAULT NULL COMMENT '添加人',
  `add_ip` varchar(255) DEFAULT NULL COMMENT '添加人所处ip',
  `modify_time` datetime DEFAULT NULL,
  `modify_user` bigint(20) DEFAULT NULL,
  `modify_ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章信息表';

-- ----------------------------
-- Records of article_info
-- ----------------------------

-- ----------------------------
-- Table structure for `article_type`
-- ----------------------------
DROP TABLE IF EXISTS `article_type`;
CREATE TABLE `article_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `show` tinyint(1) DEFAULT NULL COMMENT '是否显示 0不显示，1显示',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `add_time` datetime DEFAULT NULL,
  `add_user` bigint(20) DEFAULT NULL,
  `add_ip` varchar(55) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modify_user` bigint(20) DEFAULT NULL,
  `modify_ip` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章类别';

-- ----------------------------
-- Records of article_type
-- ----------------------------

-- ----------------------------
-- Table structure for `index_banner`
-- ----------------------------
DROP TABLE IF EXISTS `index_banner`;
CREATE TABLE `index_banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '图片名',
  `image` varchar(255) DEFAULT NULL COMMENT '图片文件名',
  `addr` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `add_time` datetime DEFAULT NULL,
  `add_user` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modify_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='首页轮播图';

-- ----------------------------
-- Records of index_banner
-- ----------------------------

-- ----------------------------
-- Table structure for `links_info`
-- ----------------------------
DROP TABLE IF EXISTS `links_info`;
CREATE TABLE `links_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '链接名称',
  `logo` varchar(255) DEFAULT NULL COMMENT 'logo',
  `link_address` varchar(50) DEFAULT NULL COMMENT '链接地址',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `add_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='友情链接表';

-- ----------------------------
-- Records of links_info
-- ----------------------------
INSERT INTO `links_info` VALUES ('1', '百度', null, 'http://www.baidu.com', '1', '2018-12-10 13:30:54', null);
INSERT INTO `links_info` VALUES ('2', '腾讯', null, 'http://www.tencent.com', '7', '2018-12-10 13:42:35', null);
INSERT INTO `links_info` VALUES ('3', 'Alibaba', null, 'http://www.alibaba.com', '1', '2018-12-10 13:47:14', null);
INSERT INTO `links_info` VALUES ('4', 'facebook', null, 'https://www.facebook.com', '6', '2018-12-10 14:16:05', null);
INSERT INTO `links_info` VALUES ('5', '新浪新闻', null, 'https://news.sina.com.cn/', '2', '2018-12-10 14:45:05', null);
INSERT INTO `links_info` VALUES ('6', 'facebook', null, 'https://www.facebook.com', '3', '2018-12-10 16:21:32', null);
INSERT INTO `links_info` VALUES ('7', '新浪新闻', null, 'https://news.sina.com.cn/', '2', '2018-12-10 16:21:33', null);

-- ----------------------------
-- Table structure for `message_info`
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '留言人姓名',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `web_site_url` varchar(100) DEFAULT NULL COMMENT '个人网站地址',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '留言内容',
  `add_time` datetime DEFAULT NULL,
  `add_ip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='留言板信息';

-- ----------------------------
-- Records of message_info
-- ----------------------------
