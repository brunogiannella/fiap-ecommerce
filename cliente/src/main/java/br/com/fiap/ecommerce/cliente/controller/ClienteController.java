package br.com.fiap.ecommerce.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.ecommerce.cliente.model.Cliente;
import br.com.fiap.ecommerce.cliente.service.ClienteService;

import java.util.List;

@RestController(value = "/clientes")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{cpf}")
    public Cliente findByCpf(@PathVariable("cpf") final String cpf) {
        return clienteService.findbyCpf(cpf);
    }

    @PostMapping
    public Cliente create(@RequestBody final Cliente cliente) {
        return clienteService.create(cliente);
    }

    @PutMapping("/{cpf}")
    public Cliente update(@PathVariable("cpf") final String cpf, @RequestBody final Cliente cliente) {
    	cliente.setCpf(cpf);
        return clienteService.update(cliente);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") final String cpf) {
        clienteService.delete(cpf);
    }
}
