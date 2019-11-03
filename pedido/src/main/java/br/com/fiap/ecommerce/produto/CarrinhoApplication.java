package br.com.fiap.ecommerce.produto;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CarrinhoApplication {

	@Value("${queue.order.name}")
    private String orderQueue;
	
	public static void main(String[] args) {
		SpringApplication.run(CarrinhoApplication.class, args);
	}
	
	@Bean
    public Queue queue() {
        return new Queue(orderQueue, true);
    }
}
