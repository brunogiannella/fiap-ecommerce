package br.com.fiap.ecommerce.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ecommerce.cliente.model.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, String> {

}
