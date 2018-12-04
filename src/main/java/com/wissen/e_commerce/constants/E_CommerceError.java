package com.wissen.e_commerce.constants;

public class E_CommerceError {
	
	
	public static enum Code{

		USER_EXISTS("301"),
		SELLER_EXISTS("302"),
		INVALID_SELLER_ID("404"),
		INVENTORY_NOT_FOUND("404"),
		PRODUCT_NOT_FOUND("404");
		private String value;
		
		public String getValue() {
			return value;
		}

		private Code(String value) {
			this.value = value;
		}
	}
	
	public static enum Message{
		
		USER_EXISTS("User already registered"),
		SELLER_EXISTS("Seller already registered"),
		INVALID_SELLER_ID("Cannot add inventory. Seller Not Found!"),
		INVENTORY_NOT_FOUND("Inventory does not exists!"),
		PRODUCT_NOT_FOUND("Product does not exists!");
		private String value;
		private Message(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
}
