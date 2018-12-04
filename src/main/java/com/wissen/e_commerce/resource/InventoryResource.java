package com.wissen.e_commerce.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import com.wissen.e_commerce.pojo.AddProductsBo;
import com.wissen.e_commerce.pojo.InventoryBo;
import com.wissen.e_commerce.pojo.RemoveProductsBo;
import com.wissen.e_commerce.service.InventoryService;

@Component
@Path("/inventory")
public class InventoryResource {
	
	@Autowired
	private InventoryService inventoryService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addInventory(InventoryBo inventoryBo) throws E_CommerceException
	{
		inventoryService.addInventory(inventoryBo);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeInventory(@PathParam("id")Long id) {
		
		inventoryService.removeInventory(id);
		return Response.ok().build();
	}
	
	@POST
	@Path("/products")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProducts(AddProductsBo addProductsBo) throws E_CommerceException {
		
		inventoryService.addProducts(addProductsBo);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/products")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeProducts(RemoveProductsBo removeProductsBo) throws E_CommerceException {
		
		inventoryService.removeProducts(removeProductsBo);
		return Response.ok().build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateQuantity(@PathParam("id")Long id,@PathParam("quantity")Long quantity) throws E_CommerceException{
		
		inventoryService.updateProductQuantity(id, quantity);
		return Response.ok().build();
	}
}
