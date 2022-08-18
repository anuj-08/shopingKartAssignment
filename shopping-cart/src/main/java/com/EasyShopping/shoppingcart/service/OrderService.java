package com.EasyShopping.shoppingcart.service;

import java.util.List;

import com.EasyShopping.shoppingcart.DTO.CartDto;
import com.EasyShopping.shoppingcart.DTO.OrderDto;
import com.EasyShopping.shoppingcart.model.Cart;
import com.EasyShopping.shoppingcart.model.Order;

public interface OrderService {

	Order save(OrderDto orderDto);

	OrderDto updateOrder(Long id, OrderDto orderDto);

	OrderDto findOne(Long id);

	List<OrderDto> findAll();

	void deleteOrder(Long id);

}
