package br.com.fiap.ecommerce.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.internal.EnableZipkinServer;

/**
 * Classe responsável pela aplicação do Zipkin e inicialização através do SpringBoot
 * @author Bruno Giannella
 *
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }
}