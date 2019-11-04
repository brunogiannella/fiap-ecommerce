package br.com.fiap.ecommerce.frete.service;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.frete.model.Frete;

/**
 * Classe responsável pelo serviço de calculo do frete
 * @author Bruno Giannella
 *
 */
@Service
public class FreteService {

	/**
	 * Método responsável por consultar o valor de um frete para um determinado CEP
	 * @param cep - CEP informado para consulta
	 * @return Frete - objeto contendo informações sobre o calculo
	 */
	public Frete calcularFrete(String cep) {
		Random gerador = new Random();
		
		Frete frete = new Frete();
		frete.setCep(cep);
		frete.setValor(new BigDecimal(gerador.nextInt(50) * 0.35).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		frete.setQuantidadeDiasEntrega(gerador.nextInt(30));
		
		return frete;
	}

}
