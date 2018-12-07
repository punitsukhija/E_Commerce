package com.wissen.e_commerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.wissen.e_commerce.pojo.DiscountType;
import com.wissen.e_commerce.pojo.PaymentMode;

@Entity(name="DISCOUNT")
@SequenceGenerator(name="discount_seq",sequenceName="DISCOUNT_SEQ", allocationSize=1)
public class Discount {
	
	@Id
	@GeneratedValue(generator= "discount_seq" ,strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "PRODUCT")
	private String product;
	
	@Column(name = "SELLER")
	private String seller;
	
	@Column(name = "PAYMENT_MODE")
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;
	
	@Column(name = "VALID_FROM_DATE")
	private Date validFromDate;
	
	@Column(name = "EXPIRY_DATE")
	private Date expiryDate;
	
	@Column(name = "DISCOUNT_TYPE")
	@Enumerated(EnumType.STRING)
	private DiscountType discountType;
	
	@Column(name = "DISCOUNT_VALUE")
	private Double discountValue;
	
	@Column(name = "ACTIVE")
	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Date getValidFromDate() {
		return validFromDate;
	}

	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}

	public Double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(Double discountValue) {
		this.discountValue = discountValue;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
