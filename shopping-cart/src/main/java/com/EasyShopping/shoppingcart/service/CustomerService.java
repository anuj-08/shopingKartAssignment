 package com.EasyShopping.shoppingcart.service;

import java.util.List;

import com.EasyShopping.shoppingcart.DTO.CustomerDto;
import com.EasyShopping.shoppingcart.model.Customer;

public interface CustomerService {
	
	Customer save(CustomerDto customerDto);
	
	CustomerDto updateCustomer(Long id, CustomerDto customerDto);
	
	CustomerDto findOne(Long id);
	
	List<CustomerDto> findAll();
	
	 void deleteCustomer(Long id);
	 
	 

}
