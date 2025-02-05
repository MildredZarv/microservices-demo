package com.amigoscode.fraud.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigoscode.fraud.model.FraudCheckHistoryModel;
import com.amigoscode.fraud.repository.FraudRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FraudCheckService {

	private final FraudRepository fraudRepository;	
	
	public boolean isFraudulentCustomer(Integer customerId) {
		fraudRepository.save(
				FraudCheckHistoryModel.builder()
					.customerId(customerId)
					.isFraudster(false)
					.createdAt(LocalDateTime.now())
					.build()
		);
		return false;
	} 
}
