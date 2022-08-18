package com.EasyShopping.shoppingcart.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.EasyShopping.shoppingcart.model.Address;
import com.EasyShopping.shoppingcart.model.Cart;
import com.EasyShopping.shoppingcart.model.Customer;
import com.EasyShopping.shoppingcart.model.ItemDetails;


public class CartDto {

	private Long idCart;
	
	private Customer customer;
	
	private BigDecimal subtotal;
	
	
	private List<ItemDetailsDto> itemsDetail = new ArrayList<ItemDetailsDto>();

	

	public  CartDto() {
		
	}

	public Long getIdCart() {
		return idCart;
	}


	public void setIdCart(Long idCart) {
		this.idCart = idCart;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public BigDecimal getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}


	public List<ItemDetailsDto> getItemsDetail() {
		return itemsDetail;
	}


	public void setItemsDetail(List<ItemDetailsDto> itemsDetail) {
		this.itemsDetail = itemsDetail;
	}
	
	
	
	
	
}
