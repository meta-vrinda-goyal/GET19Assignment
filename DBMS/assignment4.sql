/*Create a function to calculate number of orders in a month. Month and year will be input parameter to function.*/

CREATE FUNCTION getNumberOfOrdersInMonth(month INT, year INT)
RETURNS INT DETERMINISTIC
RETURN (SELECT COUNT(*) FROM orders WHERE MONTH(date) = month AND YEAR(date) = year );
SELECT GETNUMBEROFORDERSINMONTH(8, 2019) AS 'Number_Of_orders_in_month';

/*Create a function to return month in a year having maximum orders. Year will be input parameter.*/

CREATE FUNCTION getMonthWithMaxOrders(year INT)
RETURNS INT DETERMINISTIC
RETURN (SELECT MONTH(date) FROM orders WHERE YEAR(date) = 2019 GROUP BY MONTH(date) ORDER BY COUNT(order_id) DESC LIMIT 1);
SELECT GETMONTHWITHMAXORDERS(2019) AS month_haiving_max_orders;


/*Create a Stored procedure to retrieve average sales of each product in a month. 
Month and year will be input parameter to function.*/

DROP PROCEDURE IF EXISTS getAvgSales;
DELIMITER //
CREATE PROCEDURE getAvgSales(month INT , year INT)
BEGIN 
   DECLARE total_products,total_particular_product FLOAT;
   SELECT SUM(quantity) INTO TOTAL_PRODUCTS FROM items_ordered i, orders o WHERE o.order_id = i.order_id AND MONTH(date) = month AND YEAR(date) = year;
   SELECT DISTINCT product_id, SUM(quantity)/total_products as avg_sales FROM items_ordered i, orders o WHERE o.order_id = i.order_id AND MONTH(date) = month AND YEAR(date) = year  GROUP BY product_id;
END//
delimiter ;
CALL getAvgSales(8,2019);



/*Create a stored procedure to retrieve table having order detail with status for a given period. 
Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. 
If start date is greater than end date take first date of month as start date.*/

DROP PROCEDURE IF EXISTS getOrderDetail;
DELIMITER //
CREATE PROCEDURE getOrderDetail(startDate DATE, endDate DATE)
BEGIN 
    IF (startDate > endDate) THEN
        SET startDate = CONCAT(DATE_FORMAT(endDate, '%Y-%m-'), '01');
    END IF;
    SELECT order_id, shopper_id, orderBill, date FROM orders WHERE date  BETWEEN startDate AND endDate;
END//
DELIMITER ;

CALL getOrderDetail('2019-08-01', '2019-08-30');
CALL getOrderDetail('2019-08-30','2019-08-13');

/*Identify the columns require indexing in order, product, category tables and create indexes.*/
ALTER TABLE orders ADD INDEX index_date_of_order(date);
ALTER TABLE orders ADD INDEX index_shopper_id(shopper_id);
ALTER TABLE product ADD INDEX index_name(name);
ALTER TABLE categories ADD INDEX index_parent_id(parent_category);
ALTER TABLE categorylink ADD INDEX index_category_id(category_id);
ALTER TABLE categorylink ADD INDEX index_product_id(product_id);
ALTER TABLE items_ordered ADD INDEX index_order_status(order_status);

