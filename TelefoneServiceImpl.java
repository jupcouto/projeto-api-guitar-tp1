package br.unitins.topicos1.guitar.service;

import java.util.List;

import br.unitins.topicos1.guitar.dto.TelefoneDTO;
import br.unitins.topicos1.guitar.model.Telefone;
import br.unitins.topicos1.guitar.repository.TelefoneRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class TelefoneServiceImpl implements TelefoneService {

    @Inject
    TelefoneRepository repository;

    @Override
    public List<Telefone> findAll() {
        return repository.listAll();
    }

    @Override
    public List<Telefone> findByNumero(String numero) {
        return repository.findByNumero(numero);
    }

    @Override
    public Telefone findById(Long id) {
        Telefone telefone = repository.findById(id);
        if (telefone == null) {
            throw new NotFoundException("Telefone não encontrado com o ID: " + id);
        }
        return telefone;
    }

    @Transactional
    @Override
    public Telefone create(TelefoneDTO dto) {
        Telefone telefone = new Telefone();
        telefone.setCodigoArea(dto.codigoArea());
        telefone.setNumero(dto.numero());
        repository.persist(telefone);
        return telefone;
    }

    @Transactional
    @Override
    public Telefone update(Long id, TelefoneDTO dto) {
        Telefone telefone = repository.findById(id);
        if (telefone == null) {
            throw new NotFoundException("Telefone não encontrado com o ID: " + id);
        }

        telefone.setCodigoArea(dto.codigoArea());
        telefone.setNumero(dto.numero());
        repository.persist(telefone);
        return telefone;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Telefone telefone = repository.findById(id);
        if (telefone == null) {
            throw new NotFoundException("Telefone não encontrado com o ID: " + id);
        }
        repository.delete(telefone);
    }
}
