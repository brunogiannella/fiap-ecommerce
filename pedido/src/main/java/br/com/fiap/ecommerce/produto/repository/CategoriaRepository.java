package br.com.fiap.ecommerce.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ecommerce.produto.model.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {

}
