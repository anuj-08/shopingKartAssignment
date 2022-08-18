package com.EasyShopping.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.EasyShopping.shoppingcart.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(nativeQuery = true ,value =  "SELECT * FROM category where category.idCategory=?1")
	Category findCategoryById(Long id);

}
