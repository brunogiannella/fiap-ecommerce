package br.com.fiap.ecommerce.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.produto.model.Categoria;
import br.com.fiap.ecommerce.produto.service.CategoriaService;

/**
 * Classe responsável pelo controlador e exposição das APIs REST de Categorias
 * @author Bruno Giannella
 *
 */
@RestController
@RequestMapping("categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	/**
	 * Método responsável por criar uma nova categoria no sistema
	 * @param categoria - Objeto Categoria enviado como entrada para cadastro
	 * @return Categoria - Objeto criado na base de dados
	 */
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody final Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.create(categoria));
	}
	
}
