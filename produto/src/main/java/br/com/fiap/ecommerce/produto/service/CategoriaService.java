package br.com.fiap.ecommerce.produto.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.produto.model.Categoria;
import br.com.fiap.ecommerce.produto.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
    
    public Categoria getCategoria(final Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado !"));
    }

    public Categoria create(final Categoria categoria) {
        return categoriaRepository.save(categoria);
    }


    public Categoria update(final Categoria categoria) {
        if(categoria.getId()== null) {
            throw new EntityNotFoundException("Categoria nao foi encontrado para atualização!");
        }

        return categoriaRepository.save(categoria);
    }

    public void delete(final Long id) {
        if(id == null) {
            throw new EntityNotFoundException("Categoria não foi excluído!");
        }

        categoriaRepository.deleteById(id);
    }
}
