package com.EasyShopping.shoppingcart.service;

import java.util.List;

import com.EasyShopping.shoppingcart.DTO.AddressDto;
import com.EasyShopping.shoppingcart.model.Address;

public interface AddressService {

   Address save(AddressDto addressDto);
	
	AddressDto updateAddress(Long id, AddressDto addressDto);
	
	AddressDto findOne(Long id);
	
	List<AddressDto> findAll();
	
	 void deleteAddress(Long id);
	
}
