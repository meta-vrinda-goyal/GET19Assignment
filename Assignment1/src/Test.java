import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main (String[] args){
		List<CartItem> listOfItems = new ArrayList<CartItem>();
		listOfItems.add(new CartItem(1,"Bread",10,20));
		listOfItems.add(new CartItem(2,"Milk",10,45));
		listOfItems.add(new CartItem(3,"Soap",10,50));
		listOfItems.add(new CartItem(4,"Shampoo",10,100));
		listOfItems.add(new CartItem(5,"Biscuit",10,15));
		
		System.out.println("Welcome! Select an option from below");
		int optionSelected;
		ShoppingCart cart = new ShoppingCart();
		do {
			System.out.println("1.)Add item to cart");
			System.out.println("2.)Remove the item or Update the item quantity");
			System.out.println("3.)Show cart items");
			System.out.println("4.)Generate Bill");
			System.out.println("5.)EXIT");
			
			Scanner sc = new Scanner(System.in);
		    optionSelected = sc.nextInt();
			
			switch (optionSelected){
				case 1:
					for(int i = 0; i < listOfItems.size(); i++) {
						System.out.println(i+1 + " " + listOfItems.get(i).getName1() + " " + listOfItems.get(i).getPrice());
					}
					
					System.out.println("Write Item number to add to cart");
					int n = sc.nextInt();
					int itemQuan = 1;
					int in = listOfItems.get(n-1).getIndex();
					String itemName2 = listOfItems.get(n-1).getName1();
					double p = listOfItems.get(n-1).getPrice();
					CartItem cartItem = new CartItem(in,itemName2,itemQuan,p);
					cart.addItem(cartItem);
					break;
			
				case 2:
					cart.updateCart();
					break;
				
				case 3:
					cart.showCart();
					break;
				
				case 4:
					cart.generateBill();
					break;
			
			}
	}
	while (optionSelected != 5);
	
	}
}
