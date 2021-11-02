-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Nov 02, 2021 alle 20:30
-- Versione del server: 10.3.29-MariaDB
-- Versione PHP: 7.3.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ingdelweb`
--
CREATE DATABASE IF NOT EXISTS `ingdelweb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ingdelweb`;

-- --------------------------------------------------------

--
-- Struttura della tabella `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `IDAdmin` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) NOT NULL,
  `Cognome` varchar(100) NOT NULL,
  `CreateDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `UpdateDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `User` int(10) UNSIGNED NOT NULL COMMENT 'chiave esterna',
  PRIMARY KEY (`IDAdmin`),
  KEY `User` (`User`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `admin`
--

INSERT INTO `admin` (`IDAdmin`, `Nome`, `Cognome`, `CreateDate`, `UpdateDate`, `User`) VALUES
(1, 'Alessandro', 'Mattei', '2018-08-23 07:16:52', '2018-08-23 07:16:52', 2),
(2, 'Stefano', 'Decina', '2019-05-14 15:32:45', '2019-05-14 15:32:45', 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `azienda`
--

DROP TABLE IF EXISTS `azienda`;
CREATE TABLE IF NOT EXISTS `azienda` (
  `IDAzienda` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `RagioneSociale` varchar(100) NOT NULL,
  `IndirizzoSedeLegale` varchar(100) NOT NULL,
  `CFiscalePIva` varchar(50) NOT NULL,
  `NomeLegaleRappresentante` varchar(50) NOT NULL,
  `CognomeLegaleRappresentante` varchar(100) NOT NULL,
  `NomeResponsabileConvenzione` varchar(50) DEFAULT NULL,
  `CognomeResponsabileConvenzione` varchar(50) DEFAULT NULL,
  `TelefonoResponsabileConvenzione` varchar(20) DEFAULT NULL,
  `EmailResponsabileConvenzione` varchar(100) DEFAULT NULL,
  `PathPDFConvenzione` varchar(100) DEFAULT NULL,
  `DurataConvenzione` int(10) UNSIGNED DEFAULT NULL,
  `ForoControversia` varchar(500) DEFAULT NULL,
  `DataConvenzione` date DEFAULT NULL,
  `Attivo` int(2) NOT NULL DEFAULT 0,
  `ModuloConvenzione` tinyint(1) NOT NULL DEFAULT 0,
  `Descrizione` text DEFAULT NULL,
  `Link` varchar(500) DEFAULT NULL,
  `Voti` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'Numero di voti dai all''azienda',
  `Valutazione` decimal(3,2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT 'Media dei voti, da 1 a 5',
  `CreateDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `UpdateDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `User` int(11) UNSIGNED NOT NULL COMMENT 'chiave esterna',
  PRIMARY KEY (`IDAzienda`),
  KEY `User` (`User`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `azienda`
--

INSERT INTO `azienda` (`IDAzienda`, `RagioneSociale`, `IndirizzoSedeLegale`, `CFiscalePIva`, `NomeLegaleRappresentante`, `CognomeLegaleRappresentante`, `NomeResponsabileConvenzione`, `CognomeResponsabileConvenzione`, `TelefonoResponsabileConvenzione`, `EmailResponsabileConvenzione`, `PathPDFConvenzione`, `DurataConvenzione`, `ForoControversia`, `DataConvenzione`, `Attivo`, `ModuloConvenzione`, `Descrizione`, `Link`, `Voti`, `Valutazione`, `CreateDate`, `UpdateDate`, `User`) VALUES
(1, 'Mario LAzienda', 'via Roma', 'qwertyuiop123654', 'Mario', 'L&apos;Azienda', 'Mariolone', 'L\'Azienda', '3332221114', 'mariolone@gmail.com', 'Modulo Convenzione.pdf', 5, 'via Mazzini, 23 Opi ', '2019-06-18', 1, 1, NULL, NULL, 1, '3.00', '2019-05-14 15:39:39', '2019-06-18 10:42:13', 4),
(2, 'Il Paradiso della brugola', 'via milano 23 Milano', '12345hjkj', 'Giovanni ', 'Storti', 'Giacomo ', 'Poretti', '121121212112', 'aldobaglio@gmail.it', 'convenzione.pdf', 5, 'via Aranzulla, 36', '2019-06-18', 1, 1, NULL, NULL, 0, '0.00', '2019-05-15 08:35:53', '2019-06-18 10:10:22', 5),
(3, 'Piastrelle Vittorio S.p.a', 'Via roma 3, ROMA', '1312j312j3b12j3b', 'Vittorio', 'marchetti', 'Vittorio', 'Marchetti', '123457893478', 'vittorio@gmail.it', 'convenzione.pdf', 13, 'via roma', '2019-06-18', 1, 1, NULL, NULL, 1, '2.00', '2019-06-18 07:47:42', '2019-06-18 11:03:31', 10);

-- --------------------------------------------------------

--
-- Struttura della tabella `offertatirocinio`
--

DROP TABLE IF EXISTS `offertatirocinio`;
CREATE TABLE IF NOT EXISTS `offertatirocinio` (
  `IDOffertaTirocinio` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `LuogoEffettuazione` varchar(100) NOT NULL,
  `Titolo` varchar(100) NOT NULL,
  `DescrizioneBreve` text NOT NULL,
  `Descrizione` text NOT NULL,
  `Orari` varchar(50) NOT NULL,
  `DurataOre` int(10) UNSIGNED NOT NULL,
  `DurataMesi` int(10) UNSIGNED NOT NULL,
  `PeriodoInizio` date NOT NULL,
  `PeriodoFine` date NOT NULL,
  `Stato` int(2) NOT NULL DEFAULT 0 COMMENT '0: Non attivo 1: Attivo',
  `Modalita` text NOT NULL,
  `Obbiettivi` text NOT NULL,
  `Rimborsi` text DEFAULT NULL,
  `Facilitazioni` text DEFAULT NULL,
  `AziendaOspitante` varchar(100) NOT NULL,
  `CodIdentTirocinio` varchar(20) NOT NULL COMMENT 'Codice supposto interno universitario',
  `SettoreInserimento` text NOT NULL,
  `TempoAccessoLocaliAziendali` text NOT NULL,
  `NomeTutoreAziendale` varchar(100) NOT NULL,
  `CognomeTutoreAziendale` varchar(100) NOT NULL,
  `TelefonoTutoreAziendale` varchar(100) NOT NULL,
  `EmailTutoreAziendale` varchar(100) NOT NULL,
  `CreateDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `UpdateDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Azienda` int(11) UNSIGNED NOT NULL COMMENT 'chiave esterna',
  PRIMARY KEY (`IDOffertaTirocinio`),
  KEY `Azienda` (`Azienda`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `offertatirocinio`
--

INSERT INTO `offertatirocinio` (`IDOffertaTirocinio`, `LuogoEffettuazione`, `Titolo`, `DescrizioneBreve`, `Descrizione`, `Orari`, `DurataOre`, `DurataMesi`, `PeriodoInizio`, `PeriodoFine`, `Stato`, `Modalita`, `Obbiettivi`, `Rimborsi`, `Facilitazioni`, `AziendaOspitante`, `CodIdentTirocinio`, `SettoreInserimento`, `TempoAccessoLocaliAziendali`, `NomeTutoreAziendale`, `CognomeTutoreAziendale`, `TelefonoTutoreAziendale`, `EmailTutoreAziendale`, `CreateDate`, `UpdateDate`, `Azienda`) VALUES
(1, 'Pescasseroli', 'Lavoro Stage Idraulico presso Mario L&apos;Azienda', ' Lo stage consiste nel riparare tubature, sostituire cartucce dei miscelatori e lavori vari nel campo dell&apos;idraulica. La durata prevista del Tutoraggio &egrave; di 6 mesi. ', ' Lo stage consiste nel riparare tubature e sostituire cartucce dei miscelatori.\r\nLavorazioni impianti di riscaldamento pavimentale.\r\nLavorazione impianti di riscaldamento tradizionali.\r\nLavorazioni varie e generali nel campo dell&apos;idraulica.\r\nLa durata prevista del Tutoraggio &egrave; di 6 mesi.\r\nPer maggiori informazioni contattate l&apos;azienda. ', 'Dalle 8:00 alle 16:00, orario continuato', 50, 6, '2019-05-31', '2019-11-30', 0, 'Lavorazione in un team', ' Svolgere le mansioni assegnata dal Master Team ', 'Rimborso spese per il vitto', 'Nessuna', 'Mario LAzienda', 'SM51', 'Manutenzione Idraulica', 'N/D', 'Mario', 'Bross', '33322211155', 'mario@gmail.it', '2019-05-15 08:41:23', '2020-11-02 08:04:00', 1),
(2, 'Azienda MuroSpa', 'Lavoro Muratore', 'Lavoro nei cantieri edili', 'Lavoro nei cantieri edili con cazzuola per tamponature e betoniera. Guidare mezzi edili e movimento terra.', 'Dalle 8:00 alle 16:00, orario continuato', 8, 6, '2019-06-01', '2019-12-01', 0, 'Lavorazione in un team', 'Apprendere l&apos;uso degli utensili edili', 'Rimborso spese per il vitto', 'Nessuna', 'Mario LAzienda', 'SM52', 'Manutenzione Edile', 'N/D', 'Mario', 'Bross', '666777888999', 'super@gmail.it', '2019-05-15 15:01:11', '2020-11-02 08:03:58', 1),
(3, 'L&apos;Aquila', 'Piastrellista', ' Aiuto messa a terra delle piastrelle dei bagni e delle cucine. ', ' Il tirocinio consiste nell&apos;aiutare il piastrellista alla messa a terra delle piastrelle dei bagni e delle cucine nei cantieri presi in appalto. ', 'Dalle 8:00 alle 16:00, orario continuato', 150, 3, '2019-06-30', '2019-09-30', 0, 'Cooperazione con il piastrellista', ' Raggiungere una buona esperienza nel montaggio delle piastrelle ', 'Rimborso spese per il vitto', 'Nessuna', 'Piastrelle Vittorio S.p.a', 'SM48', 'Montaggio piastrelle', 'N/D', 'Piero', 'Narducci', '3336664448', 'pieronarducci@gmail.it', '2019-06-18 09:58:17', '2020-11-02 08:03:58', 3),
(4, 'Pescara', 'Tubbista', 'Istallazione sistemi idrico abitativo', 'Il tirocinio consiste nell&apos;aiutare il mastro nell&apos;istallazione e montaggio di tubi.', 'Dalle 8:00 alle 16:00, orario continuato', 150, 3, '2019-07-01', '2019-10-01', 0, 'Cooperazione con il mastro', 'Apprendere l&apos;arte dei tubi', 'Rimborso spese per il vitto', 'Nessuna', 'Piastrelle Vittorio S.p.a', 'SM55', 'Manutenzione Idraulica', 'N/D', 'Mario', 'Bross', '3336664442', 'mariob@gmail.it', '2019-06-18 10:54:04', '2020-11-02 08:03:59', 3),
(5, 'Avezzano', 'Web Administrator', ' Gestione sito web aziendale ', ' gestione e mantenimento sito web aziendale ', 'Dalle 8:00 alle 16:00, orario continuato', 150, 3, '2019-08-01', '2019-11-01', 0, 'Lavorazione in un team', ' Imparare come amministrare un sito web ', 'Rimborso spese per il vitto', 'Nessuna', 'Piastrelle Vittorio S.p.a', 'SM56', 'Informatica', 'N/D', 'Mario', 'Bross', '345236548', 'mariob@gmail.it', '2019-06-18 10:57:38', '2020-11-02 08:03:59', 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `tirocinante`
--

DROP TABLE IF EXISTS `tirocinante`;
CREATE TABLE IF NOT EXISTS `tirocinante` (
  `IDTirocinante` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) NOT NULL,
  `Cognome` varchar(100) NOT NULL,
  `LuogoDiNascita` text NOT NULL,
  `DataDiNascita` date NOT NULL,
  `LuogoDiResidenza` text NOT NULL,
  `ProvinciaDiResidenza` varchar(100) NOT NULL,
  `ProvinciaDiNascita` varchar(50) NOT NULL,
  `CodiceFiscale` varchar(100) NOT NULL,
  `Telefono` varchar(50) NOT NULL,
  `CorsoDiLaurea` text DEFAULT NULL,
  `DiplomaUniversitario` text DEFAULT NULL,
  `Laureato` text DEFAULT NULL,
  `DottoratoDiRicerca` text DEFAULT NULL,
  `ScuolaAltro` text DEFAULT NULL,
  `Handicap` tinyint(1) NOT NULL DEFAULT 0,
  `CreateDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `UpdateDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `User` int(10) UNSIGNED NOT NULL COMMENT 'chiave esterna',
  PRIMARY KEY (`IDTirocinante`),
  KEY `User` (`User`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `tirocinante`
--

INSERT INTO `tirocinante` (`IDTirocinante`, `Nome`, `Cognome`, `LuogoDiNascita`, `DataDiNascita`, `LuogoDiResidenza`, `ProvinciaDiResidenza`, `ProvinciaDiNascita`, `CodiceFiscale`, `Telefono`, `CorsoDiLaurea`, `DiplomaUniversitario`, `Laureato`, `DottoratoDiRicerca`, `ScuolaAltro`, `Handicap`, `CreateDate`, `UpdateDate`, `User`) VALUES
(1, 'Luigi', 'Bross', 'A\'vezzano', '1996-03-25', 'L\'Aquila', 'AQ', 'AQ', 'HNNSTH95E26A515M', '333-6668887', 'Informatica', NULL, NULL, NULL, NULL, 0, '2019-05-15 09:05:33', '2019-06-17 14:24:15', 6),
(3, 'Giovanni', 'Storti', 'L\'Aquila', '2000-09-25', 'L\'Aquila', 'AQ', 'AQ', '456fffddd636548r', '999-8884445', 'Economia', NULL, NULL, NULL, NULL, 0, '2019-05-15 12:17:55', '2019-06-18 08:17:21', 7),
(4, 'Luca', 'Bianchi', 'Roma', '1995-02-02', 'Via tiburtina 1 Roma ', 'RO', 'Ro', '1234567891234567', '1234567891', NULL, 'Geometra', 'Informatica', 'Ingegneria del Software', NULL, 0, '2019-05-15 12:22:44', '2019-05-15 12:22:44', 8),
(20, 'Marco', 'Rossi', 'Roma', '1990-06-22', 'Via roma, Roma', 'RM', 'RM', 'qwd3e123h12', '111111111111', 'Medicina', NULL, NULL, NULL, NULL, 0, '2019-06-18 07:38:17', '2019-06-18 07:38:17', 9),
(23, 'Marco', 'Rovazzi', 'Roma', '1990-07-28', 'Via rossi, ROMA', 'RM', 'RM', 'wefweroifjwie3', '11121212121212', NULL, 'medicina', NULL, NULL, NULL, 0, '2019-06-18 08:37:41', '2019-06-18 08:37:41', 11),
(25, 'Antonio', 'lo.svelto', 'ROMA', '1990-06-13', 'via roma 3 Roma', 'RM', 'RM', 'dwuifbuiwbe32', '11222334455', 'ing ', NULL, NULL, NULL, NULL, 0, '2019-06-18 08:52:09', '2019-06-18 09:10:51', 12),
(26, 'Barack', 'Obama', 'Roma', '1980-03-05', 'Milano', 'MI', 'RO', '123456789', '123456789', NULL, 'Giurisprudenza', NULL, 'Diritto romano', NULL, 0, '2019-06-18 09:20:25', '2019-06-18 09:20:25', 13),
(27, 'Francesco', 'Totti', 'Roma', '1990-07-05', 'Via roma 4, Roma', 'RM', 'RM', '23jb4k23b4b23', '2234234234', NULL, NULL, NULL, NULL, 'Terza media', 0, '2019-06-18 10:03:12', '2019-06-18 10:03:12', 14),
(28, 'Lino', 'Coppa', 'Avezzano', '1991-03-28', 'Avezzano', 'AQ', 'AQ', 'gvdhvhnvjv7874cc', '3332288745', 'Informatica', NULL, NULL, NULL, NULL, 0, '2019-06-18 10:14:05', '2019-06-18 10:14:05', 15),
(29, 'Umberto', 'Rulli', 'Pescara', '1992-03-10', 'Pescara', 'PE', 'PE', 'sdvbybfvbjas84v4f', '3336665558', 'Informatica', NULL, NULL, NULL, NULL, 0, '2019-06-18 12:30:18', '2019-06-18 12:30:18', 16);

-- --------------------------------------------------------

--
-- Struttura della tabella `tirocinio`
--

DROP TABLE IF EXISTS `tirocinio`;
CREATE TABLE IF NOT EXISTS `tirocinio` (
  `IDTirocinio` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `DataConsegnaModuloRichiesta` date DEFAULT NULL,
  `DurataOre` int(11) UNSIGNED NOT NULL,
  `CFU` int(11) NOT NULL,
  `Stato` int(11) NOT NULL DEFAULT 0 COMMENT '0: invio richiesta, 1: richiesta accettata, 2: fine tirocinio, 3: Segreteria dichiara la conclusione amministrativa, 4: Votazione effettuata, 5: richiesta rifiutata',
  `PeriodoEffettivoIniziale` date DEFAULT NULL,
  `PeriodoEffettivoFinale` date DEFAULT NULL,
  `RisultatoConseguito` text DEFAULT NULL,
  `DescrizioneAttivitaSvolta` text DEFAULT NULL,
  `PdfTirocinante` varchar(50) DEFAULT NULL,
  `PdfAzienda` varchar(50) DEFAULT NULL,
  `DataConsegnaModuloAzienda` date DEFAULT NULL,
  `PdfSegreteria` varchar(50) DEFAULT NULL,
  `DataConsegnaModuloSegreteria` date DEFAULT NULL,
  `DataColloquioSegreteria` date DEFAULT NULL,
  `EsitoTirocinio` text DEFAULT NULL,
  `CreditiRiconosciuti` int(11) DEFAULT NULL,
  `CreateDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `UpdateDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `OffertaTirocinio` int(11) UNSIGNED NOT NULL COMMENT 'Chiave esterna della tabella offertatirocinio',
  `Tirocinante` int(11) UNSIGNED NOT NULL COMMENT 'Chiave esterna della tabella tirocinante',
  `TutoreUniversitario` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`IDTirocinio`),
  KEY `TutoreUniversitario` (`TutoreUniversitario`),
  KEY `OffertaTirocionio` (`OffertaTirocinio`) USING BTREE,
  KEY `Tirocinante` (`Tirocinante`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `tirocinio`
--

INSERT INTO `tirocinio` (`IDTirocinio`, `DataConsegnaModuloRichiesta`, `DurataOre`, `CFU`, `Stato`, `PeriodoEffettivoIniziale`, `PeriodoEffettivoFinale`, `RisultatoConseguito`, `DescrizioneAttivitaSvolta`, `PdfTirocinante`, `PdfAzienda`, `DataConsegnaModuloAzienda`, `PdfSegreteria`, `DataConsegnaModuloSegreteria`, `DataColloquioSegreteria`, `EsitoTirocinio`, `CreditiRiconosciuti`, `CreateDate`, `UpdateDate`, `OffertaTirocinio`, `Tirocinante`, `TutoreUniversitario`) VALUES
(1, NULL, 50, 3, 1, '2019-05-30', '2019-11-29', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-05-15 12:39:27', '2019-05-15 12:50:12', 1, 3, 2),
(3, '2019-05-15', 50, 6, 4, '2019-05-28', '2019-11-27', 'Ha svolto tutte le mansioni nel migliore dei modi', 'Il ragazzo ha svolto i compiti assegnati bene', 'Richiesta Tirocinio.pdf', 'Modulo Tirocinio.pdf', '2019-05-15', 'Crea Modulo.pdf', '2019-05-15', '2019-05-14', 'Positivo', 6, '2019-05-15 13:29:34', '2019-05-15 13:29:34', 1, 1, 2),
(5, NULL, 50, 6, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-05-15 15:35:39', '2019-05-15 15:35:39', 1, 1, 3),
(15, NULL, 50, 4, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-06-17 15:07:12', '2019-06-17 15:07:12', 1, 4, 3),
(17, NULL, 50, 6, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-06-18 08:33:38', '2019-06-18 08:33:38', 1, 20, 3),
(18, NULL, 50, 6, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-06-18 08:40:27', '2019-06-18 15:09:34', 1, 23, 4),
(21, '2019-06-19', 50, 6, 2, '2019-05-29', '2019-11-28', 'hj', 'ghjh', 'convenzione.pdf', 'convenzione.pdf', '2019-06-19', NULL, NULL, NULL, NULL, 0, '2019-06-18 09:13:28', '2019-06-18 09:13:28', 1, 25, 3),
(22, '2019-06-18', 150, 6, 4, '2019-06-28', '2019-09-28', 'Andato tutto bene', 'Aiuto piastrellista', 'Richiesta Tirocinio.pdf', 'Modulo Tirocinio.pdf', '2019-06-18', 'Crea Modulo.pdf', '2019-11-18', '2019-11-18', 'Positivo', 6, '2019-06-18 10:16:11', '2019-06-18 10:16:11', 3, 28, 3),
(23, NULL, 50, 6, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-06-18 11:03:56', '2019-06-18 11:03:56', 1, 28, 3),
(35, NULL, 150, 6, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-06-18 12:59:34', '2019-06-18 12:59:34', 4, 29, 3),
(36, NULL, 150, 6, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-06-18 15:20:01', '2019-06-18 15:20:01', 5, 23, 5),
(37, NULL, 150, 4, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-06-19 07:12:46', '2019-06-19 07:12:46', 5, 27, 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `tutoreuniversitario`
--

DROP TABLE IF EXISTS `tutoreuniversitario`;
CREATE TABLE IF NOT EXISTS `tutoreuniversitario` (
  `IDTutoreUni` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) NOT NULL,
  `Cognome` varchar(50) NOT NULL,
  `Telefono` varchar(50) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Attivo` tinyint(1) NOT NULL DEFAULT 1,
  `CreateDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `UpdateDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`IDTutoreUni`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `tutoreuniversitario`
--

INSERT INTO `tutoreuniversitario` (`IDTutoreUni`, `Nome`, `Cognome`, `Telefono`, `Email`, `Attivo`, `CreateDate`, `UpdateDate`) VALUES
(2, 'Mario', 'Rossi', '1234567899', 'mario.rossi@gmail.it', 1, '2019-05-15 12:39:26', '2019-05-15 14:26:06'),
(3, 'Mario', 'Cracco', '3384495346', 'petroffffger@gel.com', 1, '2019-05-15 15:35:39', '2019-05-15 15:35:39'),
(4, 'Mario', 'Antonucci', '3332225554', 'antonucci@gmail.com', 1, '2019-06-17 14:38:10', '2019-06-17 14:38:10'),
(5, 'Marco', 'Tullio', '1111122222', 'marco.tullio@gmail.it', 1, '2019-06-18 07:40:08', '2019-06-18 07:40:08'),
(6, 'Giovanni', 'Strorti', '333222555444', 'petroffffger@gel.com', 1, '2019-06-19 07:12:46', '2019-06-19 07:12:46');

-- --------------------------------------------------------

--
-- Struttura della tabella `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `IDuser` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(128) NOT NULL,
  `TipologiaAccount` int(10) UNSIGNED NOT NULL,
  `Token` varchar(50) DEFAULT NULL,
  `CreateDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `UpdateDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`IDuser`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `user`
--

INSERT INTO `user` (`IDuser`, `Email`, `Password`, `TipologiaAccount`, `Token`, `CreateDate`, `UpdateDate`) VALUES
(2, 'alessandro@gmail.com', 'F1ECB37CC45DE7B5E816917B042F258E37BD81E95A4352723C172D20095418D82E3C05838912B8801F4F0D215969C0188509868F26735EDDC5293880EF0A4C06', 1, NULL, '2018-08-23 07:14:45', '2019-03-14 16:41:44'),
(3, 'stefano@gmail.com', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 1, NULL, '2019-05-14 15:32:44', '2019-05-14 15:32:44'),
(4, 'mario@gmail.com', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 3, NULL, '2019-05-14 15:39:38', '2019-05-14 15:39:38'),
(5, 'GiacomoPoretti@gmail.com', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 3, NULL, '2019-05-15 08:35:52', '2019-05-15 08:35:52'),
(6, 'luigi@gmail.it', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 2, NULL, '2019-05-15 09:05:31', '2019-05-15 09:05:31'),
(7, 'giovanni1@gmail.com', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 2, NULL, '2019-05-15 12:17:55', '2019-06-18 08:51:37'),
(8, 'luca@gmail.it', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 2, NULL, '2019-05-15 12:22:43', '2019-05-15 12:22:43'),
(9, 'marco@rossi.it', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 2, NULL, '2019-06-18 07:38:17', '2019-06-18 07:38:17'),
(10, 'vittorio@gmail.it', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 3, NULL, '2019-06-18 07:47:42', '2019-06-18 08:34:55'),
(11, 'marcor@gmail.it', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 2, NULL, '2019-06-18 08:37:40', '2019-06-18 08:37:40'),
(12, 'antonio.lo.svelto@gmail.it', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 2, NULL, '2019-06-18 08:52:08', '2019-06-18 08:52:08'),
(13, 'barackobama@red.it', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 2, NULL, '2019-06-18 09:20:24', '2019-06-18 09:20:24'),
(14, 'francesco.totti@gmail.com', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 2, NULL, '2019-06-18 10:03:11', '2019-06-18 10:03:11'),
(15, 'lino@gmail.it', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 2, NULL, '2019-06-18 10:14:04', '2019-06-18 10:14:04'),
(16, 'umberto@gmail.it', 'D9E6762DD1C8EAF6D61B3C6192FC408D4D6D5F1176D0C29169BC24E71C3F274AD27FCD5811B313D681F7E55EC02D73D499C95455B6B5BB503ACF574FBA8FFE85', 2, NULL, '2019-06-18 12:30:18', '2019-06-18 12:30:18');

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin-user` FOREIGN KEY (`User`) REFERENCES `user` (`IDuser`);

--
-- Limiti per la tabella `azienda`
--
ALTER TABLE `azienda`
  ADD CONSTRAINT `azienda-user` FOREIGN KEY (`User`) REFERENCES `user` (`IDuser`);

--
-- Limiti per la tabella `offertatirocinio`
--
ALTER TABLE `offertatirocinio`
  ADD CONSTRAINT `offertatirocinio-azienda` FOREIGN KEY (`Azienda`) REFERENCES `azienda` (`IDAzienda`);

--
-- Limiti per la tabella `tirocinante`
--
ALTER TABLE `tirocinante`
  ADD CONSTRAINT `tirocinante-user` FOREIGN KEY (`User`) REFERENCES `user` (`IDuser`);

--
-- Limiti per la tabella `tirocinio`
--
ALTER TABLE `tirocinio`
  ADD CONSTRAINT `tirocinio-offertatirocinio` FOREIGN KEY (`OffertaTirocinio`) REFERENCES `offertatirocinio` (`IDOffertaTirocinio`),
  ADD CONSTRAINT `tirocinio-tirocinante` FOREIGN KEY (`Tirocinante`) REFERENCES `tirocinante` (`IDTirocinante`),
  ADD CONSTRAINT `tirocinio-tutore` FOREIGN KEY (`TutoreUniversitario`) REFERENCES `tutoreuniversitario` (`IDTutoreUni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
