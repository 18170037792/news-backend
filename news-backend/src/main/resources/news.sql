/*
Navicat MySQL Data Transfer

Source Server         : qujie
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-26 18:09:59
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='文章信息表';

-- ----------------------------
-- Records of article_info
-- ----------------------------
INSERT INTO `article_info` VALUES ('1', '测试', '方霞飞123', '测试测试测试', '1', '0', '2018-12-18 16:30:38', '1', null, null, null, null);
INSERT INTO `article_info` VALUES ('2', '帅哥', '瞿杰', '南昌吴彦祖', '1', '0', '2018-12-05 16:31:07', '1', null, null, null, null);
INSERT INTO `article_info` VALUES ('3', '山有木惜', '木有只', null, null, '0', '2018-12-19 17:32:13', '2', null, null, null, null);
INSERT INTO `article_info` VALUES ('4', '据最新媒体报道', '加拿大扣留孟晚舟一案', null, null, '0', '2018-12-19 17:32:54', '2', null, null, null, null);
INSERT INTO `article_info` VALUES ('5', '美国太空司令部', '旨在围堵中国', null, null, '0', '2018-12-19 17:33:27', '1', null, null, null, null);
INSERT INTO `article_info` VALUES ('6', '花间一壶酒', '可饮一杯无', null, null, '0', '2018-12-19 17:34:09', '1', null, null, null, null);

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
-- Table structure for `log_info`
-- ----------------------------
DROP TABLE IF EXISTS `log_info`;
CREATE TABLE `log_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `action` varchar(100) DEFAULT NULL,
  `data` text,
  `author_id` bigint(20) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(100) DEFAULT NULL COMMENT '最后登录ip',
  `ip_home_location` varchar(100) DEFAULT NULL COMMENT 'ip归属地',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of log_info
-- ----------------------------
INSERT INTO `log_info` VALUES ('86', '登录后台', null, '1', '2018-12-25 15:39:20', '0:0:0:0:0:0:0:1', 'localhost');
INSERT INTO `log_info` VALUES ('87', '登录后台', null, '1', '2018-12-25 15:35:16', '0:0:0:0:0:0:0:1', 'localhost');
INSERT INTO `log_info` VALUES ('88', '登录后台', null, '1', '2018-12-25 15:37:15', '0:0:0:0:0:0:0:1', 'localhost');
INSERT INTO `log_info` VALUES ('89', '登录后台', null, '3', '2018-12-25 15:39:03', '0:0:0:0:0:0:0:1', 'localhost');
INSERT INTO `log_info` VALUES ('90', '登录后台', null, '1', '2018-12-25 15:40:37', '0:0:0:0:0:0:0:1', 'localhost');
INSERT INTO `log_info` VALUES ('91', '登录后台', null, '1', '2018-12-25 16:03:35', '0:0:0:0:0:0:0:1', 'localhost');
INSERT INTO `log_info` VALUES ('92', '登录后台', null, '1', '2018-12-25 16:20:22', '0:0:0:0:0:0:0:1', 'localhost');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='留言板信息';

-- ----------------------------
-- Records of message_info
-- ----------------------------
INSERT INTO `message_info` VALUES ('1', '瞿杰', '1125455@qq.com', 'https://www.baidu.com', '很棒', '这篇文章很棒', '2018-12-19 16:33:06', null);

-- ----------------------------
-- Table structure for `user_article_message`
-- ----------------------------
DROP TABLE IF EXISTS `user_article_message`;
CREATE TABLE `user_article_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author_id` bigint(20) DEFAULT NULL COMMENT '文章作者id',
  `article_id` bigint(20) DEFAULT NULL COMMENT '文章id',
  `message_id` bigint(20) DEFAULT NULL COMMENT '留言评论id',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='文章留言关系表';

-- ----------------------------
-- Records of user_article_message
-- ----------------------------
INSERT INTO `user_article_message` VALUES ('1', '1', '1', '1', '2018-12-19 17:08:17');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(100) DEFAULT NULL COMMENT '密码',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机号',
  `frozen` tinyint(1) DEFAULT '0' COMMENT '是否冻结用户，0为显示，1为冻结',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `home_url` varchar(255) DEFAULT NULL COMMENT '用户主页',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `add_ip` varchar(50) DEFAULT NULL COMMENT '添加时ip',
  `modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `modify_ip` varchar(50) DEFAULT NULL COMMENT '最后修改时ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户信息';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'qujie', 'e10adc3949ba59abbe56e057f20f883e', '18170037792', '0', '1071367833@qq.com', '1', 'https://github.com/18170037792', null, null, null, null);
INSERT INTO `user_info` VALUES ('2', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '18170037792', '0', null, '2', null, null, null, null, null);
INSERT INTO `user_info` VALUES ('3', 'fangxiafei', 'e10adc3949ba59abbe56e057f20f883e', '15465', '1', '123123@qq.com', '1', 'https://github.com/18170037792', null, null, null, null);

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `add_user` bigint(20) DEFAULT NULL,
  `add_ip` varchar(50) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modify_user` bigint(20) DEFAULT NULL,
  `modify_ip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色信息';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '管理员', null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('2', '超级管理员', null, null, null, null, null, null);
