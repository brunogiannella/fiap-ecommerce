package br.com.fiap.ecommerce.produto.service;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.produto.model.ItemCarrinho;
import br.com.fiap.ecommerce.produto.repository.ItemCarrinhoRepository;

/**
 * Classe responsável pelos serviços relacionados aos Itens de Carrinho de um pedido
 * @author Bruno Giannella
 *
 */
@Service
public class ItemCarrinhoService {

	@Autowired
	private ItemCarrinhoRepository itemCarrinhoRepository;

	/**
	 * Método responsável por inserir um Item no carrinho na base de dados
	 * @param item - Objeto ItemCarrinho (model)
	 * @return ItemCarrinho - Objeto retornado após inclusão na base de dados
	 */
	public ItemCarrinho create(final ItemCarrinho item) {
		item.setDataAddItem(new Date());
		return itemCarrinhoRepository.save(item);
	}

	/**
	 * Método responsável por remover um Item do Carrinho da base de dados
	 * @param id - Identificador do Item
	 */
	public void delete(final Long id) {
		if (id == null) {
			throw new EntityNotFoundException("Item não foi excluído !");
		}

		itemCarrinhoRepository.deleteById(id);
	}
}
