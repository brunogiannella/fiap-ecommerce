package br.com.fiap.ecommerce.produto.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.fiap.ecommerce.produto.model.Carrinho;
import br.com.fiap.ecommerce.produto.model.Cliente;
import br.com.fiap.ecommerce.produto.model.StatusCarrinhoEnum;
import br.com.fiap.ecommerce.produto.repository.CarrinhoRepository;

/**
 * Classe responsável pelos serviços relacionados aos Carrinho de um pedido
 * 
 * @author Bruno Giannella
 *
 */
@Service
public class CarrinhoService {

	@Autowired
	private CarrinhoRepository carrinhoRepository;

	@Autowired
	private RestTemplate restTemplate;

	public List<Carrinho> findAll(Long idCliente) {
		return carrinhoRepository.findByIdCliente(idCliente);
	}

	public Carrinho getCarrinho(final Long id) {
		Carrinho produto = carrinhoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado !"));

		return produto;
	}

	public List<Carrinho> getCarrinhoAbertoByUser(final Long idCliente) {
		return carrinhoRepository.findByIdClienteAndStatus(idCliente, StatusCarrinhoEnum.ABERTO);
	}

	public Carrinho create(final Carrinho carrinho) {
		Cliente cliente = consultarCliente(carrinho.getIdCliente());
		
		if(cliente.getCpf() != null) {
			return carrinhoRepository.save(carrinho);
		} else {
			throw new EntityNotFoundException("Cliente não encontrado !");
		}
		
	}

	@HystrixCommand(fallbackMethod = "defaultUserFallback")
	private Cliente consultarCliente(Long idCliente) {
		try {
			Cliente cliente = null;
			cliente = restTemplate.getForObject("http://localhost:8075/api/clientes/v1/clientes/" + idCliente, Cliente.class);
			return cliente;
		} catch (Exception e) {
			throw new EntityNotFoundException("Cliente não encontrado !");
		}
	}

	private Cliente defaultUserFallback(Long idCliente) {
		Cliente cliente = new Cliente();
		cliente.setCpf("41766098851");
		
		return cliente;
	}
	
	public Carrinho update(final Carrinho carrinho) {
		if (carrinho.getId() == null) {
			throw new EntityNotFoundException("Carrinho nao foi encontrado para atualização !");
		}

		return carrinhoRepository.save(carrinho);
	}

	public void delete(final Long id) {
		if (id == null) {
			throw new EntityNotFoundException("Carrinho não foi excluído !");
		}

		carrinhoRepository.deleteById(id);
	}
}
