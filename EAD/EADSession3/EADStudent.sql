show databases;
drop database student;
CREATE DATABASE STUDENT;
USE STUDENT;
CREATE TABLE STUDENT_DETAIL(
   email VARCHAR(50) PRIMARY KEY,
   first_name VARCHAR(30),
   last_name VARCHAR(30),
   father_name VARCHAR(30),
   class INT check (class BETWEEN 1 and 12),
   age INT check (Age BETWEEN 5 and 20)
);




UPDATE STUDENT_DETAIL SET  age = 19 where email  = "sachin@metcube.com";

select * from student_detail;