DROP DATABASE IF EXISTS wic;
CREATE DATABASE wic CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

DROP TABLE IF EXISTS wic_course;
CREATE TABLE wic_course (
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(36) NOT NULL COMMENT '课程名字',
    course_desc VARCHAR(255) default null comment '课程描述',
    class_hour tinyint unsigned default 0 comment '学时',
    score tinyint unsigned default 0 comment '学分',
    create_by varchar(36) not null comment '创建人',
    create_time datetime not null default CURRENT_TIMESTAMP comment '创建时间',
    update_by varchar(36) default null comment '更新人',
    update_time datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间'
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;