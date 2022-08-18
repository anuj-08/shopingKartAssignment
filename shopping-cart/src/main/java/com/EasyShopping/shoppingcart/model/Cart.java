package com.EasyShopping.shoppingcart.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carts", catalog = "shopping_cart_db")
public class Cart implements java.io.Serializable {

	@Id
	@Column(name = "id_carts", unique = true, nullable = false)
	private Long idCart;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer", nullable = false)
	private Customer customer;
	
	@Column(name = "subtotal", nullable = false, precision = 10)
	private BigDecimal subtotal;
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cart", cascade = CascadeType.ALL)
	private List<ItemDetails> itemsDetail = new ArrayList<ItemDetails>();

	public Cart() {
	}


	public Cart(Long idCart, Customer customer, BigDecimal subtotal, List<ItemDetails> itemsDetail) {
		this.idCart = idCart;
		this.customer = customer;
		this.subtotal = subtotal;
		this.itemsDetail = itemsDetail;
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

	public List<ItemDetails> getItemsDetail() {
		return itemsDetail;
	}

	public void setItemsDetail(List<ItemDetails> itemsDetail) {
		this.itemsDetail = itemsDetail;
	}
	
	
}