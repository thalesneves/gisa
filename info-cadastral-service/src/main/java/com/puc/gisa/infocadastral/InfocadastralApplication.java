package com.puc.gisa.infocadastral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InfocadastralApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfocadastralApplication.class, args);
	}

}
