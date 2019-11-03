package br.com.fiap.ecommerce.produto.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.produto.model.GeneroEnum;
import br.com.fiap.ecommerce.produto.model.Produto;
import br.com.fiap.ecommerce.produto.service.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll(@RequestParam(required = false) String genero,
			@RequestParam(required = false) String palavraChave) {

		if (genero != null && !genero.isEmpty()) {

			if (genero.equals(GeneroEnum.F.toString()) || genero.equals(GeneroEnum.M.toString())) {
				return ResponseEntity.ok(produtoService.findByGenero(GeneroEnum.valueOf(genero)));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}

		} else if (palavraChave != null && !palavraChave.isEmpty()) {
			return ResponseEntity.ok(produtoService.findBy(palavraChave));
		} else {
			return ResponseEntity.ok(produtoService.findAll());
		}

	}

	@GetMapping("/top3")
	public ResponseEntity<List<Produto>> findAll(@RequestParam(required = false) Long categoria) {

		if (categoria != null) {
			return ResponseEntity.ok(produtoService.findTop3ByCategoria(categoria));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable("id") final Long id) {
		try {
			return ResponseEntity.ok(produtoService.getProduto(id));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping
	public ResponseEntity<Produto> create(@RequestBody final Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.create(produto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable("id") final Long id, @RequestBody final Produto produto) {
		Produto prod = produtoService.getProduto(id);

		if (prod == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		produto.setId(id);
		return ResponseEntity.ok(produtoService.update(produto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") final Long id) {
		Produto prod = produtoService.getProduto(id);

		if (prod == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		produtoService.delete(id);
		return ResponseEntity.ok(null);
	}
}
