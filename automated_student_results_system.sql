-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 21, 2021 at 12:27 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

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
  `course_level` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `course_start_date` date DEFAULT NULL,
  `course_end_date` date DEFAULT NULL,
  `certificate_issuedate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `course_name`, `course_level`, `status`, `created_at`, `updated_at`, `course_start_date`, `course_end_date`, `certificate_issuedate`) VALUES
(1, 'CERTIFICATE IN SOFTWARE DEVELOPMENT', 'CSD1.1', 'Active', '2020-10-15 23:53:42', '2020-10-15 23:54:30', '2020-09-29', '2021-10-10', '2020-10-15'),
(2, 'INTERNATIONAL COMPUTER DRIVING LICENCE', 'ICDL4.2', 'Active', '2020-10-16 00:03:59', '2021-09-28 11:49:41', '2021-09-27', '2022-10-20', '2021-09-28'),
(3, 'CERTIFICATE IN SOFTWARE DEVELOPMENT', 'CSD4.2', 'Active', '2020-10-16 00:06:43', '2020-10-16 00:06:43', '2021-10-18', '2022-03-15', '2020-10-16'),
(4, 'CISCO CERTIFIED NETWORK ASSOCIATE', 'CCNA9.2', 'Active', '2021-09-28 11:15:49', '2021-10-20 13:49:47', '2021-03-15', '2022-11-20', '2021-09-28'),
(5, 'JAVA ENTERPRISE', 'JAVA7.2', 'Active', '2021-09-28 11:21:49', '2021-09-28 11:21:49', '2020-03-15', '2022-03-15', '2021-09-28'),
(6, 'DIPLOMA IN BUSINESS COMPUTING', 'DBC1.1', 'Active', '2021-10-20 14:20:44', '2021-10-20 14:25:55', '2021-10-20', '2021-11-21', '2021-11-30'),
(7, 'NETWORK INFORMATION SECURITY', 'NIS3.8', 'Active', '2021-10-21 16:46:40', '2021-10-21 16:46:40', '2021-10-21', '2021-12-07', '2022-07-19'),
(8, 'CERTIFIED INFORMATION SYSTEM AUDITOR', 'CISA1.1', 'Active', '2021-10-29 11:25:08', '2021-10-29 11:25:08', '2021-10-29', '2021-12-02', '2022-08-10');

-- --------------------------------------------------------

--
-- Table structure for table `modules`
--

CREATE TABLE `modules` (
  `id` int(255) NOT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `staff_name` varchar(255) DEFAULT NULL,
  `course_id` int(250) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `modules`
--

INSERT INTO `modules` (`id`, `module_name`, `course_name`, `staff_name`, `course_id`, `status`, `created_at`, `updated_at`) VALUES
(1, 'HTML/CSS', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD1.1', 'Mr Francis Korsah', 1, 'Active', '2020-10-16 00:08:37', '2021-09-27 16:14:50'),
(2, 'Oracle Database', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD4.2', 'Bismark Otu', 3, 'Active', '2020-10-16 00:09:34', '2021-09-27 16:15:32'),
(3, 'Microsoft', 'INTERNATIONAL COMPUTER DRIVING LICENCE---ICDL4.2', 'Mr Kennedy Asewie', 2, 'Active', '2020-10-16 00:13:11', '2021-10-19 09:56:46'),
(4, 'Oracle Database', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD1.1', 'Bismark Otu', 1, 'Active', '2020-10-16 00:15:10', '2021-09-27 16:15:39'),
(5, 'HTML/CSS', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD4.2', 'Mr Francis Korsah', 3, 'Active', '2020-10-16 00:17:59', '2021-09-27 16:15:55'),
(6, 'Software Engineering', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD1.1', 'Mr Kennedy Asewie', 1, 'Active', '2020-10-16 00:19:53', '2021-09-27 16:15:43'),
(7, 'Software Engineering', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD4.2', 'Mr Kennedy Asewie', 3, 'Active', '2020-10-16 00:20:48', '2021-09-27 16:15:49'),
(8, 'JavaScript', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD1.1', 'Mr Francis Korsah', 1, 'Active', '2021-10-18 15:37:33', '2021-10-18 15:37:33'),
(9, 'Excel', 'INTERNATIONAL COMPUTER DRIVING LICENCE---ICDL4.2', 'Nana Kwesi', 2, 'Active', '2021-09-28 11:11:19', '2021-10-19 09:56:55'),
(10, 'Networking', 'CISCO CERTIFIED NETWORK ASSOCIATE---CCNA9.2', 'Nana Kwesi', 4, 'Active', '2021-09-28 11:16:28', '2021-10-14 14:36:32'),
(11, 'Fundamentals of Computing', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD1.1', 'Mr Francis Korsah', 1, 'Active', '2021-09-28 11:20:15', '2021-10-14 14:37:47'),
(12, 'Maven', 'JAVA ENTERPRISE---JAVA7.2', 'Mr Francis Korsah', 5, 'Active', '2021-09-28 11:22:20', '2021-10-19 10:01:04'),
(13, 'Router Configuration', 'CISCO CERTIFIED NETWORK ASSOCIATE---CCNA9.2', 'Bismark Otu', 4, 'Active', '2021-09-28 11:27:10', '2021-10-14 14:36:53'),
(14, 'Hibernate', 'JAVA ENTERPRISE---JAVA7.2', 'Mr Yao', 5, 'Active', '2021-09-28 11:34:30', '2021-10-19 10:04:01'),
(15, 'Python', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD1.1', 'Elvis Segbewu', 1, 'Active', '2021-09-28 11:39:14', '2021-10-18 13:41:59'),
(16, 'Powerpoint', 'INTERNATIONAL COMPUTER DRIVING LICENCE---ICDL4.2', 'Mr Kennedy Asewie', 2, 'Active', '2021-09-28 11:43:56', '2021-10-19 09:57:05'),
(18, 'CORE JAVA & JDBC', 'DIPLOMA IN BUSINESS COMPUTING---DBC1.1', 'Mr Francis Korsah', NULL, 'Active', '2021-10-20 14:32:31', '2021-10-20 14:38:07'),
(19, 'PHP', 'DIPLOMA IN BUSINESS COMPUTING', 'Mr Edward Yeboah', NULL, 'Active', '2021-10-20 16:12:34', '2021-10-20 16:12:34');

-- --------------------------------------------------------

--
-- Table structure for table `results`
--

CREATE TABLE `results` (
  `id` int(255) NOT NULL,
  `course_id` int(255) DEFAULT NULL,
  `module_id` int(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `staff_id` varchar(255) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `results`
--

INSERT INTO `results` (`id`, `course_id`, `module_id`, `student_id`, `staff_id`, `marks`, `status`, `created_at`, `updated_at`) VALUES
(1, 1, 1, 'CSD1.12020M001', 'St2632', 88, 'Active', '2020-10-15 23:46:34', '2020-10-15 23:46:34'),
(2, 1, 11, 'CSD1.12020M001', 'St2632', 77, 'Active', '2021-10-11 13:21:55', '2021-10-11 13:21:55'),
(3, 1, 15, 'CSD1.12020M001', 'St2632', 55, 'Active', '2021-10-11 13:22:47', '2021-10-11 13:22:47'),
(4, 1, 6, 'CSD1.12020M001', 'St2632', 77, 'Active', '2021-10-11 13:23:29', '2021-10-11 13:23:29'),
(5, 1, 4, 'CSD1.12020M001', 'St2632', 69, 'Active', '2021-10-18 15:36:17', '2021-10-18 15:36:17'),
(6, 1, 8, 'CSD1.12020M001', 'St2632', 59, 'Active', '2021-10-18 15:38:11', '2021-10-18 15:38:11'),
(7, 2, 3, 'ICDL6.82021M045', 'St7308', 88, 'Active', '2021-10-18 16:08:56', '2021-10-18 16:08:56'),
(8, 5, 12, 'Java2020M009', 'St2632', 69, 'Active', '2021-10-19 10:05:53', '2021-10-19 10:07:13'),
(9, 5, 14, 'Java2020M009', 'ST7834', 88, 'Active', '2021-10-19 10:06:29', '2021-10-19 10:07:20');

-- --------------------------------------------------------

--
-- Table structure for table `staffs`
--

CREATE TABLE `staffs` (
  `id` int(250) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `staff_id` varchar(255) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact` varchar(250) DEFAULT NULL,
  `usertype` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staffs`
--

INSERT INTO `staffs` (`id`, `name`, `staff_id`, `email`, `contact`, `usertype`, `course`, `status`, `created_at`, `updated_at`) VALUES
(1, 'Mr Francis Korsah', 'St2632', 'firstinstructor@aiti-kace.com.gh', '0555560810', 'Instructor', 'CERTIFICATE IN SOFTWARE DEVELOPMENT', 'Active', '2021-09-18 08:55:07', '2021-09-22 11:28:20'),
(3, 'Mr Gabriel Dwamena', 'St3073', 'coursecordinator@aiti-kace.com.gh', '0207638264', 'Course Cordinator', NULL, 'Active', '2021-09-18 08:51:50', '2021-10-20 15:25:14'),
(7, 'Bismark Otu', 'ST41941', 'bismarko@aiti-kace.com.gh', '0549057688', 'Instructor', 'CERTIFICATE IN SOFTWARE DEVELOPMENT', 'Active', '2021-09-24 10:47:14', '2021-09-24 10:47:14'),
(10, 'Elvis Segbawu', 'ST5645', 'elviss@aiti-kace.com.gh', '0505736458', 'Instructor', 'CERTIFICATE IN SOFTWARE DEVELOPMENT	', 'Active', '2021-10-20 16:00:15', '2021-10-20 16:02:19'),
(9, 'Mr Hermas Songtaa', 'ST5768', 'hermass@aiti-kace.com.gh', '0548276444', 'Instructor', 'CERTIFICATE IN SOFTWARE DEVELOPMENT', 'Active', '2021-10-20 14:06:27', '2021-10-20 14:06:27'),
(12, 'Mr Edward Yeboah', 'ST6580', 'edwardy@aiti-kace.com.gh', '0249658903', 'Instructor', 'DIPLOMA IN BUSINESS COMPUTING', 'Active', '2021-10-20 16:12:11', '2021-10-20 16:12:11'),
(2, 'Mr Lawrence Kpodo', 'St6833', 'academicsecretary@aiti-kace.com.gh', '0547386724', 'Academic Secretary', NULL, 'Active', '2021-09-18 08:50:25', '2021-10-20 15:25:22'),
(5, 'Mr Kennedy Asewie', 'St7308', 'secondinstructor@aiti-kace.com.gh', '0542426541', 'Instructor', 'INTERNATIONAL COMPUTER DRIVING LICENCE', 'Active', '2021-09-18 09:19:34', '2021-09-23 15:44:36'),
(11, 'Jude Clottey', 'ST7429', 'judec@aiti-kace.com.gh', '0275856453', 'Instructor', 'CERTIFICATE IN SOFTWARE DEVELOPMENT', 'Active', '2021-10-20 16:09:35', '2021-10-20 16:09:35'),
(6, 'Mr Yao', 'ST7834', 'yaoa@aiti-kace.com.gh', '0207457634', 'Instructor', 'JAVA ENTERPRISE', 'Active', '2021-10-19 10:03:24', '2021-10-19 10:03:24'),
(8, 'Nana Kwesi', 'St845', 'nanakwesi1006@hotmail.com', '0247016266', 'Instructor', 'International Computer Driving Licence', 'Active', '2021-09-24 10:49:08', '2021-09-24 10:52:25'),
(13, 'Mr Isaac', 'ST8920', 'isaaca@aiti-kace.com.gh', '0573856354', 'Instructor', 'NETWORK INFORMATION SECURITY', 'Active', '2021-10-21 16:49:37', '2021-10-21 16:49:37'),
(4, 'Dr Yaw Okraku-Yirenkyi', 'St9462', 'directorofstudies@aiti-kace.com.gh', '0207693568', 'Director of Studies', NULL, 'Active', '2021-09-18 09:04:03', '2021-10-20 17:08:19');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(255) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `student_id` varchar(255) NOT NULL,
  `course_id` int(255) DEFAULT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `name`, `student_id`, `course_id`, `date_of_birth`, `contact`, `gender`, `email`, `status`, `created_at`, `updated_at`) VALUES
(1, 'Nana Kwesi', 'CSD1.12020M001', 1, '2000-11-20', '0555560810', 'male', 'firststudent@aiti-kace.com.gh', 'Active', '2021-09-15 12:16:36', '2021-10-18 11:59:09'),
(8, 'Akeem Amosu', 'CSD1.22021M002', 1, '2021-11-30', '0570578396', 'Male', 'akeem@gmail.com', 'Active', '2021-12-16 12:39:20', '2021-12-16 12:39:20'),
(10, 'Francis Annan', 'CSD1.22021M003', 2, '2021-12-02', '0208362456', 'Male', 'francisannan@gmail.com', 'Active', '2021-12-16 12:47:48', '2021-12-16 12:47:48'),
(9, 'Eugene Asante', 'DBC2020M011', 6, '2021-12-01', '0570578396', 'Male', 'eugeneasante654@hotmail.com', 'Active', '2021-12-16 12:45:02', '2021-12-16 12:45:02'),
(4, 'Bismark Otu', 'DBC2020M038', 6, '2001-10-14', '0570578396', 'Male', 'bismarkotu10@gmail.com', 'Active', '2021-10-29 13:43:34', '2021-10-29 14:08:08'),
(2, 'Mary Otu', 'ICDL6.82021M045', 2, '2001-10-14', '0209563478', 'Female', 'maryotu1006@gmail.com', 'Active', '2021-10-11 13:19:47', '2021-10-19 16:49:31'),
(3, 'Solomon OKyere', 'Java2020M009', 5, '1999-11-30', '0547457890', 'Male', 'solomonokyere2843@gmail.com', 'Active', '2021-10-19 09:52:47', '2021-10-19 16:49:34'),
(11, 'Moses Otu', 'JAVA2020M011', 5, '2021-11-28', '0249653674', 'Male', 'mosesotu@gmail.com', 'Active', '2021-12-16 17:01:27', '2021-12-16 17:01:27');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(250) NOT NULL,
  `usertype` varchar(255) DEFAULT NULL,
  `staff_id` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `usertype`, `staff_id`, `email`, `password`, `status`, `created_at`, `updated_at`) VALUES
(1, 'Instructor', 'St2632', 'firstinstructor@aiti-kace.com.gh', 'fristInstructor', 'Active', '2021-09-18 09:14:49', '2021-09-28 14:14:23'),
(2, 'Instructor', 'St7308', 'secondinstructor@aiti-kace.com.gh', 'secondInstructor', 'Active', '2021-09-15 14:18:26', '2021-09-28 14:14:57'),
(3, 'academic secretary', 'St6833', 'academicsecretary@gamil.com', 'academicSecretary', 'Active', '2021-09-15 14:34:05', '2021-09-28 14:15:12'),
(4, 'course cordinator', 'St3073', 'coursecordinator@aiti-kace.com.gh', 'courseCordinator', 'Active', '2021-09-18 08:47:24', '2021-09-28 14:15:26'),
(5, 'director of studies', 'St9462', 'directorofstudies@aiti-kace.com.gh', 'directorOfStudies', 'Active', '2021-09-18 09:03:00', '2021-09-28 14:15:33');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `modules`
--
ALTER TABLE `modules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `course_ibfk_4` (`course_id`);

--
-- Indexes for table `results`
--
ALTER TABLE `results`
  ADD PRIMARY KEY (`id`),
  ADD KEY `results_ibfk_1` (`staff_id`),
  ADD KEY `results_ibfk_2` (`student_id`),
  ADD KEY `results_ibfk_3` (`course_id`),
  ADD KEY `results_ibfk_4` (`module_id`);

--
-- Indexes for table `staffs`
--
ALTER TABLE `staffs`
  ADD PRIMARY KEY (`staff_id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `course_id_fk` (`course_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `staff_idfk_1` (`staff_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `modules`
--
ALTER TABLE `modules`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `results`
--
ALTER TABLE `results`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `staffs`
--
ALTER TABLE `staffs`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `modules`
--
ALTER TABLE `modules`
  ADD CONSTRAINT `course_ibfk_4` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`);

--
-- Constraints for table `results`
--
ALTER TABLE `results`
  ADD CONSTRAINT `results_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staffs` (`staff_id`),
  ADD CONSTRAINT `results_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
  ADD CONSTRAINT `results_ibfk_3` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  ADD CONSTRAINT `results_ibfk_4` FOREIGN KEY (`module_id`) REFERENCES `modules` (`id`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `course_id_fk` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `staff_idfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staffs` (`staff_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
