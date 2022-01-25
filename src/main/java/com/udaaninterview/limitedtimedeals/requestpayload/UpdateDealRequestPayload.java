package com.udaaninterview.limitedtimedeals.requestpayload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateDealRequestPayload {
	@JsonProperty("quantityAdded")
	private Integer addQuantity;
	
	@JsonProperty("validUpto")
	private Long validUpto;

	public Integer getAddQuantity() {
		return addQuantity;
	}

	public void setAddQuantity(Integer addQuantity) {
		this.addQuantity = addQuantity;
	}

	public Long getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(Long validUpto) {
		this.validUpto = validUpto;
	}
}
