/*
Navicat MySQL Data Transfer

Source Server         : 119.29.85.165
Source Server Version : 50610
Source Host           : 119.29.85.165:3306
Source Database       : cp1

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2016-06-04 20:37:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tdepart
-- ----------------------------
DROP TABLE IF EXISTS `tdepart`;
CREATE TABLE `tdepart` (
  `departId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学院id',
  `schoolId` bigint(20) DEFAULT NULL COMMENT '学校id',
  `departName` varchar(30) DEFAULT NULL COMMENT '学院名',
  `departNum` varchar(20) DEFAULT NULL COMMENT '学院代码',
  PRIMARY KEY (`departId`),
  KEY `FK_Reference_30` (`schoolId`),
  CONSTRAINT `FK_Reference_30` FOREIGN KEY (`schoolId`) REFERENCES `tschool` (`schoolId`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='部门表，如学院，教务处';

-- ----------------------------
-- Records of tdepart
-- ----------------------------
INSERT INTO `tdepart` VALUES ('1', '1', '软件与通信工程学院', '83840286');
INSERT INTO `tdepart` VALUES ('2', '1', '教务处', null);
INSERT INTO `tdepart` VALUES ('3', '1', '人事处', null);
INSERT INTO `tdepart` VALUES ('4', '1', '工商管理学院', '83816813');
INSERT INTO `tdepart` VALUES ('5', '1', '外国语学院', '83843233');
INSERT INTO `tdepart` VALUES ('6', '1', '财税与公共管理学院', '83816613');
INSERT INTO `tdepart` VALUES ('7', '1', '人文学院', '83843212');
INSERT INTO `tdepart` VALUES ('8', '1', '会计学院', '83823181');
INSERT INTO `tdepart` VALUES ('9', '1', '国际经贸学院', '83816581');
INSERT INTO `tdepart` VALUES ('10', '1', '体育学院、国防教育部', '83843636');
INSERT INTO `tdepart` VALUES ('11', '1', '经济学院', '83816532');
INSERT INTO `tdepart` VALUES ('12', '1', '马克思主义学院', '83816923');
INSERT INTO `tdepart` VALUES ('13', '1', '金融学院', '83816792');
INSERT INTO `tdepart` VALUES ('14', '1', 'MBA学院', '83816962');
INSERT INTO `tdepart` VALUES ('15', '1', '统计学院', '83816428');
INSERT INTO `tdepart` VALUES ('16', '1', '国际学院', '83816426');
INSERT INTO `tdepart` VALUES ('17', '1', '信息管理学院', '83983891');
INSERT INTO `tdepart` VALUES ('18', '1', '职业技术学院', '83890697');
INSERT INTO `tdepart` VALUES ('19', '1', '旅游与城市管理学院', '83842930');
INSERT INTO `tdepart` VALUES ('20', '1', '法学院', '83816810');
INSERT INTO `tdepart` VALUES ('21', '1', '现代经济管理学院', '83891773');

-- ----------------------------
-- Table structure for tevaluate
-- ----------------------------
DROP TABLE IF EXISTS `tevaluate`;
CREATE TABLE `tevaluate` (
  `evaluateId` bigint(20) NOT NULL AUTO_INCREMENT,
  `gproLea` bigint(20) DEFAULT '0' COMMENT '专业学习',
  `gnonProLea` bigint(20) DEFAULT '0' COMMENT '非专业学习',
  `gextraLearn` bigint(20) DEFAULT '0' COMMENT '课外学习',
  `gphyHealth` bigint(20) DEFAULT '0' COMMENT '身体健康',
  `gmentalHealth` bigint(20) DEFAULT '0' COMMENT '心理健康',
  `gmanageMoney` bigint(20) DEFAULT '0' COMMENT '理财',
  `ginterpersonal` bigint(20) DEFAULT '0' COMMENT '人际沟通',
  `gclubEvent` bigint(20) DEFAULT '0' COMMENT '社团部门',
  `gsocialEvent` bigint(20) DEFAULT '0' COMMENT '社会',
  `eveluaterId` bigint(20) DEFAULT NULL COMMENT '评价人id',
  `submit` varchar(10) DEFAULT 'fail' COMMENT '提交标识符',
  PRIMARY KEY (`evaluateId`),
  KEY `eveluaterId` (`eveluaterId`),
  CONSTRAINT `tevaluate_ibfk_1` FOREIGN KEY (`eveluaterId`) REFERENCES `tevaluater` (`evaluaterId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='评价分数';

-- ----------------------------
-- Records of tevaluate
-- ----------------------------
INSERT INTO `tevaluate` VALUES ('1', '8', '9', '7', '8', '8', '7', '10', '8', '0', '1', 'success');
INSERT INTO `tevaluate` VALUES ('2', '7', '8', '9', '10', '5', '6', '7', '8', '0', '4', 'success');
INSERT INTO `tevaluate` VALUES ('3', '2', '3', '9', '6', '9', '6', '5', '9', '4', '53', 'success');
INSERT INTO `tevaluate` VALUES ('4', '6', '8', '6', '7', '9', '10', '5', '7', '9', '54', 'success');
INSERT INTO `tevaluate` VALUES ('5', '8', '9', '7', '8', '10', '10', '8', '7', '9', '55', 'success');

-- ----------------------------
-- Table structure for tevaluater
-- ----------------------------
DROP TABLE IF EXISTS `tevaluater`;
CREATE TABLE `tevaluater` (
  `evaluaterId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评价人表',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户主键',
  `termNum` bigint(20) DEFAULT NULL COMMENT '学期号',
  `evauserId` bigint(20) DEFAULT NULL,
  `submit` varchar(10) DEFAULT 'fail' COMMENT '互评完成标志',
  PRIMARY KEY (`evaluaterId`),
  KEY `FK_Reference_48` (`userId`),
  CONSTRAINT `FK_Reference_48` FOREIGN KEY (`userId`) REFERENCES `tuser` (`userId`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='评价人表';

-- ----------------------------
-- Records of tevaluater
-- ----------------------------
INSERT INTO `tevaluater` VALUES ('1', '4', '4', '3', 'success');
INSERT INTO `tevaluater` VALUES ('2', '16', '4', '3', 'fail');
INSERT INTO `tevaluater` VALUES ('3', '5', '4', '3', 'fail');
INSERT INTO `tevaluater` VALUES ('4', '3', '4', '3', 'success');
INSERT INTO `tevaluater` VALUES ('5', '13', '4', '4', 'fail');
INSERT INTO `tevaluater` VALUES ('6', '13', '4', '4', 'fail');
INSERT INTO `tevaluater` VALUES ('7', '3', '4', '4', 'fail');
INSERT INTO `tevaluater` VALUES ('8', '4', '4', '4', 'fail');
INSERT INTO `tevaluater` VALUES ('9', '12', '4', '5', 'fail');
INSERT INTO `tevaluater` VALUES ('10', '12', '4', '5', 'fail');
INSERT INTO `tevaluater` VALUES ('11', '14', '4', '5', 'fail');
INSERT INTO `tevaluater` VALUES ('12', '5', '4', '5', 'fail');
INSERT INTO `tevaluater` VALUES ('13', '11', '4', '6', 'fail');
INSERT INTO `tevaluater` VALUES ('14', '16', '4', '6', 'fail');
INSERT INTO `tevaluater` VALUES ('15', '5', '4', '6', 'fail');
INSERT INTO `tevaluater` VALUES ('16', '6', '4', '6', 'fail');
INSERT INTO `tevaluater` VALUES ('17', '3', '4', '7', 'fail');
INSERT INTO `tevaluater` VALUES ('18', '8', '4', '7', 'fail');
INSERT INTO `tevaluater` VALUES ('19', '14', '4', '7', 'fail');
INSERT INTO `tevaluater` VALUES ('20', '7', '4', '7', 'fail');
INSERT INTO `tevaluater` VALUES ('21', '14', '4', '8', 'fail');
INSERT INTO `tevaluater` VALUES ('22', '5', '4', '8', 'fail');
INSERT INTO `tevaluater` VALUES ('23', '7', '4', '8', 'fail');
INSERT INTO `tevaluater` VALUES ('24', '8', '4', '8', 'fail');
INSERT INTO `tevaluater` VALUES ('25', '7', '4', '9', 'fail');
INSERT INTO `tevaluater` VALUES ('26', '6', '4', '9', 'fail');
INSERT INTO `tevaluater` VALUES ('27', '13', '4', '9', 'fail');
INSERT INTO `tevaluater` VALUES ('28', '9', '4', '9', 'fail');
INSERT INTO `tevaluater` VALUES ('29', '7', '4', '11', 'fail');
INSERT INTO `tevaluater` VALUES ('30', '4', '4', '11', 'fail');
INSERT INTO `tevaluater` VALUES ('31', '15', '4', '11', 'fail');
INSERT INTO `tevaluater` VALUES ('32', '11', '4', '11', 'fail');
INSERT INTO `tevaluater` VALUES ('33', '16', '4', '12', 'fail');
INSERT INTO `tevaluater` VALUES ('34', '4', '4', '12', 'fail');
INSERT INTO `tevaluater` VALUES ('35', '6', '4', '12', 'fail');
INSERT INTO `tevaluater` VALUES ('36', '12', '4', '12', 'fail');
INSERT INTO `tevaluater` VALUES ('37', '6', '4', '13', 'fail');
INSERT INTO `tevaluater` VALUES ('38', '12', '4', '13', 'fail');
INSERT INTO `tevaluater` VALUES ('39', '3', '4', '13', 'fail');
INSERT INTO `tevaluater` VALUES ('40', '13', '4', '13', 'fail');
INSERT INTO `tevaluater` VALUES ('41', '11', '4', '14', 'fail');
INSERT INTO `tevaluater` VALUES ('42', '8', '4', '14', 'fail');
INSERT INTO `tevaluater` VALUES ('43', '9', '4', '14', 'fail');
INSERT INTO `tevaluater` VALUES ('44', '14', '4', '14', 'fail');
INSERT INTO `tevaluater` VALUES ('45', '11', '4', '15', 'fail');
INSERT INTO `tevaluater` VALUES ('46', '9', '4', '15', 'fail');
INSERT INTO `tevaluater` VALUES ('47', '9', '4', '15', 'fail');
INSERT INTO `tevaluater` VALUES ('48', '15', '4', '15', 'fail');
INSERT INTO `tevaluater` VALUES ('49', '15', '4', '16', 'fail');
INSERT INTO `tevaluater` VALUES ('50', '8', '4', '16', 'fail');
INSERT INTO `tevaluater` VALUES ('51', '15', '4', '16', 'fail');
INSERT INTO `tevaluater` VALUES ('52', '16', '4', '16', 'fail');
INSERT INTO `tevaluater` VALUES ('53', '3', '1', '16', 'success');
INSERT INTO `tevaluater` VALUES ('54', '3', '2', '16', 'success');
INSERT INTO `tevaluater` VALUES ('55', '3', '3', '16', 'success');

-- ----------------------------
-- Table structure for texctar
-- ----------------------------
DROP TABLE IF EXISTS `texctar`;
CREATE TABLE `texctar` (
  `excTarId` bigint(20) NOT NULL AUTO_INCREMENT,
  `eproLea` varchar(100) DEFAULT '' COMMENT '专业学习',
  `enonProLea` varchar(100) DEFAULT '' COMMENT '非专业学习',
  `eextraLearn` varchar(100) DEFAULT '' COMMENT '课外学习',
  `ephyHealth` varchar(100) DEFAULT '' COMMENT '身体健康',
  `ementalHealth` varchar(100) DEFAULT '' COMMENT '心理健康',
  `emanageMoney` varchar(100) DEFAULT '' COMMENT '理财',
  `einterpersonal` varchar(100) DEFAULT '' COMMENT '人际沟通',
  `eclubEvent` varchar(100) DEFAULT '' COMMENT '社团部门',
  `esocialEvent` varchar(100) DEFAULT '' COMMENT '社会',
  `submit` varchar(10) DEFAULT 'fail' COMMENT '提交 标识符',
  PRIMARY KEY (`excTarId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='预期学期规划';

-- ----------------------------
-- Records of texctar
-- ----------------------------
INSERT INTO `texctar` VALUES ('1', '这是我的专业学习', '这是我的非专业学习', '这是我的非专业学习', '这是我的非专业学习', '这是我的非专业学习', '这是我的非专业学习', '这是我的人际沟通', '这是我的非专业学习', '这是我的非专业学习', 'success');
INSERT INTO `texctar` VALUES ('2', '这是我的专业学习', '这是我的非专业学习', '这是我的课外学习', '这是我的身体健康', '这是我的心理健康情况', '这是我的理财情况', '这是我的人际沟通', '这是我的部门情况', '这是我的社会实践', 'success');
INSERT INTO `texctar` VALUES ('3', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `texctar` VALUES ('4', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `texctar` VALUES ('5', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `texctar` VALUES ('6', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `texctar` VALUES ('7', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `texctar` VALUES ('8', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `texctar` VALUES ('9', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `texctar` VALUES ('10', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `texctar` VALUES ('11', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `texctar` VALUES ('12', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `texctar` VALUES ('13', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `texctar` VALUES ('14', '这是我的专业学习', '这是我的非专业学习', '这是我的课外学习', '这是我的身体健康', '这是我的心理健康情况', '这是我的理财情况', '这是我的人际沟通', '这是我的部门情况', '这是我的社会实践', 'success');
INSERT INTO `texctar` VALUES ('15', '这是我的专业学习', '这是我的非专业学习', '这是我的课外学习', '这是我的身体健康', '这是我的心理健康情况', '这是我的理财情况', '这是我的人际沟通', '这是我的部门情况', '这是我的社会实践', 'success');
INSERT INTO `texctar` VALUES ('16', '这是我的专业学习', '这是我的非专业学习', '这是我的课外学习', '这是我的身体健康', '这是我的心理健康情况', '这是我的理财情况', '这是我的人际沟通', '这是我的部门情况', '这是我的社会实践', 'success');

-- ----------------------------
-- Table structure for tfile
-- ----------------------------
DROP TABLE IF EXISTS `tfile`;
CREATE TABLE `tfile` (
  `fileId` bigint(20) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(64) DEFAULT NULL COMMENT '文件名',
  `fileUrl` varchar(100) DEFAULT NULL COMMENT '文件url',
  `fileComent` varchar(20) DEFAULT NULL COMMENT '文件说明',
  PRIMARY KEY (`fileId`),
  UNIQUE KEY `AK_Key_2` (`fileUrl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件表';

-- ----------------------------
-- Records of tfile
-- ----------------------------

-- ----------------------------
-- Table structure for tfilepermi
-- ----------------------------
DROP TABLE IF EXISTS `tfilepermi`;
CREATE TABLE `tfilepermi` (
  `permFileId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文件权限id',
  `permiId` bigint(20) DEFAULT NULL COMMENT '权限id',
  `fileId` bigint(20) DEFAULT NULL COMMENT '文件id',
  PRIMARY KEY (`permFileId`),
  KEY `FK_Reference_32` (`permiId`),
  KEY `FK_Reference_37` (`fileId`),
  CONSTRAINT `FK_Reference_32` FOREIGN KEY (`permiId`) REFERENCES `tpermission` (`permiId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_37` FOREIGN KEY (`fileId`) REFERENCES `tfile` (`fileId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件权限表';

-- ----------------------------
-- Records of tfilepermi
-- ----------------------------

-- ----------------------------
-- Table structure for tgroup
-- ----------------------------
DROP TABLE IF EXISTS `tgroup`;
CREATE TABLE `tgroup` (
  `groupId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户组id',
  `groupName` varchar(10) DEFAULT NULL COMMENT '组名',
  `groupCom` varchar(10) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组';

-- ----------------------------
-- Records of tgroup
-- ----------------------------

-- ----------------------------
-- Table structure for tinfo
-- ----------------------------
DROP TABLE IF EXISTS `tinfo`;
CREATE TABLE `tinfo` (
  `infoId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` bigint(11) DEFAULT NULL,
  `telphone` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`infoId`),
  KEY `FK_userinfo_1` (`userId`),
  CONSTRAINT `FK_userinfo_1` FOREIGN KEY (`userId`) REFERENCES `tuser` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tinfo
-- ----------------------------
INSERT INTO `tinfo` VALUES ('1', '1', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('2', '2', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('3', '3', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('4', '4', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('5', '5', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('6', '6', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('7', '7', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('8', '8', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('9', '9', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('10', '10', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('11', '11', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('12', '12', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('13', '13', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('14', '14', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('15', '15', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('16', '16', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('17', '17', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('18', '18', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('19', '19', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');
INSERT INTO `tinfo` VALUES ('20', '20', '15779604138', '635727914', '635727914@qq.com', '1996-05-02');

-- ----------------------------
-- Table structure for tjobass
-- ----------------------------
DROP TABLE IF EXISTS `tjobass`;
CREATE TABLE `tjobass` (
  `jobAssId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL COMMENT '用户主键',
  `employSituation` varchar(256) DEFAULT '' COMMENT '就业形势',
  `qualifications` varchar(128) DEFAULT '' COMMENT '素质要求',
  `knowledge` varchar(128) DEFAULT '' COMMENT '知识要求',
  `skills` varchar(128) DEFAULT '' COMMENT '技能要求',
  `credentials` varchar(128) DEFAULT '' COMMENT '证书要求',
  `income` varchar(128) DEFAULT '' COMMENT '收入状况',
  `prospects` varchar(256) DEFAULT '' COMMENT '职业前景',
  `Suggest` varchar(256) DEFAULT '' COMMENT '对学校的建议，比如增加哪些课，教学等等',
  `submit` varchar(10) DEFAULT 'fail' COMMENT '确认提交标识符，1 表示提交 ，0表示未提交',
  PRIMARY KEY (`jobAssId`),
  KEY `FK_Reference_22` (`userId`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`userId`) REFERENCES `tuser` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='职业评价';

-- ----------------------------
-- Records of tjobass
-- ----------------------------
INSERT INTO `tjobass` VALUES ('1', '3', '这是我的就业形势', '这是我的就业形势', '这是我的就业形势', '这是我的就业形势', '这是我的就业形势', '这是我的就业形势', '这是我的就业形势', '这是我的就业形势', 'success');
INSERT INTO `tjobass` VALUES ('2', '4', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tjobass` VALUES ('3', '5', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tjobass` VALUES ('4', '6', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tjobass` VALUES ('5', '7', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tjobass` VALUES ('6', '8', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tjobass` VALUES ('7', '9', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tjobass` VALUES ('8', '11', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tjobass` VALUES ('9', '12', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tjobass` VALUES ('10', '13', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tjobass` VALUES ('11', '14', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tjobass` VALUES ('12', '15', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tjobass` VALUES ('13', '16', '', '', '', '', '', '', '', '', 'fail');

-- ----------------------------
-- Table structure for tmenu
-- ----------------------------
DROP TABLE IF EXISTS `tmenu`;
CREATE TABLE `tmenu` (
  `menuId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menuName` varchar(64) DEFAULT NULL COMMENT '菜单名',
  `menuUrl` varchar(64) DEFAULT NULL COMMENT '菜单url',
  `parentId` bigint(20) DEFAULT NULL COMMENT '父菜单id',
  `menuComment` varchar(64) DEFAULT NULL COMMENT '菜单说明',
  PRIMARY KEY (`menuId`),
  UNIQUE KEY `AK_Key_2` (`menuUrl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of tmenu
-- ----------------------------

-- ----------------------------
-- Table structure for tmenupermi
-- ----------------------------
DROP TABLE IF EXISTS `tmenupermi`;
CREATE TABLE `tmenupermi` (
  `menuPermiId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单权限',
  `permiId` bigint(20) DEFAULT NULL COMMENT '权限id',
  `menuId` bigint(20) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`menuPermiId`),
  KEY `FK_Reference_33` (`permiId`),
  KEY `FK_Reference_35` (`menuId`),
  CONSTRAINT `FK_Reference_33` FOREIGN KEY (`permiId`) REFERENCES `tpermission` (`permiId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_35` FOREIGN KEY (`menuId`) REFERENCES `tmenu` (`menuId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单权限';

-- ----------------------------
-- Records of tmenupermi
-- ----------------------------

-- ----------------------------
-- Table structure for topeneva
-- ----------------------------
DROP TABLE IF EXISTS `topeneva`;
CREATE TABLE `topeneva` (
  `openEvaId` int(11) NOT NULL AUTO_INCREMENT,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `falg` varchar(10) DEFAULT 'fail' COMMENT '标志',
  `unitId` int(11) DEFAULT NULL,
  `termNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`openEvaId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topeneva
-- ----------------------------
INSERT INTO `topeneva` VALUES ('1', null, null, 'success', '5', '4');

-- ----------------------------
-- Table structure for topentar
-- ----------------------------
DROP TABLE IF EXISTS `topentar`;
CREATE TABLE `topentar` (
  `openTarId` int(11) NOT NULL AUTO_INCREMENT,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `flag` varchar(255) DEFAULT 'fail',
  `unitId` int(11) DEFAULT NULL,
  `termNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`openTarId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topentar
-- ----------------------------
INSERT INTO `topentar` VALUES ('1', null, null, 'success', '5', '4');

-- ----------------------------
-- Table structure for topentime
-- ----------------------------
DROP TABLE IF EXISTS `topentime`;
CREATE TABLE `topentime` (
  `openTimeId` int(11) NOT NULL AUTO_INCREMENT,
  `startData` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `tableName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`openTimeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topentime
-- ----------------------------

-- ----------------------------
-- Table structure for toperapermi
-- ----------------------------
DROP TABLE IF EXISTS `toperapermi`;
CREATE TABLE `toperapermi` (
  `operaPermiId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '操作权限id',
  `operateId` bigint(20) DEFAULT NULL COMMENT '操作id',
  `permiId` bigint(20) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`operaPermiId`),
  KEY `FK_Reference_38` (`operateId`),
  KEY `FK_Reference_39` (`permiId`),
  CONSTRAINT `FK_Reference_38` FOREIGN KEY (`operateId`) REFERENCES `toperate` (`operateId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_39` FOREIGN KEY (`permiId`) REFERENCES `tpermission` (`permiId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作权限';

-- ----------------------------
-- Records of toperapermi
-- ----------------------------

-- ----------------------------
-- Table structure for toperate
-- ----------------------------
DROP TABLE IF EXISTS `toperate`;
CREATE TABLE `toperate` (
  `operateId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '操作id',
  `operateName` varchar(10) DEFAULT NULL COMMENT '操作名',
  PRIMARY KEY (`operateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作表';

-- ----------------------------
-- Records of toperate
-- ----------------------------

-- ----------------------------
-- Table structure for tpage
-- ----------------------------
DROP TABLE IF EXISTS `tpage`;
CREATE TABLE `tpage` (
  `pageId` bigint(20) NOT NULL AUTO_INCREMENT,
  `pafeName` varchar(100) DEFAULT NULL,
  `pageUrl` varchar(100) DEFAULT NULL,
  `pageComment` varchar(20) DEFAULT NULL COMMENT '页面说明',
  PRIMARY KEY (`pageId`),
  UNIQUE KEY `AK_Key_2` (`pageUrl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='页面表';

-- ----------------------------
-- Records of tpage
-- ----------------------------

-- ----------------------------
-- Table structure for tpagepermi
-- ----------------------------
DROP TABLE IF EXISTS `tpagepermi`;
CREATE TABLE `tpagepermi` (
  `pagePermiid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '页面权限id',
  `permiId` bigint(20) DEFAULT NULL COMMENT '权限id',
  `pageId` bigint(20) DEFAULT NULL COMMENT '页面id',
  PRIMARY KEY (`pagePermiid`),
  KEY `FK_Reference_34` (`permiId`),
  KEY `FK_Reference_36` (`pageId`),
  CONSTRAINT `FK_Reference_34` FOREIGN KEY (`permiId`) REFERENCES `tpermission` (`permiId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_36` FOREIGN KEY (`pageId`) REFERENCES `tpage` (`pageId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='页面权限表';

-- ----------------------------
-- Records of tpagepermi
-- ----------------------------

-- ----------------------------
-- Table structure for tpermission
-- ----------------------------
DROP TABLE IF EXISTS `tpermission`;
CREATE TABLE `tpermission` (
  `permiId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `permiName` varchar(20) DEFAULT NULL COMMENT '权限名',
  `permiCom` varchar(20) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`permiId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of tpermission
-- ----------------------------

-- ----------------------------
-- Table structure for treatar
-- ----------------------------
DROP TABLE IF EXISTS `treatar`;
CREATE TABLE `treatar` (
  `reaTarId` bigint(20) NOT NULL AUTO_INCREMENT,
  `rproLea` varchar(100) DEFAULT '' COMMENT '专业学习',
  `rnonProLea` varchar(100) DEFAULT '' COMMENT '非专业学习',
  `rextraLearn` varchar(100) DEFAULT '' COMMENT '课外学习',
  `rphyHealth` varchar(100) DEFAULT '' COMMENT '身体健康',
  `rmentalHealth` varchar(100) DEFAULT '' COMMENT '心理健康',
  `rmanageMoney` varchar(100) DEFAULT '' COMMENT '理财',
  `rinterpersonal` varchar(100) DEFAULT '' COMMENT '人际沟通',
  `rclubEvent` varchar(100) DEFAULT '' COMMENT '社团部门',
  `rsocialEvent` varchar(100) DEFAULT '' COMMENT '社会',
  `submit` varchar(10) DEFAULT 'fail' COMMENT '提交标识符',
  PRIMARY KEY (`reaTarId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='实际情况';

-- ----------------------------
-- Records of treatar
-- ----------------------------
INSERT INTO `treatar` VALUES ('1', '这是我的实际就业学习情况', '这是我的非专业学习', '这是我的非专业学习', '这是我的非专业学习', '这是我的非专业学习', '这是我的非专业学习', '这是我的非专业学习', '这是我的非专业学习', '这是我的非专业学习', 'success');
INSERT INTO `treatar` VALUES ('2', '这是我的实际专业学习', '这是我的实际非专业学习', '这是我的实际课外学习', '这是我的实际身体健康', '这是我的实际心理健康情况', '这是我的实际理财情况', '这是我的实际人际沟通', '这是我的实际部门情况', '这是我的实际社会实践', 'success');
INSERT INTO `treatar` VALUES ('3', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `treatar` VALUES ('4', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `treatar` VALUES ('5', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `treatar` VALUES ('6', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `treatar` VALUES ('7', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `treatar` VALUES ('8', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `treatar` VALUES ('9', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `treatar` VALUES ('10', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `treatar` VALUES ('11', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `treatar` VALUES ('12', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `treatar` VALUES ('13', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `treatar` VALUES ('14', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `treatar` VALUES ('15', '', '', '', '', '', '', '', '', '', 'fail');
INSERT INTO `treatar` VALUES ('16', '', '', '', '', '', '', '', '', '', 'fail');

-- ----------------------------
-- Table structure for trole
-- ----------------------------
DROP TABLE IF EXISTS `trole`;
CREATE TABLE `trole` (
  `roleId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动增长',
  `roleName` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '角色名,学生，毕业生，班主任，班助，系统管理员，研究院',
  `roleCom` varchar(20) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of trole
-- ----------------------------
INSERT INTO `trole` VALUES ('1', 'student', '学生');
INSERT INTO `trole` VALUES ('2', 'teacher', '教师');
INSERT INTO `trole` VALUES ('3', 'admin', '管理员');

-- ----------------------------
-- Table structure for trolegroup
-- ----------------------------
DROP TABLE IF EXISTS `trolegroup`;
CREATE TABLE `trolegroup` (
  `roleGroupId` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL COMMENT '用户组id',
  `roleId` bigint(20) DEFAULT NULL COMMENT '自动增长',
  PRIMARY KEY (`roleGroupId`),
  KEY `FK_Reference_43` (`groupId`),
  KEY `FK_Reference_44` (`roleId`),
  CONSTRAINT `FK_Reference_43` FOREIGN KEY (`groupId`) REFERENCES `tgroup` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_44` FOREIGN KEY (`roleId`) REFERENCES `trole` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色组';

-- ----------------------------
-- Records of trolegroup
-- ----------------------------

-- ----------------------------
-- Table structure for trolepermi
-- ----------------------------
DROP TABLE IF EXISTS `trolepermi`;
CREATE TABLE `trolepermi` (
  `rolePermiId` bigint(20) NOT NULL,
  `permiId` bigint(20) DEFAULT NULL COMMENT '权限id',
  `roleId` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`rolePermiId`),
  KEY `FK_Reference_40` (`permiId`),
  KEY `FK_Reference_41` (`roleId`),
  CONSTRAINT `FK_Reference_40` FOREIGN KEY (`permiId`) REFERENCES `tpermission` (`permiId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_41` FOREIGN KEY (`roleId`) REFERENCES `trole` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of trolepermi
-- ----------------------------

-- ----------------------------
-- Table structure for tschool
-- ----------------------------
DROP TABLE IF EXISTS `tschool`;
CREATE TABLE `tschool` (
  `schoolId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学校id',
  `schoolName` varchar(64) DEFAULT NULL COMMENT '学校名',
  `schoolNumber` varchar(32) DEFAULT NULL COMMENT '学校代码',
  PRIMARY KEY (`schoolId`),
  UNIQUE KEY `AK_Key_2` (`schoolNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='学校表';

-- ----------------------------
-- Records of tschool
-- ----------------------------
INSERT INTO `tschool` VALUES ('1', '江西财经大学', 'jxufe');

-- ----------------------------
-- Table structure for tselass
-- ----------------------------
DROP TABLE IF EXISTS `tselass`;
CREATE TABLE `tselass` (
  `selAssId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL COMMENT '用户主键',
  `chater` varchar(256) DEFAULT '' COMMENT '性格',
  `speciality` varchar(256) DEFAULT '' COMMENT '特长',
  `interest` varchar(256) DEFAULT '' COMMENT '兴趣',
  `emotionSituation` varchar(256) DEFAULT '' COMMENT '情绪状况，能否控制情绪',
  `willpower` varchar(256) DEFAULT '' COMMENT '意志力状况',
  `english` varchar(128) DEFAULT '' COMMENT '外语水平',
  `computer` varchar(128) DEFAULT '' COMMENT '计算机水平',
  `submit` varchar(10) DEFAULT 'fail' COMMENT '提交确认符 success 表示提交 fail 表示未提交',
  PRIMARY KEY (`selAssId`),
  KEY `FK_Reference_25` (`userId`),
  CONSTRAINT `FK_Reference_25` FOREIGN KEY (`userId`) REFERENCES `tuser` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='自我评价表';

-- ----------------------------
-- Records of tselass
-- ----------------------------
INSERT INTO `tselass` VALUES ('1', '3', '我的性格阳光，善于交谈', '我的性格阳光，善于交谈', '我的性格阳光，善于交谈', '我的性格阳光，善于交谈', '我的性格阳光，善于交谈', '我的性格阳光，善于交谈', '我的性格阳光，善于交谈', 'success');
INSERT INTO `tselass` VALUES ('2', '4', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tselass` VALUES ('3', '5', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tselass` VALUES ('4', '6', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tselass` VALUES ('5', '7', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tselass` VALUES ('6', '8', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tselass` VALUES ('7', '9', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tselass` VALUES ('8', '11', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tselass` VALUES ('9', '12', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tselass` VALUES ('10', '13', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tselass` VALUES ('11', '14', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tselass` VALUES ('12', '15', '', '', '', '', '', '', '', 'fail');
INSERT INTO `tselass` VALUES ('13', '16', '', '', '', '', '', '', '', 'fail');

-- ----------------------------
-- Table structure for tunit
-- ----------------------------
DROP TABLE IF EXISTS `tunit`;
CREATE TABLE `tunit` (
  `unitId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '单位id',
  `departId` bigint(20) DEFAULT NULL COMMENT '部门id',
  `unitName` varchar(64) DEFAULT NULL COMMENT '单位名',
  `unitNumber` varchar(64) DEFAULT NULL COMMENT '单位代码',
  PRIMARY KEY (`unitId`),
  KEY `FK_Reference_29` (`departId`),
  CONSTRAINT `FK_Reference_29` FOREIGN KEY (`departId`) REFERENCES `tdepart` (`departId`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='单位，如软件工程145班';

-- ----------------------------
-- Records of tunit
-- ----------------------------
INSERT INTO `tunit` VALUES ('1', '1', '软件141班', null);
INSERT INTO `tunit` VALUES ('2', '1', '软件142班', null);
INSERT INTO `tunit` VALUES ('3', '1', '软件143班', null);
INSERT INTO `tunit` VALUES ('4', '1', '软件144班', null);
INSERT INTO `tunit` VALUES ('5', '1', '软件145班', null);
INSERT INTO `tunit` VALUES ('6', '1', '软件146班', null);
INSERT INTO `tunit` VALUES ('7', '1', '软件136班', null);

-- ----------------------------
-- Table structure for tuser
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `unitId` bigint(20) DEFAULT NULL,
  `userNum` varchar(7) DEFAULT NULL COMMENT '用户号',
  `userName` varchar(10) DEFAULT NULL COMMENT '姓名',
  `code` varchar(16) DEFAULT '123' COMMENT '密码',
  `year` int(11) DEFAULT NULL COMMENT '单位年份',
  `createRole` varchar(10) DEFAULT NULL COMMENT '创建角色，与角色表关联，联级操作',
  `createDate` date DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `AK_unique_userNum` (`userNum`),
  KEY `FK_Reference_27` (`unitId`),
  CONSTRAINT `FK_Reference_27` FOREIGN KEY (`unitId`) REFERENCES `tunit` (`unitId`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('1', '5', '6144206', '曾传东', '123456', '2014', '', '2016-04-04');
INSERT INTO `tuser` VALUES ('2', '5', '1144206', '曾传东', '123456', '2014', '6144206', '2016-04-04');
INSERT INTO `tuser` VALUES ('3', '5', '0144206', '曾传东', '123456', '2014', '1144206', '2016-04-04');
INSERT INTO `tuser` VALUES ('4', '5', '0144162', '陈梓华', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('5', '5', '0144170', '梁宇鸿', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('6', '5', '0144175', '王弘华', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('7', '5', '0144186', '曹欣聪', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('8', '5', '0144195', '丁筱芸', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('9', '5', '0144178', '陈高升', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('10', '5', '0144208', '袁福', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('11', '5', '0144197', '胡坤琳', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('12', '5', '0144200', '曽令勇', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('13', '5', '0144187', '刘蓉奇', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('14', '5', '0144207', '曾文彬', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('15', '5', '0144185', '周谦', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('16', '5', '0144190', '陈键伟', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('17', '6', '1144001', '王五', '123456', '2014', '6144206', '2016-04-04');
INSERT INTO `tuser` VALUES ('18', '6', '0144220', '杨荣', '123456', '2014', '1144206', '2016-05-05');
INSERT INTO `tuser` VALUES ('19', '7', '1134206', '李四', '123456', '2013', '6144206', '2016-04-04');
INSERT INTO `tuser` VALUES ('20', '7', '0133220', '张三', '123456', '2013', '1144206', '2016-05-05');

-- ----------------------------
-- Table structure for tusereva
-- ----------------------------
DROP TABLE IF EXISTS `tusereva`;
CREATE TABLE `tusereva` (
  `userEvaId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL COMMENT '用户主键',
  `evaluateId` bigint(20) DEFAULT NULL,
  `termNum` bigint(20) DEFAULT NULL COMMENT '学期号1，2，3，4，5，6，7，8',
  PRIMARY KEY (`userEvaId`),
  KEY `FK_Reference_26` (`userId`),
  KEY `FK_Reference_47` (`evaluateId`),
  CONSTRAINT `FK_Reference_47` FOREIGN KEY (`evaluateId`) REFERENCES `tevaluate` (`evaluateId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户_评价分数表';

-- ----------------------------
-- Records of tusereva
-- ----------------------------

-- ----------------------------
-- Table structure for tuserexctar
-- ----------------------------
DROP TABLE IF EXISTS `tuserexctar`;
CREATE TABLE `tuserexctar` (
  `userExcTarId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL COMMENT '用户主键',
  `excTarId` bigint(20) DEFAULT NULL COMMENT '预期目标id',
  `termNum` bigint(20) DEFAULT NULL COMMENT '学期号1，2，3，4，5，6，7，8',
  PRIMARY KEY (`userExcTarId`),
  KEY `FK_Reference_23` (`userId`),
  KEY `FK_Reference_45` (`excTarId`),
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`userId`) REFERENCES `tuser` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_45` FOREIGN KEY (`excTarId`) REFERENCES `texctar` (`excTarId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='用户预期目标';

-- ----------------------------
-- Records of tuserexctar
-- ----------------------------
INSERT INTO `tuserexctar` VALUES ('1', '3', '1', '4');
INSERT INTO `tuserexctar` VALUES ('2', '4', '2', '4');
INSERT INTO `tuserexctar` VALUES ('3', '5', '3', '4');
INSERT INTO `tuserexctar` VALUES ('4', '6', '4', '4');
INSERT INTO `tuserexctar` VALUES ('5', '7', '5', '4');
INSERT INTO `tuserexctar` VALUES ('6', '8', '6', '4');
INSERT INTO `tuserexctar` VALUES ('7', '9', '7', '4');
INSERT INTO `tuserexctar` VALUES ('8', '11', '8', '4');
INSERT INTO `tuserexctar` VALUES ('9', '12', '9', '4');
INSERT INTO `tuserexctar` VALUES ('10', '13', '10', '4');
INSERT INTO `tuserexctar` VALUES ('11', '14', '11', '4');
INSERT INTO `tuserexctar` VALUES ('12', '15', '12', '4');
INSERT INTO `tuserexctar` VALUES ('13', '16', '13', '4');
INSERT INTO `tuserexctar` VALUES ('14', '3', '14', '1');
INSERT INTO `tuserexctar` VALUES ('15', '3', '15', '2');
INSERT INTO `tuserexctar` VALUES ('16', '3', '16', '3');

-- ----------------------------
-- Table structure for tusergroup
-- ----------------------------
DROP TABLE IF EXISTS `tusergroup`;
CREATE TABLE `tusergroup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL COMMENT '用户主键',
  `groupId` bigint(20) DEFAULT NULL COMMENT '用户组id',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_21` (`userId`),
  KEY `FK_Reference_42` (`groupId`),
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`userId`) REFERENCES `tuser` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_42` FOREIGN KEY (`groupId`) REFERENCES `tgroup` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户_组';

-- ----------------------------
-- Records of tusergroup
-- ----------------------------

-- ----------------------------
-- Table structure for tuserreatar
-- ----------------------------
DROP TABLE IF EXISTS `tuserreatar`;
CREATE TABLE `tuserreatar` (
  `userReaTarId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL COMMENT '用户主键',
  `reaTarId` bigint(20) DEFAULT NULL COMMENT '真实情况id',
  `termNum` bigint(20) DEFAULT NULL COMMENT '学期号1，2，3，4，5，6，7，8',
  PRIMARY KEY (`userReaTarId`),
  KEY `FK_Reference_24` (`userId`),
  KEY `FK_Reference_46` (`reaTarId`),
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`userId`) REFERENCES `tuser` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_46` FOREIGN KEY (`reaTarId`) REFERENCES `treatar` (`reaTarId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='用户_真实情况表';

-- ----------------------------
-- Records of tuserreatar
-- ----------------------------
INSERT INTO `tuserreatar` VALUES ('1', '3', '1', '4');
INSERT INTO `tuserreatar` VALUES ('2', '4', '2', '4');
INSERT INTO `tuserreatar` VALUES ('3', '5', '3', '4');
INSERT INTO `tuserreatar` VALUES ('4', '6', '4', '4');
INSERT INTO `tuserreatar` VALUES ('5', '7', '5', '4');
INSERT INTO `tuserreatar` VALUES ('6', '8', '6', '4');
INSERT INTO `tuserreatar` VALUES ('7', '9', '7', '4');
INSERT INTO `tuserreatar` VALUES ('8', '11', '8', '4');
INSERT INTO `tuserreatar` VALUES ('9', '12', '9', '4');
INSERT INTO `tuserreatar` VALUES ('10', '13', '10', '4');
INSERT INTO `tuserreatar` VALUES ('11', '14', '11', '4');
INSERT INTO `tuserreatar` VALUES ('12', '15', '12', '4');
INSERT INTO `tuserreatar` VALUES ('13', '16', '13', '4');
INSERT INTO `tuserreatar` VALUES ('14', '3', '14', '1');
INSERT INTO `tuserreatar` VALUES ('15', '3', '15', '2');
INSERT INTO `tuserreatar` VALUES ('16', '3', '16', '3');

-- ----------------------------
-- Table structure for tuserrole
-- ----------------------------
DROP TABLE IF EXISTS `tuserrole`;
CREATE TABLE `tuserrole` (
  `userRoleId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL COMMENT '用户主键',
  `roleId` bigint(20) DEFAULT NULL COMMENT '自动增长',
  PRIMARY KEY (`userRoleId`),
  KEY `FK_Reference_28` (`userId`),
  KEY `FK_Reference_31` (`roleId`),
  CONSTRAINT `FK_Reference_28` FOREIGN KEY (`userId`) REFERENCES `tuser` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_31` FOREIGN KEY (`roleId`) REFERENCES `trole` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of tuserrole
-- ----------------------------
INSERT INTO `tuserrole` VALUES ('1', '1', '3');
INSERT INTO `tuserrole` VALUES ('2', '2', '2');
INSERT INTO `tuserrole` VALUES ('3', '3', '1');
INSERT INTO `tuserrole` VALUES ('4', '4', '1');
INSERT INTO `tuserrole` VALUES ('5', '5', '1');
INSERT INTO `tuserrole` VALUES ('6', '6', '1');
INSERT INTO `tuserrole` VALUES ('7', '7', '1');
INSERT INTO `tuserrole` VALUES ('8', '8', '1');
INSERT INTO `tuserrole` VALUES ('9', '9', '1');
INSERT INTO `tuserrole` VALUES ('10', '11', '1');
INSERT INTO `tuserrole` VALUES ('12', '12', '1');
INSERT INTO `tuserrole` VALUES ('13', '13', '1');
INSERT INTO `tuserrole` VALUES ('14', '14', '1');
INSERT INTO `tuserrole` VALUES ('15', '15', '1');
INSERT INTO `tuserrole` VALUES ('16', '16', '1');
INSERT INTO `tuserrole` VALUES ('17', '17', '2');
INSERT INTO `tuserrole` VALUES ('18', '18', '1');
INSERT INTO `tuserrole` VALUES ('19', '19', '2');
INSERT INTO `tuserrole` VALUES ('20', '20', '1');

-- ----------------------------
-- View structure for vavgeva
-- ----------------------------
DROP VIEW IF EXISTS `vavgeva`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vavgeva` AS select `tevaluate`.`evaluateId` AS `evaluateId`,`tevaluate`.`gproLea` AS `gproLea`,`tevaluate`.`gnonProLea` AS `gnonProLea`,`tevaluate`.`gextraLearn` AS `gextraLearn`,`tevaluate`.`gphyHealth` AS `gphyHealth`,`tevaluate`.`gmentalHealth` AS `gmentalHealth`,`tevaluate`.`gmanageMoney` AS `gmanageMoney`,`tevaluate`.`ginterpersonal` AS `ginterpersonal`,`tevaluate`.`gclubEvent` AS `gclubEvent`,`tevaluate`.`gsocialEvent` AS `gsocialEvent`,`tuser`.`userId` AS `userId`,`tuser`.`userNum` AS `userNum`,`tuser`.`userName` AS `userName`,`tevaluater`.`evauserId` AS `evauserId`,`tevaluater`.`termNum` AS `termNum`,`tuser`.`unitId` AS `unitId`,`tevaluate`.`submit` AS `submit` from ((`tuser` join `tevaluate`) join `tevaluater` on(((`tevaluater`.`userId` = `tuser`.`userId`) and (`tevaluate`.`eveluaterId` = `tevaluater`.`evaluaterId`)))) ;

-- ----------------------------
-- View structure for veva
-- ----------------------------
DROP VIEW IF EXISTS `veva`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `veva` AS select `tuser`.`userId` AS `userId`,`texctar`.`eproLea` AS `eproLea`,`texctar`.`enonProLea` AS `enonProLea`,`texctar`.`eextraLearn` AS `eextraLearn`,`texctar`.`ephyHealth` AS `ephyHealth`,`texctar`.`ementalHealth` AS `ementalHealth`,`texctar`.`emanageMoney` AS `emanageMoney`,`texctar`.`einterpersonal` AS `einterpersonal`,`texctar`.`eclubEvent` AS `eclubEvent`,`texctar`.`esocialEvent` AS `esocialEvent`,`treatar`.`rproLea` AS `rproLea`,`treatar`.`rnonProLea` AS `rnonProLea`,`treatar`.`rextraLearn` AS `rextraLearn`,`treatar`.`rphyHealth` AS `rphyHealth`,`treatar`.`rmentalHealth` AS `rmentalHealth`,`treatar`.`rmanageMoney` AS `rmanageMoney`,`treatar`.`rinterpersonal` AS `rinterpersonal`,`treatar`.`rclubEvent` AS `rclubEvent`,`treatar`.`rsocialEvent` AS `rsocialEvent`,`tuser`.`userNum` AS `userNum`,`tuser`.`userName` AS `userName`,`tuserreatar`.`termNum` AS `rtermNum`,`tuserexctar`.`termNum` AS `etermNum` from ((((`tuser` join `tuserexctar` on((`tuserexctar`.`userId` = `tuser`.`userId`))) join `texctar` on((`tuserexctar`.`excTarId` = `texctar`.`excTarId`))) join `tuserreatar` on((`tuserreatar`.`userId` = `tuser`.`userId`))) join `treatar` on((`tuserreatar`.`reaTarId` = `treatar`.`reaTarId`))) ;

-- ----------------------------
-- View structure for vinfo
-- ----------------------------
DROP VIEW IF EXISTS `vinfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vinfo` AS select `tuser`.`userNum` AS `userNum`,`tuser`.`userName` AS `userName`,`tunit`.`unitName` AS `unitName`,`tdepart`.`departName` AS `departName`,`tschool`.`schoolName` AS `schoolName`,`tinfo`.`qq` AS `qq`,`tinfo`.`telphone` AS `telphone`,`tinfo`.`email` AS `email`,`tinfo`.`birthday` AS `birthday`,`tunit`.`unitId` AS `unitId`,`trole`.`roleName` AS `roleName`,`tuser`.`userId` AS `userId` from ((((((`tuser` join `tunit` on((`tunit`.`unitId` = `tuser`.`unitId`))) join `tdepart` on((`tdepart`.`departId` = `tunit`.`departId`))) join `tschool` on((`tschool`.`schoolId` = `tdepart`.`schoolId`))) join `tinfo` on((`tinfo`.`userId` = `tuser`.`userId`))) join `tuserrole` on((`tuserrole`.`userId` = `tuser`.`userId`))) join `trole` on((`tuserrole`.`roleId` = `trole`.`roleId`))) ;

-- ----------------------------
-- View structure for vmutualeva
-- ----------------------------
DROP VIEW IF EXISTS `vmutualeva`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vmutualeva` AS select `tuser`.`userId` AS `userId`,`tuser`.`userNum` AS `userNum`,`tuser`.`userName` AS `userName`,`tevaluater`.`evaluaterId` AS `evaluaterId`,`tevaluater`.`termNum` AS `termNum` from (((`tuser` join `tevaluater` on((`tevaluater`.`userId` = `tuser`.`userId`))) join `tusereva` on((`tusereva`.`userId` = `tuser`.`userId`))) join `tevaluate` on(((`tevaluate`.`eveluaterId` = `tevaluater`.`evaluaterId`) and (`tusereva`.`evaluateId` = `tevaluate`.`evaluateId`)))) ;

-- ----------------------------
-- View structure for vrole
-- ----------------------------
DROP VIEW IF EXISTS `vrole`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vrole` AS select `tuser`.`userNum` AS `userNum`,`tuser`.`userName` AS `userName`,`trole`.`roleName` AS `roleName` from ((`tuser` join `tuserrole` on((`tuserrole`.`userId` = `tuser`.`userId`))) join `trole` on((`tuserrole`.`roleId` = `trole`.`roleId`))) ;

-- ----------------------------
-- View structure for vtar
-- ----------------------------
DROP VIEW IF EXISTS `vtar`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vtar` AS select `tuser`.`userNum` AS `userNum`,`tuser`.`userName` AS `userName`,`treatar`.`rproLea` AS `rproLea`,`treatar`.`rnonProLea` AS `rnonProLea`,`treatar`.`rextraLearn` AS `rextraLearn`,`treatar`.`rphyHealth` AS `rphyHealth`,`treatar`.`rmentalHealth` AS `rmentalHealth`,`treatar`.`rmanageMoney` AS `rmanageMoney`,`treatar`.`rinterpersonal` AS `rinterpersonal`,`treatar`.`rclubEvent` AS `rclubEvent`,`treatar`.`rsocialEvent` AS `rsocialEvent`,`texctar`.`eproLea` AS `eproLea`,`texctar`.`enonProLea` AS `enonProLea`,`texctar`.`eextraLearn` AS `eextraLearn`,`texctar`.`ephyHealth` AS `ephyHealth`,`texctar`.`ementalHealth` AS `ementalHealth`,`texctar`.`emanageMoney` AS `emanageMoney`,`texctar`.`einterpersonal` AS `einterpersonal`,`texctar`.`eclubEvent` AS `eclubEvent`,`texctar`.`esocialEvent` AS `esocialEvent`,`tuser`.`userId` AS `userId`,`tunit`.`unitId` AS `unitId`,`tunit`.`unitName` AS `unitName`,`tdepart`.`departName` AS `departName`,`tdepart`.`departId` AS `departId`,`tschool`.`schoolName` AS `schoolName`,`tschool`.`schoolId` AS `schoolId`,`tuserexctar`.`termNum` AS `termNum`,`tevaluate`.`evaluateId` AS `evaluateId`,`tevaluate`.`gproLea` AS `gproLea`,`tevaluate`.`gnonProLea` AS `gnonProLea`,`tevaluate`.`gextraLearn` AS `gextraLearn`,`tevaluate`.`gphyHealth` AS `gphyHealth`,`tevaluate`.`gmentalHealth` AS `gmentalHealth`,`tevaluate`.`gmanageMoney` AS `gmanageMoney`,`tevaluate`.`ginterpersonal` AS `ginterpersonal`,`tevaluate`.`gclubEvent` AS `gclubEvent`,`tevaluate`.`gsocialEvent` AS `gsocialEvent`,`tevaluate`.`eveluaterId` AS `eveluaterId` from (((((((((`tuser` join `tuserexctar` on((`tuserexctar`.`userId` = `tuser`.`userId`))) join `texctar` on((`tuserexctar`.`excTarId` = `texctar`.`excTarId`))) join `tuserreatar` on((`tuserreatar`.`userId` = `tuser`.`userId`))) join `treatar` on((`tuserreatar`.`reaTarId` = `treatar`.`reaTarId`))) join `tunit` on((`tuser`.`unitId` = `tunit`.`unitId`))) join `tdepart` on((`tunit`.`departId` = `tdepart`.`departId`))) join `tschool` on((`tdepart`.`schoolId` = `tschool`.`schoolId`))) join `tevaluate`) join `tevaluater` on((`tevaluater`.`userId` = `tuser`.`userId`))) where ((`tuserexctar`.`termNum` = `tuserreatar`.`termNum`) and (`tevaluater`.`evaluaterId` = `tevaluate`.`eveluaterId`)) ;
