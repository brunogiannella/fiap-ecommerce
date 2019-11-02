package br.com.fiap.ecommerce.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ecommerce.produto.model.Carrinho;
import br.com.fiap.ecommerce.produto.model.StatusCarrinhoEnum;

public interface CarrinhoRepository  extends JpaRepository<Carrinho, Long> {

	List<Carrinho> findByIdCliente(Long idCliente);
	List<Carrinho> findByIdClienteAndStatus(Long idCliente, StatusCarrinhoEnum status);
	
}
