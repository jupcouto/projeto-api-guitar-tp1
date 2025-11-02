package br.unitins.topicos1.guitar.service;
import java.util.List;

import br.unitins.topicos1.guitar.dto.CorDTO;
import br.unitins.topicos1.guitar.model.Cor;

public interface CorService {

     List<Cor> findAll();
    List<Cor> findByNome(String nome);
    Cor findById(Long id);
    Cor create(CorDTO dto);
    Cor update(Long id, CorDTO dto);
    void delete(Long id);



}
