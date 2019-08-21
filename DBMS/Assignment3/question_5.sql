/*Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with 
latest ordered items should be displayed first for last 60 days.*/
CREATE OR REPLACE VIEW order_information AS
    SELECT DISTINCT
        o.order_id,
        i.product_id,
        p.name AS product_name,
        i.quantity AS quan,
        p.price,
        u.name AS shopper_name,
        u.email,
        o.date AS date_of_order,
        i.order_status
    FROM
        orders o,
        user u,
        shopper s,
        product p,
        items_ordered i
    WHERE
        p.product_id = i.product_id
            AND o.shopper_id = s.shopper_id
            AND s.email = u.email
            AND o.order_id = i.order_id
            AND o.date < CURRENT_DATE - 60
    ORDER BY o.date DESC;
#Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT 
    product_id,order_id
FROM
    order_information
WHERE
    order_status = 'Shipped';
    
#Use the above view to display the top 5 most selling products.
SELECT 
    product_id, SUM(quan) AS quan
FROM
    order_information
GROUP BY product_id
ORDER BY quan DESC;

#Select and display the category title of all top parent categories sorted alphabetically and the count of their child categories.
SELECT DISTINCT
    c.name, COUNT(p.category_id)
FROM
    category c
        LEFT JOIN
    category p ON c.category_id = p.parent_category
WHERE
    c.parent_category IS NULL
GROUP BY p.parent_category
ORDER BY c.name;

/*Given the id of a user, fetch all orders (Id, Order Date, Order Total) of that user which are in shipped state.
Orders should be sorted by order date column in chronological order*/
SELECT 
    o.order_id, o.date, c.sum
FROM
    cart c,
    orders o
WHERE
    c.shopper_id = 2 AND o.shopper_id = c.shopper_id AND o.cart_id = c.cart_id AND order_status = 'Shipped'
ORDER BY date;

/*Delete all those products which were not ordered by any Shopper in last 1 year. */
DELETE FROM product WHERE product_id  NOT IN (SELECT DISTINCT product_id 
FROM cart c, orders o WHERE o.cart_id = c.cart_id AND date > CURRENT_DATE - 365 );

SELECT 
    *
FROM
    PRODUCT;