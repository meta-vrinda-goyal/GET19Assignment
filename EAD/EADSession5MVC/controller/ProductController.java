package com.metacube.assignment.controller;

import java.util.List;

import com.metacube.assignment.enums.DbType;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.facade.ProductFacade;
import com.metacube.assignment.factory.Factory;
import com.metacube.assignment.model.Cart;
import com.metacube.assignment.model.Product;

public class ProductController {
	private ProductFacade productFacade = Factory.createProductFacade();

	public boolean userAuthentication(String email, String password) {
		return productFacade.userAuthentication(email, password);
	}

	public int getUserIdByEmail(String email) {
		return productFacade.getUserIdByEmail(email);
	}

	public boolean isProductExist(int productCode) {
		return productFacade.isProductExist(productCode);
	}

	public boolean productIsInCart(int userId, int productCode) {
		return productFacade.productIsInCart(userId, productCode);
	}

	public Status addProductToCart(int userId, int productCode,
			int productQuantity) {
		return productFacade.addProductToCart(userId, productCode,
				productQuantity);
	}

	public Status updateProductInCart(int userId, int productCode,
			int productQuantity) {
		return productFacade.updateProductInCart(userId, productCode,
				productQuantity);
	}

	public List<Cart> showCart(int userId) {
		return productFacade.showCart(userId);
	}

	public Status deleteProduct(int userId, int productCode) {
		return productFacade.deleteProduct(userId, productCode);
	}

	public List<Product> getProductList() {
		return productFacade.getProductList();
	}
}
