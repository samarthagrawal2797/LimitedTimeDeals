package com.udaaninterview.limitedtimedeals.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udaaninterview.limitedtimedeals.entity.Claim;
import com.udaaninterview.limitedtimedeals.repo.ClaimRepository;

@Service
public class ClaimServiceImpl implements ClaimService{

	@Autowired
	ClaimRepository repo;
	@Override
	public boolean checkIfUserIsValidForClaim(String claimId) {
		// TODO Auto-generated method stub
		Optional<Claim> o = repo.findById(claimId);
		if(o.isPresent()) {
			return false;
		}
		return true;
		
	}
	@Override
	public Claim addClaim(String claimId, String dealId, Integer userId) {
		// TODO Auto-generated method stub
		return repo.save(new Claim(claimId, dealId, userId));
	}

}
