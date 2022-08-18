package com.EasyShopping.shoppingcart.DTO;

import java.util.ArrayList;
import java.util.List;

import com.EasyShopping.shoppingcart.model.Category;
import com.EasyShopping.shoppingcart.model.Product;

public class CategoryDto {

	private Long idCategory;
	
	private String description;
	
	private List<Product> products = new ArrayList<Product>();
	
	public CategoryDto() {
		
	}

	public CategoryDto(Category category) {
		super();
		this.idCategory = category.getIdCategory();
		this.description = category.getDescription();
		this.products = category.getProducts();
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
