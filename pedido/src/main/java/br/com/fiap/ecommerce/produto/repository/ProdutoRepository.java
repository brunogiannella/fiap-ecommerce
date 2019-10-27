package br.com.fiap.ecommerce.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ecommerce.produto.model.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {

}
