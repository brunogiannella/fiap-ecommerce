package br.com.fiap.ecommerce.cliente.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.cliente.model.Cliente;
import br.com.fiap.ecommerce.cliente.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findbyCpf(final String cpf) {
        return clienteRepository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("CPF: " + cpf + " não encontrado !"));
    }

    // Pattern fallback caso exista algum problema na consulta de CPFs no sistema
    public Cliente buildFallbackGetCpf(String cpf){

        Cliente clienteDomain = new Cliente();
        clienteDomain.setNome("Cliente padrão do Sistema");
        clienteDomain.setEndereco("Rua de Teste");
        clienteDomain.setCpf("123.456.789-10");
        clienteDomain.setCep("00000-000");
        clienteDomain.setTelefone("0111234-5678");

        return clienteDomain;
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
