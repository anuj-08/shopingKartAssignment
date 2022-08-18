package com.EasyShopping.shoppingcart.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.EasyShopping.shoppingcart.model.Category;
import com.EasyShopping.shoppingcart.model.ItemDetails;
import com.EasyShopping.shoppingcart.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductDto {

	private Long idProduct;

	private Category category;

	private String description;

	private BigDecimal price;

	private List<ItemDetails> itemsDetail = new ArrayList<ItemDetails>();

	public ProductDto() {

	}

	public ProductDto(Product product) {
		super();
		this.idProduct = product.getIdProduct();
		this.category = product.getCategory();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.itemsDetail = product.getItemsDetail();
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<ItemDetails> getItemsDetail() {
		return itemsDetail;
	}

	public void setItemsDetail(List<ItemDetails> itemsDetail) {
		this.itemsDetail = itemsDetail;
	}

}
