package com.wissen.e_commerce.service;

import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.pojo.DiscountBo;
import com.wissen.e_commerce.pojo.OrderBo;

public interface DiscountService {

	public void addDiscount(DiscountBo discountBo);
	
	public OrderBo applyDiscount(OrderBo orderBo);
	
	public void activateDeactivateDsicount(Boolean active , Long id) throws E_CommerceException;
}
