package br.com.fiap.ecommerce.produto.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.produto.model.Categoria;
import br.com.fiap.ecommerce.produto.model.GeneroEnum;
import br.com.fiap.ecommerce.produto.model.Produto;
import br.com.fiap.ecommerce.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
    
    public List<Produto> findByGenero(GeneroEnum gender) {
        return produtoRepository.findByGenero(gender);
    }
    
    public List<Produto> findTop3ByCategoria(Long idCategoria) {
    	Categoria categoria = new Categoria();
    	categoria.setId(idCategoria);
        return produtoRepository.findTop3ByCategoriaOrderByQuantidadeVisualizacoesDesc(categoria);
    }

    public Produto getPedido(final Long id) {
        Produto produto =  produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado !"));
        
        produto.setQuantidadeVisualizacoes(produto.getQuantidadeVisualizacoes() + 1);
        update(produto);
        
        return produto;
    }

    // Pattern fallback caso exista algum problema na consulta de CPFs no sistema
    public Produto buildFallbackGetPedido(Long id){
    	Produto pedido = new Produto();
        return pedido;
    }


    public Produto create(final Produto produto) {
    	produto.setQuantidadeVisualizacoes(0L);
        return produtoRepository.save(produto);
    }


    public Produto update(final Produto produto) {
        if(produto.getId()== null) {
            throw new EntityNotFoundException("Produto nao foi encontrado para atualização !");
        }

        return produtoRepository.save(produto);
    }

    public void delete(final Long id) {
        if(id == null) {
            throw new EntityNotFoundException("Produto não foi excluído !");
        }

        produtoRepository.deleteById(id);
    }

    public List<Produto> findBy(String palavraChave) {
    	return produtoRepository.findByDescricao(palavraChave);
	}
}
