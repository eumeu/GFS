-- phpMyAdmin SQL Dump
-- version 3.3.10deb1
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Generee le : Mar 19 Juillet 2011 à 17:08
-- Version du serveur: 5.1.54
-- Version de PHP: 5.3.5-1ubuntu7.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de donnees: `base_gfs`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `numero` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `datenais` varchar(50) NOT NULL,
  `lieunais` varchar(50) NOT NULL,
  `nationalite` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `moisInscript` varchar(50) NOT NULL,
  `classe` varchar(50) NOT NULL,
  `monta` varchar(50) NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`numero`, `nom`, `prenom`, `datenais`, `lieunais`, `nationalite`, `adresse`, `moisInscript`, `classe`, `monta`) VALUES
('200703WML', 'LASMOTHEY', 'Comlanvi M. D. Roger', '22/22/2222', 'Togo', 'Tg', 'Scat Urbam', 'OCTOBRE2010-2011', 'M1 SIR', '11000'),
('200702WML', 'Guisse', 'Amadou Wane', '11/11/1111', 'Dakar', 'Sn', 'Sicap L5', 'OCTOBRE2010-2011', 'M1 SIR', '11000'),
('200704WML', 'Kane', 'Khadidiatou', '33/33/3333', 'Dakar', 'Sn', 'Claudel', 'NOVEMBRE2010-2011', 'M1 RETEL', '12000'),
('200304WML', 'NDIAYE', 'El Hadji Abdoulaye', '44/44/4444', 'Dakar', 'Sn', 'Scat Urbam', 'DECEMBRE2010-2011', 'M1 SIR', '11000'),
('200705WML', 'NDIAYE', 'Ndeye Marie Renee', '55/55/5555', 'Kedougou', 'Gabonaise', 'Mbeubeuss', 'OCTOBRE2010-2011', 'LicPro', '10000'),
('200706WML', 'DIENG', 'Baye Salah', '66/66/6666', 'Dakar', 'Sn', 'Colobane', 'NOVEMBRE2010-2011', 'M2 RETEL', '14000');

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE IF NOT EXISTS `formation` (
  `codeform` varchar(50) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  PRIMARY KEY (`codeform`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `formation`
--

INSERT INTO `formation` (`codeform`, `libelle`) VALUES
('LicPro', 'licence pro informatique'),
('M1 SIR', 'Master 1 SIR'),
('M1 RETEL', 'Master 1 RETEL'),
('M2 SIR', 'Master 2 SIR'),
('M2 RETEL', 'Master 2 RETEL');

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE IF NOT EXISTS `paiement` (
  `numero_recu` int(15) NOT NULL AUTO_INCREMENT,
  `montant` int(15) NOT NULL DEFAULT '0',
  `Mois` varchar(50) NOT NULL,
  PRIMARY KEY (`numero_recu`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2210 ;

--
-- Contenu de la table `paiement`
--

INSERT INTO `paiement` (`numero_recu`, `montant`, `Mois`) VALUES
(2209, 100000, 'DECEMBRE');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `matricule` varchar(20) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `profil` varchar(20) NOT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`matricule`, `prenom`, `nom`, `login`, `password`, `profil`) VALUES
('ID01', 'Chef', 'Comptable', 'compta', '3b3a542046e2770f4877af00ed182a9b', 'comptable'),
('ID02', 'Secretaire', 'Invite', 'invite', 'f8f9a65ed8c3611b4ae9198b7c8a3702', 'secretaire'),
('ID04', 'Guisse', 'Amadou Wane ', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'administrateur');

-- --------------------------------------------------------

--
-- Structure de la table `validerpaiement`
--

CREATE TABLE IF NOT EXISTS `validerpaiement` (
  `numero` varchar(50) NOT NULL,
  `numero_recu` int(14) NOT NULL,
  `Mois` varchar(50) NOT NULL,
  `date` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`numero`,`numero_recu`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `validerpaiement`
--

INSERT INTO `validerpaiement` (`numero`, `numero_recu`, `Mois`, `date`) VALUES
('200702WML', 2209, 'DECEMBRE', '0000-00-00');
