/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : lnycloud

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 08/12/2022 17:43:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES (1, '测试练习');
INSERT INTO `payment` VALUES (2, NULL);
INSERT INTO `payment` VALUES (3, '成功添加');
INSERT INTO `payment` VALUES (4, '乐山大佛你');
INSERT INTO `payment` VALUES (5, '乐山大佛你');
INSERT INTO `payment` VALUES (6, '乐山大佛你');
INSERT INTO `payment` VALUES (7, '没你的是了');

SET FOREIGN_KEY_CHECKS = 1;
