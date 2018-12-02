package com.wissen.e_commerce.pojo;

public class BaseInventoryBo {
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BaseInventoryBo [id=" + id + "]";
	}

}
