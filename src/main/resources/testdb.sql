CREATE TABLE `department`
(
    `ID`          INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`        VARCHAR(50)      NOT NULL DEFAULT '' COLLATE 'utf8mb4_general_ci',
    `no`          VARCHAR(100)     NOT NULL DEFAULT '' COLLATE 'utf8mb4_general_ci',
    `update_time` DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `create_time` DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE INDEX `uqd_name` (`name`) USING BTREE,
    INDEX `idx_name` (`name`) USING BTREE
)
    COMMENT ='部门表'
    COLLATE = 'utf8mb4_general_ci'
    ENGINE = InnoDB
    AUTO_INCREMENT = 6
;
