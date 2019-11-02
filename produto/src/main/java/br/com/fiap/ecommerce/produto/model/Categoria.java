package br.com.fiap.ecommerce.produto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "CATEGORIA")
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2956232103592847201L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
	private Long id;
	
	@Column(name = "DESCRICAO")
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
