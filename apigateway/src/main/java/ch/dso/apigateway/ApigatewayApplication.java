package ch.dso.apigateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication
public class ApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}

	@Autowired
	ConsulProperties consulProperties;

	@Autowired
	DiscoveryClient discoveryClient;


	@PostConstruct
	public void postContextConstruct() {
		log.info("application context started");

		log.info("*************** Consull properties ***************");
		log.info("config/api-gateway/test : " + consulProperties.getTest());

		log.info("*************** Discovery clients services ***************");
		discoveryClient.getServices().forEach(service -> {
			log.info("Service: " + service);

			log.info("Instances for {}",service);
			discoveryClient.getInstances(service).forEach(instance -> {
				log.info("Uri: {}, ServiceId:{}",instance.getUri(),instance.getServiceId());

			});

		});

	}
}
