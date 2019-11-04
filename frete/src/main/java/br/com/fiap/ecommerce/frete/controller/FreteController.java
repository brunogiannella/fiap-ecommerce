package br.com.fiap.ecommerce.frete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.frete.model.Frete;
import br.com.fiap.ecommerce.frete.service.FreteService;

/**
 * Classe responsável pelo controlador e exposição das APIs REST de Frete
 * @author Bruno Giannella
 *
 */
@RestController
@RequestMapping("calculos-frete")
public class FreteController {
    @Autowired
    private FreteService freteService;

    /**
     * Método responsável por calcular o frete a partir de um determinado CEP
     * @param cep - parâmetro de entrada identificador do CEP para calcular o frete
     * @return Frete - objeto com resultado do calculo
     */
    @GetMapping("/{cep}")
    public Frete findByCpf(@PathVariable("cep") final String cep) {
        return freteService.calcularFrete(cep);
    }
}
