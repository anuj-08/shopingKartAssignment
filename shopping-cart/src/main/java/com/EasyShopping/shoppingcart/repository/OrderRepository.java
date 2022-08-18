package com.EasyShopping.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.EasyShopping.shoppingcart.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query(nativeQuery = true ,value =  "SELECT * FROM order where order.idorder=?1")
	Order findOrderById(Long id);

}
