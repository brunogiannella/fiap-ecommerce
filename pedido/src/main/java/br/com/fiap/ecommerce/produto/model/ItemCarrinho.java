package br.com.fiap.ecommerce.produto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ITEM_CARRINHO")
public class ItemCarrinho implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7131427003985042772L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "ID_PRODUTO")
	private Long idProduto;
	
	@Column(name = "QUANTIDADE_PRODUTO")
	private Long quantidadeProduto;
	
	@Column(name = "DATA_ADD_ITEM")
	private Date dataAddItem;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CARRINHO")
	@JsonIgnore
    private Carrinho carrinho;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Date getDataAddItem() {
		return dataAddItem;
	}

	public void setDataAddItem(Date dataAddItem) {
		this.dataAddItem = dataAddItem;
	}

	public Long getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Long quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

}
