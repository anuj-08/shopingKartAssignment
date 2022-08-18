package com.EasyShopping.shoppingcart.DTO;

import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.EasyShopping.shoppingcart.enumeration.AddressType;
import com.EasyShopping.shoppingcart.model.Address;
import com.EasyShopping.shoppingcart.model.Customer;

public class AddressDto {

	private Long id;

	private String address1;

	private String address2;

	private String address3;

	private Integer pinCode;

	private String city;

	private AddressType addressType;
	
	private String state;

	private Customer customer;

	public AddressDto() {

	}

	public AddressDto(Address address) {
		super();
		this.id = address.getId();
		this.address1 = address.getAddress1();
		this.address2 = address.getAddress2();
		this.address3 = address.getAddress3();
		this.addressType = address.getAddressType();
		this.pinCode = address.getPinCode();
		this.city = address.getCity();
		this.state = address.getState();
		this.customer = address.getCustomer();

	}

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

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "AddressDto [id=" + id + ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3
				+ ", pinCode=" + pinCode + ", city=" + city + ", state=" + state + ", addressType=" + addressType + ","
						+ "customer=" + customer + "]";
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
		AddressDto other = (AddressDto) obj;
		return Objects.equals(city, other.city) && Objects.equals(customer, other.customer)
				&& Objects.equals(address1, other.address1) && Objects.equals(id, other.id)
				&& Objects.equals(address2, other.address2) && Objects.equals(pinCode, other.pinCode)
				&& Objects.equals(state, other.state) && Objects.equals(address3, other.address3)
				&& Objects.equals(addressType, other.addressType);
	}

}
