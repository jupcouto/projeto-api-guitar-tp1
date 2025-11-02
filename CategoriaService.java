package br.unitins.topicos1.guitar.service;
import java.util.List;

import br.unitins.topicos1.guitar.dto.CategoriaDTO;
import br.unitins.topicos1.guitar.model.Categoria;

public interface CategoriaService {

     List<Categoria> findAll();
    List<Categoria> findByNome(String nome);
    Categoria findById(Long id);
    Categoria create(CategoriaDTO dto);
    Categoria update(Long id, CategoriaDTO dto);
    void delete(Long id);



}
