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

import br.com.fiap.ecommerce.produto.model.Pedido;
import br.com.fiap.ecommerce.produto.model.StatusPedidoEnum;
import br.com.fiap.ecommerce.produto.service.PedidoService;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(@RequestParam Long idCliente) {
		return ResponseEntity.ok(pedidoService.findAll(idCliente));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable("id") final Long id) {
		try {
			return ResponseEntity.ok(pedidoService.getPedido(id));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping
	public ResponseEntity<Pedido> create(@RequestBody final Pedido pedido) {
		pedido.setStatus(StatusPedidoEnum.RECEBIDO);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.create(pedido));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") final Long id) {
		Pedido prod = pedidoService.getPedido(id);

		if (prod == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		prod.setId(id);
		prod.setStatus(StatusPedidoEnum.CANCELADO);

		pedidoService.update(prod);
		return ResponseEntity.ok(null);
	}
}
