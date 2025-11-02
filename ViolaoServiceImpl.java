package br.unitins.topicos1.guitar.service;

import java.util.List;

import br.unitins.topicos1.guitar.dto.ViolaoDTO;
import br.unitins.topicos1.guitar.model.Cor;
import br.unitins.topicos1.guitar.model.Modelo;
import br.unitins.topicos1.guitar.model.Violao;
import br.unitins.topicos1.guitar.repository.CorRepository;
import br.unitins.topicos1.guitar.repository.ModeloRepository;
import br.unitins.topicos1.guitar.repository.ViolaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ViolaoServiceImpl implements ViolaoService {

    @Inject
    ViolaoRepository repository;

    @Inject
    ModeloRepository repositoryModelo;

    @Inject
    CorRepository repositoryCor;

    @Override
    public List<Violao> findAll() {
        return repository.listAll();
    }

    @Override
    public List<Violao> findByModelo(String nomeModelo) {
        return repository.findByModelo(nomeModelo);
    }

    @Override
    public Violao findById(Long id) {
        Violao violao = repository.findById(id);
        if (violao == null) {
            throw new NotFoundException("Violão não encontrado com o ID: " + id);
        }
        return violao;
    }

    @Transactional
    @Override
    public Violao create(ViolaoDTO dto) {
        Violao violao = new Violao();
        violao.setPreco(dto.preco());

        Modelo modelo = repositoryModelo.findById(dto.idModelo());
        if (modelo == null) {
            throw new NotFoundException("Modelo não encontrado com o ID: " + dto.idModelo());
        }
        violao.setModelo(modelo);

        Cor cor = repositoryCor.find("LOWER(nome)", dto.cor().toLowerCase()).firstResult();
        if (cor == null) {
            throw new NotFoundException("Cor não encontrada: " + dto.cor());
        }
        violao.setCor(cor);

        repository.persist(violao);
        return violao;
    }

    @Transactional
    @Override
    public void update(Long id, ViolaoDTO dto) {
        Violao violao = repository.findById(id);
        if (violao == null) {
            throw new NotFoundException("Violão não encontrado com o ID: " + id);
        }

        violao.setPreco(dto.preco());

        Modelo modelo = repositoryModelo.findById(dto.idModelo());
        if (modelo == null) {
            throw new NotFoundException("Modelo não encontrado com o ID: " + dto.idModelo());
        }
        violao.setModelo(modelo);

        Cor cor = repositoryCor.find("LOWER(nome)", dto.cor().toLowerCase()).firstResult();
        if (cor == null) {
            throw new NotFoundException("Cor não encontrada: " + dto.cor());
        }
        violao.setCor(cor);

        repository.persist(violao);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Violao violao = repository.findById(id);
        if (violao == null) {
            throw new NotFoundException("Violão não encontrado com o ID: " + id);
        }
        repository.delete(violao);
    }
}
