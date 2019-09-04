package com.metacube.assignment.dao;

import java.util.List;

import com.metacube.assignment.enums.Status;
import com.metacube.assignment.model.Cart;
import com.metacube.assignment.model.Product;

public class InMemoryDao implements BaseDao<Product> {

	@Override
	public boolean userAuthentication(String query) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getUserIdByEmail(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isProductExist(String query) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean productIsInCart(String query) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Status addProductToCart(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status updateProductInCart(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> showCart(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status deleteProduct(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductList(String query) {
		// TODO Auto-generated method stub
		return null;
	}
}
