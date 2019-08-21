DROP DATABASE StoreFront;
    CREATE DATABASE StoreFront;
    USE Storefront;
CREATE TABLE User (
    email VARCHAR(30) PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    phone_no VARCHAR(10),
    password VARCHAR(15) NOT NULL,
    dob DATE,
    type VARCHAR(1) NOT NULL CHECK (type IN ('S' , 'A'))
);
    
CREATE TABLE Admin (
    admin_Id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(30),
    FOREIGN KEY (email)
        REFERENCES User (email)
        ON DELETE CASCADE ON UPDATE CASCADE
);
        
CREATE TABLE Shopper (
    shopper_Id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(30),
    FOREIGN KEY (email)
        REFERENCES User (email)
        ON DELETE CASCADE ON UPDATE CASCADE
);
    
CREATE TABLE Address (
    address_Id INT NOT NULL AUTO_INCREMENT,
    shopper_Id INT NOT NULL,
    house_no VARCHAR(10) NOT NULL,
    street VARCHAR(30) NOT NULL,
    city VARCHAR(15) NOT NULL,
    state VARCHAR(20) NOT NULL,
    country VARCHAR(30) DEFAULT 'India',
    type VARCHAR(10),
    zipcode INT(6) ZEROFILL NOT NULL,
    PRIMARY KEY (address_Id),
    FOREIGN KEY (shopper_Id)
        REFERENCES Shopper (shopper_Id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
                         
CREATE TABLE Product (
    product_Id INT,
    name VARCHAR(30),
    description VARCHAR(100),
    price FLOAT,
    quantity INT NOT NULL,
    image VARCHAR(10),
    PRIMARY KEY (product_Id , image)
);

CREATE TABLE Stock (
    product_Id INT,
    image VARCHAR(10),
    is_in_stock BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (product_id , image),
    CONSTRAINT Product_Id3 FOREIGN KEY (product_id)
        REFERENCES Product (product_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Category (
    category_Id INT AUTO_INCREMENT,
    name VARCHAR(30),
    parent_category INT,
    PRIMARY KEY (category_Id)
);
        
CREATE TABLE categorylink (
    product_id INT,
    category_id INT,
    PRIMARY KEY (product_id , category_id),
    CONSTRAINT Product_Id4 FOREIGN KEY (product_id)
        REFERENCES product (product_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (category_id)
        REFERENCES category (category_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE cart (
    cart_id INT,
    shopper_id INT,
    product_id INT,
    quantity DOUBLE NOT NULL,
    sum DOUBLE,
    order_status VARCHAR(20) CHECK (order_status IN ('Shipped' , 'Cancelled', 'Returned', 'Not Shipped')),
    PRIMARY KEY (cart_id , shopper_id , product_id),
    CONSTRAINT shopper_id FOREIGN KEY (shopper_id)
        REFERENCES Shopper (shopper_Id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT Product_Id2 FOREIGN KEY (product_id)
        REFERENCES Product (product_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE amount (
    cart_id INT,
    shopper_id INT,
    amount FLOAT
);

CREATE TABLE Orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    cart_id INT,
    shopper_id INT,
    amount FLOAT,
    date DATE NOT NULL,
    CONSTRAINT cart_id FOREIGN KEY (cart_id)
        REFERENCES cart (cart_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT shopper_id2 FOREIGN KEY (shopper_id)
        REFERENCES Shopper (shopper_Id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

    
