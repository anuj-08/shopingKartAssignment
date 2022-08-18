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

import com.EasyShopping.shoppingcart.DTO.ItemDetailsDto;
import com.EasyShopping.shoppingcart.DTO.OrderDto;
import com.EasyShopping.shoppingcart.model.ItemDetails;
import com.EasyShopping.shoppingcart.model.Order;
import com.EasyShopping.shoppingcart.repository.OrderRepository;
import com.EasyShopping.shoppingcart.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderService orderService;

	public OrderController(OrderRepository orderRepository, OrderService orderService) {
		super();
		this.orderRepository = orderRepository;
		this.orderService = orderService;
	}
	
	@PostMapping("/order")
	public Order createOrder(@Valid @RequestBody OrderDto orderDto) {
		Order newOrder = orderService.save(orderDto);
		return newOrder;
	}

	@PutMapping("/order/{id}")
	public OrderDto updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto)
	{
		OrderDto c3 = orderService.updateOrder(id, orderDto);
		
		 return  c3;
	}

	@GetMapping("/order")
	public List<OrderDto> getAllOrder() {
		return orderService.findAll();
	}

	@GetMapping("/order/{id}")
	public OrderDto getOrderById(@PathVariable Long id) {
		OrderDto orderDto = orderService.findOne(id);
		return orderDto;

	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return ResponseEntity.ok().build();
	}
	
	
}
