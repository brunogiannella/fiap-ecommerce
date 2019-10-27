package br.com.fiap.ecommerce.suporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ecommerce.suporte.model.Chamado;

public interface ChamadoRepository  extends JpaRepository<Chamado, Long> {

}
