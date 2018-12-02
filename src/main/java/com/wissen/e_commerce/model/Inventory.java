package com.wissen.e_commerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "INVENTORY")
@SequenceGenerator(name="inventory_seq",sequenceName="INVENTORY_SEQ", allocationSize=1)
public class Inventory {

	@Id
	@GeneratedValue(generator= "inventory_seq" ,strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "INVENTORY_NAME")
	private String inventoryName;
	
	@Column(name = "SELLER_ID")
	private Long sellerId;
	
	@Column(name = "LOCATION")
	private String location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
