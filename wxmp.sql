/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : wxmp

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 27/09/2023 09:17:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wx_network_hook_log
-- ----------------------------
DROP TABLE IF EXISTS `wx_network_hook_log`;
CREATE TABLE `wx_network_hook_log`  (
  `N_PK_ID` int NOT NULL AUTO_INCREMENT,
  `T_CRT_TM` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `C_DOC_CHAR` varchar(16000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`N_PK_ID`) USING BTREE,
  INDEX `IDX_LOG_CRT_TM`(`T_CRT_TM` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wx_network_hook_log
-- ----------------------------
INSERT INTO `wx_network_hook_log` VALUES (1, '2023-09-26 16:13:29', '123123');

-- ----------------------------
-- Table structure for wx_user
-- ----------------------------
DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user`  (
  `N_PK_ID` int NOT NULL AUTO_INCREMENT,
  `C_WX_NO` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `C_OPEN_ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `C_WX_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `T_CRT_TM` timestamp NULL DEFAULT NULL,
  `T_UDP_TM` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `T_STATUS` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '0不生效1生效',
  PRIMARY KEY (`N_PK_ID`) USING BTREE,
  INDEX `IDX_USER_WX_NO`(`C_WX_NO` ASC) USING BTREE,
  INDEX `IDX_USER_OPEN_ID`(`C_OPEN_ID` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wx_user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
