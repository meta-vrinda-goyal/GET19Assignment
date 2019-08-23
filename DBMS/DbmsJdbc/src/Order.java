import java.sql.Date;

/**
 * @author Vrinda
 * Class for order details 
 */
public class Order {
	private int orderID;
	private Date orderDate;
	private int orderTotal;
	public Order(int orderID, Date orderDate, int orderTotal) {
		
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	
}
