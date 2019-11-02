package br.com.fiap.ecommerce.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.ecommerce.produto.model.Categoria;
import br.com.fiap.ecommerce.produto.model.GeneroEnum;
import br.com.fiap.ecommerce.produto.model.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {

	List<Produto> findByGenero(GeneroEnum genero);
	
	@Query("SELECT P FROM PRODUTO P WHERE P.descricao like %:palavraChave%")
	List<Produto> findByDescricao(String palavraChave);

	List<Produto> findTop3ByCategoriaOrderByQuantidadeVisualizacoesDesc(Long categoria);

	List<Produto> findTop3ByCategoriaOrderByQuantidadeVisualizacoesDesc(Categoria categoria);
	
}
