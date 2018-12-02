package com.wissen.e_commerce.service;

import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.pojo.CustomerBo;

public interface CustomerService {
	
	public void register(CustomerBo customer) throws E_CommerceException;
	
	public void deregister(Long id);

}
