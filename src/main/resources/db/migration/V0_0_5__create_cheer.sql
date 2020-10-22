CREATE TABLE IF NOT EXISTS `cheer`
(
    `id`         INT      NOT NULL AUTO_INCREMENT,
    `user_id`    INT      NOT NULL,
    `room_id`    INT      NOT NULL,
    `comment`    TEXT     NOT NULL,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `fk_cheer_user1_idx` (`user_id` ASC) VISIBLE,
    INDEX `fk_cheer_room1_idx` (`room_id` ASC) VISIBLE,
    CONSTRAINT `fk_cheer_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_cheer_room1`
        FOREIGN KEY (`room_id`)
            REFERENCES `room` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
