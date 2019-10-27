package br.com.fiap.ecommerce.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.ecommerce.produto.model.Produto;
import br.com.fiap.ecommerce.produto.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Produto findByCpf(@PathVariable("id") final Long id) {
        return produtoService.getPedido(id);
    }

    @PostMapping
    public Produto create(@RequestBody final Produto produto) {
        return produtoService.create(produto);
    }

    @PutMapping("/{id}")
    public Produto update(@PathVariable("id") final Long id, @RequestBody final Produto produto) {
    	produto.setId(id);
        return produtoService.update(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
    	produtoService.delete(id);
    }
}
