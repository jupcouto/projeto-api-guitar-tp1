package br.unitins.topicos1.guitar.service;

import java.util.List;

import br.unitins.topicos1.guitar.dto.MaterialDTO;
import br.unitins.topicos1.guitar.model.Material;
import br.unitins.topicos1.guitar.repository.MaterialRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class MaterialServiceImpl implements MaterialService {

    @Inject
    MaterialRepository repository;

    @Override
    public List<Material> findAll() {
        return repository.listAll();
    }

    @Override
    public List<Material> findByDescricao(String descricao) {
        return repository.findByDescricao(descricao);
    }

    @Override
    public Material findById(Long id) {
        Material material = repository.findById(id);
        if (material == null) {
            throw new NotFoundException("Material não encontrado com o ID: " + id);
        }
        return material;
    }

    @Transactional
    @Override
    public Material create(MaterialDTO dto) {
        Material material = new Material();
        material.setDescricao(dto.descricao());
        repository.persist(material);
        return material;
    }

    @Transactional
    @Override
    public Material update(Long id, MaterialDTO dto) {
        Material material = repository.findById(id);
        if (material == null) {
            throw new NotFoundException("Material não encontrado com o ID: " + id);
        }

        material.setDescricao(dto.descricao());
        repository.persist(material);
        return material;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Material material = repository.findById(id);
        if (material == null) {
            throw new NotFoundException("Material não encontrado com o ID: " + id);
        }
        repository.delete(material);
    }
}
