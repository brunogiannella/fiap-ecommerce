package br.com.fiap.ecommerce.produto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "PRODUTO")
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5478952030910970309L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DESCRICAO")
	private String descricao;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORIA_ID")
	private Categoria categoria;

	@Column(name = "GENERO")
	@Enumerated(EnumType.STRING)
	private GeneroEnum genero;

	@Column(name = "QUANTIDADE_ESTOQUE")
	private Long quantidadeEstoque;

	@Column(name = "QUANTIDADE_VISUALIZACOES")
	private Long quantidadeVisualizacoes;

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

	public GeneroEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}

	public Long getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Long quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Long getQuantidadeVisualizacoes() {
		return quantidadeVisualizacoes;
	}

	public void setQuantidadeVisualizacoes(Long quantidadeVisualizacoes) {
		this.quantidadeVisualizacoes = quantidadeVisualizacoes;
	}

}
