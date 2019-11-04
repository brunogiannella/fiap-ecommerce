package br.com.fiap.ecommerce.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.produto.model.Categoria;
import br.com.fiap.ecommerce.produto.repository.CategoriaRepository;

/**
 * Classe responsável pelos serviços relacionados as Categorias de Produtos
 * @author Bruno Giannella
 *
 */
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    /**
     * Método responsável por inserir uma Categoria na base de dados
     * @param categoria - Objeto Categoria (model)
     * @return Categoria - Objeto retornado após inserção na base de dados
     */
    public Categoria create(final Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

}
