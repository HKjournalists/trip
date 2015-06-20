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

insert  into `sys_dictionary_type`(`fs_id`,`fd_create_time`,`fd_update_time`,`fs_name`,`fs_sign`,`fs_status`) values ('1583c242-7e67-41e3-bb86-22707805b750','2015-03-20 00:24:35',NULL,'用户状态','USER_STATUS','1');

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

insert  into `sys_login_history`(`fs_id`,`fd_login_time`,`fd_logout_time`,`fs_ip`,`fs_user_id`) values ('14817b06-8811-4f29-a058-a784e4eadda2','2015-03-21 17:58:13','2015-03-23 08:09:42','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('15a28b77-d5b9-4e68-b742-c3317b585293','2015-03-20 00:23:31','2015-03-20 12:28:59','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('1871f2df-a994-4584-96f9-cf370f910744','2015-03-18 22:28:24','2015-03-18 10:31:16','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('1d728207-d85c-4d39-b572-6ae522fccbb4','2015-03-18 22:52:56','2015-03-19 09:19:36','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('1d7bbfd2-10da-452a-b4b9-e6665fc3b616','2015-03-18 10:17:05','2015-03-18 10:16:20','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('2402c89e-56d4-4d01-8504-11cb1419271f','2015-03-18 22:21:33','2015-03-18 10:21:37','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('2f8b4af8-516a-481b-87fe-4c19454337fd','2015-03-11 23:31:20','2015-03-11 11:31:20','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('39e26f51-3082-4541-bbcc-0aa303aec058','2015-03-17 23:17:20','2015-03-18 10:17:05','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('51859b46-b035-414e-96b6-2b431c482d1c','2015-03-11 23:27:17','2015-03-11 11:27:18','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('551b8e60-a3d7-4a47-b7a4-0b97c03c0b4d','2015-03-18 22:22:24','2015-03-18 10:25:40','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('6157f0bf-9c7b-4878-a603-48a61a64a7aa','2015-03-17 21:58:18','2015-03-17 10:50:57','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('81201242-6ee7-4f8b-a8e6-39cc3a09c9b9','2015-03-20 00:29:07','2015-03-21 05:58:13','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('84c4b6a5-f1a2-4cff-b1c6-acfd8674dbe2','2015-03-11 23:34:03','2015-03-11 11:34:33','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('8be6bcd2-6356-444e-b104-d96d54f363d5','2015-03-18 22:25:44','2015-03-18 10:27:20','0:0:0:0:0:0:0:1','796ce704-37ea-4f48-b7d3-f0578460b2fe'),('903bfcdf-d289-423d-978d-bba0dc9a1130','2015-03-17 23:11:57','2015-03-17 11:12:09','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('93e5e53b-9bda-4599-88fb-995c2d63e964','2015-03-23 21:22:30','2015-03-23 10:34:57','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('964794cf-3e5b-4310-99eb-95e31c83c12f','2015-03-11 23:27:57','2015-03-11 11:27:57','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('9afd8e52-e62a-4cef-aec9-79b36a365421','2015-03-16 20:59:13','2015-03-17 09:58:18','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('a57bbd33-78d5-4062-8cc6-25f45315abca','2015-03-23 20:09:42','2015-03-23 09:22:30','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('aca899bb-3916-4536-accb-73dfef30c8b8','2015-03-17 22:50:57','2015-03-17 11:09:55','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('b2009f1e-5468-4399-bf07-d9cc1fd57547','2015-03-17 23:12:51','2015-03-17 11:17:14','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('b80d9a0c-d018-46d1-ae91-81ddc8ab826d','2015-03-18 22:31:20',NULL,'0:0:0:0:0:0:0:1','1859022e-41db-462e-a71b-18fd9605449c'),('c96c2eda-0c50-4689-b226-cee3855e18fc','2015-03-19 21:19:36','2015-03-19 09:37:36','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('d9c441a8-ebe5-452d-9d04-4e118cc2c8c3','2015-03-12 14:10:04','2015-03-16 08:59:13','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('dc66e831-0814-457f-b995-8c86c368a80f','2015-03-18 22:16:20','2015-03-18 10:21:25','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('fdd70408-d6ba-49da-b75e-79c72510331c','2015-03-17 23:12:19','2015-03-17 11:12:44','0:0:0:0:0:0:0:1','4809e79f-46ef-43ff-b39b-09a991aed8a3');

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

insert  into `sys_menu_auth`(`fs_id`,`fd_create_time`,`fd_update_time`,`fs_description`,`fs_name`,`fs_parent_id`,`fs_status`,`fs_menu_type`,`fs_resources_id`,`fn_order`) values ('0','2015-03-10 00:00:00','2015-03-10 00:00:00','氧气管理系统，默认跟','氧气管理系统','root','1','2b074a4f-29f3-46fa-a965-300a41f01929','a0efd601-354c-4343-aeb4-fea1918e0e55',0),('0b64157d-da80-4fbc-a772-441c603e92bd','2015-03-10 00:00:00',NULL,'系统管理-权限配置-地址配置-删除地址\r\n','删除地址','728d4ff0-13a0-466f-8319-ddc39b50a14f','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','e5c41a59-9c53-4401-a7f9-cdc420c50c95',4),('0d038780-760b-4771-bfd3-640b055ee148','2015-03-10 00:00:00',NULL,'消息提醒-消息提醒【模块】','消息提醒','f3258a27-488c-42f1-ba20-98f461d877ca','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',1),('0dde162b-50ac-47db-a7dd-2e6c27a50407','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理\r\n','菜单管理','7eeda6e5-110a-45d7-a9f0-5495f11feb7d','1','880a54dc-020c-4d04-b997-5518af7372b5','7f15e74f-e929-4c68-ae3b-ceedcb79da77',2),('12b289b2-b447-49f7-9703-32863edf8630','2015-03-10 00:00:00',NULL,'消息提醒-优惠劵领用提醒【模块】','优惠劵领用提醒','f3258a27-488c-42f1-ba20-98f461d877ca','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',3),('1771b9d2-2226-43ea-941f-9c9aa54f05a3','2015-03-10 00:00:00',NULL,'系统管理-用户管理【模块】','用户管理','49f5cf88-810c-4b56-95f4-86a2b77e2a75','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',1),('18794149-d5bc-4969-a9ce-03fd23770f03','2015-03-10 00:00:00',NULL,'系统管理-默认内容页面\r\n','系统管理默认内容页','49f5cf88-810c-4b56-95f4-86a2b77e2a75','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','bd96fb20-4882-4ceb-9283-9a1b9fa83382',2),('203a714a-1826-4234-8b6c-4bb60ba4aba2','2015-03-10 00:00:00',NULL,'系统管理-用户管理-用户信息【菜单】','用户信息','1771b9d2-2226-43ea-941f-9c9aa54f05a3','1','880a54dc-020c-4d04-b997-5518af7372b5','056d6790-c8f8-4360-884a-05b5dd13af49',1),('217eecd6-7c58-4691-8195-a912eda7d0a2','2015-03-10 00:00:00',NULL,'接机管理子系统','接机管理','0','1','172d1108-8252-4de3-9e1a-3ea96dba10e0','a0efd601-354c-4343-aeb4-fea1918e0e55',3),('245fbcf9-57ee-4043-9563-e0d51edd6c5b','2015-03-10 00:00:00',NULL,'消息提醒-问题跟踪提醒【模块】','问题跟踪提醒','f3258a27-488c-42f1-ba20-98f461d877ca','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',2),('35d39ba5-19b6-4a94-8976-98d987c828a6','2015-03-10 00:00:00',NULL,'接机管理-机场管理【模块】','机场管理','217eecd6-7c58-4691-8195-a912eda7d0a2','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',1),('46b26b8f-5006-4924-abe0-10dc0bde1b80','2015-03-10 00:00:00',NULL,'氧气旅行系统-跟框架','框架链接首页','0','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','f25854a7-cf21-41e0-a1f5-60c219523361',0),('49f5cf88-810c-4b56-95f4-86a2b77e2a75','2015-03-10 00:00:00',NULL,'系统管理子系统','系统管理','0','1','172d1108-8252-4de3-9e1a-3ea96dba10e0','a0efd601-354c-4343-aeb4-fea1918e0e55',5),('4e3043ab-d4b2-4e24-ab8f-cb198154c810','2015-03-10 00:00:00',NULL,'订单管理-旅行订单【模块】','旅行订单','dba3c31a-ba49-4c67-9296-4790197c3e05','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',1),('504e7d56-0fff-47e6-8c53-64ed3db71d64','2015-03-10 00:00:00',NULL,'系统管理-配置管理【模块】','配置管理','49f5cf88-810c-4b56-95f4-86a2b77e2a75','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',3),('591fc03a-dd61-472a-ab84-d8758a4bbbcd','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-左边菜单页面\r\n','菜单左边树页面','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','43cbc78f-4ca5-450d-8052-291c7fb76855',1),('5cfa9e78-2954-4608-9aeb-141162de207c','2015-03-10 00:00:00',NULL,'系统管理-权限配置-地址配置-保存地址\r\n','保存地址','728d4ff0-13a0-466f-8319-ddc39b50a14f','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','6a74c5cf-f1de-41a6-b236-c4b38718bd50',3),('6a9bbb88-54ef-445b-95f5-336d63b713af','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-保存子菜单\r\n','保存子菜单','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','40ff445d-bd70-4bb7-87ae-193716ac420a',5),('6ba47f2f-9acf-4893-a486-56497c3a22dc','2015-03-10 00:00:00',NULL,'系统管理-用户管理-管理用户','管理用户','1771b9d2-2226-43ea-941f-9c9aa54f05a3','1','880a54dc-020c-4d04-b997-5518af7372b5','27a75d48-37dc-4625-b7ee-6b5a8489568c',1),('6f77a4c8-07dd-44f8-8bcd-7ca48cfe51c9','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单类型\r\n','菜单类型','7eeda6e5-110a-45d7-a9f0-5495f11feb7d','1','880a54dc-020c-4d04-b997-5518af7372b5','0be50fe5-7d5e-4a4f-9e89-e063f9f1f9ba',4),('728d4ff0-13a0-466f-8319-ddc39b50a14f','2015-03-10 00:00:00',NULL,'系统管理-权限配置-地址配置\r\n','地址配置','7eeda6e5-110a-45d7-a9f0-5495f11feb7d','1','880a54dc-020c-4d04-b997-5518af7372b5','aafa872c-d5b7-4b2b-92c1-979649ca35dd',3),('7894f72b-5748-478a-944a-1e6d6b007954','2015-03-10 00:00:00',NULL,'系统管理-用户管理-旅行用户','旅行用户','1771b9d2-2226-43ea-941f-9c9aa54f05a3','1','880a54dc-020c-4d04-b997-5518af7372b5','101d8f2b-7ddd-4507-ad5a-2e2124bc40b9',2),('7a5838d2-d8a7-4559-a82e-394611a299c5','2015-03-10 00:00:00',NULL,'订单管理-订单统计【模块】','订单统计','dba3c31a-ba49-4c67-9296-4790197c3e05','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',3),('7eeda6e5-110a-45d7-a9f0-5495f11feb7d','2015-03-10 00:00:00',NULL,'系统管理-权限配置【模块】','权限配置','49f5cf88-810c-4b56-95f4-86a2b77e2a75','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',2),('94952c68-8bb4-4cf8-8a6c-ba187b53bf48','2015-03-10 00:00:00',NULL,'旅行管理子系统','旅行管理','0','1','172d1108-8252-4de3-9e1a-3ea96dba10e0','a0efd601-354c-4343-aeb4-fea1918e0e55',4),('94dc532f-adad-4c92-b97e-3ef003387288','2015-03-10 00:00:00',NULL,'系统管理-权限配置-地址配置-选择配置地址【菜单绑定】\r\n','地址选择按钮','728d4ff0-13a0-466f-8319-ddc39b50a14f','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','816f7349-5488-4f32-86f2-ec9628f7b051',1),('a1d960ef-c497-434e-80c7-46d57c592775','2015-03-10 00:00:00',NULL,'系统管理-日志管理【模块】','日志管理','49f5cf88-810c-4b56-95f4-86a2b77e2a75','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',4),('a4c34744-a77d-4a20-b0cf-822c8953a92f','2015-03-10 00:00:00',NULL,'订单管理-优惠劵管理【模块】','优惠劵管理','dba3c31a-ba49-4c67-9296-4790197c3e05','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',4),('a639c0b0-3fd6-4369-9f56-7689214c6dc0','2015-03-10 00:00:00',NULL,'系统管理-权限配置-角色配置\r\n','角色配置','7eeda6e5-110a-45d7-a9f0-5495f11feb7d','1','880a54dc-020c-4d04-b997-5518af7372b5','97baab3f-8b5d-4f65-bf17-c3482b3dd6e0',1),('a6a4dc70-0031-4174-ae5c-b7ad42655984','2015-03-10 00:00:00',NULL,'旅行管理-配置管理【模块】','配置管理','94952c68-8bb4-4cf8-8a6c-ba187b53bf48','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',4),('a89ee76c-1578-4a85-b2b2-206439704f4b','2015-03-10 00:00:00',NULL,'氧气管理系统-框架链接默认内容【链接】','框架链接默认内容页','0','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','6536ddd7-d231-4718-b4cf-cbe6f77a3180',4),('a97d3b80-00f1-4423-a3a1-92a9b268eb15','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单类型-删除菜单类型','删除菜单类型','6f77a4c8-07dd-44f8-8bcd-7ca48cfe51c9','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','e25248c9-23ce-43b0-846e-19f7ebe501c7',3),('a9dbd2df-47c8-40b9-9e8b-3a639e2f8a2c','2015-03-10 00:00:00',NULL,'旅行管理-旅行评论【模块】','旅行评论','94952c68-8bb4-4cf8-8a6c-ba187b53bf48','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',3),('b4627be9-75ad-460b-bcc8-a60d631e691d','2015-03-10 00:00:00',NULL,'接机管理-接机评论【模块】','接机评论','217eecd6-7c58-4691-8195-a912eda7d0a2','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',2),('b545d6be-346a-4186-9b6e-0070fdd12eaf','2015-03-10 00:00:00',NULL,'系统管理-权限配置-角色配置-新增角色\r\n','新增角色','a639c0b0-3fd6-4369-9f56-7689214c6dc0','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','14321b9b-9d76-4767-aa11-c1bba7c4611b',1),('b66cfa52-6ac5-4e1b-84eb-8a47e7078184','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-删除子菜单\r\n','删除子菜单','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','c1bb6c70-aede-4093-b12e-9322f330f315',6),('b7fb0843-a0ef-4b58-8bbe-45e6ac94a36a','2015-03-10 00:00:00',NULL,'订单管理-接机订单【模块】','接机订单','dba3c31a-ba49-4c67-9296-4790197c3e05','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',2),('be6455cd-24e2-4499-9758-cb3ef63ff35c','2015-03-10 00:00:00',NULL,'系统管理-权限配置-角色配置-删除角色\r\n','删除角色','a639c0b0-3fd6-4369-9f56-7689214c6dc0','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','eee1c803-4a83-4f9c-93d8-3562040121d5',3),('c17c747a-bbae-4fe1-8f9f-3bbc9be5afef','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-删除链接\r\n','删除链接','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','91a48ec6-bf59-4ec3-83a3-674a6f1b9d8c',7),('c7dde161-6d80-494d-8bc8-9470d6c1939a','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-菜单树内容\r\n','菜单树内容','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','1fc33b2b-2998-4ac5-b329-fe71ef06dd85',3),('cdf30bb6-1148-4548-ad69-becd38862f68','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-菜单详细信息页面\r\n','菜单详细信息页面','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','88f02864-8d15-498f-8c1d-bf54916a6889',2),('d3132da1-2f27-40c8-8889-5d9fd8421dd5','2015-03-10 00:00:00',NULL,'氧气旅行管理系统-框架默认左边菜单','框架默认左边菜单','0','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','3ce0b210-07d5-459d-8771-e45baf7969a5',3),('d38c1c4e-1c59-42aa-8ef4-a74482499ec3','2015-03-10 00:00:00',NULL,'系统管理-左菜单管理【链接】','左菜单管理页','49f5cf88-810c-4b56-95f4-86a2b77e2a75','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','33c4ed3f-295f-4c23-9cd6-0b8d7aa20cfa',1),('d595a97e-b4d0-45ee-b350-e61e3f416bbb','2015-03-10 00:00:00',NULL,'旅行管理-旅行活动【模块】','旅行活动','94952c68-8bb4-4cf8-8a6c-ba187b53bf48','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',1),('d90c8474-144c-467d-90a0-d6b1c2acd157','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单类型-保存菜单类型\r\n','保存菜单类型','6f77a4c8-07dd-44f8-8bcd-7ca48cfe51c9','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','e0b39040-57ee-425f-acbe-1320f31e6a27',2),('dba3c31a-ba49-4c67-9296-4790197c3e05','2015-03-10 00:00:00',NULL,'订单管理子系统','订单管理','0','1','172d1108-8252-4de3-9e1a-3ea96dba10e0','a0efd601-354c-4343-aeb4-fea1918e0e55',2),('e1422e57-4ea4-4002-8803-d6664a0ca1d5','2015-03-10 00:00:00',NULL,'系统管理-权限配置-地址配置-新增地址\r\n','新增地址','728d4ff0-13a0-466f-8319-ddc39b50a14f','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','d0254644-c4c3-488d-8be3-13e7c10e1ad5',2),('e8b72750-0769-4c23-8f28-e31a4c0ff5c9','2015-03-10 00:00:00',NULL,'氧气旅行系统-跟框架-顶部菜单\r\n','框架链接头部页','0','1','caf08ce2-b8f8-4f23-aa4a-962d0949d4d0','ad1163e4-abd7-4107-b781-eaadf004da48',1),('ea400fdf-fc86-4ce5-bfcb-7daaee1affc1','2015-03-10 00:00:00',NULL,'旅行管理-旅行统计【模块】','旅行统计','94952c68-8bb4-4cf8-8a6c-ba187b53bf48','1','6e86f1e8-b8c9-4eae-a3dc-0ff35b5f29a1','a0efd601-354c-4343-aeb4-fea1918e0e55',2),('ea771b06-3c34-4853-a767-64f56c7fd311','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-新增子菜单\r\n','新增子菜单','0dde162b-50ac-47db-a7dd-2e6c27a50407','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','b3ba8093-ad72-45c9-97d7-c3cc3d42c29f',3),('ef60bfd2-6b4b-46ee-8124-2514b5bab2a3','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单类型-新增菜单类型','新增菜单类型','6f77a4c8-07dd-44f8-8bcd-7ca48cfe51c9','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','ac37c1b9-7c56-4a97-8257-3149c5e91cf4',1),('efb70a2c-3253-447f-b33f-7a9025a6d1d1','2015-03-10 00:00:00',NULL,'系统管理-权限配置-角色配置-保存角色\r\n','保存角色','a639c0b0-3fd6-4369-9f56-7689214c6dc0','1','0efc4905-b918-4e0f-82eb-978fc18dd6a7','bef1c901-ffcb-4a3e-82ea-b41149b5b53c',2),('f3258a27-488c-42f1-ba20-98f461d877ca','2015-03-10 00:00:00',NULL,'消息提醒子系统','消息提醒','0','1','172d1108-8252-4de3-9e1a-3ea96dba10e0','a0efd601-354c-4343-aeb4-fea1918e0e55',1);

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

insert  into `sys_resources`(`fs_id`,`fd_create_time`,`fd_update_time`,`fs_description`,`fs_key`,`fs_name`,`fs_url`) values ('056d6790-c8f8-4360-884a-05b5dd13af49','2015-03-10 00:00:00',NULL,'系统管理-用户管理-用户信息:菜单\r\n','AUTH_SYSTEM_USER_LIST','系统管理-用户管理-用户信息','/system/user/list.html'),('0be50fe5-7d5e-4a4f-9e89-e063f9f1f9ba','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单类型:菜单\r\n','AUTH_SYSTEM_MENUTYPE_LIST','系统管理-权限配置-菜单类型','/system/menutype/list.html'),('101d8f2b-7ddd-4507-ad5a-2e2124bc40b9','2015-03-10 00:00:00',NULL,'系统管理-用户管理-旅行用户','AUTH_SYSTEM_TRAVEL_USER','系统管理-用户管理-旅行用户','/system/user/travel_user.html'),('14321b9b-9d76-4767-aa11-c1bba7c4611b','2015-03-10 00:00:00',NULL,'系统管理-权限配置-角色配置-新增角色:按钮\r\n','AUTH_SYSTEM_ROLE_TOADD','系统管理-权限配置-角色配置-新增角色','/system/role/toAdd.html'),('1fc33b2b-2998-4ac5-b329-fe71ef06dd85','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-菜单树内容:链接\r\n','AUTH_SYSTEM_MENU_MANAGER_TREE','系统管理-权限配置-菜单管理-菜单树内容','/system/menu/manager_tree.html'),('27a75d48-37dc-4625-b7ee-6b5a8489568c','2015-03-10 00:00:00',NULL,'系统管理-用户管理-管理用户','AUTH_SYSTEM_MANAGER_USER','系统管理-用户管理-管理用户','/system/user/manager_user.html'),('33c4ed3f-295f-4c23-9cd6-0b8d7aa20cfa','2015-03-10 00:00:00',NULL,'系统管理-左边菜单链接:子系统','AUTH_SYSTEM_MENU_LEFT','系统管理-左边菜单链接','/system/menu_left.html'),('3ce0b210-07d5-459d-8771-e45baf7969a5','2015-03-10 00:00:00',NULL,'氧气旅行系统-跟框架-默认左边菜单:默认后台左边菜单','AUTH_OTRIP_LEFT','氧气旅行系统-跟框架-默认左边菜单','/otrip_left.html'),('40ff445d-bd70-4bb7-87ae-193716ac420a','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-保存子菜单:按钮\r\n','AUTH_SYSTEM_MENU_SAVE_CHILD_MENU','系统管理-权限配置-菜单管理-保存子菜单','/system/menu/save_child_menu.html'),('43cbc78f-4ca5-450d-8052-291c7fb76855','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-左边菜单页面:链接\r\n','AUTH_SYSTEM_MENU_MENU_MANAGER','系统管理-权限配置-菜单管理-左边菜单页面','/system/menu/menu_manager.html'),('6536ddd7-d231-4718-b4cf-cbe6f77a3180','2015-03-10 00:00:00',NULL,'氧气旅行系统-跟框架-默认内容链接:默认内容页面','AUTH_OTRIP_MAIN','氧气旅行系统-跟框架-默认内容链接','/otrip_main.html'),('6a74c5cf-f1de-41a6-b236-c4b38718bd50','2015-03-10 00:00:00',NULL,'系统管理-权限配置-地址配置-保存地址:按钮\r\n','AUTH_SYSTEM_REQUIREDPATH_SAVE','系统管理-权限配置-地址配置-保存地址','/system/requiredpath/save.html'),('7f15e74f-e929-4c68-ae3b-ceedcb79da77','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理:菜单\r\n','AUTH_SYSTEM_MENU_MANAGER','系统管理-权限配置-菜单管理','/system/menu/manager.html'),('816f7349-5488-4f32-86f2-ec9628f7b051','2015-03-10 00:00:00',NULL,'系统管理-权限配置-地址配置-选择配置地址【菜单绑定】:按钮\r\n','AUTH_SYSTEM_REQUIREDPATH_SELECT_LIST','系统管理-权限配置-地址配置-选择配置地址【菜单绑定】','/system/requiredpath/select_list.html'),('88f02864-8d15-498f-8c1d-bf54916a6889','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-菜单详细信息页面:链接\r\n','AUTH_SYSTEM_MENU_INCLUDE_MENU','系统管理-权限配置-菜单管理-菜单详细信息页面','/system/menu/include_menu.html'),('91a48ec6-bf59-4ec3-83a3-674a6f1b9d8c','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-删除链接:链接\r\n','AUTH_SYSTEM_MENU_DELETELINK','系统管理-权限配置-菜单管理-删除链接','/system/menu/deleteLink.html'),('97baab3f-8b5d-4f65-bf17-c3482b3dd6e0','2015-03-10 00:00:00',NULL,'系统管理-权限配置-角色配置:菜单\r\n','AUTH_SYSTEM_ROLE_MANAGER','系统管理-权限配置-角色配置','/system/role/manager.html'),('a0efd601-354c-4343-aeb4-fea1918e0e55','2015-03-10 00:00:00',NULL,'默认空地址配置','COMMON_NULL','默认空地址配置',''),('aafa872c-d5b7-4b2b-92c1-979649ca35dd','2015-03-10 00:00:00',NULL,'系统管理-权限配置-地址配置:菜单\r\n','AUTH_SYSTEM_REQUIREDPATH_LIST','系统管理-权限配置-地址配置','/system/requiredpath/list.html'),('ac37c1b9-7c56-4a97-8257-3149c5e91cf4','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单类型-新增菜单:按钮\r\n','AUTH_SYSTEM_MENUTYPE_TOADD','系统管理-权限配置-菜单类型-新增菜单类型','/system/menutype/toAdd.html'),('ad1163e4-abd7-4107-b781-eaadf004da48','2015-03-10 00:00:00',NULL,'','AUTH_OTRIP_TOP','氧气旅行系统-跟框架-顶部菜单','/otrip_top.html'),('b3ba8093-ad72-45c9-97d7-c3cc3d42c29f','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-新增子菜单:按钮\r\n','AUTH_SYSTEM_MENU_ADD_CHILD_MENU','系统管理-权限配置-菜单管理-新增子菜单','/system/menu/add_child_menu.html'),('bd96fb20-4882-4ceb-9283-9a1b9fa83382','2015-03-10 00:00:00',NULL,'系统管理-默认内容页面:链接\r\n','AUTH_SYSTEM_MAIN_CONTENT','系统管理-默认内容页面','/system/main_content.html'),('bef1c901-ffcb-4a3e-82ea-b41149b5b53c','2015-03-10 00:00:00',NULL,'系统管理-权限配置-角色配置-保存角色:按钮\r\n','AUTH_SYSTEM_ROLE_SAVE','系统管理-权限配置-角色配置-保存角色','/system/role/save.html'),('c1bb6c70-aede-4093-b12e-9322f330f315','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单管理-删除子菜单:按钮\r\n','AUTH_SYSTEM_MENU_DELETE','系统管理-权限配置-菜单管理-删除子菜单','/system/menu/delete.html'),('d0254644-c4c3-488d-8be3-13e7c10e1ad5','2015-03-10 00:00:00',NULL,'系统管理-权限配置-地址配置-新增地址:按钮\r\n','AUTH_SYSTEM_REQUIREDPATH_TOADD','系统管理-权限配置-地址配置-新增地址','/system/requiredpath/toAdd.html'),('e0b39040-57ee-425f-acbe-1320f31e6a27','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单类型-保存菜单:按钮\r\n','AUTH_SYSTEM_MENUTYPE_SAVE','系统管理-权限配置-菜单类型-保存菜单类型','/system/menutype/save.html'),('e25248c9-23ce-43b0-846e-19f7ebe501c7','2015-03-10 00:00:00',NULL,'系统管理-权限配置-菜单类型-删除菜单:链接\r\n','AUTH_SYSTEM_MENUTYPE_DELETE','系统管理-权限配置-菜单类型-删除菜单类型','/system/menutype/delete.html'),('e5c41a59-9c53-4401-a7f9-cdc420c50c95','2015-03-10 00:00:00',NULL,'系统管理-权限配置-地址配置-删除地址:链接\r\n','AUTH_SYSTEM_REQUIREDPATH_DELETE','系统管理-权限配置-地址配置-删除地址','/system/requiredpath/delete.html'),('eee1c803-4a83-4f9c-93d8-3562040121d5','2015-03-10 00:00:00',NULL,'系统管理-权限配置-角色配置-删除角色:链接\r\n','AUTH_SYSTEM_ROLE_DELETE','系统管理-权限配置-角色配置-删除角色','/system/role/delete.html'),('f25854a7-cf21-41e0-a1f5-60c219523361','2015-03-10 00:00:00',NULL,'氧气旅行系统-后台主页-跟框架','AUTH_OTRIP_INDEX','氧气旅行系统-跟框架','/index.html');

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

insert  into `sys_role`(`fs_id`,`fd_create_time`,`fd_update_time`,`fn_order`,`fs_name`,`fs_sign`,`fs_status`,`fs_parent_id`) values ('0498d44f-7e04-4002-af0c-6c010398e229','2015-03-10 00:00:00',NULL,1,'超级管理员','ROLE_SUPER_ADMIN','1','6594cee4-c04d-4ce2-81e2-7c88b6e506ac'),('3726a08e-a3e7-456b-9309-39ec7196b481','2015-03-10 00:00:00',NULL,1,'1221','2323','1','0498d44f-7e04-4002-af0c-6c010398e229'),('6594cee4-c04d-4ce2-81e2-7c88b6e506ac','2015-03-11 00:00:00','2015-03-11 00:00:00',1,'氧气旅行系统跟角色','ROLE_ROOT','1',NULL),('66af9863-e782-403b-a346-83f913c4a128','2015-03-10 00:00:00',NULL,3,'测试管理员角色','TEST_ADMIAN_ROLE','1','0498d44f-7e04-4002-af0c-6c010398e229'),('86d884c7-703f-49c1-a9ae-1697ac8c8515','2015-03-10 00:00:00',NULL,3,'后台管理员','ROLE_BACK_AMDIN','1','0498d44f-7e04-4002-af0c-6c010398e229');

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

insert  into `sys_role_auth`(`fs_id`,`fs_menu_auth_id`,`fs_role_id`) values ('0275aa68-a2d9-41aa-b653-be8e046f77e9','c7dde161-6d80-494d-8bc8-9470d6c1939a','66af9863-e782-403b-a346-83f913c4a128'),('03d68377-4c03-44f8-843e-511a44fa2457','728d4ff0-13a0-466f-8319-ddc39b50a14f','66af9863-e782-403b-a346-83f913c4a128'),('03f5e099-125d-4b2d-b4e1-bb80c13c2f96','0d038780-760b-4771-bfd3-640b055ee148','66af9863-e782-403b-a346-83f913c4a128'),('089b1376-5a2e-4717-8cd9-61f410741da8','591fc03a-dd61-472a-ab84-d8758a4bbbcd','66af9863-e782-403b-a346-83f913c4a128'),('0e91b6b9-d6aa-42cf-a182-1a1680402258','504e7d56-0fff-47e6-8c53-64ed3db71d64','66af9863-e782-403b-a346-83f913c4a128'),('1e476fdb-43cf-4b3a-9716-5cc996687a01','b545d6be-346a-4186-9b6e-0070fdd12eaf','66af9863-e782-403b-a346-83f913c4a128'),('1e7c17f6-7dd5-4421-9267-621b4e54eb70','ea771b06-3c34-4853-a767-64f56c7fd311','66af9863-e782-403b-a346-83f913c4a128'),('30dcbd1d-9aef-44a8-be62-f0ca260b0304','be6455cd-24e2-4499-9758-cb3ef63ff35c','66af9863-e782-403b-a346-83f913c4a128'),('339834d5-ffa7-4bb7-96a4-7a58e456ad44','6f77a4c8-07dd-44f8-8bcd-7ca48cfe51c9','66af9863-e782-403b-a346-83f913c4a128'),('356173a2-11c6-4dcb-a5da-855c86136bb5','5cfa9e78-2954-4608-9aeb-141162de207c','66af9863-e782-403b-a346-83f913c4a128'),('3f499150-21bb-47b6-9df1-c5ba09e8a8ae','b7fb0843-a0ef-4b58-8bbe-45e6ac94a36a','66af9863-e782-403b-a346-83f913c4a128'),('45ad4262-58d4-4708-808d-009c121e006e','e8b72750-0769-4c23-8f28-e31a4c0ff5c9','66af9863-e782-403b-a346-83f913c4a128'),('47b717e5-5d23-4cac-b8d3-6bd226fba0a4','7894f72b-5748-478a-944a-1e6d6b007954','66af9863-e782-403b-a346-83f913c4a128'),('48b5fb29-1d15-47c8-85e2-98dd4222a508','18794149-d5bc-4969-a9ce-03fd23770f03','66af9863-e782-403b-a346-83f913c4a128'),('49b9df82-6397-405c-ac97-a40e0f1b385d','a639c0b0-3fd6-4369-9f56-7689214c6dc0','66af9863-e782-403b-a346-83f913c4a128'),('4e773511-cf6a-4cfe-9b05-419a464ab2de','e1422e57-4ea4-4002-8803-d6664a0ca1d5','66af9863-e782-403b-a346-83f913c4a128'),('4ffddfae-95d6-4e82-9f87-70581b8c8696','6a9bbb88-54ef-445b-95f5-336d63b713af','66af9863-e782-403b-a346-83f913c4a128'),('5ebbe851-4e40-4be7-85ea-308d68a8a438','94952c68-8bb4-4cf8-8a6c-ba187b53bf48','66af9863-e782-403b-a346-83f913c4a128'),('5ecb3418-38b9-4704-ab4a-15b0826ff7be','c17c747a-bbae-4fe1-8f9f-3bbc9be5afef','66af9863-e782-403b-a346-83f913c4a128'),('6428c59c-7a71-440d-8918-a1306aac0ab8','f3258a27-488c-42f1-ba20-98f461d877ca','66af9863-e782-403b-a346-83f913c4a128'),('6547a0f5-017c-4975-a68c-3fb8abc7678b','a89ee76c-1578-4a85-b2b2-206439704f4b','66af9863-e782-403b-a346-83f913c4a128'),('6c028dcf-c885-4363-9027-921d02548ab8','5cfa9e78-2954-4608-9aeb-141162de207c','3726a08e-a3e7-456b-9309-39ec7196b481'),('6d486c80-a2e9-40e9-944a-db7b6927dec3','7a5838d2-d8a7-4559-a82e-394611a299c5','66af9863-e782-403b-a346-83f913c4a128'),('730702c4-88c1-4e15-ba71-2714e3016420','245fbcf9-57ee-4043-9563-e0d51edd6c5b','66af9863-e782-403b-a346-83f913c4a128'),('74cac9ef-7bef-40a0-9c84-676d64a87674','217eecd6-7c58-4691-8195-a912eda7d0a2','66af9863-e782-403b-a346-83f913c4a128'),('75869396-6433-4605-8e92-8f008ed448b7','a6a4dc70-0031-4174-ae5c-b7ad42655984','66af9863-e782-403b-a346-83f913c4a128'),('7ba0c14c-4b7e-4294-9d5b-c38e0b51b237','6a9bbb88-54ef-445b-95f5-336d63b713af','3726a08e-a3e7-456b-9309-39ec7196b481'),('7e40d3ba-209c-4e79-8ba0-a1104fc2bc28','dba3c31a-ba49-4c67-9296-4790197c3e05','66af9863-e782-403b-a346-83f913c4a128'),('8372fba1-ddce-45b1-8a94-e627001ea57f','ef60bfd2-6b4b-46ee-8124-2514b5bab2a3','66af9863-e782-403b-a346-83f913c4a128'),('8490c528-c9a1-4a04-865b-96fc71e07d9b','0dde162b-50ac-47db-a7dd-2e6c27a50407','66af9863-e782-403b-a346-83f913c4a128'),('88434d09-ee24-45c4-929b-0142f4e2caf0','b4627be9-75ad-460b-bcc8-a60d631e691d','66af9863-e782-403b-a346-83f913c4a128'),('909a2d98-cdb5-4f7c-a3a0-5a6dfaa20531','6ba47f2f-9acf-4893-a486-56497c3a22dc','66af9863-e782-403b-a346-83f913c4a128'),('913127d5-0beb-4ddd-89db-8f64da133060','a4c34744-a77d-4a20-b0cf-822c8953a92f','66af9863-e782-403b-a346-83f913c4a128'),('93098e52-7036-481f-8e92-24b08474247c','94dc532f-adad-4c92-b97e-3ef003387288','3726a08e-a3e7-456b-9309-39ec7196b481'),('94ab38b8-76d5-4d70-ad6c-a62b6c54bf8a','1771b9d2-2226-43ea-941f-9c9aa54f05a3','66af9863-e782-403b-a346-83f913c4a128'),('985fc0a2-8e76-4ea0-af1f-077f01ce7315','7eeda6e5-110a-45d7-a9f0-5495f11feb7d','66af9863-e782-403b-a346-83f913c4a128'),('9c518776-c3d4-4000-b3db-18f8e44d5f33','ea400fdf-fc86-4ce5-bfcb-7daaee1affc1','66af9863-e782-403b-a346-83f913c4a128'),('a3d79131-b692-471a-90ca-65c986ddbb7b','35d39ba5-19b6-4a94-8976-98d987c828a6','66af9863-e782-403b-a346-83f913c4a128'),('a56bf59f-1def-4f32-a2c3-fbaa877bd2c9','d3132da1-2f27-40c8-8889-5d9fd8421dd5','66af9863-e782-403b-a346-83f913c4a128'),('a75a534b-4c46-4a71-8620-20826873e480','efb70a2c-3253-447f-b33f-7a9025a6d1d1','66af9863-e782-403b-a346-83f913c4a128'),('a8368cd5-9a0a-49c5-91bf-625bac515453','0b64157d-da80-4fbc-a772-441c603e92bd','66af9863-e782-403b-a346-83f913c4a128'),('abe5f078-1fb9-4962-a71b-df240eb0fbd5','d38c1c4e-1c59-42aa-8ef4-a74482499ec3','66af9863-e782-403b-a346-83f913c4a128'),('b76e0dba-e7b4-42e6-bca7-59d6772983a1','46b26b8f-5006-4924-abe0-10dc0bde1b80','66af9863-e782-403b-a346-83f913c4a128'),('b856f0e5-cc25-4674-adc8-5a3302e16d0b','d595a97e-b4d0-45ee-b350-e61e3f416bbb','66af9863-e782-403b-a346-83f913c4a128'),('bed43387-a57e-482e-ab9b-de3fa1d7072d','b66cfa52-6ac5-4e1b-84eb-8a47e7078184','66af9863-e782-403b-a346-83f913c4a128'),('c402c0b4-58ca-41d6-b891-51948aebde1e','94dc532f-adad-4c92-b97e-3ef003387288','66af9863-e782-403b-a346-83f913c4a128'),('ccd9c910-f8ac-427d-97af-10bc1df32ee2','a97d3b80-00f1-4423-a3a1-92a9b268eb15','66af9863-e782-403b-a346-83f913c4a128'),('d04264db-46a4-4787-ad7b-e0324bc94119','d90c8474-144c-467d-90a0-d6b1c2acd157','66af9863-e782-403b-a346-83f913c4a128'),('d216a382-2fb1-465d-a317-bca6f20c54a7','12b289b2-b447-49f7-9703-32863edf8630','66af9863-e782-403b-a346-83f913c4a128'),('d95fb632-09fa-48ee-a25e-b73038c4be29','a9dbd2df-47c8-40b9-9e8b-3a639e2f8a2c','66af9863-e782-403b-a346-83f913c4a128'),('e56736c6-3aec-4f9a-876e-d92dcb8a708a','203a714a-1826-4234-8b6c-4bb60ba4aba2','66af9863-e782-403b-a346-83f913c4a128'),('eeba5cd2-fff3-4820-918e-b22e6e9f06ce','4e3043ab-d4b2-4e24-ab8f-cb198154c810','66af9863-e782-403b-a346-83f913c4a128'),('f0ca8854-eb71-4543-83ae-bb228830a971','0','66af9863-e782-403b-a346-83f913c4a128'),('f6753c20-dc4f-461b-ab21-faa23e2c1c01','49f5cf88-810c-4b56-95f4-86a2b77e2a75','66af9863-e782-403b-a346-83f913c4a128'),('fa19e92a-f58b-466e-abfa-3e8634399c1b','cdf30bb6-1148-4548-ad69-becd38862f68','66af9863-e782-403b-a346-83f913c4a128'),('fc686ec9-d65c-42ea-b942-47fb549029af','a1d960ef-c497-434e-80c7-46d57c592775','66af9863-e782-403b-a346-83f913c4a128');

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

insert  into `sys_user`(`fs_id`,`fd_create_time`,`fd_register_date`,`fd_update_time`,`fs_account`,`fs_description`,`fs_email`,`fs_image`,`fs_name`,`fs_password`,`fs_phone`,`fs_status`,`fs_type_sign`) values ('1859022e-41db-462e-a71b-18fd9605449c',NULL,NULL,NULL,'44','44','44',NULL,'44','44','44','1','0'),('4809e79f-46ef-43ff-b39b-09a991aed8a3',NULL,NULL,NULL,'admin','超级管理员用户','1279066525@qq.com',NULL,'超级管理员','111111','2222','1','0'),('5a6ff9d9-7095-469a-8f6d-ae97d359c137','2015-03-16 11:05:36','2015-03-16 11:05:36',NULL,'wsAdmin',NULL,'13711708646@qq.com',NULL,'wsAdmin','ws','11111','1','1'),('796ce704-37ea-4f48-b7d3-f0578460b2fe',NULL,NULL,NULL,'22','11','11',NULL,'11','22','1','1','0'),('d348e684-3c99-4d68-a37e-6cb00977ddce','2015-03-22 20:50:28','2015-03-22 20:50:28',NULL,'12311456@.com',NULL,'12311456@.com',NULL,'12311456@.com','ws11456',NULL,'1','1');

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

insert  into `sys_user_role`(`fs_id`,`fs_role_id`,`fs_user_id`) values ('6aeb84cc-846d-4644-a695-7ed27ee7198c','66af9863-e782-403b-a346-83f913c4a128','1859022e-41db-462e-a71b-18fd9605449c'),('6d9903c4-eca7-497b-8e9f-c13600ae8b96','0498d44f-7e04-4002-af0c-6c010398e229','796ce704-37ea-4f48-b7d3-f0578460b2fe'),('a1ab8ad3-aa97-4522-8dcb-3fdc386ddcd5','86d884c7-703f-49c1-a9ae-1697ac8c8515','1859022e-41db-462e-a71b-18fd9605449c'),('b98a9a38-924d-471e-8aed-5661f6872bae','0498d44f-7e04-4002-af0c-6c010398e229','1859022e-41db-462e-a71b-18fd9605449c'),('cf1a9ea5-9efb-40f9-b290-1d7b04c7b6b6','66af9863-e782-403b-a346-83f913c4a128','4809e79f-46ef-43ff-b39b-09a991aed8a3'),('d40e42f2-8e20-4747-9f3b-117aec5005b9','3726a08e-a3e7-456b-9309-39ec7196b481','1859022e-41db-462e-a71b-18fd9605449c');

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

insert  into `ws_log_login`(`fs_id`,`fd_login_time`,`fd_logout_time`,`fs_ip`,`fs_user_id`) values ('6829db40-50ed-437d-9d25-b1a678cfbc5d','2015-03-16 15:34:12','2015-03-16 03:34:44','127.0.0.1','5a6ff9d9-7095-469a-8f6d-ae97d359c137'),('878b3375-5035-45b5-80f4-dfe1b12ad5d1','2015-03-22 23:15:32','2015-03-22 11:16:27','127.0.0.1','d348e684-3c99-4d68-a37e-6cb00977ddce'),('98fed1e0-e379-4cb0-aaeb-5817adc97cf2','2015-03-22 23:05:59','2015-03-22 11:09:10','0:0:0:0:0:0:0:1','d348e684-3c99-4d68-a37e-6cb00977ddce');

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

insert  into `ws_service_client`(`fs_id`,`fs_client_account`,`fs_client_password`,`fd_create_time`,`fd_update_time`) values ('1','111','111','2015-03-10 00:00:00',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
