/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : gradupro

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-05-05 21:45:34
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
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `s_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `s_name` varchar(64) NOT NULL COMMENT '学生姓名',
  `s_number` varchar(64) NOT NULL COMMENT '学生学号',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生信息表';

-- ----------------------------
-- Records of student_info
-- ----------------------------

-- ----------------------------
-- Table structure for student_scores
-- ----------------------------
DROP TABLE IF EXISTS `student_scores`;
CREATE TABLE `student_scores` (
  `score_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `s_id` int(10) unsigned NOT NULL COMMENT '学生id',
  `score` int(10) unsigned NOT NULL COMMENT '学生成绩',
  `title` varchar(64) NOT NULL COMMENT 'issue title',
  `body` longtext NOT NULL COMMENT 'issue body',
  `label` int(10) unsigned NOT NULL COMMENT 'issue label',
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生成绩表';

-- ----------------------------
-- Records of student_scores
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
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123', '2');
INSERT INTO `user` VALUES ('3', '发', '21', '2');
INSERT INTO `user` VALUES ('23', 'vvv', '444', '2');
INSERT INTO `user` VALUES ('24', 'vvv', 'vvv', '2');
INSERT INTO `user` VALUES ('25', '安抚', '2', '2');
INSERT INTO `user` VALUES ('26', '2', '2', '2');
INSERT INTO `user` VALUES ('27', '1的', '2', '2');
