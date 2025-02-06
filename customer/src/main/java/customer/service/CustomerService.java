package customer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import customer.model.Customer;
import customer.model.CustomerRegistrationRequest;
import customer.model.FraudCheckResponse;
import customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	private final CustomerRepository customerRepository;
	private final RestTemplate restTemplate;
	
	public void registerCustomer(CustomerRegistrationRequest request) {
		Customer customer = Customer.builder()
				.firstName(request.firstName())
				.lastName(request.lastName())
				.email(request.email())
				.build();
		customerRepository.saveAndFlush(customer);
		
		FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
				"http://FRAUDSERVICE/api/v1/fraud-check/{customerId}", 
				FraudCheckResponse.class, 
				customer.getId());
		
		if(fraudCheckResponse.isFraudster()) {
			throw new IllegalStateException("fraudster");
		}
	}
}
