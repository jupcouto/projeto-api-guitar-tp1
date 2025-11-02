package br.unitins.topicos1.guitar.service;

import java.util.List;

import br.unitins.topicos1.guitar.dto.ModeloDTO;
import br.unitins.topicos1.guitar.model.Modelo;
import br.unitins.topicos1.guitar.repository.ModeloRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ModeloServiceImpl implements ModeloService {

    @Inject
    ModeloRepository repository;

    @Override
    public List<Modelo> findAll() {
        return repository.listAll();
    }

    @Override
    public List<Modelo> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    public Modelo findById(Long id) {
        Modelo modelo = repository.findById(id);
        if (modelo == null) {
            throw new NotFoundException("Modelo não encontrado com o ID: " + id);
        }
        return modelo;
    }

    @Transactional
    @Override
    public Modelo create(ModeloDTO dto) {
        Modelo modelo = new Modelo();
        modelo.setNome(dto.nome());
        modelo.setAnoFabricacao(dto.anoFabricacao());
        modelo.setEscala(dto.escala());

        repository.persist(modelo);
        return modelo;
    }

    @Transactional
    @Override
    public Modelo update(Long id, ModeloDTO dto) {
        Modelo modelo = repository.findById(id);
        if (modelo == null) {
            throw new NotFoundException("Modelo não encontrado com o ID: " + id);
        }

        modelo.setNome(dto.nome());
        modelo.setAnoFabricacao(dto.anoFabricacao());
        modelo.setEscala(dto.escala());

        repository.persist(modelo);
        return modelo;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Modelo modelo = repository.findById(id);
        if (modelo == null) {
            throw new NotFoundException("Modelo não encontrado com o ID: " + id);
        }
        repository.delete(modelo);
    }
}
