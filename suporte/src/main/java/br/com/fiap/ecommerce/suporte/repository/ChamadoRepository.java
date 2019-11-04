package br.com.fiap.ecommerce.suporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ecommerce.suporte.model.Chamado;

/**
 * Classe responsável pela interface de comunicação com o banco de dados mysql da tabela de Chamado
 * @author Bruno Giannella
 *
 */
public interface ChamadoRepository  extends JpaRepository<Chamado, Long> {

}
