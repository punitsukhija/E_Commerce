package com.wissen.e_commerce.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wissen.e_commerce.model.Discount;
import com.wissen.e_commerce.pojo.PaymentMode;

@Repository
public interface DiscountRepository  extends JpaRepository<Discount,Long>{

	public List<Discount> findByProductOrSellerOrPaymentModeAndValidFromDateLessThanAndExpiryDateGreaterThan(String product, String seller, PaymentMode paymentMode, Date validFromDate ,Date expiryDate);
	
}
