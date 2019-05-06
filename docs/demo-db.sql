/*
Navicat MySQL Data Transfer

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo_department
-- ----------------------------
DROP TABLE IF EXISTS `demo_department`;
CREATE TABLE `demo_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `sort` bigint(11) DEFAULT NULL COMMENT '排序',
  `level` int(10) DEFAULT NULL COMMENT '级别',
  `left_value` int(11) DEFAULT NULL,
  `right_value` int(11) DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL COMMENT '0=正常，1=删除',
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='部门表';
