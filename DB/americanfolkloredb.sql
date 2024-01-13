-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema americanfolkloredb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `americanfolkloredb` ;

-- -----------------------------------------------------
-- Schema americanfolkloredb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `americanfolkloredb` DEFAULT CHARACTER SET utf8 ;
USE `americanfolkloredb` ;

-- -----------------------------------------------------
-- Table `folklore`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `folklore` ;

CREATE TABLE IF NOT EXISTS `folklore` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(300) NOT NULL,
  `category` VARCHAR(100) NOT NULL,
  `description` VARCHAR(2000) NOT NULL,
  `lore` VARCHAR(2000) NULL,
  `lore_url` VARCHAR(1000) NULL,
  `state` VARCHAR(200) NULL,
  `city` VARCHAR(200) NULL,
  `street` VARCHAR(300) NULL,
  `enabled` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS loreteller@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'loreteller'@'localhost' IDENTIFIED BY 'spooky';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'loreteller'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `folklore`
-- -----------------------------------------------------
START TRANSACTION;
USE `americanfolkloredb`;
INSERT INTO `folklore` (`id`, `name`, `category`, `description`, `lore`, `lore_url`, `state`, `city`, `street`, `enabled`) VALUES (1, 'Mothman', 'Creature', 'A black 10-foot creature with wings and red eyes', NULL, 'https://www.youtube.com/watch?v=2jnCwbXaDhM', 'West Virginian', 'Point Pleasant', NULL, 1);
INSERT INTO `folklore` (`id`, `name`, `category`, `description`, `lore`, `lore_url`, `state`, `city`, `street`, `enabled`) VALUES (2, 'Paul Bunyan', 'Giant', 'A literal giant lumberjack who towers over forests  ', NULL, NULL, NULL, NULL, NULL, 1);

COMMIT;

