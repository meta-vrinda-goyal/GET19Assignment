#Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT 
    c.product_id AS ID,
    COUNT(c.category_id) AS countOfCategories
FROM
    categoryLink c
GROUP BY c.product_id
HAVING COUNT(c.category_id) > 1;

#Display Count of products as per below price range 0-1000,1001-5000,Above 5000
SELECT 
    price_range, COUNT(*) no_of_products
FROM
    (SELECT 
        CASE
                WHEN price >= 0 AND price <= 1000 THEN '0-1000'
                WHEN price >= 1001 AND price <= 5000 THEN '1001-5000'
                ELSE 'Above 5000'
            END AS price_range
    FROM
        product
    GROUP BY product_id) AS count_of_products
GROUP BY price_range;

#Display the Categories along with number of products under each category.
SELECT 
    c.category_id,
    c.name,
    COUNT(cl.product_id) AS numberOfProducts
FROM
    category c
        LEFT JOIN
    categoryLink cl ON cl.category_id = c.category_id
GROUP BY cl.category_Id;