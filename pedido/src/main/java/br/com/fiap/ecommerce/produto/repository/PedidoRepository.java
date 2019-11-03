package br.com.fiap.ecommerce.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.ecommerce.produto.model.Pedido;

/**
 * Classe responsável pela interface de comunicação com o banco de dados mysql da tabela de pedido
 * @author Bruno
 *
 */
public interface PedidoRepository  extends JpaRepository<Pedido, Long> {

	/**
	 * Método responsável pela consulta de pedidos através de um id cliente
	 * @param idCliente - Identificador do cliente (CPF)
	 * @return List<Pedido> - Lista de pedidos do cliente
	 */
	@Query("SELECT P FROM PEDIDO P WHERE P.carrinho.idCliente = :idCliente")
	List<Pedido> findByCliente(Long idCliente);
	
}
