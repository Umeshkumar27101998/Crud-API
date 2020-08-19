create database UmeshKumar_Crud;

use Umesh_Crud;

CREATE TABLE `UmeshKumar_Invoice` (
`user_id` varchar(100) NOT NULL,
`amount` int NOT NULL,
`name` varchar(100) NOT NULL,
`mobile_no` varchar(100) NOT NULL,
`created_at` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00',
`updated_at` TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW(),
PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
