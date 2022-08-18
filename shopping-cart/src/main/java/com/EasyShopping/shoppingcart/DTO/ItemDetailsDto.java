package com.EasyShopping.shoppingcart.DTO;

import java.math.BigDecimal;

import com.EasyShopping.shoppingcart.model.Address;
import com.EasyShopping.shoppingcart.model.Cart;
import com.EasyShopping.shoppingcart.model.ItemDetails;
import com.EasyShopping.shoppingcart.model.Order;
import com.EasyShopping.shoppingcart.model.Product;

public class ItemDetailsDto {

	private Long id;
	
	private Cart cart;
	
	private Product product;
	
	private Order order;
	
	private Integer quantity;
	
	private BigDecimal price;
	
	public ItemDetailsDto() {

	}

	public ItemDetailsDto(ItemDetails itemDetails) {
		super();
		this.id = itemDetails.getId();
		this.cart = itemDetails.getCart();
		this.order = itemDetails.getOrder();
		this.price = itemDetails.getPrice();
		this.product = itemDetails.getProduct();
		this.quantity = itemDetails.getQuantity();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
}
