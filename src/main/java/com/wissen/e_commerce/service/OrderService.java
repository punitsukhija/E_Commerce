package com.wissen.e_commerce.service;

import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.pojo.OrderBo;

public interface OrderService {
	
	public void placeOrder(OrderBo orderBo) throws E_CommerceException;
	
	public void modifyOrder(OrderBo orderBo) throws E_CommerceException;
	
	public void cancelOrder(Long id) throws E_CommerceException;
	
	public OrderBo checkOrderStatus(Long id) throws E_CommerceException;


}
