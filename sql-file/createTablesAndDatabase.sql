CREATE DATABASE IF NOT EXISTS `virb`;
USE `virb`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
	`id` 			int(11) NOT NULL AUTO_INCREMENT,
    `first_name`	varchar(50) NOT NULL,
    `last_name`		varchar(50) NOT NULL,
    `email`			varchar(50) NOT NULL,
    `password` 		varchar(20) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=LATIN1;
    
DROP TABLE IF EXISTS `website`;

CREATE TABLE `website` (
	`id` 			int(11) NOT NULL AUTO_INCREMENT,
    `site_title`	varchar(100) NOT NULL,
    `site_link`		varchar(100) NOT NULL,
    `site_category`	varchar(50)	 NOT NULL,
    `account_id`	int(11)	DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `TITLE_UNIQUE` (`site_title`), -- for site title need to be unique
    UNIQUE KEY `LINK_UNIQUE` (`site_link`), -- link need to be unique
    KEY `FK_ACCOUNT_idx` (`account_id`),
    CONSTRAINT `FK_ACCOUNT` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

