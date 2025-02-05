package com.amigoscode.fraud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigoscode.fraud.model.FraudCheckResponse;
import com.amigoscode.fraud.service.FraudCheckService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
	
	private final FraudCheckService fraudService;

	@GetMapping(path = "{customerId}")
	public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
		boolean isFraudulentCustomer = fraudService.isFraudulentCustomer(customerId);
		return new FraudCheckResponse(isFraudulentCustomer);
	}
}
