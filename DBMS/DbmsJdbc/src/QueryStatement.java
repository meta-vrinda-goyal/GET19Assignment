/**
 * @author Vrinda
 * To get mySql queries 
 */
public class QueryStatement {

	/**
	 * @return query for Given the id of a user, fetch all orders (Id, Order Date, Order Total) of that user 
	 *         which are in shipped state. Orders should be sorted by order date column in 
	 *         chronological order.
	 */
	public static String getShippedOrders(){
		return "SELECT " + 
			    "o.order_id, o.date, c.sum " +
			    "FROM " +
			        "cart c, " +
			        "orders o " +
			    "WHERE " + 
			        "c.shopper_id = ? AND o.shopper_id = c.shopper_id AND o.cart_id = c.cart_id AND order_status = 'Shipped' " +
			    "ORDER BY date ";

	}
	
	/**
	 * @return query for Insert images of a product using batch insert technique.
	 */
	public static String insertImage(){
		return "INSERT INTO Product (productId, image) VALUES(?,?) ";
	}
	
	/**
	 * @return query for Select and display the category title of all top parent categories 
	 *         sorted alphabetically and the count of their child categories.
	 */
	public static String displayCountOfChildCategory(){
		return "SELECT DISTINCT " +
	           "c.name, COUNT(p.category_id) "
				+ "FROM "
					+ "category c "
						+ "LEFT JOIN "
					+ "category p ON c.category_id = p.parent_category "
				+ "WHERE "
					+ "c.parent_category IS NULL "
				+ "GROUP BY p.parent_category "
				+ "ORDER BY c.name ";
	}
	
	/**
	 * @return query for Delete all those products which were not ordered by any Shopper in last 1 year. 
	 *         Return the number of products deleted.
	 */
	public static String deleteProducts(){
		return "DELETE FROM product WHERE product_id  NOT IN (SELECT DISTINCT product_id "+
				"FROM cart WHERE date > CURRENT_DATE - 365 ) "; 

	}
}
