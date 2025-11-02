package br.unitins.topicos1.guitar.repository;

import java.util.List;

import br.unitins.topicos1.guitar.model.Telefone;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;



@ApplicationScoped
public class TelefoneRepository implements PanacheRepository<Telefone> {

    public List<Telefone> findByNumero(String numero) {
        return find("SELECT t FROM Telefone t WHERE t.numero LIKE ?1 ", "%"+numero+"%").list();
    }
    
}