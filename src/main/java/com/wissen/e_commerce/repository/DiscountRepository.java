package com.wissen.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wissen.e_commerce.model.Discount;

@Repository
public interface DiscountRepository  extends JpaRepository<Discount,Long>{

}
