package br.com.fiap.ecommerce.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ecommerce.cliente.model.Cliente;

/**
 * Classe responsável pela interface de comunicação com o banco de dados mysql da tabela de Cliente
 * @author Bruno Giannella
 *
 */
public interface ClienteRepository  extends JpaRepository<Cliente, String> {

}
