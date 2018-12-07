package com.wissen.e_commerce.pojo;

import java.util.Date;
import java.util.List;

public class OrderBo {

	private Long id;
	
	private List<ProductBo> products;
	
	private Date dateAndTime;
	
	private Double totalBillAmount;
	
	private Double discountedPrice;
	
	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	private OrderStatus orderStatus;
	
	public Long getId() {
		return id;
	}

	public Double getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(Double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	@Override
	public String toString() {
		return "OrderBo [id=" + id + ", products=" + products + ", dateAndTime=" + dateAndTime + ", totalBillAmount="
				+ totalBillAmount + ", customerId=" + customerId + ", deliveryAddress=" + deliveryAddress
				+ ", paymentMode=" + paymentMode + "]";
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ProductBo> getProducts() {
		return products;
	}

	public void setProducts(List<ProductBo> products) {
		this.products = products;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	private Long customerId;
	
	private String deliveryAddress;
	
	private PaymentMode paymentMode;
	
}
