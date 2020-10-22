CREATE TABLE IF NOT EXISTS `room_password`
(
    `id`         INT        NOT NULL AUTO_INCREMENT,
    `password`   INT        NOT NULL,
    `room_id`    INT        NOT NULL,
    `is_deleted` TINYINT(1) NOT NULL,
    `created_at` DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`, `is_deleted`),
    INDEX `fk_room_password_room1_idx` (`room_id` ASC) VISIBLE,
    CONSTRAINT `fk_room_password_room1`
        FOREIGN KEY (`room_id`)
            REFERENCES `room` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
