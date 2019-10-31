package ch.dso.bff.infrastructure;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class APIClientConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate apiClient(){
        return new RestTemplate();
    }


}
