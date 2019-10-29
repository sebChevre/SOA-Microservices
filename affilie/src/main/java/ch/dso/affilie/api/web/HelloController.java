package ch.dso.affilie.api.web;

import ch.dso.affilie.api.web.ressources.HelloWorldRessource;
import ch.dso.affilie.infrastructure.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    Environment environment;

    @Autowired
    KafkaProducer producer;

    @GetMapping("/hello")
    public ResponseEntity<HelloWorldRessource> helloWorld(){
        log.info("/hello rest endpoint");
        producer.sendMessage("test msg, /hello");
        return ResponseEntity.ok(new HelloWorldRessource("World, from affilie, /hello",getInstancePort()));
    }

    @GetMapping("/api/hello")
    public ResponseEntity<HelloWorldRessource> helloWorldApiPrefixPath(){
        log.info("/api/hello rest endpoint");
        producer.sendMessage("test msg, /api/hello");
        return ResponseEntity.ok(new HelloWorldRessource("World, from affilie, /api/hello",getInstancePort()));
    }

    private int getInstancePort() {
        return Integer.parseInt(environment.getProperty("server.port"));
    }
}
