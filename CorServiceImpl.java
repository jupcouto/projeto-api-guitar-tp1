package br.unitins.topicos1.guitar.service;

import java.util.List;

import br.unitins.topicos1.guitar.dto.CorDTO;
import br.unitins.topicos1.guitar.model.Cor;
import br.unitins.topicos1.guitar.repository.CorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CorServiceImpl implements CorService {

    @Inject
    CorRepository repository;

    @Override
    public List<Cor> findAll() {
        return repository.listAll();
    }

    @Override
    public List<Cor> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    public Cor findById(Long id) {
        Cor cor = repository.findById(id);
        if (cor == null) {
            throw new NotFoundException("Cor não encontrada com o ID: " + id);
        }
        return cor;
    }

    @Transactional
    @Override
    public Cor create(CorDTO dto) {
        Cor cor = new Cor();
        cor.setNome(dto.nome());
        repository.persist(cor);
        return cor;
    }

    @Transactional
    @Override
    public Cor update(Long id, CorDTO dto) {
        Cor cor = repository.findById(id);
        if (cor == null) {
            throw new NotFoundException("Cor não encontrada com o ID: " + id);
        }

        cor.setNome(dto.nome());
        repository.persist(cor);
        return cor;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Cor cor = repository.findById(id);
        if (cor == null) {
            throw new NotFoundException("Cor não encontrada com o ID: " + id);
        }
        repository.delete(cor);
    }
}
