package com.EasyShopping.shoppingcart.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.EasyShopping.shoppingcart.model.Address;
import com.EasyShopping.shoppingcart.model.Customer;
import com.EasyShopping.shoppingcart.model.ItemDetails;
import com.EasyShopping.shoppingcart.model.Order;

public class OrderDto {

	private Long idorder;

	private Customer customer;

	private Address address;

	private Date ordered;

	private String status;

	private BigDecimal total;

	private List<ItemDetails> itemsDetail = new ArrayList<ItemDetails>();

	public OrderDto() {

	}

	public OrderDto(Order order) {
		super();
		this.idorder = order.getIdorder();
		this.customer = order.getCustomer();
		this.address = order.getAddress();
		this.ordered = order.getOrdered();
		this.status = order.getStatus();
		this.total = order.getTotal();
		this.itemsDetail = order.getItemsDetail();
	}

	public Long getIdorder() {
		return idorder;
	}

	public void setIdorder(Long idorder) {
		this.idorder = idorder;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getOrdered() {
		return ordered;
	}

	public void setOrdered(Date ordered) {
		this.ordered = ordered;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ItemDetails> getItemsDetail() {
		return itemsDetail;
	}

	public void setItemsDetail(List<ItemDetails> itemsDetail) {
		this.itemsDetail = itemsDetail;
	}

}