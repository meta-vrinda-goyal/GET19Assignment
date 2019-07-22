import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
	List<CartItem> l1 = new ArrayList<CartItem>();
	int flag = 0;
	int flag2 = 0;
	Scanner sc = new Scanner(System.in);
	// add item to cart
	public void addItem(CartItem cartItem){
		if (l1.isEmpty()){
			l1.add(new CartItem(cartItem.getIndex(),cartItem.getName1(),1,cartItem.getPrice()));
			flag2 = 1;
		}
		else {
			int check = cartItem.getIndex();
			for(int i = 0; i < l1.size(); i++) {
				if( check==l1.get(i).getIndex() ){
					System.out.println("Item is already in cart. Update it's quantity by selecting 2 option.");
					flag = 1;
					break;
				}
			}
			if (flag == 0 && flag2 == 1){
				l1.add(new CartItem(cartItem.getIndex(),cartItem.getName1(),1,cartItem.getPrice()));
			}
		}
		
	}
	// show cart items
	public void showCart(){
		if(l1.isEmpty()){
			System.out.println("Cart is empty!");
			System.out.println();
		}
		else {
			System.out.println("Sr.NO." + " " + "Item name" + " " + "Item quantity");
			for(int i = 0; i < l1.size(); i++) {
				System.out.println(i+1 + "      " + l1.get(i).getName1() + "      " + l1.get(i).getQuantity());
				
			}
			System.out.println();
		}
	}
	// update quantity of items
	public void updateCart(){
		System.out.println("Write the item number and updated quantity");
		int itemNumber = sc.nextInt();
		if((itemNumber-1) >= l1.size()) {
			System.out.println("This item does not exist");
			System.out.println();
			return;
		}
		int updatedQuan =sc.nextInt();
		if(updatedQuan == 0) {
			l1.remove(itemNumber-1);	
		}
		else l1.get(itemNumber-1).setQuantity(updatedQuan);
	}
	
	
	//generate bill
	public void generateBill(){
		if(l1.isEmpty()) {
			System.out.println("The cart has no item");
			System.out.println();
		}
		else {
			System.out.println("Sr. No." + "  " + "Ïtem Name" + "  " + "Item Quantity" + "  " + "PricePerItem" + "  " + "Price");
			double amt=0;
			for(int i = 0; i < l1.size(); i++){
				double price = l1.get(i).getQuantity() * l1.get(i).getPrice();
				System.out.println(i+1 + "        " + l1.get(i).getName1() + "        " + l1.get(i).getQuantity() + "            " + l1.get(i).getPrice() + "            " + price);
				//amt += l1.get(i).getQuantity() * l1.get(i).getPrice();
				amt += price;
			}
			System.out.println("Your Bill amount is" + " " + amt);
			System.out.println();
		
		}
	}
}
