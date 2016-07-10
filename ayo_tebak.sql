-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 03 Jul 2016 pada 17.07
-- Versi Server: 5.5.48
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ayo_tebak`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `bank_soal`
--

CREATE TABLE IF NOT EXISTS `bank_soal` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `soal` text NOT NULL,
  `jawaban` varchar(30) NOT NULL,
  `petunjuk` varchar(30) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data untuk tabel `bank_soal`
--

INSERT INTO `bank_soal` (`no`, `soal`, `jawaban`, `petunjuk`) VALUES
(1, 'Jumlahku selalu bertambah, namun tidak pernah berkurang, Apakah aku ?', 'umur', 'Dirayakan Pada Setiap Tahunnya'),
(2, 'Aku selalu jatuh ke tanah, Namun aku tidak pernah naik keatas.', 'hujan', 'berhubungan dengan cuaca');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
