/*Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with 
latest ordered items should be displayed first for last 60 days.*/
CREATE OR REPLACE VIEW order_information AS
    SELECT DISTINCT
        o.order_id,
        p.product_id,
        p.name AS product_name,
        c.quantity,
        c.sum AS price,
        u.name AS shopper_name,
        u.email,
        o.date AS date_of_order,
        c.order_status
    FROM
        orders o,
        user u,
        shopper s,
        product p,
        cart c
    WHERE
        p.product_id = c.product_id
            AND c.shopper_id = s.shopper_id
            AND s.email = u.email
            AND o.shopper_id = c.shopper_id
            AND o.date < CURRENT_DATE - 60
    ORDER BY o.date DESC;
#Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT 
    product_id
FROM
    order_information
WHERE
    order_status = 'Shipped';
    
#Use the above view to display the top 5 most selling products.
SELECT 
    product_id, COUNT(product_id)
FROM
    order_information
GROUP BY product_id
ORDER BY COUNT(product_id) DESC;
