-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 07, 2022 at 05:29 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `QLTruongHoc`
--

-- --------------------------------------------------------

--
-- Table structure for table `Class`
--

CREATE TABLE `Class` (
  `ClassName` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Class`
--

INSERT INTO `Class` (`ClassName`) VALUES
('CNTT'),
('KT'),
('QTKD');

-- --------------------------------------------------------

--
-- Table structure for table `Student`
--

CREATE TABLE `Student` (
  `StudentID` varchar(15) NOT NULL,
  `StudentName` varchar(30) NOT NULL,
  `Address` varchar(25) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `PhoneNumber` varchar(11) DEFAULT NULL,
  `Nationality` varchar(15) DEFAULT NULL,
  `ClassName` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Student`
--

INSERT INTO `Student` (`StudentID`, `StudentName`, `Address`, `Email`, `PhoneNumber`, `Nationality`, `ClassName`) VALUES
('101', 'Le Tran Nam', 'Ha Noi', 'lenam@gmail.com', '0378355000', 'VietNam', 'CNTT'),
('102', 'Phan Van Dinh', 'Nghe An', 'dinhdinh@gmail.com', '0998456564', 'VietNam', 'CNTT'),
('103', 'Van Trung', 'NewYork', 'trubgh@gmail.com', '066485152', 'America', 'QTKD'),
('104', 'Quang Huy', 'Nam Dinh', 'huyyyy@gmail.com', '095313561', 'VietNam', 'KT'),
('105', 'John', 'Paris', 'johnnn@gmail.com', '013256456', 'France', 'CNTT'),
('106', 'Van Dinh', 'Son La', 'dinhhashd@gmail.com', '098115654', 'VietNam', 'QTKD'),
('107', 'Duy Anh', 'Quang Ngai', 'anhhhshh@gmail.com', '091321313', 'VietNam', 'KT');

-- --------------------------------------------------------

--
-- Table structure for table `Teacher`
--

CREATE TABLE `Teacher` (
  `TeacherID` varchar(15) NOT NULL,
  `TeacherName` varchar(30) NOT NULL,
  `Address` varchar(25) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `PhoneNumber` varchar(11) DEFAULT NULL,
  `Nationality` varchar(15) DEFAULT NULL,
  `Specialization` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Teacher`
--

INSERT INTO `Teacher` (`TeacherID`, `TeacherName`, `Address`, `Email`, `PhoneNumber`, `Nationality`, `Specialization`) VALUES
('001', 'Nguyen Van D', 'HaNoi', 'dadasdsad@gmail.com', '092156443', 'VietNam', 'CNTT'),
('002', 'John', 'NewYork', 'asdasd@gmail.com', '066485152', 'America', 'QTKD'),
('003', 'Quang Tuan', 'Nam Dinh', 'huyyyasdy@gmail.com', '0965215621', 'VietNam', 'KT');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Class`
--
ALTER TABLE `Class`
  ADD PRIMARY KEY (`ClassName`),
  ADD UNIQUE KEY `unique_class_name` (`ClassName`);

--
-- Indexes for table `Student`
--
ALTER TABLE `Student`
  ADD PRIMARY KEY (`StudentID`),
  ADD UNIQUE KEY `StudentID` (`StudentID`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `PhoneNumber` (`PhoneNumber`),
  ADD KEY `fk_class_name` (`ClassName`);

--
-- Indexes for table `Teacher`
--
ALTER TABLE `Teacher`
  ADD PRIMARY KEY (`TeacherID`),
  ADD UNIQUE KEY `TeacherID` (`TeacherID`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `PhoneNumber` (`PhoneNumber`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Student`
--
ALTER TABLE `Student`
  ADD CONSTRAINT `fk_class_name` FOREIGN KEY (`ClassName`) REFERENCES `Class` (`ClassName`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
