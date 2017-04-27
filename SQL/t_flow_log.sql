/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : activiti-db

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-04-27 17:05:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_flow_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_flow_log`;
CREATE TABLE `t_flow_log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FORMID` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `USERID` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `USERTYPE` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `ACTION` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `LOGTIME` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `OPINION` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `TASKID` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `TASKNAME` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `FLOWID` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `RECORDID` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_flow_log
-- ----------------------------
INSERT INTO `t_flow_log` VALUES ('1', null, 'sa', null, '1', '2017-04-25 11:11:45', null, '13', 'myProcess:2:8', '9', '2');
INSERT INTO `t_flow_log` VALUES ('2', null, 'admin', null, '1', '2017-04-25 11:13:06', null, '21', 'myProcess:2:8', '17', '3');
INSERT INTO `t_flow_log` VALUES ('3', null, 'sa', null, '1', '2017-04-25 16:19:01', null, '5009', 'myProcess:4:5004', '5005', '5');
INSERT INTO `t_flow_log` VALUES ('4', null, 'sa', null, '3', '2017-04-25 16:24:19', '', '24', 'myProcess:2:8', '17', '3');
INSERT INTO `t_flow_log` VALUES ('5', null, 'admin', null, '1', '2017-04-25 16:27:10', null, '7503', 'myProcess:2:8', '17', '3');
INSERT INTO `t_flow_log` VALUES ('6', null, 'admin', null, '1', '2017-04-25 16:29:18', null, '10005', 'myProcess:4:5004', '10001', '6');
INSERT INTO `t_flow_log` VALUES ('7', null, 'sa', null, '2', '2017-04-26 16:54:58', '', '7505', 'myProcess:2:8', '17', '3');
INSERT INTO `t_flow_log` VALUES ('8', null, 'sa', null, '2', '2017-04-26 16:55:04', '', '5012', 'myProcess:4:5004', '5005', '5');
INSERT INTO `t_flow_log` VALUES ('9', null, 'sa', null, '2', '2017-04-26 16:55:08', '', '16', 'myProcess:2:8', '9', '2');
INSERT INTO `t_flow_log` VALUES ('10', null, 'sa', null, '2', '2017-04-26 16:55:11', '', '10008', 'myProcess:4:5004', '10001', '6');
INSERT INTO `t_flow_log` VALUES ('11', null, 'sa', null, '1', '2017-04-26 16:55:58', null, '35018', 'myProcess:9:22504', '35014', '9');
INSERT INTO `t_flow_log` VALUES ('12', null, 'admin', null, '2', '2017-04-26 16:56:40', '', '35013', 'myProcess:4:5004', '10001', '6');
INSERT INTO `t_flow_log` VALUES ('13', null, 'admin', null, '2', '2017-04-26 16:56:46', '', '35009', 'myProcess:2:8', '9', '2');
INSERT INTO `t_flow_log` VALUES ('14', null, 'admin', null, '2', '2017-04-26 16:56:51', '', '35005', 'myProcess:4:5004', '5005', '5');
INSERT INTO `t_flow_log` VALUES ('15', null, 'admin', null, '2', '2017-04-26 16:56:56', '', '35002', 'myProcess:2:8', '17', '3');
INSERT INTO `t_flow_log` VALUES ('16', null, 'sa', null, '1', '2017-04-26 17:00:12', null, '35028', 'myProcess:9:22504', '35024', '10');
INSERT INTO `t_flow_log` VALUES ('17', null, 'sa', null, '1', '2017-04-26 17:02:03', null, '35038', 'myProcess:10:35033', '35034', '11');
INSERT INTO `t_flow_log` VALUES ('18', null, 'sa', null, '2', '2017-04-26 17:02:42', '', '35041', 'myProcess:10:35033', '35034', '11');
INSERT INTO `t_flow_log` VALUES ('19', null, 'wo', null, '1', '2017-04-27 15:34:22', null, '47572', 'WF_Leave:2:50004', '47561', '14');
INSERT INTO `t_flow_log` VALUES ('20', null, 'wo', null, '1', '2017-04-27 15:42:33', null, '47589', 'WF_Leave:3:52504', '47578', '15');
INSERT INTO `t_flow_log` VALUES ('21', null, 'wo', null, '1', '2017-04-27 16:20:47', null, '55012', 'WF_Leave:3:52504', '55001', '16');
INSERT INTO `t_flow_log` VALUES ('22', null, 'zj', null, '2', '2017-04-27 16:22:28', '', '55017', 'WF_Leave:3:52504', '55001', '16');
INSERT INTO `t_flow_log` VALUES ('23', null, 'rs', null, '3', '2017-04-27 16:23:06', '', '55022', 'WF_Leave:3:52504', '55001', '16');
INSERT INTO `t_flow_log` VALUES ('24', null, 'wo', null, '1', '2017-04-27 16:34:48', null, '55039', 'WF_Leave:4:57504', '55028', '17');
INSERT INTO `t_flow_log` VALUES ('25', null, 'bm', null, '2', '2017-04-27 16:35:52', '', '55042', 'WF_Leave:4:57504', '55028', '17');
INSERT INTO `t_flow_log` VALUES ('26', null, 'zj', null, '2', '2017-04-27 16:36:17', 'xx', '55048', 'WF_Leave:4:57504', '55028', '17');
INSERT INTO `t_flow_log` VALUES ('27', null, 'rs', null, '3', '2017-04-27 16:36:49', '', '55052', 'WF_Leave:4:57504', '55028', '17');
INSERT INTO `t_flow_log` VALUES ('28', null, 'wo', null, '2', '2017-04-27 16:37:30', '的的双丰收的发送到发', '55056', 'WF_Leave:4:57504', '55028', '17');
INSERT INTO `t_flow_log` VALUES ('29', null, 'wo', null, '1', '2017-04-27 16:39:34', null, '55073', 'WF_Leave:5:60004', '55062', '18');
INSERT INTO `t_flow_log` VALUES ('30', null, 'bm', null, '2', '2017-04-27 16:39:53', '', '55076', 'WF_Leave:5:60004', '55062', '18');
INSERT INTO `t_flow_log` VALUES ('31', null, 'jl', null, '3', '2017-04-27 16:40:25', '', '55082', 'WF_Leave:5:60004', '55062', '18');
INSERT INTO `t_flow_log` VALUES ('32', null, 'wo', null, '2', '2017-04-27 16:40:48', '', '55086', 'WF_Leave:5:60004', '55062', '18');
INSERT INTO `t_flow_log` VALUES ('33', null, 'bm', null, '2', '2017-04-27 16:41:22', '', '55088', 'WF_Leave:5:60004', '55062', '18');
INSERT INTO `t_flow_log` VALUES ('34', null, 'jl', null, '2', '2017-04-27 16:41:39', '', '55092', 'WF_Leave:5:60004', '55062', '18');
INSERT INTO `t_flow_log` VALUES ('35', null, 'rs', null, '2', '2017-04-27 16:41:55', '', '55095', 'WF_Leave:5:60004', '55062', '18');
