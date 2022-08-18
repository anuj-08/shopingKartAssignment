package com.EasyShopping.shoppingcart.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.EasyShopping.shoppingcart.enumeration.AddressType;


@Entity
@Table(name = "address")
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "address_1")
	private String address1;
	
	@Column(name = "address_2")
	private String address2;
	
	@Column(name = "address_3")
	private String address3;

	@Column(name = "pin_code")
	private Integer pinCode;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "address_type")
	private AddressType addressType;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, customer, address1, id, address2, pinCode, state, address3, addressType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(customer, other.customer)
				&& Objects.equals(address1, other.address1) && Objects.equals(id, other.id)
				&& Objects.equals(address2, other.address2) && Objects.equals(pinCode, other.pinCode)
				&& Objects.equals(state, other.state) && Objects.equals(address3, other.address3)
				&& Objects.equals(addressType, other.addressType);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address1 =" + address1 + ", address2=" + address2 + ", address3 ="
				+ address3 + ", pinCode=" + pinCode + ", city=" + city + ", state=" + state + ", addressType=" + addressType + 
				", customer=" + customer + "]";
	}


	
	

}
