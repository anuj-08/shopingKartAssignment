package com.EasyShopping.shoppingcart.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EasyShopping.shoppingcart.DTO.CartDto;
import com.EasyShopping.shoppingcart.DTO.ItemDetailsDto;
import com.EasyShopping.shoppingcart.DTO.ProductDto;
import com.EasyShopping.shoppingcart.model.Cart;
import com.EasyShopping.shoppingcart.model.ItemDetails;
import com.EasyShopping.shoppingcart.model.Product;
import com.EasyShopping.shoppingcart.repository.CartRepository;
import com.EasyShopping.shoppingcart.repository.CustomerRepository;
import com.EasyShopping.shoppingcart.repository.ItemDetailsRepository;
import com.EasyShopping.shoppingcart.repository.ProductRepository;
import com.EasyShopping.shoppingcart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ItemDetailsRepository itemDetailsRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public ProductServiceImpl(ProductRepository productRepository, CartRepository cartRepository,
			ItemDetailsRepository itemDetailsRepository, CustomerRepository customerRepository) {
		super();
		this.productRepository = productRepository;
		this.cartRepository = cartRepository;
		this.itemDetailsRepository = itemDetailsRepository;
		this.customerRepository = customerRepository;
	}

	public Product save(ProductDto productDto) {
		Product product = new Product();
		product.setIdProduct(productDto.getIdProduct());
		product.setCategory(productDto.getCategory());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		if (productDto.getItemsDetail() != null) {
			List<ItemDetails> ite = productDto.getItemsDetail().stream().map(test -> {
				ItemDetails details = itemDetailsRepository.findById(test.getId()).get();

				return details;
			})

					.collect(Collectors.toList());
			product.setItemsDetail(ite);
		}
		productRepository.save(product);
		return product;

	}

	public ProductDto updateProduct(Long id, ProductDto productDto) {
		Product c1 = productRepository.findProductById(id);
		c1.setIdProduct(productDto.getIdProduct());
		c1.setCategory(productDto.getCategory());
		c1.setDescription(productDto.getDescription());
		c1.setPrice(productDto.getPrice());
		c1.setItemsDetail(productDto.getItemsDetail().stream().map(m1 -> {
			ItemDetails t = new ItemDetails();
			t.setCart(m1.getCart());
			t.setOrder(m1.getOrder());
			t.setPrice(m1.getPrice());
			t.setProduct(m1.getProduct());
			t.setQuantity(m1.getQuantity());

			return t;
		}).collect(Collectors.toList()));

		c1 = productRepository.save(c1);
		ProductDto cdto = new ProductDto();
		cdto.setIdProduct(c1.getIdProduct());
		cdto.setCategory(c1.getCategory());
		cdto.setDescription(c1.getDescription());
		cdto.setPrice(c1.getPrice());
		cdto.setItemsDetail(c1.getItemsDetail());
		return cdto;

	}

	public List<ProductDto> findAll() {
		return productRepository.findAll().stream().map(s -> {
			ProductDto productDto = new ProductDto();
			productDto.setCategory(s.getCategory());
			productDto.setDescription(s.getDescription());
			productDto.setPrice(s.getPrice());
			productDto.setItemsDetail(s.getItemsDetail());
			return productDto;

		}).collect(Collectors.toList());

	}

	public ProductDto findOne(Long productId) {
		Optional<Product> product =  productRepository.findById(productId);
		 ProductDto productDto = new  ProductDto();
		 productDto.setIdProduct(product.get().getIdProduct());
		 productDto.setCategory(product.get().getCategory());
		 productDto.setDescription(product.get().getDescription());
		 productDto.setPrice(product.get().getPrice());
		 productDto.setItemsDetail(product.get().getItemsDetail());
	        return  productDto;
	    }

	public void deleteProduct(Long id) {

		productRepository.deleteById(id);
	}

}
