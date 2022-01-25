package com.udaaninterview.limitedtimedeals.service;

import org.springframework.stereotype.Service;

import com.udaaninterview.limitedtimedeals.entity.Deal;
import com.udaaninterview.limitedtimedeals.requestpayload.UpdateDealRequestPayload;
@Service
public interface DealService {
	public Deal addDeal(Integer product_id, String name, Integer quantity, Double price, Long validUpto);
	public Deal findDeal(String dealId);
	public void validateDeal(Deal deal);
	public void updateDeal(Deal deal, UpdateDealRequestPayload payload);
	public void deleteDeal(Deal deal);
	public boolean checkIfDealExists(String dealId);
	
}
