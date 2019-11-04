package br.com.fiap.ecommerce.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.ecommerce.produto.model.Categoria;
import br.com.fiap.ecommerce.produto.model.GeneroEnum;
import br.com.fiap.ecommerce.produto.model.Produto;

/**
 * Classe responsável pela interface de comunicação com o banco de dados mysql da tabela de Produto
 * @author Bruno Giannella
 *
 */
public interface ProdutoRepository  extends JpaRepository<Produto, Long> {

	/**
	 * Método responsável por consultar produtos através de um determinado genero
	 * @param genero - GeneroEnum com opções para M e F
	 * @return List<Produto> - Lista de produtos encontrados
	 */
	List<Produto> findByGenero(GeneroEnum genero);
	
	/**
	 * Método responsável por consultar produtos através de um determinado texto que esteja presente na descrição do produto
	 * @param palavraChave - String com texto a ser procurado
	 * @return List<Produto> - Lista de produtos encontrados
	 */
	@Query("SELECT P FROM PRODUTO P WHERE P.descricao like %:palavraChave%")
	List<Produto> findByDescricao(String palavraChave);

	/**
	 * Método responsável por consultar os 3 Produtos com mais visualizações de uma determinada Categoria
	 * @param categoria - Objeto com categoria a ser procurada
	 * @return List<Produto> - Lista de produtos encontrados
	 */
	List<Produto> findTop3ByCategoriaOrderByQuantidadeVisualizacoesDesc(Categoria categoria);
	
}
