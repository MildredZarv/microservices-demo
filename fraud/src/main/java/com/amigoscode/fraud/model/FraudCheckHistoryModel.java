package com.amigoscode.fraud.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistoryModel {
	@Id
	@SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
	private Integer id;
	private Integer customerId;
	private Boolean isFraudster;
	private LocalDateTime createdAt;
}
