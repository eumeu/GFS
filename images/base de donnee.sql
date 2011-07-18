-- phpMyAdmin SQL Dump
-- version 2.9.1.1
-- http://www.phpmyadmin.net
-- 
-- Serveur: localhost
-- Généré le : Samedi 20 Mars 2010 à 18:07
-- Version du serveur: 5.0.27
-- Version de PHP: 5.2.0
-- 
-- Base de données: `paiement_cfpp_09`
-- 

-- --------------------------------------------------------

-- 
-- Structure de la table `etudiant`
-- 
-- Création: Lundi 23 Mars 2009 à 04:33
-- Dernière modification: Mercredi 25 Mars 2009 à 15:02
-- 

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE `etudiant` (
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
  PRIMARY KEY  (`numero`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Contenu de la table `etudiant`
-- 

INSERT INTO `etudiant` (`numero`, `nom`, `prenom`, `datenais`, `lieunais`, `nationalite`, `adresse`, `moisInscript`, `classe`, `monta`) VALUES 
('12', 'MOKTAR', 'sidi', '1980', 'RKIZ', 'MAURITANIENNE', '1G2AVV', 'DECEMBRE', 'LPGI1', '120000');

-- --------------------------------------------------------

-- 
-- Structure de la table `formation`
-- 
-- Création: Samedi 14 Mars 2009 à 06:32
-- Dernière modification: Samedi 14 Mars 2009 à 19:03
-- 

DROP TABLE IF EXISTS `formation`;
CREATE TABLE `formation` (
  `codeform` varchar(50) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  PRIMARY KEY  (`codeform`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Contenu de la table `formation`
-- 

INSERT INTO `formation` (`codeform`, `libelle`) VALUES 
('LPGI1', 'licence pro '),
('LPRT1', 'licence pro'),
('DURIG2', 'reseaux info'),
('DSCDSI2', 'conception developpement'),
('MaDSI', 'master ');

-- --------------------------------------------------------

-- 
-- Structure de la table `paiement`
-- 
-- Création: Dimanche 22 Mars 2009 à 02:58
-- Dernière modification: Jeudi 26 Mars 2009 à 02:03
-- 

DROP TABLE IF EXISTS `paiement`;
CREATE TABLE `paiement` (
  `numero_recu` int(15) NOT NULL auto_increment,
  `montant` int(15) NOT NULL default '0',
  `Mois` varchar(50) NOT NULL,
  PRIMARY KEY  (`numero_recu`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2206 ;

-- 
-- Contenu de la table `paiement`
-- 

INSERT INTO `paiement` (`numero_recu`, `montant`, `Mois`) VALUES 
(2205, 1111, 'janvier'),
(2204, 111, 'janvier'),
(2203, 11111, 'fevrier');

-- --------------------------------------------------------

-- 
-- Structure de la table `validerpaiement`
-- 
-- Création: Mercredi 25 Mars 2009 à 13:27
-- Dernière modification: Jeudi 26 Mars 2009 à 02:03
-- 

DROP TABLE IF EXISTS `validerpaiement`;
CREATE TABLE `validerpaiement` (
  `numero` varchar(50) NOT NULL,
  `numero_recu` int(14) NOT NULL,
  `Mois` varchar(50) NOT NULL,
  `date` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`numero`,`numero_recu`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Contenu de la table `validerpaiement`
-- 