package com.EasyShopping.shoppingcart.service;

import java.util.List;

import com.EasyShopping.shoppingcart.DTO.OrderDto;
import com.EasyShopping.shoppingcart.DTO.ProductDto;
import com.EasyShopping.shoppingcart.model.Order;
import com.EasyShopping.shoppingcart.model.Product;

public interface ProductService {

	Product save(ProductDto productDto);

	ProductDto updateProduct(Long id, ProductDto productDto);

	ProductDto findOne(Long id);

	List<ProductDto> findAll();

	void deleteProduct(Long id);
}
