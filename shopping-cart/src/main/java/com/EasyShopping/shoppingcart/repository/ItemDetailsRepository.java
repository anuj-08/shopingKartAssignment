package com.EasyShopping.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.EasyShopping.shoppingcart.model.ItemDetails;

@Repository
public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Long> {

	@Query(nativeQuery = true ,value =  "SELECT * FROM itemdetails where itemdetails.id=?1")
	ItemDetails findCustomerById(Long id);

}
