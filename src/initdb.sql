-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- Mysql Version:                6.2 CE
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for AIRBUSCONTROLLER_2012010869
CREATE DATABASE IF NOT EXISTS `AIRBUSCONTROLLER_2012010869` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `AIRBUSCONTROLLER_2012010869`;


-- Dumping structure for table AIRBUSCONTROLLER_2012010869.bus
CREATE TABLE IF NOT EXISTS `bus` (
  `BUS_ID` varchar(4) NOT NULL,
  `BUS_NO` varchar(10) NOT NULL,
  `LINE_ID` char(3) NOT NULL,
  `BUS_DATE` datetime NOT NULL,
  `TOTAL_SEAT` int(3) NOT NULL,
  `AVAILABLE_SEAT` int(3) NOT NULL,
  PRIMARY KEY (`BUS_ID`),
  KEY `FK_BUS_line` (`LINE_ID`),
  CONSTRAINT `FK_BUS_line` FOREIGN KEY (`LINE_ID`) REFERENCES `line` (`LINE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table AIRBUSCONTROLLER_2012010869.bus: ~3 rows (approximately)
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT INTO `bus` (`BUS_ID`, `BUS_NO`, `LINE_ID`, `BUS_DATE`, `TOTAL_SEAT`, `AVAILABLE_SEAT`) VALUES
	('0001', '001', '001', '2015-01-10 22:02:00', 50, 50),
	('0002', '001', '101', '2015-01-10 22:00:04', 50, 50),
	('0003', '002', '002', '2015-01-10 21:04:17', 50, 50);
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;


-- Dumping structure for table AIRBUSCONTROLLER_2012010869.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `CUS_ID` varchar(45) NOT NULL,
  `CUS_FNAME` varchar(45) DEFAULT NULL,
  `CUS_LNAME` varchar(45) DEFAULT NULL,
  `CUS_PHONE` varchar(45) DEFAULT NULL,
  `CUS_PASSPORT` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CUS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table AIRBUSCONTROLLER_2012010869.customer: ~2 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`CUS_ID`, `CUS_FNAME`, `CUS_LNAME`, `CUS_PHONE`, `CUS_PASSPORT`) VALUES
	('110108199201233869', 'SW', 'C', '13911932438', 'cswcsw'),
	('110221199511203929', 'XQ', 'Z', '18611002738', 'zxq1120');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


-- Dumping structure for table AIRBUSCONTROLLER_2012010869.line
CREATE TABLE IF NOT EXISTS `line` (
  `LINE_ID` char(3) NOT NULL,
  `LINE_NAME` varchar(45) DEFAULT NULL,
  `LINE_TYPE` varchar(45) DEFAULT NULL,
  `START_TIME` time DEFAULT NULL,
  `END_TIME` time DEFAULT NULL,
  PRIMARY KEY (`LINE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table AIRBUSCONTROLLER_2012010869.line: ~6 rows (approximately)
/*!40000 ALTER TABLE `line` DISABLE KEYS */;
INSERT INTO `line` (`LINE_ID`, `LINE_NAME`, `LINE_TYPE`, `START_TIME`, `END_TIME`) VALUES
	('001', 'FANGZHUANGXIAN', 'TOAIRPORT', '05:00:00', '21:00:00'),
	('002', 'XIDANXIAN', 'TOAIRPORT', '05:00:00', '21:00:00'),
	('003', 'BEIJINGZHANXIAN', 'TOAIRPORT', '05:00:00', '21:00:00'),
	('004', 'GONGZHUFENXIAN', 'TOAIRPORT', '05:00:00', '21:00:00'),
	('101', 'FANGZHUANGXIAN', 'TOCITY', '05:00:00', '22:30:00'),
	('102', 'BEIJINGZHANXIAN', 'TOCITY', '05:00:00', '22:30:00');
/*!40000 ALTER TABLE `line` ENABLE KEYS */;


-- Dumping structure for table AIRBUSCONTROLLER_2012010869.payment
CREATE TABLE IF NOT EXISTS `payment` (
  `PAYMENT_ID` varchar(50) NOT NULL,
  `PAYMENT_PRICE` int(3) NOT NULL,
  `PAYMENT_DATE` datetime NOT NULL,
  `CARD_NUM` varchar(50) NOT NULL,
  `CUS_ID` varchar(45) NOT NULL,
  `ROUTE_ID` varchar(3) NOT NULL,
  `BUS_ID` varchar(4) NOT NULL,
  PRIMARY KEY (`PAYMENT_ID`),
  KEY `FK_payment_station` (`ROUTE_ID`),
  KEY `FK_payment_bus` (`BUS_ID`),
  KEY `FK_payment_customer` (`CUS_ID`),
  CONSTRAINT `FK_payment_bus` FOREIGN KEY (`BUS_ID`) REFERENCES `bus` (`BUS_ID`),
  CONSTRAINT `FK_payment_customer` FOREIGN KEY (`CUS_ID`) REFERENCES `customer` (`CUS_ID`),
  CONSTRAINT `FK_payment_station` FOREIGN KEY (`ROUTE_ID`) REFERENCES `route` (`ROUTE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table AIRBUSCONTROLLER_2012010869.payment: ~0 rows (approximately)
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;


-- Dumping structure for table AIRBUSCONTROLLER_2012010869.route
CREATE TABLE IF NOT EXISTS `route` (
  `ROUTE_ID` varchar(3) NOT NULL,
  `STATION_NAME` varchar(45) NOT NULL,
  `LINE_ID` char(3) NOT NULL,
  `PRICE` int(3) NOT NULL,
  PRIMARY KEY (`ROUTE_ID`),
  KEY `FK_station_line` (`LINE_ID`),
  CONSTRAINT `FK_station_line` FOREIGN KEY (`LINE_ID`) REFERENCES `line` (`LINE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table AIRBUSCONTROLLER_2012010869.route: ~3 rows (approximately)
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` (`ROUTE_ID`, `STATION_NAME`, `LINE_ID`, `PRICE`) VALUES
	('001', 'FANGZHUANG', '001', 32),
	('002', 'SANYUANQIAO', '101', 30),
	('101', 'FANGZHUANG', '101', 32);
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;