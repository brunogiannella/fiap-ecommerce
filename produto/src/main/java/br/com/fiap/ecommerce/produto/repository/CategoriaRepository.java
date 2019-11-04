package br.com.fiap.ecommerce.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ecommerce.produto.model.Categoria;

/**
 * Classe responsável pela interface de comunicação com o banco de dados mysql da tabela de Categoria
 * @author Bruno Giannella
 *
 */
public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {

}
