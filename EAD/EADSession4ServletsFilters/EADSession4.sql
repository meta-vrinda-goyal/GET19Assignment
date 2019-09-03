show databases;
drop database MetaCube_Parking;
create database MetaCube_Parking;

use MetaCube_Parking;
create table employee_details(
  regId int primary key auto_increment,
  firstName varchar(30),
  lastName varchar(30),
  gender VARCHAR(6) CHECK (gender IN ('Male','Female')) ,
  email varchar(50) unique,
  password varchar(20),
  contact varchar(10),
  organization varchar(30) 

);
create table vehicle (
regId int primary key,
vehicle_name varchar(20),
vehicle_type varchar(20) CHECK (vehicle_type IN ('Cycle','MotorCycle','Four Wheelers')),
vehicle_number varchar(20),
Identification varchar(100),
foreign key (regId) references employee_details(regId) 
       ON DELETE CASCADE ON UPDATE CASCADE
);
create table passDetails(
regId int primary key,
plan varchar(20) check (plan in ('Daily' , 'Monthly' ,'Yearly')),
price int ,
foreign key (regId) references employee_details(regId) 
       ON DELETE CASCADE ON UPDATE CASCADE
);
select * from employee_details;
select * from vehicle;
select * from passDetails;


truncate table employee_details;
truncate table vehicle;
truncate table passDetails;

drop table employee_details;
drop table vehicle;
drop table passDetails;
SELECT MAX(regId) FROM employee_details;
select e.regId,firstName,lastName,gender,email,contact,organization,vehicle_name,vehicle_type,vehicle_number,Identification,plan,price from
employee_details e , vehicle v , passDetails p where e.regId = 1 and e.regId = v.regId and e.regId = p.regId ;

select fullName from employee_details where organization = "Metacube";

select regId,fullName,gender,email,contact,organization from employee_details where fisrtName = "Vrinda" and regId = 2;  