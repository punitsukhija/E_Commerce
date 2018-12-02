package com.wissen.e_commerce.pojo;

import java.util.List;

public class AddProductsBo extends BaseInventoryBo{
	
	private List<ProductBo> products;

	public List<ProductBo> getProducts() {
		return products;
	}

	public void setProducts(List<ProductBo> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "AddProductsBo [products=" + products + "]";
	}
	

}
