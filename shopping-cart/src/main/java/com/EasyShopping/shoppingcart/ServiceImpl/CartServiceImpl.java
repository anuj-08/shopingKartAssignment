package com.EasyShopping.shoppingcart.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EasyShopping.shoppingcart.DTO.AddressDto;
import com.EasyShopping.shoppingcart.DTO.CartDto;
import com.EasyShopping.shoppingcart.DTO.CustomerDto;
import com.EasyShopping.shoppingcart.DTO.ItemDetailsDto;
import com.EasyShopping.shoppingcart.model.Address;
import com.EasyShopping.shoppingcart.model.Cart;
import com.EasyShopping.shoppingcart.model.Customer;
import com.EasyShopping.shoppingcart.model.ItemDetails;
import com.EasyShopping.shoppingcart.repository.CartRepository;
import com.EasyShopping.shoppingcart.repository.CustomerRepository;
import com.EasyShopping.shoppingcart.repository.ItemDetailsRepository;
import com.EasyShopping.shoppingcart.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ItemDetailsRepository itemDetailsRepository;

	public CartServiceImpl(CartRepository cartRepository, CustomerRepository customerRepository,
			ItemDetailsRepository itemDetailsRepository) {
		super();
		this.cartRepository = cartRepository;
		this.customerRepository = customerRepository;
		this.itemDetailsRepository = itemDetailsRepository;
	}

	 public Cart save(CartDto cartDto)
	 {
		 Cart cart = new Cart();
		 cart.setIdCart(cartDto.getIdCart());
		 cart.setCustomer(cartDto.getCustomer());
		 cart.setSubtotal(cartDto.getSubtotal());
		 if (cartDto.getItemsDetail() != null) {
		 List<ItemDetails> ite = cartDto.getItemsDetail().stream().map(test  -> {
			 ItemDetails details = itemDetailsRepository.findById(test.getId()).get();
			 
			 return details;
		 })
	                
	                .collect(Collectors.toList());
	            cart.setItemsDetail(ite);
		 }
		  cartRepository.save(cart);
		 return cart;

	 }
	 
	 public CartDto updateCart(Long id, CartDto cartDto)
	    {
		 Cart c1 = cartRepository.findCartById(id);
		 c1.setCustomer(cartDto.getCustomer());
		 c1.setSubtotal(cartDto.getSubtotal());
		 c1.setItemsDetail(cartDto.getItemsDetail().stream().map(m1 -> {
			 ItemDetails t = new ItemDetails();
			 t.setCart(m1.getCart());
			 t.setOrder(m1.getOrder());
			 t.setPrice(m1.getPrice());
			 t.setProduct(m1.getProduct());
			 t.setQuantity(m1.getQuantity());
			 
			 return t;
		 }).collect(Collectors.toList()));

	   		 c1 = cartRepository.save(c1);
		 CartDto cdto = new CartDto();
		 cdto.setCustomer(c1.getCustomer());
		 cdto.setSubtotal(c1.getSubtotal());
		 cdto.setItemsDetail(c1.getItemsDetail().stream().map(m2-> {
			 ItemDetailsDto t2 = new ItemDetailsDto();
			 t2.setCart(m2.getCart());
			 t2.setOrder(m2.getOrder());
			 t2.setPrice(m2.getPrice());
			 t2.setProduct(m2.getProduct());
			 t2.setQuantity(m2.getQuantity());
			 return t2;
			 
		 }).collect(Collectors.toList()));
		 
		 return cdto;
		 
	    }
	 
	 
	 public List<CartDto> findAll()
	 {
		  return cartRepository.findAll().stream().map(s -> {
			  CartDto cartDto =  new CartDto();
			  cartDto.setCustomer(s.getCustomer());
			  cartDto.setSubtotal(s.getSubtotal());
			  cartDto.setItemsDetail(s.getItemsDetail().stream().map(m2->{
					ItemDetailsDto it = new ItemDetailsDto();
					it.setCart(m2.getCart());
					it.setOrder(m2.getOrder());
					it.setPrice(m2.getPrice());
					it.setProduct(m2.getProduct());
					it.setQuantity(m2.getQuantity());
					 return it;
			  }).collect(Collectors.toList()));		  
			  return cartDto;
			
			  }).collect(Collectors.toList());
			  
	
	 }
	 
	 public CartDto findOne(Long cartId) {
		 Optional<Cart> cart =  cartRepository.findById(cartId);
		 CartDto cartDto = new CartDto();
		 cartDto.setIdCart(cart.get().getIdCart());
		 cartDto.setCustomer(cart.get().getCustomer());
		 cartDto.setSubtotal(cart.get().getSubtotal());
		 cartDto.setItemsDetail(cart.get().getItemsDetail().stream().map(s3->{
			 ItemDetailsDto it = new ItemDetailsDto();
				it.setCart(s3.getCart());
				it.setOrder(s3.getOrder());
				it.setPrice(s3.getPrice());
				it.setProduct(s3.getProduct());
				it.setQuantity(s3.getQuantity());
				 return it;
			  }).collect(Collectors.toList()));
	        return  cartDto;
	    }
	
	 public void deleteCart(Long id) {
	        
	        cartRepository.deleteById(id);
	    }
	 
	
	
}
