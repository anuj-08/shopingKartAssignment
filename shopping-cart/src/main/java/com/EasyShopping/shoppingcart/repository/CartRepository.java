package com.EasyShopping.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.EasyShopping.shoppingcart.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query(nativeQuery = true ,value =  "SELECT * FROM cart where cart.idCart=?1")
	Cart findCartById(Long id);

}
