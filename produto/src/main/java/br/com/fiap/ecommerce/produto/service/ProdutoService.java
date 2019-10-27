package br.com.fiap.ecommerce.produto.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.produto.model.Produto;
import br.com.fiap.ecommerce.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto getPedido(final Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado !"));
    }

    // Pattern fallback caso exista algum problema na consulta de CPFs no sistema
    public Produto buildFallbackGetPedido(Long id){
    	Produto pedido = new Produto();
        return pedido;
    }


    public Produto create(final Produto cliente) {
        return produtoRepository.save(cliente);
    }


    public Produto update(final Produto cliente) {
        if(cliente.getId()== null) {
            throw new EntityNotFoundException("Produto nao foi encontrado para atualização !");
        }

        return produtoRepository.save(cliente);
    }

    public void delete(final Long id) {
        if(id == null) {
            throw new EntityNotFoundException("Produto não foi excluído !");
        }

        produtoRepository.deleteById(id);
    }
}
