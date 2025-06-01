-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 01, 2025 at 09:28 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `il`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(15) NOT NULL,
  `username` varchar(50) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `nama`, `password`) VALUES
('A001', '', 'Budi Susanto', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` varchar(50) NOT NULL,
  `nama_barang` varchar(100) DEFAULT NULL,
  `jumlah` int DEFAULT NULL,
  `jenis` varchar(50) DEFAULT NULL,
  `kondisi` varchar(50) DEFAULT NULL,
  `deskripsi` varchar(50) DEFAULT NULL,
  `denda` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `jumlah`, `jenis`, `kondisi`, `deskripsi`, `denda`) VALUES
('B002', 'Monitor AOC', 16, 'Mouse', 'BAIK', 'Monitor dari AOC', 10000),
('B003', 'AADC', 7, 'PC', 'Baik', 'keren', 20000),
('B004', 'AOCI', 100, 'Monitor', 'Baik', 'Baik Sekali', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` varchar(20) NOT NULL,
  `nim` int DEFAULT NULL,
  `id_barang` varchar(50) DEFAULT NULL,
  `id_admin` varchar(15) DEFAULT NULL,
  `tanggal_pinjam` date DEFAULT NULL,
  `tanggal_kembali` date DEFAULT NULL,
  `denda` int DEFAULT '0',
  `status` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `nim`, `id_barang`, `id_admin`, `tanggal_pinjam`, `tanggal_kembali`, `denda`, `status`) VALUES
('PMJ001', 2418015, 'B002', 'A001', '2025-05-23', '2025-05-23', 90000, 'Telah Dikembalikan'),
('PMJ002', 2418015, 'B004', 'A001', '2025-05-23', '2025-05-12', 110000, 'Telah Dikembalikan'),
('PMJ003', 2418015, 'B002', 'A001', '2025-05-23', '2025-05-23', 20000, 'Telah Dikembalikan'),
('PMJ005', 2418015, 'B003', 'A001', '2025-05-26', '2025-05-30', 40000, 'Telah Dikembalikan'),
('PMJ006', 2418014, 'B002', 'A001', '2025-06-01', '2025-06-20', 0, 'Telah Dikembalikan'),
('PMJ007', 2418015, 'B003', NULL, '2025-05-01', '2025-05-31', 20000, 'Telah Dikembalikan');

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id_pengembalian` varchar(20) NOT NULL,
  `id_peminjaman` varchar(20) DEFAULT NULL,
  `tanggal_dikembalikan` date DEFAULT NULL,
  `denda` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`id_pengembalian`, `id_peminjaman`, `tanggal_dikembalikan`, `denda`) VALUES
('K0001', 'PMJ001', '2025-05-23', 0),
('K0002', 'PMJ002', '2025-05-23', 110000),
('K0003', 'PMJ003', '2025-05-25', 20000),
('K0004', 'PMJ006', '2025-06-01', 0),
('K0005', 'PMJ005', '2025-06-01', 40000),
('K0006', 'PMJ007', '2025-06-01', 20000),
('K0007', 'PMJ001', '2025-06-01', 90000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `nim` int NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `no_wa` varchar(15) DEFAULT NULL,
  `Alamat` longtext NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`nim`, `nama`, `no_wa`, `Alamat`, `password`) VALUES
(2418014, 'Radit Arya Wiguna', '089121212', 'Singhasari', 'ayayaya'),
(2418015, 'Dani Aqila Rosyidi', '08123445678896', 'Malang jawa timur', 'AIE07CT3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `user` (`nim`),
  ADD KEY `barang` (`id_barang`),
  ADD KEY `admin` (`id_admin`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`nim`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `admin` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`),
  ADD CONSTRAINT `barang` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `user` FOREIGN KEY (`nim`) REFERENCES `user` (`nim`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
