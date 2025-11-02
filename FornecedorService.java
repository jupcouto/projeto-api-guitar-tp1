package br.unitins.topicos1.guitar.service;
import java.util.List;

import br.unitins.topicos1.guitar.dto.FornecedorDTO;
import br.unitins.topicos1.guitar.model.Fornecedor;

public interface FornecedorService {

     List<Fornecedor> findAll();
    List<Fornecedor> findByNome(String nome);
    Fornecedor findById(Long id);
    Fornecedor create(FornecedorDTO dto);
    Fornecedor update(Long id, FornecedorDTO dto);
    void delete(Long id);



}