package br.com.fiap.ecommerce.suporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.ecommerce.suporte.model.Chamado;
import br.com.fiap.ecommerce.suporte.service.ChamadoService;

import java.util.List;

@RestController
@RequestMapping("chamados")
public class ChamadoController {


    @Autowired
    private ChamadoService chamadoService;


    @GetMapping
    public List<Chamado> findAll() {
        return chamadoService.findAll();
    }

    @GetMapping("/{id}")
    public Chamado findByCpf(@PathVariable("id") final Long id) {
        return chamadoService.getPedido(id);
    }

    @PostMapping
    public Chamado create(@RequestBody final Chamado chamado) {
        return chamadoService.create(chamado);
    }

    @PutMapping("/{id}")
    public Chamado update(@PathVariable("id") final Long id, @RequestBody final Chamado chamado) {
    	chamado.setId(id);
        return chamadoService.update(chamado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
    	chamadoService.delete(id);
    }
}
