-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema travel_agency
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema travel_agency
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `travel_agency` DEFAULT CHARACTER SET utf8;
USE `travel_agency`;

-- -----------------------------------------------------
-- Table `travel_agency`.`tour_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `travel_agency`.`tour_type`;

CREATE TABLE IF NOT EXISTS `travel_agency`.`tour_type`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `type_UNIQUE` (`type` ASC) VISIBLE
);


-- -----------------------------------------------------
-- Table `travel_agency`.`hotel_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `travel_agency`.`hotel_type`;

CREATE TABLE IF NOT EXISTS `travel_agency`.`hotel_type`
(
    `id`    INT NOT NULL AUTO_INCREMENT,
    `stars` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `type_UNIQUE` (`stars` ASC) VISIBLE
);


-- -----------------------------------------------------
-- Table `travel_agency`.`tour`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `travel_agency`.`tour`;

CREATE TABLE IF NOT EXISTS `travel_agency`.`tour`
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(45) NOT NULL,
    `description`   VARCHAR(45) NULL,
    `price`         INT         NOT NULL,
    `person_count`  INT         NOT NULL,
    `tour_type_id`  INT         NOT NULL,
    `hotel_type_id` INT         NOT NULL,
    `hot`           TINYINT     NOT NULL,
    `img_url`       VARCHAR(45) NULL,
    `discount`      DECIMAL     NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`),
    INDEX `fk_tour_tour_type_idx` (`tour_type_id` ASC) VISIBLE,
    INDEX `fk_tour_hotel_type1_idx` (`hotel_type_id` ASC) VISIBLE,
    CONSTRAINT `fk_tour_tour_type`
        FOREIGN KEY (`tour_type_id`)
            REFERENCES `travel_agency`.`tour_type` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_tour_hotel_type1`
        FOREIGN KEY (`hotel_type_id`)
            REFERENCES `travel_agency`.`hotel_type` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `travel_agency`.`receipt_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `travel_agency`.`receipt_status`;

CREATE TABLE IF NOT EXISTS `travel_agency`.`receipt_status`
(
    `id`     INT         NOT NULL AUTO_INCREMENT,
    `status` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `status_UNIQUE` (`status` ASC) VISIBLE
);


-- -----------------------------------------------------
-- Table `travel_agency`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `travel_agency`.`user_role`;

CREATE TABLE IF NOT EXISTS `travel_agency`.`user_role`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `role` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `role_UNIQUE` (`role` ASC) VISIBLE
);


-- -----------------------------------------------------
-- Table `travel_agency`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `travel_agency`.`user`;

CREATE TABLE IF NOT EXISTS `travel_agency`.`user`
(
    `id`           INT          NOT NULL AUTO_INCREMENT,
#     `login`        VARCHAR(16)  NOT NULL,
    `email`        VARCHAR(255) NOT NULL,
    `password`     VARCHAR(32)  NOT NULL,
    `name`         VARCHAR(45)  NOT NULL,
    `create_time`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `user_role_id` INT          NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_user_user_role1_idx` (`user_role_id` ASC) VISIBLE,
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
#     UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
    CONSTRAINT `fk_user_user_role1`
        FOREIGN KEY (`user_role_id`)
            REFERENCES `travel_agency`.`user_role` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);


-- -----------------------------------------------------
-- Table `travel_agency`.`receipt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `travel_agency`.`receipt`;

CREATE TABLE IF NOT EXISTS `travel_agency`.`receipt`
(
    `id`                INT       NOT NULL AUTO_INCREMENT,
    `create_time`       TIMESTAMP NULL,
    `receipt_status_id` INT       NOT NULL,
    `tour_id`           INT       NOT NULL,
    `user_id`           INT       NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_receipt_receipt_status1_idx` (`receipt_status_id` ASC) VISIBLE,
    INDEX `fk_receipt_tour1_idx` (`tour_id` ASC) VISIBLE,
    INDEX `fk_receipt_user1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_receipt_receipt_status1`
        FOREIGN KEY (`receipt_status_id`)
            REFERENCES `travel_agency`.`receipt_status` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_receipt_tour1`
        FOREIGN KEY (`tour_id`)
            REFERENCES `travel_agency`.`tour` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_receipt_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `travel_agency`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO user_role VALUES(1, 'admin');
INSERT INTO user_role VALUES(2, 'moderator');
INSERT INTO user_role VALUES(3, 'client');

INSERT INTO tour_type VALUES(1, 'Excursion');
INSERT INTO tour_type VALUES(2, 'Vacation');
INSERT INTO tour_type VALUES(3, 'Shopping');

INSERT INTO hotel_type VALUES(1, 1), (2,2), (3,3), (4,4), (5,5);

INSERT INTO receipt_status VALUES(1, 'Registered');
INSERT INTO receipt_status VALUES(2, 'Paid');
INSERT INTO receipt_status VALUES(3, 'Canceled');
INSERT INTO receipt_status VALUES(4, 'Executed');

# INSERT INTO user VALUES(1, 'admin','admin@email.com', md5('admin'), 'Neo', default, 1);
# INSERT INTO user VALUES(2, 'moderator','moderator@email.com', md5('moderator'), 'Holden',  default, 2);
# INSERT INTO user VALUES(3, 'client','client@email.com', md5('client'), 'Elvis',  default, 3);

INSERT INTO user VALUES(1, 'admin@email.com', md5('admin'), 'Neo', default, 1);
INSERT INTO user VALUES(2, 'moderator@email.com', md5('moderator'), 'Holden',  default, 2);
INSERT INTO user VALUES(3, 'client@email.com', md5('client'), 'Elvis',  default, 3);

INSERT INTO tour VALUES(1,  'Irish Castle Tour', 'Explore Irish Castles', 300.00, 10, 1, 3, false, 'ireland.webp', default);
INSERT INTO tour VALUES(2,  'Mauritanian caravan', 'Become a part of desert caravan', 700.00, 5, 1, 1, true, 'caravan.jpg', default);
INSERT INTO tour VALUES(3,  'Bali relax', 'Chill out on a tropical island', 900.00, 10, 2, 4, true, 'bali.jpg', default);
INSERT INTO tour VALUES(4,  'New York shopping trip', 'Shop at the best stores', 3000.00, 5, 3, 5, false, 'NY.jpg', default);
INSERT INTO tour VALUES(5,  'Delhi artifacts', 'Find mystical things', 800.00, 15, 3, 3, true, 'delhi.jpg', default);
INSERT INTO tour VALUES(6,  'Austria ski resort', 'Holidays in the mountains', 1000.00, 3, 2, 5, false, 'ski-resort.jpg', default);