package lu.sfeir.com.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import lu.sfeir.com.webflux.model.SimpleOperation;

@SpringBootApplication
@Configuration
public class TestAopApplication {
	
	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}

	
	@Bean
	public SimpleOperation simpleOperation() {
		return new SimpleOperation();
	}
	public static void main(String[] args) {
		SpringApplication.run(TestAopApplication.class, args);
		
	}

}
