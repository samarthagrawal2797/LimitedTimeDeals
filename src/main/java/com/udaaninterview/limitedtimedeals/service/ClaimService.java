package com.udaaninterview.limitedtimedeals.service;

import org.springframework.stereotype.Service;

import com.udaaninterview.limitedtimedeals.entity.Claim;

@Service
public interface ClaimService {

	public boolean checkIfUserIsValidForClaim(String claimId);
	public Claim addClaim(String claimId, String dealId, Integer userId);
}
