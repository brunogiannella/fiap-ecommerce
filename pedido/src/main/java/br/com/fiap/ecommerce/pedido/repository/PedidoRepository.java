package br.com.fiap.ecommerce.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ecommerce.pedido.model.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {

}
