package com.wissen.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wissen.e_commerce.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{

	public Seller findFirstByEmail(String email);
}
