package com.EasyShopping.shoppingcart.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EasyShopping.shoppingcart.DTO.CartDto;
import com.EasyShopping.shoppingcart.DTO.ItemDetailsDto;
import com.EasyShopping.shoppingcart.DTO.OrderDto;
import com.EasyShopping.shoppingcart.model.Address;
import com.EasyShopping.shoppingcart.model.Cart;
import com.EasyShopping.shoppingcart.model.ItemDetails;
import com.EasyShopping.shoppingcart.model.Order;
import com.EasyShopping.shoppingcart.repository.AddressRepository;
import com.EasyShopping.shoppingcart.repository.CartRepository;
import com.EasyShopping.shoppingcart.repository.CustomerRepository;
import com.EasyShopping.shoppingcart.repository.ItemDetailsRepository;
import com.EasyShopping.shoppingcart.repository.OrderRepository;
import com.EasyShopping.shoppingcart.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ItemDetailsRepository itemDetailsRepository;

	@Autowired
	private OrderRepository orderRepository;

	public OrderServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository,
			ItemDetailsRepository itemDetailsRepository, OrderRepository orderRepository) {
		super();
		this.customerRepository = customerRepository;
		this.addressRepository = addressRepository;
		this.itemDetailsRepository = itemDetailsRepository;
		this.orderRepository = orderRepository;
	}

	public Order save(OrderDto orderDto) {
		Order order = new Order();
		order.setIdorder(orderDto.getIdorder());
		order.setOrdered(orderDto.getOrdered());
		order.setCustomer(orderDto.getCustomer());
		order.setAddress(orderDto.getAddress());
		order.setStatus(orderDto.getStatus());
		order.setTotal(orderDto.getTotal());
		if (orderDto.getItemsDetail() != null) {
			List<ItemDetails> ite = orderDto.getItemsDetail().stream().map(test -> {
				ItemDetails details = itemDetailsRepository.findById(test.getId()).get();

				return details;
			}).collect(Collectors.toList());
			order.setItemsDetail(ite);
		}
		orderRepository.save(order);
		return order;

	}

	public OrderDto updateOrder(Long id, OrderDto orderDto) {
		Order c2 = orderRepository.findOrderById(id);
		c2.setAddress(orderDto.getAddress());
		c2.setCustomer(orderDto.getCustomer());
		c2.setOrdered(orderDto.getOrdered());
		c2.setStatus(orderDto.getStatus());
		c2.setTotal(orderDto.getTotal());
		c2.setItemsDetail(orderDto.getItemsDetail().stream().map(m1 -> {
			ItemDetails t = new ItemDetails();
			t.setCart(m1.getCart());
			t.setOrder(m1.getOrder());
			t.setPrice(m1.getPrice());
			t.setProduct(m1.getProduct());
			t.setQuantity(m1.getQuantity());

			return t;
		}).collect(Collectors.toList()));

		c2 = orderRepository.save(c2);
		OrderDto cdto = new OrderDto();
		cdto.setAddress(orderDto.getAddress());
		cdto.setCustomer(orderDto.getCustomer());
		cdto.setOrdered(orderDto.getOrdered());
		cdto.setStatus(orderDto.getStatus());
		cdto.setTotal(orderDto.getTotal());
		cdto.setItemsDetail(c2.getItemsDetail());
		return cdto;

	}

	public List<OrderDto> findAll() {
		return orderRepository.findAll().stream().map(s -> {
			OrderDto ot = new OrderDto();
			ot.setAddress(s.getAddress());
			ot.setCustomer(s.getCustomer());
			ot.setOrdered(s.getOrdered());
			ot.setStatus(s.getStatus());
			ot.setTotal(s.getTotal());
			ot.setItemsDetail(s.getItemsDetail());
			return ot;

		}).collect(Collectors.toList());

	}

	public OrderDto findOne(Long orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		OrderDto orderDto = new OrderDto();
		orderDto.setIdorder(order.get().getIdorder());
		orderDto.setAddress(order.get().getAddress());
		orderDto.setCustomer(order.get().getCustomer());
		orderDto.setOrdered(order.get().getOrdered());
		orderDto.setStatus(order.get().getStatus());
		orderDto.setTotal(order.get().getTotal());
		orderDto.setItemsDetail(order.get().getItemsDetail());
		return orderDto;
	}

	public void deleteOrder(Long id) {

		orderRepository.deleteById(id);
	}

}
