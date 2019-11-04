package br.com.fiap.ecommerce.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Classe responsável por inicializar o Microservice de Cliente através do SpringBoot
 * @author Bruno Giannella
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class ClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}
	
}
