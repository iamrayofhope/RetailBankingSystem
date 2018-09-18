package com.tcs.ilp.SupplyManagement.SupplyManagement.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Supply_1418076")
public class Supply {

	@Id
	@Column(name = "supplyId")
	private String supplyId;

	@Column(name = "productId")
	private String productId;

	@Column(name = "vendorId")
	private String vendorId;

	@Column(name = "purchaseQuantity")
	private String purchaseQuantity;

	@Column(name = "supplyDate")
	private String supplyDate;

	public Supply() {
		
	}
	
	public String getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(String supplyId) {
		this.supplyId = supplyId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(String purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public String getSupplyDate() {
		return supplyDate;
	}

	public void setSupplyDate(String supplyDate) {
		this.supplyDate = supplyDate;
	}

}
