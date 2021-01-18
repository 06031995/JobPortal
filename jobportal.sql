/*
SQLyog Trial v13.1.5  (64 bit)
MySQL - 10.1.38-MariaDB : Database - jobportal
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jobportal` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `jobportal`;

/*Table structure for table `admin_login` */

DROP TABLE IF EXISTS `admin_login`;

CREATE TABLE `admin_login` (
  `login_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `admin_login` */

insert  into `admin_login`(`login_id`,`email`,`password`) values 
(1,'patil@123','123');

/*Table structure for table `applied_job` */

DROP TABLE IF EXISTS `applied_job`;

CREATE TABLE `applied_job` (
  `applied_job_id` int(11) NOT NULL,
  `applied_active` int(11) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `cv_id` int(11) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`applied_job_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `applied_job` */

insert  into `applied_job`(`applied_job_id`,`applied_active`,`company_name`,`cv_id`,`date`,`student_id`) values 
(1,1,'dffg',1,'2020-11-05',8);

/*Table structure for table `capital` */

DROP TABLE IF EXISTS `capital`;

CREATE TABLE `capital` (
  `capital_id` int(11) NOT NULL,
  `Capital_Name` varchar(255) DEFAULT NULL,
  `Capital_Population` varchar(255) DEFAULT NULL,
  `pDetail_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`capital_id`),
  KEY `FKabl8yv1vukp6gfsvik5aihbcj` (`pDetail_FK`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `capital` */

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `country_id` int(11) NOT NULL,
  `countryPopulation` varchar(255) DEFAULT NULL,
  `country_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `country` */

/*Table structure for table `create_vacancy` */

DROP TABLE IF EXISTS `create_vacancy`;

CREATE TABLE `create_vacancy` (
  `cv_id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `cv_active` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `employment_type` varchar(255) DEFAULT NULL,
  `function_area` varchar(255) DEFAULT NULL,
  `industry_type` varchar(255) DEFAULT NULL,
  `job_desc` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `required_skill` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `vacancy` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `year_of_exp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cv_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `create_vacancy` */

insert  into `create_vacancy`(`cv_id`,`address`,`company_name`,`created_by`,`created_date`,`cv_active`,`education`,`employment_type`,`function_area`,`industry_type`,`job_desc`,`location`,`post`,`required_skill`,`role`,`salary`,`updated_date`,`vacancy`,`website`,`year_of_exp`) values 
(1,'dfg','dffg','Megha','2020-10-23 14:35:28','1','dfg','dfg','fdg','dfg','dfg','fdfg','java','dfg','dfg','dfg','2020-10-23 14:35:28','dfg','fdg','fdgf');

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(24),
(24),
(24),
(24);

/*Table structure for table `principle_profile` */

DROP TABLE IF EXISTS `principle_profile`;

CREATE TABLE `principle_profile` (
  `principle_id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `college_code` varchar(255) DEFAULT NULL,
  `college_name` varchar(255) DEFAULT NULL,
  `college_ph` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `principle_name` varchar(255) DEFAULT NULL,
  `principle_ph` int(11) DEFAULT NULL,
  PRIMARY KEY (`principle_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `principle_profile` */

insert  into `principle_profile`(`principle_id`,`address`,`college_code`,`college_name`,`college_ph`,`email`,`principle_name`,`principle_ph`) values 
(14,'Pune','1209','college','020-9873','megha19karampuri@gmail.com','megha',992922),
(23,'pune','1256','Rahul Patil','020-9873','karampurimegha@gmail.com','megha',99299);

/*Table structure for table `principle_register` */

DROP TABLE IF EXISTS `principle_register`;

CREATE TABLE `principle_register` (
  `principle_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `resetToken` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`principle_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `principle_register` */

insert  into `principle_register`(`principle_id`,`email`,`name`,`password`,`resetToken`) values 
(22,'karampurimegha@gmail.com','4545','megha',NULL),
(11,'megha19karampuri@gmail.com','1290','megha',NULL);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `certifications` varchar(255) DEFAULT NULL,
  `clg_name_10` varchar(255) DEFAULT NULL,
  `clg_name_12` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `exp_years` varchar(255) DEFAULT NULL,
  `f_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `key_skills` varchar(255) DEFAULT NULL,
  `l_name` varchar(255) DEFAULT NULL,
  `last_ctc` varchar(255) DEFAULT NULL,
  `last_org` varchar(255) DEFAULT NULL,
  `m_name` varchar(255) DEFAULT NULL,
  `notice_period` varchar(255) DEFAULT NULL,
  `passing_yr_10` varchar(255) DEFAULT NULL,
  `passing_yr_12` varchar(255) DEFAULT NULL,
  `passing_yr_degree` varchar(255) DEFAULT NULL,
  `percent_10` varchar(255) DEFAULT NULL,
  `percent_12` varchar(255) DEFAULT NULL,
  `percent_degree` varchar(255) DEFAULT NULL,
  `projects` varchar(255) DEFAULT NULL,
  `student_active` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`student_id`,`address`,`certifications`,`clg_name_10`,`clg_name_12`,`contact_no`,`degree`,`dob`,`email_id`,`exp_years`,`f_name`,`gender`,`key_skills`,`l_name`,`last_ctc`,`last_org`,`m_name`,`notice_period`,`passing_yr_10`,`passing_yr_12`,`passing_yr_degree`,`percent_10`,`percent_12`,`percent_degree`,`projects`,`student_active`,`user_id`) values 
(8,'pune','java','school','college','9922279101','MCA','1997-12-09','karampurimegha@gmail.com','NA','megha','Female','java','karampuri','NA','NA','A','NA','2019','2019','2018','80','80','80','EPR','1',6),
(17,'sdf','java','dsf','sdf','8909786789','MCA','2020-11-06','patil3948@gmail.com','NA','Rahul','Male','java','Patil','NA','NA','v','NA','2020','2020','2010','fs','sdf','sdf','EPR','1',15);

/*Table structure for table `token` */

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token` (
  `token_id` int(11) NOT NULL,
  `authenticationToken` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `secretKey` varchar(255) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`token_id`),
  UNIQUE KEY `UK_o7c3le3un7644xbmnl4wg8e22` (`u_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `token` */

insert  into `token`(`token_id`,`authenticationToken`,`email_id`,`secretKey`,`u_id`) values 
(7,'eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJrYXJhbXB1cmltZWdoYUBnbWFpbC5jb20iLCJpYXQiOjE2MDUwMDY1NDAsInN1YiI6IkpXVCBUb2tlbiIsImlzcyI6IkphdmFUcG9pbnQiLCJleHAiOjE2MDUwNDk3NDB9.AwgIdBE4NTXAmNCLdsrikQE_LjuvlSH-QrSHeu7sDsQ','karampurimegha@gmail.com','karampurimegha@gmail.com525',6),
(12,'eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJtZWdoYTE5a2FyYW1wdXJpQGdtYWlsLmNvbSIsImlhdCI6MTYwNDkzMzI5MSwic3ViIjoiSldUIFRva2VuIiwiaXNzIjoiSmF2YVRwb2ludCIsImV4cCI6MTYwNDk3NjQ5MX0.qp-3Qskizb_7HDPH_ILF0kUdmxEiuq4QyMewIIHmB4g','megha19karampuri@gmail.com','megha19karampuri@gmail.com606',11),
(16,'eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJwYXRpbDM5NDhAZ21haWwuY29tIiwiaWF0IjoxNjA0OTM3MzcwLCJzdWIiOiJKV1QgVG9rZW4iLCJpc3MiOiJKYXZhVHBvaW50IiwiZXhwIjoxNjA0OTgwNTcwfQ.PY8J1F9HZi6SfUhy4wJjbX8kQgZGFZc5cpR2fs8RSzg','patil3948@gmail.com','patil3948@gmail.com751',15);

/*Table structure for table `user_register` */

DROP TABLE IF EXISTS `user_register`;

CREATE TABLE `user_register` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `resetToken` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `user_register` */

insert  into `user_register`(`user_id`,`email`,`name`,`password`,`resetToken`) values 
(6,'karampurimegha@gmail.com','megha','megha',NULL),
(15,'patil3948@gmail.com','rahul','123',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
