package br.com.fiap.ecommerce.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ecommerce.produto.model.ItemCarrinho;

public interface ItemCarrinhoRepository  extends JpaRepository<ItemCarrinho, Long> {

}
