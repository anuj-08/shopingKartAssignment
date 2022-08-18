package com.EasyShopping.shoppingcart.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EasyShopping.shoppingcart.DTO.CustomerDto;
import com.EasyShopping.shoppingcart.model.Customer;
import com.EasyShopping.shoppingcart.repository.AddressRepository;
import com.EasyShopping.shoppingcart.repository.CustomerRepository;
import com.EasyShopping.shoppingcart.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository) {
		super();
		this.customerRepository = customerRepository;
		this.addressRepository = addressRepository;
	}
	
	 /**
     * Save a customer. 
     *
     **/
	 public Customer save(CustomerDto customerDto)
	 {
		 Customer customer = new Customer();
		 customer.setFirstName(customerDto.getFirstName());
		 customer.setLastName(customerDto.getLastName());
		 customer.setUserName(customerDto.getUserName());
		 customer.setEmail(customerDto.getEmail());
		 customer.setActive(customerDto.getActive());
		  customerRepository.save(customer);
		 return customer;
	 }
	 
	 public CustomerDto updateCustomer(Long id, CustomerDto customerDto)
	    {
		 Customer customer1 = customerRepository.findCustomerById(id);
		 customer1.setFirstName(customerDto.getFirstName());
		 customer1.setLastName(customerDto.getLastName());
		 customer1.setUserName(customerDto.getUserName());
		 customer1.setEmail(customerDto.getEmail());
		 customer1.setActive(customerDto.getActive());
		 customer1 = customerRepository.save(customer1);
		 CustomerDto cdto = new CustomerDto();
		 cdto.setFirstName(customer1.getFirstName());
		 cdto.setLastName(customer1.getLastName());
		 cdto.setUserName(customer1.getUserName());
		 cdto.setEmail(customer1.getEmail());
		 cdto.setActive(customer1.getActive());
		 return cdto;
		 
	    }
	 
	        
	 
	 public List<CustomerDto> findAll()
	 {
		  return customerRepository.findAll().stream().map(s -> {
			  CustomerDto customerDto =  new CustomerDto();
			  customerDto.setFirstName(s.getFirstName());
			  customerDto.setLastName(s.getLastName());
			  customerDto.setUserName(s.getUserName());
			  customerDto.setEmail(s.getEmail());
			  customerDto.setActive(s.getActive());
			  return customerDto;
		  }).collect(Collectors.toList());
	 }
	 
	 public CustomerDto findOne(Long customerId) {
		 Optional<Customer> customer =  customerRepository.findById(customerId);
		 CustomerDto customerDto = new CustomerDto();
		 customerDto.setId(customer.get().getId());
		 customerDto.setFirstName(customer.get().getFirstName());
		 customerDto.setLastName(customer.get().getLastName());
		 customerDto.setUserName(customer.get().getUserName());
		 customerDto.setEmail(customer.get().getEmail());
		 customerDto.setActive(customer.get().getActive());
	        return  customerDto;
	    }
	 
	 
	 
	 public void deleteCustomer(Long id) {
	        
	        customerRepository.deleteById(id);
	    }
}
