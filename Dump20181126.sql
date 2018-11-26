-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: libreria
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assegnazione`
--

DROP TABLE IF EXISTS `assegnazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assegnazione` (
  `IDUtente` int(11) NOT NULL,
  `IDPagina` int(11) NOT NULL,
  KEY `AssegnazioneUtente` (`IDUtente`),
  KEY `AssegnazionePagina` (`IDPagina`),
  CONSTRAINT `AssegnazionePagina` FOREIGN KEY (`IDPagina`) REFERENCES `pagina` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `AssegnazioneUtente` FOREIGN KEY (`IDUtente`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assegnazione`
--

LOCK TABLES `assegnazione` WRITE;
/*!40000 ALTER TABLE `assegnazione` DISABLE KEYS */;
/*!40000 ALTER TABLE `assegnazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consente`
--

DROP TABLE IF EXISTS `consente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `consente` (
  `IDRuolo` int(11) NOT NULL,
  `IDPermessi` int(11) NOT NULL,
  KEY `RuoloConsente` (`IDRuolo`),
  KEY `PermessiConsente` (`IDPermessi`),
  CONSTRAINT `PermessiConsente` FOREIGN KEY (`IDPermessi`) REFERENCES `permessi` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `RuoloConsente` FOREIGN KEY (`IDRuolo`) REFERENCES `ruolo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consente`
--

LOCK TABLES `consente` WRITE;
/*!40000 ALTER TABLE `consente` DISABLE KEYS */;
INSERT INTO `consente` VALUES (2,4),(3,4),(4,4),(5,4),(6,4),(7,4),(7,1),(7,2),(7,3),(7,5),(7,6),(2,5),(4,6),(3,5),(3,3),(5,2),(5,6),(1,4);
/*!40000 ALTER TABLE `consente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `infotrascrizioni`
--

DROP TABLE IF EXISTS `infotrascrizioni`;
/*!50001 DROP VIEW IF EXISTS `infotrascrizioni`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `infotrascrizioni` AS SELECT 
 1 AS `id`,
 1 AS `scanpath`,
 1 AS `testo`,
 1 AS `annotazioni`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `manoscritto`
--

DROP TABLE IF EXISTS `manoscritto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `manoscritto` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Pubblicato` tinyint(1) DEFAULT '0',
  `Anno` int(11) DEFAULT NULL,
  `Secolo` int(11) NOT NULL,
  `Titolo` varchar(50) DEFAULT NULL,
  `Autore` varchar(50) DEFAULT NULL,
  `Genere` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manoscritto`
--

LOCK TABLES `manoscritto` WRITE;
/*!40000 ALTER TABLE `manoscritto` DISABLE KEYS */;
INSERT INTO `manoscritto` VALUES (1,0,NULL,14,'Divina Commedia','Dante Alighieri',NULL),(2,0,NULL,10,'prova','Marco Autili',NULL);
/*!40000 ALTER TABLE `manoscritto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagina`
--

DROP TABLE IF EXISTS `pagina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pagina` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Numero` int(11) NOT NULL,
  `Manoscritto` int(11) NOT NULL,
  `Accettato` tinyint(1) NOT NULL DEFAULT '0',
  `Scanpath` varchar(100) NOT NULL,
  `Trascrizione` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_2` (`ID`,`Manoscritto`),
  UNIQUE KEY `ID` (`ID`,`Trascrizione`),
  KEY `PaginaManoscritto` (`Manoscritto`),
  KEY `PaginaTrascrizione` (`Trascrizione`),
  CONSTRAINT `PaginaManoscritto` FOREIGN KEY (`Manoscritto`) REFERENCES `manoscritto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `PaginaTrascrizione` FOREIGN KEY (`Trascrizione`) REFERENCES `trascrizione` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagina`
--

LOCK TABLES `pagina` WRITE;
/*!40000 ALTER TABLE `pagina` DISABLE KEYS */;
INSERT INTO `pagina` VALUES (34,1,1,0,'/C:/Users/Andrea/Desktop/pagina.jpg',52);
/*!40000 ALTER TABLE `pagina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `pagineassegnate`
--

DROP TABLE IF EXISTS `pagineassegnate`;
/*!50001 DROP VIEW IF EXISTS `pagineassegnate`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `pagineassegnate` AS SELECT 
 1 AS `id`,
 1 AS `scanpath`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `permessi`
--

DROP TABLE IF EXISTS `permessi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `permessi` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permessi`
--

LOCK TABLES `permessi` WRITE;
/*!40000 ALTER TABLE `permessi` DISABLE KEYS */;
INSERT INTO `permessi` VALUES (1,'Modifica Back-End'),(2,'Accetta Trascrizioni'),(3,'Accetta Upload'),(4,'Visualizza profilo'),(5,'Carica Upload'),(6,'Carica Trascrizioni');
/*!40000 ALTER TABLE `permessi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruolo`
--

DROP TABLE IF EXISTS `ruolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ruolo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruolo`
--

LOCK TABLES `ruolo` WRITE;
/*!40000 ALTER TABLE `ruolo` DISABLE KEYS */;
INSERT INTO `ruolo` VALUES (1,'Utente'),(2,'Uploader'),(3,'RevisoreUpload'),(4,'Trascrittore'),(5,'RevisoreTrascrizioni'),(6,'CapoTrascrittore'),(7,'Amministratore');
/*!40000 ALTER TABLE `ruolo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story`
--

DROP TABLE IF EXISTS `story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `story` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDUtente1` int(11) NOT NULL,
  `IDPagina` int(11) DEFAULT NULL,
  `IDUtente2` int(11) DEFAULT NULL,
  `Descrizione` text,
  `Tipologia` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `StoryUtente` (`IDUtente1`),
  KEY `StoryPagina` (`IDPagina`),
  KEY `StoryUtente2` (`IDUtente2`),
  CONSTRAINT `StoryPagina` FOREIGN KEY (`IDPagina`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `StoryUtente` FOREIGN KEY (`IDUtente1`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `StoryUtente2` FOREIGN KEY (`IDUtente2`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story`
--

LOCK TABLES `story` WRITE;
/*!40000 ALTER TABLE `story` DISABLE KEYS */;
INSERT INTO `story` VALUES (1,0,NULL,NULL,' si è registrato!',0),(3,0,NULL,NULL,' ha inserito una nuova pagina!',1),(4,0,0,NULL,' è stata assegnata la pagina ',2),(5,0,NULL,NULL,'La trascrizione è stata accettata!',3),(18,0,NULL,NULL,' ha inserito una nuova pagina!',1),(23,0,NULL,NULL,' ha inserito una nuova pagina!',1),(24,0,NULL,NULL,' ha inserito una nuova pagina!',1),(25,0,NULL,NULL,' ha inserito una nuova pagina!',1),(26,0,NULL,NULL,' ha inserito una nuova pagina!',1),(27,0,NULL,NULL,' ha inserito una nuova pagina!',1),(34,0,NULL,NULL,' ha inserito una nuova pagina!',1),(35,0,NULL,NULL,' ha inserito una nuova pagina!',1),(36,0,NULL,NULL,' ha inserito una nuova pagina!',1);
/*!40000 ALTER TABLE `story` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trascrizione`
--

DROP TABLE IF EXISTS `trascrizione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trascrizione` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `testo` varchar(255) NOT NULL DEFAULT '0',
  `annotazioni` text,
  `accettato` tinyint(1) NOT NULL DEFAULT '0',
  `IDUtente` int(11) DEFAULT NULL,
  `pagina` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDUtente` (`IDUtente`),
  CONSTRAINT `trascrizione_ibfk_1` FOREIGN KEY (`IDUtente`) REFERENCES `utente` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trascrizione`
--

LOCK TABLES `trascrizione` WRITE;
/*!40000 ALTER TABLE `trascrizione` DISABLE KEYS */;
INSERT INTO `trascrizione` VALUES (0,'Trascrizione non disponibile',NULL,1,NULL,NULL),(50,'La morte non è niente','La morte non è niente     Ti prego Dio funziona',0,27,34),(51,'Ok ho cambiato','Ok ho cambiato  ma questo è un disastro',0,27,34),(52,'La morte non è niente     Ti prego Dio funziona',NULL,1,27,34);
/*!40000 ALTER TABLE `trascrizione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `trascrizioniutente`
--

DROP TABLE IF EXISTS `trascrizioniutente`;
/*!50001 DROP VIEW IF EXISTS `trascrizioniutente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `trascrizioniutente` AS SELECT 
 1 AS `testo`,
 1 AS `annotazioni`,
 1 AS `pagina`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utente` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(50) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `TitoloDiStudio` varchar(50) DEFAULT NULL,
  `Professione` varchar(50) DEFAULT NULL,
  `Ruolo` int(11) NOT NULL DEFAULT '1',
  `LivelloTrascrittore` int(11) NOT NULL DEFAULT '0',
  `CanDownload` tinyint(1) NOT NULL DEFAULT '0',
  `RichiestaTrascrittore` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email` (`Email`),
  KEY `UtenteRuolo` (`Ruolo`),
  CONSTRAINT `UtenteRuolo` FOREIGN KEY (`Ruolo`) REFERENCES `ruolo` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (0,'qualcuno@qualcuno.com','qualcuno','pass',NULL,NULL,1,0,0,0),(27,'dangeloandrea14@gmail.com','Utente','pass','liceo','studente',4,0,0,0),(28,'ddd','Susanna','pass','sss','scema',1,0,0,0);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'libreria'
--

--
-- Dumping routines for database 'libreria'
--

--
-- Final view structure for view `infotrascrizioni`
--

/*!50001 DROP VIEW IF EXISTS `infotrascrizioni`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `infotrascrizioni` AS select `pagineassegnate`.`id` AS `id`,`pagineassegnate`.`scanpath` AS `scanpath`,`trascrizioniutente`.`testo` AS `testo`,`trascrizioniutente`.`annotazioni` AS `annotazioni` from (`pagineassegnate` left join `trascrizioniutente` on((`pagineassegnate`.`id` = `trascrizioniutente`.`pagina`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pagineassegnate`
--

/*!50001 DROP VIEW IF EXISTS `pagineassegnate`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pagineassegnate` AS select `p`.`ID` AS `id`,`p`.`Scanpath` AS `scanpath` from ((`pagina` `p` join `assegnazione` `a`) join `utente` `u`) where ((`a`.`IDUtente` = 27) and (`p`.`ID` = `a`.`IDPagina`) and (`u`.`ID` = `a`.`IDUtente`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `trascrizioniutente`
--

/*!50001 DROP VIEW IF EXISTS `trascrizioniutente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `trascrizioniutente` AS select `t`.`testo` AS `testo`,`t`.`annotazioni` AS `annotazioni`,`t`.`pagina` AS `pagina` from (`trascrizione` `t` join `utente` `u`) where ((`t`.`IDUtente` = `u`.`ID`) and (`u`.`ID` = 27)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-26 18:04:52
