CREATE TABLE IF NOT EXISTS `room`
(
    `id`         INT          NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(128) NOT NULL,
    `created_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);
