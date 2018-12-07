package com.wissen.e_commerce.service;

import java.util.List;

import com.wissen.e_commerce.pojo.ProductBo;

public interface ProductService {
	
	public List<ProductBo> searchProduct(String name);
	
	public List<ProductBo> advanceSearch(String productName, String sellerName, String category, String fromPrice, String toPrice);
 
}
