-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema forumdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema forumdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `forumdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `forumdb` ;

-- -----------------------------------------------------
-- Table `forumdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `forumdb`.`user` (
  `id` INT NOT NULL,
  `login` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `role` INT NOT NULL,
  `picture` MEDIUMBLOB NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `forumdb`.`theme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `forumdb`.`theme` (
  `id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `description` TEXT NULL,
  `date` DATETIME NOT NULL,
  `state` INT NOT NULL,
  `rating` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_theme_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_theme`
    FOREIGN KEY (`user_id`)
    REFERENCES `forumdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `forumdb`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `forumdb`.`message` (
  `id` INT NOT NULL,
  `theme_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `date` DATETIME NOT NULL,
  `rating` INT NOT NULL,
  `replied_user_id` INT NULL,
  `text` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_message_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_theme_message_idx` (`theme_id` ASC) VISIBLE,
  INDEX `fk_replied_message_idx` (`replied_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_message`
    FOREIGN KEY (`user_id`)
    REFERENCES `forumdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_theme_message`
    FOREIGN KEY (`theme_id`)
    REFERENCES `forumdb`.`theme` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_replied_message`
    FOREIGN KEY (`replied_user_id`)
    REFERENCES `forumdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `forumdb`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `forumdb`.`tag` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `forumdb`.`tagged`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `forumdb`.`tagged` (
  `tag_id` INT NOT NULL,
  `theme_id` INT NOT NULL,
  INDEX `fk_theme_tagged_idx` (`theme_id` ASC) VISIBLE,
  INDEX `fk_tag_tagged_idx` (`tag_id` ASC) VISIBLE,
  CONSTRAINT `fk_theme_tagged`
    FOREIGN KEY (`theme_id`)
    REFERENCES `forumdb`.`theme` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tag_tagged`
    FOREIGN KEY (`tag_id`)
    REFERENCES `forumdb`.`tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
