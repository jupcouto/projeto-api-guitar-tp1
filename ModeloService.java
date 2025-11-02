package br.unitins.topicos1.guitar.service;
import java.util.List;

import br.unitins.topicos1.guitar.dto.ModeloDTO;
import br.unitins.topicos1.guitar.model.Modelo;

public interface ModeloService {

     List<Modelo> findAll();
    List<Modelo> findByNome(String nome);
    Modelo findById(Long id);
    Modelo create(ModeloDTO dto);
    Modelo update(Long id, ModeloDTO dto);
    void delete(Long id);



}