package com.EasyShopping.shoppingcart.model;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders", catalog = "shopping_cart_db")
public class Order implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order", unique = true, nullable = false)
	private Long idorder;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer", nullable = false)
	private Customer customer;
	
	 @OneToOne
     @JoinColumn(name="address_id")
	private Address address;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ordered", nullable = false, length = 19)
	private Date ordered;
	
	@Column(name = "status", nullable = false, length = 20)
	private String status;
	
	@Column(name = "total", nullable = false, precision = 10)
	private BigDecimal total;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	private List<ItemDetails> itemsDetail = new ArrayList<ItemDetails>();

	public Order() {
	}

	public Order(Long idorder, Customer customer, Address address, Date ordered, String status, BigDecimal total,
			List<ItemDetails> itemsDetail) {
		super();
		this.idorder = idorder;
		this.customer = customer;
		this.address = address;
		this.ordered = ordered;
		this.status = status;
		this.total = total;
		this.itemsDetail = itemsDetail;
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

	public Date getOrdered() {
		return ordered;
	}

	public void setOrdered(Date ordered) {
		this.ordered = ordered;
	}

	public String getStatus() {
		return status;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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