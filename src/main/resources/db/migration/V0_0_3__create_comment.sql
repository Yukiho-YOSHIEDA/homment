CREATE TABLE IF NOT EXISTS `comment`
(
    `id`         INT      NOT NULL AUTO_INCREMENT,
    `user_from`  INT      NOT NULL,
    `user_to`    INT      NOT NULL,
    `room_id`    INT      NOT NULL,
    `comment`    TEXT     NOT NULL,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `fk_comment_user_idx` (`user_from` ASC) VISIBLE,
    INDEX `fk_comment_room1_idx` (`room_id` ASC) VISIBLE,
    INDEX `fk_comment_user1_idx` (`user_to` ASC) VISIBLE,
    CONSTRAINT `fk_comment_user`
        FOREIGN KEY (`user_from`)
            REFERENCES `user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_comment_room1`
        FOREIGN KEY (`room_id`)
            REFERENCES `room` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_comment_user1`
        FOREIGN KEY (`user_to`)
            REFERENCES `user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
