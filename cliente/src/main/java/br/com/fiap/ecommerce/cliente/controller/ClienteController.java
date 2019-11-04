package br.com.fiap.ecommerce.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.ecommerce.cliente.model.Cliente;
import br.com.fiap.ecommerce.cliente.service.ClienteService;

import java.util.List;

/**
 * Classe responsável pelo controlador e exposição das APIs REST de clientes
 * @author Bruno Giannella
 *
 */
@RestController
@RequestMapping("clientes")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;


    /**
     * Método responsável por consultar todos os clientes
     * @return List<Cliente> - Lista de clientes
     */
    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    /**
     * Método responsável por consultar um cliente através do CPF
     * @param cpf - Identificador do cliente
     * @return Cliente - Objeto cliente que representa um cliente do Ecommerce
     */
    @GetMapping("/{cpf}")
    public Cliente findByCpf(@PathVariable("cpf") final String cpf) {
        return clienteService.findbyCpf(cpf);
    }

    /**
     * Método resppnsável por inserir um cliente
     * @param cliente - Objeto cliente enviado como entrada da API
     * @return Cliente - Objeto do cliente criado pela aplicação
     */
    @PostMapping
    public Cliente create(@RequestBody final Cliente cliente) {
        return clienteService.create(cliente);
    }

    /**
     * Método responsável por atualizar um cliente da aplicação
     * @param cpf - Identificador do cliente (CPF)
     * @param cliente - Objeto cliente com as novas informações
     * @return Cliente- Objeto Cliente após atualização
     */
    @PutMapping("/{cpf}")
    public Cliente update(@PathVariable("cpf") final String cpf, @RequestBody final Cliente cliente) {
    	cliente.setCpf(cpf);
        return clienteService.update(cliente);
    }

    /**
     * Método responsável por remover um cliente da aplicação
     * @param cpf - Identificador do cliente (CPF)
     */
    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") final String cpf) {
        clienteService.delete(cpf);
    }
}
