drop database shopping_app;
CREATE DATABASE SHOPPING_APP;
USE SHOPPING_APP;
CREATE TABLE USER(
  user_id int AUTO_INCREMENT primary key,
  email varchar(30) unique,
  password varchar(20)
  
);
CREATE TABLE PRODUCT(
  product_code int AUTO_INCREMENT primary key,
  product_name varchar(30) ,
  product_type varchar(30),
  price double
);
CREATE TABLE CART(
  user_id int ,
  product_code int ,
  product_quantity int,
  FOREIGN KEY ( user_id) REFERENCES USER(user_id)
  ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY ( product_code) REFERENCES PRODUCT(product_code)
  ON DELETE CASCADE ON UPDATE CASCADE
  
);
insert into user(email,password) values('rsg@gm.com','pass');
INSERT INTO Product(product_type, product_name, price) VALUES
   ('Mobile', 'Oppo A83', 13000.0),
   ('Mobile', 'Oppo A3S', 11000.0),
   ('Mobile', 'Moto E4+', 12000.0),
   ('Mobile', 'Vivo V11 Pro', 23000.0),
   ('Shoes', 'Nike Shoes', 1300.0),
   ('Shoes', 'Puma Shoes', 2500.0),
   ('Cloth', 'Peter Shirt', 1300.0),
   ('Cloth', 'Arrow Jeans', 900.0);
   
    