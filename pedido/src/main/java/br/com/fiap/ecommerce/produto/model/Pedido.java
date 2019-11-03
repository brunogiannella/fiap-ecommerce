package br.com.fiap.ecommerce.produto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "PEDIDO")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5478952030910970309L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@OneToOne
	@JoinColumn(name = "ID_CARRINHO")
	private Carrinho carrinho;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private StatusPedidoEnum status;

	@Column(name = "DATA_PEDIDO")
	private Date dataPedido;

	@Column(name = "DATA_ENTREGA")
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

	public StatusPedidoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusPedidoEnum status) {
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
