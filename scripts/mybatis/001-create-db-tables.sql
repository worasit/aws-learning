drop database if exists details;
create database details;

Drop table if exists details.student;
create table details.students
(
    ID         int(10)      NOT NULL AUTO_INCREMENT,
    NAME       varchar(100) NOT NULL,
    BRANCH     varchar(255) NOT NULL,
    PERCENTAGE int(3)       NOT NULL,
    PHONE      int(10)      NOT NULL,
    EMAIL      varchar(255) NOT NULL,
    PRIMARY KEY (ID)
);