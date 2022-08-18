package com.EasyShopping.shoppingcart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EasyShopping.shoppingcart.DTO.CustomerDto;
import com.EasyShopping.shoppingcart.model.Customer;
import com.EasyShopping.shoppingcart.repository.CustomerRepository;
import com.EasyShopping.shoppingcart.service.CustomerService;


@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository customerRepository;

	public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
		super();
		this.customerService = customerService;
		this.customerRepository = customerRepository;
	}

	@PostMapping("/customer")
	public Customer createCustomer(@Valid @RequestBody CustomerDto customerDto) {
		Customer newCustomer = customerService.save(customerDto);
		return newCustomer;
	}

	@PutMapping("/customer/{id}")
	public CustomerDto updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto)
	{
		CustomerDto customer3 = customerService.updateCustomer(id, customerDto);
		
		 return  customer3;
	}

	@GetMapping("/customer")
	public List<CustomerDto> getAllCustomer() {
		return customerService.findAll();
	}

	@GetMapping("/customer/{id}")
	public CustomerDto getCustomerById(@PathVariable Long id) {
		CustomerDto customerDto = customerService.findOne(id);
		return customerDto;

	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.ok().build();
	}
}