package com.EasyShopping.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.EasyShopping.shoppingcart.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	@Query(nativeQuery = true ,value =  "SELECT * FROM address where address.id=?1")
	Address findAddressById(Long id);

}
