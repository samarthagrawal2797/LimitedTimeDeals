package com.udaaninterview.limitedtimedeals.requestpayload;

import com.fasterxml.jackson.annotation.JsonProperty;
 
public class CreateDealRequestPayload {

	@JsonProperty("productId")
	private Integer productId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("quantity")
	private Integer quantity;
	
	@JsonProperty("price")
	private Double price;
	
	@JsonProperty("validUpto")
	private Long validUpto;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(Long validUpto) {
		this.validUpto = validUpto;
	}
	
}
