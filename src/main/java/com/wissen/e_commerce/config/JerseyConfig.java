package com.wissen.e_commerce.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.wissen.e_commerce.exception.E_CommerceException;
import com.wissen.e_commerce.resource.CustomerResource;
import com.wissen.e_commerce.resource.HelloWorldResource;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

	/**
	 * In constructor we can define Jersey Resources & Other Components
	 */
	public JerseyConfig() {
		
		/*
		 * Jersey will automatically register class with @provider, @Component  by scanning
		 * these packages + nested packages
		 */
		packages("com.wissen.e_commerce.resource", "com.wissen.e_commerce.config","com.wissen.e_commerce.exception");
		
		/* CustomTypeParamterConsumeResource auto scanned and register */
		//register(CustomTypeParamterConsumeResource.class);
		/*register(MatrixUriResource.class);
		register(RequestCookiesResource.class);
		register(RequestHeaderResource.class);
		register(RequestParameterResource.class);
		register(EmployeeResource.class);
		register(HumansResource.class);
		register(HelloWorldResource.class);
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
		register(MultiPartFeature.class);
*/		
		register(HelloWorldResource.class);
		register(CustomerResource.class);
		register(E_CommerceException.class);
	}
}