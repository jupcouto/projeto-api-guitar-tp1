package br.unitins.topicos1.guitar.service;
import java.util.List;

import br.unitins.topicos1.guitar.dto.MarcaDTO;
import br.unitins.topicos1.guitar.model.Marca;

public interface MarcaService {

     List<Marca> findAll();
    List<Marca> findByNome(String nome);
    Marca findById(Long id);
    Marca create(MarcaDTO dto);
    Marca update(Long id, MarcaDTO dto);
    void delete(Long id);



}
