package com.EasyShopping.shoppingcart.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.EasyShopping.shoppingcart.DTO.CartDto;
import com.EasyShopping.shoppingcart.DTO.CategoryDto;
import com.EasyShopping.shoppingcart.DTO.ItemDetailsDto;
import com.EasyShopping.shoppingcart.model.Cart;
import com.EasyShopping.shoppingcart.model.Category;
import com.EasyShopping.shoppingcart.model.ItemDetails;
import com.EasyShopping.shoppingcart.model.Product;
import com.EasyShopping.shoppingcart.repository.CategoryRepository;
import com.EasyShopping.shoppingcart.repository.CustomerRepository;
import com.EasyShopping.shoppingcart.repository.ProductRepository;
import com.EasyShopping.shoppingcart.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	private ProductRepository productRepository;

	private CategoryRepository categoryRepository;

	private CustomerRepository customerRepository;

	public CategoryServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository,
			CustomerRepository customerRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}

	public Category save(CategoryDto categoryDto) {
		Category category = new Category();
		category.setIdCategory(category.getIdCategory());
		category.setDescription(category.getDescription());
		if (categoryDto.getProducts() != null) {
			List<Product> ite = categoryDto.getProducts().stream().map(test -> {
				Product pr = productRepository.findById(test.getIdProduct()).get();

				return pr;
			})

					.collect(Collectors.toList());
			category.setProducts(ite);
		}
		categoryRepository.save(category);
		return category;

	}

	public CategoryDto updateCategory(Long id, CategoryDto categoryDto)
	    {
		 Category c1 = categoryRepository.findCategoryById(id);
		 c1.setDescription(categoryDto.getDescription());
		 c1.setProducts(categoryDto.getProducts().stream().map(m1 -> {
			Product t = new Product();
			 t.setCategory(m1.getCategory());
			 t.setDescription(m1.getDescription());
			 t.setPrice(m1.getPrice());
			 t.setItemsDetail(m1.getItemsDetail());
			 
			 return t;
		 }).collect(Collectors.toList()));

	   		 c1 = categoryRepository.save(c1);
		 CategoryDto cdto = new CategoryDto();
		 cdto.setDescription(c1.getDescription());
		 cdto.setProducts(c1.getProducts());
		 
		 return cdto;
		 
	    }

	public List<CategoryDto> findAll() {
		return categoryRepository.findAll().stream().map(s -> {
			CategoryDto categoryDto = new CategoryDto();
			categoryDto.setDescription(s.getDescription());
			categoryDto.setProducts(s.getProducts());
			return categoryDto;

		}).collect(Collectors.toList());

	}

	public CategoryDto findOne(Long categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setIdCategory(category.get().getIdCategory());
		categoryDto.setDescription(category.get().getDescription());
		categoryDto.setProducts(category.get().getProducts());
		return categoryDto;
	}

	public void deleteCategory(Long id) {

		categoryRepository.deleteById(id);
	}

}
