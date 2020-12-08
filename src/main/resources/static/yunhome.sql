/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.16-log : Database - yunhome
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yunhome` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `yunhome`;

/*Table structure for table `h_district` */

DROP TABLE IF EXISTS `h_district`;

CREATE TABLE `h_district` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) DEFAULT NULL,
  `dis_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

/*Data for the table `h_district` */

insert  into `h_district`(`did`,`parentid`,`dis_name`) values (1,0,'武汉市'),(2,1,'江岸区'),(3,1,'江汉区'),(4,1,'硚口区'),(5,1,'东西湖区'),(6,1,'武昌区'),(7,1,'青山区'),(8,1,'洪山区'),(9,1,'汉阳区'),(10,1,'东湖高新区'),(11,1,'江夏区'),(12,1,'蔡甸区'),(13,2,'百步亭'),(14,2,'大智路'),(15,2,'堤角'),(16,2,'二七'),(17,2,'后湖'),(18,2,'黄埔路'),(19,2,'永清街'),(20,2,'前进路'),(21,2,'江汉路'),(22,2,'三阳路'),(23,2,'台北路'),(24,2,'香港路'),(25,2,'唐家墩'),(26,2,'花桥街'),(27,3,'宝丰路'),(28,3,'常青路'),(29,3,'西北湖'),(30,3,'长港路'),(31,3,'万松园'),(32,3,'新华路'),(33,3,'杨汊湖'),(34,4,'古田'),(35,4,'汉正街'),(36,4,'吴家山'),(37,4,'宗关'),(38,5,'金银滩 '),(39,5,'将军路'),(40,5,'常青花园'),(41,5,'白沙洲'),(42,6,'楚河汉街'),(43,6,'东湖'),(44,6,'东亭'),(45,6,'街道口'),(46,6,'积玉桥'),(47,6,'水果湖'),(48,6,'首义路'),(49,6,'沙湖'),(50,6,'团结大道'),(51,6,'武昌火车站'),(52,6,'徐东'),(53,6,'杨园'),(54,6,'中北路'),(55,6,'中南路'),(56,7,'红钢城'),(57,7,'建设一路'),(58,7,'建设二路'),(59,7,'建设三路'),(60,7,'建设四路'),(61,7,'建设五路'),(62,7,'建设七路'),(63,7,'建设十路'),(64,7,'白玉山'),(65,7,'武东路'),(66,7,'罗家路'),(67,7,'八大家'),(68,7,'奥山世纪城'),(69,8,'虎泉'),(70,8,'杨家湾'),(71,8,'珞狮南路'),(72,8,'珞狮北路'),(73,8,'南湖'),(74,8,'光谷'),(75,8,'广埠屯'),(76,9,'王家湾'),(77,9,'钟家村'),(78,9,'四新'),(79,10,'关山大道'),(80,10,'民族大道'),(81,10,'金融港'),(82,10,'华科大'),(83,10,'光谷南'),(84,10,'花城大道'),(85,10,'软件园'),(86,11,'藏龙岛'),(87,11,'庙山'),(88,11,'文化大道'),(89,12,'沌口');

/*Table structure for table `h_house` */

DROP TABLE IF EXISTS `h_house`;

CREATE TABLE `h_house` (
  `hid` int(11) NOT NULL AUTO_INCREMENT COMMENT '房屋id',
  `user_id` int(11) DEFAULT NULL COMMENT '房屋所属房东id',
  `district_id` int(11) DEFAULT NULL COMMENT '区域表id',
  `type_id` int(11) DEFAULT NULL COMMENT '类型表id',
  `price` double DEFAULT NULL COMMENT '价格',
  `areas` double DEFAULT NULL COMMENT '面积',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `mark` varchar(50) DEFAULT NULL COMMENT '标签',
  `equipment` varchar(100) DEFAULT NULL COMMENT '配备',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `imgs` varchar(200) DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `h_house` */

insert  into `h_house`(`hid`,`user_id`,`district_id`,`type_id`,`price`,`areas`,`title`,`mark`,`equipment`,`address`,`imgs`) values (1,1,2,1,500,56,'清江山水','湖景房','电视 冰箱 空调 洗衣机','武汉市江夏区软件园中路10号 清江山水1期16栋5楼501','/houseImg/1.jpg'),(2,1,78,2,800,78,'清江山水','湖景房','电视 冰箱 空调 洗衣机','武汉市江夏区软件园中路10号 清江山水1期15栋12楼1203','/houseImg/2.jpg'),(3,3,55,1,550,59,'清江山水','湖景房','电视 冰箱 空调 洗衣机','武汉市江夏区软件园中路10号 清江山水1期11栋5楼501','/houseImg/3.jpg'),(4,3,52,2,650,77,'清江山水','湖景房','电视 冰箱 空调 洗衣机','武汉市江夏区软件园中路10号 清江山水2期6栋5楼501','/houseImg/4.jpg'),(5,5,40,1,600,60,'清江山水','湖景房','电视 冰箱 空调 洗衣机','武汉市江夏区软件园中路10号 清江山水3期2栋1楼101','/houseImg/5.jpg'),(6,5,78,2,700,78,'清江山水','湖景房','电视 冰箱 空调 洗衣机','武汉市江夏区软件园中路10号 清江山水4期6栋6楼602','/houseImg/6.jpg'),(7,1,37,1,1000,50,'好房子','精装修','沙发 台球 ','吴家山 一号 4栋 ','/houseImg/7.jpg'),(8,1,34,1,900,60,'大房子','精装修','沙发 台球 ','吴家山 一号 4栋 ','/houseImg/8.jpg'),(9,3,36,2,100,78,'好房子','湖景房','沙发 台球 ','吴家山 一号 4栋 ','/houseImg/6.jpg'),(10,5,45,6,3000,150,'大房子','精装修','电脑 女仆','街道口 1号','/houseImg/4.jpg'),(11,5,13,6,3000,150,'大房子','精装修','电脑 女仆','街道口 1号','/houseImg/15.jpg'),(12,3,15,1,2500,70,'好房子','精装修','沙发 台球 ','吴家山 一号 4栋 ','/houseImg/9.jpg'),(13,1,19,2,1200,80,'好房子','精装修','沙发 台球 ','吴家山 一号 4栋 ','/houseImg/10.jpg'),(14,3,22,3,1300,90,'好房子','精装修','沙发 台球 ','吴家山 一号 4栋 ','/houseImg/11.jpg'),(15,1,25,4,500,100,'好房子','精装修','沙发 台球 ','吴家山 一号 4栋 ','/houseImg/12.jpg'),(16,3,28,6,600,110,'好房子','精装修','沙发 台球 ','吴家山 一号 4栋 ','/houseImg/13.jpg'),(17,1,36,5,700,120,'好房子','精装修','沙发 台球 ','吴家山 一号 4栋 ','/houseImg/14.jpg'),(18,3,35,1,800,130,'好房子','精装修','沙发 台球 ','吴家山 一号 4栋 ','/houseImg/15.jpg'),(19,5,44,2,900,140,'好房子','精装修','沙发 台球 ','吴家山 一号 4栋 ','/houseImg/16.jpg'),(20,5,56,3,1100,56,'好房子','精装修','沙发 台球 ','吴家山 一号 4栋 ','/houseImg/17.jpg'),(21,5,65,4,1400,65,'好房子','精装修','沙发 台球 ','吴家山 一号 4栋 ','/houseImg/18.jpg');

/*Table structure for table `h_type` */

DROP TABLE IF EXISTS `h_type`;

CREATE TABLE `h_type` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `typedesc` varchar(50) DEFAULT NULL COMMENT '类型描述',
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `h_type` */

insert  into `h_type`(`typeid`,`typedesc`) values (1,'一室一厅'),(2,'两室一厅'),(3,'三室一厅'),(4,'一室两厅'),(5,'两室两厅'),(6,'三室两厅');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `pwd` varchar(100) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `head_img` varchar(100) DEFAULT NULL,
  `role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`uid`,`name`,`pwd`,`sex`,`birth`,`head_img`,`role`) values (1,'admin','admin','男','2020-06-13','/img/曹操.jpg','房东'),(2,'lisi','123','女','2020-06-03','/img/貂蝉.jpg','租客'),(3,'刘备','666','男','2020-06-10','/img/刘备.jpg','房东'),(4,'孙小妹','123','女','2020-06-13','/img/孙小妹.jpg','租客'),(5,'孙权','666','男','2020-06-17','/img/孙权.jpg','房东'),(6,'zhangsan','123','女','2020-06-09','/img/大乔.jpg','租客');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
