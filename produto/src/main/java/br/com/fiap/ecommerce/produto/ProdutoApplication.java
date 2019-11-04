package br.com.fiap.ecommerce.produto;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Classe responsável por inicializar o Microservice de Produto através do SpringBoot
 * @author Bruno Giannella
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
public class ProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}
	
}
