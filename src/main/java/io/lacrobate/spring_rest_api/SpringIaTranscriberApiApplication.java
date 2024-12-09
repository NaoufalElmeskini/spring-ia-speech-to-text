package io.lacrobate.spring_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringIaTranscriberApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIaTranscriberApiApplication.class, args);
	}

}