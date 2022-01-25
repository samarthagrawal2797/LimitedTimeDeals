package com.udaaninterview.limitedtimedeals.requestpayload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClaimDealRequestPayload {
	@JsonProperty("userId")
	private Integer userId;
	
	@JsonProperty("dealId")
	private String dealId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}
}
