package br.com.fiap.ecommerce.produto.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.produto.model.Carrinho;
import br.com.fiap.ecommerce.produto.model.StatusCarrinhoEnum;
import br.com.fiap.ecommerce.produto.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

	@Autowired
	private CarrinhoRepository carrinhoRepository;

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
		return carrinhoRepository.save(carrinho);
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
