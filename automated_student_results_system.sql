-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 22, 2022 at 05:36 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `automated_student_results_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` int(250) NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `course_name`, `status`, `created_at`, `updated_at`) VALUES
(1, 'CERTIFICATE IN SOFTWARE DEVELOPMENT', 'Active', '2022-08-31 17:43:42', '2022-09-12 14:07:26'),
(2, 'INTERNATIONAL COMPUTER DRIVING LICENCE', 'Active', '2022-09-07 17:08:39', '2022-09-08 14:39:08'),
(3, 'DIPLOMA IN BUSINESS COMPUTING', 'Active', '2022-09-07 17:13:08', '2022-09-08 14:39:13'),
(4, 'CISCO CERTIFIED NETWORK ASSOCIATE', 'Active', '2022-09-12 15:03:22', '2022-09-15 14:53:07'),
(5, 'CISCO CERTIFIED NETWORK PROFESSIONALS', 'Active', '2022-09-12 15:03:22', '2022-09-15 14:53:07'),
(6, 'CYBER SECURITY', 'Active', '2022-09-12 15:03:22', '2022-09-15 14:53:07'),
(7, 'NETWORK INFORMATION SECURITY', 'Active', '2022-09-12 15:03:22', '2022-09-15 14:53:07'),
(8, 'CERTIFIED INFORMATION SYSTEM AUDITOR', 'Active', '2022-09-12 15:03:22', '2022-09-15 14:53:07'),
(9, 'COMPUTING INFRASTRUCTURE SYSTEMS & SECURITY', 'Active', '2022-09-12 15:03:22', '2022-09-15 14:53:07'),
(10, 'ADVANCED BIG DATA ANALYTICS', 'Active', '2022-09-12 15:03:22', '2022-09-15 14:53:07');

-- --------------------------------------------------------

--
-- Table structure for table `course_batch`
--

CREATE TABLE `course_batch` (
  `id` int(255) NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `course_id` int(255) DEFAULT NULL,
  `course_level` varchar(255) DEFAULT NULL,
  `coordinator` varchar(255) DEFAULT NULL,
  `course_start_date` varchar(255) DEFAULT NULL,
  `course_end_date` varchar(255) DEFAULT NULL,
  `certificate_issuedate` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course_batch`
--

INSERT INTO `course_batch` (`id`, `course_name`, `course_id`, `course_level`, `coordinator`, `course_start_date`, `course_end_date`, `certificate_issuedate`, `status`, `created_at`, `updated_at`) VALUES
(1, 'CERTIFICATE IN SOFTWARE DEVELOPMENT', 1, 'CSD1.1', 'Bismark Otu', '2022-09-19', '2022-09-30', '2022-10-06', 'Active', '2022-09-19 16:30:07', '2022-09-19 16:38:36'),
(2, 'CERTIFICATE IN SOFTWARE DEVELOPMENT', 1, 'CSD2.2', 'Bismark Otu', '2022-09-19', '2022-09-30', '2022-10-06', 'Active', '2022-09-19 16:30:07', '2022-09-19 16:38:36');

--


-- --------------------------------------------------------

--
-- Table structure for table `modules`
--

CREATE TABLE `modules` (
  `id` int(255) NOT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `staff_name` varchar(255) DEFAULT NULL,
  `course_id` int(255) DEFAULT NULL,
  `batch_id` int(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `module_start_date` date DEFAULT NULL,
  `module_end_date` date DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `modules`
--

INSERT INTO `modules` (`id`, `module_name`, `staff_name`, `course_id`, `batch_id`, `status`, `module_start_date`, `module_end_date`, `created_at`, `updated_at`) VALUES
(1, 'FOUNDAMENTAL OF COMPUTING', 'Hermas Songtaa Wasaal', 1, 2, 'Active', '0000-00-00', '0000-00-00', '2022-08-31 17:43:42', '2022-09-22 14:11:28'),
(2, 'HTML AND CSS', 'Hermas Songtaa Wasaal', 1, 2, 'Active', '0000-00-00', '0000-00-00', '2022-08-31 17:43:42', '2022-09-22 14:11:25'),
(3, 'JAVASCRIPT', 'Hermas Songtaa Wasaal', 1, 2, 'Active', '0000-00-00', '0000-00-00', '2022-08-31 17:43:42', '2022-09-22 12:48:49'),
(4, 'SOFTWARE ENGINEERING', 'Moro Abdul-Wahab', 1, 2, 'Active', '0000-00-00', '0000-00-00', '2022-08-31 17:43:42', '2022-09-22 12:48:49'),
(5, 'DATABASE', 'Bismark Otu', 1, 2, 'Active', '0000-00-00', '0000-00-00', '2022-08-31 17:43:42', '2022-09-22 12:48:49'),
(6, 'PYTHON', 'Hermas Songtaa Wasaal', 1, 2, 'Active', '0000-00-00', '0000-00-00', '2022-08-31 17:43:42', '2022-09-22 12:48:49'),
(7, 'INTRODUCTION TO COMPUTER', 'Edwin Ocansey Larweh', 2, NULL, 'Active', '0000-00-00', '0000-00-00', '2022-09-07 17:08:39', '2022-09-08 12:37:57'),
(8, 'MICROSOFT WORD', 'Edwin Ocansey Larweh', 2, NULL, 'Active', '0000-00-00', '0000-00-00', '2022-09-07 17:08:39', '2022-09-08 12:38:02'),
(9, 'POWERPOINT', 'Edwin Ocansey Larweh', 2, NULL, 'Active', '0000-00-00', '0000-00-00', '2022-09-07 17:08:39', '2022-09-08 12:38:04'),
(10, 'EXCEL', 'Bismark Otu', 2, NULL, 'Active', '0000-00-00', '0000-00-00', '2022-09-07 17:08:39', '2022-09-08 12:38:13'),
(11, 'DIGITAL MARKETING', 'Edwin Ocansey Larweh', 2, NULL, 'Active', '0000-00-00', '0000-00-00', '2022-09-07 17:08:39', '2022-09-08 12:38:25'),
(12, 'IT SECURITY', 'Edwin Ocansey Larweh', 2, NULL, 'Active', '0000-00-00', '0000-00-00', '2022-09-07 17:08:39', '2022-09-08 12:38:30'),
(13, 'PHP', 'Eugene Osae Agyei', 3, NULL, 'Active', '0000-00-00', '0000-00-00', '2022-09-07 17:13:08', '2022-09-08 12:38:51'),
(14, 'LARAVEL', 'Eugene Osae Agyei', 3, NULL, 'Active', '0000-00-00', '0000-00-00', '2022-09-07 17:13:08', '2022-09-08 12:38:54'),
(15, 'ASP.NET CORE MVC ( C# )', 'Cliff Osei Afriyie', 3, NULL, 'Active', '0000-00-00', '0000-00-00', '2022-09-07 17:13:08', '2022-09-08 12:39:07'),
(16, 'CORE JAVA AND JDBC', 'Bismark Otu', 3, NULL, 'Active', '0000-00-00', '0000-00-00', '2022-09-07 17:13:08', '2022-09-08 12:39:15'),
(17, 'SPRING FRAMEWORK', 'Bismark Otu', 3, NULL, 'Active', '0000-00-00', '0000-00-00', '2022-09-07 17:13:08', '2022-09-08 12:39:18'),
(18, 'REACT', 'Jude Attuquaye Clottey', 3, NULL, 'Active', '0000-00-00', '0000-00-00', '2022-09-07 17:13:08', '2022-09-08 12:39:29'),
(19, 'PYTHON FOR DATA SCIENCE', 'Moro Abdul-Wahab', 3, NULL, 'Active', '0000-00-00', '0000-00-00', '2022-09-07 17:13:08', '2022-09-08 12:39:36'),
(20, 'NETWORKING', 'Paul Ntim', 4, NULL, 'Active', '2022-09-09', '2022-11-11', '2022-09-12 15:28:31', '2022-09-12 17:13:44');

--


-- --------------------------------------------------------

--
-- Table structure for table `past_students`
--

CREATE TABLE `past_students` (
  `id` int(255) DEFAULT NULL,
  `name` varchar(250) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `batch_id` int(255) DEFAULT NULL,
  `date_of_birth` varchar(100) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fees` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `staff_details`
--

CREATE TABLE `staff_details` (
  `id` int(250) NOT NULL,
  `staff_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `batch_id` int(250) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `reset_password_token` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff_details`
--

INSERT INTO `staff_details` (`id`, `staff_id`, `name`, `contact`, `department`, `batch_id`, `email`, `password`, `reset_password_token`, `status`, `created_at`, `updated_at`) VALUES
(1, NULL, 'Abraham Agyemfra', '2702169603', NULL, 0, 'abrahamag@aiti-kace.com.gh', '$2y$10$.cEs04O./VyBdYCXEruLdO7VrJxN68y2r1PaTkkEyvWykftg16AMm', '', '1', '2022-08-09 15:22:30', '2022-08-09 15:22:30'),
(2, '1472515', 'David Adu Sarkodie', '242310374', NULL, 0, 'davidsa@aiti-kace.com.gh', '$2y$10$t5sh1JbbH6lZ1s567/GcZ.lW0XgXXdOWfUGV9EMtO3G1XfcGAiyYG', '', '1', '2022-08-09 15:24:13', '2022-08-09 15:24:13'),
(3, '1472563', 'Stephen Amemornu', '247565660', NULL, 0, 'stephename@aiti-kace.com.gh', '$2y$10$ncSlUMJ3pIeowsvcuRoif.ndcUl7q3u8NJ5BsF7s6ZR9Rnc/8jE/K', '', '1', '2022-08-09 15:24:27', '2022-08-09 15:24:27'),
(4, '1407320', 'Elham Gausu', '548330225', 'Finance and Administration', 0, 'gausu@aiti-kace.com.gh', '$2y$10$jq2xEkrLs9KnZY/L4OGl7u//SE5z3bWT657tZjfpQnTY7mYQcH8cW', '', '1', '2022-08-09 15:24:35', '2022-08-09 15:24:35'),
(5, '1472552', 'Abigail Tawiah', '575487638', 'Research and Innovation', 0, 'abigailta@aiti-kace.com.gh', '$2y$10$eHA/OzxYL1ypk1fM7AspK.sSAEB/GdLMGtEVUbsrezFkTb64L9TVG', '', '1', '2022-08-09 15:24:55', '2022-08-09 15:24:55'),
(6, '1407312', 'Anita Danso', '202002209', 'Centre Manager', 0, 'anitad@aiti-kace.com.gh', '$2y$10$5GyVPL3wZQxwQEdKaXA6JuFdVT87FD0KLEjxyPf5z.ShlDctYFKZy', '', '1', '2022-08-09 15:24:55', '2022-08-09 15:24:55'),
(7, '1473114', 'Mark Asare', '202996653', 'Research and Innovation', 0, 'marka@aiti-kace.com.gh', '$2y$10$hOSUROcQUHhYz1BA9m/TBOUHdxseW08aHM.0tQDxV5nNJFc4FKJh2', '', '1', '2022-08-09 15:24:55', '2022-08-09 15:24:55'),
(8, '1414239', 'Eugene Osae Agyei', '542194914', 'Research and Innovation', 5, 'eugeneag@aiti-kace.com.gh', '$2y$10$FOpAsPSLQmzDS1th7weB6OaHWQ3nkjPiaYh7d0ngh9cLo3emAd2Ve', '', '1', '2022-08-09 15:25:19', '2022-09-19 11:37:53'),
(9, '1437475', 'Richard Adjei', '545084441', 'Research and Innovation', 0, 'richarda@aiti-kace.com.gh', '$2y$10$nPCO.USPfBmPrJv2tNBzlumrF.nvJ3cQ8JKYAkxUTRDBWjU43nbYa', '', '1', '2022-08-09 15:25:19', '2022-08-09 15:25:19'),
(10, '1407307', 'Bismark Otu', '555560810', 'Course Cordinator', 0, 'bismarko@aiti-kace.com.gh', 'Openforme', NULL, '1', '2022-09-22 15:15:04', '2022-09-22 15:15:24'),
(11, '1472490', 'Akosua Pinamang Atta - Boateng', '548033957', 'Research and Innovation', 1, 'akosuaat@aiti-kace.com.gh', '$2y$10$l99JZL7YnlIwIiWpX/XVEOiLa3JHNhI02V.9Ep3iiUJZ.MlZmUdyO', '', '1', '2022-08-09 15:25:38', '2022-09-19 13:26:11'),
(12, NULL, 'Stephen Baffoe', '244171322', 'Finance and Administration', 0, 'stephenb@aiti-kace.com.gh', '$2y$10$ly8Z/8Jndr6djAVOAg2/ZueSEfouZxgR6WXQmvSZCzj6VPAYZvq6W', '', '1', '2022-08-09 15:25:46', '2022-08-09 15:25:46'),
(13, '1227984', 'Edward Yeboah', '550009404', 'Course Cordinator', 3, 'edwardky@aiti-kace.com.gh', '$2y$10$.zR1EUI/T4WUF1XPLXynMuaOlZRGpolATbg7lHuTydtdoigNNf5Na', '', '1', '2022-08-09 15:25:55', '2022-09-19 16:31:36'),
(14, NULL, 'Rosamond Ankrah', '509566597', 'Faculty', 0, 'rosamonda@aiti-kace.com.gh', '$2y$10$yqDe9Db.1EzK1IKVvI10FehP7LmwX7Z4CZBe7KQ345LunrpxyOlAK', '', '1', '2022-08-09 15:26:07', '2022-08-09 15:26:07'),
(15, '664165', 'Charles Acquah-Moses', '244713085', 'Facility', 0, 'charlesam@aiti-kace.com.gh', '$2y$10$qO3zJj5C69wyS7drctP2Ju0xYdBIv45vHon3Ll4kzcYz6V45WndBi', '', '1', '2022-08-09 15:26:15', '2022-08-09 15:26:15'),
(16, '810146', 'Mabel Tei', '244959925', 'Store', 0, 'mabelt@aiti-kace.com.gh', '$2y$10$6odPdXMqnntKmPiuZ5BcIeTrjwkIaOVUYaNVp298Opkdod6GPHI4y', '', '1', '2022-08-09 15:26:23', '2022-08-09 15:26:23'),
(17, '874472', 'Cliff Osei Afriyie', '241268730', 'Faculty', 3, 'cliffoa@aiti-kace.com.gh', '$2y$10$SPSI9n6t46jGWonMsiLY/OwMwYg9gMeI1fb4QLFcXpJkllpcbodkO', '', '1', '2022-08-09 15:26:31', '2022-09-19 13:26:54'),
(18, '888099', 'Nana Fosu Nyante', '244088537', 'Consultancy', 0, 'fosun@aiti-kace.com.gh', '$2y$10$/HOj/QOo3NRNliP7AN/wTOqZL5GZyenp7huq4UxZ1AAImdY4AENiy', '', '1', '2022-08-09 15:26:38', '2022-08-09 15:26:38'),
(19, '888642', 'Agnes Anese', '204783641', 'Faculty', 1, 'agnesan@aiti-kace.com.gh', '$2y$10$tZNv8WETJ5svd/JqhZzobO6Ap73aZW3KKrMxUv0XW3XDK96wP5BUK', '', '1', '2022-08-09 15:26:46', '2022-09-19 13:26:59'),
(20, '888624', 'Holy Agbolosoo', '243988124', 'Audit', 0, 'holya@aiti-kace.com.gh', '$2y$10$XMZ61mfPdBKJ920j9zUJsO0Wsbr9K0B4yHGp0.RAm3UGGVqd49Lom', '', '1', '2022-08-09 15:26:55', '2022-08-09 15:26:55'),
(21, '934853', 'Nii Aboni Tackie', '207513955', 'Faculty', 1, 'niiat@aiti-kace.com.gh', '$2y$10$2./7N/I5voEK4OtBq4QJue2k1rqu6hL7lyKh.E/Tp7wIcF.Ow1Yva', '', '1', '2022-08-09 15:27:15', '2022-09-19 13:26:23'),
(22, '57570', 'Rosemond Aryeetey', '243462703', 'Faculty', 1, 'rosemonda@aiti-kace.com.gh', '$2y$10$1BTjBLE3uyxUC4V5ULqDouWTfJSoUxSLZUZx2env8tv81cOB9SjC6', '', '1', '2022-08-09 15:27:23', '2022-09-19 13:25:31'),
(23, '1284388', 'McSeidu Abilla', '545503663', 'Finance and Administration', 0, 'mcseidua@aiti-kace.com.gh', '$2y$10$pRTnefCdUgoKRiUIj15/o.W6Tf9.CZUi3QnBWhCcplgAXY3HYP2Tu', '', '1', '2022-08-09 15:27:30', '2022-08-09 15:27:30'),
(24, '1284401', 'Michael Boateng Yeboah', '243264771', NULL, 0, 'michaelby@aiti-kace.com.gh', '$2y$10$b12atQtNXpJ6D2285g1r6OttKW3o8Cop0e.LPE3IxCkSDOBJ5j8gq', '', '1', '2022-08-09 15:27:38', '2022-08-09 15:27:38'),
(25, '1284377', 'Christian Danso', '204003229', 'Centre Manager', 0, 'christiand@aiti-kace.com.gh', '$2y$10$QHhLIc.is4uGhOhr7YmFze0DKp92c6ABpPBluDSlgh5ZakEDDXJEe', '', '1', '2022-08-09 15:27:56', '2022-08-09 15:27:56'),
(26, '1284395', 'Priscilla Hope', '208175887', 'Consultancy', 0, 'priscillah@aiti-kace.com.gh', '$2y$10$u8AJJAtgQGSNqXQ5rCR/uuF7VsAijRSy1LXS4MoCeDgClC5AisRXa', '', '1', '2022-08-09 15:28:07', '2022-08-09 15:28:07'),
(27, '1284425', 'Seth Kwaku Gyekye-Boateng', '247460450', 'Research and Innovation', 0, 'sethg@aiti-kace.com.gh', '$2y$10$f5YaI2nta57cJYkEi/aPmuXzbwwGAzWkqvCOHhknF51V6kqVSFQMu', '', '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(28, '1371861', 'Bobby', '548150450', 'Facility', 0, 'bobbyjo@aiti-kace.com.gh', '$2y$10$dGYItsv8Tl6fjPvALWGuDOyR8EnKrF19ct1UMqKra9uCWl/uz.yIC', '', '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(29, '1472506', 'Jacqueline Lartey', '247631393', 'NULL', 0, 'jacquelinel@aiti-kace.com.gh', '$2y$10$nvm6t3jQsAHMXCFSt4pyue07zw4UBlO3Ft9lMf/0jfgzb6uqezRxW', '', '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(30, '1471511', 'Ernestina Akweley Adotey', '240699926', 'Consultancy', 0, 'ernestinaa@aiti-kace.com.gh', '$2y$10$1gnNWbmGC89d04gEhOOZ0ufG2GRlGDW.dlCspdQmQfI5TSdxWqe9G', '', '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(31, '1284412', 'Rexford Ayeh Nyarko', '262565566', 'Research and Innovation', 0, 'rexfordn@aiti-kace.com.gh', '$2y$10$96EsXkCcL06LjldYa8nUtuctYssmqrHAWztnpFlr/zVSH8vuMoGpW', '', '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(32, '887965', 'Paulina Issifu Abayaakadi', '244481522', NULL, 0, 'paulinai@aiti-kace.com.gh', '$2y$10$.pK46C1oXrgMB2Og1Fm9HOBcK0HSj12kXtf3RjrMW9Ivaep0Uxr4i', '', '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(33, NULL, 'Carslake Adwoa Pamela', '202142943', 'Consultancy', 0, 'pamelaca@aiti-kace.com.gh', '$2y$10$8KkbCCMMbsG1n9l.c7uJiu96x3Pg/z/kLMp21ygms6JJn.nbccdUy', '', '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(34, '599608', 'Haruna Balle Musah', '249325015', 'Research and Innovation', 0, 'harunab@aiti-kace.com.gh', '$2y$10$MOCg.CR2WGuLsSZf9nWikOlYbeMxggmtSXbvX3Y/m.G//zpYjPQaq', '', '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(35, '1472528', 'Rosalyn Naa Atswei Sowah', '548511805', 'Finance and Administration', 0, 'rosalyns@aiti-kace.com.gh', '$2y$10$7ESI.y/W3gmtKkVz1tMY0u2/GAgho9tbqg1fa1j2lCIS83MA1nMjm', '', '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(36, '1371588', 'Gabriel Dwumah', '543906076', 'Faculty', 0, 'gabrieldw@aiti-kace.com.gh', 'Openforme', '', '1', '2022-08-09 15:28:08', '2022-09-19 17:16:33'),
(37, '1472498', 'Bright Kesse Osei', '506366104', 'Faculty', 2, 'brightos@aiti-kace.com.gh', '$2y$10$WkmTM0Er1O/mq44VYejOPu72vY88zaJX1An1OlOpGwF1Ev8EBH2Ce', '', '1', '2022-08-09 15:28:08', '2022-09-19 13:27:11'),
(38, '887852', 'Mary Bamfo', '541845899', 'Faculty', 1, 'maryb@aiti-kace.com.gh', '$2y$10$h0e6nbz9Pq11wOSVU.NZJufSaeCor2Df5JWWRhMQb2vnOJVPEVqDi', '', '1', '2022-08-09 15:28:08', '2022-09-19 13:27:14'),
(39, '664073', 'Frederick Yeboah', '264679882', 'Research and Innovation', 0, 'fredericky@aiti-kace.com.gh', '$2y$10$2bJpAakxyCSrW4.upIEoF.FtwHDSEathSKbVQ2GaT5ONnJTSj1YWK', '', '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(40, NULL, 'Lawrence Kpodo', '243668183', 'Academics', 0, 'lawrenceyk@aiti-kace.com.gh', 'Academics', '', '1', '2022-08-09 15:28:08', '2022-08-19 17:07:34'),
(41, '664215', 'Sarata Omane', '243349368', 'Consultancy', 0, 'sarataa@aiti-kace.com.gh', '$2y$10$R2PTnlFtUKOnFwWdgFyJvuJP3IiQtqDWSf.7pKSHTay2iVLq.IEva', '', '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(42, '728917', 'Yaw Okraku-Yirenkyi', '207693568', 'Director', 0, 'yawoy@aiti-kace.com.gh', 'directorOfStudies', '', '1', '2022-08-09 15:28:08', '2022-08-19 17:06:43'),
(43, '846804', 'Paul Ntim', '547435445', 'Faculty', 4, 'paulny@aiti-kace.com.gh', '$2y$10$MpvTRbSbCOyeAxalFSXQI.1Xt9SkQfgqBUULScwVp91i38icsW.kW', '', '1', '2022-08-09 15:28:08', '2022-09-19 13:27:26'),
(44, NULL, 'Collins Yeboah Afari', '246193518', 'Director General', 0, 'collinsya@aiti-kace.com.gh', '$2y$10$R2DhKbbrGIJVkApaYY.ZpO/cXInZ215bXcsJym8xbVvdG09zDcZ8u', '', '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(45, NULL, 'Lucy Dzoagbe', '244407966', 'Course Cordinator', 4, 'lucydz@aiti-kace.com.gh', '$2y$10$h/kg6lTmRgc0dWYkwLTlZO/VC3s6XuDMS7SLUtu6wljuW1ySumsAm', '', '1', '2022-08-09 15:28:08', '2022-09-19 16:39:20'),
(46, '1414301', 'Elvis Segbawu Mawuli', '543081518', 'Research and Innovation', 0, 'segbawuel@aiti-kace.com.gh', '$2y$10$ZPpIAW9UjRancEQHoJOE4ObXMUrUKixTaG3ey5xKsHV8Ca7B1X01O', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(47, NULL, 'Ernest Adu', '505054151', 'Corporate Affairs and Media Relations', 0, 'ernesta@aiti-kace.com.gh', '$2y$10$l86tcvTsc96h/V/RUTkGP.h4Wl6zdCjoLtLFLSwUzSEE6p9F/vzXi', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(48, '1407319', 'Wiliam Agyare Kwakye', '547835356', 'Research and Innovation', 0, 'williamkw@aiti-kace.com.gh', '$2y$10$i5uMt.UUlmzaJAG5Irfv1uF.QMNfRb6IQ7frdyxSZM9MU3KAr91KO', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(49, '1294347', 'Quaye Nii Okai', '244741697', 'Research and Innovation', 0, 'niiokai@aiti-kace.com.gh', '$2y$10$qUPMpfwPuDnBL0UMT1QCSOj9OzEZ.VlFvfgrhGe2tVigVTSxxW63S', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(50, '846813', 'Collins Adu', '267711771', 'Facility', 0, 'collinsad@aiti-kace.com.gh', '$2y$10$oKgSfiQ9RYVkAypS/xRRD.yXF6PFN40naXExsfIyHcWLfUuCu2yA6', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(51, '1323144', 'Patrick Kojo Boye Ofei', '540992344', 'Director of Consultancy', 0, 'patrickof@aiti-kace.com.gh', '$2y$10$VM4H3GMW1/j/iyMN0A11keKvFrnuyX7QWKKOQf1k2ZscNIQZhK9Ja', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(52, '1361537', 'Isaac Direser', '549406612', 'Course Cordinator', 0, 'isaacd@aiti-kace.com.gh', '$2y$10$wTsTZsYB.yfH5u/X6OA0oukZmAICh3J/L2N1G2zBt.SfRT2KKw1MG', '', '1', '2022-08-09 15:28:09', '2022-09-15 10:28:14'),
(53, '1361048', 'Randy Moses', '501424378', 'Research and Innovation', 0, 'randym@aiti-kace.com.gh', '$2y$10$DWgZbkJEwT7lwV3qnmwnkuWw4nH12eQPBuoJ1F115AZL4/dbILJWe', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(54, '1361049', 'Rene Xoese Kwasi Novor', '261710326', 'Research and Innovation', 0, 'renen@aiti-kace.com.gh', '$2y$10$LW8gVITM.wteeZg7RvQ2qu9J6UNPj9zvcg62ZA950OyleD/TC2oXi', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(55, '136105', 'Sarpong Collins Kissiedu', '553287180', 'Faculty', 3, 'collinssa@aiti-kace.com.gh', '$2y$10$lCcX8IP5sL5hnelZ20F45OQjmA6gDheWcI0UPhBKh2R4ElycqO2C6', '', '1', '2022-08-09 15:28:09', '2022-09-19 13:27:32'),
(56, '1361056', 'Francis Kwame Korsah', '245847179', 'Course Cordinator', 0, 'francisko@aiti-kace.com.gh', '$2y$10$CS.tPlu0975AdXw2Cv2Bq.TIoGvO5OGlizG7hpWtcnvz/UM6NWwWS', '', '1', '2022-08-09 15:28:09', '2022-09-12 14:08:06'),
(57, '1360939', 'Hermas Songtaa Wasaal', '241834073', 'Course Cordinator', 1, 'hermass@aiti-kace.com.gh', 'testMe', '', '1', '2022-08-09 15:28:09', '2022-09-19 11:07:02'),
(58, NULL, 'Acheampomah Akua Gama', '541133367', 'Consultancy', 0, 'acheampomaha@aiti-kace.com.gh', '$2y$10$W4MUWDhHMuNMBKan40IonuNcaeHAeAEwxe5ri4lfKQu2Xd8FW/vuu', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(59, '1414263', 'Jude Attuquaye Clottey', '575557050', 'Research and Innovation', 0, 'judecl@aiti-kace.com.gh', '$2y$10$ug2oSSZQnRXVomE9ysl7IOZgsjQWdYsg8ssYcD0MVTYCR5GWCd1AS', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(60, NULL, 'Abigail Tawiah', '595487638', 'Research and Innovation', 0, 'abigtailta@iti-kace.com.gh', '$2y$10$wToEA1tZ7nj1Exwt/VugY.SZVpE4eragcGLOVtFcIhhkMTx3z/.Au', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(61, '1506486', 'Osei Agyeman Tutu', '555845204', 'Corporate Affairs and Media Relations', 0, 'agyemantu@aiti-kace.com.gh', '$2y$10$3D9lq.c1fVhGZ3bmlMHYvuZFjTveEft6MexL79eRlkZfIXixVBNle', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(62, '1473112', 'Moro Abdul-Wahab', '542681415', 'Research and Innovation', 0, 'moroa@aiti-kace.com.gh', '$2y$10$d.Yxf.p9oBVPA1Ij48FyTurzYCiqR5/u06oVXAEWz.FMo62Ufrtz2', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(63, '1480763', 'Benjamin Doe Ocansey', '507244002', NULL, 0, 'benjaminoc@aiti-kace.com.gh', '$2y$10$9jsT1zm4MquHrpYbl0y4K.Q3s1D2hPop/FjSD4VdIMs91NN9.3vcq', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(64, NULL, 'Kobi Ossisiadan-Bekoe Hemaa', '244739568', 'Corporate Affairs and Media Relations', 0, 'kobios@aiti-kace.com.gh', '$2y$10$kZjm7egb0RU3O4hDV.OD2.94sd8Hl75FWMW41tP4NSZJArqQmx3Bq', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(65, '1506379', 'Edwin Ocansey Larweh', '205825026', 'Course Cordinator', 2, 'edwinla@aiti-kace.com.gh', '$2y$10$qJLaFIPuLGE0ZeeUIRsTOe7KiRyltOCE68OjWCK0pGCF7i3A8j8dK', '', '1', '2022-08-09 15:28:09', '2022-09-19 16:31:12'),
(66, '1495839', 'Bismarck Ogbamey Tetteh Nii', '246708651', 'Corporate Affairs and Media Relations', 0, 'ogbameyte@aiti-kace.com.gh', '$2y$10$mZa5mdek74bHdlC7kXjmteyPhU5oMtyd22TfujW5OEuhj/Z.jcD3W', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(67, '1506504', 'Stephen Yiadom Boakye', '242608824', 'NULL', 0, 'stephenyi@aiti-kace.com.gh', '$2y$10$EUCen0HlDm9b9xyCt7hV0.IyY6lLKpRui9lmknTS37z3YQ9Ru8QOG', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(68, '1495896', 'Emmanuella Godlove Osei', '506798145', 'NULL', 0, 'godloveos@aiti-kace.com.gh', '$2y$10$1Ja.XPwdQl1mJhp1Y4ADjOYtemMCTujvqa6T0EfcfDsHgZpgRhynu', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(69, '1480732', 'Kingsley Kumi Owusu', '248105128', NULL, 0, 'kingsleyku@aiti-kace.com.gh', '$2y$10$If3hd7I3WuYdNACTqURxF.QzQgDUQYVzlVHl6F94VJv2zibDmiEKa', '', '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(70, NULL, 'Anthionette Ohene-Amoah', '247453461', 'Faculty', 1, 'anthoineto@aiti-kace.com.gh', '$2y$10$PcMl8R217i9Y6W7Rv9MDCOl9uJ7mS1aaA7ArWvHrBgykrRhZcnsc2', '', '1', '2022-08-09 15:28:10', '2022-09-19 13:27:38'),
(71, NULL, 'Foster Adjei', '546766728', 'Research and Innovation', 0, 'fostera@aiti-kace.com.gh', '$2y$10$kJNCm/1vwqsW6StN8WYuJ.C9RJvcFsOcPFVDRkFUsARdhi98Cm9Hm', '', '1', '2022-08-09 15:28:10', '2022-08-09 15:28:10'),
(72, '1495819', 'Shadrach Ainoo', '557591616', 'NULL', 0, 'shadrachai@aiti-kace.com.gh', '$2y$10$Zy6mFnTTFdTQZNMABOkvlua10ScMFTJR5oV.AAYxF3lpJjcLvId4O', '', '1', '2022-08-09 15:28:10', '2022-08-09 15:28:10'),
(73, '1227982', 'Annibert Nanor', '277753394', 'Facility', 0, 'anniberta@aiti-kace.com.gh', '$2y$10$oY11YlZmtQEZYJR6hjQ/huZYZ2L/Lloe3AJR0M2Hd8l3OMwxs.8b6', '', '1', '2022-08-09 15:28:10', '2022-08-09 15:28:10'),
(74, '1480708', 'Emmanuel Awiti Kuffour', '547410729', 'NULL', 1, 'emmanuelaw@aiti-kace.com.gh', '$2y$10$8c0ZlJD3ShTelllxJRvM8u9t3hX.KaGO92enM5mHZjuaRudXZuOxe', '', '1', '2022-08-09 15:28:10', '2022-09-19 13:25:49'),
(75, '1361062', 'David Afriyie Osei-Bonsu', '246256177', 'Faculty', 4, 'davidaob@aiti-kace.com.gh', '$2y$10$.8w.RYt3Fhb1rJhP/EUIFea457f5C6m8inbgKshQN2lV5QGS47iWy', '', '1', '2022-08-09 15:28:10', '2022-09-19 13:27:42'),
(76, '1506510', 'Edmund Dsane Nii Kotey', '244245238', 'NULL', 0, 'edmundds@aiti-kace.com.gh', '$2y$10$dcWsDd8ZaK1X6hy/6s1QL.C3FcR0rqFS2sO2tVMpi7VcK2eqS8wIq', '', '1', '2022-08-09 15:28:42', '2022-08-09 15:28:42');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(255) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `batch_id` int(255) DEFAULT NULL,
  `date_of_birth` varchar(100) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fees` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--


-- --------------------------------------------------------

--
-- Table structure for table `students_results`
--

CREATE TABLE `students_results` (
  `id` int(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `batch_id` int(250) DEFAULT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `staff_name` varchar(255) DEFAULT NULL,
  `marks` int(100) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--





-- Triggers `course_batch`
--
DELIMITER $$
CREATE TRIGGER `insert_into_CourseBatch_update_Modules_BatchID` AFTER INSERT ON `course_batch` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN
    

UPDATE modules SET modules.batch_id = NEW.id 
WHERE modules.course_id = NEW.course_id;

END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `insert_into_courseBatch_update_staff_department_to_cordinator` AFTER INSERT ON `course_batch` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN
    
UPDATE staff_details SET staff_details.department = "Course Cordinator", staff_details.batch_id = NEW.id
WHERE staff_details.name = NEW.coordinator;

END IF;
END
$$
DELIMITER ;




-- Triggers `modules`
--
DELIMITER $$
CREATE TRIGGER `after_insert_into_modules_insert_into_student_results` AFTER INSERT ON `modules` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN
    
INSERT into students_results(students_results.module_name, students_results.batch_id, students_results.staff_name, students_results.status,  
                             students_results.name, students_results.student_id)

SELECT NEW.module_name, NEW.batch_id, NEW.staff_name, NEW.status, 
students.name, students.student_id
FROM students where students.batch_id = NEW.batch_id GROUP by students.name ORDER by students.name;

    END IF;
    
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_insert_into_modules_update_batch_id_on_staff_table` AFTER INSERT ON `modules` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN
    
UPDATE staff_details SET staff_details.batch_id = NEW.batch_id 
WHERE staff_details.name = NEW.staff_name;

    END IF;
    
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update_on_modules_update_batch_id_on_staff_table` AFTER UPDATE ON `modules` FOR EACH ROW BEGIN

    IF (OLD.staff_name != NEW.staff_name)
    THEN
    

UPDATE staff_details SET staff_details.batch_id = NEW.batch_id
WHERE staff_details.name = NEW.staff_name;

    END IF;
    
END
$$
DELIMITER ;




-- Triggers `students`
--
DELIMITER $$
CREATE TRIGGER `after_insert_into_student_insert_into_student_results` AFTER INSERT ON `students` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN
    
INSERT into students_results(students_results.name, students_results.student_id, students_results.batch_id, students_results.status,
                             students_results.module_name, students_results.staff_name)

SELECT NEW.name, NEW.student_id, NEW.batch_id, NEW.status, 
modules.module_name, modules.staff_name
FROM modules where modules.batch_id = NEW.batch_id GROUP by modules.module_name ORDER by modules.module_name;
    END IF;
    
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_updating_only_batch_id_insert_into_past_student` AFTER UPDATE ON `students` FOR EACH ROW BEGIN

    IF (OLD.student_id != NEW.student_id)
    Then
     
 INSERT into past_students(past_students.id, past_students.name,past_students.student_id,
                 past_students.batch_id,
 						 past_students.date_of_birth,past_students.contact,past_students.gender,
                         past_students.email,past_students.fees,past_students.status)

SELECT OLD.id, OLD.name, OLD.student_id, OLD.batch_id,
OLD.date_of_birth, OLD.contact,
OLD.gender, OLD.email, OLD.fees, OLD.status FROM students;

END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_updating_only_batch_id_insert_into_student_results` AFTER UPDATE ON `students` FOR EACH ROW BEGIN

    IF (OLD.batch_id != NEW.batch_id and OLD.student_id != NEW.student_id)
    THEN
    
INSERT into students_results(students_results.name, students_results.student_id, students_results.batch_id, students_results.status,
                             students_results.module_name, students_results.staff_name)

SELECT NEW.name, NEW.student_id, NEW.batch_id, NEW.status, 
modules.module_name, modules.staff_name
FROM modules where modules.batch_id = NEW.batch_id  GROUP by modules.module_name ORDER by modules.module_name;

END IF;
END
$$
DELIMITER ;

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `course_batch`
--
ALTER TABLE `course_batch`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `modules`
--
ALTER TABLE `modules`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staff_details`
--
ALTER TABLE `staff_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `student_id` (`student_id`);

--
-- Indexes for table `students_results`
--
ALTER TABLE `students_results`
  ADD PRIMARY KEY (`id`),
  ADD KEY `hg_stu` (`student_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `course_batch`
--
ALTER TABLE `course_batch`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `modules`
--
ALTER TABLE `modules`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `staff_details`
--
ALTER TABLE `staff_details`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `students_results`
--
ALTER TABLE `students_results`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
