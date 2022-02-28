-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema miniproject
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema miniproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `miniproject` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `miniproject` ;

-- -----------------------------------------------------
-- Table `miniproject`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`board` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `content` LONGTEXT NULL DEFAULT NULL,
  `writer` VARCHAR(50) NOT NULL,
  `regdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hit` INT NULL DEFAULT '0',
  `state` INT NOT NULL DEFAULT '1',
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`member` (
  `id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `profile` BLOB NULL DEFAULT NULL,
  `email` VARCHAR(30) NOT NULL,
  `regdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` INT NOT NULL DEFAULT '1',
  `auth_status` INT NOT NULL DEFAULT '0',
  `auth_key` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`message` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `recv_id` VARCHAR(45) NOT NULL,
  `send_id` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `note` TEXT NOT NULL,
  `date_sent` TIMESTAMP NOT NULL,
  `date_read` TIMESTAMP NULL DEFAULT NULL,
  `recv_read` CHAR(1) NOT NULL DEFAULT 'N',
  `recv_del` CHAR(1) NOT NULL DEFAULT 'N',
  `sent_del` CHAR(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`notice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`notice` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `content` LONGTEXT NULL DEFAULT NULL,
  `writer` VARCHAR(50) NOT NULL DEFAULT '관리자',
  `regdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hit` INT NULL DEFAULT '0',
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`notice_reply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`notice_reply` (
  `notice_no` INT NOT NULL,
  `reply_no` INT NOT NULL,
  `writer` VARCHAR(24) NOT NULL,
  `memo` TEXT NULL DEFAULT NULL,
  `regDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  INDEX `notice_no` (`notice_no` ASC) VISIBLE,
  CONSTRAINT `notice_reply_ibfk_1`
    FOREIGN KEY (`notice_no`)
    REFERENCES `miniproject`.`notice` (`no`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `miniproject`.`reply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miniproject`.`reply` (
  `board_no` INT NOT NULL,
  `reply_no` INT NOT NULL,
  `writer` VARCHAR(24) NOT NULL,
  `memo` TEXT NULL DEFAULT NULL,
  `regDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  INDEX `board_no` (`board_no` ASC) VISIBLE,
  CONSTRAINT `reply_ibfk_1`
    FOREIGN KEY (`board_no`)
    REFERENCES `miniproject`.`board` (`no`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
