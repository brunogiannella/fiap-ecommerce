package br.com.fiap.ecommerce.cliente.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.cliente.model.Cliente;
import br.com.fiap.ecommerce.cliente.repository.ClienteRepository;

/**
 * Classe responsável pelos serviços relacionados aos Clientes da plataforma
 * @author Bruno Giannella
 *
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Método responsável por consultar todos os clientes na base de dados
     * @return List<Cliente> - lista de clientes retornados
     */
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findbyCpf(final String cpf) {
        return clienteRepository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("CPF: " + cpf + " não encontrado !"));
    }

    public Cliente create(final Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(final Cliente cliente) {
        if(cliente.getCpf()== null) {
            throw new EntityNotFoundException("CPF nao foi encontrado para atualização !");
        }

        return clienteRepository.save(cliente);
    }

    public void delete(final String cpf) {
        if(cpf == null) {
            throw new EntityNotFoundException("Cliente não foi excluído !");
        }

        clienteRepository.deleteById(cpf);
    }
}
