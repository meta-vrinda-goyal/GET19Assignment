#Display Recent 50 Orders placed (Id, Order Date, Order Total).
SELECT 
    order_id, date, amount AS order_total
FROM
    orders
ORDER BY date desc
LIMIT 50;
    
#Display 10 most expensive Orders.
SELECT 
    order_id, date, amount
FROM
    orders
ORDER BY amount DESC
LIMIT 2;
    
#Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
/*INSERT INTO cart (cart_id,shopper_id,product_id,quantity,sum,order_status) VALUES 
(2,2,1,1,1700,"not shipped");*/
SELECT 
    c.cart_id, o.order_id, o.shopper_id, o.date
FROM
    cart c
        LEFT JOIN
    orders o ON c.cart_id = o.cart_id
WHERE
    c.order_status IN ('not Shipped')
        AND o.date < CURRENT_DATE - 10;
    
#Display list of shoppers which haven't ordered anything since last month.
SELECT 
    shopper_id, email
FROM
    shopper
WHERE
    shopper_id NOT IN (SELECT DISTINCT
        s.shopper_id
    FROM
        shopper s
            LEFT JOIN
        orders o ON s.shopper_id = o.shopper_id
    WHERE
        o.date > CURRENT_DATE-30);
#Display list of shopper along with orders placed by them in last 15 days. 
SELECT 
    s.shopper_id, s.email, o.order_id, o.amount, o.date
FROM
    shopper s
        LEFT JOIN
    orders o ON s.shopper_id = o.shopper_id
WHERE
    o.date > CURRENT_DATE - 15;
    
#Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
SELECT 
    c.product_id, c.quantity, c.sum
FROM
    cart c
        LEFT JOIN
    orders o ON c.shopper_id = o.shopper_id
WHERE
    o.order_id = 1  and c.order_status = 'shipped';
    
#Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
