package com.wissen.e_commerce.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wissen.e_commerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Transactional
	public void removeByInventoryId(Long id);
	
	@Query("select p from Product p "
	          + "where (:productName='' or e.productName=:productName) "
	          + "and (:category='' or e.category=:category) "
	          + "and (:fromPrice='' or p.price between :fromPrice AND :toPrice)"
	          + "and (:sellerName='' or p.inventoryId IN (select i.id from Inventory i where i.sellerId IN (select s.id from Seller s where s.selleName=:sellerName)))")
	public Page<Product> advancedSearch(@Param("productName")String productName,
			@Param("category")String category,@Param("sellerName") String sellerName,
			@Param("fromPrice")Long fromPrice ,@Param("toPrice")Long toPrice );
	
	@Query(nativeQuery = true,value = "select p from Product p where p.inventoryId IN (select i.id from Inventory i where i.sellerId IN (select s.id from Seller s where s.sellenamer=:sellerName))")
	public List<Product> getProductWithSeller(@Param("sellerName") String sellerName); 
	

}
