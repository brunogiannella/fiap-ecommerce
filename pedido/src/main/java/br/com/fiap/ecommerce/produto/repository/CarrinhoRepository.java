package br.com.fiap.ecommerce.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ecommerce.produto.model.Carrinho;
import br.com.fiap.ecommerce.produto.model.StatusCarrinhoEnum;

/**
 * Classe responsável pela interface de comunicação com o banco de dados mysql da tabela de carrinho
 * @author Bruno
 *
 */
public interface CarrinhoRepository  extends JpaRepository<Carrinho, Long> {

	/**
	 * Método responsável pela consulta de carrinhos através de um id cliente
	 * @param idCliente - Identificador do cliente (CPF)
	 * @return List<Carrinho> - Lista de carrinhos do cliente
	 */
	List<Carrinho> findByIdCliente(Long idCliente);
	
	/**
	 * Método responsável pela consulta de carrinhos através de um id cliente e um determinado status
	 * @param idCliente - Identificador do cliente (CPF)
	 * @param status - Status do carrinho (Enum)
	 * @return List<Carrinho> - Lista de carrinhos do cliente
	 */
	List<Carrinho> findByIdClienteAndStatus(Long idCliente, StatusCarrinhoEnum status);
	
}
