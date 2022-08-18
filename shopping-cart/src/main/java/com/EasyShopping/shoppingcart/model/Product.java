package com.EasyShopping.shoppingcart.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products", catalog = "shopping_cart_db")
public class Product implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product", unique = true, nullable = false)
	private Long idProduct;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private Category category;
	
	@Column(name = "description", nullable = false, length = 100)
	private String description;
	
	@Column(name = "price", nullable = false, precision = 10)
	private BigDecimal price;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<ItemDetails> itemsDetail = new ArrayList<ItemDetails>();

	public Product() {
	}

	public Product(String description, BigDecimal price) {
		this.description = description;
		this.price = price;
	}

	public Product(Category category, String description, BigDecimal price, List<ItemDetails> itemsDetail) {
		this.category = category;
		this.description = description;
		this.price = price;
		this.itemsDetail = itemsDetail;
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
