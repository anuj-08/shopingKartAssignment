package com.EasyShopping.shoppingcart.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EasyShopping.shoppingcart.DTO.AddressDto;
import com.EasyShopping.shoppingcart.DTO.CustomerDto;
import com.EasyShopping.shoppingcart.model.Address;
import com.EasyShopping.shoppingcart.model.Customer;
import com.EasyShopping.shoppingcart.repository.AddressRepository;
import com.EasyShopping.shoppingcart.repository.CustomerRepository;
import com.EasyShopping.shoppingcart.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	public AddressServiceImpl(AddressRepository addressRepository, CustomerRepository customerRepository) {
		super();
		this.addressRepository = addressRepository;
		this.customerRepository = customerRepository;
	}
	
	 public Address save(AddressDto addressDto)
	 {
		 Address address = new Address();
		 address.setAddress1(addressDto.getAddress1());
		 address.setAddress2(addressDto.getAddress2());
		 address.setAddress3(addressDto.getAddress3());
		 address.setAddressType(addressDto.getAddressType());
		 address.setCity(addressDto.getCity());
		 address.setPinCode(addressDto.getPinCode());
		 address.setState(addressDto.getState());
		 address.setCustomer(addressDto.getCustomer());
		  addressRepository.save(address);
		 return address;
	 }
	 
	 public AddressDto updateAddress(Long id, AddressDto addressDto)
	    {
		 Address add1 = addressRepository.findAddressById(id);
		 add1.setAddress1(addressDto.getAddress1());
		 add1.setAddress2(addressDto.getAddress2());
		 add1.setAddress3(addressDto.getAddress3());
		 add1.setAddressType(addressDto.getAddressType());
		 add1.setCity(addressDto.getCity());
		 add1.setPinCode(addressDto.getPinCode());
		 add1.setState(addressDto.getState());
		 add1.setCustomer(addressDto.getCustomer());
		 AddressDto cdt = new AddressDto();
		 cdt.setAddress1(add1.getAddress1());
		 cdt.setAddress2(add1.getAddress2());
		 cdt.setAddress3(add1.getAddress3());
		 cdt.setAddressType(add1.getAddressType());
		 cdt.setCity(add1.getCity());
		 cdt.setPinCode(add1.getPinCode());
		 cdt.setState(add1.getState());
		 cdt.setCustomer(add1.getCustomer());
		 return cdt;
		 
	    }
	 
	 public List<AddressDto> findAll()
	 {
		  return addressRepository.findAll().stream().map(s -> {
			  AddressDto addressDto =  new AddressDto();
			  addressDto.setAddress1(s.getAddress1());
			  addressDto.setAddress2(s.getAddress2());
			  addressDto.setAddress3(s.getAddress3());
			  addressDto.setAddressType(s.getAddressType());
			  addressDto.setCity(s.getCity());
			  addressDto.setPinCode(s.getPinCode());
			  addressDto.setState(s.getState());
			  addressDto.setCustomer(s.getCustomer());
			  return addressDto;
		  }).collect(Collectors.toList());
	 }
	 
	 public AddressDto findOne(Long addressId) {
		 Optional<Address> address =  addressRepository.findById(addressId);
		 AddressDto addressDto = new AddressDto();
		 addressDto.setId(address .get().getId());
		 addressDto.setAddress1(address .get().getAddress1());
		 addressDto.setAddress2(address .get().getAddress2());
		 addressDto.setAddress3(address .get().getAddress3());
		 addressDto.setAddressType(address.get().getAddressType());
		 addressDto.setCity(address .get().getCity());
		 addressDto.setPinCode(address .get().getPinCode());
		 addressDto.setState(address .get().getState());
		 addressDto.setCustomer(address .get().getCustomer());
		 
	        return  addressDto;
	    }
	
	 public void deleteAddress(Long id) {
	        
	        addressRepository.deleteById(id);
	    }
	 
}
