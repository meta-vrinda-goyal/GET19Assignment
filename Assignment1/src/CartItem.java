
public class CartItem {
	int index;
	String name1;
	int quantity;
	double price;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CartItem(int index, String name1, int quantity, double price) {
		super();
		this.index = index;
		this.name1 = name1;
		this.quantity = quantity;
		this.price = price;
	}
}
