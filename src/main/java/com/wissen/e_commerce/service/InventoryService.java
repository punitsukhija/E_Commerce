package com.wissen.e_commerce.service;

import java.util.List;

import com.wissen.e_commerce.pojo.AddProductsBo;
import com.wissen.e_commerce.pojo.InventoryBo;
import com.wissen.e_commerce.pojo.ProductBo;
import com.wissen.e_commerce.pojo.RemoveProductsBo;

public interface InventoryService {
	
	public void addInventory(InventoryBo inventoryBo);
	
	public void removeInventory(Long id);
	
	public void addProducts(AddProductsBo addProductsBo);
	
	public void removeProducts(RemoveProductsBo removeProductsBo);
	
	public void updateProductQuantity(Long id,Long quantity);

}
