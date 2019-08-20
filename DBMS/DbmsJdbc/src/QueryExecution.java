import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vrinda Class to execute queries
 */
public class QueryExecution {
	
	private Connection connectToDB;

	public QueryExecution(Connection con) throws ClassNotFoundException,SQLException {
		connectToDB = ConnectionToDB.getConnection();
	}

	/**
	 * @param shopperId
	 * @return list of order details
	 */
	public List<Order> getShippedOrdersDetails(int shopperId) {
		//if shopper id not valid
		if (shopperId < 1) {
			throw new AssertionError("Invalid shopper id");
		}
		//list for storing order details
		List<Order> listOfOrderDetails = new ArrayList<Order>();
		try {
			//prepared statement for query 
			PreparedStatement getOrderListQuery = connectToDB.prepareStatement(QueryStatement.getShippedOrders());
			//set shopper_id as given by user
			getOrderListQuery.setInt(1, shopperId);
			ResultSet orders = getOrderListQuery.executeQuery();
			while (orders.next()) {
				//store resulting output in list
				listOfOrderDetails.add(new Order(orders.getInt(1), orders.getDate(2), orders.getInt(3)));
			}
		} catch (SQLException e) {
			System.out.println("SQL exception occured:" + e.getMessage());
		}
		return listOfOrderDetails;

	}

	/**
	 * @param productId
	 * @param images
	 * @return number of new images inserted
	 */
	public int insertNewImage(int productId, List<Image> images) {
		if (productId < 1) {
			throw new AssertionError("Invalid product ID");
		}
		//if no images are given
		if (images.size() == 0) {
			System.out.println("No images selected");
			return 0;
		}
		int numberOfImagesInserted = 0;
		try {
			PreparedStatement imageInsertionQuery = connectToDB.prepareStatement(QueryStatement.insertImage());
			try {

				connectToDB.setAutoCommit(false);
				for (Image img : images) {
					imageInsertionQuery.setInt(1, productId);
					imageInsertionQuery.setString(2, img.getImgName());
					//batch insertion
					imageInsertionQuery.addBatch();
					numberOfImagesInserted++;
				}
				imageInsertionQuery.executeBatch();
				//connection to be committed
				connectToDB.commit();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				//if error then rollback connection
				connectToDB.rollback();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return numberOfImagesInserted;
	}

	/**
	 * @return list of top category with number of child
	 */
	public List<TopCategory> getTopCategoryInformation() {
		//list for storing top categories detail
		List<TopCategory> topCategoryInfoList = new ArrayList<TopCategory>();
		try {
			PreparedStatement getTopCategoryListQuery = connectToDB.prepareStatement(QueryStatement.displayCountOfChildCategory());
			ResultSet topCategoryList = getTopCategoryListQuery.executeQuery();
			while (topCategoryList.next()) {
				//add details in list
				topCategoryInfoList.add(new TopCategory(topCategoryList.getString(1), topCategoryList.getInt(2)));
			}
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return topCategoryInfoList;
	}

	/**
	 * @return number of products left after deleting certain products 
	 */
	public int deleteProducts() {
		int countOfDeletedProducts = 0;
		try {
			PreparedStatement deleteProductQuery = connectToDB.prepareStatement(QueryStatement.deleteProducts());
			countOfDeletedProducts = deleteProductQuery.executeUpdate();

		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return countOfDeletedProducts;
	}

}
