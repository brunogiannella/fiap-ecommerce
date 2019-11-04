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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.produto.model.Carrinho;
import br.com.fiap.ecommerce.produto.model.ItemCarrinho;
import br.com.fiap.ecommerce.produto.model.StatusCarrinhoEnum;
import br.com.fiap.ecommerce.produto.service.CarrinhoService;
import br.com.fiap.ecommerce.produto.service.ItemCarrinhoService;

/**
 * Classe responsável pelo controlador e exposição das APIs REST de carrinhos
 * @author Bruno Giannella
 *
 */
@RestController
@RequestMapping("carrinhos")
public class CarrinhoController {

	@Autowired
	private CarrinhoService carrinhoService;

	@Autowired
	private ItemCarrinhoService itemCarrinhoService;

	/**
	 * Método responsável por consultar todos os carrinhos de um determinado cliente
	 * @param idCliente - Identificador do cliente (CPF)
	 * @return ResponseEntity - retorna uma lista de carrinhos de um determinado cliente
	 */
	@GetMapping
	public ResponseEntity<List<Carrinho>> findAll(@RequestParam Long idCliente) {
		return ResponseEntity.ok(carrinhoService.findAll(idCliente));
	}

	/**
	 * Método responsável por consultar um carrinho de compras pelo ID
	 * @param id - identificador do carrinho
	 * @return ResponseEntity - retorna um Carrinho de compras
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Carrinho> findById(@PathVariable("id") final Long id) {
		try {
			return ResponseEntity.ok(carrinhoService.getCarrinho(id));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	/**
	 * Método responsável por criar um carrinho de compras
	 * @param carrinho - Objeto carrinho, contendo todas as informações dos carrinhos e itens
	 * @return ResponseEntity - retorna o carrinho criado
	 */
	@PostMapping
	public ResponseEntity<Carrinho> create(@RequestBody final Carrinho carrinho) {
		
		if(carrinhoService.getCarrinhoAbertoByUser(carrinho.getIdCliente()).size() > 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		try {
			carrinho.setStatus(StatusCarrinhoEnum.ABERTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoService.create(carrinho));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	}

	/**
	 * Método responsável por adicionar item ao carrinho
	 * @param id - identificador do carrinho
	 * @param item - objeto ItemCarrinho a ser adicionado
	 * @return ResponseEntity - retorna o carrinho já com as alterações
	 */
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

	/**
	 * Método responsável por remover item do carrinho
	 * @param id - identificador do carrinho
	 * @param item - id do item do carrinho a ser removido
	 * @return ResponseEntity - retorna o carrinho já com as alterações
	 */
	@DeleteMapping("/{id}/itens/{idItem}")
	public ResponseEntity<Carrinho> adicionarItem(@PathVariable("id") final Long id,
			@PathVariable("idItem") final Long idItem) {
		itemCarrinhoService.delete(idItem);
		return ResponseEntity.ok(null);
	}

	/**
	 * Método responsável por cancelar um carrinho de compras do cliente
	 * @param id - identificador do carrinho de compras do cliente
	 * @return ResponseEntity - retorno do status code 200 em caso de sucesso
	 */
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
