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
    (shopper_Id ,house_no ,street ,city,state ,country,type ,zipcode);
    SELECT 
        *
    FROM
        Address;
    describe product;
    
    LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoProduct.txt'
    INTO TABLE Product
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (product_Id,name,description,price,quantity,image);
    SELECT 
        *
    FROM
        Product;
    
    INSERT INTO Stock (product_Id)  
    SELECT product_Id
      FROM Product;
      
    UPDATE Stock LEFT JOIN Product
        ON Stock.product_Id = Product.product_Id 
    SET is_in_stock = TRUE WHERE Product.quantity > 0;
    
    SELECT 
        *
    FROM
        Stock;
    
    
    
    LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoCategory.txt'
    INTO TABLE Category
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (name,parent_category,product_Id);
    SELECT 
        *
    FROM
        Category;
    
    LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoCart.txt'
    INTO TABLE cart
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (shopper_id,product_id,quantity,order_status);
    
    UPDATE cart INNER JOIN Product
        ON cart.product_id = Product.product_id 
    SET cart.sum = Product.price * cart.quantity WHERE cart.quantity > 0 ;
    SELECT 
        *
    FROM
        cart;
    
    INSERT INTO amount (shopper_id,amount)  
    SELECT shopper_id,SUM(sum)
      FROM cart GROUP BY shopper_id;
    SELECT 
        *
    FROM
        amount;
    
    
    LOAD DATA LOCAL INFILE 'C:/Users/Vrinda/insertIntoOrder.txt'
    INTO TABLE Orders
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"' 
    LINES TERMINATED BY '\r\n'
    (shopper_id,@DATE)
    SET date = STR_TO_DATE(@DATE, '%d-%m-%Y');
    
    UPDATE Orders INNER JOIN amount
        ON amount.shopper_id = orders.shopper_id
    SET orders.amount = amount.amount WHERE amount.shopper_id = orders.shopper_id;
    
    
    SELECT 
        *
    FROM
        Orders;
    
    
    
    
    
    
    
    
