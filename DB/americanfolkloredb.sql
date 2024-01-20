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
  `description` VARCHAR(500) NOT NULL,
  `image_url` VARCHAR(500) NULL,
  `lore` VARCHAR(2000) NULL,
  `location` VARCHAR(500) NULL,
  `lore_url` VARCHAR(1000) NULL,
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
INSERT INTO `folklore` (`id`, `name`, `category`, `description`, `image_url`, `lore`, `location`, `lore_url`, `enabled`) VALUES (1, 'Mothman', 'Creature', 'A black 10-foot tall creature with wings and red eyes said to stalk the night', 'https://www.wvencyclopedia.org/assets/0003/0398/mothmanp_large.jpg?1604081035', NULL, 'West Virginian', 'https://www.youtube.com/watch?v=2jnCwbXaDhM', 1);
INSERT INTO `folklore` (`id`, `name`, `category`, `description`, `image_url`, `lore`, `location`, `lore_url`, `enabled`) VALUES (2, 'Paul Bunyan', 'Giant', 'A literal giant lumberjack who towers over forests, traveling with his blue bull ', 'https://static.wikia.nocookie.net/sons-of-liberty/images/b/bc/Paul-Bunyan.jpg/revision/latest/scale-to-width-down/256?cb=20181010231931', NULL, 'Pennsylvania, Wisconsin, and the Northwest', NULL, 1);
INSERT INTO `folklore` (`id`, `name`, `category`, `description`, `image_url`, `lore`, `location`, `lore_url`, `enabled`) VALUES (DEFAULT, 'doug dimmadon', 'test', 'Timmy Turner, my name is Doug Dimmadome owner of the Dimmsdale Dimmadome. Thank you for locating my long lost son Dale Dimmadome, heir to the Dimmsdale Dimmadome fortune. If there\'s anything I can do to repay you for your kindness, all you need to do is ask!', 'https://64.media.tumblr.com/b2f8286a76974ea342b75e9d7607d36e/tumblr_ooz44laNXG1r326feo1_1280.jpg', NULL, NULL, NULL, 1);

COMMIT;

