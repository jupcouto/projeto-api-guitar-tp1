package br.unitins.topicos1.guitar.repository;

import java.util.List;

import br.unitins.topicos1.guitar.model.Categoria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;



@ApplicationScoped
public class CategoriaRepository implements PanacheRepository<Categoria> {

    public List<Categoria> findByClassificacao(String classificacao) {
        return find("SELECT c FROM Categoria c WHERE c.classificacao LIKE ?1 ", "%"+classificacao+"%").list();
    }
    
}