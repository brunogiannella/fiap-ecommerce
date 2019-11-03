package br.com.fiap.ecommerce.produto.model;

import java.io.Serializable;
import java.util.Date;

public class ItemCarrinho implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7131427003985042772L;

	private Long id;
	
	private Long idProduto;
	
	private Long quantidadeProduto;
	
	private Date dataAddItem;
	
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
