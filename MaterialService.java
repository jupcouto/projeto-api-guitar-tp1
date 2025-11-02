package br.unitins.topicos1.guitar.service;
import java.util.List;

import br.unitins.topicos1.guitar.dto.MaterialDTO;
import br.unitins.topicos1.guitar.model.Material;

public interface MaterialService {

     List<Material> findAll();
    List<Material> findByDescricao(String descricao);
    Material findById(Long id);
    Material create(MaterialDTO dto);
    Material update(Long id, MaterialDTO dto);
    void delete(Long id);



}