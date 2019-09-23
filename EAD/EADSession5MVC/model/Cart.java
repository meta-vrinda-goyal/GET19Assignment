package com.metacube.assignment.model;

public class Cart {

	private int productCode;
	private String productName;
	private String productType;
	private int productQuantity;
	private double productPrice;
	public Cart(int productCode, String productName, String productType,
			int productQuantity, double productPrice) {
		this.productCode = productCode;
		this.productName = productName;
		this.productType = productType;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
	}
	public int getProductCode() {
		return productCode;
	}
	public String getProductName() {
		return productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public double getProductPrice() {
		return productPrice;
	}
	@Override
	public String toString() {
		return String.format("\t%d\t%s\t%s\t\t\t%d\t\t%.2f", productCode,
				productName, productType, productQuantity, productPrice);
	}
}
