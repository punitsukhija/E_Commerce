package com.wissen.e_commerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wissen.e_commerce.model.Discount;
import com.wissen.e_commerce.pojo.DiscountBo;
import com.wissen.e_commerce.pojo.OrderBo;
import com.wissen.e_commerce.repository.DiscountRepository;
import com.wissen.e_commerce.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService{

	@Autowired
	private DiscountRepository discountRepo;
	@Override
	public void addDiscount(DiscountBo discountBo) {
		
		Discount discount = mapBoToEntity(discountBo);
		discountRepo.save(discount);
		
	}

	private Discount mapBoToEntity(DiscountBo discountBo) {
		Discount discount = new Discount();
		
		
		return discount ;
	}

	@Override
	public Double applyDiscount(OrderBo orderBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void activateDeactivateDsicount(Boolean active, Long id) {
		// TODO Auto-generated method stub
		
	}

}
