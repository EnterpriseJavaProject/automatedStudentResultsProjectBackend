-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 27, 2022 at 02:18 PM
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
-- Triggers `course_batch`
--
DELIMITER $$
CREATE TRIGGER `after_insert_courseBatch_insert_staff_role` AFTER INSERT ON `course_batch` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN

INSERT into staff_role(staff_role.status, staff_role.batch_id, staff_role.course_id, staff_role.module_name)

SELECT NEW.status, NEW.id, NEW.course_id, modules.module_name
FROM modules where modules.course_id = NEW.course_id GROUP by modules.module_name ORDER by modules.module_name;

    END IF;

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_insert_courseBatch_update_staff_batch_id` AFTER INSERT ON `course_batch` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN

UPDATE staff_details SET staff_details.batch_id = NEW.id
WHERE staff_details.name = NEW.coordinator;

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

-- --------------------------------------------------------

--
-- Table structure for table `modules`
--

CREATE TABLE `modules` (
  `id` int(255) NOT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `course_id` int(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `modules`
--

INSERT INTO `modules` (`id`, `module_name`, `course_id`, `status`, `created_at`, `updated_at`) VALUES
(1, 'FOUNDAMENTAL OF COMPUTING', 1, 'Active', '2022-08-31 17:43:42', '2022-10-26 10:20:36'),
(2, 'HTML AND CSS', 1, 'Active', '2022-08-31 17:43:42', '2022-10-21 13:57:25'),
(3, 'JAVASCRIPT', 1, 'Active', '2022-08-31 17:43:42', '2022-10-21 13:57:27'),
(4, 'SOFTWARE ENGINEERING', 1, 'Active', '2022-08-31 17:43:42', '2022-10-21 13:57:29'),
(5, 'DATABASE', 1, 'Active', '2022-08-31 17:43:42', '2022-10-21 13:57:32'),
(6, 'PYTHON', 1, 'Active', '2022-08-31 17:43:42', '2022-10-21 13:57:34'),
(7, 'INTRODUCTION TO COMPUTER', 2, 'Active', '2022-09-07 17:08:39', '2022-10-21 13:57:14'),
(8, 'MICROSOFT WORD', 2, 'Active', '2022-09-07 17:08:39', '2022-10-21 13:57:16'),
(9, 'POWERPOINT', 2, 'Active', '2022-09-07 17:08:39', '2022-10-21 13:57:37'),
(10, 'EXCEL', 2, 'Active', '2022-09-07 17:08:39', '2022-10-21 13:57:40'),
(11, 'DIGITAL MARKETING', 2, 'Active', '2022-09-07 17:08:39', '2022-10-21 13:57:42'),
(12, 'IT SECURITY', 2, 'Active', '2022-09-07 17:08:39', '2022-10-21 13:57:44'),
(13, 'PHP', 3, 'Active', '2022-09-07 17:13:08', '2022-10-21 13:58:24'),
(14, 'LARAVEL', 3, 'Active', '2022-09-07 17:13:08', '2022-10-21 13:58:24'),
(15, 'ASP.NET CORE MVC ( C# )', 3, 'Active', '2022-09-07 17:13:08', '2022-10-21 13:58:24'),
(16, 'CORE JAVA AND JDBC', 3, 'Active', '2022-09-07 17:13:08', '2022-10-21 13:58:24'),
(17, 'SPRING FRAMEWORK', 3, 'Active', '2022-09-07 17:13:08', '2022-10-21 13:58:24'),
(18, 'REACT', 3, 'Active', '2022-09-07 17:13:08', '2022-10-21 13:58:24'),
(19, 'PYTHON FOR DATA SCIENCE', 3, 'Active', '2022-09-07 17:13:08', '2022-10-21 13:58:24'),
(20, 'NETWORKING', 4, 'Active', '2022-09-12 15:28:31', '2022-09-12 17:13:44');

-- --------------------------------------------------------

--
-- Table structure for table `past_students`
--

CREATE TABLE `past_students` (
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
  `usertype` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff_details`
--

INSERT INTO `staff_details` (`id`, `staff_id`, `name`, `contact`, `department`, `batch_id`, `email`, `password`, `reset_password_token`, `usertype`, `status`, `created_at`, `updated_at`) VALUES
(1, NULL, 'Abraham Agyemfra', '2702169603', NULL, 0, 'abrahamag@aiti-kace.com.gh', '$2y$10$.cEs04O./VyBdYCXEruLdO7VrJxN68y2r1PaTkkEyvWykftg16AMm', '', NULL, '1', '2022-08-09 15:22:30', '2022-08-09 15:22:30'),
(2, '1472515', 'David Adu Sarkodie', '242310374', NULL, 0, 'davidsa@aiti-kace.com.gh', '$2y$10$t5sh1JbbH6lZ1s567/GcZ.lW0XgXXdOWfUGV9EMtO3G1XfcGAiyYG', '', NULL, '1', '2022-08-09 15:24:13', '2022-08-09 15:24:13'),
(3, '1472563', 'Stephen Amemornu', '247565660', NULL, 0, 'stephename@aiti-kace.com.gh', '$2y$10$ncSlUMJ3pIeowsvcuRoif.ndcUl7q3u8NJ5BsF7s6ZR9Rnc/8jE/K', '', NULL, '1', '2022-08-09 15:24:27', '2022-08-09 15:24:27'),
(4, '1407320', 'Elham Gausu', '548330225', 'Finance and Administration', 0, 'gausu@aiti-kace.com.gh', '$2y$10$jq2xEkrLs9KnZY/L4OGl7u//SE5z3bWT657tZjfpQnTY7mYQcH8cW', '', NULL, '1', '2022-08-09 15:24:35', '2022-08-09 15:24:35'),
(5, '1472552', 'Abigail Tawiah', '575487638', 'Research and Innovation', 0, 'abigailta@aiti-kace.com.gh', '$2y$10$eHA/OzxYL1ypk1fM7AspK.sSAEB/GdLMGtEVUbsrezFkTb64L9TVG', '', NULL, '1', '2022-08-09 15:24:55', '2022-08-09 15:24:55'),
(6, '1407312', 'Anita Danso', '202002209', 'Centre Manager', 0, 'anitad@aiti-kace.com.gh', '$2y$10$5GyVPL3wZQxwQEdKaXA6JuFdVT87FD0KLEjxyPf5z.ShlDctYFKZy', '', 'Manager', '1', '2022-08-09 15:24:55', '2022-10-27 12:17:29'),
(7, '1473114', 'Mark Asare', '202996653', 'Research and Innovation', 0, 'marka@aiti-kace.com.gh', '$2y$10$hOSUROcQUHhYz1BA9m/TBOUHdxseW08aHM.0tQDxV5nNJFc4FKJh2', '', NULL, '1', '2022-08-09 15:24:55', '2022-08-09 15:24:55'),
(8, '1414239', 'Eugene Osae Agyei', '542194914', 'Research and Innovation', 5, 'eugeneag@aiti-kace.com.gh', '$2y$10$FOpAsPSLQmzDS1th7weB6OaHWQ3nkjPiaYh7d0ngh9cLo3emAd2Ve', '', NULL, '1', '2022-08-09 15:25:19', '2022-09-19 11:37:53'),
(9, '1437475', 'Richard Adjei', '545084441', 'Research and Innovation', 0, 'richarda@aiti-kace.com.gh', '$2y$10$nPCO.USPfBmPrJv2tNBzlumrF.nvJ3cQ8JKYAkxUTRDBWjU43nbYa', '', NULL, '1', '2022-08-09 15:25:19', '2022-08-09 15:25:19'),
(10, '1407307', 'Bismark Otu', '555560810', 'Course Cordinator', 10, 'bismarko@aiti-kace.com.gh', 'Openforme', NULL, NULL, '1', '2022-10-19 15:49:15', '2022-10-27 12:02:03'),
(11, '1472490', 'Akosua Pinamang Atta - Boateng', '548033957', 'Research and Innovation', 1, 'akosuaat@aiti-kace.com.gh', '$2y$10$l99JZL7YnlIwIiWpX/XVEOiLa3JHNhI02V.9Ep3iiUJZ.MlZmUdyO', '', NULL, '1', '2022-08-09 15:25:38', '2022-09-19 13:26:11'),
(12, NULL, 'Stephen Baffoe', '244171322', 'Finance and Administration', 0, 'stephenb@aiti-kace.com.gh', '$2y$10$ly8Z/8Jndr6djAVOAg2/ZueSEfouZxgR6WXQmvSZCzj6VPAYZvq6W', '', NULL, '1', '2022-08-09 15:25:46', '2022-08-09 15:25:46'),
(13, '1227984', 'Edward Yeboah', '550009404', 'Faculty', 4, 'edwardky@aiti-kace.com.gh', '$2y$10$.zR1EUI/T4WUF1XPLXynMuaOlZRGpolATbg7lHuTydtdoigNNf5Na', '', 'Instructor', '1', '2022-08-09 15:25:55', '2022-10-27 12:15:41'),
(14, NULL, 'Rosamond Ankrah', '509566597', 'Faculty', 3, 'rosamonda@aiti-kace.com.gh', '$2y$10$yqDe9Db.1EzK1IKVvI10FehP7LmwX7Z4CZBe7KQ345LunrpxyOlAK', '', 'Instructor', '1', '2022-08-09 15:26:07', '2022-10-27 12:15:46'),
(15, '664165', 'Charles Acquah-Moses', '244713085', 'Facility', 0, 'charlesam@aiti-kace.com.gh', '$2y$10$qO3zJj5C69wyS7drctP2Ju0xYdBIv45vHon3Ll4kzcYz6V45WndBi', '', NULL, '1', '2022-08-09 15:26:15', '2022-08-09 15:26:15'),
(16, '810146', 'Mabel Tei', '244959925', 'Store', 0, 'mabelt@aiti-kace.com.gh', '$2y$10$6odPdXMqnntKmPiuZ5BcIeTrjwkIaOVUYaNVp298Opkdod6GPHI4y', '', NULL, '1', '2022-08-09 15:26:23', '2022-08-09 15:26:23'),
(17, '874472', 'Cliff Osei Afriyie', '241268730', 'Faculty', 4, 'cliffoa@aiti-kace.com.gh', '$2y$10$SPSI9n6t46jGWonMsiLY/OwMwYg9gMeI1fb4QLFcXpJkllpcbodkO', '', 'Instructor', '1', '2022-08-09 15:26:31', '2022-10-27 12:15:48'),
(18, '888099', 'Nana Fosu Nyante', '244088537', 'Consultancy', 0, 'fosun@aiti-kace.com.gh', '$2y$10$/HOj/QOo3NRNliP7AN/wTOqZL5GZyenp7huq4UxZ1AAImdY4AENiy', '', NULL, '1', '2022-08-09 15:26:38', '2022-08-09 15:26:38'),
(19, '888642', 'Agnes Anese', '204783641', 'Faculty', 3, 'agnesan@aiti-kace.com.gh', '$2y$10$tZNv8WETJ5svd/JqhZzobO6Ap73aZW3KKrMxUv0XW3XDK96wP5BUK', '', 'Instructor', '1', '2022-08-09 15:26:46', '2022-10-27 12:15:50'),
(20, '888624', 'Holy Agbolosoo', '243988124', 'Audit', 0, 'holya@aiti-kace.com.gh', '$2y$10$XMZ61mfPdBKJ920j9zUJsO0Wsbr9K0B4yHGp0.RAm3UGGVqd49Lom', '', NULL, '1', '2022-08-09 15:26:55', '2022-08-09 15:26:55'),
(21, '934853', 'Nii Aboni Tackie', '207513955', 'Faculty', 4, 'niiat@aiti-kace.com.gh', '$2y$10$2./7N/I5voEK4OtBq4QJue2k1rqu6hL7lyKh.E/Tp7wIcF.Ow1Yva', '', 'Instructor', '1', '2022-08-09 15:27:15', '2022-10-27 12:15:52'),
(22, '57570', 'Rosemond Aryeetey', '243462703', 'Faculty', 4, 'rosemonda@aiti-kace.com.gh', '$2y$10$1BTjBLE3uyxUC4V5ULqDouWTfJSoUxSLZUZx2env8tv81cOB9SjC6', '', 'Instructor', '1', '2022-08-09 15:27:23', '2022-10-27 12:15:56'),
(23, '1284388', 'McSeidu Abilla', '545503663', 'Finance and Administration', 0, 'mcseidua@aiti-kace.com.gh', '$2y$10$pRTnefCdUgoKRiUIj15/o.W6Tf9.CZUi3QnBWhCcplgAXY3HYP2Tu', '', NULL, '1', '2022-08-09 15:27:30', '2022-08-09 15:27:30'),
(24, '1284401', 'Michael Boateng Yeboah', '243264771', NULL, 0, 'michaelby@aiti-kace.com.gh', '$2y$10$b12atQtNXpJ6D2285g1r6OttKW3o8Cop0e.LPE3IxCkSDOBJ5j8gq', '', NULL, '1', '2022-08-09 15:27:38', '2022-08-09 15:27:38'),
(25, '1284377', 'Christian Danso', '204003229', 'Centre Manager', 0, 'christiand@aiti-kace.com.gh', '$2y$10$QHhLIc.is4uGhOhr7YmFze0DKp92c6ABpPBluDSlgh5ZakEDDXJEe', '', 'Manager', '1', '2022-08-09 15:27:56', '2022-10-27 12:17:19'),
(26, '1284395', 'Priscilla Hope', '208175887', 'Consultancy', 0, 'priscillah@aiti-kace.com.gh', '$2y$10$u8AJJAtgQGSNqXQ5rCR/uuF7VsAijRSy1LXS4MoCeDgClC5AisRXa', '', NULL, '1', '2022-08-09 15:28:07', '2022-08-09 15:28:07'),
(27, '1284425', 'Seth Kwaku Gyekye-Boateng', '247460450', 'Research and Innovation', 0, 'sethg@aiti-kace.com.gh', '$2y$10$f5YaI2nta57cJYkEi/aPmuXzbwwGAzWkqvCOHhknF51V6kqVSFQMu', '', NULL, '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(28, '1371861', 'Bobby', '548150450', 'Facility', 0, 'bobbyjo@aiti-kace.com.gh', '$2y$10$dGYItsv8Tl6fjPvALWGuDOyR8EnKrF19ct1UMqKra9uCWl/uz.yIC', '', NULL, '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(29, '1472506', 'Jacqueline Lartey', '247631393', 'NULL', 0, 'jacquelinel@aiti-kace.com.gh', '$2y$10$nvm6t3jQsAHMXCFSt4pyue07zw4UBlO3Ft9lMf/0jfgzb6uqezRxW', '', NULL, '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(30, '1471511', 'Ernestina Akweley Adotey', '240699926', 'Consultancy', 0, 'ernestinaa@aiti-kace.com.gh', '$2y$10$1gnNWbmGC89d04gEhOOZ0ufG2GRlGDW.dlCspdQmQfI5TSdxWqe9G', '', NULL, '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(31, '1284412', 'Rexford Ayeh Nyarko', '262565566', 'Research and Innovation', 0, 'rexfordn@aiti-kace.com.gh', '$2y$10$96EsXkCcL06LjldYa8nUtuctYssmqrHAWztnpFlr/zVSH8vuMoGpW', '', NULL, '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(32, '887965', 'Paulina Issifu Abayaakadi', '244481522', NULL, 0, 'paulinai@aiti-kace.com.gh', '$2y$10$.pK46C1oXrgMB2Og1Fm9HOBcK0HSj12kXtf3RjrMW9Ivaep0Uxr4i', '', NULL, '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(33, NULL, 'Carslake Adwoa Pamela', '202142943', 'Consultancy', 0, 'pamelaca@aiti-kace.com.gh', '$2y$10$8KkbCCMMbsG1n9l.c7uJiu96x3Pg/z/kLMp21ygms6JJn.nbccdUy', '', NULL, '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(34, '599608', 'Haruna Balle Musah', '249325015', 'Research and Innovation', 0, 'harunab@aiti-kace.com.gh', '$2y$10$MOCg.CR2WGuLsSZf9nWikOlYbeMxggmtSXbvX3Y/m.G//zpYjPQaq', '', NULL, '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(35, '1472528', 'Rosalyn Naa Atswei Sowah', '548511805', 'Finance and Administration', 0, 'rosalyns@aiti-kace.com.gh', '$2y$10$7ESI.y/W3gmtKkVz1tMY0u2/GAgho9tbqg1fa1j2lCIS83MA1nMjm', '', NULL, '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(36, '1371588', 'Gabriel Dwumah', '543906076', 'Faculty', NULL, 'gabrieldw@aiti-kace.com.gh', 'Openforme', '', 'Instructor', '1', '2022-08-09 15:28:08', '2022-10-27 12:15:58'),
(37, '1472498', 'Bright Kesse Osei', '506366104', 'Faculty', 4, 'brightos@aiti-kace.com.gh', '$2y$10$WkmTM0Er1O/mq44VYejOPu72vY88zaJX1An1OlOpGwF1Ev8EBH2Ce', '', 'Instructor', '1', '2022-08-09 15:28:08', '2022-10-27 12:16:47'),
(38, '887852', 'Mary Bamfo', '541845899', 'Faculty', 3, 'maryb@aiti-kace.com.gh', '$2y$10$h0e6nbz9Pq11wOSVU.NZJufSaeCor2Df5JWWRhMQb2vnOJVPEVqDi', '', 'Instructor', '1', '2022-08-09 15:28:08', '2022-10-27 12:16:47'),
(39, '664073', 'Frederick Yeboah', '264679882', 'Research and Innovation', 0, 'fredericky@aiti-kace.com.gh', '$2y$10$2bJpAakxyCSrW4.upIEoF.FtwHDSEathSKbVQ2GaT5ONnJTSj1YWK', '', NULL, '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(40, NULL, 'Lawrence Kpodo', '243668183', 'Academics', 0, 'lawrenceyk@aiti-kace.com.gh', 'Academics', '', 'Academics', '1', '2022-08-09 15:28:08', '2022-10-27 12:14:41'),
(41, '664215', 'Sarata Omane', '243349368', 'Consultancy', 0, 'sarataa@aiti-kace.com.gh', '$2y$10$R2PTnlFtUKOnFwWdgFyJvuJP3IiQtqDWSf.7pKSHTay2iVLq.IEva', '', NULL, '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(42, '728917', 'Yaw Okraku-Yirenkyi', '207693568', 'Director', 0, 'yawoy@aiti-kace.com.gh', 'directorOfStudies', '', 'Director', '1', '2022-08-09 15:28:08', '2022-10-27 12:14:31'),
(43, '846804', 'Paul Ntim', '547435445', 'Faculty', 4, 'paulny@aiti-kace.com.gh', '$2y$10$MpvTRbSbCOyeAxalFSXQI.1Xt9SkQfgqBUULScwVp91i38icsW.kW', '', 'Instructor', '1', '2022-08-09 15:28:08', '2022-10-27 12:16:47'),
(44, NULL, 'Collins Yeboah Afari', '246193518', 'Director General', 0, 'collinsya@aiti-kace.com.gh', '$2y$10$R2DhKbbrGIJVkApaYY.ZpO/cXInZ215bXcsJym8xbVvdG09zDcZ8u', '', NULL, '1', '2022-08-09 15:28:08', '2022-08-09 15:28:08'),
(45, NULL, 'Lucy Dzoagbe', '244407966', 'Faculty', 4, 'lucydz@aiti-kace.com.gh', '$2y$10$h/kg6lTmRgc0dWYkwLTlZO/VC3s6XuDMS7SLUtu6wljuW1ySumsAm', '', 'Instructor', '1', '2022-08-09 15:28:08', '2022-10-27 12:16:47'),
(46, '1414301', 'Elvis Segbawu Mawuli', '543081518', 'Research and Innovation', 0, 'segbawuel@aiti-kace.com.gh', '$2y$10$ZPpIAW9UjRancEQHoJOE4ObXMUrUKixTaG3ey5xKsHV8Ca7B1X01O', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(47, NULL, 'Ernest Adu', '505054151', 'Corporate Affairs and Media Relations', 0, 'ernesta@aiti-kace.com.gh', '$2y$10$l86tcvTsc96h/V/RUTkGP.h4Wl6zdCjoLtLFLSwUzSEE6p9F/vzXi', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(48, '1407319', 'Wiliam Agyare Kwakye', '547835356', 'Research and Innovation', 0, 'williamkw@aiti-kace.com.gh', '$2y$10$i5uMt.UUlmzaJAG5Irfv1uF.QMNfRb6IQ7frdyxSZM9MU3KAr91KO', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(49, '1294347', 'Quaye Nii Okai', '244741697', 'Research and Innovation', 0, 'niiokai@aiti-kace.com.gh', '$2y$10$qUPMpfwPuDnBL0UMT1QCSOj9OzEZ.VlFvfgrhGe2tVigVTSxxW63S', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(50, '846813', 'Collins Adu', '267711771', 'Facility', 0, 'collinsad@aiti-kace.com.gh', '$2y$10$oKgSfiQ9RYVkAypS/xRRD.yXF6PFN40naXExsfIyHcWLfUuCu2yA6', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(51, '1323144', 'Patrick Kojo Boye Ofei', '540992344', 'Director of Consultancy', 0, 'patrickof@aiti-kace.com.gh', '$2y$10$VM4H3GMW1/j/iyMN0A11keKvFrnuyX7QWKKOQf1k2ZscNIQZhK9Ja', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(52, '1361537', 'Isaac Direser', '549406612', 'Faculty', 0, 'isaacd@aiti-kace.com.gh', '$2y$10$wTsTZsYB.yfH5u/X6OA0oukZmAICh3J/L2N1G2zBt.SfRT2KKw1MG', '', 'Instructor', '1', '2022-08-09 15:28:09', '2022-10-27 12:16:47'),
(53, '1361048', 'Randy Moses', '501424378', 'Research and Innovation', 0, 'randym@aiti-kace.com.gh', '$2y$10$DWgZbkJEwT7lwV3qnmwnkuWw4nH12eQPBuoJ1F115AZL4/dbILJWe', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(54, '1361049', 'Rene Xoese Kwasi Novor', '261710326', 'Research and Innovation', 0, 'renen@aiti-kace.com.gh', '$2y$10$LW8gVITM.wteeZg7RvQ2qu9J6UNPj9zvcg62ZA950OyleD/TC2oXi', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(55, '136105', 'Sarpong Collins Kissiedu', '553287180', 'Faculty', 4, 'collinssa@aiti-kace.com.gh', '$2y$10$lCcX8IP5sL5hnelZ20F45OQjmA6gDheWcI0UPhBKh2R4ElycqO2C6', '', 'Instructor', '1', '2022-08-09 15:28:09', '2022-10-27 12:16:47'),
(56, '1361056', 'Francis Kwame Korsah', '245847179', 'Faculty', 4, 'francisko@aiti-kace.com.gh', '$2y$10$CS.tPlu0975AdXw2Cv2Bq.TIoGvO5OGlizG7hpWtcnvz/UM6NWwWS', '', 'Instructor', '1', '2022-08-09 15:28:09', '2022-10-27 12:16:47'),
(57, '1360939', 'Hermas Songtaa Wasaal', '241834073', 'Faculty', 3, 'hermass@aiti-kace.com.gh', 'testMe', '', 'Instructor', '1', '2022-08-09 15:28:09', '2022-10-27 12:16:47'),
(58, NULL, 'Acheampomah Akua Gama', '541133367', 'Consultancy', 0, 'acheampomaha@aiti-kace.com.gh', '$2y$10$W4MUWDhHMuNMBKan40IonuNcaeHAeAEwxe5ri4lfKQu2Xd8FW/vuu', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(59, '1414263', 'Jude Attuquaye Clottey', '575557050', 'Research and Innovation', 0, 'judecl@aiti-kace.com.gh', '$2y$10$ug2oSSZQnRXVomE9ysl7IOZgsjQWdYsg8ssYcD0MVTYCR5GWCd1AS', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(60, NULL, 'Abigail Tawiah', '595487638', 'Research and Innovation', 0, 'abigtailta@iti-kace.com.gh', '$2y$10$wToEA1tZ7nj1Exwt/VugY.SZVpE4eragcGLOVtFcIhhkMTx3z/.Au', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(61, '1506486', 'Osei Agyeman Tutu', '555845204', 'Corporate Affairs and Media Relations', 0, 'agyemantu@aiti-kace.com.gh', '$2y$10$3D9lq.c1fVhGZ3bmlMHYvuZFjTveEft6MexL79eRlkZfIXixVBNle', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(62, '1473112', 'Moro Abdul-Wahab', '542681415', 'Research and Innovation', 2, 'moroa@aiti-kace.com.gh', '$2y$10$d.Yxf.p9oBVPA1Ij48FyTurzYCiqR5/u06oVXAEWz.FMo62Ufrtz2', '', NULL, '1', '2022-08-09 15:28:09', '2022-10-24 12:29:01'),
(63, '1480763', 'Benjamin Doe Ocansey', '507244002', NULL, 0, 'benjaminoc@aiti-kace.com.gh', '$2y$10$9jsT1zm4MquHrpYbl0y4K.Q3s1D2hPop/FjSD4VdIMs91NN9.3vcq', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(64, NULL, 'Kobi Ossisiadan-Bekoe Hemaa', '244739568', 'Corporate Affairs and Media Relations', 0, 'kobios@aiti-kace.com.gh', '$2y$10$kZjm7egb0RU3O4hDV.OD2.94sd8Hl75FWMW41tP4NSZJArqQmx3Bq', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(65, '1506379', 'Edwin Ocansey Larweh', '205825026', 'Faculty', 5, 'edwinla@aiti-kace.com.gh', '$2y$10$qJLaFIPuLGE0ZeeUIRsTOe7KiRyltOCE68OjWCK0pGCF7i3A8j8dK', '', 'Instructor', '1', '2022-08-09 15:28:09', '2022-10-27 12:16:47'),
(66, '1495839', 'Bismarck Ogbamey Tetteh Nii', '246708651', 'Corporate Affairs and Media Relations', 0, 'ogbameyte@aiti-kace.com.gh', '$2y$10$mZa5mdek74bHdlC7kXjmteyPhU5oMtyd22TfujW5OEuhj/Z.jcD3W', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(67, '1506504', 'Stephen Yiadom Boakye', '242608824', 'NULL', 0, 'stephenyi@aiti-kace.com.gh', '$2y$10$EUCen0HlDm9b9xyCt7hV0.IyY6lLKpRui9lmknTS37z3YQ9Ru8QOG', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(68, '1495896', 'Emmanuella Godlove Osei', '506798145', 'NULL', 0, 'godloveos@aiti-kace.com.gh', '$2y$10$1Ja.XPwdQl1mJhp1Y4ADjOYtemMCTujvqa6T0EfcfDsHgZpgRhynu', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(69, '1480732', 'Kingsley Kumi Owusu', '248105128', NULL, 0, 'kingsleyku@aiti-kace.com.gh', '$2y$10$If3hd7I3WuYdNACTqURxF.QzQgDUQYVzlVHl6F94VJv2zibDmiEKa', '', NULL, '1', '2022-08-09 15:28:09', '2022-08-09 15:28:09'),
(70, NULL, 'Anthionette Ohene-Amoah', '247453461', 'Faculty', 3, 'anthoineto@aiti-kace.com.gh', '$2y$10$PcMl8R217i9Y6W7Rv9MDCOl9uJ7mS1aaA7ArWvHrBgykrRhZcnsc2', '', 'Instructor', '1', '2022-08-09 15:28:10', '2022-10-27 12:16:47'),
(71, NULL, 'Foster Adjei', '546766728', 'Research and Innovation', 0, 'fostera@aiti-kace.com.gh', '$2y$10$kJNCm/1vwqsW6StN8WYuJ.C9RJvcFsOcPFVDRkFUsARdhi98Cm9Hm', '', NULL, '1', '2022-08-09 15:28:10', '2022-08-09 15:28:10'),
(72, '1495819', 'Shadrach Ainoo', '557591616', 'NULL', 0, 'shadrachai@aiti-kace.com.gh', '$2y$10$Zy6mFnTTFdTQZNMABOkvlua10ScMFTJR5oV.AAYxF3lpJjcLvId4O', '', NULL, '1', '2022-08-09 15:28:10', '2022-08-09 15:28:10'),
(73, '1227982', 'Annibert Nanor', '277753394', 'Facility', 0, 'anniberta@aiti-kace.com.gh', '$2y$10$oY11YlZmtQEZYJR6hjQ/huZYZ2L/Lloe3AJR0M2Hd8l3OMwxs.8b6', '', NULL, '1', '2022-08-09 15:28:10', '2022-08-09 15:28:10'),
(74, '1480708', 'Emmanuel Awiti Kuffour', '547410729', 'NULL', 1, 'emmanuelaw@aiti-kace.com.gh', '$2y$10$8c0ZlJD3ShTelllxJRvM8u9t3hX.KaGO92enM5mHZjuaRudXZuOxe', '', NULL, '1', '2022-08-09 15:28:10', '2022-09-19 13:25:49'),
(75, '1361062', 'David Afriyie Osei-Bonsu', '246256177', 'Faculty', 4, 'davidaob@aiti-kace.com.gh', '$2y$10$.8w.RYt3Fhb1rJhP/EUIFea457f5C6m8inbgKshQN2lV5QGS47iWy', '', 'Instructor', '1', '2022-08-09 15:28:10', '2022-10-27 12:16:47'),
(76, '1506510', 'Edmund Dsane Nii Kotey', '244245238', 'NULL', 0, 'edmundds@aiti-kace.com.gh', '$2y$10$dcWsDd8ZaK1X6hy/6s1QL.C3FcR0rqFS2sO2tVMpi7VcK2eqS8wIq', '', NULL, '1', '2022-08-09 15:28:42', '2022-08-09 15:28:42');

-- --------------------------------------------------------

--
-- Table structure for table `staff_role`
--

CREATE TABLE `staff_role` (
  `id` int(255) NOT NULL,
  `staff_name` varchar(255) DEFAULT NULL,
  `course_id` int(255) DEFAULT NULL,
  `batch_id` int(255) DEFAULT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `module_start_date` date DEFAULT NULL,
  `module_end_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Triggers `staff_role`
--
DELIMITER $$
CREATE TRIGGER `after_insert_into_staffRole_insert_into_student_results` AFTER INSERT ON `staff_role` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN
    
INSERT into students_results(students_results.name, students_results.student_id, students_results.batch_id, students_results.status, students_results.module_name, students_results.staff_name)

SELECT students.name, students.student_id, students.batch_id, students.status, 
NEW.module_name, NEW.staff_name
FROM students where students.batch_id = NEW.batch_id GROUP by students.name ORDER by students.name;
    END IF;
    
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_insert_into_staff_role_update_batch_id_on_staff_table` AFTER INSERT ON `staff_role` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN
    
UPDATE staff_details SET staff_details.batch_id = NEW.batch_id 
WHERE staff_details.name = NEW.staff_name;

    END IF;
    
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update_into_staff_role_update_batch_id_on_staff_table` AFTER UPDATE ON `staff_role` FOR EACH ROW BEGIN

    IF (OLD.staff_name != NEW.staff_name)
    THEN
    
UPDATE staff_details SET staff_details.batch_id = NEW.batch_id 
WHERE staff_details.name = NEW.staff_name;

    END IF;
    
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `update_staffName_staff_role_update_staffName_StudentResults` AFTER UPDATE ON `staff_role` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN

UPDATE students_results SET students_results.staff_name = NEW.staff_name 
WHERE students_results.batch_id = OLD.batch_id and students_results.module_name = OLD.module_name;

    END IF;

END
$$
DELIMITER ;

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
-- Triggers `students`
--
DELIMITER $$
CREATE TRIGGER `after_insert_into_student_insert_into_student_results` AFTER INSERT ON `students` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN
    
INSERT into students_results(students_results.name, students_results.student_id, students_results.batch_id, students_results.status,
                             students_results.module_name, students_results.staff_name)

SELECT NEW.name, NEW.student_id, NEW.batch_id, NEW.status, 
staff_role.module_name, staff_role.staff_name
FROM staff_role where staff_role.batch_id = NEW.batch_id GROUP by staff_role.module_name ORDER by staff_role.module_name;
    END IF;
    
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_updating_only_batch_id_insert_into_past_student` AFTER UPDATE ON `students` FOR EACH ROW BEGIN

    IF (OLD.student_id != NEW.student_id or OLD.batch_id != NEW.batch_id)
    Then
     
 INSERT into past_students( past_students.name,past_students.student_id,
                 past_students.batch_id,
 						 past_students.date_of_birth,past_students.contact,past_students.gender,
                         past_students.email,past_students.fees,past_students.status)

SELECT  OLD.name, OLD.student_id, OLD.batch_id,
OLD.date_of_birth, OLD.contact,
OLD.gender, OLD.email, OLD.fees, OLD.status FROM students;

END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_updating_only_batch_id_insert_into_student_results` AFTER UPDATE ON `students` FOR EACH ROW BEGIN

    IF (OLD.student_id != NEW.student_id)
    THEN
    
INSERT into students_results(students_results.name, students_results.student_id, students_results.batch_id, students_results.status,students_results.module_name, students_results.staff_name)

SELECT NEW.name, NEW.student_id, NEW.batch_id, NEW.status, 
staff_role.module_name, staff_role.staff_name
FROM staff_role where staff_role.batch_id = NEW.batch_id  GROUP by staff_role.module_name ORDER by staff_role.module_name;

END IF;
END
$$
DELIMITER ;

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
-- Indexes for table `past_students`
--
ALTER TABLE `past_students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staff_details`
--
ALTER TABLE `staff_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staff_role`
--
ALTER TABLE `staff_role`
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
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `course_batch`
--
ALTER TABLE `course_batch`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `modules`
--
ALTER TABLE `modules`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `past_students`
--
ALTER TABLE `past_students`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `staff_details`
--
ALTER TABLE `staff_details`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT for table `staff_role`
--
ALTER TABLE `staff_role`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `students_results`
--
ALTER TABLE `students_results`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
