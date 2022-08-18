package com.EasyShopping.shoppingcart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EasyShopping.shoppingcart.DTO.CartDto;
import com.EasyShopping.shoppingcart.DTO.CustomerDto;
import com.EasyShopping.shoppingcart.model.Cart;
import com.EasyShopping.shoppingcart.model.Customer;
import com.EasyShopping.shoppingcart.repository.CartRepository;
import com.EasyShopping.shoppingcart.service.CartService;

@RestController
@RequestMapping("/api")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartRepository cartRepository;

	public CartController(CartService cartService, CartRepository cartRepository) {
		super();
		this.cartService = cartService;
		this.cartRepository = cartRepository;
	}
	
	@PostMapping("/cart")
	public Cart createCart(@Valid @RequestBody CartDto cartDto) {
		Cart newCart = cartService.save(cartDto);
		return newCart;
	}

	@PutMapping("/cart/{id}")
	public CartDto updateCart(@PathVariable Long id, @RequestBody CartDto cartDto)
	{
		CartDto c3 = cartService.updateCart(id, cartDto);
		
		 return  c3;
	}

	@GetMapping("/cart")
	public List<CartDto> getAllCart() {
		return cartService.findAll();
	}

	@GetMapping("/cart/{id}")
	public CartDto getCartById(@PathVariable Long id) {
		CartDto cartDto = cartService.findOne(id);
		return  cartDto;

	}

	@DeleteMapping("/ cart/{id}")
	public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
		cartService.deleteCart(id);
		return ResponseEntity.ok().build();
	}
	
}
