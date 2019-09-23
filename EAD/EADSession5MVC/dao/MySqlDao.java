package com.metacube.assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.assignment.enums.Status;
import com.metacube.assignment.model.Cart;
import com.metacube.assignment.model.Product;

public class MySqlDao implements BaseDao<Product> {

	private Connection connection;

	public MySqlDao() throws ClassNotFoundException, SQLException {
		connection = MySQLCon.getConnection();
	}

	@Override
	public boolean userAuthentication(String query) {
		try {
			PreparedStatement statement = MySQLCon.getConnection()
					.prepareStatement(query);
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			connection.commit();
			return resultSet.next();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}
	}

	@Override
	public int getUserIdByEmail(String query) {
		int userId = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			connection.commit();
			resultSet.next();
			userId = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return userId;
	}

	@Override
	public boolean isProductExist(String query) {
		try {
			PreparedStatement statement = MySQLCon.getConnection()
					.prepareStatement(query);
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			connection.commit();
			return resultSet.next();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}
	}

	@Override
	public boolean productIsInCart(String query) {
		try {
			PreparedStatement statement = MySQLCon.getConnection()
					.prepareStatement(query);
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			connection.commit();
			return resultSet.next();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}
	}

	@Override
	public Status addProductToCart(String query) {
		try {
			PreparedStatement statement = MySQLCon.getConnection()
					.prepareStatement(query);
			connection.setAutoCommit(false);
			statement.executeUpdate();
			connection.commit();
			return Status.ADDED;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return Status.FAILED;
		}
	}

	@Override
	public Status updateProductInCart(String query) {
		try {
			PreparedStatement statement = MySQLCon.getConnection()
					.prepareStatement(query);
			connection.setAutoCommit(false);
			statement.executeUpdate();
			connection.commit();
			return Status.UPDATED;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return Status.FAILED;
		}
	}

	@Override
	public List<Cart> showCart(String query) {
		List<Cart> cartList = new ArrayList<Cart>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			connection.commit();
			while (resultSet.next()) {
				cartList.add(new Cart(resultSet.getInt(1), resultSet
						.getString(2), resultSet.getString(3), resultSet
						.getInt(4), resultSet.getDouble(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return cartList;
	}

	@Override
	public Status deleteProduct(String query) {
		try {
			PreparedStatement statement = MySQLCon.getConnection()
					.prepareStatement(query);
			connection.setAutoCommit(false);
			statement.executeUpdate();
			connection.commit();
			return Status.DELETED;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return Status.FAILED;
		}
	}

	@Override
	public List<Product> getProductList(String query) {
		List<Product> productList = new ArrayList<Product>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			ResultSet resultSet = statement.executeQuery();
			connection.commit();
			while (resultSet.next()) {
				productList.add(new Product(resultSet.getInt(1), resultSet
						.getString(2), resultSet.getString(3), resultSet
						.getDouble(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return productList;
	}

}
