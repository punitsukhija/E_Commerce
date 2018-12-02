package com.wissen.e_commerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wissen.e_commerce.constants.E_CommerceError.Code;
import com.wissen.e_commerce.constants.E_CommerceError.Message;
import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.model.Seller;
import com.wissen.e_commerce.pojo.SellerBo;
import com.wissen.e_commerce.repository.SellerRepository;
import com.wissen.e_commerce.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepo;

	@Override
	public void register(SellerBo sellerBo) throws E_CommerceException {
		Seller seller = mapSellerBoToEntity(sellerBo);
		Seller registeredSeller = sellerExists(seller.getEmail());
		
		if(registeredSeller != null && registeredSeller.getActive()==true)
			throw new E_CommerceException(Code.SELLER_EXISTS, Message.SELLER_EXISTS);
		else {
			seller.setId(registeredSeller!=null?registeredSeller.getId():null);
		}
		
		seller.setActive(true);
		sellerRepo.save(seller);

	}

	private Seller sellerExists(String email) {
		return sellerRepo.findFirstByEmail(email);
		
	}

	private Seller mapSellerBoToEntity(SellerBo sellerBo) {
		Seller seller = new Seller();
		seller.setSellerName(sellerBo.getSellerName());
		seller.setPhone_number(sellerBo.getPhoneNumber());
		seller.setAddress(sellerBo.getAddress());
		seller.setEmail(sellerBo.getEmail());

		return seller;
	}

	@Override
	public void deregister(Long id) {
		Seller seller = sellerRepo.findOne(id);

		if (seller != null) {
			seller.setActive(false);
			sellerRepo.save(seller);
		}

	}

}