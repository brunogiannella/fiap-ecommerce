package br.com.fiap.ecommerce.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Classe responsável pelo Config Server e inicialização através do SpringBoot
 * Neste config server as informações estão sendo buscadas do Git
 * https://github.com/brunogiannella/fiap-ecommerce-config
 * @author Bruno Giannella
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
