/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : activiti-db

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-04-27 17:05:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_leave`
-- ----------------------------
DROP TABLE IF EXISTS `t_leave`;
CREATE TABLE `t_leave` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leavePerson` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `superior` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `startTime` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `endTime` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `leaveReasons` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `createTime` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `userID` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `domStatus` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_leave
-- ----------------------------
INSERT INTO `t_leave` VALUES ('2', 'sa', 'admin', '2017-04-25 11:10', '2017-04-29 11:10', 'dddd', '17-04-25 11:04:45', 'sa', '3');
INSERT INTO `t_leave` VALUES ('3', 'admin', 'sa', '2017-04-25 11:12', '2017-04-29 11:12', 'dddxxxx', '17-04-25 11:04:06', 'admin', '3');
INSERT INTO `t_leave` VALUES ('4', 'sa', 'admin', '2017-04-25 16:11', '2017-04-29 16:11', 'dddd', '17-04-25 04:04:30', 'sa', '1');
INSERT INTO `t_leave` VALUES ('5', 'sa', 'admin', '2017-04-25 16:11', '2017-04-29 16:11', 'ddddxx6666', '17-04-25 04:04:08', 'sa', '3');
INSERT INTO `t_leave` VALUES ('6', 'admin', 'sa', '2017-04-25 16:28', '2017-05-05 16:28', 'dddd6666', '17-04-25 04:04:45', 'admin', '3');
INSERT INTO `t_leave` VALUES ('7', 'sa', 'admin', '2017-04-26 16:35', '2017-04-29 16:35', 'dd', '17-04-26 04:04:42', 'sa', '1');
INSERT INTO `t_leave` VALUES ('8', 'sa', 'admin', '2017-04-26 16:42', '2017-05-05 16:42', 'xfddfdfxxx', '17-04-26 04:04:41', 'sa', '1');
INSERT INTO `t_leave` VALUES ('9', 'sa', 'admin', '2017-04-26 16:55', '2017-04-28 16:55', '请假玩', '17-04-26 04:04:53', 'sa', '2');
INSERT INTO `t_leave` VALUES ('10', 'sa', 'admin', '2017-04-26 16:59', '2017-04-29 16:59', 'xxx', '17-04-26 05:04:12', 'sa', '2');
INSERT INTO `t_leave` VALUES ('11', 'sa', 'admin', '2017-04-26 17:01', '2017-04-29 17:01', 'fffffff', '17-04-26 05:04:03', 'sa', '2');
INSERT INTO `t_leave` VALUES ('12', 'wo', 'bm', '2017-04-27 10:52', '2017-05-06 10:52', 'qingjia', '17-04-27 10:04:54', 'wo', '2');
INSERT INTO `t_leave` VALUES ('14', 'wo', 'bm', '2017-04-27 14:04', '2017-04-29 14:04', 'xxx555', '17-04-27 02:04:41', 'wo', '2');
INSERT INTO `t_leave` VALUES ('15', 'wo', 'bm', '2017-04-27 15:42', '2017-04-29 15:42', 'sss', '17-04-27 03:04:26', 'wo', '2');
INSERT INTO `t_leave` VALUES ('16', 'wo', 'bm', '2017-04-27 16:20', '2017-05-06 16:20', 'xxxx', '17-04-27 04:04:47', 'wo', '4');
INSERT INTO `t_leave` VALUES ('17', 'wo', 'bm', '2017-04-27 16:34', '2017-05-06 16:34', 'xxxx', '17-04-27 04:04:48', 'wo', '3');
INSERT INTO `t_leave` VALUES ('18', 'wo', 'bm', '2017-04-27 16:39', '2017-04-28 16:39', 'xxx', '17-04-27 04:04:34', 'wo', '4');
