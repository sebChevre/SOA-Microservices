package ch.dso.affilie;

import ch.dso.affilie.scheduler.SimpleScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Date;

@EnableScheduling
@SpringBootApplication(exclude = ConsulDiscoveryClientConfiguration.class)
public class AffilieApplication {



	public static void main(String[] args) {
		SpringApplication.run(AffilieApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}

	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
		ThreadPoolTaskScheduler threadPoolTaskScheduler
				= new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(5);
		threadPoolTaskScheduler.setThreadNamePrefix(
				"scheduled-task");

		return threadPoolTaskScheduler;
	}
/**
	@PostConstruct
	public void postConstruct () {

		LocalDateTime d = LocalDateTime.now().plus(1, ChronoUnit.MINUTES);

		Date date = Date.from(d.atZone(ZoneId.systemDefault()).toInstant());

		simpleScheduler.startJobAt(date);

	}
*/
}
