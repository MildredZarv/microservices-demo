package customer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import customer.model.CustomerRegistrationRequest;
import customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

	private final CustomerService customerService;
	
	@PostMapping
	public void regusterCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
		customerService.registerCustomer(customerRequest);
		log.info("New customer registration {}", customerRequest);
	}
}
