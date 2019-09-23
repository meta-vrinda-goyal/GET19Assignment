package com.metacube.assignment.factory;

import java.sql.SQLException;

import com.metacube.assignment.dao.ProductDao;
import com.metacube.assignment.enums.DbType;
import com.metacube.assignment.facade.ProductFacade;
import com.metacube.assignment.model.Product;

public class Factory {

	public static ProductFacade createProductFacade() {
		return new ProductFacade();
	}

	public static ProductDao createProductDao(DbType dbType) {
		try {
			return new ProductDao(dbType);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public Product createProduct(int productCode, String productName,
			String productType, double price) {
		Product product = new Product(productCode, productName, productType,
				price);
		return product;
	}

}
