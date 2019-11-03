package br.com.fiap.ecommerce.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.ecommerce.produto.model.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {

	@Query("SELECT P FROM PEDIDO P WHERE P.carrinho.idCliente = :idCliente")
	List<Pedido> findByCliente(Long idCliente);
	
}
