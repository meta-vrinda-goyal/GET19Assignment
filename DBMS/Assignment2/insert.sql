USE Storefront;
LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoUser.txt'
	INTO TABLE User
	FIELDS TERMINATED BY ',' 
	ENCLOSED BY '"' 
	LINES TERMINATED BY '\r\n'
	(email,name ,phone_no,password,@DOB,type)
	SET dob = STR_TO_DATE(@DOB, '%d-%m-%Y');
SELECT 
    *
FROM
    User;

INSERT INTO Shopper(email) SELECT email FROM user WHERE type='S';
SELECT 
    *
FROM
    Shopper;

INSERT INTO Admin(email) SELECT email FROM user WHERE type='a';
SELECT 
    *
FROM
    Admin;

LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoAddress.txt'
    INTO TABLE Address
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (shopper_Id,house_no ,street ,city,state ,country,type,zipcode);
SELECT 
    *
FROM
    Address;

LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoProduct.txt'
    INTO TABLE Product
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (name,description,price,quantity);
SELECT 
    *
FROM
    Product;
    
LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoImage.txt'
    INTO TABLE Image
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (product_id,imageName,imageUrl);
SELECT 
    *
FROM
    image;

LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoCategory.txt'
    INTO TABLE Category
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (name,parent_category);
SELECT 
    *
FROM
    Category;

INSERT INTO CategoryLink VALUES(1,1) ,(1,6),(2,1),
(2,6),
(3,1),
(3,7),
(4,1),
(4,7),
(5,1),
(5,7),
(6,1),
(6,7),
(7,1),
(7,8),
(8,1),
(8,8),
(9,1),
(9,9),
(10,2),
(10,10),
(11,2),
(11,13),
(11,20),
(12,2),
(12,13),
(12,21),
(13,3),
(13,15),
(13,28),
(14,3),
(14,14),
(14,24),
(15,3),
(15,14),
(15,24),
(16,3),
(16,14),
(16,22),
(17,3),
(17,14),
(17,22),
(17,29),
(18,3),
(18,14),
(18,25),
(19,3),
(19,14),
(19,25),
(20,3),
(20,14),
(20,22),
(21,3),
(21,14),
(21,26),
(22,2),
(22,14),
(22,26),
(23,3),
(23,14),
(23,23),
(24,3),
(24,14),
(24,23);

SELECT 
    *
FROM
    CategoryLink;

LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoOrder.txt'
    INTO TABLE Orders
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (shopper_id,@DATE)
    SET date = STR_TO_DATE(@DATE, '%d-%m-%Y');

LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoItemsOrdered.txt'
    INTO TABLE items_ordered
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (order_id,product_id,quantity,order_status);
    
#delete those products which are not in stock
DELETE FROM items_ordered WHERE items_ordered.product_id IN (SELECT product_id FROM product WHERE quantity = 0);
SELECT 
    *
FROM
    items_ordered;
        

UPDATE orders SET orders.orderBill = (SELECT SUM(items_ordered.quantity * product.price) FROM items_ordered,product WHERE 
items_ordered.order_id = orders.order_id AND product.product_id = items_ordered.product_id);

SELECT 
    *
FROM
    Orders;




