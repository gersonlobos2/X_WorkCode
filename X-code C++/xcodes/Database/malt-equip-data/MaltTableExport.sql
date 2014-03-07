-- phpMyAdmin SQL Dump
-- version 3.2.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 08, 2010 at 03:58 PM
-- Server version: 5.1.44
-- PHP Version: 5.3.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `BeerProducts`
--

-- --------------------------------------------------------

--
-- Table structure for table `MaltTable`
--

CREATE TABLE `MaltTable` (
  `P_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Product ID#',
  `MaltName` mediumtext NOT NULL COMMENT 'Malt name',
  `Country` mediumtext NOT NULL COMMENT 'Country',
  `ColorL` float NOT NULL DEFAULT '10.5' COMMENT 'Lovibond color',
  `Price` float unsigned NOT NULL DEFAULT '3.99' COMMENT 'Price per unit',
  PRIMARY KEY (`P_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COMMENT='Malt Primary Table' AUTO_INCREMENT=51 ;

--
-- Dumping data for table `MaltTable`
--

INSERT INTO `MaltTable` VALUES(1, 'Munich', 'Canada', 146, 10.5);
INSERT INTO `MaltTable` VALUES(2, 'Pale', 'USA', 114, 1.5);
INSERT INTO `MaltTable` VALUES(3, 'Marris Otter', 'England', 11, 9.5);
INSERT INTO `MaltTable` VALUES(4, 'Flaked Oats', 'England', 112, 6.5);
INSERT INTO `MaltTable` VALUES(5, 'Aromatic', 'Germany', 22, 5.5);
INSERT INTO `MaltTable` VALUES(6, 'Chocolate', 'Canada', 19, 10.5);
INSERT INTO `MaltTable` VALUES(7, 'CaraMunich', 'England', 82, 4.5);
INSERT INTO `MaltTable` VALUES(8, 'Crystal 80', 'Canada', 100, 8.5);
INSERT INTO `MaltTable` VALUES(9, 'Special B', 'England', 38, 8.5);
INSERT INTO `MaltTable` VALUES(10, 'Chocolate', 'England', 102, 7.5);
INSERT INTO `MaltTable` VALUES(11, 'Coffee', 'Belgium', 88, 6.5);
INSERT INTO `MaltTable` VALUES(12, 'Munich', 'Belgium', 109, 1.5);
INSERT INTO `MaltTable` VALUES(13, 'Flaked Barley', 'Canada', 135, 8.5);
INSERT INTO `MaltTable` VALUES(14, 'Crystal 20', 'Germany', 86, 6.5);
INSERT INTO `MaltTable` VALUES(15, 'Munich', 'Canada', 69, 5.5);
INSERT INTO `MaltTable` VALUES(16, 'Flaked Oats', 'Germany', 169, 4.5);
INSERT INTO `MaltTable` VALUES(17, 'Crystal 20', 'Belgium', 135, 10.5);
INSERT INTO `MaltTable` VALUES(18, 'Flaked Barley', 'England', 19, 6.5);
INSERT INTO `MaltTable` VALUES(19, 'Flaked Barley', 'England', 179, 1.5);
INSERT INTO `MaltTable` VALUES(20, 'Flaked Oats', 'USA', 177, 3.5);
INSERT INTO `MaltTable` VALUES(21, 'Lager', 'USA', 130, 7.5);
INSERT INTO `MaltTable` VALUES(22, 'Flaked Oats', 'Germany', 158, 4.5);
INSERT INTO `MaltTable` VALUES(23, 'Melanoidin', 'Germany', 163, 3.5);
INSERT INTO `MaltTable` VALUES(24, 'Wheat', 'England', 112, 1.5);
INSERT INTO `MaltTable` VALUES(25, 'Smoked', 'Germany', 178, 4.5);
INSERT INTO `MaltTable` VALUES(26, 'Flaked Barley', 'Germany', 97, 5.5);
INSERT INTO `MaltTable` VALUES(27, 'Vienna', 'Belgium', 165, 9.5);
INSERT INTO `MaltTable` VALUES(28, 'Crystal 20', 'England', 70, 9.5);
INSERT INTO `MaltTable` VALUES(29, 'Crystal 80', 'USA', 81, 8.5);
INSERT INTO `MaltTable` VALUES(30, 'Flaked Oats', 'Canada', 169, 3.5);
INSERT INTO `MaltTable` VALUES(31, 'Chocolate', 'Germany', 21, 5.5);
INSERT INTO `MaltTable` VALUES(32, 'Crystal 60', 'Belgium', 179, 3.5);
INSERT INTO `MaltTable` VALUES(33, 'Flaked Oats', 'Canada', 80, 9.5);
INSERT INTO `MaltTable` VALUES(34, 'Flaked Barley', 'England', 123, 7.5);
INSERT INTO `MaltTable` VALUES(35, 'CaraMunich', 'USA', 79, 1.5);
INSERT INTO `MaltTable` VALUES(36, 'Wheat', 'England', 171, 4.5);
INSERT INTO `MaltTable` VALUES(37, 'Pilsner', 'Canada', 148, 3.5);
INSERT INTO `MaltTable` VALUES(38, 'Lager', 'Belgium', 88, 7.5);
INSERT INTO `MaltTable` VALUES(39, 'Flaked Oats', 'Germany', 106, 1.5);
INSERT INTO `MaltTable` VALUES(40, 'Marris Otter', 'Germany', 175, 4.5);
INSERT INTO `MaltTable` VALUES(41, 'Pale', 'Germany', 103, 2.5);
INSERT INTO `MaltTable` VALUES(42, 'Wheat', 'Belgium', 126, 8.5);
INSERT INTO `MaltTable` VALUES(43, 'Pilsner', 'USA', 4, 6.5);
INSERT INTO `MaltTable` VALUES(44, 'Smoked', 'Belgium', 29, 2.5);
INSERT INTO `MaltTable` VALUES(45, 'Biscuit', 'Germany', 118, 9.5);
INSERT INTO `MaltTable` VALUES(46, 'Melanoidin', 'Belgium', 21, 3.5);
INSERT INTO `MaltTable` VALUES(47, 'Lager', 'USA', 11, 3.5);
INSERT INTO `MaltTable` VALUES(48, 'Chocolate', 'Belgium', 138, 4.5);
INSERT INTO `MaltTable` VALUES(49, 'Coffee', 'Belgium', 141, 3.5);
INSERT INTO `MaltTable` VALUES(50, 'Biscuit', 'England', 20, 7.5);
