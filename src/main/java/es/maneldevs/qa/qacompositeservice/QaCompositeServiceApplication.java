package es.maneldevs.qa.qacompositeservice;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import es.maneldevs.qa.qacompositeservice.config.MicroservicesConfigProperties;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan("es.maneldevs")
@EnableConfigurationProperties({MicroservicesConfigProperties.class})
public class QaCompositeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QaCompositeServiceApplication.class, args);
	}

	@PostConstruct
    public void init(){
      TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
