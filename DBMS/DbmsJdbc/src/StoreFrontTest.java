import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoreFrontTest {

	@Test
	public void TestA_ShoppeHasShippedItems() throws ClassNotFoundException, SQLException {
		Connection con = null ;
		QueryExecution execution = new QueryExecution(con);
		List<Order> resultList = new ArrayList<Order>();
		resultList.add(new Order(4, java.sql.Date.valueOf("2019-03-12"), 1700));
		resultList.add(new Order(3, java.sql.Date.valueOf("2019-07-12"), 1700));
		resultList.add(new Order(2, java.sql.Date.valueOf("2019-08-04"), 25000));
		resultList.add(new Order(2, java.sql.Date.valueOf("2019-08-04"), 70000));
		List<Order> orderList = execution.getShippedOrdersDetails(2);
		for (int i = 0; i < resultList.size(); i++) {
			assertEquals(resultList.get(i).getOrderID(), orderList.get(i).getOrderID());
			assertEquals(resultList.get(i).getOrderDate(), orderList.get(i).getOrderDate());
			assertEquals(resultList.get(i).getOrderTotal(), orderList.get(i).getOrderTotal());
		}
	}
	@Test(expected = AssertionError.class)
	public void TestB_shopperIdNotValid() throws ClassNotFoundException, SQLException{
		Connection con = null ;
		QueryExecution execution = new QueryExecution(con);
		execution.getShippedOrdersDetails(-4);
	}
	@Test
	public void TestC_insertImages() throws ClassNotFoundException, SQLException{
		Connection con = null ;
		QueryExecution execution = new QueryExecution(con);
		List<Image> imagesList = new ArrayList<Image>();
		imagesList.add(new Image("newImage1", "newImgUrl1"));
		imagesList.add(new Image("newimg2","newImgUrl2"));
		int numberOfImageInserted = execution.insertNewImage(2, imagesList);
		assertEquals(2, numberOfImageInserted );
	}
	@Test
	public void TestD_insertImagesWhenNoImagesSelected() throws ClassNotFoundException, SQLException{
		Connection con = null ;
		QueryExecution execution = new QueryExecution(con);
		List<Image> imagesList = new ArrayList<Image>();
		int numberOfImageInserted = execution.insertNewImage(2, imagesList);
		assertEquals(0, numberOfImageInserted );
	}
	@Test(expected = AssertionError.class)
	public void TestE_insertImagesWhenInvalidProductId() throws ClassNotFoundException, SQLException{
		Connection con = null ;
		QueryExecution execution = new QueryExecution(con);
		List<Image> imagesList = new ArrayList<Image>();
		execution.insertNewImage(-7, imagesList);
	}
	@Test
	public void TestF_getTopCategoryInfo() throws ClassNotFoundException, SQLException{
		Connection con = null ;
		QueryExecution execution = new QueryExecution(con);
		List<TopCategory> topCategoryListExpected = new ArrayList<TopCategory>();
		topCategoryListExpected.add(new TopCategory("Electronics", 4));
		topCategoryListExpected.add(new TopCategory("Fashion", 3));
		topCategoryListExpected.add(new TopCategory("Grocery and household", 2));
		topCategoryListExpected.add(new TopCategory("Mobile and Computer", 4));
		topCategoryListExpected.add(new TopCategory("Personal care and health", 1));
		
		List<TopCategory> topCategoryListActual = execution.getTopCategoryInformation();
		for(int i = 0; i<topCategoryListActual.size(); i++){
			assertEquals(topCategoryListExpected.get(i).getName(),topCategoryListActual.get(i).getName());
			assertEquals(topCategoryListExpected.get(i).getNumberOfChildCategory(),topCategoryListActual.get(i).getNumberOfChildCategory());
		}
	}

	@Test
	public void TestG_deleteProducts() throws ClassNotFoundException, SQLException{
		Connection con = null ;
		QueryExecution execution = new QueryExecution(con);
		int numberOfProductsDeleted = execution.deleteProducts();
		assertEquals(4,numberOfProductsDeleted);
	}
	
}
