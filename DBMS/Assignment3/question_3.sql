#Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT 
    s.shopper_Id, s.email, COUNT(o.order_id)
FROM
    shopper s
        LEFT JOIN
    orders o ON s.shopper_id = o.shopper_id
WHERE
    o.date > CURRENT_DATE-30
GROUP BY o.shopper_id;

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT 
    o.shopper_id, s.email
FROM
    orders o
        LEFT JOIN
    shopper s ON o.shopper_id = s.shopper_Id
WHERE
    o.date > CURRENT_DATE - 30
ORDER BY o.amount DESC
LIMIT 10;

#Display top 20 Products which are ordered most in last 60 days along with numbers
SELECT 
    p.product_id, p.name, SUM(c.quantity) AS numberOfProducts
FROM
    product p,
    cart c
    where c.product_id = p.product_id
GROUP BY c.product_id
ORDER BY SUM(c.quantity) DESC
LIMIT 20;


#Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT 
    MONTH(o.date), SUM(o.amount) AS revenue
FROM
    orders o
WHERE
    o.date > CURRENT_DATE - 360
GROUP BY MONTH(o.date); 

#Mark the products as Inactive which are not ordered in last 90 days.

#Given a category search keyword, display all the Products present in this category/categories.
SELECT 
    p.product_id, p.name
FROM
    product p,
    category c,
    categoryLink cl
WHERE
    c.name LIKE 'jeans'
        AND cl.product_id = p.product_id
        AND c.category_id = cl.category_id;
        
#Display top 10 Items which were cancelled most.
SELECT 
    p.product_id, p.name
FROM
    product p,
    cart c
WHERE
    p.product_id = c.product_id
        AND c.order_status = 'cancelled'
GROUP BY c.product_id
ORDER BY COUNT(c.product_id) DESC
LIMIT 10;
