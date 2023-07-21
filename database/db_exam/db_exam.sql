-- MySQL dump 10.13  Distrib 5.5.21, for Win32 (x86)
--
-- Host: localhost    Database: db_exam
-- ------------------------------------------------------
-- Server version	5.5.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_grade`
--

DROP TABLE IF EXISTS `tb_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_grade` (
  `id` int(11) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `radioResult` int(11) NOT NULL,
  `fullResule` int(11) NOT NULL,
  `esitResult` int(11) NOT NULL,
  `readResult` int(11) NOT NULL,
  `batsisResult` int(11) NOT NULL,
  `date` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_grade`
--

LOCK TABLES `tb_grade` WRITE;
/*!40000 ALTER TABLE `tb_grade` DISABLE KEYS */;
INSERT INTO `tb_grade` VALUES (1,'bbb',20,0,30,0,50,'2011-01-20 14:30:44'),(10,'ls',15,0,10,0,25,'2011-01-20 14:38:16'),(11,'abc',10,0,20,0,30,'2011-01-20 14:49:29'),(12,'zk',20,0,30,0,50,'2011-01-20 14:59:44'),(13,'yezi',15,0,20,20,55,'2013-05-20 23:36:05');
/*!40000 ALTER TABLE `tb_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_question`
--

DROP TABLE IF EXISTS `tb_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeid` int(11) NOT NULL,
  `q_subject` varchar(400) NOT NULL,
  `q_answer` varchar(400) NOT NULL,
  `optionA` varchar(400) NOT NULL,
  `optionB` varchar(400) NOT NULL,
  `optionC` varchar(400) NOT NULL,
  `optionD` varchar(400) NOT NULL,
  `note` varchar(400) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_question`
--

LOCK TABLES `tb_question` WRITE;
/*!40000 ALTER TABLE `tb_question` DISABLE KEYS */;
INSERT INTO `tb_question` VALUES (1,1,'widows是什么','B','应用程序','操作系统','软件','以上都不对','无'),(2,1,'下面哪个属于数据库语句','A','SELECT语句','ad','ab','dfa','无'),(3,3,'Java语言是面向对象的程序设计语言','正确','','','','','无'),(4,1,'下面哪个不属于Java基本数据类型','A','String类型','int类型','char类型','boolean类型','无'),(5,2,'WWW正确解释是？','A,B,C,D','全球网','万维网','World Wide Web的缩写','以上叙述全部正确','无'),(6,3,'数据库命名后就不能修改了','错误','','','','','无'),(7,1,'下面哪个不属于企业管理器的功能','D','注册服务器','配置本地和远程服务器','引入和导出数据','为Windows创建操作系统用户','无'),(8,4,'英语的英文','A','Eglish','aa','bb','cc','无'),(9,4,'中国的首都','A','北京','a','b','c','无'),(20,4,'熊猫的故乡','A','中国','a','b','c','无'),(10,3,'String是基本数据类型吗？','错误','','','','','无'),(11,3,'数组的下标是从“1”开始的','错误','','','','','无'),(12,3,'SQl的意思是结构化查询','正确','','','','','无'),(13,2,'Internet提供的基本服务有哪些？','A,B,D','E-mail','FTP','Telnet','WWW','无'),(14,3,'数组的下标是从“0”开始的','正确','','','','','无'),(15,1,'数组的下标是从几开始的？','A','0','1','2','3','无'),(16,2,'下面哪个属于Java基本数据类型','A,B,C','int','float','double','enum','无'),(17,4,'下面哪个不属于Java基本数据类型','A','String类型','int类型','char类型','boolean类型','无'),(18,4,'WWW正确解释是？','A','全球网','万维网','World Wide Web的缩写','以上叙述全部正确','无'),(19,4,'下面哪个属于数据库语句','A','delete语句','b','c','d','无');
/*!40000 ALTER TABLE `tb_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_questiontype`
--

DROP TABLE IF EXISTS `tb_questiontype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_questiontype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_questiontype`
--

LOCK TABLES `tb_questiontype` WRITE;
/*!40000 ALTER TABLE `tb_questiontype` DISABLE KEYS */;
INSERT INTO `tb_questiontype` VALUES (1,'单选题'),(2,'多选题'),(3,'判断题'),(4,'阅读题');
/*!40000 ALTER TABLE `tb_questiontype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_stat`
--

DROP TABLE IF EXISTS `tb_stat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_stat` (
  `id` int(11) NOT NULL,
  `radio_BL` int(11) NOT NULL,
  `more_BL` int(11) NOT NULL,
  `judge_BL` int(11) NOT NULL,
  `read_BL` int(11) NOT NULL,
  `radio_FS` int(11) NOT NULL,
  `more_FS` int(11) NOT NULL,
  `judge_FS` int(11) NOT NULL,
  `read_FS` int(11) NOT NULL,
  `exam_time` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stat`
--

LOCK TABLES `tb_stat` WRITE;
/*!40000 ALTER TABLE `tb_stat` DISABLE KEYS */;
INSERT INTO `tb_stat` VALUES (1,30,30,20,20,5,10,10,10,20);
/*!40000 ALTER TABLE `tb_stat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userType` int(11) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `passWord` varchar(220) NOT NULL,
  `havaIn` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,0,'bbb','BCBE3365E6AC95EA2C0343A2395834DD',1),(2,1,'aaa','698D51A19D8A121CE581499D7B701668',1),(3,0,'tsoft','698D51A19D8A121CE581499D7B701668',1),(4,1,'mr','FDB390E945559E74475ED8C8BBB48CA5',1),(5,1,'zzk','5DE7FBD4186F39F6CCBBD13AE8C16C3F',1),(6,0,'zhangjing','A10F4B7E48419178177232D2D31DC4B8',1),(7,0,'zhd','897D517000A3CE543C7422CF84B505F0',1),(8,0,'zx','698D51A19D8A121CE581499D7B701668',1),(9,0,'lvshuang','698D51A19D8A121CE581499D7B701668',1),(10,0,'ls','698D51A19D8A121CE581499D7B701668',1),(11,0,'abc','698D51A19D8A121CE581499D7B701668',1),(12,0,'zk','698D51A19D8A121CE581499D7B701668',1),(13,0,'yezi','E10ADC3949BA59ABBE56E057F20F883E',0);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-21 14:09:46
