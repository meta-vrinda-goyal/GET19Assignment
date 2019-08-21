USE storefront;
SHOW TABLES;
ALTER TABLE image DROP FOREIGN KEY Product_Id1;
ALTER TABLE categorylink DROP FOREIGN KEY Product_Id2;
ALTER TABLE items_ordered DROP FOREIGN KEY Product_Id3;
DROP TABLE product;
    
CREATE TABLE Product(
    product_Id INT,
    name VARCHAR(30),
    description VARCHAR(100),
    price FLOAT,
    quantity INT,
    image VARCHAR(10),
    PRIMARY KEY (product_Id,image)
);
describe cart;
ALTER TABLE image
    ADD CONSTRAINT `Product_Id1` FOREIGN KEY ( product_Id) REFERENCES Product( product_Id);
ALTER TABLE categorylink
    ADD CONSTRAINT `Product_Id2` FOREIGN KEY ( product_Id) REFERENCES Product( product_Id);
ALTER TABLE items_ordered
    ADD CONSTRAINT `Product_Id3` FOREIGN KEY ( product_Id) REFERENCES Product( product_Id);