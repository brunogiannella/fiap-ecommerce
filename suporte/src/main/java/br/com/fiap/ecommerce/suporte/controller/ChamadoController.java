package br.com.fiap.ecommerce.suporte.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.suporte.model.Chamado;
import br.com.fiap.ecommerce.suporte.service.ChamadoService;

@RestController
@RequestMapping("chamados")
public class ChamadoController {


    @Autowired
    private ChamadoService chamadoService;


    @GetMapping
    public ResponseEntity<List<Chamado>> findAll() {
        return ResponseEntity.ok(chamadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chamado> findById(@PathVariable("id") final Long id) {
    	try {
			return ResponseEntity.ok(chamadoService.getChamado(id));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
    }

    @PostMapping
    public ResponseEntity<Chamado> create(@RequestBody final Chamado chamado) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(chamadoService.create(chamado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chamado> update(@PathVariable("id") final Long id, @RequestBody final Chamado chamado) {
    	chamado.setId(id);
    	Chamado prod = chamadoService.getChamado(id);

		if (prod == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.ok(chamadoService.update(chamado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") final Long id) {
    	Chamado prod = chamadoService.getChamado(id);

		if (prod == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		chamadoService.delete(id);
		return ResponseEntity.ok(null);
    }
}
