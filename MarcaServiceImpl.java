package br.unitins.topicos1.guitar.service;

import java.util.List;

import br.unitins.topicos1.guitar.dto.MarcaDTO;
import br.unitins.topicos1.guitar.model.Marca;
import br.unitins.topicos1.guitar.repository.MarcaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class MarcaServiceImpl implements MarcaService {

    @Inject
    MarcaRepository repository;

    @Override
    public List<Marca> findAll() {
        return repository.listAll();
    }

    @Override
    public List<Marca> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    public Marca findById(Long id) {
        Marca marca = repository.findById(id);
        if (marca == null) {
            throw new NotFoundException("Marca não encontrada com o ID: " + id);
        }
        return marca;
    }

    @Transactional
    @Override
    public Marca create(MarcaDTO dto) {
        Marca marca = new Marca();
        marca.setNome(dto.nome());

        repository.persist(marca);
        return marca;
    }

    @Transactional
    @Override
    public Marca update(Long id, MarcaDTO dto) {
        Marca marca = repository.findById(id);
        if (marca == null) {
            throw new NotFoundException("Marca não encontrada com o ID: " + id);
        }

        marca.setNome(dto.nome());
        repository.persist(marca);
        return marca;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Marca marca = repository.findById(id);
        if (marca == null) {
            throw new NotFoundException("Marca não encontrada com o ID: " + id);
        }
        repository.delete(marca);
    }
}
