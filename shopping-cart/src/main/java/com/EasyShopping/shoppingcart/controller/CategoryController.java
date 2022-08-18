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

import com.EasyShopping.shoppingcart.DTO.CategoryDto;
import com.EasyShopping.shoppingcart.DTO.CustomerDto;
import com.EasyShopping.shoppingcart.model.Category;
import com.EasyShopping.shoppingcart.model.Customer;
import com.EasyShopping.shoppingcart.repository.CategoryRepository;
import com.EasyShopping.shoppingcart.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryRepository category;
	
	@Autowired
	private CategoryService categoryService;

	public CategoryController(CategoryRepository category, CategoryService categoryService) {
		super();
		this.category = category;
		this.categoryService = categoryService;
	}
	
	@PostMapping("/category")
	public Category createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		Category newCategory = categoryService.save(categoryDto);
		return newCategory;
	}

	@PutMapping("/category/{id}")
	public CategoryDto updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto)
	{
		CategoryDto c3 = categoryService.updateCategory(id, categoryDto);
		
		 return  c3;
	}

	@GetMapping("/category")
	public List<CategoryDto> getAllCategory() {
		return categoryService.findAll();
	}

	@GetMapping("/category/{id}")
	public CategoryDto getCategoryById(@PathVariable Long id) {
		CategoryDto categoryDto = categoryService.findOne(id);
		return categoryDto;

	}

	@DeleteMapping("/category/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.ok().build();
	}
	
}
