package com.EasyShopping.shoppingcart.service;

import java.util.List;

import com.EasyShopping.shoppingcart.DTO.CategoryDto;
import com.EasyShopping.shoppingcart.DTO.CustomerDto;
import com.EasyShopping.shoppingcart.model.Category;
import com.EasyShopping.shoppingcart.model.Customer;

public interface CategoryService {

	Category save(CategoryDto categoryDto);

	CategoryDto updateCategory(Long id, CategoryDto categoryDto);

	CategoryDto findOne(Long id);

	List<CategoryDto> findAll();

	void deleteCategory(Long id);

}
