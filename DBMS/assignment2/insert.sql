USE Storefront;
LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoUser.txt'
	INTO TABLE User
	FIELDS TERMINATED BY ',' 
	ENCLOSED BY '"' 
	LINES TERMINATED BY '\r\n'
	(email,name ,phone_no,password,@DOB,type)
	SET dob = STR_TO_DATE(@DOB, '%d-%m-%Y');
SELECT * FROM User;

INSERT INTO Shopper(email) SELECT email FROM user WHERE type='S';
SELECT * FROM Shopper;

INSERT INTO Admin(email) SELECT email FROM user WHERE type='a';
SELECT * FROM Admin;

LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoAddress.txt'
    INTO TABLE Address
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (shopper_Id,house_no ,street ,city,state ,country,type,zipcode);
SELECT * FROM Address;

LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoProduct.txt'
    INTO TABLE Product
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (product_Id,name,description,price,quantity,image);
SELECT * FROM Product;

INSERT INTO Stock (product_Id,image)  
    SELECT product_Id,image
      FROM Product;
UPDATE Stock
        LEFT JOIN
    Product ON Stock.product_Id = Product.product_Id 
SET 
    is_in_stock = TRUE
WHERE
    Product.quantity > 0;
SELECT * FROM Stock;

LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoCategory.txt'
    INTO TABLE Category
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (name,parent_category);
SELECT * FROM Category;

LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoCategoryLink.txt'
    INTO TABLE cart
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (product_id,category_id);
SELECT * FROM CategoryLink;

LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoCart.txt'
    INTO TABLE cart
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (cart_id,shopper_id,product_id,quantity,order_status);
    
UPDATE cart
        INNER JOIN
    Product ON cart.product_id = Product.product_id 
SET 
    cart.sum = Product.price * cart.quantity
WHERE
    cart.quantity > 0;
#delete those products which are not in stock
DELETE from cart where cart.product_id in (select product_id from stock where is_in_stock is false);
SELECT * FROM cart;
    
INSERT INTO amount (cart_id,shopper_id,amount)  
    SELECT cart_id,shopper_id,SUM(sum)
      FROM cart GROUP BY cart_id;#shopper_id,cartUpdateDate;
SELECT * FROM amount;
    
LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoOrder.txt'
    INTO TABLE Orders
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (cart_id,shopper_id,@DATE)
    SET date = STR_TO_DATE(@DATE, '%d-%m-%Y');
UPDATE Orders
        INNER JOIN
    amount ON amount.shopper_id = orders.shopper_id 
SET 
    orders.amount = amount.amount
WHERE
    amount.shopper_id = orders.shopper_id
        AND orders.cart_id = amount.cart_id;
SELECT * FROM Orders;
