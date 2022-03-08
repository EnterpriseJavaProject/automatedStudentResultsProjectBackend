-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 08, 2022 at 05:04 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.26

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
(1, 'CERTIFICATE IN SOFTWARE DEVELOPMENT', 'CSD1.1', 'Active', '2020-10-15 23:53:42', '2022-03-08 10:29:28', '2020-09-08', '2021-10-10', '2020-10-15'),
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
  `module_start_date` date DEFAULT NULL,
  `module_end_date` date DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `modules`
--

INSERT INTO `modules` (`id`, `module_name`, `course_name`, `staff_name`, `course_id`, `status`, `module_start_date`, `module_end_date`, `created_at`, `updated_at`) VALUES
(1, 'HTML/CSS', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD1.1', 'Mr Francis Korsah', 1, 'Active', '2020-09-08', '2022-10-20', '2020-10-16 00:08:37', '2022-03-08 10:32:11'),
(2, 'Oracle Database', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD4.2', 'Bismark Otu', 3, 'Active', '2020-09-08', '2022-10-20', '2020-10-16 00:09:34', '2022-03-08 10:32:14'),
(3, 'Microsoft', 'INTERNATIONAL COMPUTER DRIVING LICENCE---ICDL4.2', 'Mr Kennedy Asewie', 2, 'Active', '2020-09-08', '2022-10-20', '2020-10-16 00:13:11', '2022-03-08 10:32:18'),
(4, 'Oracle Database', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD1.1', 'Bismark Otu', 1, 'Active', '2020-09-08', '2022-10-20', '2020-10-16 00:15:10', '2022-03-08 10:32:20'),
(5, 'HTML/CSS', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD4.2', 'Mr Francis Korsah', 3, 'Active', '2020-09-08', '2022-10-20', '2020-10-16 00:17:59', '2022-03-08 10:32:22'),
(6, 'Software Engineering', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD1.1', 'Mr Kennedy Asewie', 1, 'Active', '2020-09-08', '2022-10-20', '2020-10-16 00:19:53', '2022-03-08 10:32:25'),
(7, 'Software Engineering', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD4.2', 'Mr Kennedy Asewie', 3, 'Active', NULL, '2022-10-20', '2020-10-16 00:20:48', '2022-03-08 10:32:29'),
(8, 'JavaScript', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD1.1', 'Mr Francis Korsah', 1, 'Active', '2020-09-08', '2022-10-20', '2021-10-18 15:37:33', '2022-03-08 10:32:31'),
(9, 'Excel', 'INTERNATIONAL COMPUTER DRIVING LICENCE---ICDL4.2', 'Nana Kwesi', 2, 'Active', '2020-09-08', '2022-10-20', '2021-09-28 11:11:19', '2022-03-08 10:32:33'),
(10, 'Networking', 'CISCO CERTIFIED NETWORK ASSOCIATE---CCNA9.2', 'Nana Kwesi', 4, 'Active', '2020-09-08', '2022-10-20', '2021-09-28 11:16:28', '2022-03-08 10:32:35'),
(11, 'Fundamentals of Computing', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD1.1', 'Mr Francis Korsah', 1, 'Active', '2020-09-08', '2022-10-20', '2021-09-28 11:20:15', '2022-03-08 10:32:38'),
(12, 'Maven', 'JAVA ENTERPRISE---JAVA7.2', 'Mr Francis Korsah', 5, 'Active', '2020-09-08', '2022-10-20', '2021-09-28 11:22:20', '2022-03-08 10:32:39'),
(13, 'Router Configuration', 'CISCO CERTIFIED NETWORK ASSOCIATE---CCNA9.2', 'Bismark Otu', 4, 'Active', '2020-09-08', '2022-10-20', '2021-09-28 11:27:10', '2022-03-08 10:32:41'),
(14, 'Hibernate', 'JAVA ENTERPRISE---JAVA7.2', 'Mr Yao', 5, 'Active', '2020-09-08', '2022-10-20', '2021-09-28 11:34:30', '2022-03-08 10:32:43'),
(15, 'Python', 'CERTIFICATE IN SOFTWARE DEVELOPMENT---CSD1.1', 'Elvis Segbewu', 1, 'Active', '2020-09-08', '2022-10-20', '2021-09-28 11:39:14', '2022-03-08 10:32:47'),
(16, 'Powerpoint', 'INTERNATIONAL COMPUTER DRIVING LICENCE---ICDL4.2', 'Mr Kennedy Asewie', 2, 'Active', '2020-09-08', '2022-10-20', '2021-09-28 11:43:56', '2022-03-08 10:32:49'),
(18, 'CORE JAVA & JDBC', 'DIPLOMA IN BUSINESS COMPUTING---DBC1.1', 'Mr Francis Korsah', 6, 'Active', '2020-09-08', '2022-10-20', '2021-10-20 14:32:31', '2022-03-08 10:32:51'),
(19, 'PHP', 'DIPLOMA IN BUSINESS COMPUTING', 'Mr Edward Yeboah', 6, 'Active', '2020-09-08', '2022-10-20', '2021-10-20 16:12:34', '2022-03-08 10:32:53');

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
  `course_id` int(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staffs`
--

INSERT INTO `staffs` (`id`, `name`, `staff_id`, `email`, `contact`, `usertype`, `course_id`, `status`, `created_at`, `updated_at`) VALUES
(1, 'Mr Francis Korsah', 'St2632', 'firstinstructor@aiti-kace.com.gh', '0555560810', 'Instructor', 1, 'Active', '2021-09-18 08:55:07', '2022-03-08 11:53:06'),
(2, 'Mr Lawrence Kpodo', 'St6833', 'academicsecretary@aiti-kace.com.gh', '0547386724', 'Academic Secretary', NULL, 'Active', '2021-09-18 08:50:25', '2021-10-20 15:25:22'),
(3, 'Mr Gabriel Dwamena', 'St3073', 'coursecordinator@aiti-kace.com.gh', '0207638264', 'Course Cordinator', NULL, 'Active', '2021-09-18 08:51:50', '2021-10-20 15:25:14'),
(4, 'Dr Yaw Okraku-Yirenkyi', 'St9462', 'directorofstudies@aiti-kace.com.gh', '0207693568', 'Director of Studies', NULL, 'Active', '2021-09-18 09:04:03', '2021-10-20 17:08:19'),
(5, 'Kennedy Asewie', 'St7308', 'secondinstructor@aiti-kace.com.gh', '0542426541', 'Instructor', 2, 'Active', '2021-09-18 09:19:34', '2022-03-08 11:53:22'),
(6, 'Mr Yao', 'ST7834', 'yaoa@aiti-kace.com.gh', '0207457634', 'Instructor', 5, 'Active', '2021-10-19 10:03:24', '2022-03-08 11:53:30'),
(7, 'Bismark Otu', 'ST41941', 'bismarko@aiti-kace.com.gh', '0549057688', 'Instructor', 3, 'Active', '2021-09-24 10:47:14', '2022-03-08 11:54:03'),
(8, 'Nana Kwesi', 'St845', 'nanakwesi1006@hotmail.com', '0247016266', 'Instructor', 2, 'Active', '2021-09-24 10:49:08', '2022-03-08 11:54:09'),
(9, 'Mr Hermas Songtaa', 'ST5768', 'hermass@aiti-kace.com.gh', '0548276444', 'Instructor', 1, 'Active', '2021-10-20 14:06:27', '2022-03-08 11:54:14'),
(10, 'Elvis Segbawu', 'ST5645', 'elviss@aiti-kace.com.gh', '0505736458', 'Instructor', 3, 'Active', '2021-10-20 16:00:15', '2022-03-08 11:54:19'),
(11, 'Jude Clottey', 'ST7429', 'judec@aiti-kace.com.gh', '0275856453', 'Instructor', 1, 'Active', '2021-10-20 16:09:35', '2022-03-08 11:54:23'),
(12, 'Mr Edward Yeboah', 'ST6580', 'edwardy@aiti-kace.com.gh', '0249658903', 'Instructor', 6, 'Active', '2021-10-20 16:12:11', '2022-03-08 11:54:34'),
(13, 'Mr Isaac', 'ST8920', 'isaaca@aiti-kace.com.gh', '0573856354', 'Instructor', 7, 'Active', '2021-10-21 16:49:37', '2022-03-08 11:54:41');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(255) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `course_id` int(255) DEFAULT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fees` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `name`, `student_id`, `course_id`, `date_of_birth`, `contact`, `gender`, `email`, `fees`, `status`, `created_at`, `updated_at`) VALUES
(1, 'Nana Kwesi', 'CSD1.12020M001', 1, '2000-11-20', '0555560810', 'Male', 'firststudent@aiti-kace.com.gh', '', 'Active', '2021-09-15 12:16:36', '2022-02-28 11:34:57'),
(2, 'Mary Otu', 'ICDL6.82021M045', 2, '2001-10-14', '0209563478', 'Female', 'maryotu1006@gmail.com', '', 'Active', '2021-10-11 13:19:47', '2021-10-19 16:49:31'),
(3, 'Solomon OKyere', 'Java2020M009', 5, '1999-11-30', '0547457890', 'Male', 'solomonokyere2843@gmail.com', '', 'Active', '2021-10-19 09:52:47', '2021-10-19 16:49:34'),
(4, 'Bismark Otu', 'DBC2020M038', 6, '2001-10-14', '0570578396', 'Male', 'bismarkotu10@gmail.com', '', 'Active', '2021-10-29 13:43:34', '2021-10-29 14:08:08'),
(8, 'Akeem Amosu', 'CSD1.22021M002', 1, '2021-11-30', '0570578396', 'Male', 'akeem@gmail.com', '', 'Active', '2021-12-16 12:39:20', '2021-12-16 12:39:20'),
(9, 'Eugene Asante', 'DBC2020M011', 6, '2021-12-01', '0570578396', 'Male', 'eugeneasante654@hotmail.com', '', 'Active', '2021-12-16 12:45:02', '2021-12-16 12:45:02'),
(10, 'Francis Annan', 'CSD1.22021M003', 2, '2021-12-02', '0208362456', 'Male', 'francisannan@gmail.com', '', 'Active', '2021-12-16 12:47:48', '2021-12-16 12:47:48'),
(11, 'Moses Otu', 'JAVA2020M011', 5, '2021-11-28', '0249653674', 'Male', 'mosesotu@gmail.com', '', 'Active', '2021-12-16 17:01:27', '2021-12-16 17:01:27'),
(12, 'Oscar Opoku', 'CSD1.22021M034', 3, '1999-01-01', '0578456789', 'Male', 'oscaropoku23@gmail.com', '', 'Active', '2022-01-18 10:07:14', '2022-01-18 10:07:14'),
(13, 'Asante Richard', 'CSD1.22021M022', 3, '1999-01-01', '0507384658', 'Male', 'asanterichard3@gmail.com', '', 'Active', '2022-01-18 10:08:39', '2022-01-18 10:08:39'),
(14, 'Felix Annan', 'CSD2020M027', 1, '2022-01-24', '0549057666', 'Male', 'felixannan22@gmail.com', '', 'Active', '2022-01-24 09:31:12', '2022-01-24 09:31:12');

-- --------------------------------------------------------

--
-- Table structure for table `students_results`
--

CREATE TABLE `students_results` (
  `id` int(255) NOT NULL,
  `studentname` varchar(255) DEFAULT NULL,
  `studentid` varchar(255) DEFAULT NULL,
  `course_id` int(255) DEFAULT NULL,
  `modulename` varchar(255) DEFAULT NULL,
  `staffname` varchar(255) DEFAULT NULL,
  `marks` int(100) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
-- Indexes for table `staffs`
--
ALTER TABLE `staffs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cou_fk` (`course_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `student_id` (`student_id`),
  ADD KEY `fk_course` (`course_id`);

--
-- Indexes for table `students_results`
--
ALTER TABLE `students_results`
  ADD PRIMARY KEY (`id`),
  ADD KEY `hg_stu` (`studentid`),
  ADD KEY `hg_cour` (`course_id`);

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
-- AUTO_INCREMENT for table `staffs`
--
ALTER TABLE `staffs`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `students_results`
--
ALTER TABLE `students_results`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `modules`
--
ALTER TABLE `modules`
  ADD CONSTRAINT `fk_course_id` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`);

--
-- Constraints for table `staffs`
--
ALTER TABLE `staffs`
  ADD CONSTRAINT `cou_fk` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`);

--
-- Constraints for table `students_results`
--
ALTER TABLE `students_results`
  ADD CONSTRAINT `hg_cour` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  ADD CONSTRAINT `hg_stu` FOREIGN KEY (`studentid`) REFERENCES `students` (`student_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
