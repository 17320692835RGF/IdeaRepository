/*
Navicat MySQL Data Transfer

Source Server         : zhang
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : java9

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2021-08-22 18:03:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '艾瑞克', '男', '18', '沈阳', '324', '2321423@qq.com', 'eric', '123');
INSERT INTO `user` VALUES ('2', '李三', '男', '18', '北京', '111213213', '21321321@qq.com', null, null);
INSERT INTO `user` VALUES ('3', '李四', '男', '15', '陕西', '1133113131', 'dasas@qewqe.com', null, null);
INSERT INTO `user` VALUES ('6', '李广坤', '男', '111', '北京', '323243232432', '232432433@qq.com', null, null);
INSERT INTO `user` VALUES ('7', '李寻欢', '男', '23', '上海', '1133113131', '23213213@qq.com', null, null);
INSERT INTO `user` VALUES ('22', '问我群二', '男', '12', '北京', '3213', '31232121', null, null);
INSERT INTO `user` VALUES ('10', '沈阳', '男', '111', '北京', '1133113131', '211@qd', null, null);
INSERT INTO `user` VALUES ('23', '  大萨达', '女', '323', '上海', '3231', '322323', null, null);
INSERT INTO `user` VALUES ('24', '大萨达', '女', '21321', '湖南', '1133113131', '321', null, null);
INSERT INTO `user` VALUES ('21', '寻物控', '男', '232', '北京', '21323', '34324324', null, null);
