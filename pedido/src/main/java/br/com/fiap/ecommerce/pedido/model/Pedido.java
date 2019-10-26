package br.com.fiap.ecommerce.pedido.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "PEDIDO")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5478952030910970309L;

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "DESCRICAO")
	@ManyToOne
	private Categoria categoria;

	@Column(name = "GENERO")
	@Enumerated(EnumType.STRING)
	private GeneroEnum sexo;

	@Column(name = "CEP")
	private Long quantidadeEstoque;

	@Column(name = "DATA_NASCIMENTO")
	private Boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public GeneroEnum getSexo() {
		return sexo;
	}

	public void setSexo(GeneroEnum sexo) {
		this.sexo = sexo;
	}

	public Long getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Long quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}