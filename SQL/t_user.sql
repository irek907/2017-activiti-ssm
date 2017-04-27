/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : activiti-db

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-04-27 17:05:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '1');
INSERT INTO `t_user` VALUES ('2', 'sa', '1');
INSERT INTO `t_user` VALUES ('3', 'zhangsan', '1');
INSERT INTO `t_user` VALUES ('4', 'wo', '1');
INSERT INTO `t_user` VALUES ('5', 'bm', '1');
INSERT INTO `t_user` VALUES ('6', 'jl', '1');
INSERT INTO `t_user` VALUES ('7', 'zj', '1');
INSERT INTO `t_user` VALUES ('8', 'rs', '1');
INSERT INTO `t_user` VALUES ('9', 'xj', '1');
