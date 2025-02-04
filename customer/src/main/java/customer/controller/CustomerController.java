package customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import customer.model.CustomerRegistrationRequest;
import customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping
	public void regusterCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
		customerService.registerCustomer(customerRequest);
		log.info("New customer registration {}", customerRequest);
	}
}
