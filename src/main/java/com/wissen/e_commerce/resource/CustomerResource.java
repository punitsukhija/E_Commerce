package com.wissen.e_commerce.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.pojo.CustomerBo;
import com.wissen.e_commerce.service.CustomerService;

@Component
@Path("/customer")
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerCustomer(CustomerBo customer) throws E_CommerceException {
		
		customerService.register(customer);
		return Response.status(Status.OK).build();
		
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
public Response deregisterCustomer(@PathParam("id")String id) {
		
		customerService.deregister(Long.parseLong(id));
		return Response.status(Status.OK).build();
		
	}
	
	

}
