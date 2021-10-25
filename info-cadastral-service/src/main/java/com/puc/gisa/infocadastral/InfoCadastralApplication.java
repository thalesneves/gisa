package com.puc.gisa.infocadastral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InfoCadastralApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoCadastralApplication.class, args);
	}

}
