package ch.dso.eventconsummer;

import brave.Span;

import brave.Tracer;
import brave.propagation.TraceContextOrSamplingFlags;
import brave.propagation.TraceIdContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;


import java.io.IOException;
import java.util.EventListener;

@Slf4j
@SpringBootApplication
public class EventConsummerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventConsummerApplication.class);
    }

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(@Payload String data,
                        @Headers MessageHeaders messageHeaders) throws IOException {


    //    byte[] spanId = (byte[]) messageHeaders.get("X-B3-TraceId");
     //   Span span = this.tracer.nextSpan(TraceContextOrSamplingFlags.newBuilder()
      //          .traceIdContext(TraceIdContext.newBuilder()
       //                 .traceId(123L)
        //                .build())
         //       .build()).name("foo").start();

        log.info("received message='{}'", data);
        log.info(String.format("#### -> Consumed message -> %s", data));
        log.info("Span Id: {}",new String(""));
    }
}
