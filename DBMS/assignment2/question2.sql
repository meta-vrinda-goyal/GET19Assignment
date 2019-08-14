    #Display Id, Title, Category Title, Price of the products which are Active 
    #and recently added products should be at top.
    
    SELECT 
        product.product_id,
        product.name,
        product.price,
        category.name
    FROM
        product,
        category
    WHERE
        product.quantity > 0 AND product.product_id = category.product_id
    ORDER BY product_id;
    
    #Display the list of products which don't have any images.
    SELECT 
        product_id, name, price, image
    FROM
        product
    WHERE
        image IS NULL;
    
    #Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title
    #and then Category Title. (If Category is top category then Parent Category Title column should display “Top Category” as value.)
    SELECT 
        c.category_id AS ID,
        c.name AS Title,
        IFNULL(p.name, 'Top Category') AS Parent_Category_Name
    FROM
        Category c
            LEFT JOIN
        Category p ON c.parent_category = p.category_id
    ORDER BY p.name,c.name;
    
    #Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)
    SELECT 
        c.category_id AS ID,
        c.name AS Title,
        p.name AS Parent_Category_Title
    FROM
        Category c
            LEFT JOIN
        Category p ON c.parent_category = p.category_id
    WHERE
        c.category_id NOT IN (SELECT 
            parent_category
        FROM
            category
        WHERE
            parent_category IS NOT NULL);
     
    #Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
    SELECT 
        p.name, p.price, p.description
    FROM
        product p
            LEFT JOIN
        category c ON c.product_id = p.product_id
    WHERE
        c.name IN ('jeans');
    
    #Display the list of Products whose Quantity on hand (Inventory) is under 50.
    SELECT 
        product_id, name, description
    FROM
        product
    WHERE
        quantity < 50;
    
            
    
    


   



