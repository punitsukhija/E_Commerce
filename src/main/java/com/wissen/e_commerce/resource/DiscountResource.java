package com.wissen.e_commerce.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.wissen.e_commerce.pojo.DiscountBo;

@Component
@Path("/discount")
public class DiscountResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addDiscount(DiscountBo discountBo) {
		
	}
}
