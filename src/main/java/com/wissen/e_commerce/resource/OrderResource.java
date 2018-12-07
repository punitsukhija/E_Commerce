package com.wissen.e_commerce.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.pojo.OrderBo;
import com.wissen.e_commerce.service.OrderService;

@Component
@Path("/order")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newOrder(OrderBo orderBo) throws E_CommerceException {
		orderService.placeOrder(orderBo);
		return Response.ok().build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOrder(OrderBo orderBo) throws E_CommerceException {
		orderService.modifyOrder(orderBo);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public Response cancelOrder(@PathParam("id")Long id) throws E_CommerceException {
		orderService.cancelOrder(id);
		return Response.ok().build();
	}
	
	@GET
	@Path("{id}")
	public Response checkOrderStatus(@PathParam("id")Long id) throws E_CommerceException {
		orderService.checkOrderStatus(id);
		return Response.ok().build();
	}

}
