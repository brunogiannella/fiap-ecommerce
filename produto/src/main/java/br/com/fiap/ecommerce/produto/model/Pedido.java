package br.com.fiap.ecommerce.produto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5478952030910970309L;

	private Long id;

	private Carrinho carrinho;

	private String status;

	private Date dataPedido;

	private Date dataEntrega;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

}
