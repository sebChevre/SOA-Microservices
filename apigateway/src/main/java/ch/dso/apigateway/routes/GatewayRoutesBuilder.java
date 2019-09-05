package ch.dso.apigateway.routes;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!ymlroutes")
@Component
public class GatewayRoutesBuilder {

	
	@Bean
	public RouteLocator helloApiAffilieRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("hello_affilie_api_route", r ->
				r.path("/hello-api-affilie")
				.filters(f -> 
					f.rewritePath("/hello-api-affilie", "/api/hello"))
			.uri("lb://affilie")).build();
	}

	@Bean
	public RouteLocator helloAffilieRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("hello_affilie_route", r ->
						r.path("/hello-affilie")
						.filters(f ->
								f.rewritePath("/hello-affilie", "/hello"))
						.uri("lb://affilie")).build();
	}
	@Bean
	public RouteLocator helloApiPersonneRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("hello_api_personne_route", r ->
						r.path("/hello-api-personne")
								.filters(f ->
										f.rewritePath("//hello-api-personne", "/api/hello"))
								.uri("lb://personne")).build();
	}

	@Bean
	public RouteLocator helloAPersonneRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("hello_personne_route", r ->
						r.path("/hello-personne")
						.filters(f ->
								f.rewritePath("/hello-personne", "/hello"))
						.uri("lb://personne")).build();
	}





}
