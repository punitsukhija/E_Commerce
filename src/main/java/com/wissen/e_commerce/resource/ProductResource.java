package com.wissen.e_commerce.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wissen.e_commerce.pojo.ProductBo;
import com.wissen.e_commerce.service.ProductService;

@Component
@Path("/product")
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	@GET
	@Path("{productName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchProduct(@PathParam("productName")String productName) {
		List<ProductBo> productBos = productService.searchProduct(productName);
		return Response.ok().entity(productBos).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response advanceSearch(@QueryParam("productName")String productName, @QueryParam("sellerName")String sellerName,
						@QueryParam("category")String category,@QueryParam("fromPrice")String fromPrice, @QueryParam("toPrice")String toPrice) {
		List<ProductBo> productBos = productService.advanceSearch(productName, sellerName, category, fromPrice, toPrice);
		return Response.ok().entity(productBos).build();
	}
}
