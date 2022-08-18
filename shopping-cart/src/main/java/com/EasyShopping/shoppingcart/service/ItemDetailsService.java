package com.EasyShopping.shoppingcart.service;

import java.util.List;

import com.EasyShopping.shoppingcart.DTO.ItemDetailsDto;
import com.EasyShopping.shoppingcart.model.ItemDetails;

public interface ItemDetailsService {

	ItemDetails save(ItemDetailsDto itemDetailsDto);

	ItemDetailsDto updateItemDetails(Long id, ItemDetailsDto itemDetailsDto);

	ItemDetailsDto findOne(Long id);

	List<ItemDetailsDto> findAll();

	void deleteItemDetails(Long id);
	
}
