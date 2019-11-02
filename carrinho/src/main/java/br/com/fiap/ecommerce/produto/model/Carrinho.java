package br.com.fiap.ecommerce.produto.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "CARRINHO")
public class Carrinho implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5478952030910970309L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ID_CLIENTE")
	private Long idCliente;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private StatusCarrinhoEnum status;

	@OneToMany(mappedBy = "carrinho")
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

	public StatusCarrinhoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusCarrinhoEnum status) {
		this.status = status;
	}

	public List<ItemCarrinho> getItensCarrinho() {
		return itensCarrinho;
	}

	public void setItensCarrinho(List<ItemCarrinho> itensCarrinho) {
		this.itensCarrinho = itensCarrinho;
	}

}
