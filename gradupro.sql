/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : gradupro

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-05-09 17:39:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `author_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `author_type` varchar(64) NOT NULL COMMENT '权限类别',
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '老师');
INSERT INTO `authority` VALUES ('2', '管理员');

-- ----------------------------
-- Table structure for repos
-- ----------------------------
DROP TABLE IF EXISTS `repos`;
CREATE TABLE `repos` (
  `r_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `r_name` varchar(64) NOT NULL COMMENT '仓库名',
  `ssh_url` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  PRIMARY KEY (`r_id`),
  UNIQUE KEY `uk_repn` (`r_name`)
) ENGINE=InnoDB AUTO_INCREMENT=532 DEFAULT CHARSET=utf8 COMMENT='仓库表';

-- ----------------------------
-- Records of repos
-- ----------------------------
INSERT INTO `repos` VALUES ('301', '6103115145', 'git@github.com:gradupro/6103115145.git', 'gradupro');
INSERT INTO `repos` VALUES ('302', '6103115143', 'git@github.com:gradupro/6103115143.git', 'gradupro');
INSERT INTO `repos` VALUES ('303', '6103115139', 'git@github.com:gradupro/6103115139.git', 'gradupro');

-- ----------------------------
-- Table structure for studentinfo
-- ----------------------------
DROP TABLE IF EXISTS `studentinfo`;
CREATE TABLE `studentinfo` (
  `s_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `s_name` varchar(64) NOT NULL COMMENT '学生姓名',
  `s_number` varchar(64) NOT NULL COMMENT '学生学号',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='学生信息表';

-- ----------------------------
-- Records of studentinfo
-- ----------------------------
INSERT INTO `studentinfo` VALUES ('1', '王泽坤', '6103115143');
INSERT INTO `studentinfo` VALUES ('2', '鸭鸭', '6103115145');
INSERT INTO `studentinfo` VALUES ('3', '南南', '6103115139');

-- ----------------------------
-- Table structure for studentscores
-- ----------------------------
DROP TABLE IF EXISTS `studentscores`;
CREATE TABLE `studentscores` (
  `score_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `s_id` int(10) unsigned NOT NULL COMMENT '学生id',
  `score` varchar(64) NOT NULL COMMENT '学生成绩',
  `number` varchar(64) NOT NULL COMMENT '用于查issuse',
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='学生成绩表';

-- ----------------------------
-- Records of studentscores
-- ----------------------------
INSERT INTO `studentscores` VALUES ('1', '1', '100', '1');
INSERT INTO `studentscores` VALUES ('23', '2', '95', '3');
INSERT INTO `studentscores` VALUES ('24', '3', '98', '1');
INSERT INTO `studentscores` VALUES ('31', '1', '95', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `u_name` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `author_id` int(10) unsigned NOT NULL COMMENT '权限id',
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `uk_n` (`u_name`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '1234', '2');
INSERT INTO `user` VALUES ('24', 'vvv', 'vv', '2');
INSERT INTO `user` VALUES ('25', '安抚', '2', '2');
INSERT INTO `user` VALUES ('26', '2', '2', '2');
INSERT INTO `user` VALUES ('29', '我啊', '123', '1');
INSERT INTO `user` VALUES ('36', '092178 ', '280030', '2');
