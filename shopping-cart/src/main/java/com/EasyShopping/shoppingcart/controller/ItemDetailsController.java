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

import com.EasyShopping.shoppingcart.DTO.CustomerDto;
import com.EasyShopping.shoppingcart.DTO.ItemDetailsDto;
import com.EasyShopping.shoppingcart.model.Customer;
import com.EasyShopping.shoppingcart.model.ItemDetails;
import com.EasyShopping.shoppingcart.repository.ItemDetailsRepository;
import com.EasyShopping.shoppingcart.service.ItemDetailsService;

@RestController
@RequestMapping("/api")
public class ItemDetailsController {

	@Autowired
	private ItemDetailsRepository itemDetailsRepository;
	
	@Autowired
	private ItemDetailsService itemDetailsService;

	public ItemDetailsController(ItemDetailsRepository itemDetailsRepository, ItemDetailsService itemDetailsService) {
		super();
		this.itemDetailsRepository = itemDetailsRepository;
		this.itemDetailsService = itemDetailsService;
	}
	
	@PostMapping("/itemDeatils")
	public ItemDetails createCustomer(@Valid @RequestBody ItemDetailsDto itemDetailsDto) {
		ItemDetails newItemDetails = itemDetailsService.save(itemDetailsDto);
		return newItemDetails;
	}

	@PutMapping("/itemDetails/{id}")
	public ItemDetailsDto updateItemDetails(@PathVariable Long id, @RequestBody ItemDetailsDto itemDetailsDto)
	{
		ItemDetailsDto c3 = itemDetailsService.updateItemDetails(id, itemDetailsDto);
		
		 return  c3;
	}

	@GetMapping("/itemDetails")
	public List<ItemDetailsDto> getAllCustomer() {
		return itemDetailsService.findAll();
	}

	@GetMapping("/itemDetails/{id}")
	public ItemDetailsDto getItemDetailsById(@PathVariable Long id) {
		ItemDetailsDto itemCustomerDto = itemDetailsService.findOne(id);
		return itemCustomerDto;

	}

	@DeleteMapping("/itemDetails/{id}")
	public ResponseEntity<Void> deleteItemDetails(@PathVariable Long id) {
		itemDetailsService.deleteItemDetails(id);
		return ResponseEntity.ok().build();
	}
	
}
