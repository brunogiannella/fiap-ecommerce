package br.com.fiap.ecommerce.suporte.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.suporte.model.Chamado;
import br.com.fiap.ecommerce.suporte.repository.ChamadoRepository;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();
    }

    public Chamado getPedido(final Long id) {
        return chamadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado !"));
    }

    // Pattern fallback caso exista algum problema na consulta de CPFs no sistema
    public Chamado buildFallbackGetPedido(Long id){
    	Chamado pedido = new Chamado();
        return pedido;
    }


    public Chamado create(final Chamado chamado) {
        return chamadoRepository.save(chamado);
    }


    public Chamado update(final Chamado chamado) {
        if(chamado.getId()== null) {
            throw new EntityNotFoundException("Chamado nao foi encontrado para atualização !");
        }

        return chamadoRepository.save(chamado);
    }

    public void delete(final Long id) {
        if(id == null) {
            throw new EntityNotFoundException("Chamado não foi excluído !");
        }

        chamadoRepository.deleteById(id);
    }
}
