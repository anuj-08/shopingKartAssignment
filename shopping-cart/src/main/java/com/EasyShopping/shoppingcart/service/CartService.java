package com.EasyShopping.shoppingcart.service;

import java.util.List;

import com.EasyShopping.shoppingcart.DTO.AddressDto;
import com.EasyShopping.shoppingcart.DTO.CartDto;
import com.EasyShopping.shoppingcart.model.Address;
import com.EasyShopping.shoppingcart.model.Cart;

public interface CartService {


	   Cart save(CartDto cartDto);
		
		CartDto updateCart(Long id, CartDto cartDto);
		
		CartDto findOne(Long id);
		
		List<CartDto> findAll();
		
		 void deleteCart(Long id);
}
