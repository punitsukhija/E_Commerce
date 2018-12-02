package com.wissen.e_commerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity(name = "SELLER")
@SequenceGenerator(name="seller_seq",sequenceName="SELLER_SEQ", allocationSize=1)
public class Seller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3982619663007721347L;
	
	@Id
	@GeneratedValue(generator= "seller_seq" ,strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "SELLER_NAME")
	private String sellerName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE_NUMBER")
	private String phone_number;
	
	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "ACTIVE")
	private Boolean active;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	

}
