package com.in28minutes.microservices.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p-> p.path("**/customer-management/**")
						.uri("lb://customer-management"))
				.build();
		
	}
}
