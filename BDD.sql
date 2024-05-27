CREATE database university;

CREATE TABLE `absence` (
  `id` int NOT NULL AUTO_INCREMENT,
  `num_semaine` varchar(350) DEFAULT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  `course` varchar(350) DEFAULT NULL,
  `estJustifie` varchar(50) DEFAULT NULL,
  `date_insert` date DEFAULT NULL,
  `date_update` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course` varchar(350) DEFAULT NULL,
  `department` varchar(350) DEFAULT NULL,
  `Salle` varchar(350) DEFAULT NULL,
  `StartTime` int DEFAULT NULL,
  `EndTime` int DEFAULT NULL,
  `Jour` varchar(350) DEFAULT NULL,
  `teacher_id` varchar(350) DEFAULT NULL,
  `full_name` varchar(350) DEFAULT NULL,
  `date_insert` date DEFAULT NULL,
  `date_update` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `demande` (
  `iddemande` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `massar` varchar(255) DEFAULT NULL,
  `classeSouh` varchar(255) DEFAULT NULL,
  `Justification` varchar(255) DEFAULT NULL,
  `date_insert` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  PRIMARY KEY (`iddemande`)
)

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` bigint DEFAULT NULL,
  `full_name` varchar(350) DEFAULT NULL,
  `gender` varchar(350) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `age` int DEFAULT NULL,
  `niveau` varchar(350) DEFAULT NULL,
  `course` varchar(350) DEFAULT NULL,
  `section` varchar(350) DEFAULT NULL,
  `semester` varchar(250) DEFAULT NULL,
  `emailPa` varchar(500) DEFAULT NULL,
  `date_insert` date DEFAULT NULL,
  `date_update` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `teacher_id` varchar(250) DEFAULT NULL,
  `full_name` varchar(350) DEFAULT NULL,
  `gender` varchar(350) DEFAULT NULL,
  `year_experience` varchar(350) DEFAULT NULL,
  `experience` varchar(350) DEFAULT NULL,
  `department` varchar(350) DEFAULT NULL,
  `date_insert` date DEFAULT NULL,
  `date_update` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL,
  `student_id` varchar(350) DEFAULT NULL,
  `teacher_id` varchar(350) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) 