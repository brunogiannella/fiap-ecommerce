package br.com.fiap.ecommerce.pedido.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.pedido.model.Pedido;
import br.com.fiap.ecommerce.pedido.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedido(final Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado !"));
    }

    // Pattern fallback caso exista algum problema na consulta de CPFs no sistema
    public Pedido buildFallbackGetPedido(Long id){
    	Pedido pedido = new Pedido();
        return pedido;
    }


    public Pedido create(final Pedido cliente) {
        return pedidoRepository.save(cliente);
    }


    public Pedido update(final Pedido cliente) {
        if(cliente.getId()== null) {
            throw new EntityNotFoundException("Pedido nao foi encontrado para atualização !");
        }

        return pedidoRepository.save(cliente);
    }

    public void delete(final Long id) {
        if(id == null) {
            throw new EntityNotFoundException("Pedido não foi excluído !");
        }

        pedidoRepository.deleteById(id);
    }
}
