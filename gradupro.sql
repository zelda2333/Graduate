/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : gradupro

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-05-10 01:50:10
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '老师');
INSERT INTO `authority` VALUES ('2', '助教');
INSERT INTO `authority` VALUES ('3', '超级管理员');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `c_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `c_name` varchar(64) NOT NULL COMMENT '班级名称',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='班级表';

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '计算机科学与技术153班');
INSERT INTO `class` VALUES ('2', '计算机科学与技术154班');

-- ----------------------------
-- Table structure for classrepos
-- ----------------------------
DROP TABLE IF EXISTS `classrepos`;
CREATE TABLE `classrepos` (
  `cr_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `t_id` int(10) unsigned NOT NULL COMMENT '用户id(老师)',
  `c_id` int(10) unsigned NOT NULL COMMENT '老师管理的班级id',
  `cr_name` varchar(64) DEFAULT NULL COMMENT '此老师管理的班级与之对应的组织名',
  PRIMARY KEY (`cr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='github organization表';

-- ----------------------------
-- Records of classrepos
-- ----------------------------

-- ----------------------------
-- Table structure for github
-- ----------------------------
DROP TABLE IF EXISTS `github`;
CREATE TABLE `github` (
  `g_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `t_id` int(10) unsigned NOT NULL COMMENT '老师id',
  `g_uname` varchar(64) NOT NULL COMMENT 'github用户名',
  `g_password` varchar(64) NOT NULL COMMENT 'github密码',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='github 用户表 用于基本认证';

-- ----------------------------
-- Records of github
-- ----------------------------

-- ----------------------------
-- Table structure for repos
-- ----------------------------
DROP TABLE IF EXISTS `repos`;
CREATE TABLE `repos` (
  `r_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `r_name` varchar(64) NOT NULL COMMENT '学生作业仓库名',
  `ssh_url` varchar(255) NOT NULL COMMENT '学生仓库下载地址',
  `owner` varchar(255) NOT NULL COMMENT '组织名称（所属班级）',
  PRIMARY KEY (`r_id`),
  UNIQUE KEY `uk_repn` (`r_name`)
) ENGINE=InnoDB AUTO_INCREMENT=634 DEFAULT CHARSET=utf8 COMMENT='学生作业仓库表';

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
  `c_id` int(10) unsigned NOT NULL COMMENT '班级id',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='学生信息表';

-- ----------------------------
-- Records of studentinfo
-- ----------------------------
INSERT INTO `studentinfo` VALUES ('1', '王泽坤', '6103115143', '2');
INSERT INTO `studentinfo` VALUES ('2', '尹婉婷', '6103115145', '2');
INSERT INTO `studentinfo` VALUES ('3', '李文悦', '6103115139', '2');
INSERT INTO `studentinfo` VALUES ('4', '赵玮怡\r\n', '5501215027\r\n', '2');
INSERT INTO `studentinfo` VALUES ('5', '田宇琛\r\n', '5601115010\r\n', '1');
INSERT INTO `studentinfo` VALUES ('6', '邹淑英\r\n', '5702115009\r\n', '1');
INSERT INTO `studentinfo` VALUES ('7', '周志刚\r\n', '6103114902\r\n', '2');
INSERT INTO `studentinfo` VALUES ('8', '杨姣\r\n', '6103115076\r\n', '1');
INSERT INTO `studentinfo` VALUES ('9', '郭禹\r\n', '6103115077\r\n', '1');
INSERT INTO `studentinfo` VALUES ('10', '徐国强\r\n', '6103115078\r\n', '1');
INSERT INTO `studentinfo` VALUES ('11', '解亚奇\r\n', '6103115079\r\n', '1');
INSERT INTO `studentinfo` VALUES ('12', '王震宁\r\n', '6103115080\r\n', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='学生成绩表';

-- ----------------------------
-- Records of studentscores
-- ----------------------------
INSERT INTO `studentscores` VALUES ('1', '1', '98', '1');
INSERT INTO `studentscores` VALUES ('23', '2', '95', '3');
INSERT INTO `studentscores` VALUES ('24', '3', '98', '1');
INSERT INTO `studentscores` VALUES ('31', '1', '90', '2');
INSERT INTO `studentscores` VALUES ('32', '1', '90', '3');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tc_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `t_id` int(10) unsigned NOT NULL COMMENT '用户id',
  `t_name` varchar(64) NOT NULL COMMENT '用户名（老师）',
  `c_id` int(10) unsigned DEFAULT NULL COMMENT '班级id',
  PRIMARY KEY (`tc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='老师拥有的班级表';

-- ----------------------------
-- Records of teacher
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('24', 'vvv', 'vv', '2');
INSERT INTO `user` VALUES ('25', '安抚', '2', '2');
INSERT INTO `user` VALUES ('26', '2', '2', '2');
INSERT INTO `user` VALUES ('37', 'admin', '123', '3');
INSERT INTO `user` VALUES ('38', '100', '28003', '2');
INSERT INTO `user` VALUES ('39', '王老师', '123', '1');
