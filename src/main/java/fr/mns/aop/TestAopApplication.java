package fr.mns.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.mns.aop.model.SimpleOperation;

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
