package com.wissen.e_commerce.model;

public class ProductOrderPlaced {
	
	private Long id;
	
	private Long productId;
	
	@Override
	public String toString() {
		return "ProductOrderPlaced [id=" + id + ", productId=" + productId + ", orderId=" + orderId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	private Long orderId;
	
}
