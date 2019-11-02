package br.com.fiap.ecommerce.produto.service;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.produto.model.ItemCarrinho;
import br.com.fiap.ecommerce.produto.repository.ItemCarrinhoRepository;

@Service
public class ItemCarrinhoService {

	@Autowired
	private ItemCarrinhoRepository itemCarrinhoRepository;

	public ItemCarrinho create(final ItemCarrinho item) {
		item.setDataAddItem(new Date());
		return itemCarrinhoRepository.save(item);
	}

	public void delete(final Long id) {
		if (id == null) {
			throw new EntityNotFoundException("Item não foi excluído !");
		}

		itemCarrinhoRepository.deleteById(id);
	}
}
