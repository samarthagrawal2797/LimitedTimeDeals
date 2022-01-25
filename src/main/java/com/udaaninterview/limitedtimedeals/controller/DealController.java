package com.udaaninterview.limitedtimedeals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.udaaninterview.limitedtimedeals.entity.Deal;
import com.udaaninterview.limitedtimedeals.requestpayload.ClaimDealRequestPayload;
import com.udaaninterview.limitedtimedeals.requestpayload.CreateDealRequestPayload;
import com.udaaninterview.limitedtimedeals.requestpayload.UpdateDealRequestPayload;
import com.udaaninterview.limitedtimedeals.service.ClaimServiceImpl;
import com.udaaninterview.limitedtimedeals.service.DealServiceImpl;

@RestController
@RequestMapping(value = "/deal", consumes = MediaType.APPLICATION_JSON_VALUE)
public class DealController {

	@Autowired
	DealServiceImpl dealService;
	
	@Autowired
	ClaimServiceImpl claimService;
	
	@PostMapping("/addNewDeal")
	public @ResponseBody ResponseEntity<String> addNewDeal(@RequestBody CreateDealRequestPayload payload){
		Integer product_id = payload.getProductId();
		String name = payload.getName();
		Integer quantity = payload.getQuantity();
		Double price = payload.getPrice();
		Long validUpto = payload.getValidUpto();
		Boolean dealAlreadyExists = dealService.checkIfDealExists(name);
		if(dealAlreadyExists) {
			throw new RuntimeException("Deal already exists for deal name"+name);
		}
		else {
			dealService.addDeal(product_id, name, quantity, price, validUpto);
		}
		return new ResponseEntity<String>("Successfully created a deal", HttpStatus.OK);
	}
	@GetMapping("/getDealInfo/{dealId}")
	public @ResponseBody ResponseEntity<Deal> getDealInfo(@PathVariable String dealId){
		Deal deal = dealService.findDeal(dealId);
		return new ResponseEntity<Deal>(deal, HttpStatus.OK);
	}
	@PostMapping("/claimDeal")
	public @ResponseBody ResponseEntity<String> claimDeal(@RequestBody ClaimDealRequestPayload payload){
		
		String dealId = payload.getDealId();
		Integer userId = payload.getUserId();
		String claimId = dealId + Integer.toString(userId);
		Deal deal = dealService.findDeal(dealId);
		Boolean validUser = claimService.checkIfUserIsValidForClaim(claimId);
		if(validUser) {
			dealService.validateDeal(deal);
			claimService.addClaim(claimId, dealId, userId);
		}
		else {
			throw new RuntimeException("Already claimed the deal");
		}
		
		return new ResponseEntity<String>("Successfully claimed a deal", HttpStatus.OK);
	}
	@PutMapping("/updateDeal/{dealId}")
	public @ResponseBody ResponseEntity<String> updateDeal(@RequestBody UpdateDealRequestPayload payload,@PathVariable String dealId ){
		
		Deal deal = dealService.findDeal(dealId);
		dealService.updateDeal(deal, payload);
		return new ResponseEntity<String>("Successfully updated a deal", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteDeal/{dealId}")
	public @ResponseBody ResponseEntity<String> deleteDeal(@PathVariable String dealId){
		Deal deal = dealService.findDeal(dealId);
		dealService.deleteDeal(deal);
		return new ResponseEntity<String>("Successfully deleted a deal", HttpStatus.OK);
	}
	
	
}
