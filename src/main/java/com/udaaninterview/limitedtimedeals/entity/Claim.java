package com.udaaninterview.limitedtimedeals.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deal_user")
public class Claim {
	
	public Claim() {
		super();
	}

	@Id
	@Column(name = "deal_user_id")
	private String claimId;
	
	@Column
	private String dealId;
	
	@Column
	private Integer userId;


	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Claim(String claimId, String dealId, Integer userId) {
		super();
		this.claimId = claimId;
		this.dealId = dealId;
		this.userId = userId;
	}
}
