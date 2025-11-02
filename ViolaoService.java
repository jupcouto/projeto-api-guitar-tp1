package br.unitins.topicos1.guitar.service;

import java.util.List;

import br.unitins.topicos1.guitar.dto.ViolaoDTO;
import br.unitins.topicos1.guitar.model.Violao;

public interface ViolaoService {
    List<Violao> findAll();
    List<Violao> findByModelo(String nomeModelo);
    Violao findById(Long id);
    Violao create(ViolaoDTO dto);
    void update(Long id, ViolaoDTO dto);
    void delete(Long id);
}
