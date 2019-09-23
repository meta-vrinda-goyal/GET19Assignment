package com.metacube.assignment.model;

public class Product {

	private int productCode;
	private String productName;
	private String productType;
	private double price;
	public Product(int productCode, String productName, String productType,
			double price) {
		this.productCode = productCode;
		this.productName = productName;
		this.productType = productType;
		this.price = price;
	}
	public int getProductCode() {
		return productCode;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductType() {
		return productType;
	}
	public double getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return String.format("\t%d\t%s\t%s\t\t%.2f", productCode, productName,
				productType, price);
	}

}
