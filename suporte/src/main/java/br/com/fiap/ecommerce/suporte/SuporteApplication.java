package br.com.fiap.ecommerce.suporte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Classe responsável por inicializar o Microservice de Suporte através do SpringBoot
 * @author Bruno Giannella
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SuporteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuporteApplication.class, args);
	}
	
}
