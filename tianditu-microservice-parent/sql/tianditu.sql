/*创建关键点与统计数量表*/
CREATE TABLE `point_count` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(40) DEFAULT NULL COMMENT '编码',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `count_general_hospital` int(11) DEFAULT NULL COMMENT '辖区下的综合医院数量',
  `type` varchar(16) NOT NULL COMMENT '类型',
  `province_name` varchar(40) DEFAULT NULL COMMENT '省名称',
  `province_code` varchar(40) DEFAULT NULL COMMENT '省编码',
  `city_name` varchar(40) DEFAULT NULL COMMENT '市名称',
  `city_code` varchar(40) DEFAULT NULL COMMENT '市编码',
  `lat` decimal(10,6) DEFAULT NULL COMMENT '经度',
  `lon` decimal(10,6) DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3179 DEFAULT CHARSET=utf8;