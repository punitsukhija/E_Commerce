package com.wissen.e_commerce.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wissen.e_commerce.constants.E_CommerceError.Code;
import com.wissen.e_commerce.constants.E_CommerceError.Message;
import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.model.Discount;
import com.wissen.e_commerce.model.Inventory;
import com.wissen.e_commerce.model.Seller;
import com.wissen.e_commerce.pojo.DiscountBo;
import com.wissen.e_commerce.pojo.OrderBo;
import com.wissen.e_commerce.pojo.PaymentMode;
import com.wissen.e_commerce.pojo.ProductBo;
import com.wissen.e_commerce.repository.DiscountRepository;
import com.wissen.e_commerce.repository.InventoryRepository;
import com.wissen.e_commerce.repository.ProductRepository;
import com.wissen.e_commerce.repository.SellerRepository;
import com.wissen.e_commerce.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService{

	@Autowired
	private DiscountRepository discountRepo;
	
	@Autowired
	private InventoryRepository inventoryRepo;
	
	@Autowired
	private SellerRepository sellerRepo;
	@Override
	public void addDiscount(DiscountBo discountBo) {
		
		Discount discount = mapBoToEntity(discountBo);
		discountRepo.save(discount);
		
	}

	private Discount mapBoToEntity(DiscountBo discountBo) {
		Discount discount = new Discount();
		discount.setProduct(discountBo.getProduct());
		discount.setSeller(discount.getSeller());
		discount.setDiscountType(discountBo.getDiscountType());
		discount.setDiscountValue(discountBo.getDiscountValue());
		discount.setPaymentMode(discountBo.getPaymentMode());
		discount.setActive(discountBo.getActive());
		discount.setValidFromDate(discountBo.getValidFromDate());
		discount.setExpiryDate(discountBo.getExpiryDate());
		return discount ;
	}

	@Override
	public OrderBo applyDiscount(OrderBo orderBo) {
		return checkForDiscountAndApply(orderBo);
	}

	private OrderBo checkForDiscountAndApply(OrderBo orderBo) {
		Double totalBillAmount = 0d;
		for(ProductBo productBo : orderBo.getProducts()) {
			
		String productName = productBo.getProductName();
		Date dateAndTime = orderBo.getDateAndTime();
		Inventory inventory = inventoryRepo.findOne(productBo.getInventoryId());
		Seller seller = sellerRepo.findOne(inventory.getSellerId());
		String sellerEmailId = seller.getEmail();
		
		double discountedPrice = getBestDiscount(productName,sellerEmailId,orderBo.getPaymentMode(),dateAndTime,productBo.getPrice());
		totalBillAmount += discountedPrice;
		productBo.setPrice(discountedPrice);
		}
		orderBo.setDiscountedPrice(totalBillAmount);
		return orderBo;
	}

	private Double getBestDiscount(String productName, String sellerEmailId, PaymentMode paymentMode,
			Date dateAndTime , Double price) {
		List<Discount> discounts = 	discountRepo.findByProductOrSellerOrPaymentModeAndValidFromDateLessThanAndExpiryDateGreaterThan(productName, sellerEmailId
				, paymentMode, dateAndTime, dateAndTime);
		
		
		Double bestPrice = 0d;
		for(Discount discount: discounts) {
			switch(discount.getDiscountType()) {
			case FLAT :
				if(discount.getDiscountValue()>bestPrice) {
					bestPrice = price - discount.getDiscountValue();
					
				}
			case PERCENTAGE :
				Double discountedPrice = price - ((discount.getDiscountValue()/100)*price);
				if(discountedPrice>bestPrice) {
					bestPrice = discountedPrice;  
				}
			}
		}
		return bestPrice;
	}

	@Override
	public void activateDeactivateDsicount(Boolean active, Long id) throws E_CommerceException {
		Discount discount = discountRepo.findOne(id);
		if(discount ==null) {
			throw new E_CommerceException(Code.DISCOUNT_NOT_FOUND, Message.DISCOUNT_NOT_FOUND);	
		}
		discount.setActive(active);
	}

}
