CREATE DATABASE spring_security;
USE spring_security;
CREATE TABLE users(
 username VARCHAR(30) PRIMARY KEY,
 password VARCHAR(20) NOT NULL,
 enabled boolean NOT NULL
);

CREATE TABLE authorities(
username VARCHAR(30) PRIMARY KEY,
authority varchar(50) NOT NULL,
    foreign key (username) references users (username)
);

insert into users(username, password, enabled)values('admin','{noop}Admin@Password',true);
insert into authorities(username,authority)values('admin','ROLE_ADMIN');
 
insert into users(username, password, enabled)values('user','{noop}User@Password',true);
insert into authorities(username,authority)values('user','ROLE_USER');