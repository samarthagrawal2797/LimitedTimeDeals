package com.udaaninterview.limitedtimedeals.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udaaninterview.limitedtimedeals.entity.Deal;
import com.udaaninterview.limitedtimedeals.repo.DealRepository;
import com.udaaninterview.limitedtimedeals.requestpayload.UpdateDealRequestPayload;
@Service
public class DealServiceImpl implements DealService{
	
	@Autowired
	DealRepository repo;
	@Override
	public Deal addDeal(Integer product_id, String name, Integer quantity, Double price, Long validUpto) {
		// TODO Auto-generated method stub
		return repo.save(new Deal(product_id, name, quantity, price, validUpto));
	}
	@Override
	public Deal findDeal(String dealId) {
		// TODO Auto-generated method stub
		Deal deal = repo.findById(dealId).orElseThrow(() -> new RuntimeException("Deal does not exist") );
		return deal;
	}
	@Override
	public void validateDeal(Deal deal) {
		if(deal.getValidUpto() < System.currentTimeMillis()) {
			throw new RuntimeException("Deal has Expired");
		}
		if(deal.getQuantity() < 0) {
			throw new RuntimeException("Sorry the deal is exhausted");
		}
		else {
			deal.setQuantity(deal.getQuantity() - 1);
			repo.save(deal);
		}
	}
	@Override
	public void updateDeal(Deal deal, UpdateDealRequestPayload payload) {
		// TODO Auto-generated method stub
		Integer addQuantity = payload.getAddQuantity() < 0 ? 0 : payload.getAddQuantity();
		Long validUpto = payload.getValidUpto() == null ? null : payload.getValidUpto();
		if(validUpto != null) {
			deal.setValidUpto(validUpto);
		}
		if(addQuantity > 0) {
			deal.setQuantity(deal.getQuantity() + addQuantity);
		}
		repo.save(deal);
	}
	@Override
	public void deleteDeal(Deal deal) {
		// TODO Auto-generated method stub
		repo.delete(deal);
	}
	@Override
	public boolean checkIfDealExists(String dealId) {
		// TODO Auto-generated method stub
		Optional<Deal> o = repo.findById(dealId);
		if(o.isPresent()) {
			return true;
		}
		return false;
	}

}
