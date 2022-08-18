package com.EasyShopping.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.EasyShopping.shoppingcart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(nativeQuery = true ,value =  "SELECT * FROM product where product.idProduct=?1")

	Product findProductById(Long id);

}
