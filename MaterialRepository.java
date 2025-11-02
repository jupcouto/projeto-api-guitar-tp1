package br.unitins.topicos1.guitar.repository;
import java.util.List;
import br.unitins.topicos1.guitar.model.Material;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MaterialRepository implements PanacheRepository<Material> {

    public List<Material> findByDescricao(String descricao) {
        return find("SELECT m FROM Material m WHERE m.descricao LIKE ?1 ", "%"+descricao+"%").list();
    }
    
}
