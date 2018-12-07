package com.wissen.e_commerce.pojo;

public class ProductBo {
	private Long id;

	private String productName;

	private String description;

	private String category;

	private Double price;

	private Long inventoryId;
	
	private Double discountedPrice;

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	@Override
	public String toString() {
		return "ProductBo [id=" + id + ", productName=" + productName + ", description=" + description + ", category="
				+ category + ", price=" + price + ", inventoryId=" + inventoryId + ", discountedPrice="
				+ discountedPrice + ", quantity=" + quantity + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	private Long quantity;

}
