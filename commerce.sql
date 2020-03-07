/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : commerce

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2020-03-07 21:43:34
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `bname` varchar(32) DEFAULT NULL,
  `blogo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO brand VALUES ('15', '14', '111', '/uploadFile/2020/03/06/2c4aca73-2d09-4126-920d-4ca145090c0c.jpeg');

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `ccname` varchar(32) DEFAULT NULL,
  `cename` varchar(32) DEFAULT NULL,
  `cinfo` varchar(255) DEFAULT NULL,
  `ctype` varchar(32) DEFAULT NULL,
  `curl` varchar(32) DEFAULT NULL,
  `cpassword` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO company VALUES ('11', null, '123', null, null, null, '123');
INSERT INTO company VALUES ('12', null, '123', null, null, null, '123');
INSERT INTO company VALUES ('13', null, '123', null, null, null, '123');
INSERT INTO company VALUES ('14', '1112', '111', '\n \n输入内容…111 \n				  \n                  \n                      \n                  ', '111', '111', '111');

-- ----------------------------
-- Table structure for `company_account`
-- ----------------------------
DROP TABLE IF EXISTS `company_account`;
CREATE TABLE `company_account` (
  `ca_id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `ca_name` varchar(32) DEFAULT NULL,
  `ca_email` varchar(32) DEFAULT NULL,
  `ca_pwd` varchar(32) DEFAULT NULL,
  `ca_money` float(255,2) DEFAULT NULL,
  PRIMARY KEY (`ca_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_account
-- ----------------------------
INSERT INTO company_account VALUES ('18', '14', '111', '111', '111', '553.00');

-- ----------------------------
-- Table structure for `company_record`
-- ----------------------------
DROP TABLE IF EXISTS `company_record`;
CREATE TABLE `company_record` (
  `cr_id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `cr_transact` varchar(32) DEFAULT NULL,
  `cr_money` float(255,2) DEFAULT NULL,
  `cr_time` varchar(32) DEFAULT NULL,
  `cr_status` int(11) DEFAULT NULL,
  `cr_type` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`cr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_record
-- ----------------------------
INSERT INTO company_record VALUES ('12', '14', '428137113662', '20.00', '2020-03-07 09:20:56', '1', '提现');

-- ----------------------------
-- Table structure for `data_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `data_dictionary`;
CREATE TABLE `data_dictionary` (
  `dictionary_id` int(11) NOT NULL AUTO_INCREMENT,
  `dictionary_type` varchar(32) DEFAULT NULL,
  `dictionary_description` varchar(32) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  `code_value` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`dictionary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_dictionary
-- ----------------------------
INSERT INTO data_dictionary VALUES ('5', '', '', '0', '12efvewt');
INSERT INTO data_dictionary VALUES ('6', '', '', '0', 'cfcnfg');

-- ----------------------------
-- Table structure for `good`
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gc_id` int(11) DEFAULT NULL,
  `gname` varchar(32) DEFAULT NULL,
  `gprice` float(32,2) DEFAULT NULL,
  `gcounts` int(11) DEFAULT NULL,
  `gsku` varchar(32) DEFAULT NULL,
  `length` float(7,2) DEFAULT NULL,
  `width` float(7,2) DEFAULT NULL,
  `height` float(7,2) DEFAULT NULL,
  `weight` float(7,2) DEFAULT NULL,
  `upc` varchar(32) DEFAULT NULL,
  `ena` varchar(32) DEFAULT NULL,
  `model` varchar(32) DEFAULT NULL,
  `maintain` varchar(32) DEFAULT NULL,
  `edescription` text,
  `adescription` text,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO good VALUES ('24', '21', '64655', '200.00', '500', '346ygf', '456.00', '45.00', '456.00', '4564.00', 'f43yhb', '54th54h', '45h54u', '12', '输入内容…grefzhbdnfgn', '输入内容…dzhzdrhzdfhdfh', '14');
INSERT INTO good VALUES ('26', '23', '1313', '123.00', '111111', '1', '11.00', '1.00', '1.00', '1.00', '1', '1', '1', '12', '输入内容…ffff', '输入内容…fff', '14');
INSERT INTO good VALUES ('27', '24', 'dfnhxhtr', '22.00', '198', '12rrrrrrrr', '12.00', '12.00', '12.00', '12.00', 'f3tt4', 'f24t', '13', '12', '输入内容…fdhthr', '输入内容…gfxhbfbbvnvmgh', '14');
INSERT INTO good VALUES ('28', '25', 'e464rgejft', '13.00', '200', 'vg43g', '12.00', '12.00', '12.00', '12.00', 'g34h5', '45hh45hh', '12', '12', '输入内容…fdhgfnng', '输入内容…fgznzdfhzer', '14');

-- ----------------------------
-- Table structure for `good_category`
-- ----------------------------
DROP TABLE IF EXISTS `good_category`;
CREATE TABLE `good_category` (
  `gc_id` int(11) NOT NULL AUTO_INCREMENT,
  `gc_category` varchar(32) DEFAULT NULL,
  `gc_picture` varchar(32) DEFAULT NULL,
  `gc_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`gc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good_category
-- ----------------------------
INSERT INTO good_category VALUES ('21', '电器类', 'a.jpg', '4');
INSERT INTO good_category VALUES ('23', '电器类', 'IMG_20181228_134200.jpg', '4');
INSERT INTO good_category VALUES ('24', '文具办公类', '1.jpeg', '4');
INSERT INTO good_category VALUES ('25', '美妆类', '1.jpeg', '4');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `ocounts` float(7,2) DEFAULT NULL,
  `orderno` varchar(32) DEFAULT NULL,
  `trackingno` varchar(32) DEFAULT NULL,
  `ocost` float(32,2) DEFAULT NULL,
  `createtime` varchar(32) DEFAULT NULL,
  `ostatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO orders VALUES ('19', '27', '11', '24.00', 'Lo09W6OWcu', '750113726035', '528.00', '2020-03-07 09:26:28', '4');

-- ----------------------------
-- Table structure for `parameter_management`
-- ----------------------------
DROP TABLE IF EXISTS `parameter_management`;
CREATE TABLE `parameter_management` (
  `parameter_id` int(11) NOT NULL AUTO_INCREMENT,
  `parameter_value` varchar(32) DEFAULT NULL,
  `parameter_key` varchar(32) DEFAULT NULL,
  `parameter_description` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`parameter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parameter_management
-- ----------------------------
INSERT INTO parameter_management VALUES ('9', '', '', '122');

-- ----------------------------
-- Table structure for `seller`
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(32) DEFAULT NULL,
  `semail` varchar(32) DEFAULT NULL,
  `sphone` varchar(32) DEFAULT NULL,
  `spassword` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller
-- ----------------------------
INSERT INTO seller VALUES ('10', '1234', null, null, '123');
INSERT INTO seller VALUES ('11', '222', '222', '222', '222');

-- ----------------------------
-- Table structure for `seller_account`
-- ----------------------------
DROP TABLE IF EXISTS `seller_account`;
CREATE TABLE `seller_account` (
  `sa_id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `sa_name` varchar(32) DEFAULT NULL,
  `sa_pwd` varchar(32) DEFAULT NULL,
  `sa_email` varchar(32) DEFAULT NULL,
  `sa_money` float(255,2) DEFAULT NULL,
  PRIMARY KEY (`sa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller_account
-- ----------------------------
INSERT INTO seller_account VALUES ('9', '11', '222', '222', '222', '49467.00');

-- ----------------------------
-- Table structure for `seller_record`
-- ----------------------------
DROP TABLE IF EXISTS `seller_record`;
CREATE TABLE `seller_record` (
  `sr_id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `sr_transact` varchar(32) DEFAULT NULL,
  `sr_money` float(255,2) DEFAULT NULL,
  `sr_time` varchar(32) DEFAULT NULL,
  `sr_status` int(11) DEFAULT NULL,
  `sr_type` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`sr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller_record
-- ----------------------------
INSERT INTO seller_record VALUES ('17', '11', '784755978699', '50000.00', '2020-03-07 09:28:13', '1', '充值');

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `store_id` int(11) NOT NULL AUTO_INCREMENT,
  `store_name` varchar(32) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `marketplaceId` int(11) DEFAULT NULL,
  `mws` varchar(32) DEFAULT NULL,
  `store_type` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO store VALUES ('18', '22', '11', '22', '22', 'Amazon');
INSERT INTO store VALUES ('19', '22', '11', '22', '222', 'eBay');

-- ----------------------------
-- Table structure for `store_good`
-- ----------------------------
DROP TABLE IF EXISTS `store_good`;
CREATE TABLE `store_good` (
  `gids` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`gids`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store_good
-- ----------------------------
INSERT INTO store_good VALUES ('92', '27', '19');
INSERT INTO store_good VALUES ('93', '27', '18');

-- ----------------------------
-- Table structure for `superadmin`
-- ----------------------------
DROP TABLE IF EXISTS `superadmin`;
CREATE TABLE `superadmin` (
  `admin_name` varchar(32) DEFAULT NULL,
  `admin_pwd` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of superadmin
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL,
  `user_password` varchar(32) DEFAULT NULL,
  `user_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'admin', '123', '0');
INSERT INTO user VALUES ('14', '111', '111', '1');
INSERT INTO user VALUES ('15', '222', '222', '2');

-- ----------------------------
-- Table structure for `wishlist`
-- ----------------------------
DROP TABLE IF EXISTS `wishlist`;
CREATE TABLE `wishlist` (
  `wid` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wishlist
-- ----------------------------
INSERT INTO wishlist VALUES ('56', '27', '11');
