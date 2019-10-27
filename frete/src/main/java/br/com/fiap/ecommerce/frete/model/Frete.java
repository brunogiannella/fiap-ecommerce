package br.com.fiap.ecommerce.frete.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Frete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5478952030910970309L;

	private String cep;

	private BigDecimal valor;

	private Integer quantidadeDiasEntrega;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidadeDiasEntrega() {
		return quantidadeDiasEntrega;
	}

	public void setQuantidadeDiasEntrega(Integer quantidadeDiasEntrega) {
		this.quantidadeDiasEntrega = quantidadeDiasEntrega;
	}

}
