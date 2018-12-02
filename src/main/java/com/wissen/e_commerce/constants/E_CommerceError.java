package com.wissen.e_commerce.constants;

public class E_CommerceError {
	
	
	public static enum Code{

		USER_EXISTS("301"),
		SELLER_EXISTS("302");
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
		SELLER_EXISTS("Seller already registered");
		private String value;
		private Message(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
}
