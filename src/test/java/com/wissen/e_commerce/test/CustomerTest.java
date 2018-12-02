package com.wissen.e_commerce.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;

public class CustomerTest {
	
	/*@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}
	
	@Test
	public void test() {
		RestAssured.get("/api/helloworld").then().statusCode(200);
	}
	
	@Test
	public void registerCustomer() {
		RequestSpecification request = RestAssured.given();
		String customerJson = createCustomerJsonObject();

		request.header("Content-Type", "application/json");
		request.body(customerJson);
		com.jayway.restassured.response.Response response = request.post("/customer");
		Assert.assertEquals("Status code assert", 200, response.getStatusCode());
	}

	private String createCustomerJsonObject() {
		return "{\\r\\n\\\"firstName\\\":\\\"Punit\\\",\\r\\n\\\"lastName\\\":\\\"Sukhija\\\",\\r\\n\\\"email\\\":\\\"punitsukhija1993@gmail.com\\\",\\r\\n\\\"phoneNumber\\\":\\\"9920920935\\\",\\r\\n\\\"address\\\":\\\"Mumbai\\\"\\r\\n}";
		//return "{\r\n\"sellerName\":\"Punit\",\r\n\"email\":\"punitsukhija1993@gmail.com\",\r\n\"phoneNumber\":\"9920920935\",\r\n\"address\":\"Mumbai\"\r\n}";
	}
	
	*/
}
