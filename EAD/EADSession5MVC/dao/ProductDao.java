package com.metacube.assignment.dao;

import java.sql.SQLException;
import java.util.List;

import com.metacube.assignment.enums.DbType;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.model.Cart;
import com.metacube.assignment.model.Product;

public class ProductDao implements BaseDao<Product> {

	private BaseDao<Product> baseDao;

	public ProductDao(DbType dbType) throws ClassNotFoundException,
			SQLException {
		if (dbType == DbType.MYSQL)
			baseDao = new MySqlDao();
		else if (dbType == DbType.IN_MEMORY)
			baseDao = new InMemoryDao();
	}

	@Override
	public boolean userAuthentication(String query) {
		return baseDao.userAuthentication(query);
	}

	@Override
	public int getUserIdByEmail(String query) {
		return baseDao.getUserIdByEmail(query);
	}

	@Override
	public boolean isProductExist(String query) {
		return baseDao.isProductExist(query);
	}

	@Override
	public boolean productIsInCart(String query) {
		return baseDao.productIsInCart(query);
	}

	@Override
	public Status addProductToCart(String query) {
		return baseDao.addProductToCart(query);
	}

	@Override
	public Status updateProductInCart(String query) {
		return baseDao.updateProductInCart(query);
	}

	@Override
	public List<Cart> showCart(String query) {
		return baseDao.showCart(query);
	}

	@Override
	public Status deleteProduct(String query) {
		return baseDao.deleteProduct(query);
	}

	@Override
	public List<Product> getProductList(String query) {
		return baseDao.getProductList(query);
	}
}
