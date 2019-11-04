package br.com.fiap.ecommerce.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import br.com.fiap.ecommerce.zuul.filters.ErrorFilter;
import br.com.fiap.ecommerce.zuul.filters.PostFilter;
import br.com.fiap.ecommerce.zuul.filters.PreFilter;

/**
 * Classe responsável pelo Gateway Zuul e inicialização através do SpringBoot
 * @author Bruno Giannella
 *
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }
    
    /**
     * Inicialização de um pré filter para cada rota
     * @return PreFilter - objeto com regras para pré filtro
     */
    @Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

    /**
     * Inicialização de um pós filter para cada rota
     * @return PostFilter - objeto com regras para pós filtro
     */
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	/**
     * Inicialização de um error filter para cada rota
     * @return ErrorFilter - objeto com regras para filtro de possíveis errosO
     */
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
}