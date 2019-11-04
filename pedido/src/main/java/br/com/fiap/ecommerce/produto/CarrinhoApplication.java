package br.com.fiap.ecommerce.produto;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Classe responsável por inicializar o Microservice de Pedidos através do
 * SpringBoot
 * 
 * @author Bruno Giannelal
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CarrinhoApplication {

	@Value("${queue.order.name}")
	private String orderQueue;

	public static void main(String[] args) {
		SpringApplication.run(CarrinhoApplication.class, args);
	}

	/**
	 * Método responsável por configurar a Fila PEDIDOS do RabbitMQ
	 * 
	 * @return Queue - Objeto para interação com a fila PEDIDOS
	 */
	@Bean
	public Queue queue() {
		return new Queue(orderQueue, true);
	}

	/**
	 * Método responsável por criar RestTempalte
	 * @return RestTemplate
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
