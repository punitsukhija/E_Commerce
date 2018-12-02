package com.wissen.e_commerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wissen.e_commerce.constants.E_CommerceError.Code;
import com.wissen.e_commerce.constants.E_CommerceError.Message;
import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.model.Customer;
import com.wissen.e_commerce.pojo.CustomerBo;
import com.wissen.e_commerce.repository.CustomerRepository;
import com.wissen.e_commerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public void register(CustomerBo customerBo) throws E_CommerceException {
		//map pojo to dao
		Customer customer = mapCustomerBoToEntity(customerBo);
		Customer registeredCustomer = customerExists(customer.getEmail());
		if(registeredCustomer != null && registeredCustomer.getActive() == true)
			throw new E_CommerceException(Code.USER_EXISTS, Message.USER_EXISTS);
		else
			customer.setId(registeredCustomer!=null?registeredCustomer.getId():null);
		customer.setActive(true);
		customerRepo.save(customer);
		
	}

	private Customer customerExists(String email) {
		return customerRepo.findFirstByEmail(email);
		
	}

	private Customer mapCustomerBoToEntity(CustomerBo customerBo) {
		Customer customer = new Customer();
		customer.setFirstName(customerBo.getFirstName());
		customer.setLastName(customerBo.getLastName());
		customer.setEmail(customerBo.getEmail());
		customer.setPhone_number(customerBo.getPhoneNumber());
		customer.setAddress(customerBo.getAddress());
		return customer;
	}



	@Override
	public void deregister(Long id) {
		Customer customer =customerRepo.findOne(id);
		if(customer!= null) {
			customer.setActive(false);
			customerRepo.save(customer);
		}
	}
}
