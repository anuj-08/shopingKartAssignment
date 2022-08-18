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

import com.EasyShopping.shoppingcart.DTO.OrderDto;
import com.EasyShopping.shoppingcart.DTO.ProductDto;
import com.EasyShopping.shoppingcart.model.Order;
import com.EasyShopping.shoppingcart.model.Product;
import com.EasyShopping.shoppingcart.repository.ProductRepository;
import com.EasyShopping.shoppingcart.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;

	public ProductController(ProductRepository productRepository, ProductService productService) {
		super();
		this.productRepository = productRepository;
		this.productService = productService;
	}
	
	@PostMapping("/product")
	public Product createProduct(@Valid @RequestBody ProductDto productDto) {
		Product newProduct = productService.save(productDto);
		return newProduct;
	}

	@PutMapping("/product/{id}")
	public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto)
	{
		ProductDto c3 = productService.updateProduct(id, productDto);
		
		 return  c3;
	}

	@GetMapping("/product")
	public List<ProductDto> getAllProduct() {
		return productService.findAll();
	}

	@GetMapping("/product/{id}")
	public ProductDto getProductById(@PathVariable Long id) {
		ProductDto productDto = productService.findOne(id);
		return productDto;

	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok().build();
	}

}
