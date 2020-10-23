CREATE TABLE IF NOT EXISTS `room`
(
    `id`         INT          NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(128) NOT NULL,
    `created_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `created_by` INT          NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_room_user1_idx` (`created_by` ASC) VISIBLE,
    CONSTRAINT `fk_room_user1`
        FOREIGN KEY (`created_by`)
            REFERENCES `user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
