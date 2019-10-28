package ch.dso.restdoc.api.web;

import ch.dso.restdoc.config.ServiceDefinitionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceDefinitionController {

    @Autowired
    private ServiceDefinitionContext definitionContext;



    @GetMapping("/service/{servicename}")

    public String getServiceDefinition(@PathVariable("servicename") String serviceName){

        return definitionContext.getSwaggerDefinition(serviceName);
    }
}
