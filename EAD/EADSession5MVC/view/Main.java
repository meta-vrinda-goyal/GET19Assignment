package com.metacube.assignment.view;

import java.util.List;
import java.util.Scanner;

import com.metacube.assignment.controller.ProductController;
import com.metacube.assignment.model.Cart;
import com.metacube.assignment.model.Product;

public class Main {
	
	private static ProductController productController = new ProductController();
	public static void main(String[] args) {
		//call userAuthentication for getting authentication
		int userId = userAuthentication();
		int choice = 0, productCode = 0, productQuantity;
		//label 
		Loop : do {
			System.out
					.println("Welcome to Shopping App\n1.Add product to cart\n2.update cart\n3.show cart\n4.delete product in cart\n5.exit");
			System.out.println("Enter choice : ");
			try {
				Scanner scanner = new Scanner(System.in);
				choice = scanner.nextInt();
				switch (choice) {
					case 1 :
						//list all product in stock
						showProducts();
						System.out.println("enter product code : ");
						productCode = scanner.nextInt();
						//if product code is valid
						if (productController.isProductExist(productCode)) {
							//check if product is already in stock
							if (!productController.productIsInCart(userId,
									productCode)) {
								System.out.println("enter product quantity : ");
								productQuantity = scanner.nextInt();
								//check quantity
								if (productQuantity > 0)
									//print status after adding product
									System.out.println(productController
											.addProductToCart(userId,
													productCode,
													productQuantity));
								else
									System.out.println("invalid quantity");
							} else
								System.out
										.println("product already is in your cart");
						} else
							System.out.println("invalid product code");
						break;
					case 2 :
						System.out.println("enter product code : ");
						productCode = scanner.nextInt();
						//check if product is in cart
						if (productController.productIsInCart(userId,
								productCode)) {
							System.out.println("enter product quantity : ");
							productQuantity = scanner.nextInt();
							//check if product quantity is valid
							if (productQuantity > 0)
								//print status after updating product
								System.out.println(productController
										.updateProductInCart(userId,
												productCode, productQuantity));
							else
								System.out.println("invalid quantity");
						} else
							System.out.println("product is not in your cart");
						break;

					case 3 :
						//list for showing cart items
						List<Cart> cartList = productController.showCart(userId);
						System.out.println("Product Code\tProduct Name\tProduct Type\tProduct Quantity\tPrice");
						for (Cart cart : cartList) {
							System.out.println(cart.toString());
						}
						break;
					case 4 :
						System.out.println("enter product code : ");
						productCode = scanner.nextInt();
						//check if product is in cart
						if (productController.productIsInCart(userId,
								productCode)) {
							//print status after deleting product
							System.out.println(productController.deleteProduct(
									userId, productCode));
						} else
							System.out.println("product is not in your cart");
						break;
				}
			} catch (Exception e) {
				//exception for input mismatch
				System.out.println("something went wrong");
				continue Loop;
			}
			//exit if choice is 5
		} while (choice != 5);
		System.out.println("Thank you for using Shopping App");
	}

	/**
	 * show product items in stock
	 */
	private static void showProducts() {
		List<Product> productList = productController.getProductList();
		System.out.println("Product Code\tProduct Name\tProduct Type\tPrice");
		for (Product product : productList) {
			System.out.println(product.toString());
		}
	}

	/**
	 * @return userId after authentication done successfully
	 */
	private static int userAuthentication() {
		Scanner scanner = new Scanner(System.in);
		String email, password;
		int userId;
		do {
			System.out.println("Enter Email : ");
			email = scanner.nextLine();
			System.out.println("Enter Password : ");
			password = scanner.nextLine();
		} 
		//ask for email and password until user enters correct credentials
		while (!productController.userAuthentication(email, password));
		//get userId after successful authentication
		userId = productController.getUserIdByEmail(email);
		return userId;
	}
}
