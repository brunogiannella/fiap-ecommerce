package br.com.fiap.ecommerce.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ecommerce.produto.model.ItemCarrinho;

/**
 * Classe responsável pela interface de comunicação com o banco de dados mysql da tabela de ItemCarrinho
 * @author Bruno
 *
 */
public interface ItemCarrinhoRepository  extends JpaRepository<ItemCarrinho, Long> {

}
