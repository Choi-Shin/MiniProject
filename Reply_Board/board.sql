-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `db1` ;

-- -----------------------------------------------------
-- Table `db1`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db1`.`board` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `content` TEXT NULL DEFAULT NULL,
  `writer` VARCHAR(50) NOT NULL,
  `regdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hit` INT NULL DEFAULT '0',
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `db1`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db1`.`member` (
  `id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `regdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `db1`.`notice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db1`.`notice` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `content` TEXT NULL DEFAULT NULL,
  `writer` VARCHAR(50) NOT NULL DEFAULT '관리자',
  `regdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hit` INT NULL DEFAULT '0',
  PRIMARY KEY (`no`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `db1`.`notice_reply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db1`.`notice_reply` (
  `notice_no` INT NOT NULL,
  `reply_no` INT NOT NULL,
  `writer` VARCHAR(24) NOT NULL,
  `memo` TEXT NULL DEFAULT NULL,
  `regDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`reply_no`),
  INDEX `notice_no` (`notice_no` ASC) VISIBLE,
  CONSTRAINT `notice_reply_ibfk_1`
    FOREIGN KEY (`notice_no`)
    REFERENCES `db1`.`notice` (`no`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `db1`.`reply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db1`.`reply` (
  `board_no` INT NOT NULL,
  `reply_no` INT NOT NULL,
  `writer` VARCHAR(24) NOT NULL,
  `memo` TEXT NULL DEFAULT NULL,
  `regDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`reply_no`),
  INDEX `board_no` (`board_no` ASC) VISIBLE,
  CONSTRAINT `reply_ibfk_1`
    FOREIGN KEY (`board_no`)
    REFERENCES `db1`.`board` (`no`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
