package br.com.fiap.ecommerce.produto.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.produto.model.Categoria;
import br.com.fiap.ecommerce.produto.model.GeneroEnum;
import br.com.fiap.ecommerce.produto.model.Produto;
import br.com.fiap.ecommerce.produto.repository.ProdutoRepository;

/**
 * Classe responsável pelos serviços relacionados aos Produtos da plataforma
 * @author Bruno Giannella
 *
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Método responsável por consultar todos os produtos na base de dados
     * @return List<Produto> - lista de produtos retornados
     */
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
    
    /**
     * Método responsável por retornar os produtos de um determinado Genero
     * @param gender - GeneroEnum com opções M e F
     * @return List<Produto> - lista de produtos retornados
     */
    public List<Produto> findByGenero(GeneroEnum gender) {
        return produtoRepository.findByGenero(gender);
    }
    
    /**
     * Método responsável por retornar os 3 produtos mais visualizados de uma determinada Categoria
     * @param idCategoria - Identificador da Categoria
     * @return List<Produto> - lista de produtos retornados
     */
    public List<Produto> findTop3ByCategoria(Long idCategoria) {
    	Categoria categoria = new Categoria();
    	categoria.setId(idCategoria);
        return produtoRepository.findTop3ByCategoriaOrderByQuantidadeVisualizacoesDesc(categoria);
    }

    /**
     * Método responsável por retornar um determinado produto da base de dados
     * @param id - Identificador do produto
     * @return Produto - Produto consultado através do ID
     */
    public Produto getProduto(final Long id) {
        Produto produto =  produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado !"));
        
        produto.setQuantidadeVisualizacoes(produto.getQuantidadeVisualizacoes() + 1);
        update(produto);
        
        return produto;
    }

    /**
     * Método responsável por inserir um produto na base de dados
     * @param produto - Objeto Produto
     * @return Produto - Objeto do produto após inserção na base
     */
    public Produto create(final Produto produto) {
    	produto.setQuantidadeVisualizacoes(0L);
        return produtoRepository.save(produto);
    }


    /**
     * Método reposonsável por atualizar um produto na base de dados
     * @param produto - Objeto Produto (model)
     * @return Produto - Objeto do produto após atualização na base
     */
    public Produto update(final Produto produto) {
        if(produto.getId()== null) {
            throw new EntityNotFoundException("Produto nao foi encontrado para atualização !");
        }

        return produtoRepository.save(produto);
    }

    /**
     * Método responsável por remover um produto da base de dados
     * @param id - Identificador do produto
     */
    public void delete(final Long id) {
        if(id == null) {
            throw new EntityNotFoundException("Produto não foi excluído !");
        }

        produtoRepository.deleteById(id);
    }

    /**
     * Método responsável por consultar produtor através de palavras chave na descrição
     * @param palavraChave - Palavra chave a ser consultada
     * @return List<Produto> - lista de produtos retornados
     */
    public List<Produto> findBy(String palavraChave) {
    	return produtoRepository.findByDescricao(palavraChave);
	}
}
