package br.com.fiap.ecommerce.produto.model;

import java.io.Serializable;
import java.util.List;

public class Carrinho implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8082861168551258884L;

	private Long id;

	private Long idCliente;

	private String status;

	private List<ItemCarrinho> itensCarrinho;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ItemCarrinho> getItensCarrinho() {
		return itensCarrinho;
	}

	public void setItensCarrinho(List<ItemCarrinho> itensCarrinho) {
		this.itensCarrinho = itensCarrinho;
	}

}
