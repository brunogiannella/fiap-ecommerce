package br.com.fiap.ecommerce.pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.ecommerce.pedido.model.Pedido;
import br.com.fiap.ecommerce.pedido.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {


    @Autowired
    private PedidoService pedidoService;


    @GetMapping
    public List<Pedido> findAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public Pedido findByCpf(@PathVariable("id") final Long id) {
        return pedidoService.getPedido(id);
    }

    @PostMapping
    public Pedido create(@RequestBody final Pedido pedido) {
        return pedidoService.create(pedido);
    }

    @PutMapping("/{id}")
    public Pedido update(@PathVariable("id") final Long id, @RequestBody final Pedido pedido) {
    	pedido.setId(id);
        return pedidoService.update(pedido);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("id") final Long id) {
    	pedidoService.delete(id);
    }
}
