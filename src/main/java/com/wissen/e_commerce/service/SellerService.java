package com.wissen.e_commerce.service;

import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.pojo.SellerBo;

public interface SellerService {
	
	public void register(SellerBo sellerBo) throws E_CommerceException;
	
	public void deregister(Long id);

}
