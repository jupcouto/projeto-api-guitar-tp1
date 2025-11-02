package br.unitins.topicos1.guitar.service;

import java.util.List;

import br.unitins.topicos1.guitar.dto.CategoriaDTO;
import br.unitins.topicos1.guitar.model.Categoria;
import br.unitins.topicos1.guitar.repository.CategoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CategoriaServiceImpl implements CategoriaService {

    @Inject
    CategoriaRepository repository;

    @Override
    public List<Categoria> findAll() {
        return repository.listAll();
    }

    @Override
    public List<Categoria> findByNome(String nome) {
        return repository.findByClassificacao(nome);
    }

    @Override
    public Categoria findById(Long id) {
        Categoria categoria = repository.findById(id);
        if (categoria == null) {
            throw new NotFoundException("Categoria não encontrada com o ID: " + id);
        }
        return categoria;
    }

    @Transactional
    @Override
    public Categoria create(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setClassificacao(dto.classificacao());
        repository.persist(categoria);
        return categoria;
    }

    @Transactional
    @Override
    public Categoria update(Long id, CategoriaDTO dto) {
        Categoria categoria = repository.findById(id);
        if (categoria == null) {
            throw new NotFoundException("Categoria não encontrada com o ID: " + id);
        }

        categoria.setClassificacao(dto.classificacao());
        repository.persist(categoria);
        return categoria;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Categoria categoria = repository.findById(id);
        if (categoria == null) {
            throw new NotFoundException("Categoria não encontrada com o ID: " + id);
        }
        repository.delete(categoria);
    }
}
