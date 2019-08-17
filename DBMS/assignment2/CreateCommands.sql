    DROP DATABASE StoreFront;
    CREATE DATABASE StoreFront;
    USE Storefront;
    CREATE TABLE User(
        email VARCHAR(30) PRIMARY KEY,
        name VARCHAR(30) NOT NULL,
        phone_no VARCHAR(10),
        password VARCHAR(15) NOT NULL,
        dob DATE,
        type VARCHAR(1) NOT NULL CHECK (type IN ('S','A'))
    );
    
    
    CREATE TABLE Admin(
        admin_Id INT PRIMARY KEY AUTO_INCREMENT,
        email VARCHAR(30),
        FOREIGN KEY (email)
            REFERENCES User (email)
            ON DELETE CASCADE ON UPDATE CASCADE
    );
        
    CREATE TABLE Shopper(
        shopper_Id INT AUTO_INCREMENT PRIMARY KEY,
        email VARCHAR(30),
        FOREIGN KEY (email)
            REFERENCES User (email)
            ON DELETE CASCADE ON UPDATE CASCADE
    );
    
    CREATE TABLE Address(
        address_Id INT NOT NULL AUTO_INCREMENT,
        shopper_Id INT,
        house_no VARCHAR(10),
        street VARCHAR(30),
        city VARCHAR(15),
        state VARCHAR(20),
        country VARCHAR(30) DEFAULT 'India',
        type VARCHAR(10),
        zipcode INT(6) ZEROFILL NOT NULL,
        PRIMARY KEY (address_Id),
        FOREIGN KEY (shopper_Id)
            REFERENCES Shopper (shopper_Id)
            ON DELETE CASCADE ON UPDATE CASCADE
    );
                         
    CREATE TABLE Product(
        name VARCHAR(20),
        description VARCHAR(100),
        product_Id INT,
        quantity INT NOT NULL,
        price FLOAT,
        image VARCHAR(10),
        PRIMARY KEY (product_Id,image)
    );
    describe product;
    CREATE TABLE Stock(
        product_Id INT PRIMARY KEY,
        is_in_stock BOOLEAN NOT NULL DEFAULT FALSE
    );
    
    CREATE TABLE Category(
        category_Id INT AUTO_INCREMENT,
        name VARCHAR(20),
        parent_category INT,
        PRIMARY KEY (category_Id,product_Id)
    );
        
    CREATE TABLE categorylink(
        product_id INT, 
        category_id INT, 
        PRIMARY KEY(product_id, category_id),
        FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE ON UPDATE CASCADE, 
        FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE CASCADE ON UPDATE CASCADE
    );
    
    CREATE TABLE Orders(
        order_id INT PRIMARY KEY AUTO_INCREMENT,
        shopper_id INT,
        amount FLOAT NOT NULL,
        date DATE NOT NULL,
        CONSTRAINT shopper_id2 FOREIGN KEY (shopper_id)
            REFERENCES Shopper (shopper_Id)
            ON DELETE CASCADE ON UPDATE CASCADE
    );
    CREATE TABLE amount(
        shopper_id INT,
        amount FLOAT
    );
    
    CREATE TABLE cart(
        shopper_id INT,
        product_id INT,
        quantity DOUBLE NOT NULL,
        sum DOUBLE,
        order_status VARCHAR(20) CHECK (order_status IN ('Shipped','Cancelled', 'Returned', 'Not Shipped')),
        PRIMARY KEY (shopper_id,product_id),
        CONSTRAINT shopper_id FOREIGN KEY (shopper_id)
            REFERENCES Shopper (shopper_Id)
            ON DELETE CASCADE ON UPDATE CASCADE,
        CONSTRAINT Product_Id2 FOREIGN KEY (product_id)
            REFERENCES Product (product_id)
            ON DELETE CASCADE ON UPDATE CASCADE
    );
    
    
    
                               
                               
                               
                       
        
                          
                          
                          
