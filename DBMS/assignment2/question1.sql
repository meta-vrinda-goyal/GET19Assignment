    USE storefront;
    SHOW TABLES;
    ALTER TABLE cart DROP FOREIGN KEY Product_Id2;
    ALTER TABLE stock DROP FOREIGN KEY Product_Id3;
    ALTER TABLE categorylink DROP FOREIGN KEY Product_Id4;
    DROP TABLE product;
    
CREATE TABLE Product (
    name VARCHAR(30),
    description VARCHAR(100),
    product_Id INT,
    quantity INT NOT NULL,
    price FLOAT,
    image VARCHAR(10),
    PRIMARY KEY (product_Id , image)
);
    ALTER TABLE cart
    ADD CONSTRAINT `Product_Id2` FOREIGN KEY ( product_Id) REFERENCES Product( product_Id);
    ALTER TABLE stock
    ADD CONSTRAINT `Product_Id3` FOREIGN KEY ( product_Id) REFERENCES Product( product_Id);
    ALTER TABLE categorylink
    ADD CONSTRAINT `Product_Id4` FOREIGN KEY ( product_Id) REFERENCES Product( product_Id);
    
    
