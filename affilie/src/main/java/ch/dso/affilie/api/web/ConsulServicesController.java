package ch.dso.affilie.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ConsulServicesController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    /**
    public Optional<URI> serviceUrl() {
        return discoveryClient..getInstances("myApp")
                .stream()
                .map(si -> si.getUri())
          .findFirst();
    }
*/

    @GetMapping("/services")
    public List<String> discoveryPing() throws RestClientException, ServiceUnavailableException {

        return  discoveryClient.getServices();

       /**
        URI service = serviceUrl()
                .map(s -> s.resolve("/ping"))
                .orElseThrow(ServiceUnavailableException::new);
        return restTemplate.getForEntity(service, String.class)
                .getBody();
        */
    }

}
