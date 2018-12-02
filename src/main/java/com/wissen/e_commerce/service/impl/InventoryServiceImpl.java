package com.wissen.e_commerce.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.e_commerce.model.Inventory;
import com.wissen.e_commerce.model.Seller;
import com.wissen.e_commerce.pojo.AddProductsBo;
import com.wissen.e_commerce.pojo.InventoryBo;
import com.wissen.e_commerce.pojo.RemoveProductsBo;
import com.wissen.e_commerce.repository.InventoryRepository;
import com.wissen.e_commerce.repository.ProductRepository;
import com.wissen.e_commerce.repository.SellerRepository;
import com.wissen.e_commerce.service.InventoryService;

public class InventoryServiceImpl implements InventoryService
{
	
	@Autowired
	private InventoryRepository inventoryRepo;
	
	@Autowired
	private SellerRepository sellerRepo;
	
	@Autowired
	private ProductRepository productRepo;

	@Transactional
	@Override
	public void addInventory(InventoryBo inventoryBo) {
		
		Inventory inventory = mapInventoryBoToEntity(inventoryBo);
		
		inventoryRepo.save(inventory);
	}

	private Inventory mapInventoryBoToEntity(InventoryBo inventoryBo) {
		Inventory inventory = new Inventory();
		inventory.setInventoryName(inventoryBo.getInventoryName());
		inventory.setLocation(inventoryBo.getLocation());
		Seller seller = sellerRepo.findFirstByEmail(inventoryBo.getSellerEmailId());
		inventory.setSellerId(seller!=null?seller.getId():null);
		
		return inventory;
	}

	@Override
	public void removeInventory(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProducts(AddProductsBo addProductsBo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProducts(RemoveProductsBo removeProductsBo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProductQuantity(Long id, Long quantity) {
		// TODO Auto-generated method stub
		
	}

}
