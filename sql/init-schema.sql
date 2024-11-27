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

-- 新增几条测试数据
INSERT INTO wic_course VALUES (1, '语文', '中华文化渊源流传,每个同学必学', 60, 150, '系统管理员', now(), '系统管理员', now());
INSERT INTO wic_course VALUES (2, '数学', '数学是理科的基础', 24, 150, '系统管理员', now(), '系统管理员', now());
INSERT INTO wic_course VALUES (3, '英语', '学号英语，走向全世界', 48, 150, '系统管理员', now(), '系统管理员', now());
INSERT INTO wic_course VALUES (4, '计算机基础', '每个人都应该学习计算机', 50, 100, '系统管理员', now(), '系统管理员', now());
INSERT INTO wic_course VALUES (5, '物理', '爱因斯坦相对论牛逼', 32, 100, '系统管理员', now(), '系统管理员', now());
INSERT INTO wic_course VALUES (6, '化学', '学化学先背好元素周期表', 25, 100, '系统管理员', now(), '系统管理员', now());
INSERT INTO wic_course VALUES (7, 'Java', 'Java大法好，就是太内卷了', 25, 100, '系统管理员', now(), '系统管理员', now());
INSERT INTO wic_course VALUES (8, 'C#', '微软爸爸好，就是信创不太欢迎', 25, 100, '系统管理员', now(), '系统管理员', now());
INSERT INTO wic_course VALUES (9, 'Rust', 'Rust是现代编程语言的典范', 25, 100, '系统管理员', now(), '系统管理员', now());
INSERT INTO wic_course VALUES (10, '鸿蒙开发', '国产化的必经之路', 25, 100, '系统管理员', now(), '系统管理员', now());
INSERT INTO wic_course VALUES (11, 'C++', '时代的眼泪，美国白宫有计划用rust淘汰C++', 25, 100, '系统管理员', now(), '系统管理员', now());
INSERT INTO wic_course VALUES (12, 'PHP', 'PHP是最好的语言（手动滑稽）', 25, 100, '系统管理员', now(), '系统管理员', now());
INSERT INTO wic_course VALUES (13, '前端开发', '前端内卷程度和java一个鸟样', 25, 100, '系统管理员', now(), '系统管理员', now());