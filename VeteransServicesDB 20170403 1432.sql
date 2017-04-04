-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.17-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema veteransservices
--

CREATE DATABASE IF NOT EXISTS veteransservices;
USE veteransservices;

--
-- Definition of table `planofstudy`
--

DROP TABLE IF EXISTS `planofstudy`;
CREATE TABLE `planofstudy` (
  `studentid` varchar(9) NOT NULL,
  `coursenumber` varchar(6) NOT NULL,
  `coursename` varchar(50) NOT NULL,
  `passed` tinyint(1) NOT NULL,
  KEY `FK_student` (`studentid`),
  CONSTRAINT `FK_student` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `planofstudy`
--

/*!40000 ALTER TABLE `planofstudy` DISABLE KEYS */;
/*!40000 ALTER TABLE `planofstudy` ENABLE KEYS */;


--
-- Definition of table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentid` varchar(9) NOT NULL,
  `firstname` varchar(15) NOT NULL,
  `lastname` varchar(15) NOT NULL,
  `ssn` varchar(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(2) NOT NULL,
  `zipcode` int(11) NOT NULL,
  `gpa` float NOT NULL,
  `hoursenrolled` tinyint(4) NOT NULL,
  `repeating` tinyint(1) NOT NULL,
  `major` varchar(25) NOT NULL DEFAULT 'Undeclared',
  `tuitionandfees` float NOT NULL,
  `veteranbenefits` tinyint(1) NOT NULL,
  `dependentbenefits` tinyint(1) NOT NULL,
  `disabilitybenefirts` tinyint(1) NOT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


--
-- Definition of table `studentrecords`
--

DROP TABLE IF EXISTS `studentrecords`;
CREATE TABLE `studentrecords` (
  `studentid` varchar(9) NOT NULL,
  `certificateofeligibility` longblob NOT NULL,
  `statementofunderstanding` longblob NOT NULL,
  `classregistration` longblob NOT NULL,
  `transcript` longblob NOT NULL,
  `specialforms` longblob NOT NULL,
  `appeals` longblob NOT NULL,
  `studentinteractions` longblob NOT NULL,
  KEY `FK_student_1` (`studentid`),
  CONSTRAINT `FK_student_1` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `studentrecords`
--

/*!40000 ALTER TABLE `studentrecords` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentrecords` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
