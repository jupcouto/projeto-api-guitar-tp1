package br.unitins.topicos1.guitar.repository;
import java.util.List;
import br.unitins.topicos1.guitar.model.Violao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ViolaoRepository implements PanacheRepository<Violao> {

    public List<Violao> findByModelo(String nomeModelo) {
        return find("LOWER(modelo.nome) LIKE LOWER(?1)", "%" + nomeModelo + "%").list();
    }

}


