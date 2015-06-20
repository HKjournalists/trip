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

insert  into `sys_resources`(`fs_id`,`fd_create_time`,`fd_update_time`,`fs_description`,`fs_key`,`fs_name`,`fs_url`) values ('056d6790-c8f8-4360-884a-05b5dd13af49',NULL,NULL,'系统管理-用户管理-用户信息:菜单\r\n','AUTH_SYSTEM_USER_LIST','系统管理-用户管理-用户信息','/system/user/list.html'),('0be50fe5-7d5e-4a4f-9e89-e063f9f1f9ba',NULL,NULL,'系统管理-权限配置-菜单类型:菜单\r\n','AUTH_SYSTEM_MENUTYPE_LIST','系统管理-权限配置-菜单类型','/system/menutype/list.html'),('14321b9b-9d76-4767-aa11-c1bba7c4611b',NULL,NULL,'系统管理-权限配置-角色配置-新增角色:按钮\r\n','AUTH_SYSTEM_ROLE_TOADD','系统管理-权限配置-角色配置-新增角色','/system/role/toAdd.html'),('1fc33b2b-2998-4ac5-b329-fe71ef06dd85',NULL,NULL,'系统管理-权限配置-菜单管理-菜单树内容:链接\r\n','AUTH_SYSTEM_MENU_MANAGER_TREE','系统管理-权限配置-菜单管理-菜单树内容','/system/menu/manager_tree.html'),('33c4ed3f-295f-4c23-9cd6-0b8d7aa20cfa',NULL,NULL,'系统管理-左边菜单链接:子系统','AUTH_SYSTEM_MENU_LEFT','系统管理-左边菜单链接','/system/menu_left.html'),('3ce0b210-07d5-459d-8771-e45baf7969a5',NULL,NULL,'氧气旅行系统-跟框架-默认左边菜单:默认后台左边菜单','AUTH_OTRIP_LEFT','氧气旅行系统-跟框架-默认左边菜单','/otrip_left.html'),('40ff445d-bd70-4bb7-87ae-193716ac420a',NULL,NULL,'系统管理-权限配置-菜单管理-保存子菜单:按钮\r\n','AUTH_SYSTEM_MENU_SAVE_CHILD_MENU','系统管理-权限配置-菜单管理-保存子菜单','/system/menu/save_child_menu.html'),('43cbc78f-4ca5-450d-8052-291c7fb76855',NULL,NULL,'系统管理-权限配置-菜单管理-左边菜单页面:链接\r\n','AUTH_SYSTEM_MENU_MENU_MANAGER','系统管理-权限配置-菜单管理-左边菜单页面','/system/menu/menu_manager.html'),('6536ddd7-d231-4718-b4cf-cbe6f77a3180',NULL,NULL,'氧气旅行系统-跟框架-默认内容链接:默认内容页面','AUTH_OTRIP_MAIN','氧气旅行系统-跟框架-默认内容链接','/otrip_main.html'),('6a74c5cf-f1de-41a6-b236-c4b38718bd50',NULL,NULL,'系统管理-权限配置-地址配置-保存地址:按钮\r\n','AUTH_SYSTEM_REQUIREDPATH_SAVE','系统管理-权限配置-地址配置-保存地址','/system/requiredpath/save.html'),('7f15e74f-e929-4c68-ae3b-ceedcb79da77',NULL,NULL,'系统管理-权限配置-菜单管理:菜单\r\n','AUTH_SYSTEM_MENU_MANAGER','系统管理-权限配置-菜单管理','/system/menu/manager.html'),('816f7349-5488-4f32-86f2-ec9628f7b051',NULL,NULL,'系统管理-权限配置-地址配置-选择配置地址【菜单绑定】:按钮\r\n','AUTH_SYSTEM_REQUIREDPATH_SELECT_LIST','系统管理-权限配置-地址配置-选择配置地址【菜单绑定】','/system/requiredpath/select_list.html'),('88f02864-8d15-498f-8c1d-bf54916a6889',NULL,NULL,'系统管理-权限配置-菜单管理-菜单详细信息页面:链接\r\n','AUTH_SYSTEM_MENU_INCLUDE_MENU','系统管理-权限配置-菜单管理-菜单详细信息页面','/system/menu/include_menu.html'),('91a48ec6-bf59-4ec3-83a3-674a6f1b9d8c',NULL,NULL,'系统管理-权限配置-菜单管理-删除链接:链接\r\n','AUTH_SYSTEM_MENU_DELETELINK','系统管理-权限配置-菜单管理-删除链接','/system/menu/deleteLink.html'),('97baab3f-8b5d-4f65-bf17-c3482b3dd6e0',NULL,NULL,'系统管理-权限配置-角色配置:菜单\r\n','AUTH_SYSTEM_ROLE_MANAGER','系统管理-权限配置-角色配置','/system/role/manager.html'),('aafa872c-d5b7-4b2b-92c1-979649ca35dd',NULL,NULL,'系统管理-权限配置-地址配置:菜单\r\n','AUTH_SYSTEM_REQUIREDPATH_LIST','系统管理-权限配置-地址配置','/system/requiredpath/list.html'),('ac37c1b9-7c56-4a97-8257-3149c5e91cf4',NULL,NULL,'系统管理-权限配置-菜单类型-新增菜单:按钮\r\n','AUTH_SYSTEM_MENUTYPE_TOADD','系统管理-权限配置-菜单类型-新增菜单','/system/menutype/toAdd.html'),('ad1163e4-abd7-4107-b781-eaadf004da48',NULL,NULL,'','AUTH_OTRIP_TOP','氧气旅行系统-跟框架-顶部菜单','/otrip_top.html'),('b3ba8093-ad72-45c9-97d7-c3cc3d42c29f',NULL,NULL,'系统管理-权限配置-菜单管理-新增子菜单:按钮\r\n','AUTH_SYSTEM_MENU_ADD_CHILD_MENU','系统管理-权限配置-菜单管理-新增子菜单','/system/menu/add_child_menu.html'),('bd96fb20-4882-4ceb-9283-9a1b9fa83382',NULL,NULL,'系统管理-默认内容页面:链接\r\n','AUTH_SYSTEM_MAIN_CONTENT','系统管理-默认内容页面','/system/main_content.html'),('bef1c901-ffcb-4a3e-82ea-b41149b5b53c',NULL,NULL,'系统管理-权限配置-角色配置-保存角色:按钮\r\n','AUTH_SYSTEM_ROLE_SAVE','系统管理-权限配置-角色配置-保存角色','/system/role/save.html'),('c1bb6c70-aede-4093-b12e-9322f330f315',NULL,NULL,'系统管理-权限配置-菜单管理-删除子菜单:按钮\r\n','AUTH_SYSTEM_MENU_DELETE','系统管理-权限配置-菜单管理-删除子菜单','/system/menu/delete.html'),('d0254644-c4c3-488d-8be3-13e7c10e1ad5',NULL,NULL,'系统管理-权限配置-地址配置-新增地址:按钮\r\n','AUTH_SYSTEM_REQUIREDPATH_TOADD','系统管理-权限配置-地址配置-新增地址','/system/requiredpath/toAdd.html'),('e0b39040-57ee-425f-acbe-1320f31e6a27',NULL,NULL,'系统管理-权限配置-菜单类型-保存菜单:按钮\r\n','AUTH_SYSTEM_MENUTYPE_SAVE','系统管理-权限配置-菜单类型-保存菜单','/system/menutype/save.html'),('e25248c9-23ce-43b0-846e-19f7ebe501c7',NULL,NULL,'系统管理-权限配置-菜单类型-删除菜单:链接\r\n','AUTH_SYSTEM_MENUTYPE_DELETE','系统管理-权限配置-菜单类型-删除菜单','/system/menutype/delete.html'),('e5c41a59-9c53-4401-a7f9-cdc420c50c95',NULL,NULL,'系统管理-权限配置-地址配置-删除地址:链接\r\n','AUTH_SYSTEM_REQUIREDPATH_DELETE','系统管理-权限配置-地址配置-删除地址','/system/requiredpath/delete.html'),('eee1c803-4a83-4f9c-93d8-3562040121d5',NULL,NULL,'系统管理-权限配置-角色配置-删除角色:链接\r\n','AUTH_SYSTEM_ROLE_DELETE','系统管理-权限配置-角色配置-删除角色','/system/role/delete.html'),('f25854a7-cf21-41e0-a1f5-60c219523361',NULL,NULL,'氧气旅行系统-后台主页-跟框架','AUTH_OTRIP_INDEX','氧气旅行系统-跟框架','/index.html');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
