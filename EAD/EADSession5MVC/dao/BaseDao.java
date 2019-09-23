package com.metacube.assignment.dao;

import java.util.List;

import com.metacube.assignment.enums.Status;
import com.metacube.assignment.model.Cart;
import com.metacube.assignment.model.Product;

public interface BaseDao<T> {

	/**
	 * @param query
	 * @return true if user is authenticated else false
	 */
	public boolean userAuthentication(String query);
	
	/**
	 * @param query
	 * @return user ID searched by email
	 */
	public int getUserIdByEmail(String query);
	
	/**
	 * @param query
	 * @return true if product is in product stock else false
	 */
	public boolean isProductExist(String query);
	
	/**
	 * @param query
	 * @return true if product is in cart else false
	 */
	public boolean productIsInCart(String query);
	
	/**
	 * @param query
	 * @return Status (ADDED) if product added else FAILED
	 */
	public Status addProductToCart(String query);
	
	/**
	 * @param query
	 * @return Status (UPDATED) if product added else FAILED
	 */
	public Status updateProductInCart(String query);
	
	/**
	 * @param query
	 * @return list of product in cart 
	 */
	public List<Cart> showCart(String query);
	
	/**
	 * @param query
	 * @return Status (DELETED) if product added else FAILED
	 */
	public Status deleteProduct(String query);
	
	/**
	 * @param query
	 * @return list of products in stock
	 */
	public List<Product> getProductList(String query);
}
