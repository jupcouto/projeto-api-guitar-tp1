package br.unitins.topicos1.guitar.service;

import java.util.List;

import br.unitins.topicos1.guitar.dto.FornecedorDTO;
import br.unitins.topicos1.guitar.model.Fornecedor;
import br.unitins.topicos1.guitar.repository.FornecedorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FornecedorServiceImpl implements FornecedorService {

    @Inject
    FornecedorRepository repository;

    @Override
    public List<Fornecedor> findAll() {
        return repository.listAll();
    }

    @Override
    public List<Fornecedor> findByNome(String nome) {
        return repository.find("SELECT f FROM Fornecedor f WHERE f.nome LIKE ?1", "%" + nome + "%").list();
    }

    @Override
    public Fornecedor findById(Long id) {
        Fornecedor fornecedor = repository.findById(id);
        if (fornecedor == null) {
            throw new NotFoundException("Fornecedor não encontrado com o ID: " + id);
        }
        return fornecedor;
    }

    @Transactional
    @Override
    public Fornecedor create(FornecedorDTO dto) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.nome());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setRazaoSocial(dto.razaoSocial());
        repository.persist(fornecedor);
        return fornecedor;
    }

    @Transactional
    @Override
    public Fornecedor update(Long id, FornecedorDTO dto) {
        Fornecedor fornecedor = repository.findById(id);
        if (fornecedor == null) {
            throw new NotFoundException("Fornecedor não encontrado com o ID: " + id);
        }

        fornecedor.setNome(dto.nome());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setRazaoSocial(dto.razaoSocial());
        repository.persist(fornecedor);
        return fornecedor;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Fornecedor fornecedor = repository.findById(id);
        if (fornecedor == null) {
            throw new NotFoundException("Fornecedor não encontrado com o ID: " + id);
        }
        repository.delete(fornecedor);
    }
}
