package com.wissen.e_commerce.service;

import java.util.List;

import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.pojo.AddProductsBo;
import com.wissen.e_commerce.pojo.InventoryBo;
import com.wissen.e_commerce.pojo.ProductBo;
import com.wissen.e_commerce.pojo.RemoveProductsBo;

public interface InventoryService {
	
	public void addInventory(InventoryBo inventoryBo) throws E_CommerceException;
	
	public void removeInventory(Long id);
	
	public void addProducts(AddProductsBo addProductsBo) throws E_CommerceException;
	
	public void removeProducts(RemoveProductsBo removeProductsBo) throws E_CommerceException;
	
	public void updateProductQuantity(Long id,Long quantity) throws E_CommerceException;

}
