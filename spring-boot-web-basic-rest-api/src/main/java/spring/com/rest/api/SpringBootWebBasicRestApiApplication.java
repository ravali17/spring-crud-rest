package spring.com.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//(scanBasePackages={
//"spring.com.rest.api.controller", "spring.com.rest.api.dto","spring.com.rest.api.entity","spring.com.rest.api.exceptions","spring.com.rest.api.service","spring.com.rest.api.repository"})

public class SpringBootWebBasicRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebBasicRestApiApplication.class, args);
	}

}
