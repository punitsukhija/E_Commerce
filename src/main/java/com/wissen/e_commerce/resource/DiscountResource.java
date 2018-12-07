package com.wissen.e_commerce.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.pojo.DiscountBo;
import com.wissen.e_commerce.pojo.OrderBo;
import com.wissen.e_commerce.service.DiscountService;

@Component
@Path("/discount")
public class DiscountResource {

	@Autowired
	private DiscountService discountService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDiscount(DiscountBo discountBo) {
		discountService.addDiscount(discountBo);
		return Response.ok().build();
	}
	
	@POST
	@Path("/apply")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response applyDiscount(OrderBo orderBo) {
		return Response.ok().entity(discountService.applyDiscount(orderBo)).build();
	}
	
	@PUT
	@Path("{id}/{active}")
	public Response activeDeactiveDiscount(@PathParam("id")Long id , @PathParam("active")Boolean active) throws E_CommerceException {
		discountService.activateDeactivateDsicount(active, id);
		return Response.ok().build();
	}
}
