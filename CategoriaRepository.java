package br.unitins.topicos1.guitar.repository;

import java.util.List;

import br.unitins.topicos1.guitar.model.Categoria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;



@ApplicationScoped
public class CategoriaRepository implements PanacheRepository<Categoria> {

    public List<Categoria> findByNome(String nome) {
        return find("SELECT c FROM Categoria c WHERE c.nome LIKE ?1 ", "%"+nome+"%").list();
    }
    
}