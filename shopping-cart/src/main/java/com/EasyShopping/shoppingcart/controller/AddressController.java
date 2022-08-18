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

import com.EasyShopping.shoppingcart.DTO.AddressDto;
import com.EasyShopping.shoppingcart.DTO.CustomerDto;
import com.EasyShopping.shoppingcart.model.Address;
import com.EasyShopping.shoppingcart.model.Customer;
import com.EasyShopping.shoppingcart.repository.AddressRepository;
import com.EasyShopping.shoppingcart.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressService addressService;

	public AddressController(AddressRepository addressRepository, AddressService addressService) {
		super();
		this.addressRepository = addressRepository;
		this.addressService = addressService;
	}
	
	@PostMapping("/address")
	public Address createAddress(@Valid @RequestBody AddressDto addressDto) {
		Address newAddress = addressService.save(addressDto);
		return newAddress;
	}

	@PutMapping("/address/{id}")
	public AddressDto updateAddress(@PathVariable Long id, @RequestBody AddressDto addressDto)
	{
		AddressDto address3 = addressService.updateAddress(id, addressDto);
		
		 return  address3;
	}

	@GetMapping("/address")
	public List<AddressDto> getAllAddress() {
		return addressService.findAll();
	}

	@GetMapping("/address/{id}")
	public AddressDto getAddressById(@PathVariable Long id) {
		AddressDto addressDto = addressService.findOne(id);
		return addressDto;

	}

	@DeleteMapping("/address/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		addressService.deleteAddress(id);
		return ResponseEntity.ok().build();
	}
}
