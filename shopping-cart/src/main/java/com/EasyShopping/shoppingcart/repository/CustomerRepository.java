package com.EasyShopping.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.EasyShopping.shoppingcart.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(nativeQuery = true ,value =  "SELECT * FROM customer where customer.id=?1")
	Customer findCustomerById(Long id);

	

}
