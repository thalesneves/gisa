package com.puc.gisa.servicosaoassociado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicosAssociadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicosAssociadoApplication.class, args);
	}

}
