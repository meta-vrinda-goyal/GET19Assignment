    USE storefront;
    SHOW TABLES;
    ALTER TABLE cart DROP FOREIGN KEY Product_Id2;
    DROP TABLE product;
    
    CREATE TABLE Product(
        name VARCHAR(20),
        description VARCHAR(100),
        product_Id INT,
        quantity INT NOT NULL,
        price FLOAT,
        image VARCHAR(10),
        PRIMARY KEY (product_Id,image)
    );
    
    ALTER TABLE cart
    ADD CONSTRAINT `Product_Id2` FOREIGN KEY ( product_Id) REFERENCES Product( product_Id);
    
    
