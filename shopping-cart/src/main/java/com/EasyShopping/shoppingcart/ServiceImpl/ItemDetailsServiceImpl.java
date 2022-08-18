package com.EasyShopping.shoppingcart.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.EasyShopping.shoppingcart.DTO.CustomerDto;
import com.EasyShopping.shoppingcart.DTO.ItemDetailsDto;
import com.EasyShopping.shoppingcart.model.Customer;
import com.EasyShopping.shoppingcart.model.ItemDetails;
import com.EasyShopping.shoppingcart.repository.CartRepository;
import com.EasyShopping.shoppingcart.repository.ItemDetailsRepository;
import com.EasyShopping.shoppingcart.repository.OrderRepository;
import com.EasyShopping.shoppingcart.repository.ProductRepository;
import com.EasyShopping.shoppingcart.service.ItemDetailsService;

@Service
public class ItemDetailsServiceImpl implements ItemDetailsService {

	private ItemDetailsRepository itemDetailsRepository;

	private ProductRepository productRepository;

	private OrderRepository orderRepository;

	private CartRepository cartRepository;

	public ItemDetailsServiceImpl(ItemDetailsRepository itemDetailsRepository, ProductRepository productRepository,
			OrderRepository orderRepository, CartRepository cartRepository) {
		super();
		this.itemDetailsRepository = itemDetailsRepository;
		this.productRepository = productRepository;
		this.orderRepository = orderRepository;
		this.cartRepository = cartRepository;
	}

	public ItemDetails save(ItemDetailsDto itemDetailsDto) {
		ItemDetails it = new ItemDetails();
		it.setId(itemDetailsDto.getId());
		it.setCart(itemDetailsDto.getCart());
		it.setOrder(itemDetailsDto.getOrder());
		it.setPrice(itemDetailsDto.getPrice());
		it.setProduct(itemDetailsDto.getProduct());
		it.setQuantity(itemDetailsDto.getQuantity());
		itemDetailsRepository.save(it);
		return it;
	}

	public ItemDetailsDto updateItemDetails(Long id, ItemDetailsDto itemDetailsDto) {
		ItemDetails c1 = itemDetailsRepository.findCustomerById(id);
		c1.setCart(itemDetailsDto.getCart());
		c1.setOrder(itemDetailsDto.getOrder());
		c1.setPrice(itemDetailsDto.getPrice());
		c1.setProduct(itemDetailsDto.getProduct());
		c1.setQuantity(itemDetailsDto.getQuantity());

		c1 = itemDetailsRepository.save(c1);
		ItemDetailsDto cdto = new ItemDetailsDto();
		cdto.setCart(c1.getCart());
		cdto.setOrder(c1.getOrder());
		cdto.setPrice(c1.getPrice());
		cdto.setProduct(c1.getProduct());
		cdto.setQuantity(c1.getQuantity());
		return cdto;

	}

	public List<ItemDetailsDto> findAll() {
		return itemDetailsRepository.findAll().stream().map(s -> {
			ItemDetailsDto i2 = new ItemDetailsDto();
			i2.setCart(s.getCart());
			i2.setOrder(s.getOrder());
			i2.setPrice(s.getPrice());
			i2.setProduct(s.getProduct());
			i2.setQuantity(s.getQuantity());
			return i2;
		}).collect(Collectors.toList());
	}

	public ItemDetailsDto findOne(Long itemDetailsId) {
		Optional<ItemDetails> it = itemDetailsRepository.findById(itemDetailsId);
		ItemDetailsDto idt = new ItemDetailsDto();
		idt.setId(it.get().getId());
		idt.setCart(it.get().getCart());
		idt.setOrder(it.get().getOrder());
		idt.setPrice(it.get().getPrice());
		idt.setProduct(it.get().getProduct());
		idt.setQuantity(it.get().getQuantity());
		return idt;
	}

	public void deleteItemDetails(Long id) {

		itemDetailsRepository.deleteById(id);
	}
}
