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

import br.com.fiap.ecommerce.produto.model.Carrinho;
import br.com.fiap.ecommerce.produto.model.ItemCarrinho;
import br.com.fiap.ecommerce.produto.model.StatusCarrinhoEnum;
import br.com.fiap.ecommerce.produto.service.CarrinhoService;
import br.com.fiap.ecommerce.produto.service.ItemCarrinhoService;

@RestController
@RequestMapping("carrinhos")
public class CarrinhoController {

	@Autowired
	private CarrinhoService carrinhoService;

	@Autowired
	private ItemCarrinhoService itemCarrinhoService;

	@GetMapping
	public ResponseEntity<List<Carrinho>> findAll(@RequestParam Long idCliente) {
		return ResponseEntity.ok(carrinhoService.findAll(idCliente));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Carrinho> findById(@PathVariable("id") final Long id) {
		try {
			return ResponseEntity.ok(carrinhoService.getCarrinho(id));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping
	public ResponseEntity<Carrinho> create(@RequestBody final Carrinho carrinho) {
		
		if(carrinhoService.getCarrinhoAbertoByUser(carrinho.getIdCliente()).size() > 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		carrinho.setStatus(StatusCarrinhoEnum.ABERTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoService.create(carrinho));
	}

	@PostMapping("/{id}/itens")
	public ResponseEntity<Carrinho> adicionarItem(@PathVariable("id") final Long id,
			@RequestBody final ItemCarrinho item) {
		Carrinho prod = carrinhoService.getCarrinho(id);

		if (prod == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		prod.setId(id);

		item.setCarrinho(prod);
		itemCarrinhoService.create(item);

		return ResponseEntity.ok(carrinhoService.getCarrinho(id));
	}

	@DeleteMapping("/{id}/itens/{idItem}")
	public ResponseEntity<Carrinho> adicionarItem(@PathVariable("id") final Long id,
			@PathVariable("idItem") final Long idItem) {
		itemCarrinhoService.delete(idItem);
		return ResponseEntity.ok(null);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") final Long id) {
		Carrinho prod = carrinhoService.getCarrinho(id);

		if (prod == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		prod.setId(id);
		prod.setStatus(StatusCarrinhoEnum.CANCELADO);

		carrinhoService.update(prod);
		return ResponseEntity.ok(null);
	}
}
