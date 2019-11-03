package br.com.fiap.ecommerce.produto.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.ecommerce.produto.model.Carrinho;
import br.com.fiap.ecommerce.produto.model.Pedido;
import br.com.fiap.ecommerce.produto.model.StatusCarrinhoEnum;
import br.com.fiap.ecommerce.produto.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private CarrinhoService carrinhoService;
	
	@Autowired
	private PedidosQueueSender pedidosQueueSender;
	
	public List<Pedido> findAll(Long idCliente) {
		return pedidoRepository.findByCliente(idCliente);
	}

	public Pedido getPedido(final Long id) {
		Pedido pedido = pedidoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado !"));

		return pedido;
	}

	
	public Pedido create(final Pedido pedido) {
		
		Carrinho carrinho = carrinhoService.getCarrinho(pedido.getCarrinho().getId());
		carrinho.setStatus(StatusCarrinhoEnum.FECHADO);
		carrinhoService.update(carrinho);
		
		Pedido created = pedidoRepository.save(pedido);
		
		ObjectMapper Obj = new ObjectMapper(); 
		  
        try { 
            String jsonStr = Obj.writeValueAsString(created); 
            pedidosQueueSender.send(jsonStr); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
		
		return created;
	}

	public Pedido update(final Pedido pedido) {
		if (pedido.getId() == null) {
			throw new EntityNotFoundException("Pedido nao foi encontrado para atualização !");
		}

		return pedidoRepository.save(pedido);
	}

	public void delete(final Long id) {
		if (id == null) {
			throw new EntityNotFoundException("Pedido não foi excluído !");
		}

		pedidoRepository.deleteById(id);
	}
}
