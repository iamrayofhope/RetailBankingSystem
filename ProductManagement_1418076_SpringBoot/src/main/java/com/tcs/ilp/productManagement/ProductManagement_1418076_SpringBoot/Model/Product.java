package com.tcs.ilp.productManagement.ProductManagement_1418076_SpringBoot.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Product_1418076")
public class Product {

	@Id
	@Column(name = "productId")
	private int productId;
	@Column(name = "productName")
	private String productName;
	@Column(name = "manufacturerDetails")
	private String manufacturerDetails;
	@Column(name = "price")
	private String price;

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int productId, String productName, String manufacturerDetails, String price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.manufacturerDetails = manufacturerDetails;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getManufacturerDetails() {
		return manufacturerDetails;
	}

	public void setManufacturerDetails(String manufacturerDetails) {
		this.manufacturerDetails = manufacturerDetails;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
