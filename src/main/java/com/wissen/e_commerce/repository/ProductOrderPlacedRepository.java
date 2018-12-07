package com.wissen.e_commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wissen.e_commerce.model.ProductOrderPlaced;

public interface ProductOrderPlacedRepository extends JpaRepository<ProductOrderPlaced, Long>{

	
	public List<ProductOrderPlaced> findByOrderId(Long orderId);
	
}