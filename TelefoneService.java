package br.unitins.topicos1.guitar.service;
import java.util.List;
import br.unitins.topicos1.guitar.model.Telefone;
import br.unitins.topicos1.guitar.dto.TelefoneDTO;

public interface TelefoneService {

     List<Telefone> findAll();
    List<Telefone> findByNumero(String numero);
    Telefone findById(Long id);
    Telefone create(TelefoneDTO dto);
    Telefone update(Long id, TelefoneDTO dto);
    void delete(Long id);



}
