package com.metacube.assignment.facade;

import java.util.List;

import com.metacube.assignment.dao.ProductDao;
import com.metacube.assignment.enums.DbType;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.factory.Factory;
import com.metacube.assignment.model.Cart;
import com.metacube.assignment.model.Product;

public class ProductFacade {
	private ProductDao productDao = Factory.createProductDao(DbType.MYSQL);

	public boolean userAuthentication(String email, String password) {
		String query = "select email from user where email = '" + email
				+ "' and password = '" + password + "'";
		return productDao.userAuthentication(query);
	}

	public int getUserIdByEmail(String email) {
		String query = "select user_id from user where email='" + email + "'";
		return productDao.getUserIdByEmail(query);
	}

	public boolean isProductExist(int productCode) {
		String query = "select product_code from product where product_code = '"
				+ productCode + "'";
		return productDao.isProductExist(query);
	}

	public boolean productIsInCart(int userId, int productCode) {
		String query = "select product_code from CART where user_id ='"
				+ userId + "' and product_code = '" + productCode + "'";
		return productDao.productIsInCart(query);
	}

	public Status addProductToCart(int userId, int productCode,
			int productQuantity) {
		String query = "insert into cart values(" + userId + "," + productCode
				+ "," + productQuantity + ")";
		return productDao.addProductToCart(query);
	}

	public Status updateProductInCart(int userId, int productCode,
			int productQuantity) {
		String query = "update cart set product_quantity ='" + productQuantity
				+ "' where user_id='" + userId + "' and product_code = '"
				+ productCode + "'";
		return productDao.updateProductInCart(query);
	}

	public List<Cart> showCart(int userId) {
		String query = "select c.product_code,p.product_name,p.product_type,c.product_quantity,p.price from cart c,product p where user_id='"
				+ userId + "' and p.product_code=c.product_code";
		return productDao.showCart(query);
	}

	public Status deleteProduct(int userId, int productCode) {
		String query = "delete from cart where user_id = '" + userId
				+ "' and product_code = '" + productCode + "'";
		return productDao.deleteProduct(query);
	}

	public List<Product> getProductList() {
		String query = "select * from product";
		return productDao.getProductList(query);
	}

}
