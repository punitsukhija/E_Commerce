package com.wissen.e_commerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wissen.e_commerce.constants.E_CommerceError.Code;
import com.wissen.e_commerce.constants.E_CommerceError.Message;
import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.model.Order;
import com.wissen.e_commerce.model.Product;
import com.wissen.e_commerce.model.ProductOrderPlaced;
import com.wissen.e_commerce.pojo.OrderBo;
import com.wissen.e_commerce.pojo.OrderStatus;
import com.wissen.e_commerce.pojo.ProductBo;
import com.wissen.e_commerce.repository.OrderRepository;
import com.wissen.e_commerce.repository.ProductOrderPlacedRepository;
import com.wissen.e_commerce.repository.ProductRepository;
import com.wissen.e_commerce.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProductOrderPlacedRepository productOrderPlacedRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Transactional(rollbackFor= E_CommerceException.class)	
	@Override
	public void placeOrder(OrderBo orderBo) throws E_CommerceException {
		Order order = mapBoToEntity(orderBo);
		order = orderRepo.save(order);
		checkProductExistsAndPlaceOrder(orderBo.getProducts(), order);
		
	}

	private void checkProductExistsAndPlaceOrder(List<ProductBo> products,Order order) throws E_CommerceException {
		for(ProductBo productBo: products) {
			Product product = productRepo.findOne(productBo.getId());
				
			if(product!=null) {
				if(product.getQuantity()>=productBo.getQuantity()) {
					ProductOrderPlaced orderPlaced = new ProductOrderPlaced();
					orderPlaced.setOrderId(order.getId());
					orderPlaced.setProductId(product.getId());
					product.setQuantity(product.getQuantity()-productBo.getQuantity());
					productRepo.save(product);
				}
				else {
					throw new E_CommerceException(Code.PRODUCT_QUANTITY_EXCEEDED, Message.PRODUCT_QUANTITY_EXCEEDED);
				}
				}
			else {
				throw new E_CommerceException(Code.PRODUCT_NOT_FOUND, Message.PRODUCT_NOT_FOUND);
			}
		}
	}

	private Order mapBoToEntity(OrderBo orderBo) {
		Order order = new Order();
		order.setCustomerId(orderBo.getCustomerId());
		order.setDateAndTime(orderBo.getDateAndTime());
		order.setDeliveryAddress(orderBo.getDeliveryAddress());
		order.setDiscountedPrice(orderBo.getDiscountedPrice());
		order.setTotalBillAmount(orderBo.getTotalBillAmount());
		order.setPaymentMode(orderBo.getPaymentMode());
		return order;
	}

	@Override
	public void modifyOrder(OrderBo orderBo) throws E_CommerceException {
		Order order = orderRepo.findOne(orderBo.getId());
		if(order==null) {
			throw new E_CommerceException(Code.ORDER_NOT_FOUND, Message.ORDER_NOT_FOUND);
		}
		if(order.getOrderStatus().equals(OrderStatus.DELIVERED)||order.getOrderStatus().equals(OrderStatus.CANCELLED)) {
			throw new E_CommerceException(Code.ORDER_MODIFY_ERROR, Message.ORDER_MODIFY_ERROR);
		}else {
			order.setDeliveryAddress(orderBo.getDeliveryAddress());
		}
		orderRepo.save(order);
	}

	@Override
	public void cancelOrder(Long id) throws E_CommerceException {
		Order order = orderRepo.findOne(id);
		if(order==null) {
			throw new E_CommerceException(Code.ORDER_NOT_FOUND, Message.ORDER_NOT_FOUND);
		}
		order.setOrderStatus(OrderStatus.CANCELLED);
		orderRepo.save(order);
		
	}

	@Override
	public OrderBo checkOrderStatus(Long id) throws E_CommerceException {
		Order order = orderRepo.findOne(id);
		if(order == null) {
			throw new E_CommerceException(Code.ORDER_NOT_FOUND, Message.ORDER_NOT_FOUND);
		}
		return mapEntityToBo(order);
	}

	private OrderBo mapEntityToBo(Order order) {
		OrderBo orderBo = new OrderBo();
		orderBo.setCustomerId(order.getCustomerId());
		orderBo.setDateAndTime(order.getDateAndTime());
		orderBo.setDeliveryAddress(order.getDeliveryAddress());
		orderBo.setDiscountedPrice(order.getDiscountedPrice());
		orderBo.setId(order.getId());
		orderBo.setOrderStatus(order.getOrderStatus());
		orderBo.setPaymentMode(order.getPaymentMode());
		orderBo.setTotalBillAmount(order.getTotalBillAmount());
		orderBo.setProducts(getListOfProducts(order.getId()));
		return orderBo;
	}

	private List<ProductBo> getListOfProducts(Long id) {
		List<ProductOrderPlaced> listOfProductOrderPlaced = productOrderPlacedRepo.findByOrderId(id);
		List<ProductBo> productBos = getListOfProductBos(listOfProductOrderPlaced);
		return productBos;
	}

	private List<ProductBo> getListOfProductBos(List<ProductOrderPlaced> listOfProductOrderPlaced) {
		List<ProductBo> productBos = new ArrayList<>();
		for(ProductOrderPlaced orderPlaced : listOfProductOrderPlaced) {
			Product product = productRepo.findOne(orderPlaced.getProductId());
			ProductBo productBo = mapEntityToBo(product);
			productBos.add(productBo);
		}
		return productBos;
	}

	private ProductBo mapEntityToBo(Product product) {
		ProductBo productBo = new ProductBo();
		productBo.setId(product.getId());
		productBo.setInventoryId(product.getInventoryId());
		productBo.setCategory(product.getCategory());
		productBo.setDescription(product.getDescription());
		productBo.setPrice(product.getPrice());
		productBo.setProductName(product.getProductName());
		productBo.setQuantity(product.getQuantity());
		return productBo;
	}
}