package com.wissen.e_commerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.e_commerce.constants.E_CommerceError.Code;
import com.wissen.e_commerce.constants.E_CommerceError.Message;
import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.model.Inventory;
import com.wissen.e_commerce.model.Product;
import com.wissen.e_commerce.model.Seller;
import com.wissen.e_commerce.pojo.AddProductsBo;
import com.wissen.e_commerce.pojo.InventoryBo;
import com.wissen.e_commerce.pojo.ProductBo;
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
	public void addInventory(InventoryBo inventoryBo) throws E_CommerceException {
		
		Inventory inventory = mapInventoryBoToEntity(inventoryBo);
		
		inventoryRepo.save(inventory);
	}

	private Inventory mapInventoryBoToEntity(InventoryBo inventoryBo) throws E_CommerceException {
		Inventory inventory = new Inventory();
		inventory.setInventoryName(inventoryBo.getInventoryName());
		inventory.setLocation(inventoryBo.getLocation());
		Seller seller = sellerRepo.findFirstByEmail(inventoryBo.getSellerEmailId());
		if(seller ==null) {
			throw new E_CommerceException(Code.INVALID_SELLER_ID, Message.INVALID_SELLER_ID);
		}
		inventory.setSellerId(seller.getId());
		
		return inventory;
	}

	@Transactional
	@Override
	public void removeInventory(Long id) {
		
		inventoryRepo.delete(id);
		productRepo.removeByInventoryId(id);
		
	}

	@Transactional
	@Override
	public void addProducts(AddProductsBo addProductsBo) throws E_CommerceException {
		
		if(inventoryRepo.findOne(addProductsBo.getId())==null) {
			throw new E_CommerceException(Code.INVENTORY_NOT_FOUND, Message.INVENTORY_NOT_FOUND);
		}
		List<Product> products = getProductsFromProductBo(addProductsBo.getProducts(),addProductsBo.getId());
		productRepo.save(products);
	}

	private List<Product> getProductsFromProductBo(List<ProductBo> productsBo , Long inventoryId) {
		
		List<Product> products = new ArrayList<>();
		for(ProductBo productBo : productsBo) {
			Product product = mapBoToEntity(productBo,inventoryId);
			products.add(product);
		}
		return products;
	}

	private Product mapBoToEntity(ProductBo productBo, Long inventoryId) {
		Product product = new Product();
		product.setId(productBo.getId());
		product.setInventoryId(inventoryId);
		product.setCategory(productBo.getCategory());
		product.setDescription(productBo.getDescription());
		product.setPrice(productBo.getPrice());
		product.setProductName(productBo.getProductName());
		product.setQuantity(productBo.getQuantity());
		return product;
	}

	@Transactional
	@Override
	public void removeProducts(RemoveProductsBo removeProductsBo) throws E_CommerceException {
		if(inventoryRepo.findOne(removeProductsBo.getId())==null) {
			throw new E_CommerceException(Code.INVENTORY_NOT_FOUND, Message.INVENTORY_NOT_FOUND);
		}
		List<Product> products = getProductsFromProductBo(removeProductsBo.getProducts(), removeProductsBo.getId());
		 
		productRepo.deleteInBatch(products);
		
	}
	
	@Transactional
	@Override
	public void updateProductQuantity(Long id, Long quantity) throws E_CommerceException {
		Product product = productRepo.findOne(id);
		if(product==null) {
			throw new E_CommerceException(Code.PRODUCT_NOT_FOUND,Message.PRODUCT_NOT_FOUND);
		}
		
		product.setQuantity(quantity);
		productRepo.save(product);
		
	}

}
