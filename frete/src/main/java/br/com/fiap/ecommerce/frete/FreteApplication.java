package br.com.fiap.ecommerce.frete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Classe responsável por inicializar o Microservice de Frete através do SpringBoot
 * @author Bruno Giannella
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FreteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreteApplication.class, args);
	}
	
}
