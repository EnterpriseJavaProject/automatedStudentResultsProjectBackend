-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 14, 2022 at 05:41 PM
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
  `course_level` varchar(255) DEFAULT NULL,
  `coordinator` varchar(250) DEFAULT NULL,
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

INSERT INTO `courses` (`id`, `course_name`, `course_level`, `coordinator`, `status`, `created_at`, `updated_at`, `course_start_date`, `course_end_date`, `certificate_issuedate`) VALUES
(13, 'CERTIFICATE IN SOFTWARE DEVELOPMENT', 'CSD1.1', 'Bismark Otu', 'Active', '2022-06-28 14:06:07', '2022-06-28 14:06:07', '2022-06-28', '2022-07-14', '2022-09-21'),
(14, 'INTERNATIONAL COMPUTER DRIVING LICENECE', 'ICDL1.1', 'Jude Clottey', 'Active', '2022-06-28 14:06:32', '2022-06-28 14:06:32', '2022-07-12', '2022-08-18', '2022-10-21');

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
(27, 'FOC', 'CERTIFICATE IN SOFTWARE DEVELOPMENT', 'Elvis Segbawu', 13, 'Active', '2022-06-29', '2022-08-11', '2022-06-28 14:08:08', '2022-06-28 14:08:08'),
(28, 'Html', 'CERTIFICATE IN SOFTWARE DEVELOPMENT', 'Elvis Segbawu', 13, 'Active', '2022-06-30', '2022-07-15', '2022-06-28 14:08:29', '2022-06-28 14:08:29'),
(29, 'Powerpoint', 'INTERNATIONAL COMPUTER DRIVING LICENECE', 'Elvis Segbawu', 14, 'Active', '2022-06-30', '2022-07-14', '2022-06-28 14:11:30', '2022-06-28 14:11:30'),
(30, 'Microsoft word', 'INTERNATIONAL COMPUTER DRIVING LICENECE', 'Elvis Segbawu', 14, 'Active', '2022-07-13', '2022-08-19', '2022-06-28 14:11:44', '2022-06-28 14:11:44'),
(31, 'Excel', 'INTERNATIONAL COMPUTER DRIVING LICENECE', 'Elvis Segbawu', 14, 'Active', '2022-07-06', '2022-09-14', '2022-06-28 15:03:17', '2022-06-28 15:03:17'),
(32, 'Digital Marketing', 'INTERNATIONAL COMPUTER DRIVING LICENECE', 'Elvis Segbawu', 14, 'Active', '2022-07-21', '2022-09-08', '2022-06-28 15:27:48', '2022-06-28 15:27:48');

--
-- Triggers `modules`
--
DELIMITER $$
CREATE TRIGGER `after_inserting_into_modules` AFTER INSERT ON `modules` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN
    
INSERT into students_results(students_results.module_id, students_results.module_name, students_results.course_id, students_results.staff_name, students_results.status,  
                             students_results.name, students_results.student_id)

SELECT NEW.id, NEW.module_name, NEW.course_id , NEW.staff_name, NEW.status, 
students.name, students.student_id
FROM students where students.course_id = NEW.course_id GROUP by students.name ORDER by students.name;


    END IF;
    


END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_inserting_into_modules_update_course_id_on_staff_table` AFTER INSERT ON `modules` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN
    

UPDATE staffs SET staffs.course_id = NEW.course_id 
WHERE staffs.name = NEW.staff_name;

END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_updating_only_course_id_on_modules` AFTER UPDATE ON `modules` FOR EACH ROW BEGIN

    IF (OLD.course_id != NEW.course_id)
    THEN
    

UPDATE staffs SET staffs.course_id = NEW.course_id 
WHERE staffs.course_id = OLD.course_id and staffs.name = OLD.staff_name;

END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `past_students`
--

CREATE TABLE `past_students` (
  `id` int(255) DEFAULT NULL,
  `name` varchar(250) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `course_id` int(255) DEFAULT NULL,
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
(4, 'Dr Yaw Okraku-Yirenkyi', 'St9462', 'directorofstudies@aiti-kace.com.gh', '0207693568', 'Director', NULL, 'Active', '2021-09-18 09:04:03', '2022-06-22 13:25:41'),
(19, 'Bismark Otu', 'ST1405476', 'bismarko@aiti-kace.com.gh', '0276890865', 'Course Cordinator', NULL, 'Active', '2022-06-28 11:38:00', '2022-06-28 11:38:00'),
(20, 'Jude Clottey', 'ST1760989', 'judec@aiti-kace.com.gh', '0555555556', 'Course Cordinator', NULL, 'Active', '2022-06-28 11:38:41', '2022-06-28 11:38:41'),
(21, 'Mr Lawrence Kpodo', 'ST1406798', 'lawrencek@aiti-kace.com.gh', '0208362456', 'Academic Secretary', NULL, 'Active', '2022-06-28 11:39:47', '2022-06-28 11:39:47'),
(22, 'Elvis Segbawu', 'ST1406798', 'bismarko@aiti-kace.com.gh', '0208362456', 'Instructor', 14, 'Active', '2022-06-28 11:55:11', '2022-06-28 14:51:38'),
(23, 'Nana Kwesi', 'ST1760559', 'nana@aiti-kace.com.gh', '0247016266', 'Instructor', 13, 'Active', '2022-07-06 15:20:45', '2022-07-06 15:20:45');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(255) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `course_id` int(255) DEFAULT NULL,
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
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `name`, `student_id`, `course_id`, `date_of_birth`, `contact`, `gender`, `email`, `fees`, `status`, `created_at`, `updated_at`) VALUES
(7, 'Solomon Okyere', 'ICDL2022M001', 14, '2022-07-01T00:00:00.000Z', '0276890865', 'male', 'solomonokyere89@gmail.com', 'Full Payment', 'Active', '2022-07-06 14:28:34', '2022-07-06 14:28:34');

--
-- Triggers `students`
--
DELIMITER $$
CREATE TRIGGER `after_inserting_into_student` AFTER INSERT ON `students` FOR EACH ROW BEGIN

    IF (NEW.status = 'Active')
    THEN
    
INSERT into students_results(students_results.name, students_results.student_id, students_results.course_id, students_results.status,
                             students_results.module_name, students_results.module_id, students_results.staff_name)

SELECT NEW.name, NEW.student_id, NEW.course_id, NEW.status, 
modules.module_name, modules.id, modules.staff_name
FROM modules where modules.course_id = NEW.course_id GROUP by modules.module_name ORDER by modules.module_name;



    END IF;
    


END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_updating_only_course_id` AFTER UPDATE ON `students` FOR EACH ROW BEGIN

    IF (OLD.course_id != NEW.course_id)
    THEN
    
INSERT into students_results(students_results.name, students_results.student_id, students_results.course_id, students_results.status,
                             students_results.module_name, students_results.module_id, students_results.staff_name)

SELECT NEW.name, NEW.student_id, NEW.course_id, NEW.status, 
modules.module_name, modules.id, modules.staff_name
FROM modules where modules.course_id = NEW.course_id GROUP by modules.module_name ORDER by modules.module_name;



    END IF;

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_updating_only_course_id_insert_into_past_student` AFTER UPDATE ON `students` FOR EACH ROW BEGIN

    IF (NEW.course_id != OLD.course_id)
    Then
    
  
 INSERT into past_students(past_students.id, past_students.name,past_students.student_id,past_students.course_id,
 						 past_students.date_of_birth,past_students.contact,past_students.gender,
                         past_students.email,past_students.fees,past_students.status)

SELECT OLD.id, OLD.name, OLD.student_id, OLD.course_id,
OLD.date_of_birth, OLD.contact,
OLD.gender, OLD.email, OLD.fees, OLD.status FROM students;


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
  `course_id` int(255) DEFAULT NULL,
  `module_id` int(100) DEFAULT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `staff_name` varchar(255) DEFAULT NULL,
  `marks` int(100) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students_results`
--

INSERT INTO `students_results` (`id`, `name`, `student_id`, `course_id`, `module_id`, `module_name`, `staff_name`, `marks`, `status`, `created_at`, `updated_at`) VALUES
(17, 'Solomon Okyere', 'ICDL2022M001', 14, 32, 'Digital Marketing', 'Elvis Segbawu', NULL, 'Active', '2022-07-06 14:28:34', '2022-07-06 14:28:34'),
(18, 'Solomon Okyere', 'ICDL2022M001', 14, 31, 'Excel', 'Elvis Segbawu', NULL, 'Active', '2022-07-06 14:28:34', '2022-07-06 14:28:34'),
(19, 'Solomon Okyere', 'ICDL2022M001', 14, 30, 'Microsoft word', 'Elvis Segbawu', NULL, 'Active', '2022-07-06 14:28:34', '2022-07-06 14:28:34'),
(20, 'Solomon Okyere', 'ICDL2022M001', 14, 29, 'Powerpoint', 'Elvis Segbawu', NULL, 'Active', '2022-07-06 14:28:34', '2022-07-06 14:28:34');

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
(5, 'Director', 'St9462', 'directorofstudies@aiti-kace.com.gh', 'directorOfStudies', 'Active', '2021-09-18 09:03:00', '2022-06-22 13:25:54'),
(11, 'Course Cordinator', 'ST1405476', 'bismarko@aiti-kace.com.gh', 'Openforme', 'Active', '2022-06-28 11:38:00', '2022-06-28 11:38:00'),
(12, 'Course Cordinator', 'ST1760989', 'judec@aiti-kace.com.gh', 'Openforme', 'Active', '2022-06-28 11:38:41', '2022-06-28 11:38:41'),
(13, 'Academic Secretary', 'ST1406798', 'lawrencek@aiti-kace.com.gh', 'academic', 'Active', '2022-06-28 11:39:47', '2022-06-28 11:39:47'),
(14, 'Instructor', 'ST1406798', 'elvis@aiti-kace.com.gh', 'directorOfStudies', 'Active', '2022-06-28 11:55:11', '2022-06-28 11:55:11'),
(15, 'Instructor', 'ST1760559', 'nana@aiti-kace.com.gh', 'directorOfStudies', 'Active', '2022-07-06 15:20:45', '2022-07-06 15:20:45');

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
  ADD KEY `hg_stu` (`student_id`),
  ADD KEY `hg_cour` (`course_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `modules`
--
ALTER TABLE `modules`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `staffs`
--
ALTER TABLE `staffs`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `students_results`
--
ALTER TABLE `students_results`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
