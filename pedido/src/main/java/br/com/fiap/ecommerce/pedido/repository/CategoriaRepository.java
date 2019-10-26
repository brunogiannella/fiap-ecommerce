package br.com.fiap.ecommerce.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ecommerce.pedido.model.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {

}
