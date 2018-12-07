package com.wissen.e_commerce.model;

import java.util.Date;

import com.wissen.e_commerce.pojo.OrderStatus;
import com.wissen.e_commerce.pojo.PaymentMode;

public class Order {
	
	private Long id;
	
	private Long customerId;
	
	private Date dateAndTime;
	
	private String deliveryAddress;
	
	private PaymentMode paymentMode;
	
	private Double totalBillAmount;
	
	private Double discountedPrice;
	
	private OrderStatus orderStatus;

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", dateAndTime=" + dateAndTime + ", deliveryAddress="
				+ deliveryAddress + ", paymentMode=" + paymentMode + ", totalBillAmount=" + totalBillAmount
				+ ", discountedPrice=" + discountedPrice + ", orderStatus=" + orderStatus + "]";
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
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

	public Double getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(Double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

}
