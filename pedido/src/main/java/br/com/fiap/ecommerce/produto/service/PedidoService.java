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

/**
 * Classe responsável pelos serviços relacionados aos Pedidos
 * @author Bruno Giannella
 *
 */
@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private CarrinhoService carrinhoService;
	
	@Autowired
	private PedidosQueueSender pedidosQueueSender;
	
	/**
	 * Método responsável por consultar pedidos na base de dados através de um cliente
	 * @param idCliente - Identificador do cliente (CPF)
	 * @return List<Pedido> - Lista de objetos Pedido retornados da base de dados
	 */
	public List<Pedido> findAll(Long idCliente) {
		return pedidoRepository.findByCliente(idCliente);
	}

	/**
	 * Método responsável por consultar um determinado pedido na base de dados através do ID do Produto
	 * @param id - Identificador do Produto (ID)
	 * @return Pedido - Objeto retornado da base de dados
	 */
	public Pedido getPedido(final Long id) {
		Pedido pedido = pedidoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado !"));

		return pedido;
	}

	
	/**
	 * Método responsável por criar um pedido através de um determinado carrinho
	 * Método também responsável por fechar um carrinho
	 * Método responsável também por enviar a uma fila de Pedidos as informações
	 * @param pedido - Objeto Pedido (model)
	 * @return Pedido - Objeto pedido retornado após inserção na base de dados
	 */
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

	/**
	 * Método responsável por atualizar um Pedido na base de dados
	 * @param pedido - Objeto Pedido (model)
	 * @return Pedido - Objeto após atualização na base de dados
	 */
	public Pedido update(final Pedido pedido) {
		if (pedido.getId() == null) {
			throw new EntityNotFoundException("Pedido nao foi encontrado para atualização !");
		}

		return pedidoRepository.save(pedido);
	}

	/**
	 * Método responsável por remover um Pedido na base de dados
	 * @param id - Identificador do Pedido (ID)
	 */
	public void delete(final Long id) {
		if (id == null) {
			throw new EntityNotFoundException("Pedido não foi excluído !");
		}

		pedidoRepository.deleteById(id);
	}
}
