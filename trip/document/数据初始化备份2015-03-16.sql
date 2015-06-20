/*
SQLyog Trial v9.02 
MySQL - 5.0.45-community-nt : Database - otrip_test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`otrip_test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `otrip_test`;

/*Table structure for table `ot_acti_click_praise` */

DROP TABLE IF EXISTS `ot_acti_click_praise`;

CREATE TABLE `ot_acti_click_praise` (
  `fs_id` varchar(255) NOT NULL,
  `fd_praise_time` datetime default NULL,
  `fn_long` longtext,
  `fs_acti_id` varchar(255) default NULL,
  `fs_user_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_ch6voupavxokdp8ptepy3nndx` (`fs_acti_id`),
  KEY `FK_qdxo0vxy9jy4wugqongtukc11` (`fs_user_id`),
  CONSTRAINT `FK_ch6voupavxokdp8ptepy3nndx` FOREIGN KEY (`fs_acti_id`) REFERENCES `ot_acti_info` (`fs_id`),
  CONSTRAINT `FK_qdxo0vxy9jy4wugqongtukc11` FOREIGN KEY (`fs_user_id`) REFERENCES `sys_user` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_acti_click_praise` */

/*Table structure for table `ot_acti_day` */

DROP TABLE IF EXISTS `ot_acti_day`;

CREATE TABLE `ot_acti_day` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fn_days` int(11) default NULL,
  `fn_latitude` decimal(19,2) default NULL,
  `fn_longitude` decimal(19,2) default NULL,
  `fs_description` varchar(255) default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_acti_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_sms3pq7s9n2x1k1qtvkctmcss` (`fs_acti_id`),
  CONSTRAINT `FK_sms3pq7s9n2x1k1qtvkctmcss` FOREIGN KEY (`fs_acti_id`) REFERENCES `ot_acti_info` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_acti_day` */

/*Table structure for table `ot_acti_destination` */

DROP TABLE IF EXISTS `ot_acti_destination`;

CREATE TABLE `ot_acti_destination` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fn_latitude` decimal(19,2) default NULL,
  `fn_longitudel` decimal(19,2) default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_parent_id` varchar(255) default NULL,
  `fs_value` varchar(255) default NULL,
  `fs_type_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_hijb9v4asprmgt0j3cntql3oe` (`fs_type_id`),
  CONSTRAINT `FK_hijb9v4asprmgt0j3cntql3oe` FOREIGN KEY (`fs_type_id`) REFERENCES `ot_acti_destination_type` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_acti_destination` */

/*Table structure for table `ot_acti_destination_type` */

DROP TABLE IF EXISTS `ot_acti_destination_type`;

CREATE TABLE `ot_acti_destination_type` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_sign` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_acti_destination_type` */

/*Table structure for table `ot_acti_discuss` */

DROP TABLE IF EXISTS `ot_acti_discuss`;

CREATE TABLE `ot_acti_discuss` (
  `fs_id` varchar(255) NOT NULL,
  `fd_time` datetime default NULL,
  `fs_content` varchar(255) default NULL,
  `fs_grade_level` int(11) default NULL,
  `fs_acti_id` varchar(255) default NULL,
  `fs_user_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_be36oq4rue5xsovsb3e8ytwhh` (`fs_acti_id`),
  KEY `FK_l3nienujrv7qwslo5meymb4uy` (`fs_user_id`),
  CONSTRAINT `FK_be36oq4rue5xsovsb3e8ytwhh` FOREIGN KEY (`fs_acti_id`) REFERENCES `ot_acti_info` (`fs_id`),
  CONSTRAINT `FK_l3nienujrv7qwslo5meymb4uy` FOREIGN KEY (`fs_user_id`) REFERENCES `sys_user` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_acti_discuss` */

/*Table structure for table `ot_acti_favorite` */

DROP TABLE IF EXISTS `ot_acti_favorite`;

CREATE TABLE `ot_acti_favorite` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fs_acti_id` varchar(255) default NULL,
  `fs_user_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_48re5f9y11svfm0w41q8dfgl8` (`fs_acti_id`),
  KEY `FK_9w9ppfbfq6oe8lq47ue1q6kcr` (`fs_user_id`),
  CONSTRAINT `FK_48re5f9y11svfm0w41q8dfgl8` FOREIGN KEY (`fs_acti_id`) REFERENCES `ot_acti_info` (`fs_id`),
  CONSTRAINT `FK_9w9ppfbfq6oe8lq47ue1q6kcr` FOREIGN KEY (`fs_user_id`) REFERENCES `sys_user` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_acti_favorite` */

/*Table structure for table `ot_acti_info` */

DROP TABLE IF EXISTS `ot_acti_info`;

CREATE TABLE `ot_acti_info` (
  `fs_id` varchar(255) NOT NULL,
  `create_time` datetime default NULL,
  `fd_under_time` datetime default NULL,
  `fd_upper_time` datetime default NULL,
  `fn_day` int(11) default NULL,
  `fn_destination_latitude` decimal(19,2) default NULL,
  `fn_destination_longitudel` decimal(19,2) default NULL,
  `fn_discuss_num` longtext,
  `fn_favorite_num` longtext,
  `fn_praise_num` longtext,
  `fn_trip_distance` decimal(19,2) default NULL,
  `fs_cost_notes` varchar(255) default NULL,
  `fs_create_user_id` varchar(255) default NULL,
  `fs_destination_type` varchar(255) default NULL,
  `fs_equip_list` varchar(255) default NULL,
  `fs_holiday` varchar(255) default NULL,
  `fs_line_road` varchar(255) default NULL,
  `fs_no` varchar(255) default NULL,
  `fs_physical_strength` varchar(255) default NULL,
  `fs_refund_notes` varchar(255) default NULL,
  `fs_season` varchar(255) default NULL,
  `fs_title` varchar(255) default NULL,
  `fs_update_user_id` varchar(255) default NULL,
  `update_time` datetime default NULL,
  `fs_destination_scenic` varchar(255) default NULL,
  `fs_destination_continent` varchar(255) default NULL,
  `fs_destination_country` varchar(255) default NULL,
  `fs_destination_province` varchar(255) default NULL,
  `fs_outdoors_type` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_86kw51v2u007l8l7uhqt2j642` (`fs_destination_scenic`),
  KEY `FK_skf6d81cuelq8m91ckglevakg` (`fs_destination_continent`),
  KEY `FK_eka1mca6krdobjaywu835832w` (`fs_destination_country`),
  KEY `FK_l3cpelm8oj6s079g7742wubdo` (`fs_destination_province`),
  KEY `FK_omjhd4dqfdna2y9f9ftvpr5cq` (`fs_outdoors_type`),
  CONSTRAINT `FK_86kw51v2u007l8l7uhqt2j642` FOREIGN KEY (`fs_destination_scenic`) REFERENCES `ot_acti_destination` (`fs_id`),
  CONSTRAINT `FK_eka1mca6krdobjaywu835832w` FOREIGN KEY (`fs_destination_country`) REFERENCES `ot_acti_destination` (`fs_id`),
  CONSTRAINT `FK_l3cpelm8oj6s079g7742wubdo` FOREIGN KEY (`fs_destination_province`) REFERENCES `ot_acti_destination` (`fs_id`),
  CONSTRAINT `FK_omjhd4dqfdna2y9f9ftvpr5cq` FOREIGN KEY (`fs_outdoors_type`) REFERENCES `ot_acti_type` (`fs_id`),
  CONSTRAINT `FK_skf6d81cuelq8m91ckglevakg` FOREIGN KEY (`fs_destination_continent`) REFERENCES `ot_acti_destination` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_acti_info` */

/*Table structure for table `ot_acti_order` */

DROP TABLE IF EXISTS `ot_acti_order`;

CREATE TABLE `ot_acti_order` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_order_time` datetime default NULL,
  `fd_trip_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fn_coupon_money` decimal(19,2) default NULL,
  `fn_order_money` decimal(19,2) default NULL,
  `fn_pay_money` decimal(19,2) default NULL,
  `fn_travel_adult_num` longtext,
  `fn_travel_children_num` longtext,
  `fs_contact_email` varchar(255) default NULL,
  `fs_contact_name` varchar(255) default NULL,
  `fs_contact_phone` varchar(255) default NULL,
  `fs_main_travel_person_name` varchar(255) default NULL,
  `fs_main_travel_person_name_py` varchar(255) default NULL,
  `fs_pay_way` varchar(255) default NULL,
  `fs_status` varchar(255) default NULL,
  `fs_acti_id` varchar(255) default NULL,
  `fs_user_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_glhyrmkko7b1i2re30yns19wr` (`fs_acti_id`),
  KEY `FK_bhb5gircdm26mdleui3748ghh` (`fs_user_id`),
  CONSTRAINT `FK_bhb5gircdm26mdleui3748ghh` FOREIGN KEY (`fs_user_id`) REFERENCES `sys_user` (`fs_id`),
  CONSTRAINT `FK_glhyrmkko7b1i2re30yns19wr` FOREIGN KEY (`fs_acti_id`) REFERENCES `ot_acti_info` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_acti_order` */

/*Table structure for table `ot_acti_order_coupon` */

DROP TABLE IF EXISTS `ot_acti_order_coupon`;

CREATE TABLE `ot_acti_order_coupon` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fs_order_id` varchar(255) default NULL,
  `fs_coupon_id` varchar(255) default NULL,
  `fs_user_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_8tw4jxtoeufsdofn94nxrvy0g` (`fs_order_id`),
  KEY `FK_8uchf2o740n34086xc9tgbn2r` (`fs_coupon_id`),
  KEY `FK_pc01hq3hnb5gwdmv9s3qxo6yl` (`fs_user_id`),
  CONSTRAINT `FK_8tw4jxtoeufsdofn94nxrvy0g` FOREIGN KEY (`fs_order_id`) REFERENCES `ot_acti_order` (`fs_id`),
  CONSTRAINT `FK_8uchf2o740n34086xc9tgbn2r` FOREIGN KEY (`fs_coupon_id`) REFERENCES `ot_coupon_part` (`fs_id`),
  CONSTRAINT `FK_pc01hq3hnb5gwdmv9s3qxo6yl` FOREIGN KEY (`fs_user_id`) REFERENCES `sys_user` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_acti_order_coupon` */

/*Table structure for table `ot_acti_order_user_list` */

DROP TABLE IF EXISTS `ot_acti_order_user_list`;

CREATE TABLE `ot_acti_order_user_list` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fs_credentials_no` varchar(255) default NULL,
  `fs_credentials_type` varchar(255) default NULL,
  `fs_email` varchar(255) default NULL,
  `fs_name_pinyin` varchar(255) default NULL,
  `fs_travel_user_name` varchar(255) default NULL,
  `fs_travel_user_phone` varchar(255) default NULL,
  `fs_acti_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_5d4g7025fu7elklq9be3ym0f` (`fs_acti_id`),
  CONSTRAINT `FK_5d4g7025fu7elklq9be3ym0f` FOREIGN KEY (`fs_acti_id`) REFERENCES `ot_acti_order` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_acti_order_user_list` */

/*Table structure for table `ot_acti_problem_discuss` */

DROP TABLE IF EXISTS `ot_acti_problem_discuss`;

CREATE TABLE `ot_acti_problem_discuss` (
  `fs_id` varchar(255) NOT NULL,
  `fd_time` datetime default NULL,
  `fs_content` varchar(255) default NULL,
  `fs_status` varchar(255) default NULL,
  `fs_acti_id` varchar(255) default NULL,
  `fs_proplem_id` varchar(255) default NULL,
  `fs_user_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_mr1h6afgqxm69216kd57r1yev` (`fs_acti_id`),
  KEY `FK_s9oqgtb6aimt3bl7vcs4kb1l4` (`fs_proplem_id`),
  KEY `FK_tp62p5f7bgc4wxy2kk6d2f6ta` (`fs_user_id`),
  CONSTRAINT `FK_mr1h6afgqxm69216kd57r1yev` FOREIGN KEY (`fs_acti_id`) REFERENCES `ot_acti_info` (`fs_id`),
  CONSTRAINT `FK_s9oqgtb6aimt3bl7vcs4kb1l4` FOREIGN KEY (`fs_proplem_id`) REFERENCES `ot_acti_problem_discuss` (`fs_id`),
  CONSTRAINT `FK_tp62p5f7bgc4wxy2kk6d2f6ta` FOREIGN KEY (`fs_user_id`) REFERENCES `sys_user` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_acti_problem_discuss` */

/*Table structure for table `ot_acti_time_price` */

DROP TABLE IF EXISTS `ot_acti_time_price`;

CREATE TABLE `ot_acti_time_price` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_end_time` datetime default NULL,
  `fd_start_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fn_deposit_rate` decimal(19,2) default NULL,
  `fn_original_price` decimal(19,2) default NULL,
  `fn_special_price` decimal(19,2) default NULL,
  `fs_acti_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_b5gsy9vyhqoe54ul7ya6nh6km` (`fs_acti_id`),
  CONSTRAINT `FK_b5gsy9vyhqoe54ul7ya6nh6km` FOREIGN KEY (`fs_acti_id`) REFERENCES `ot_acti_info` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_acti_time_price` */

/*Table structure for table `ot_acti_type` */

DROP TABLE IF EXISTS `ot_acti_type`;

CREATE TABLE `ot_acti_type` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_sign` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_acti_type` */

/*Table structure for table `ot_coupon_gather` */

DROP TABLE IF EXISTS `ot_coupon_gather`;

CREATE TABLE `ot_coupon_gather` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fn_sheet_number` longtext,
  `fn_total_money` decimal(19,2) default NULL,
  `fs_type` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_coupon_gather` */

/*Table structure for table `ot_coupon_part` */

DROP TABLE IF EXISTS `ot_coupon_part`;

CREATE TABLE `ot_coupon_part` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_effective_end_time` datetime default NULL,
  `fd_effective_start_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fn_per_money` decimal(19,2) default NULL,
  `fs_code` varchar(255) default NULL,
  `fs_description` varchar(255) default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_status` varchar(255) default NULL,
  `fs_coupon_gather_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_6c2uk3y8wvwsroly8x4fb3d1o` (`fs_coupon_gather_id`),
  CONSTRAINT `FK_6c2uk3y8wvwsroly8x4fb3d1o` FOREIGN KEY (`fs_coupon_gather_id`) REFERENCES `ot_coupon_gather` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_coupon_part` */

/*Table structure for table `ot_image` */

DROP TABLE IF EXISTS `ot_image`;

CREATE TABLE `ot_image` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fs_content_type` varchar(255) default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_obj_id` varchar(255) default NULL,
  `fs_obj_sign` varchar(255) default NULL,
  `fs_obj_tab_name` varchar(255) default NULL,
  `fs_path` longblob,
  PRIMARY KEY  (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_image` */

/*Table structure for table `ot_meet_airport` */

DROP TABLE IF EXISTS `ot_meet_airport`;

CREATE TABLE `ot_meet_airport` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fn_latitude` decimal(19,2) default NULL,
  `fn_longitude` decimal(19,2) default NULL,
  `fs_airport` varchar(255) default NULL,
  `fs_city` varchar(255) default NULL,
  `fs_continent` varchar(255) default NULL,
  `fs_country` varchar(255) default NULL,
  `fs_province` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_meet_airport` */

/*Table structure for table `ot_meet_airport_discuss` */

DROP TABLE IF EXISTS `ot_meet_airport_discuss`;

CREATE TABLE `ot_meet_airport_discuss` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_discuss_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fn_star_level` longtext,
  `fs_discuss_content` varchar(255) default NULL,
  `fs_airport_id` varchar(255) default NULL,
  `fs_user_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_neythvodyc2mmst1j67p2p5ja` (`fs_airport_id`),
  KEY `FK_igrahdv5ow2xepp7j6439g8sc` (`fs_user_id`),
  CONSTRAINT `FK_igrahdv5ow2xepp7j6439g8sc` FOREIGN KEY (`fs_user_id`) REFERENCES `sys_user` (`fs_id`),
  CONSTRAINT `FK_neythvodyc2mmst1j67p2p5ja` FOREIGN KEY (`fs_airport_id`) REFERENCES `ot_meet_airport` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_meet_airport_discuss` */

/*Table structure for table `ot_meet_airport_order` */

DROP TABLE IF EXISTS `ot_meet_airport_order`;

CREATE TABLE `ot_meet_airport_order` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_meet_time` datetime default NULL,
  `fd_order_time` datetime default NULL,
  `fd_pay_time` datetime default NULL,
  `fd_start_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fn_order_money` decimal(19,2) default NULL,
  `fn_passenger_adult` longtext,
  `fn_passenger_children` longtext,
  `fs_contact_phone` varchar(255) default NULL,
  `fs_contacts_user` varchar(255) default NULL,
  `fs_description` varchar(255) default NULL,
  `fs_order_no` varchar(255) default NULL,
  `fs_pay_way` varchar(255) default NULL,
  `fs_status` varchar(255) default NULL,
  `fs_start_airport_id` varchar(255) default NULL,
  `fs_meet_airport_id` varchar(255) default NULL,
  `fs_order_user` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_5rw8uewe7bq1pjjky41yhxi2` (`fs_start_airport_id`),
  KEY `FK_mdodtjyr8fih9su136qde9v41` (`fs_meet_airport_id`),
  KEY `FK_shq934s02fffx7yq6ouwcb1qv` (`fs_order_user`),
  CONSTRAINT `FK_5rw8uewe7bq1pjjky41yhxi2` FOREIGN KEY (`fs_start_airport_id`) REFERENCES `ot_meet_airport` (`fs_id`),
  CONSTRAINT `FK_mdodtjyr8fih9su136qde9v41` FOREIGN KEY (`fs_meet_airport_id`) REFERENCES `ot_meet_airport` (`fs_id`),
  CONSTRAINT `FK_shq934s02fffx7yq6ouwcb1qv` FOREIGN KEY (`fs_order_user`) REFERENCES `sys_user` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_meet_airport_order` */

/*Table structure for table `ot_order_passenger` */

DROP TABLE IF EXISTS `ot_order_passenger`;

CREATE TABLE `ot_order_passenger` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fs_credentials_no` varchar(255) default NULL,
  `fs_credentials_type` varchar(255) default NULL,
  `fs_email` varchar(255) default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_person_pinyin` varchar(255) default NULL,
  `fs_person_type` varchar(255) default NULL,
  `fs_phone` varchar(255) default NULL,
  `fs_order_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_4ciqq0kuhufof0wablato1iok` (`fs_order_id`),
  CONSTRAINT `FK_4ciqq0kuhufof0wablato1iok` FOREIGN KEY (`fs_order_id`) REFERENCES `ot_meet_airport_order` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_order_passenger` */

/*Table structure for table `ot_owner_coupon` */

DROP TABLE IF EXISTS `ot_owner_coupon`;

CREATE TABLE `ot_owner_coupon` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fn_number` longtext,
  `fs_status` varchar(255) default NULL,
  `fs_coupon_id` varchar(255) default NULL,
  `fs_user_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_fk58d688xm7rrl0fkbs5b0jn` (`fs_coupon_id`),
  KEY `FK_100lnbo3r0n4apis5ovnwnelj` (`fs_user_id`),
  CONSTRAINT `FK_100lnbo3r0n4apis5ovnwnelj` FOREIGN KEY (`fs_user_id`) REFERENCES `sys_user` (`fs_id`),
  CONSTRAINT `FK_fk58d688xm7rrl0fkbs5b0jn` FOREIGN KEY (`fs_coupon_id`) REFERENCES `ot_coupon_part` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ot_owner_coupon` */

/*Table structure for table `sys_contacts_person` */

DROP TABLE IF EXISTS `sys_contacts_person`;

CREATE TABLE `sys_contacts_person` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fs_certificates_code` varchar(255) default NULL,
  `fs_certificates_type` varchar(255) default NULL,
  `fs_email` varchar(255) default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_phone` varchar(255) default NULL,
  `fs_user_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_3yr7p5sfub7s3oss04xeut0gf` (`fs_user_id`),
  CONSTRAINT `FK_3yr7p5sfub7s3oss04xeut0gf` FOREIGN KEY (`fs_user_id`) REFERENCES `sys_user` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_contacts_person` */

/*Table structure for table `sys_dictionary_type` */

DROP TABLE IF EXISTS `sys_dictionary_type`;

CREATE TABLE `sys_dictionary_type` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_sign` varchar(255) default NULL,
  `fs_status` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_dictionary_type` */

/*Table structure for table `sys_dictionary_value` */

DROP TABLE IF EXISTS `sys_dictionary_value`;

CREATE TABLE `sys_dictionary_value` (
  `fs_id` varchar(255) NOT NULL,
  `fb_image` longblob,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fn_sort` int(11) default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_parent_id` varchar(255) default NULL,
  `fs_value` varchar(255) default NULL,
  `fs_dictionary_type` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_etqdhkwceawr8mbsuwbp5mk6e` (`fs_dictionary_type`),
  CONSTRAINT `FK_etqdhkwceawr8mbsuwbp5mk6e` FOREIGN KEY (`fs_dictionary_type`) REFERENCES `sys_dictionary_type` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_dictionary_value` */

/*Table structure for table `sys_login_history` */

DROP TABLE IF EXISTS `sys_login_history`;

CREATE TABLE `sys_login_history` (
  `fs_id` varchar(255) NOT NULL,
  `fd_login_time` datetime default NULL,
  `fd_logout_time` datetime default NULL,
  `fs_ip` varchar(255) default NULL,
  `fs_user_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_rcberxgkdfu0y1u0kh12r3op5` (`fs_user_id`),
  CONSTRAINT `FK_rcberxgkdfu0y1u0kh12r3op5` FOREIGN KEY (`fs_user_id`) REFERENCES `sys_user` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_login_history` */

insert  into `sys_login_history`(`fs_id`,`fd_login_time`,`fd_logout_time`,`fs_ip`,`fs_user_id`) values ('2f8b4af8-516a-481b-87fe-4c19454337fd','2015-03-11 23:31:20','2015-03-11 11:31:20','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('51859b46-b035-414e-96b6-2b431c482d1c','2015-03-11 23:27:17','2015-03-11 11:27:18','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('84c4b6a5-f1a2-4cff-b1c6-acfd8674dbe2','2015-03-11 23:34:03','2015-03-11 11:34:33','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('964794cf-3e5b-4310-99eb-95e31c83c12f','2015-03-11 23:27:57','2015-03-11 11:27:57','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('d9c441a8-ebe5-452d-9d04-4e118cc2c8c3','2015-03-12 14:10:04',NULL,'0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3');

/*Table structure for table `sys_menu_auth` */

DROP TABLE IF EXISTS `sys_menu_auth`;

CREATE TABLE `sys_menu_auth` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fs_description` varchar(255) default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_parent_id` varchar(255) default NULL,
  `fs_status` varchar(255) default NULL,
  `fs_menu_type` varchar(255) default NULL,
  `fs_resources_id` varchar(255) default NULL,
  `fn_order` int(10) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_5lje8t49uxrovhwcjgsvt2hk2` (`fs_menu_type`),
  KEY `FK_jms40gc9q1rq3bqabp68vi7pu` (`fs_resources_id`),
  CONSTRAINT `FK_5lje8t49uxrovhwcjgsvt2hk2` FOREIGN KEY (`fs_menu_type`) REFERENCES `sys_menu_type` (`fs_id`),
  CONSTRAINT `FK_jms40gc9q1rq3bqabp68vi7pu` FOREIGN KEY (`fs_resources_id`) REFERENCES `sys_resources` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu_auth` */

insert  into `sys_menu_auth`(`fs_id`,`fd_create_time`,`fd_update_time`,`fs_description`,`fs_name`,`fs_parent_id`,`fs_status`,`fs_menu_type`,`fs_resources_id`,`fn_order`) values ('0','2015-03-10 00:00:00','2015-03-10 00:00:00','氧气管理系统，默认跟','氧气管理系统','root','1','2b074a4f-29f3-46fa-a965-300a41f01929','a0efd601-354c-4343-aeb4-fea1918e0e55',0),('0b64157d-da80-4fbc-a772-441c603e92bd',NULL,NULL,'系统管理-权限配置-地址配置-删除地址\r\n','删除地址','728d4ff0-13a0-466f-8319-ddc39b50a14f','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','e5c41a59-9c53-4401-a7f9-cdc420c50c95',4),('0d038780-760b-4771-bfd3-640b055ee148',NULL,NULL,'消息提醒-消息提醒【模块】','消息提醒','f3258a27-488c-42f1-ba20-98f461d877ca','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',1),('0dde162b-50ac-47db-a7dd-2e6c27a50407',NULL,NULL,'系统管理-权限配置-菜单管理\r\n','菜单管理','7eeda6e5-110a-45d7-a9f0-5495f11feb7d','1','880a54dc-020c-4d04-b997-5518af7372b5','7f15e74f-e929-4c68-ae3b-ceedcb79da77',2),('12b289b2-b447-49f7-9703-32863edf8630',NULL,NULL,'消息提醒-优惠劵领用提醒【模块】','优惠劵领用提醒','f3258a27-488c-42f1-ba20-98f461d877ca','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',3),('1771b9d2-2226-43ea-941f-9c9aa54f05a3',NULL,NULL,'系统管理-用户管理【模块】','用户管理','49f5cf88-810c-4b56-95f4-86a2b77e2a75','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',1),('18794149-d5bc-4969-a9ce-03fd23770f03',NULL,NULL,'系统管理-默认内容页面\r\n','系统管理默认内容页','49f5cf88-810c-4b56-95f4-86a2b77e2a75','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','bd96fb20-4882-4ceb-9283-9a1b9fa83382',2),('203a714a-1826-4234-8b6c-4bb60ba4aba2',NULL,NULL,'系统管理-用户管理-用户信息【菜单】','用户信息','1771b9d2-2226-43ea-941f-9c9aa54f05a3','1','880a54dc-020c-4d04-b997-5518af7372b5','056d6790-c8f8-4360-884a-05b5dd13af49',1),('217eecd6-7c58-4691-8195-a912eda7d0a2',NULL,NULL,'接机管理子系统','接机管理','0','1','172d1108-8252-4de3-9e1a-3ea96dba10e0','a0efd601-354c-4343-aeb4-fea1918e0e55',3),('245fbcf9-57ee-4043-9563-e0d51edd6c5b',NULL,NULL,'消息提醒-问题跟踪提醒【模块】','问题跟踪提醒','f3258a27-488c-42f1-ba20-98f461d877ca','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',2),('35d39ba5-19b6-4a94-8976-98d987c828a6',NULL,NULL,'接机管理-机场管理【模块】','机场管理','217eecd6-7c58-4691-8195-a912eda7d0a2','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',1),('46b26b8f-5006-4924-abe0-10dc0bde1b80',NULL,NULL,'氧气旅行系统-跟框架','框架链接首页','0','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','f25854a7-cf21-41e0-a1f5-60c219523361',0),('49f5cf88-810c-4b56-95f4-86a2b77e2a75',NULL,NULL,'系统管理子系统','系统管理','0','1','172d1108-8252-4de3-9e1a-3ea96dba10e0','a0efd601-354c-4343-aeb4-fea1918e0e55',5),('4e3043ab-d4b2-4e24-ab8f-cb198154c810',NULL,NULL,'订单管理-旅行订单【模块】','旅行订单','dba3c31a-ba49-4c67-9296-4790197c3e05','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',1),('504e7d56-0fff-47e6-8c53-64ed3db71d64',NULL,NULL,'系统管理-配置管理【模块】','配置管理','49f5cf88-810c-4b56-95f4-86a2b77e2a75','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',3),('591fc03a-dd61-472a-ab84-d8758a4bbbcd',NULL,NULL,'系统管理-权限配置-菜单管理-左边菜单页面\r\n','菜单左边树页面','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','43cbc78f-4ca5-450d-8052-291c7fb76855',1),('5cfa9e78-2954-4608-9aeb-141162de207c',NULL,NULL,'系统管理-权限配置-地址配置-保存地址\r\n','保存地址','728d4ff0-13a0-466f-8319-ddc39b50a14f','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','6a74c5cf-f1de-41a6-b236-c4b38718bd50',3),('6a9bbb88-54ef-445b-95f5-336d63b713af',NULL,NULL,'系统管理-权限配置-菜单管理-保存子菜单\r\n','保存子菜单','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','40ff445d-bd70-4bb7-87ae-193716ac420a',5),('6f77a4c8-07dd-44f8-8bcd-7ca48cfe51c9',NULL,NULL,'系统管理-权限配置-菜单类型\r\n','菜单类型','7eeda6e5-110a-45d7-a9f0-5495f11feb7d','1','880a54dc-020c-4d04-b997-5518af7372b5','0be50fe5-7d5e-4a4f-9e89-e063f9f1f9ba',4),('728d4ff0-13a0-466f-8319-ddc39b50a14f',NULL,NULL,'系统管理-权限配置-地址配置\r\n','地址配置','7eeda6e5-110a-45d7-a9f0-5495f11feb7d','1','880a54dc-020c-4d04-b997-5518af7372b5','aafa872c-d5b7-4b2b-92c1-979649ca35dd',3),('7a5838d2-d8a7-4559-a82e-394611a299c5',NULL,NULL,'订单管理-订单统计【模块】','订单统计','dba3c31a-ba49-4c67-9296-4790197c3e05','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',3),('7eeda6e5-110a-45d7-a9f0-5495f11feb7d',NULL,NULL,'系统管理-权限配置【模块】','权限配置','49f5cf88-810c-4b56-95f4-86a2b77e2a75','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',2),('94952c68-8bb4-4cf8-8a6c-ba187b53bf48',NULL,NULL,'旅行管理子系统','旅行管理','0','1','172d1108-8252-4de3-9e1a-3ea96dba10e0','a0efd601-354c-4343-aeb4-fea1918e0e55',4),('94dc532f-adad-4c92-b97e-3ef003387288',NULL,NULL,'系统管理-权限配置-地址配置-选择配置地址【菜单绑定】\r\n','地址选择按钮','728d4ff0-13a0-466f-8319-ddc39b50a14f','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','816f7349-5488-4f32-86f2-ec9628f7b051',1),('a1d960ef-c497-434e-80c7-46d57c592775',NULL,NULL,'系统管理-日志管理【模块】','日志管理','49f5cf88-810c-4b56-95f4-86a2b77e2a75','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',4),('a4c34744-a77d-4a20-b0cf-822c8953a92f',NULL,NULL,'订单管理-优惠劵管理【模块】','优惠劵管理','dba3c31a-ba49-4c67-9296-4790197c3e05','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',4),('a639c0b0-3fd6-4369-9f56-7689214c6dc0',NULL,NULL,'系统管理-权限配置-角色配置\r\n','角色配置','7eeda6e5-110a-45d7-a9f0-5495f11feb7d','1','880a54dc-020c-4d04-b997-5518af7372b5','97baab3f-8b5d-4f65-bf17-c3482b3dd6e0',1),('a6a4dc70-0031-4174-ae5c-b7ad42655984',NULL,NULL,'旅行管理-配置管理【模块】','配置管理','94952c68-8bb4-4cf8-8a6c-ba187b53bf48','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',4),('a89ee76c-1578-4a85-b2b2-206439704f4b',NULL,NULL,'氧气管理系统-框架链接默认内容【链接】','框架链接默认内容页','0','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','6536ddd7-d231-4718-b4cf-cbe6f77a3180',4),('a97d3b80-00f1-4423-a3a1-92a9b268eb15',NULL,NULL,'系统管理-权限配置-菜单类型-删除菜单类型','删除菜单类型','6f77a4c8-07dd-44f8-8bcd-7ca48cfe51c9','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','e25248c9-23ce-43b0-846e-19f7ebe501c7',3),('a9dbd2df-47c8-40b9-9e8b-3a639e2f8a2c',NULL,NULL,'旅行管理-旅行评论【模块】','旅行评论','94952c68-8bb4-4cf8-8a6c-ba187b53bf48','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',3),('b4627be9-75ad-460b-bcc8-a60d631e691d',NULL,NULL,'接机管理-接机评论【模块】','接机评论','217eecd6-7c58-4691-8195-a912eda7d0a2','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',2),('b545d6be-346a-4186-9b6e-0070fdd12eaf',NULL,NULL,'系统管理-权限配置-角色配置-新增角色\r\n','新增角色','a639c0b0-3fd6-4369-9f56-7689214c6dc0','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','14321b9b-9d76-4767-aa11-c1bba7c4611b',1),('b66cfa52-6ac5-4e1b-84eb-8a47e7078184',NULL,NULL,'系统管理-权限配置-菜单管理-删除子菜单\r\n','删除子菜单','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','c1bb6c70-aede-4093-b12e-9322f330f315',6),('b7fb0843-a0ef-4b58-8bbe-45e6ac94a36a',NULL,NULL,'订单管理-接机订单【模块】','接机订单','dba3c31a-ba49-4c67-9296-4790197c3e05','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',2),('be6455cd-24e2-4499-9758-cb3ef63ff35c',NULL,NULL,'系统管理-权限配置-角色配置-删除角色\r\n','删除角色','a639c0b0-3fd6-4369-9f56-7689214c6dc0','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','eee1c803-4a83-4f9c-93d8-3562040121d5',3),('c17c747a-bbae-4fe1-8f9f-3bbc9be5afef',NULL,NULL,'系统管理-权限配置-菜单管理-删除链接\r\n','删除链接','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','91a48ec6-bf59-4ec3-83a3-674a6f1b9d8c',7),('c7dde161-6d80-494d-8bc8-9470d6c1939a',NULL,NULL,'系统管理-权限配置-菜单管理-菜单树内容\r\n','菜单树内容','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','1fc33b2b-2998-4ac5-b329-fe71ef06dd85',3),('cdf30bb6-1148-4548-ad69-becd38862f68',NULL,NULL,'系统管理-权限配置-菜单管理-菜单详细信息页面\r\n','菜单详细信息页面','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','88f02864-8d15-498f-8c1d-bf54916a6889',2),('d3132da1-2f27-40c8-8889-5d9fd8421dd5',NULL,NULL,'氧气旅行管理系统-框架默认左边菜单','框架默认左边菜单','0','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','3ce0b210-07d5-459d-8771-e45baf7969a5',3),('d38c1c4e-1c59-42aa-8ef4-a74482499ec3',NULL,NULL,'系统管理-左菜单管理【链接】','左菜单管理页','49f5cf88-810c-4b56-95f4-86a2b77e2a75','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','33c4ed3f-295f-4c23-9cd6-0b8d7aa20cfa',1),('d595a97e-b4d0-45ee-b350-e61e3f416bbb',NULL,NULL,'旅行管理-旅行活动【模块】','旅行活动','94952c68-8bb4-4cf8-8a6c-ba187b53bf48','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',1),('d90c8474-144c-467d-90a0-d6b1c2acd157',NULL,NULL,'系统管理-权限配置-菜单类型-保存菜单类型\r\n','保存菜单类型','6f77a4c8-07dd-44f8-8bcd-7ca48cfe51c9','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','e0b39040-57ee-425f-acbe-1320f31e6a27',2),('dba3c31a-ba49-4c67-9296-4790197c3e05',NULL,NULL,'订单管理子系统','订单管理','0','1','172d1108-8252-4de3-9e1a-3ea96dba10e0','a0efd601-354c-4343-aeb4-fea1918e0e55',2),('e1422e57-4ea4-4002-8803-d6664a0ca1d5',NULL,NULL,'系统管理-权限配置-地址配置-新增地址\r\n','新增地址','728d4ff0-13a0-466f-8319-ddc39b50a14f','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','d0254644-c4c3-488d-8be3-13e7c10e1ad5',2),('e8b72750-0769-4c23-8f28-e31a4c0ff5c9',NULL,NULL,'氧气旅行系统-跟框架-顶部菜单\r\n','框架链接头部页','0','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','ad1163e4-abd7-4107-b781-eaadf004da48',1),('ea400fdf-fc86-4ce5-bfcb-7daaee1affc1',NULL,NULL,'旅行管理-旅行统计【模块】','旅行统计','94952c68-8bb4-4cf8-8a6c-ba187b53bf48','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',2),('ea771b06-3c34-4853-a767-64f56c7fd311',NULL,NULL,'系统管理-权限配置-菜单管理-新增子菜单\r\n','新增子菜单','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','b3ba8093-ad72-45c9-97d7-c3cc3d42c29f',3),('ef60bfd2-6b4b-46ee-8124-2514b5bab2a3',NULL,NULL,'系统管理-权限配置-菜单类型-新增菜单类型','新增菜单类型','6f77a4c8-07dd-44f8-8bcd-7ca48cfe51c9','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','ac37c1b9-7c56-4a97-8257-3149c5e91cf4',1),('efb70a2c-3253-447f-b33f-7a9025a6d1d1',NULL,NULL,'系统管理-权限配置-角色配置-保存角色\r\n','保存角色','a639c0b0-3fd6-4369-9f56-7689214c6dc0','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','bef1c901-ffcb-4a3e-82ea-b41149b5b53c',2),('f3258a27-488c-42f1-ba20-98f461d877ca',NULL,NULL,'消息提醒子系统','消息提醒','0','1','172d1108-8252-4de3-9e1a-3ea96dba10e0','a0efd601-354c-4343-aeb4-fea1918e0e55',1);

/*Table structure for table `sys_menu_type` */

DROP TABLE IF EXISTS `sys_menu_type`;

CREATE TABLE `sys_menu_type` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_sign` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu_type` */

insert  into `sys_menu_type`(`fs_id`,`fd_create_time`,`fd_update_time`,`fs_name`,`fs_sign`) values ('0efc4905-b918-4e0f-82eb-978fc18dd6a7','2015-03-10 00:00:00','2015-03-10 00:00:00','按钮','4'),('172d1108-8252-4de3-9e1a-3ea96dba10e0','2015-03-10 00:00:00','2015-03-10 00:00:00','子系统','1'),('2b074a4f-29f3-46fa-a965-300a41f01929','2015-03-10 00:00:00','2015-03-10 00:00:00','主系统','0'),('6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','2015-03-10 00:00:00','2015-03-10 00:00:00','模块','2'),('880a54dc-020c-4d04-b997-5518af7372b5','2015-03-10 00:00:00','2015-03-10 00:00:00','菜单','3'),('caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','2015-03-10 00:00:00','2015-03-10 00:00:00','链接','5');

/*Table structure for table `sys_resources` */

DROP TABLE IF EXISTS `sys_resources`;

CREATE TABLE `sys_resources` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fs_description` varchar(255) default NULL,
  `fs_key` varchar(255) default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_url` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_resources` */

insert  into `sys_resources`(`fs_id`,`fd_create_time`,`fd_update_time`,`fs_description`,`fs_key`,`fs_name`,`fs_url`) values ('056d6790-c8f8-4360-884a-05b5dd13af49',NULL,NULL,'系统管理-用户管理-用户信息:菜单\r\n','AUTH_SYSTEM_USER_LIST','系统管理-用户管理-用户信息','/system/user/list.html'),('0be50fe5-7d5e-4a4f-9e89-e063f9f1f9ba',NULL,NULL,'系统管理-权限配置-菜单类型:菜单\r\n','AUTH_SYSTEM_MENUTYPE_LIST','系统管理-权限配置-菜单类型','/system/menutype/list.html'),('14321b9b-9d76-4767-aa11-c1bba7c4611b',NULL,NULL,'系统管理-权限配置-角色配置-新增角色:按钮\r\n','AUTH_SYSTEM_ROLE_TOADD','系统管理-权限配置-角色配置-新增角色','/system/role/toAdd.html'),('1fc33b2b-2998-4ac5-b329-fe71ef06dd85',NULL,NULL,'系统管理-权限配置-菜单管理-菜单树内容:链接\r\n','AUTH_SYSTEM_MENU_MANAGER_TREE','系统管理-权限配置-菜单管理-菜单树内容','/system/menu/manager_tree.html'),('33c4ed3f-295f-4c23-9cd6-0b8d7aa20cfa',NULL,NULL,'系统管理-左边菜单链接:子系统','AUTH_SYSTEM_MENU_LEFT','系统管理-左边菜单链接','/system/menu_left.html'),('3ce0b210-07d5-459d-8771-e45baf7969a5',NULL,NULL,'氧气旅行系统-跟框架-默认左边菜单:默认后台左边菜单','AUTH_OTRIP_LEFT','氧气旅行系统-跟框架-默认左边菜单','/otrip_left.html'),('40ff445d-bd70-4bb7-87ae-193716ac420a',NULL,NULL,'系统管理-权限配置-菜单管理-保存子菜单:按钮\r\n','AUTH_SYSTEM_MENU_SAVE_CHILD_MENU','系统管理-权限配置-菜单管理-保存子菜单','/system/menu/save_child_menu.html'),('43cbc78f-4ca5-450d-8052-291c7fb76855',NULL,NULL,'系统管理-权限配置-菜单管理-左边菜单页面:链接\r\n','AUTH_SYSTEM_MENU_MENU_MANAGER','系统管理-权限配置-菜单管理-左边菜单页面','/system/menu/menu_manager.html'),('6536ddd7-d231-4718-b4cf-cbe6f77a3180',NULL,NULL,'氧气旅行系统-跟框架-默认内容链接:默认内容页面','AUTH_OTRIP_MAIN','氧气旅行系统-跟框架-默认内容链接','/otrip_main.html'),('6a74c5cf-f1de-41a6-b236-c4b38718bd50',NULL,NULL,'系统管理-权限配置-地址配置-保存地址:按钮\r\n','AUTH_SYSTEM_REQUIREDPATH_SAVE','系统管理-权限配置-地址配置-保存地址','/system/requiredpath/save.html'),('7f15e74f-e929-4c68-ae3b-ceedcb79da77',NULL,NULL,'系统管理-权限配置-菜单管理:菜单\r\n','AUTH_SYSTEM_MENU_MANAGER','系统管理-权限配置-菜单管理','/system/menu/manager.html'),('816f7349-5488-4f32-86f2-ec9628f7b051',NULL,NULL,'系统管理-权限配置-地址配置-选择配置地址【菜单绑定】:按钮\r\n','AUTH_SYSTEM_REQUIREDPATH_SELECT_LIST','系统管理-权限配置-地址配置-选择配置地址【菜单绑定】','/system/requiredpath/select_list.html'),('88f02864-8d15-498f-8c1d-bf54916a6889',NULL,NULL,'系统管理-权限配置-菜单管理-菜单详细信息页面:链接\r\n','AUTH_SYSTEM_MENU_INCLUDE_MENU','系统管理-权限配置-菜单管理-菜单详细信息页面','/system/menu/include_menu.html'),('91a48ec6-bf59-4ec3-83a3-674a6f1b9d8c',NULL,NULL,'系统管理-权限配置-菜单管理-删除链接:链接\r\n','AUTH_SYSTEM_MENU_DELETELINK','系统管理-权限配置-菜单管理-删除链接','/system/menu/deleteLink.html'),('97baab3f-8b5d-4f65-bf17-c3482b3dd6e0',NULL,NULL,'系统管理-权限配置-角色配置:菜单\r\n','AUTH_SYSTEM_ROLE_MANAGER','系统管理-权限配置-角色配置','/system/role/manager.html'),('a0efd601-354c-4343-aeb4-fea1918e0e55',NULL,NULL,'默认空地址配置','COMMON_NULL','默认空地址配置',''),('aafa872c-d5b7-4b2b-92c1-979649ca35dd',NULL,NULL,'系统管理-权限配置-地址配置:菜单\r\n','AUTH_SYSTEM_REQUIREDPATH_LIST','系统管理-权限配置-地址配置','/system/requiredpath/list.html'),('ac37c1b9-7c56-4a97-8257-3149c5e91cf4',NULL,NULL,'系统管理-权限配置-菜单类型-新增菜单:按钮\r\n','AUTH_SYSTEM_MENUTYPE_TOADD','系统管理-权限配置-菜单类型-新增菜单类型','/system/menutype/toAdd.html'),('ad1163e4-abd7-4107-b781-eaadf004da48',NULL,NULL,'','AUTH_OTRIP_TOP','氧气旅行系统-跟框架-顶部菜单','/otrip_top.html'),('b3ba8093-ad72-45c9-97d7-c3cc3d42c29f',NULL,NULL,'系统管理-权限配置-菜单管理-新增子菜单:按钮\r\n','AUTH_SYSTEM_MENU_ADD_CHILD_MENU','系统管理-权限配置-菜单管理-新增子菜单','/system/menu/add_child_menu.html'),('bd96fb20-4882-4ceb-9283-9a1b9fa83382',NULL,NULL,'系统管理-默认内容页面:链接\r\n','AUTH_SYSTEM_MAIN_CONTENT','系统管理-默认内容页面','/system/main_content.html'),('bef1c901-ffcb-4a3e-82ea-b41149b5b53c',NULL,NULL,'系统管理-权限配置-角色配置-保存角色:按钮\r\n','AUTH_SYSTEM_ROLE_SAVE','系统管理-权限配置-角色配置-保存角色','/system/role/save.html'),('c1bb6c70-aede-4093-b12e-9322f330f315',NULL,NULL,'系统管理-权限配置-菜单管理-删除子菜单:按钮\r\n','AUTH_SYSTEM_MENU_DELETE','系统管理-权限配置-菜单管理-删除子菜单','/system/menu/delete.html'),('d0254644-c4c3-488d-8be3-13e7c10e1ad5',NULL,NULL,'系统管理-权限配置-地址配置-新增地址:按钮\r\n','AUTH_SYSTEM_REQUIREDPATH_TOADD','系统管理-权限配置-地址配置-新增地址','/system/requiredpath/toAdd.html'),('e0b39040-57ee-425f-acbe-1320f31e6a27',NULL,NULL,'系统管理-权限配置-菜单类型-保存菜单:按钮\r\n','AUTH_SYSTEM_MENUTYPE_SAVE','系统管理-权限配置-菜单类型-保存菜单类型','/system/menutype/save.html'),('e25248c9-23ce-43b0-846e-19f7ebe501c7',NULL,NULL,'系统管理-权限配置-菜单类型-删除菜单:链接\r\n','AUTH_SYSTEM_MENUTYPE_DELETE','系统管理-权限配置-菜单类型-删除菜单类型','/system/menutype/delete.html'),('e5c41a59-9c53-4401-a7f9-cdc420c50c95',NULL,NULL,'系统管理-权限配置-地址配置-删除地址:链接\r\n','AUTH_SYSTEM_REQUIREDPATH_DELETE','系统管理-权限配置-地址配置-删除地址','/system/requiredpath/delete.html'),('eee1c803-4a83-4f9c-93d8-3562040121d5',NULL,NULL,'系统管理-权限配置-角色配置-删除角色:链接\r\n','AUTH_SYSTEM_ROLE_DELETE','系统管理-权限配置-角色配置-删除角色','/system/role/delete.html'),('f25854a7-cf21-41e0-a1f5-60c219523361',NULL,NULL,'氧气旅行系统-后台主页-跟框架','AUTH_OTRIP_INDEX','氧气旅行系统-跟框架','/index.html');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fn_order` int(11) default NULL,
  `fs_name` varchar(255) default NULL,
  `fs_sign` varchar(255) default NULL,
  `fs_status` varchar(255) default NULL,
  `fs_parent_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_no5g67htr2gh0uc92gtgul1y` (`fs_parent_id`),
  CONSTRAINT `FK_no5g67htr2gh0uc92gtgul1y` FOREIGN KEY (`fs_parent_id`) REFERENCES `sys_role` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`fs_id`,`fd_create_time`,`fd_update_time`,`fn_order`,`fs_name`,`fs_sign`,`fs_status`,`fs_parent_id`) values ('0498d44f-7e04-4002-af0c-6c010398e229',NULL,NULL,1,'超级管理员','ROLE_SUPER_ADMIN','1','6594cee4-c04d-4ce2-81e2-7c88b6e506ac'),('6594cee4-c04d-4ce2-81e2-7c88b6e506ac','2015-03-11 00:00:00','2015-03-11 00:00:00',1,'氧气旅行系统跟角色','ROLE_ROOT','1',NULL),('86d884c7-703f-49c1-a9ae-1697ac8c8515',NULL,NULL,3,'后台管理员','ROLE_BACK_AMDIN','1','0498d44f-7e04-4002-af0c-6c010398e229');

/*Table structure for table `sys_role_auth` */

DROP TABLE IF EXISTS `sys_role_auth`;

CREATE TABLE `sys_role_auth` (
  `fs_id` varchar(255) NOT NULL,
  `fs_menu_auth_id` varchar(255) default NULL,
  `fs_role_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_2ehlrylpgk1eaofohu0hljne8` (`fs_menu_auth_id`),
  KEY `FK_aren4ncje8yya0pn6h7u3028n` (`fs_role_id`),
  CONSTRAINT `FK_2ehlrylpgk1eaofohu0hljne8` FOREIGN KEY (`fs_menu_auth_id`) REFERENCES `sys_menu_auth` (`fs_id`),
  CONSTRAINT `FK_aren4ncje8yya0pn6h7u3028n` FOREIGN KEY (`fs_role_id`) REFERENCES `sys_role` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_auth` */

insert  into `sys_role_auth`(`fs_id`,`fs_menu_auth_id`,`fs_role_id`) values ('0a0cca34-8df5-414c-9586-2179d3e3e42e','b4627be9-75ad-460b-bcc8-a60d631e691d','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('1c6b7689-8480-468d-a920-814c2f79b6cb','a639c0b0-3fd6-4369-9f56-7689214c6dc0','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('24ba1249-e214-4c9d-9fe2-a62bfe0d7d5c','591fc03a-dd61-472a-ab84-d8758a4bbbcd','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('287f7db7-1557-40bd-9e10-cf39bf315c6e','0b64157d-da80-4fbc-a772-441c603e92bd','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('2a59956a-8a75-4419-9b03-e10069c55eb3','1771b9d2-2226-43ea-941f-9c9aa54f05a3','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('2eef330a-8f66-4c39-a046-f3b4ce6f1669','12b289b2-b447-49f7-9703-32863edf8630','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('2ef36ed3-6987-41e0-b54a-f72dc4d10e73','d38c1c4e-1c59-42aa-8ef4-a74482499ec3','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('35d61ba2-9c85-4022-83e4-19be75e577b9','49f5cf88-810c-4b56-95f4-86a2b77e2a75','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('3646080c-ed86-4481-871d-38d760aa456e','a9dbd2df-47c8-40b9-9e8b-3a639e2f8a2c','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('3b01bee6-58e4-49cc-9b2e-98f19c4da9fb','a6a4dc70-0031-4174-ae5c-b7ad42655984','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('3f9c4634-5873-4ca0-bc7d-301a613044f2','a1d960ef-c497-434e-80c7-46d57c592775','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('4b134b08-bb0b-4e1f-a47b-7068e281dd48','46b26b8f-5006-4924-abe0-10dc0bde1b80','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('4e34a303-95de-4160-baca-49c42d6c9cf9','b7fb0843-a0ef-4b58-8bbe-45e6ac94a36a','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('515ef9c3-7896-41ff-994d-10eeb2a1c796','d90c8474-144c-467d-90a0-d6b1c2acd157','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('5357b581-5c49-4384-ba98-8dd301cdcc3e','efb70a2c-3253-447f-b33f-7a9025a6d1d1','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('5dd12b40-369e-4ac4-8dfa-f1a016ab25db','a97d3b80-00f1-4423-a3a1-92a9b268eb15','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('620f8303-faed-401f-b4c7-7c6ccb815d9d','245fbcf9-57ee-4043-9563-e0d51edd6c5b','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('67f9ed7d-9329-46d3-9452-8086f219b116','217eecd6-7c58-4691-8195-a912eda7d0a2','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('69f0243a-6481-411b-b114-f77e6057aacf','d595a97e-b4d0-45ee-b350-e61e3f416bbb','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('6ae1cfa8-8331-49dc-acbc-9722483b0ff2','e8b72750-0769-4c23-8f28-e31a4c0ff5c9','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('724fef93-4a95-4d85-a11d-c6883c9a4a54','0','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('72ac0d64-bd59-4a88-b866-0815b3ad11ea','18794149-d5bc-4969-a9ce-03fd23770f03','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('72e590da-afd0-48b8-8e08-262a3a2d23e1','94dc532f-adad-4c92-b97e-3ef003387288','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('73f7142f-3eff-439a-8347-7d2d0ef1dcfc','203a714a-1826-4234-8b6c-4bb60ba4aba2','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('7a5682ca-baab-48a3-83fd-2c7c4e4af961','a89ee76c-1578-4a85-b2b2-206439704f4b','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('7afaf767-c1d8-4d91-9922-5032a2981ca1','7eeda6e5-110a-45d7-a9f0-5495f11feb7d','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('7cc8a8e3-f5cc-4156-97b1-4ada0df39cec','4e3043ab-d4b2-4e24-ab8f-cb198154c810','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('8235932a-b27c-471f-ada7-4d8cfd0d4671','504e7d56-0fff-47e6-8c53-64ed3db71d64','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('8c3f5a10-fca5-4f96-a4fd-add8f08c71a5','d3132da1-2f27-40c8-8889-5d9fd8421dd5','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('90bce6cd-76af-48b0-8be8-ce14e18499ee','728d4ff0-13a0-466f-8319-ddc39b50a14f','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('9add0535-74b5-4ba7-a4cf-9952176b349a','94952c68-8bb4-4cf8-8a6c-ba187b53bf48','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('a69a294c-594c-4da9-a4f7-96d4fda7b469','cdf30bb6-1148-4548-ad69-becd38862f68','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('a7786947-8f1d-4cbe-8231-451753a42e9b','0d038780-760b-4771-bfd3-640b055ee148','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('a9b23718-4e94-44f3-825c-00007c117422','ef60bfd2-6b4b-46ee-8124-2514b5bab2a3','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('b218752d-5f19-4626-8008-f0d3a0eb7d34','c7dde161-6d80-494d-8bc8-9470d6c1939a','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('b6423e40-a695-4ff0-91d6-ba01202526d2','b66cfa52-6ac5-4e1b-84eb-8a47e7078184','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('bcb7e1d5-1b65-4957-b4a2-d92b4f0abe88','b545d6be-346a-4186-9b6e-0070fdd12eaf','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('be7ade40-212f-4789-9767-0ee7fe49b44e','6a9bbb88-54ef-445b-95f5-336d63b713af','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('bec13f64-c307-466f-8110-1245b56d08b3','dba3c31a-ba49-4c67-9296-4790197c3e05','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('bf0f06d6-3557-4529-87cc-fa064c8a5e4f','5cfa9e78-2954-4608-9aeb-141162de207c','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('c0c9c7cd-8b6b-4b79-a403-6676edbd3ecb','c17c747a-bbae-4fe1-8f9f-3bbc9be5afef','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('c330ac10-aecb-491c-81a5-e9f901c174d5','ea400fdf-fc86-4ce5-bfcb-7daaee1affc1','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('ce2b7155-3893-4bcf-b49b-76d874ebbebe','7a5838d2-d8a7-4559-a82e-394611a299c5','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('d0f61a80-3f56-48bd-a3cb-ce539878cba7','6f77a4c8-07dd-44f8-8bcd-7ca48cfe51c9','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('d2522816-4279-4e2a-826d-1fe180f52a65','a4c34744-a77d-4a20-b0cf-822c8953a92f','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('dbf21671-5edc-49a9-ade3-88adc141d261','35d39ba5-19b6-4a94-8976-98d987c828a6','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('dd029957-528b-4bdb-8c3d-9c8ba2a3a452','be6455cd-24e2-4499-9758-cb3ef63ff35c','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('e6bce7d2-f401-493c-9401-5720342091e3','ea771b06-3c34-4853-a767-64f56c7fd311','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('ef373608-5472-435c-9287-170fa384a504','e1422e57-4ea4-4002-8803-d6664a0ca1d5','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('f4e80ccc-d650-4909-9bb2-ce0071c6028b','0dde162b-50ac-47db-a7dd-2e6c27a50407','86d884c7-703f-49c1-a9ae-1697ac8c8515'),('f6069e99-b599-48ff-9bfd-4a6cf0585d2c','f3258a27-488c-42f1-ba20-98f461d877ca','86d884c7-703f-49c1-a9ae-1697ac8c8515');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `fs_id` varchar(255) NOT NULL,
  `fd_create_time` datetime default NULL,
  `fd_register_date` datetime default NULL,
  `fd_update_time` datetime default NULL,
  `fs_account` varchar(255) default NULL,
  `fs_description` varchar(255) default NULL,
  `fs_email` varchar(255) default NULL,
  `fs_image` longblob,
  `fs_name` varchar(255) default NULL,
  `fs_password` varchar(255) default NULL,
  `fs_phone` varchar(255) default NULL,
  `fs_status` varchar(255) default NULL,
  `fs_type_sign` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`fs_id`,`fd_create_time`,`fd_register_date`,`fd_update_time`,`fs_account`,`fs_description`,`fs_email`,`fs_image`,`fs_name`,`fs_password`,`fs_phone`,`fs_status`,`fs_type_sign`) values ('4809e79f-46ef-43ff-b39b-09a991aed8a3',NULL,NULL,NULL,'admin','超级管理员用户','1279066525@qq.com',NULL,'超级管理员','111111',NULL,'1','0'),('5a6ff9d9-7095-469a-8f6d-ae97d359c137','2015-03-16 11:05:36','2015-03-16 11:05:36',NULL,'wsAdmin',NULL,'13711708646',NULL,'wsAdmin','ws',NULL,'1','0');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `fs_id` varchar(255) NOT NULL,
  `fs_role_id` varchar(255) default NULL,
  `fs_user_id` varchar(255) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_18fxhg3nsja5t3etwaxlqopif` (`fs_role_id`),
  KEY `FK_hpwcc6lbg19yh1slqirgm9xlv` (`fs_user_id`),
  CONSTRAINT `FK_18fxhg3nsja5t3etwaxlqopif` FOREIGN KEY (`fs_role_id`) REFERENCES `sys_role` (`fs_id`),
  CONSTRAINT `FK_hpwcc6lbg19yh1slqirgm9xlv` FOREIGN KEY (`fs_user_id`) REFERENCES `sys_user` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`fs_id`,`fs_role_id`,`fs_user_id`) values ('cf1a9ea5-9efb-40f9-b290-1d7b04c7b6b6','86d884c7-703f-49c1-a9ae-1697ac8c8515','4809e79f-46ef-43ff-b39b-09a991aed8a3');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `tid` varchar(255) NOT NULL,
  `content` varchar(255) default NULL,
  `title` varchar(255) default NULL,
  PRIMARY KEY  (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

/*Table structure for table `ws_log_login` */

DROP TABLE IF EXISTS `ws_log_login`;

CREATE TABLE `ws_log_login` (
  `fs_id` varchar(36) NOT NULL,
  `fd_login_time` datetime default NULL,
  `fd_logout_time` datetime default NULL,
  `fs_ip` varchar(20) default NULL,
  `fs_user_id` varchar(36) default NULL,
  PRIMARY KEY  (`fs_id`),
  KEY `FK_ws_log_login` (`fs_user_id`),
  CONSTRAINT `FK_ws_log_login` FOREIGN KEY (`fs_user_id`) REFERENCES `sys_user` (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ws_log_login` */

insert  into `ws_log_login`(`fs_id`,`fd_login_time`,`fd_logout_time`,`fs_ip`,`fs_user_id`) values ('6829db40-50ed-437d-9d25-b1a678cfbc5d','2015-03-16 15:34:12','2015-03-16 03:34:44','127.0.0.1','5a6ff9d9-7095-469a-8f6d-ae97d359c137');

/*Table structure for table `ws_service_client` */

DROP TABLE IF EXISTS `ws_service_client`;

CREATE TABLE `ws_service_client` (
  `fs_id` varchar(36) NOT NULL,
  `fs_client_account` varchar(100) default NULL,
  `fs_client_password` varchar(100) default NULL,
  `fd_create_time` datetime default NULL,
  `fd_update_time` datetime default NULL,
  PRIMARY KEY  (`fs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ws_service_client` */

insert  into `ws_service_client`(`fs_id`,`fs_client_account`,`fs_client_password`,`fd_create_time`,`fd_update_time`) values ('1','111','111',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
