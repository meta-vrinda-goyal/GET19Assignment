show databases;
drop database student;
CREATE DATABASE STUDENT;
USE STUDENT;
CREATE TABLE STUDENT_DETAIL(
   email VARCHAR(50) PRIMARY KEY,
   first_name VARCHAR(30),
   last_name VARCHAR(30),
   father_name VARCHAR(30),
   class INT,
   age INT
);


UPDATE STUDENT_DETAIL SET  age = 19 where email  = "sachin@metcube.com";

select * from student_detail;